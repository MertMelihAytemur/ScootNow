package tr.com.mermela.feature.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tr.com.mermela.R

@AndroidEntryPoint
class SplashFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSplash()
    }
    private fun initSplash() {
        lifecycleScope.launch {
            delay(DELAY_SPLASH)
            findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
        }
    }

    companion object {

        private const val DELAY_SPLASH = 2000L

        fun newInstance() = SplashFragment()

    }
}