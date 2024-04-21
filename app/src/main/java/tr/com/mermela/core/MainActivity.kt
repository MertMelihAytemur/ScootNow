package tr.com.mermela.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import tr.com.mermela.R
import tr.com.mermela.common.extension.findNavController
import tr.com.mermela.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initActivity()
    }

    private fun initActivity(){
        navController = findNavController()
        initOnBackPressedDispatcher()
    }

    private fun initOnBackPressedDispatcher() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navController.currentDestination?.id == R.id.splashFragment) { //will be replaced with home fragment
                    //exitApplicationDialog.show()
                } else {
                    navController.navigateUp()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }
}