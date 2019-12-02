package org.logan.test.kotlin.basic.cp02

/**
 * desc: when使用枚举 <br/>
 * time: 2019-08-22 17:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun getColorName(color: Color) =
    when (color) { // when 可以是一个有返回值的表达式
        Color.RED -> "Red"
        Color.ORANGE -> "Orange"
        Color.YELLOW -> "Yellow"
        Color.GREEN -> "Green"
        Color.BLUE -> "Blue"
        Color.INDIGO -> "Indigo"
        Color.VIOLET -> "Violet"
    }


fun getWarmth(color: Color) {
    when (color) {
        Color.GREEN -> "neutral" // 和Java不一样，你不需要在每个分支上写上break语句。
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm" //多个条件，使用,合并
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }
}