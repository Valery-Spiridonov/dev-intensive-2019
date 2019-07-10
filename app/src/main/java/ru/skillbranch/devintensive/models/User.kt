package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
){
    var introBit: String

    constructor(id: String, firstname: String?, lastName: String?) : this(id, firstname, lastName, avatar = null)

    constructor(id: String) : this(id, "John", "Doe $id")

    init{
        introBit = getIntro()

        println("Its; Alive! \n${
            if(firstName.isNullOrEmpty() and lastName.isNullOrEmpty()) "He do not have name" else
            if(firstName.isNullOrEmpty()) "He do not have first name" else
            if(lastName.isNullOrEmpty()) "He do not have first name" else
            if(lastName === "Doe") "His name is $firstName $lastName" else
            "And his name is $firstName $lastName!" }"
        //+ "${getIntro()}"
        )
    }

    private fun getIntro() = """tu tu! ${"\n"} $firstName $lastName"""

    fun printMe() = println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User{
            lastId++

            var emptyName: String? = null
            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User("$lastId", "${if(firstName.isNullOrEmpty()) "$emptyName" else "$firstName"}", "${if(lastName.isNullOrEmpty()) "$emptyName" else "$lastName"}")
        }
    }
}