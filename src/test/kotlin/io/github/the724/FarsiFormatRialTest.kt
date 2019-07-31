package io.github.the724

import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException

class FarsiFormatRialTest {

    @Test
    fun one_digit_number() {
        // Arrange
        val amount = IrAmount(1)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("یک ریال", farsi)
    }

    @Test
    fun two_digit_number() {
        // Arrange
        val amount = IrAmount(34)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("سی و چهار ریال", farsi)
    }

    @Test
    fun three_digit_number() {
        // Arrange
        val amount = IrAmount(508)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("پانصد و هشت ریال", farsi)
    }

    @Test
    fun three_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(410)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("چهارصد و ده ریال", farsi)
    }

    @Test
    fun four_digit_number() {
        // Arrange
        val amount = IrAmount(4065)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("چهار هزار و شصت و پنج ریال", farsi)
    }

    @Test
    fun four_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(1000)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("یک هزار ریال", farsi)
    }

    @Test
    fun five_digit_number() {
        // Arrange
        val amount = IrAmount(54032)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("پنجاه و چهار هزار و سی و دو ریال", farsi)
    }

    @Test
    fun five_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(46200)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("چهل و شش هزار و دویست ریال", farsi)
    }

    @Test
    fun six_digit_number() {
        // Arrange
        val amount = IrAmount(123456)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("صد و بیست و سه هزار و چهارصد و پنجاه و شش ریال", farsi)
    }

    @Test
    fun six_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(100000)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("صد هزار ریال", farsi)
    }

    @Test
    fun seven_digit_number() {
        // Arrange
        val amount = IrAmount(1005000)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("یک میلیون و پنج هزار ریال", farsi)
    }

    @Test
    fun eight_digit_number() {
        // Arrange
        val amount = IrAmount(10050100)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("ده میلیون و پنجاه هزار و صد ریال", farsi)
    }

    @Test
    fun nine_digit_number() {
        // Arrange
        val amount = IrAmount(410050100)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("چهارصد و ده میلیون و پنجاه هزار و صد ریال", farsi)
    }

    @Test
    fun ten_digit_number() {
        // Arrange
        val amount = IrAmount(4108050100)

        // Act
        val farsi = amount.farsiFormatRial()

        // Assert
        Assert.assertEquals("چهار میلیارد و صد و هشت میلیون و پنجاه هزار و صد ریال", farsi)
    }
}