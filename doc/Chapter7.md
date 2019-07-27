# 复用类

复用类一般分为两种方法：

第一种，在类中继承其他类的属性和方法，我们称之为类的继承。继承是面向对象程序设计基石之一。

第二种，在类中实现现有的类，称之为组合。也就是说，类是由其他类组合而成。复用其他类的功能。

## 组合语法

```java
class Gan {
    public void shot() {
        System.out.print("开枪射击...");
    }
}

class Person {
    public void fight() {
        Gan gan = new Gan();
        gan.shot();
    }
}
```

Gan（枪）类不是Person（人）类的一部分，我们只要拿过来用就可以了。

### 对象引用初始化

编译器不会自动为引用创建默认对象，因为这样会增加不必要负担（消耗内存空间）。

有四种方式为对象引用初始化：

1. 在定义对象引用的地方。这样它们总是能够在构造方法被调用之前初始化。
2. 在类的构造方法中。
3. 在正要使用这个对象之前，这种方式称为惰性初始化。
4. 实例初始化。

## 继承语法

继承是OOP语言和Java语言不可缺少的组成部分。当创建一个类时，总是在继承，因此，除非已经明确指出要从其他类中继承，否则就是隐式从Java标准根类Object继承。

显示声明继承其他类，需要在子类名称后面加上关键字*extents*然后更上父类（也称为基类）名称。一旦继承某个类为基类，那么子类就拥有基类所有属性和方法。

```java
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void scrub() { append("scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.scrub();
    }
}

public class Detergent extents Cleanser {
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub(); // 调用基类scrub方法
    }
    public void foam() {
        append("foam()");
    }
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.scrub();
        x.foam();
        Cleanser.main(args);
    }
}
```

这个程序示范了Java许多特性。首先，在Cleanser的append()方法中，我们用到了`+=`操作符将多个String对象拼接成字符串，此操作符是Java设计者重载用以处理String对象的操作符（另外一个是`+`）。

其次，Cleanser和Detergent均含有main()方法。可以为每个类都创建一个main()方法。好处是方便每个类单元测试。单元测试完成之后，不必删除main()方法，可以保留等待下次测试。

即使一个程序包含多个类，也只有命令行所调用的那个类的main()方法会被调用。因此，在此示例中，如果命令行是`java Detergent`，那么Detergent.main()将会被调用。如果命令行是`java Cleanser`，即使Cleanser不是一个public类，Cleanser.main()方法也会被调用，类只具有包访问权限，其public main()方法仍然是可以访问的。

在此示例中，可以看到在Detergent.main()方法调用了Cleanser.main()方法，并将命令行中获取到的参数传递给它。当然，也可以传递其他任意String数组。

Cleanser中所有的方法都必须是public的，这点非常重要。如果没有加任何访问权限修饰符，那么成员默认的访问权限是包访问权限，仅允许包内的其他类访问。因此，在包中，如果没有访问权限修饰符，包内其他类都可以访问这些方法和数据成员。假设以上示例两个方法都处于同一包中，那么Detergent类就可以访问Cleanser类包级别方法和数据成员；如果两个类处于不同包中，那么Detergent类只能访问Cleanser类中public方法和数据成员。在继承中，一般规则是将所有的数据成员都指定为private，将所有的方法指定public（或者protected）。

在Cleanser中有一组方法。由于Detergent继承Cleanser，尽管不在Detergent类中看到这些方法显式定义，但是Detergent仍然拥有这些方法。因此，可以将继承视为是对象的复用。

如果子类重写了父类的方法，同时想调用父类的方法，那么必须通过关键字`super`访问父类的方法。Detergent.scrub()方法调用了Detergent.scrub()方法，通过关键字`super.scrub()`访问。如果不加关键字`super`那么Detergent.scrub()方法就会造成递归，也就是自己调用自己。

继承的子类，不一定非得使用基类的方法。也可以添加新的方法。

### 初始化基类

由于现在涉及基类和子类两个类，所以要理解子类所产生的对象，会有点困惑。从外部来看，它像是一个与基类具有相同特征和行为的新类，或许会有一些额外的方法和数据成员。但是继承并不只是复制基类的特征和行为。当创建一个子类的对象时，该对象包含了一个基类的子对象。这个子对象与基类创建的对象是一样的。区别在于，后者来自外部，而基类的子类被包装在子类对象内部。

理解基类子对象正确的初始化过程很重要，而且也仅有一种方式来保证初始化：在构造方法中调用基类的构造方法，而基类的构造方法执行基类初始化所需要的所有能力。Java会自动在子类的构方法中调用基类的构造方法。下例展示了上述机制在三层继承关系上是如何工作的：

```java
class Art {
    Art() { 
        System.out.print("Art constructor()"); 
    }
}

class Drawing extents Art {
    Drawing() {
        System.out.print("Drawing constructor()");
    }
}

public class Cartoon extents Drawing {
    public Cartoon {
        System.out.print("Cartoon constructor()");
    }
    
    public static void main(String args) {
        Cartoon x = new Cartoon();
    }
}
/* output:
 * Art constructor
 * Drawing constructor
 * Cartoon constructor
 */
```

由此发现，构造过程是先调用基类构造方法再调用子类的构造方法。所以基类的构造方法是在子类的构造方法之前就已经完成初始化。即使你不为Cartoon类创建构造方法，编译器也会默认调用基类的构造方法。

### 带参数的构造方法

如果想调用基类带参数的构造方法，和普通方法调用基类的方法一样，必须用关键字`super`显式地调用，并且传递正确的参数列表。

```java
class Game {
    Game(int i) {
        System.out.print("Game constructor()");
    }
}

class BoardGame extents Game {
    BoardGame(int i) {
        super(i);
        System.out.print("BoardGame constructor()");
    }
}

public class Chess extents BoardGame {
    Chess() {
        super(1);
        System.out.print("Chess constructor()");
    }
    
    public static void main(String args) {
        Chess x = new Chess();
    }
}
/* output:
*  Game constructor()
*  BoardGame constructor()
*  Chess constructor()
*/
```

如果不在BoardGame或者Chess构造方法中调用基类的构造方法，编译器将会报错提示无法找到符合的构造方法。

### 代理

第三种关系称为代理。Java并没有提供对它的直接支持。这是继承与组合之间的中庸之道，因为我们将一个成员对象置于所要构造的类中（就像组合），但与此同时我们在新创建的类中暴露该成员对象的所有方法（就像继承）。例如，太空船需要一个控制模块：

```java
public class SpaceShipControls {
    void forward(int velocity) {}
}
```

构造太空船的一种方式是使用继承：

```java
public class SpaceShip extents SpaceShipControls {
    private String name;
    
    public SpaceShip(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
    
    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip();
        protector.forward(100);
    }
}
```

这样设计不合理SpaceShip不是属于SpaceShipControls类型。更准确地讲，SpaceShip包含SpaceShipControls。通过代理解决此问题：

```java
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipCOntrols();
    
    public SpaceShipDelegation(String name) {
        this.name = name;
    }
    
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    
    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NESA Protector");
        protector.forward(100);
    }
}
```

使用代理可以拥有更多的控制力，因为我们可以选择只提供成员对象中某些方法。

### 结合使用组合和继承

同时使用组合和继承是很常见的事情。下例展示了同时使用这两种技术，并配以必要的构造方法初始化，来创建更加复杂的类：

```java
class Plate {
    plate(int i) {
        System.out.print("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        System.out.print("DinnerPlate constructor");
    }
}

class Utensil {
    Utensil(int i ) {
        System.out.print("Untensil constructor");
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        System.out.print("Spoon constructor");
    }
}

public class PlaceSetting {
    private Spoon sp;
    private DinnerPlate pl;
    public PlaceSetting() {
        sp = new Spoon("1");
        pl = new DinnerPlate("2");
        System.out.print("PlaceSetting constructor");
    }
    
    public static void main(String[] args) {
        PlaceStting x = new PlaceStting();
    }
}
/* output:
* Untensil constructor
* Spoon constructor
* Plate constructor
* DinnerPlate constructor
* PlaceSetting constructor
*/
```

虽然编译器强制初始化基类，但并不监督成员对象的初始化，如果在成员对象未初始化将抛空指针异常。

#### 确保正确清理

有时类可能要在生命周期执行一些必要的清理（比如操作IO、SQL释放资源）。由于并不知道垃圾回收器何时调用，这时我们可以将一些清理动作置于`finally`字句之中，以预防异常的出现。

```java
class Circle {
    Circle() {
        System.out.print("Drawing Circle");
    } 
    
    void dispose() {
        System.out.print("Erasing Circle");
    }
    
    public static void main(String[] args) {
        Circle x = new Circle();
        try {
            // 代码和异常处理...
        } finally {
            x.dispose(); 
        }
    }
}
```

在main()方法中可以看到`try`和`finally`两个之前没有看到的关键字，关键字`try`表示，下面的块（用一组大括号括起来的范围）是所谓的保护区。其中一项特殊处理就是无论try语句块是怎样退出的，保护区后的finally块的代码总会被执行。这里的finally子语句表示“无论发生什么事情，一定会执行x.dispose()”。

在许多情况下，让垃圾回收器完成清理就可以了。但是当必须亲自处理清理的时候，就不要依赖回收器。因为，你永远不知道垃圾回收器什么时候回收对象。最好的办法是除了内存以为，不要依赖垃圾回收器去做任何事。如果需要进行清理，最好自己编写清理方法，但不要使用finalize方法。

#### 名称屏蔽

如果基类拥有某个已被多次重载的方法名称，那么在子类中重新定义该方法名称并不会屏蔽在基类的方法。无论在子类或者它的基类中对方法进行定义，重载机制都可以正常工作：

```java
class Homer {
    char doh(char c) {
        System.out.print("doh(char)");
        return c;
    }
    
    float doh(float f) {
        System.out.print("doh(float)");
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.print("doh(Milhouse)");
    }
    
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(2.0f);
        b.doh(new Milhouse());
    } 
}
/* output:
* doh(float)
* doh(char)
* doh(float)
* doh(Milhouse)
*/
```

可以看到，虽然Bart引入了一个新的重载方法，但是Bart中的Homer的所有重载方法都是可用的。使用与基类完全相同特征签名及返回类型来覆盖相同名称的方法，是非常平常的事。

Java SE5新增加了**@Override**注解，它不是关键字，但是可以用它当作关键字使用。当需要重写某个方法时，可以选择添加这个注解，**@Override**可以防止重写错误，比如参数类型错误，返回类型错误等。

## 在组合与继承之间选择

组合和继承都允许在类中添加其他对象，组合是显式，而继承则是隐式。

组合通常用于想在类中实现其他类已有的功能。而继承是为现有类开发一个特殊的版本。

比如一个人**Person**类继承了**human**类，我们可以称为**Person**是属于**human**类。再比如一个**Person**类可以组合**Gun**类，这里使用组合就不太合适了，因为**Person**类不属于**Gun**。所以衡量到底使用组合还是继承的方式标准如下：

如果一个类是另外一个类那么用继承（is-a关系），一个类拥有另外一个类那么使用组合（has-a）。

## protected关键字

如果基类某个方法或者属性只允许它的子类或者同一个包内其他类访问，那么使用关键字**protected**就能起到很好的保护作用。

## 向上转型

假设有一个**Instrument**代表乐器的基类和一个称为**Wind**的子类。由于继承可以确保基类中所有的方法在子类中也同样有效，所以能够向基类发送的信息子类也可以发送。如果**Instrument**有一个play方法，那么**Wind**同样具备play方法。这样我们可以准确地说**Wind**对象也是一个**Instrument**对象。下面的例子说明了编译器是支持这一概念的：

```java
class Instrument {
    public void play() {}
    static void tune(Instrument i) {
        i.play();
    }
}

public class Wind extends Instrument {
    Wind flute = new Wind();
    Instrument.tune(flute); // 向上转型
}
```

在tune方法中，可以对**Instrument**和它所有子类起作用，这种将**Wind**引用转换为**Instrument**的动作，我们称为向上转型。

### 为什么称为向上转型

该术语使用有历史原因，并以传统类继承图的绘制方法为基础：将根置于页面的顶端，然后逐渐向下。

有子类转型成基类，在继承图上是向上移动的，因此一般称为向上转型。由于向上转型是从一个专用类型向通用类型转换，所以是很安全的。也就是说，子类是基类的超集。它可以比基类包有更多的方法，同时它也具体基类所包含的方法。向上转型，类型接口唯一可能发生的事情就是方法丢失。也可以执行与向上转型相反的向下转型。

### 再论组合与继承

在面向对象编程中，生成和使用程序代码最有可能采用的方法就是直接将数据可方法包装在一个类中，并使用该类的对象。也可以运用组合使用现有类来开发新的类；而继承其实不太常用。相反，应当慎用继承。到底是该使用组合还是继承，一个最清晰的判断方法就是是否需要从新类向基类向上转型。如果必须向上转型，则使用继承；如果不需要，则应当很好考虑。

## final关键字

根据上下文环境，Java的关键字**final**的含义存在细微的区别，但通常它指的是“它是无法改变的”。不想改变可能出于两种理由：设计和效率。由于这两种原因相差很远，所以关键字final有可能误用。

可以使用**final**的三种情况：数据，方法和类。

### final数据

许多编程语言都有某种方法，来向编译器告知一块数据是恒定不变的。有时数据的恒定不变很有用，比如：

- 一个永不改变的编译时常量
- 一个在运行时被初始化的值，而你不希望它被改变

对于编译期常量这种情况，编译器可以将该常量值代入任何可以用到它的计算中，也就是说，可以在编译时执行计算，减轻运行时负担。在Java中，这里常量必须是基本数据类型，并且以关键字**final**表示。在对这个常量进行定义的时候，必须赋值。

一个即是**static**又是**final**的属性只占一段不能改变的存储空间。

当对象引用使用**final**时，需要注意。一旦引用被初始化指向一个对象，就无法再把它改变指向另外一个对象。然而，对象中属性是可以被修改的。这一限制同样适用数组，它也是对象。

```java
class Value {
    int i; 
    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id) {
        this.id = id;
    }
    // 定义final则说明它是一个常量，编译时常量
    private final int valueONe = 9;
    // 定义static，则强调只占一块内存空间
    private static final int VALUE_TWO = 99;
    // 典型堆常数定义的方式，定义public可以被用于其他类，
    public static final int VALUE_THREE = 39;
    // 运行时常量
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    // 数组
    private final int[] a = {1, 2, 3, 4, 5, 6};
    public String toString() {
        return id + ":" + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }
    
    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        // fd1.valueOne++; // 错误：valueOne是常量不能改变它的值
        fd1.v1 = new Value(9); // 正确，fd1和v1不是常量
        // fd1.v2 = new Value(0); // 错误，v2是常量不能改变它的引用
        // fd1.VAL_3 = new Value(1); // 同上
        // fd1.a = new new int[3]; // 同上
        
        fd1.v2.i++; // v2虽然是常量但是属性i不是常量可以改变它的值
        for(int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++; //　同上
        }
        
        FinalData fd2 = new FinalData("fd2");
    }
}


```

我们不能因为某个数据是final就认为在编译时就可以知道它的值。i4和INT_5说明常量可以在运行时定义。示例也展示了将final数值定义为静态和非静态的区别。在f1和f2中，i4的值是唯一的，但是INT_5的值是不会因为创建多个FinalData对象而改变它的值。这是因为它是static的，在装载时已被初始化，不会每次创建新对象都初始化。

v1到VAL_3这些变量说明了引用类型final的意义。不能因为v2是final，就认为无法改变它的值。由于它是一个引用，所以v2无法再次指向另外一个新的对象，数组一样，它也是另外一种引用。

### 空白final

Java允许生成"空白final"，所谓空白final是值被声明为final但又未给定初始值。但是在使用final之前必须初始。但是，空白final提供更大的灵活性。为此，一个类中的final属性可以做到根据对象而有所不同，保持其恒定不变的特性。例子：

```java
class Poppet {
    private int i;
    Poppet(int i) {
        this.i = i;
    }
}

public class BlankFinal {
    private final int i = 0; // 已初始化的final常量
    private final int j; // 空白final，也就是未初始化
    private final Poppet p; //　空白fianl，未初始化的对象引用
   　
    public BlankFinal() {
        j = i; // 初始化空白final
        p = new Poppet(i); // 初始化空白final对象引用
    }
}
```

必须在属性的定义处或者每个构造器中对final进行赋值，这正式final属性在使用前被初始化的原因所在。

### fianl参数

Java允许在参数列表中将参数指明为final，这样就无法在方法中更改参数引用所指向的对象以及它的值：

```java
class Gizmo {
    public void spin() {}
}

public class FinalArguments {
    void with(final Gizmo g) {
        // g = new Gizmo(); // Illegal －－　参数g是final所以不能改变它的引用
    }
    
    void with(Gizmo g) {
        g = new Gizmo(); // 正确 －－ 此次参数g不是final
    }
    
    void f(final int i) {
        i++; // 参数i是final不能改变它的值
    }
    
    int g(final int i) {
        return i + 1; // 这样是可以的
    }
}
```

方法f()和g()展示了基本类型的参数指明为final时：只可以读取参数值，不能修改参数。

### final方法

使用final方法的原因有两个。第一个原因把方法锁定，以防止任何继承类修改，这是出于设计考虑。

过去建议使用final方法的第二个原因是效率。在Java早期实现中，如果将一个方法声明为final，就是同意编译器针对该方法的所以调用都转为内嵌调用。当编译器发现一个final方法调用命令时，它会根据自己的谨慎判断，跳过插入程序代码这种正常方式执行方法调用机制（将参数压人栈，调至方法代码处并执行，任何调回并清理栈中参数，处理返回值），并且以方法体中的实际代码的副本来替代方法调用。这将消除方法调用的开销。当然，如果一个方法很多，程序代码会膨胀，可能看不到内嵌带来任何性能提高，因为，性能提高会花费于方法内的时间量而并缩减。

在最近的Java版本中，虚拟机（特别是hostpot技术）可以探测到这些情况，并优化去掉这些效率反而降低的额外内嵌调用，因此不再需要使用final方法来进行优化了。只有想要明确禁止覆盖时，才将方法设置为final。

#### fianl和private关键字

类中所有的private方法都隐式地指定为final。由于外部类无法调用private方法，所以也就无法覆盖它。对private方法添加final修饰词没有任何意义。

这个问题会造成混淆。因为如果试图覆盖一个private方法，编译器不会给出成为信息：

```java
class WithFinals {
    private void f() {
        System.out.print("WithFinals.f()");
    }
}

class OverridingPrivate extends WithFinals {
    private void f() {
        System.out.print("OverridingPrivate.f()");
    }
}
```

基类的方法是private不构成重载。

#### final 类

当将某个类的整体定义为final时，就表明了该类不能被其他类继承。两种情况可以把类设计为final，第一种情况是将来不希望做任何改动，另外出于安全考虑不希望拥有子类。

```java
final class Dinosaur {
    int i = 7;
    int j = 1;
}

// class Further extends Dinosaur {} //　Dinosaur定义为final不能被继承
```

定义为final的类它字段方法都隐式指定为final。

#### 有关final的忠告

在设计类时，将方法指明为final，应该是明智的选择。这样别人就无法继承你的类。

但也需要根据实际情况考虑，预见类是如何被复用的一般很困难。

## 初始化以及类的加载

在许多传统的语言中，程序是作为启动过程的一部分立刻被加载的。然后是初始化，紧接着开始运行。这些语言的初始化过程必须小心控制，以确保初始化顺序不会出错。

Java就不会出现这个问题，因为它采用了一种不同的加载方式。因为Java一切都是对象。请记住，每个类的编译代码都存在于它独立的**.class**文件中。该文件只有在需要使用程序代码时才会被加载。一般来说，“类的代码在初次使用才加载”。通常是指加载发生于创建类的第一个对象时，但是当访问static属性或者static方法时，也会发生加载。

### 继承与初始化

了解包括继承在内的初始化全过程，以对所发生的一切有个全局性把握，是很有益的。请看以下例子：

```java
class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.print("i = " + i + ", j = " + j);
        j = 39;
    }
    
    private static int x1 = 
        printInit("static Insect.x1 initialized");
    
    private int y1 =
        printInit("Insect.y1 initialized");
    
    static int printInit(String s) {
        System.out.print(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.print("k = " + k);
        System.out.print("j = " + j);
    }
    private static int x2 = 
        printInit("static Beetle.x2 initialized");
    
    public static void main(String[] args) {
        System.out.print("Beetle constructor");
        Beetle b = new Beetle();
    }
}
```

输出结果

```java
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
Insect.y1 initialized
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
```

在Beetle上运行Java时，第一件事情就是试图访问**Beetle.main()**（程序入口静态方法）,于是加载器开始启动并找出Beetle类的编译代码（在名为Beetle.class的文件中）。在对它进行加载的过程中，编译器注意到它有一个基类，于是继续进行加载。不管是否打算产生改基类的对象，都会发生（尝试将对象创建代码注释掉，以证明这一点）。

如果基类还有其自身的基类，那么第二个基类就会被加载，以此类推。接下来，根基类中的static初始化（在此例中为Insect）即会被执行，任何是子类。这种方式很重要，因为子类的static初始化可能会依赖基类成员。

至此，类已加载完成，就可以创建对象。首先，对象中所以的基本类型都会被设置默认值，对象引用被设为null－这是通过对象内存设为二进制零值生成的。任何，基类的构造器会被调用。在本例中，它是自动调用的，但也可以用super来指定堆基类构造方法调用。类构造方法和子类的构造方法一样。在基类构造方法中，实例变量按其次序被初始化。

## 总结

继承和组合都能从现有类型生成新类型。组合一般是将现有类型作为新类型底层实现的一部分来加以复用，而继承复用的是接口。

在使用继承时，由于子类具有基类的方法，因此它可以向上转型为基类，这对多态来讲很重要。

尽管某些对象编程堆继承极力强调，但在开始设计时，一般优先选择使用组合（或者使用代理），只在必要时才使用继承，因为值更具灵活性。此外，通过堆成员类型使用继承技术的添加技巧，可以在运行时改变那些成员对象的类型和行为。因此，可以在运行时改变组合而成的对象的行为。

在设计一个系统时，目标应该是找到或者创建某些类其中每个类都有具体的用途，而且不能太大（包含太多功能很难复用），也不能太小（不添加其他功能就无法使用）。如果设计变得过于复杂，通过拆分现有类部分功能。一般一个类只做一件事情。

设计一个系统时，一个意识到程序开发是增量过程。程序开发依赖实验，可以尽己所能发现。将项目视为一种有机的，进化的生命体去培养。继承和组合是面向对象编程中是实验最基本的两个工具。

