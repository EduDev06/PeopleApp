package com.androidperu.peopleapp.feature_users.domain.repository

import com.androidperu.peopleapp.feature_users.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

    suspend fun getUserById(id: Int): User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}