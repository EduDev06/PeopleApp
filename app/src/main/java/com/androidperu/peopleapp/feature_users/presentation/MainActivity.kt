package com.androidperu.peopleapp.feature_users.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.androidperu.peopleapp.ui.theme.PeopleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeopleAppTheme {
                Navigation()
            }
        }
    }
}
