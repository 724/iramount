package io.github.the724

import org.junit.Assert
import org.junit.Test

class FarsiFormatTomanTest {

    @Test
    fun one_digit_number() {
        // Arrange
        val amount = IrAmount(1)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("یک ریال", farsi)
    }

    @Test
    fun two_digit_number() {
        // Arrange
        val amount = IrAmount(34)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("سه تومان و چهار ریال", farsi)
    }

    @Test
    fun three_digit_number() {
        // Arrange
        val amount = IrAmount(508)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("پنجاه تومان و هشت ریال", farsi)
    }

    @Test
    fun three_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(410)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("چهل و یک تومان", farsi)
    }

    @Test
    fun four_digit_number() {
        // Arrange
        val amount = IrAmount(4065)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("چهارصد و شش تومان و پنج ریال", farsi)
    }

    @Test
    fun four_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(1000)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("صد تومان", farsi)
    }

    @Test
    fun five_digit_number() {
        // Arrange
        val amount = IrAmount(54032)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("پنج هزار و چهارصد و سه تومان و دو ریال", farsi)
    }

    @Test
    fun five_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(46200)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("چهار هزار و ششصد و بیست تومان", farsi)
    }

    @Test
    fun six_digit_number() {
        // Arrange
        val amount = IrAmount(123456)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("دوازده هزار و سیصد و چهل و پنج تومان و شش ریال", farsi)
    }

    @Test
    fun six_digit_number_ending_in_zero() {
        // Arrange
        val amount = IrAmount(100000)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("ده هزار تومان", farsi)
    }

    @Test
    fun seven_digit_number() {
        // Arrange
        val amount = IrAmount(1005000)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("صد هزار و پانصد تومان", farsi)
    }

    @Test
    fun eight_digit_number() {
        // Arrange
        val amount = IrAmount(10050100)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("یک میلیون و پنج هزار و ده تومان", farsi)
    }

    @Test
    fun nine_digit_number() {
        // Arrange
        val amount = IrAmount(410050100)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("چهل و یک میلیون و پنج هزار و ده تومان", farsi)
    }

    @Test
    fun ten_digit_number() {
        // Arrange
        val amount = IrAmount(4108050100)

        // Act
        val farsi = amount.farsiFormatToman()

        // Assert
        Assert.assertEquals("چهارصد و ده میلیون و هشتصد و پنج هزار و ده تومان", farsi)
    }
}