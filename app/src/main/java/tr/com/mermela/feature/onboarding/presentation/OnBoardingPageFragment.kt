package tr.com.mermela.feature.onboarding.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import tr.com.mermela.common.extension.getDrawableCompat
import tr.com.mermela.common.extension.getSerializable
import tr.com.mermela.core.getText
import tr.com.mermela.databinding.FragmentOnBoardingPageBinding
import tr.com.mermela.feature.onboarding.domain.uimodel.OnBoardingPageUiModel


@AndroidEntryPoint
class OnBoardingPageFragment private constructor() : Fragment() {

    private var uiModel: OnBoardingPageUiModel? = null

    private lateinit var binding: FragmentOnBoardingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiModel = arguments?.getSerializable(key = ARGS_UI_MODEL)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentOnBoardingPageBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyUiModel()
    }

    private fun applyUiModel() {
        uiModel?.apply {
            binding.imageViewLogo.setImageDrawable(requireContext().getDrawableCompat(drawableRes))
            binding.textViewTitle.text = title.getText(requireContext())
            binding.textViewDescription.text = description.getText(requireContext())
        }
    }

    companion object{

        private const val ARGS_UI_MODEL = "ARGS_UI_MODEL"

        fun newInstance(
            uiModel: OnBoardingPageUiModel
        ): OnBoardingPageFragment {
            val args = Bundle()
            args.apply {
                putSerializable(ARGS_UI_MODEL, uiModel)
            }
            val fragment = OnBoardingPageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}