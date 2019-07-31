package io.github.the724

open class IrAmount(private val number: Long) {

    companion object {
        private const val separator = ","
        private const val and = " و "
        private const val rialTag = " ریال"
        private const val tomanTag = " تومان"

        private val oneToTwenty = listOf(
                "",
                "یک",
                "دو",
                "سه",
                "چهار",
                "پنج",
                "شش",
                "هفت",
                "هشت",
                "نه",
                "ده",
                "یازده",
                "دوازده",
                "سیزده",
                "چهارده",
                "پانزده",
                "شانزده",
                "هفده",
                "هجده",
                "نوزده",
                "بیست"
        )
        private val tenMultiples = listOf(
                "",
                "",
                "بیست",
                "سی",
                "چهل",
                "پنجاه",
                "شصت",
                "هفتاد",
                "هشتاد",
                "نود"
        )
        private val hundredMultiples = listOf(
                "",
                "صد",
                "دویست",
                "سیصد",
                "چهارصد",
                "پانصد",
                "ششصد",
                "هفتصد",
                "هشتصد",
                "نهصد"
        )
        private val thousandMultiples = listOf(
                "",
                "هزار",
                "میلیون",
                "میلیارد",
                "بیلیون",
                "بیلیارد",
                "تریلیون"
        )
    }

    fun digitGrouped(): String {
        return digitGrouped(number.toString())
    }

    private fun digitGrouped(token: String): String {
        val divOfThree = token.length.div(3)
        val remOfThree = token.length.rem(3)

        return when (divOfThree) {
            0 -> token
            1 -> {
                val tail = token.substring(token.length - 3)

                if (remOfThree != 0)
                    token.substring(0, remOfThree) + separator + tail
                else
                    tail
            }
            else -> {
                val head = token.substring(0, token.length - 3)
                val tail = token.substring(token.length - 3)
                var result = tail

                if (head.length > 2) {
                    result = separator + result
                }

                digitGrouped(head) + result
            }
        }
    }

    fun farsiFormatRial(): String {
        val groups = digitGrouped().split(",")
        return groups.map { it.toInt() }.mapIndexed { index, number ->
            var farsiRep = ""

            if (number != 0 && index != 0)
                farsiRep += and

            farsiRep += formatFragment(number)

            if (number != 0)
                farsiRep += " ${thousandMultiples[groups.size - 1 - index]}"

            return@mapIndexed farsiRep
        }.joinToString("").trim().plus(rialTag)
    }

    fun farsiFormatToman(): String {
        val amountInToman: Long = number.div(10)
        val remOfToman: Int = number.rem(10).toInt()
        val groups = digitGrouped(amountInToman.toString()).split(",")
        val spokenFormat = groups.map { it.toInt() }.mapIndexed { index, number ->
            var farsiRep = ""

            if (number != 0 && index != 0)
                farsiRep += and

            farsiRep += formatFragment(number)

            if (number != 0)
                farsiRep += " ${thousandMultiples[groups.size - 1 - index]}"

            return@mapIndexed farsiRep
        }.joinToString("").trim()

        return if (remOfToman != 0) {
            if (amountInToman == 0L) {
                spokenFormat.plus(oneToTwenty[remOfToman]).plus(rialTag)
            } else {
                spokenFormat.plus(tomanTag)
                        .plus(and)
                        .plus(oneToTwenty[remOfToman])
                        .plus(rialTag)
            }
        } else
            spokenFormat.plus(tomanTag)
    }

    private fun formatFragment(input: Int): String {
        return when (input) {
            in 100..999 -> threeDigit(input)
            in 10..99 -> twoDigit(input)
            in 0..9 -> oneDigit(input)
            else -> ""
        }
    }

    private fun threeDigit(input: Int): String {
        var result = ""
        val divOfHundred = input.div(100)
        val remOfHundred = input.rem(100)
        result += hundredMultiples[divOfHundred]

        if (remOfHundred != 0)
            result += and

        result += twoDigit(remOfHundred)

        return result
    }

    private fun twoDigit(input: Int): String {
        return if (input <= 20) {
            oneToTwenty[input]
        } else {
            val divOfTen = input.div(10)
            val remOfTen = input.rem(10)

            if (remOfTen != 0) {
                tenMultiples[divOfTen] + and + oneDigit(remOfTen)
            } else {
                tenMultiples[divOfTen]
            }
        }
    }

    private fun oneDigit(input: Int): String {
        return oneToTwenty[input]
    }
}