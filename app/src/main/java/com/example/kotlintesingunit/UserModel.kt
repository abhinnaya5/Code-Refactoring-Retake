package com.example.kotlintesingunit

class UserModel(val username: String, val password: String) {
    companion object {
        val userList:MutableList<UserModel> = mutableListOf(
            UserModel("admin","admin"),
            UserModel("aaaa","aaaa"),
            UserModel("bbbb","bbbb")
        )

        fun login(username:String, password:String) : UserModel? {
            return userList.find { it.username.equals(username) && it.password.equals(password) }
        }

        fun register(username:String, password:String) : Boolean {
            if (userList.find {it.username.equals(username)} != null) {
                return false
            }
            userList.add(UserModel(username,password))
            return true
        }
    }
}

