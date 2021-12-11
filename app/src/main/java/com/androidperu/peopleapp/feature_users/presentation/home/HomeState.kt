package com.androidperu.peopleapp.feature_users.presentation.home

import com.androidperu.peopleapp.feature_users.domain.model.User

data class HomeState(
    val users: List<User> = emptyList()
)
