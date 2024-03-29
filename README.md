[ ![Download](https://api.bintray.com/packages/farhad/maven/iramount/images/download.svg) ](https://bintray.com/farhad/maven/iramount/_latestVersion) [![HitCount](http://hits.dwyl.io/the724/iramount.svg)](http://hits.dwyl.io/the724/iramount)

```groovy
repositories {
	jcenter()
}
	
implementation 'io.github.the724:iramount:[latest-version]'
```
---

This library enables you to create formal Farsi spoken format for numbers that represent an amount in Rials (IRR).

To group digits by three, use

```kotlin
val amount = IrAmount(5511255) // we assume the number is in Rials!
val withDigitGrouping = amount.digitGrouped() // returns 5,511,255
```

To display Farsi spoken format in Rials (IRR), use
```kotlin
val amount = IrAmount(5511255) // we assume the number is in Rials!
val rialFormat = amount.farsiFormatRial() // returns پنج میلیون و پانصد و یازده هزار و دویست و پتجاه و پنج ریال
```

To display Farsi spoken format in Tomans, use
```kotlin
val amount = IrAmount(5511255) // we assume the number is in Rials!
val tomanFormat = amount.farsiFormatToman() // returns پانصد و پنجاه و یک هزار و صد و بیست و پنج تومان و پنج ریال
```

### License

    Copyright (C) 2019  Farhad Faghihi

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
