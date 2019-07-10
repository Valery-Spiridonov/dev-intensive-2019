package ru.skillbranch.devintensive.models

class UserView (
    val id: String,
    val fullName: String,
    val nickName: String,
    val avatar: String? =null,
    var status: String? = "offline",
    val initials: String?
) {

    fun printMe() {
        println("""
            id: $id
            fullName: $fullName
            avatar: $avatar
            status: $status
            initials: $initials
        """.trimIndent())
    }

}