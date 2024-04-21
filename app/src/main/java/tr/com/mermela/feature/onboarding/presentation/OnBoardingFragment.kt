package tr.com.mermela.feature.onboarding.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.core.view.children
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import tr.com.mermela.R
import tr.com.mermela.common.extension.getDrawableCompat
import tr.com.mermela.common.extension.setMargin
import tr.com.mermela.databinding.FragmentOnBoardingBinding
import tr.com.mermela.feature.onboarding.presentation.adapter.OnBoardingAdapter
import tr.com.mermela.feature.onboarding.presentation.factory.OnBoardingPageFragmentFactory


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    private val viewModel: OnBoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentOnBoardingBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initAdapter()
        initOnBackPressedHandler()
        initIndicator()
    }

    private fun initIndicator(){
        val size = OnBoardingPageFragmentFactory.size
        repeat(size){ position ->
            val radioButton = RadioButton(context)
            radioButton.id = generateOrGetId(position)
            radioButton.setMargin(resources.getDimensionPixelSize(R.dimen.fontSize_small))
            radioButton.isClickable = false
            radioButton.isFocusable = false
            radioButton.buttonDrawable = requireContext().getDrawableCompat(R.drawable.selector_indicator)
            binding.radioGroupIndicator.addView(radioButton)
        }
    }

    private fun initOnBackPressedHandler() {
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        })
    }

    private fun onBackPressedBehaviour(){
        if (binding.viewPagerInformations.currentItem != 0) {
            binding.viewPagerInformations.currentItem -= 1
        } else{
            findNavController().navigateUp()
        }
    }

    private fun initAdapter(){
        binding.viewPagerInformations.apply {
            adapter = OnBoardingAdapter(this@OnBoardingFragment)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.buttonNextOrGetStarted.text = if (position != LAST_INDEX){
                        getString(R.string.onBoarding_next)
                    } else
                        getString(R.string.onBoarding_getStarted)

                    binding.toolbar.isInvisible = position == PAGE_FIRST
                    binding.radioGroupIndicator.children.forEachIndexed { index, view ->
                        (view as RadioButton).isChecked = index == position
                    }
                }
            })
        }
    }

    private fun initListeners(){
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedBehaviour()
        }
        binding.buttonNextOrGetStarted.setOnClickListener {
            if (binding.viewPagerInformations.currentItem != OnBoardingPageFragmentFactory.size - 1)
                binding.viewPagerInformations.currentItem = binding.viewPagerInformations.currentItem + 1
            else {
                //viewModel.setOnBoardingHasSeen()
                //findNavigationHandler().navigateToFragment(HomeFragment.newInstance())
            }
        }
    }

    private fun generateOrGetId(index: Int): Int = 1000 + index


    companion object {
        private const val PAGE_FIRST = 0
        private val LAST_INDEX = OnBoardingPageFragmentFactory.size - 1
    }
}