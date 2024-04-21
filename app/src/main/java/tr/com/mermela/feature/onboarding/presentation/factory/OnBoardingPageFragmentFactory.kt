package tr.com.mermela.feature.onboarding.presentation.factory

import tr.com.mermela.R
import tr.com.mermela.core.Factory
import tr.com.mermela.core.UiString
import tr.com.mermela.feature.onboarding.presentation.OnBoardingPageFragment
import tr.com.mermela.feature.onboarding.domain.uimodel.OnBoardingPageUiModel

class OnBoardingPageFragmentFactory private constructor(
    private val page: Int
): Factory<OnBoardingPageFragment> {

    override fun create(): OnBoardingPageFragment =
        OnBoardingPageFragment.newInstance(uiModels[page])

    companion object{

        private val uiModels = arrayOf(
            OnBoardingPageUiModel(
                drawableRes = R.drawable.ic_woman_drinks_water,
                title = UiString.PlainResource(R.string.onBoardingPage_first_title),
                description = UiString.PlainResource(R.string.onBoardingPage_first_description)
            ),
            OnBoardingPageUiModel(
                drawableRes = R.drawable.ic_man_drinks_water,
                title = UiString.PlainResource(R.string.onBoardingPage_second_title),
                description = UiString.PlainResource(R.string.onBoardingPage_second_description)
            ),
            OnBoardingPageUiModel(
                drawableRes = R.drawable.ic_water_bottle,
                title = UiString.PlainResource(R.string.onBoardingPage_third_title),
                description = UiString.PlainResource(R.string.onBoardingPage_third_description)
            ),
        )

        val size = uiModels.size

        fun create(page: Int): OnBoardingPageFragment {
            val factory = OnBoardingPageFragmentFactory(page)
            return factory.create()
        }
    }
}