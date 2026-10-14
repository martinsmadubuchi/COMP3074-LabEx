package ca.gbc.comp3074.madubuchi_ihechu.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.gbc.comp3074.madubuchi_ihechu.lab4.data.AppDatabase
import ca.gbc.comp3074.madubuchi_ihechu.lab4.ui.CustomerApp
import ca.gbc.comp3074.madubuchi_ihechu.lab4.ui.CustomerViewModel
import ca.gbc.comp3074.madubuchi_ihechu.lab4.ui.CustomerViewModelFactory
import ca.gbc.comp3074.madubuchi_ihechu.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)

        setContent {
            Lab4Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: CustomerViewModel = viewModel(
                        factory = CustomerViewModelFactory(database.customerDao())
                    )
                    CustomerApp(viewModel)
                }
            }
        }
    }
}

