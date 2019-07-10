package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.*
import java.util.*

fun User.toUserView(): UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "offline" else if(isOnline) "online" else "Last seen ${lastVisit?.humanizeDiff()}"

    return UserView(
        id = id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        initials = initials,
        nickName = nickName,
        status = status    )
}






