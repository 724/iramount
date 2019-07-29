package io.github.the724

import org.junit.Assert
import org.junit.Test

class DigitGroupingTest {

    @Test
    fun one_digit_number() {
        // Arrange
        val amount = Amount(1)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("1", digitsGrouped)
    }

    @Test
    fun two_digit_number() {
        // Arrange
        val amount = Amount(34)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("34", digitsGrouped)
    }

    @Test
    fun three_digit_number() {
        // Arrange
        val amount = Amount(508)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("508", digitsGrouped)
    }

    @Test
    fun three_digit_number_ending_in_zero() {
        // Arrange
        val amount = Amount(410)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals(digitsGrouped, "410")
    }

    @Test
    fun four_digit_number() {
        // Arrange
        val amount = Amount(4065)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("4,065", digitsGrouped)
    }

    @Test
    fun four_digit_number_ending_in_zero() {
        // Arrange
        val amount = Amount(1000)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("1,000", digitsGrouped)
    }

    @Test
    fun five_digit_number() {
        // Arrange
        val amount = Amount(54032)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("54,032", digitsGrouped)
    }

    @Test
    fun five_digit_number_ending_in_zero() {
        // Arrange
        val amount = Amount(46200)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("46,200", digitsGrouped)
    }

    @Test
    fun six_digit_number() {
        // Arrange
        val amount = Amount(123456)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("123,456", digitsGrouped)
    }

    @Test
    fun six_digit_number_ending_in_zero() {
        // Arrange
        val amount = Amount(100000)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("100,000", digitsGrouped)
    }

    @Test
    fun seven_digit_number() {
        // Arrange
        val amount = Amount(1005000)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("1,005,000", digitsGrouped)
    }

    @Test
    fun eight_digit_number() {
        // Arrange
        val amount = Amount(10050100)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("10,050,100", digitsGrouped)
    }

    @Test
    fun nine_digit_number() {
        // Arrange
        val amount = Amount(410050100)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("410,050,100", digitsGrouped)
    }

    @Test
    fun ten_digit_number() {
        // Arrange
        val amount = Amount(4108050100)

        // Act
        val digitsGrouped = amount.digitGrouped()

        // Assert
        Assert.assertEquals("4,108,050,100", digitsGrouped)
    }
}