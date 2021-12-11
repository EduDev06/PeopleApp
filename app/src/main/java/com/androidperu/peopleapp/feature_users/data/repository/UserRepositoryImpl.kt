package com.androidperu.peopleapp.feature_users.data.repository

import com.androidperu.peopleapp.feature_users.data.source.local.dao.UserDao
import com.androidperu.peopleapp.feature_users.domain.model.User
import com.androidperu.peopleapp.feature_users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
): UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }

    override suspend fun getUserById(id: Int): User? {
       return dao.getUserById(id)
    }

    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }
}