package org.logan.test.kotlin.basic.cp04


import java.io.File

/**
 * desc: Kotlin object关键字用法1 - 对象声明。 <br/>
 * 通过object关键字，对象声明将类声明与该类的单例声明结合到了一起，非常适合创建单例对象。 <br/>
 * 与类一样，一个对象声明可以包含属性、方法、初始化语句块等声明，唯一不允许的就是构造方法(包括主、从构造方法)。<br />
 * 因为对象声明在定义的时候就立即创建类，不需要在代码的其它地方调用构造方法。因此，为对象声明定义一个构造方法是没有意义的。<br/>
 *
 * time: 2019-09-03 11:08 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

object Payroll { // 使用object关键字，声明 对象声明

    val allEmployees = arrayListOf<Person>()

    init {
        println("Payroll init.")
    }

    fun calculateSalary() {
        for (person in allEmployees) {
            //...
        }
    }
}


// 对象声明同样可以继承自类和接口。通常在使用的框架需要去实现一个接口，但实现并不包含任何状态的时候很有用。
object CaseInsensitiveFileComparator : Comparator<File> { // 对象声明
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

// 在类中声明对象，这样的对象同样只有一个单一实例。实质是一个嵌套类
data class Person(val name: String) {

    // 对象声明，比较器
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return p1.name.compareTo(p2.name)
        }
    }

}


fun main(args: Array<String>) {

    // 对象声明允许使用"对象名加.字符"的方式来调用方法和访问属性
    Payroll.allEmployees
    Payroll.calculateSalary();


    // 对象声明 继承类或接口
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    // 可以在任何可以使用普通对象的地方使用单例对象
    val files = listOf(File("/Z"), File("/a"));
    println(files.sortedWith(CaseInsensitiveFileComparator))


    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator)) // 使用类中的对象声明

    // Kotlin中的对象声明被编译成通过静态字段来持有它的单一实例的类，这个字段名字始终是 INSTANCE。
    // 要从Java代码中使用Kotlin对象，可以通过访问静态的 INSTANCE 字段(Java代码)：
    // CaseInsensitiveFileComparator.INSTANCE.compare(file1, file2);
}



