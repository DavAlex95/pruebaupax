package com.upax.upokemon


import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upax.upokemon.base.UPBaseActivity
import com.upax.upokemon.databinding.ActivityUprootBinding

class UPRootActivity : UPBaseActivity<ActivityUprootBinding>(ActivityUprootBinding::inflate) {

    override fun setUpView() {
        super.setUpView()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_pokemon, R.id.navigation_fav_pokemons)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}