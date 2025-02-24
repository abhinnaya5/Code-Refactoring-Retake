package com.example.kotlintesingunit

import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.Assertions

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testLoginValidCredentials() {
        val user = UserModel.login("admin", "admin")
        Assertions.assertNotNull(user)
        Assertions.assertEquals("admin", user?.username)
        Assertions.assertEquals("admin", user?.password)
    }

    @Test
    fun testLoginInvalidCredentials() {
        val user = UserModel.login("nonexistent", "password")
        Assertions.assertNull(user)
    }

    @Test
    fun testRegisterNewUser() {
        val result = UserModel.register("newuser", "password")
        Assertions.assertTrue(result)
        Assertions.assertNotNull(UserModel.userList.find { it.username == "newuser" })
    }

    @Test
    fun testRegisterExistingUser() {
        val result = UserModel.register("admin", "password")
        Assertions.assertFalse(result)
    }

}