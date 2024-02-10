package com.quare.blitzsplit.user.data.datasource.local

import androidx.datastore.core.Serializer
import com.quare.blitzsplit.user.data.dto.UserDto
import java.io.InputStream
import java.io.OutputStream
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

object UserDataSerializer: Serializer<UserDto> {

    override val defaultValue: UserDto
        get() = UserDto(
            id = null,
            profilePictureUrl = null
        )

    override suspend fun readFrom(input: InputStream): UserDto = try {
        Json.decodeFromString(
            deserializer = UserDto.serializer(),
            string = input.readBytes().decodeToString()
        )
    } catch (exception: SerializationException) {
        exception.printStackTrace()
        defaultValue
    }

    override suspend fun writeTo(t: UserDto, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserDto.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}
