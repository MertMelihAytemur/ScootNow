package tr.com.mermela.feature.onboarding.domain.uimodel

import androidx.annotation.DrawableRes
import tr.com.mermela.core.UiString
import java.io.Serializable

data class OnBoardingPageUiModel(
    @DrawableRes val drawableRes: Int,
    val title: UiString,
    val description: UiString
) : Serializable
