# 一切皆对象

Java是一门纯面向对象程序设计语言

## 数据类型

### 数据存储 

- 寄存器（Registers）

  最快的存储区，位于处理器（CPU）内部。数量有限，由编译器根据需求进行分配，Java程序员不能直接控制，也不能在程序中感觉到寄存器存在（C和C++允许向编译器建议寄存器分配方式）。

  程序计数寄存器，它记载着线程当前运行的JAVA方法的地址，如果是当前执行的是本地方法，则程序计数器会是一个空地址。它的作用就是用来支持多线程，线程的阻塞、恢复、挂起等一系列操作，直观的想象一下，要是没有记住每个线程当前运行的位置，又如何恢复呢。依据这一点，每一个线程都有一个PC寄存器，也就是说PC寄存器是线程独有的。

- 堆栈（Stack）

  位于通用RAM（随机访问存储器）中，通过堆栈指针可以从处理器获得直接支持。若堆栈指针向下移动，则分配新的内存；若向上移动，则释放内存。一种快速有效的分配存储方法，速度仅此寄存器。创建程序时，Java系统必须知道存储在堆栈内所有项的确切生命周期，以便上下移动堆栈指针。这约束了程序的灵活性，所以某些Java数据存储在堆栈中——特别是对象引用，Java对象存储在堆中，并不存储在堆栈中。

- 堆（Heap）

  通用的内存池（也位于RAM区），用于存放所有的Java对象。堆相对与堆栈的好吃是：编译器不需要知道存储的数据在堆里的存活时长。因此，在堆里分配存储有很大的灵活性。当需要一个对象时，只需要通过`new`关键字写一行简单的代码，当执行这行代码时，会自动在堆里进行存储分配。这种灵活性也有代价，用堆进行存储分配和清理可能比用堆栈存储分配需要更多时间。

- 常量（Constant storage）

  常量值通常直接放在程序代码内部，这样是安全的，因为它们永远不会被改变。

- 非RAM存储（Non-RAM storage）

  数据完成存活在程序之外，不受程序如何控制，在程序没有运行也可以存在。两个基本例子是流对象和持久化对象。在流对象中，对象转换成字节流，通常被发生到另外一台机器（比如通过网络），对象被存放于硬盘上（比如文件、数据库），即使程序终止，它们仍然可以保持自己的状态。这种存储方式技巧在于：把对象转换成可以存放在其他媒介上的事物，在需要时，可恢复成常规的、基于RAM的对象。Java提供了对轻量级持久化支持，诸如JDBC和Hibernate这样的机制提供了更加复杂的对数据库中存储和读取对象的支持。

### 基本类型

程序设计中经常使用到一些类型，我们把它们称之为基本类型。基本类型直接存储“值”并置于堆栈中，因此更加高效。

Java通常讲一共有8种基本类型，`void`是一种特殊的基本类型。每种基本类型所占存储空间的大小是确定的。不会像其他编程语言那样随机器硬件的变化而改变。正是这一特性Java比其他大多数编程语言编写的程序更具可移植的原因之一。

| 基本类型 |  大小  |  最小值   |      最大值      | 包装器类型 |
| :------: | :----: | :-------: | :--------------: | :--------: |
| boolean  |   -    |     -     |        -         |  Boolean   |
|   char   | 16 bit | Unicode 0 | Unicode 2[^16]-1 | Character  |
|   byte   | 8 bit  |   -128    |       127        |    Byte    |
|  short   | 16 bit |  -2[^15]  |    +2[^15]-1     |   Short    |
|   int    | 32 bit |  -2[^31]  |    +2[^31]-1     |  Integer   |
|   long   | 64 bit |  -2[^63]  |    +2[^63]-1     |    Long    |
|  float   | 32 bit |  IEEE754  |     IEEE754      |   Float    |
|  double  | 4 bit  |  IEEE754  |     IEEE754      |   Double   |
|   void   |   -    |     -     |        -         |    Void    |

所有数值类型都有正负号。

`boolean`类型所占存储空间大小没有明确指定，仅定义能够取字面值`true`或`false`。

所有基本类型都有对应的包装器类，可以在堆中创建一个非基本类型，用来表示对应的基本类型。例如：

``` java
char c = "x";
Character ch = new Character(c);
// Java SE5的自动包装功能将自动将基本类型转换为包装器类型
Character ch = c;
// 并且可以反向转换
c = ch;
```

#### 高精度数字

如果用于精准计算不建议使用`float`和`double`（参考《effective java》第48条）。建议使用Java提供了的两个用于高精度计算的类：`BigInteger`和`BigDecimal`。虽然它们大体属于“包装器类”范畴，但是二者没有对应的基本类型。

不过，这两个类包含的方法，提供的操作与基本类型所能执行的操作相似。也就是说能作用`int`或`float`的操作，也同样能作用于`BigInteger`和`BigDecimal`。 只不过必须通过方法调用方式取代运算符来实现。由于这么做复杂了许多，所以运算速度会比较慢。我们以速度换精度。

#### 数组

Java数组相对C或C++是安全的。使用数组之前必须初始化，而且不能在它的范围之外被访问。通过运行时下标检查，是有内存开销的，但也保证了安全性。

创建一个数组对象时，实际上就是创建一个引用数组，并每个引用都会自动被初始化一个特定值`null`。使用如何引用前，必须指定一个对象；如果试图使用一个还是`null`的引用，运行时将会报错。

### 永远不需要销毁对象

#### 作用域

大多数过程编程语言都有作用域（sope）的概念。作用域决定了在其内定义的变量的可见性和生命周期。

``` java
{
    int x = 12; // 只有x有效
    {
        int y = 96;
        // x和y都有效
    }
    // x有效y无效
}
// x和y都无效
```

####　对象的作用域

Java对象和基本类型的作用域有所不同。但通过`new`创建一个对象时，它可以存活于作用域之外。

``` java
{
    String s = new String("a string");
} // 无法访问ｓ
```

引用ｓ作用域终点就消失了。然后，ｓ所指向的String对象扔继续占据内存空间。但是这段代码出了作用域，我们无法再访问这个对象，因为它唯一的引用已经超出作用域范围。我们不必手动释放内存问题，垃圾回收机制会帮我们搞定。

###　创建新的数据类型：类

Java通过`class`关键字创建一个类。例如：

```java
class HelloWorld {
    // 类体
}
```

然后可以通过`new`创建一个对象

```java
HelloWorld hello = new HelloWorld();
```

#### 字段和方法

一旦定义好类，就可以在类中设置两种类型元素：字段（有时被称为数据成员）和方法（有时被称为成员函数）。

字段可以是任何类型对象。如果字段是引用类型，那么必须先初始化，以便使其与实际对象相关联。

每个对象都有用来存储其字段的空间；普通字段不能在对象间共享（相同类不同对象中的字段都有一块独立存储空间）。下面是一个具有字段（属性）的Student类：

```java
class Student {
    String name;
    int age;
}
```

创建一个对象

```java
Student student = new Student();
```

给字段赋值

```java
student.name = "oldman";
student.age = 18;
```



##### 基本成员默认值

如果类某个成员是基本数据类型，即使没有进行初始化，Java也会确保它获得一个默认值。如图

| 基本类型 |     默认值     |
| :------: | :------------: |
| boolean  |     false      |
|   char   | '\u0000'(null) |
|   byte   |    (byte)0     |
|  short   |       0        |
|   int    |       0        |
|   long   |       0L       |
|  float   |      0.0f      |
|  double  |      0.0d      |

初始值对程序来说，可能是不正确的，甚至是不合法的。所以最好明确地对成员进行初始化。

初始值并不适用于局部变量（比如方法内定义的变量）。

局部变量可能是任意值（与Ｃ和Ｃ++一样），而不会被自动初始化为零。所以在使用某个局部变量之前，必须初始化，如果忘记初始化，Java会在编译时报错，提示没有初始化。

```java
class Test {
    int i; // 默认初始值为０
    
    void run() {
        int x; // 错误，局部变量必须先初始化
        int y = 0; // 正确，给局部变量赋值默认值０
    }
}
```

### 方法、参数和返回值

Java方法（也称函数）决定了一个对象能够接收什么样的消息（执行某种操作）。方法的基本组成包括：`方法名`、`参数`、`返回值`、`方法体`。下面是它的基本形式：

```java
ReturnType methodName(Argument list) {
    // 方法体
}
```

`ReturnType`：返回类型描述的是调用该方法之后从该方法返回的值。

`methodName`：方法名

`Argument list`：参数列表要传给方法的信息类型和名称（可以从外面接收哪类信息）

方法名和参数列表（它们合起来称为`方法签名`）唯一地标识出某个方法。

Java中的方法只能作为类的一部分创建（二等公民）。非`static`方法只能通过对象调用。

创建方法示例：

```java
class Student {
    String name;
    int age;
    
    /**
    * 创建一个获取学生姓名的方法
    * 方法名称:getName
    * 没有参数
    * 返回一个String类型的学生名字
    * 方法体：return name;
    */
    String getName() {
        return name;
    }
    
    /**
    * 创建一个设置学生姓名的方法
    * 方法名称：setName
    * 参数类型：String，参数名称：name
    * void 表示没有返回值
    * 方法体：this.name = name;
    */
    void setName(String name) {
        this.name = name;
    }
    
    void getAge() {
        return age;
    }
}
```

##### 方法调用

创建一个对象，通过对象名，紧接着是英文句号点`.`，然后是方法名和参数列表。如下

```java
Student student = new Student();
student.setName("Snow");
student.getName();
```

接收方法返回值的变量必须要和返回值类型一致。

```java
String name;
String age;

Student student = new Student();
name = student.getName(); // 正确，接收的返回值的变量和返回值数据类型一致
age = student.getAge(); // 错误，接收的方法返回值的变量和返回值数据类型不一致

```

##### 参数列表

方法的列表指定要传递给方法什么样的信息。和返回值一样，传递给参数的值必须和参数类型一致。和Java其他的信息一样，采用的对象形式（数据类型及参数名称）。Java基本类型参数是值传递，引用类型是引用传递。

值传递

```java
int age = 18;

setAge(age);

void setAge(int age) {
    age = 28; // 修改参数age的值不会影响到成员变量的值
}
```

引用传递

```java
Student student = new Student();
student.age = 18;

setAge(student);

void setAge(Student student) {
    student.age = 19; // student.age 值被改变成19
}
```

### 命名空间

Java为了避免命名冲突采用包名一般使用公司发转域名。比如google.com那么程序包名可以这样定义`com.google`。如果公司有多个项目可以在后面加项目名称。比如项目名称为gmail，那么包名应该这样定义`com.google.gmail`。

假设你的项目有一个类名`ArrayList`，该类名和Java标准库里的类冲突，如果不想引用标准库类可以通过`import`关键字指定要引用的类。示例如下：

```java
import com.google.gmail.ArrayList;
class Test {
    AarrayList list = new ArrayList(); // 引用的是com.google.gmail项目的ArrayList
}
```

如果一个类同时需要引用两个不同包相同类名，解决方式如下

```java
class Test {
    // 明确调用com.google.gmail项目的ArrayList
    com.google.gmail.ArrayList gList = new com.google.gmail.ArrayList();
    // 明确调用java.util.ArrayList项目的ArrayList
    java.util.ArrayList jList = new java.util.ArrayList();
}
```

### 静态方法

通常来说，创建类时，就是在描述那个类的外观和行为。除非通过关键字`new`创建那个类的对象，否则，实际上并没有获得任何对象。执行`new`来创建对象时，数据存储才被分配空间，方法才能供外部调用。

有两种情形用上述方法是无法解决的。一种情形是，只想为某个特定变量分配单一存储空间。另外一种情形是，希望某个方法不与对象关联在一起，也能够调用这个方法（如果工具类）。

通过`static`关键字可以满足以上两种情形。当声明`static`时，意味这个成员变量和方法不会与这个类的任何对象关联（静态成员变量只会分配一块单一存储空间，非静态成员变量每个对象都会分配一块存储空间）。因此，可以在未创建任何对象情况下调用静态变量和静态方法。

```java
class Test {
    int i = 0; // 非静态变量
    static int x = 0;　// 静态变量
    
    /**
    * 非静态方法
    */
    void say() {}
    
    /**
    * 静态方法
    */
    static void hello() {
        i = 1; // 错误，静态方法不能调用非静态成员变量
        x = 1; // 正确
        int y = 0; // 正确
        say(); // 不能调用非静态方法
        add(); // 正确
    }
    
    static void add() {}
}
```

类调用静态变量和方法

```java
Test.x = 0; // 正确
Test.i = 1; // 错误，类不能调用非静态成员变量
Test.hello(); // 正确
Test.say(); //　错误，类不能调用非静态方法
```

对象调用静态变量，改变的是同一块存储空间。

```java
Test test1 = new Test();
Test test2 = new Test();
test1.x++; // x == 1
test2.x++; // x == 2
```

对象调用成静态方法

```java
Test test1 = new Test();
Test test2 = new Test();
test1.say();　// 正确
test1.hello(); // 正确
```

### 注释和嵌入式文档

Java一共有三种注释风格，

```java
// 第一种：单行注释

/*
* 第二种：多行注释
*/

/**
* 第三种：文档注释
* @author Snow
* @version 1.0
*/


```

#### 注释文档

注释文档主要是用于撰写程序文档。`javadoc`只能为`public`和`protected`成员进行文档注释。

### 编码风格

类的首字母要大写，多个单词构成，每个单词首字母大写

方法、成员变量、局部变量采用`驼峰风格`

```java
class AllTheColorsOfTheRainbow {
    int anIntgerRepresentingColors;
    void changeTheHueOfTheColor(int newHub) {}
}
```



