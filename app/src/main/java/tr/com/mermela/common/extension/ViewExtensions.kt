package tr.com.mermela.common.extension

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

fun View.setMargin(left: Int = marginLeft, top: Int = marginTop, right: Int = marginRight, bottom: Int = marginBottom) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(left, top, right, bottom)
        this.requestLayout()
    }
}

fun View.setMargin(margin: Int){
    setMargin(margin, margin, margin, margin)
}