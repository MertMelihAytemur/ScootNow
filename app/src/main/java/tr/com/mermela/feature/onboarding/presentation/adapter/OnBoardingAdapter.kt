package tr.com.mermela.feature.onboarding.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import tr.com.mermela.feature.onboarding.presentation.factory.OnBoardingPageFragmentFactory

class OnBoardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = OnBoardingPageFragmentFactory.size

    override fun createFragment(position: Int): Fragment {
        return OnBoardingPageFragmentFactory.create(position)
    }
}