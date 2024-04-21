package tr.com.mermela.common.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import tr.com.mermela.R

fun AppCompatActivity.findNavController(@IdRes id: Int = R.id.nav_host_fragment_container): NavController {
    val navHostFragment = supportFragmentManager.findFragmentById(id) as NavHostFragment
    return navHostFragment.navController
}