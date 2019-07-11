package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = if(fullName.isNullOrBlank()) null else fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName= parts?.getOrNull(1)

        //return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val firstInitial = "${if(firstName.isNullOrBlank()) "" else firstName?.capitalize().first()}"
        val lastInitial = "${if(lastName.isNullOrBlank()) "" else lastName?.capitalize().first()}"

        return if("$firstInitial$lastInitial".isNullOrBlank()) null else "$firstInitial$lastInitial"
    }


    fun transliteration(payload: String, divider: String = " "): String {
        val ru = listOf('а','б','в','г','д','е','ё','ж','Ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','Ч','ш','Ш','щ','Щ','ъ','ы','ь','э','ю','Ю','я','Я')
        val en = listOf("a","b","v","g","d","e","e","zh","Zh","z","i","i","k","l","m","n","o","p","r","s","t","u","f","h","c","ch","Ch","sh","Sh","sh'","Sh'","","i","","e","yu","Yu","ya","Ya")
/*        "а": "a","б": "b","в": "v","г": "g","д": "d","е": "e","ё": "e","ж": "zh","з": "z","и": "i","й": "i","к": "k","л": "l","м": "m","н": "n","о": "o","п": "p","р": "r","с": "s","т": "t","у": "u","ф": "f","х": "h","ц": "c","ч": "ch","ш": "sh","щ": "sh'","ъ": "","ы": "i","ь": "","э": "e","ю": "yu","я": "ya",*/

        var new_payload: String = ""
        for(letter in payload) {

            /*if(letter.toLowerCase() in ru) println("$letter ${ru.indexOf(letter.toLowerCase())}")*/
            new_payload += when {
                letter in ru -> en[ru.indexOf(letter)]
                letter.toLowerCase() in ru -> en[ru.indexOf(letter.toLowerCase())].toUpperCase()
                letter in " " -> divider
                else -> letter
            }
        }

        return new_payload
    }
}