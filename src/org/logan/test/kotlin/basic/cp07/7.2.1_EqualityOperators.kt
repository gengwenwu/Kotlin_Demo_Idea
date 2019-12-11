package org.logan.test.kotlin.basic.cp07.ext2

/**
 * desc: 重载比较运算符 - Kotlin可以对任何对象使用比较运算符(==、!=、 >、 <等) <br/>
 *
 * 和所有其它运算符不同的是，== 和 != 可以用于可空运算数，因为这它会检查运算数是否为null。
 * 比较 a == b 会检查a是否为非空，如果不是，就调用 a.equals(b); 否则，只有两个参数都是空引用，结果才是true。
 * 如：a==b -> a?.equals(b) ?: (b==null)
 *
 * Kotlin恒等运算符(===) 与 Java中的==运算符是完全相同的：
 *   检查两个参数是否是同一个对象的引用(如果是基本数据类型，检查它们是否是相同的值)。
 *   在实现了 equals() 之后，通常会使用这个运算符来优化调用代码。注意，===运算符不能被重载。
 *
 *
 * time: 2019/12/11 3:33 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Point(val x: Int, val y: Int) {

    /**
     * equals 函数之所以被标记为 override，那是因为与其他约定不同的是，
     * 它的实现是在 Any 类中定义的 (Kotlin 中的所有对象都支持等式比较)。
     *
     * 这也解释了为什么你不需要将它标记为 operator，因为Any中己经标记了，
     * 而且函数的 operator 修饰符也适用于所有实现或重写它的方法(向下自动继承该特性)。
     *
     **/
    override fun equals(obj: Any?): Boolean { // 手动实现equals()
        if (obj === this) return true // 检查对象引用是否相等
        if (obj !is Point) return false //检查数据类型是否相等

        return obj.x == x && obj.y == y //检查类中的值是否相等
    }

}

fun main() {
    println(Point(10, 20) == Point(10, 20))

    // 这个例子显示使用!=运算符也会转换为 equals 方法的调用。编译器会自动对返回值取反。
    println(Point(10, 20) != Point(5, 5))

    println(null == Point(1, 2))
}