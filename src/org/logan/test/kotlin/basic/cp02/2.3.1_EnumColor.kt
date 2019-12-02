package org.logan.test.kotlin.basic.cp02


/**
 * desc: Kotlin枚举 <br/>
 * time: 2019-08-22 17:26 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// Kotlin用了enum class声明一个枚举，而Java只使用enum一个关键字
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// 给枚举声明属性和方法
enum class Color2(
    // 属性
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // Kotlin唯一使用分号的地方

    // 方法
    fun rgb() = (r * 256 + g) * 256 + b

}