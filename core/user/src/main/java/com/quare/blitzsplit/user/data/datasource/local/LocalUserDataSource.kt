package com.quare.blitzsplit.user.data.datasource.local

import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import com.quare.blitzsplit.user.data.dto.UserDto
import com.quare.blitzsplit.user.domain.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

@Singleton
class LocalUserDataSource @Inject constructor(
    private val dataStore: DataStore<UserDto>,
    private val serializer: Serializer<UserDto>
) {

    private var cache: UserModel? = null

    suspend fun getUser(): UserModel? = cache ?: try {
        dataStore.data.map { userDto ->
            UserModel(
                id = userDto.id,
                profilePictureUrl = userDto.profilePictureUrl
            ).also { cache = it }
        }.first()
    } catch (exception: NoSuchElementException) {
        null
    }

    suspend fun saveUser(userModel: UserModel) {
        cache = userModel
        saveInInternalMemory(userModel)
    }

    private suspend fun saveInInternalMemory(userModel: UserModel) {
        dataStore.updateData { userDto ->
            userDto.copy(
                id = userModel.id,
                profilePictureUrl = userModel.profilePictureUrl
            )
        }
    }

    suspend fun clear() {
        cache = null
        dataStore.updateData {
            serializer.defaultValue
        }
    }
}
