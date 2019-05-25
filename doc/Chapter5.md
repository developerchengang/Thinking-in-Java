#　初始化与清理

## 构造器用于确保初始化

在Java中，通过构造器，可以确保类的每个对象都会初始化。创建对象时，如果其中类具有构造器，Java就会在操作对象之前自动调用相应的构造器，保证初始化。

构造器采用与类相同的名称。在初始化期间自动调用构造器。

以下是一个带有构造器的简单类：

```java
class Rock {
    // 构造方法
    Rock() {}
}

public class SimpleConstructor {
    public static void main(String[] args) {
        new Rock(); // 创建对象，为对象分配存储空间
    }
}
```

由于构造器的名称与类名完全相同，所以每个方法首字母小写的编码风格并不适合构造器。

不接受任何参数的构造器叫做默认构造器，Java文档中通常使用术语无参构造器。构造器也能带有形式参数。对上述例子稍加修改，即可使用构造器接受一个参数：

```java
class Rock {
    // 带有一个参数的构造方法
    Rock(int i) {}
}

public class SimpleConstructor {
    public static void main(String[] args) {
        // 创建十个对象
        for (int i = 0; i < 10; i++) {
            new Rock(); // 创建对象，为每个对象分配独立的存储空间    
        }
    }
}
```

如果创建了构造方法，那么编译器就不再自动创建默认构造方法。

构造方法是一种特殊的类型方法，因为它没有返回值。这与返回空（void）不同。对于空返回值，尽管方法本身不会自动返回什么，但仍可选择让它返回别的对象。构造方法不会返回任何对象，`new`表达式返回了新建对象的引用，但是构造方法本身并没有返回任何返回值。

## 方法重载

任何程序设计语言都具备一项重要的特性就是对名字的运用。当创建一个对象时，也就是给分配到存储空间的对象取名字。所谓方法则是给某个动作取名字。通过名字，你可以引用对象和方法，名字起的好可以更易于理解和修改。就好比写散文目的是让读者易于理解。

在Java里，构造方法，构造方法的名字已经由类名决定，就只能有一个构造方法名。想要用多种方式创建一个对象该怎么办？假设要创建一个类，即可以用默认构造方法初始化，也可以从文件里读取信息来初始化。这就需要两个构造方法：一个默认的构造方法，另外一个带字符串作为形式参数。由于都是构造方法，所以它们必须具有相同的名字。为了让方法名相同而形参不到的构造方法同时存在，必须用到**方法重载**。方法重载即可用于构造方法也可以用于普通方法。

以下例子用于示范重载的构造方法和普通方法：

```java
class Tree {
    int height;
    // 默认构造方法
    Tree() {
        height = 0;
    }
    
    // 有参构造方法
    Tree(int initialHeight) {
        height = initialHeight;
    }
    
    // print()方法和print(int height)构成方法重载
    void print() {
        System.out.println("height:" + height);
    }
    
    void print(int height) {
        System.out.println("height:" + height);
    }
}
```

### 区分重载方法

要是几个方法具有相同的名字，Java如何才能指定你指定的是哪一个呢？其实规则很简单：每个重载的方法必须有一个独一无二的参数类型列表。甚至参数顺序的不同也足以分区两个方法。不过，一般情况下别这么做，因为这会时代码难以维护。

### 涉及基本类型的重载

```java
void f1(short s) {
    System.out.println("s:" + s);
}

void f1(int i) {
    System.out.println("i:" + i);
}

public static void main(String[] args) {
    f1(5);
}
```

常量值为5被当做int值常量，如果某个重载方法接受int类型参数，就会被调用。如果传入的数据类型（实参）小于方法中声明的形参，实参数据类型就会被提示。char类型如果没有找到接受char参数的方法，就会把char直接提示至int类型。如果传入的实参数较大，就得向下转型。无法根据返回值区分重载方法。

## 默认构造方法

默认构造方法（又名“无参”构造方法）是没有形参的——它的作用是创建一个“默认对象”。如果没有在类中定义构造方法，编译器会自动创建一个默认构造方法。

##　this关键字

如果有同一类型的两个对象，分别是a和b。如何才能让两个对象都能调用peel()方法呢：

```java
class Banana() { void peel(int i) { /* ... */} }

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana();
               b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}
```

如果只有一个peel()方法，如何指定是被a还是b调用呢？

为了简便，面向对象的语法编写代码——即“发送消息给对象”，编译器做了一下幕后工作。它暗自把“所操作对象的引用”作为第一个参数传递给peel()方法。所以上述两个方法的调用就变成了这样：

```java
Banana.peel(a, 1);
Banana.peel(b, 2);
```

这是内部的表达形式。我们并不需要这样编写代码，但这种写法能了解实际所发生的事情。

假设希望在方法的内部获得当前对象的引用。由于这个引用是有编译器“偷偷”传入的，所以没有标识符可用。但是，有个专门的关键字：`this`。this关键字只能在方法内部使用，表示对“调用方法的那个对象”的引用。this的用法和其他对象的引用并无不同。但是要注意，如果在方法内部调用同一类的另外一个方法，就不必使用this，直接调用即可。当前方法中的this引用会自动应用与同一类中的其他方法。所以可以这样写：

```java
public class Apricot {
    void pick() {}
    void pit() { pick(); }
}
```

在pit()方法内部，可以写this.pick()，但是没有必要。编译器会自动添加this。只有当前需要明确指出当前对象引用时，才需要this关键字。例如，需要返回当前对象的引用时，常常在return语句里这样写：

```java
public class Leaf {
    int i = 0;
    Leaf increment() {
        i++;
        return this;
    }
    
    void print() {
        System.out.print("i = " i);
    }
    
    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
```

由于increment()通过this关键字返回了当前对象的引用，所以很容易在一条语句里对同一个对象执行多次操作。

this关键字对于将当前对象传递给其他方法也很有用：

```java
class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() { 
        return Peeler.peel(this);
    }
}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
```

Apple需要调用Peeler.peel()方法，它是一个外部的工具方法，将执行由于某种原因必须放在Apple外部的操作（也许是因为该方法要应用许多不同的类，而你却不想重复这些代码）。为了将其自身传递给外部方法，Apple必须使用this关键字。

####　在构造方法中调用构造方法

一个类可以有多个构造方法，有时想在一个构造方法中调用另外一个构造方法，以避免重复代码。可用this关键字做到这一点。

通常this关键字是值“这个对象”或者“当前对象”，而且它本身是当前对象的引用。在构造方法中，如果为this添加了参数列表，那么就有了不同的含义。这将对符合参数列表的某个构造方法明确调用。

```java
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    
    Flower(int petals) {
        petalCount = petals;
    }
    
    Flower(String ss) {
        s = ss;
    }
    
    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        // this(s); 不能同时调用两个构造方法 
    }
    
    Flower() {
        this("h1", 10);
    }
    
   　void print() {
        // this(11); 不能在非构造方法中调用构造方法 
    }
}
```

#### static的含义

带有static关键字的方法称为静态方法又称为类方法。static就是没有this的方法，在static方法内部不能调用非静态方法，非静态方法可以调用静态方法。静态方法可以在类没有任何对象的情况下通过｀类名.｀方式调用。除静态方法外，还有静态变量以及常量。

### 垃圾回收

在Java中我们不需要手动释放被弃用的对象，`GC`垃圾回收机制帮我们清理通过`new`创建的对象。`finalize()`关键字并不能帮我们立即释放内存，finalize方法一般用于**本地方法**，本地方法是一种在Java中调用非Java代码的方式（本地方法目前只支持C和C++）。对象回收什么时候回收由垃圾回收机制决定。

#### 垃圾回收机制如何工作

垃圾收集的目的在于清除不再使用的对象。**GC**通过确定对象是否被活动对象引用来确定是否收集该对象。

Java虚拟机采用自适应的垃圾回收技术。至于如何处理找到存活的对象，取决于不同的Java虚拟机实现。有一种做法**停止－复制（stop-and-copy）**。先暂停程序的运行（所以它不属于后台回收模式），然后将存活的对象从当前堆复制到另外一个堆，没有被复制的全部都是垃圾。当对象被复制到新堆时，它们是一个挨着一个的，所以保持紧凑排列，然后就可以直接分配新空间了。

当把对象从一处搬到另外一处时，所有指向它的引用都必须修正。位于堆或者静态存储区的引用直接被修正。

对于这种所谓的“复制式回收器”而言，效率会降低，有两个原因。首先，得有两个堆，然后得在这两个分离的堆之间来回倒腾，从而得维护比实际多一倍的空间。某些Java虚拟机对此问题的处理方式是，按需从堆中分配几块比较大的内存，复制动作发生在这些大块内存之间。

第二个问题在于复制。程序进入稳定状态之后，可能只会产生少量垃圾，甚至没有垃圾。尽管如此，复制式回收器仍然会将所以内存复制到另外一处，这很浪费。为了避免这种情形，一下Java虚拟机会进行检查：要是没有垃圾产生，就会换到另外一种工作模式（即“自适应”）。这种模式称为标记—清扫（mark－and-sweep），Sun公司早期版本的Java虚拟机使用这种技术。对于一般用途而言，“标记—清扫”方式速度相对慢，但是当它只会产生少量垃圾设置没有垃圾时，它的速度就很快。

#### 标记—清扫

从堆栈和静态存储区出发，遍历所有的引用，找出所有存活的对象。每当找到一个存活对象，就会给对象设一个标记，这个过程不会回收任何对象。只有全部标记工作完成时，清理动作才开始。在清理过程中，没有标记的对象将被释放，不会发生任何复制动作。所以剩下的堆空间是不连续的，垃圾回收器要是希望得到连续空间的话，就得重新整理剩下的对象。

#### 停止—复制

这种垃圾回收动作不是在后台进行的；垃圾回收动作发生的同时，程序将会被暂停。当可用内存数量较低时，Sun版本的垃圾回收器会暂停运行程序，同样，“标记—清扫”工作也必须在程序暂停的情况下才能进行。

严格来说，**停止—复制**要求在释放旧有对象之前，必须先把所有存活对象从旧堆复制到新堆，这将导致大量内存复制行为。有了块之后，垃圾回收器在回收时候就可以往废弃的块里拷贝对象。每个块都用相应的代数（generation count）来记录它是否还存活。通常，如果块在某处被引用，其代数会增加；垃圾回收器会对上次回收动作之后的新分配的块进行整理。这对处理大量短命的临时对象很有帮助。垃圾回收器会定期进行完整的清理动作——对大型对象仍然不会被复制（只会代数增加），小型对象那块则被复制并整理。Java虚拟机会进行监视，如果所有对象都很稳定，垃圾回收器的效率低的话，就会切换回“标记—清扫“方式；同样，Java虚拟机会跟踪”标记—清扫“的效果，要是堆空间出现很多碎片，就会切换回”停止—复制“方式。这就是”自适应“技术，你可以给它个啰嗦的称呼：“自适应的、分代的、停止—复制、标记—清扫”式垃圾回收器。

Java虚拟机中有许多附件技术用于提升速度。尤其与加速器操作有关的，被称为“即时”（Just－In－Time）编译器技术。这种技术可以把程序全部或者部分翻译成本地机器码，程序运行速度因此得以提升。当需要装载某个类（通常是在该类创建第第一个对象）时，编译器会先找到其.class文件，然后将该类的字节码装入内存。此时，有两种方案可供选择。一种就是让即时编译器编译所以代码。这种做法有两个缺陷：加载动作散落在整个程序生命周期内，累加起来要花更多时间；并且会增加可执行代码的长度（字节码要比即时编译器展开后的本地机器码小很多），导致页面调度，从而降低速度。另外一种做法称为惰性评估（lazy evaluation），意思是即时编译器只在必要的时候才编译代码。这样，从不会被执行的代码就压根不会被JIT所编译。JDK中的Java HotSpot技术就采用这类方式，代码每次被执行的时候就做一项优化，所以执行次数越多，它的速度就越快。

### 成员初始化

Java尽量保证：所有变量在使用前都能得到恰当的初始化。成员变量如果是基本类型默认会指定默认值。对于方法的局部变量，如果没有初始化则会报错。

```java
void f() {
    int i;
    i++; // 报错，i没有初始化
}
```

#### 指定初始值

如果想为某个变量赋值，直接的方法，就是在定义类成员变量的地方为其赋值。

```java
public class Initial {
    boolean bool = true;
    char ch = "x";
    byte b = 1;
    short s = 0xff;
    int i = 999;
    long l = 10000;
    float f = 3.1415f;
    double d = 3.1415;
}
```

也可以用同样的方式初始化非基本类型的对象。

```java
class Depth {}

public class Measurement {
    Depth d = new Depth();
}
```

也可以通过方法来提供初始值：

```java
int i = f();
int f() {
    return 11;
}
```

### 构造方法初始化

可以用构造器来进行成员变量初始化。成员变量在构造器调用之前初始化。

``` java
public class Counter {
    int i;
    Counter() {
        i = 7;
    }
}
```

#### 初始化顺序

在类的内部，变量定义的先后顺序决定了初始化的顺序。即使变量定义散布于方法定义之间，它们仍旧会在方法（包括构造方法）被调用之前初始化。

```java
class Window {
    Window(int marker) { System.out.println("Window(" + marker + ")"); }
}

class House {
    Window w1 = new Window(1);
    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f() { System.out.println("f()"); }
    Window w3 = new Window(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}
/*output
 Window(1)
 Window(2)
 Window(3)
 House()
 Window(33)
 f()
*/
```

#### 静态数据的初始化

无论创建多少个对象，静态数据只会占用一份存储区域。static关键字不能应用于局部变量，因为它只能作用于成员变量或者常量。初始化的顺序先静态对象（前提是它们没有因为前面的对象创建过程而被初始化，也就是只会初始化一次），再初始化非静态对象。

```java
public class Window {
    Window(int marker) { System.out.println("Window(" + marker + ")"); }
}

public class House {
    Window w1 = new Window(1);
    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }
    static Window w2 = new Window(2);
    void f() { System.out.println("f()"); }
    static Window w3 = new Window(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        new House();
        h.f();
    }
    
    static House h = new House();
}
/*output
  Window(2)
  Window(3)
  Window(1)
  House()
  Window(33)
  Window(1)
  House()
  Window(33)
  f()
*/
```

#### 显示的静态初始化

Java运行将多个静态初始化动作组织成一个特殊的静态字句（有时也叫作静态块）：

```java
public class Spoon {
    static int i;
    static {
        i = 2;
    }
}
```

尽管上面的代码看起来像方法，但他实际只是一段跟在static关键字后面的代码。与其他静态初始化一样，只会执行一次。

#### 非静态实例初始化

Java也有称为实例初始化的类似语句，用来初始化每个非静态变量。

```java
Mug mug1;
{
    mug = new Mug();
}
```

### 数组

数组是一组相同数据类型的集合。数组是通过方括号下标操作符[]来定义和使用。定义数组，只需要在数据类型后加一对空方括号：

```java
int[] a;
```

也可以把方括号放在数组名后面：

```java
int a[];
```

两种格式的含义是一样的，后一种格式符合C和C++程序员的习惯。通常使用前一种格式。

#### 数组长度

数组一旦指定长度就不可变。

```java
int a[] = new int[5];
```

#### 赋值

和基本类型以及引用类型一样

```java
// 声明一个数组
int[] a;
// 指定长度
a = [5];
// 给数组的第2个元素赋值
a[1] = 1;

// 声明并赋值
Integer b[] = {1, 2, 3};
b[3] = 4; // 编译报错，数组越界。数组下标从0开始


```

### 可变参数列表

可应用于参数个数不确定的场合。编译器实际上生成一个数组。

```java
void test(String... values) {
    values[1] = "4";　// 可以通过下标访问第二个元素
    
    // 循环打印可变参数值
    for(String s : values) {
        System.out.println("s:" + s + "\n");
    }
}

test("1", "2", "3");
```

### 枚举

枚举一般和switch结合使用

```java
public enum Color {
    RED, BLUE, GREEN
}

void test(Color color) {
    switch(color) {
        case RED:
            System.out.println("红色");
            break;
        case BLUE:
            System.out.println("蓝色");
            break;
        case GREEN:
            System.out.println("绿色");
            break;
    }
}
```

### 总结

构造方法，这种精巧的初始化机制，可在创建对象的同时初始化，大量编程语言错误都源于未正确初始化。不恰当的清理也会导致类似问题。构造方法能保证正确的初始化和清理（没有正确的构造方法调用，编译器就不允许创建对象），所以控制了对象安全。

Java的垃圾回收器可以简化编程工作，处理内存的时候更安全。然而，垃圾回收器也增加了运行时的开销。