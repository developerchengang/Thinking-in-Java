# 访问权限控制

访问权限从大到小依次为：**public**，**protected**，包访问权限（没有关键字）和**private**。设计类库，尽可能将方法都定义为**private**，仅对外公开必要的方法。

## 包

包内包括一组类，它们在由同一命名空间中并组织在一起。

例如，在Java的标准工具库，它被组织在**java.util**命名空间中。**java.util**有个**ArrayList**类，它的全名**java.util.ArrayList**。

```java
public class FullQualification {
    java.util.ArrayList list = new java.util.ArrayList();
}
```

这样程序会变得很冗长，可以使用**import**关键字。

```java
import java.util.ArrayList;

public class FullQualification {
    ArrayList list = new ArrayList();
}
```

如果想导入**java.util**下所有类，只需要使用`import java.util.*`。

使用包名是为了防止名称冲突。例如你编写了一个**Stack**类，而你的项目又导入了其他类库也存在一个类叫**Stack**。假设，没有命名空间，那么编译器就不能区分调用的那个类。

如果创建一个类没有指定包名：即未命名包，或称为默认包。

编写一个Java源文件时，此文件通常被称为编译单元（有时也被称为转译单元）。每个Java源文件后缀名必须是`.java`，每个Java源文件可以有多个类，但只能有一个**public**类。

### 组织代码

当编译一个.java文件时，在.java文件中的每个类都会生成一个文件，生成的文件的名称与.java文件中的每个类名称相同，只是文件后缀名**.class**。Java可运行程序是一组可以打包并压缩为一个Java文档文件（JAR，使用Java的jar文档生成器）的.class文件．Java解释器负责这些文件的查找、装载和解释。

类库实际上是一组类文件。如果希望这些构件（每个都有自己独立的.java和.class文件）从属同一群组，可以使用关键字**package**。

如果使用**package**语句，它必须是文件中除注释以外的第一句程序代码，包的命名规则全部使用小写字母。在文件起始处写：

```java
package access;
```

表示在声明一个名为**access**的包。如果其他包需要引用access包下面的任意类，通过**import**关键字指定access包名。

```java
package access;

public class Person {}
```

假设有另外一个包为**user**需要访问**access**包下面的**Person**类

```java
package user;

import access.Person;

public class Test {
    Person person = new Person();
}
```

###　创建独一无二的包名

为了避免包名冲突。通用的做法是通过域名反顺序起名。如果没有域名一般建议使用自己的名字命名。

Java解释器的运行过程：首先，找到环境变量**CLASSPATH**，CLASSPATH包含一个或者多个目录，用来查找.class文件的根目录。然后从根目录开始，解释器获取包名并将每个**.**替换成反斜杠，从CLASSPATH根目录中生成一个路径名称（如果，package foo.bar.baz 就变成为foo\bar\baz或者foo/bar/baz，取决于操作系统）。得到的路径会与CLASSPATH中的各个不同的项相连接，解释器在这些目录中查找与你所创建的类名相关的.class文件。（解释器还会去查找某些涉及Java解释器所在位置的标准目录）。

假设我的个人网站**doumiaotech.com**为例。把它的顺序倒过来，并全部转换为小写，**com.doumiaotech**。如果有多个项目可以进一步细分。如下：

```java
package com.doumiaotech.simple

public class Vector {}
```

在我的电脑系统目录显示如下：

```java
D:worksapce\com\doumiaotech\simple
```

环境变量**CLASSPATH**

CLASSPATH=.;D:\worksapce

但是使用JAR文件时会有点不同，必须在CLASSPATH中指定JAR文件的实际名称。因此，对于一个名为grape.jar的JAR文件，**CLASSPATH**

CLASSPATH=.;D:\flavors\grape.jar

如果在同一个类同时导入两个包，这两个包都存在一个相同的类名。比如**java.util**和**com.doumiaotech.simaple**都包含一个Vector类，如果我们在类中调用Vector类，这样存在潜在冲突，因为编译器不能确定到底调用的是哪个Vector类，于是提示编译错误。为了解决冲突一般显示调用。如下：

```java
import java.util.*;
import com.doumiaotech.simple.*;

// import java.util.Vector; // 解决方法1

public class Test {
    Vector vector = new Vector();　// 编译错误，未显示指定
    java.util.Vector vector = new Vector(); // 解决方法2，显示调用java.util包下面的Vector类
}
```

### 定制工具库

定义自己的工具库来减少或者消除重复的程序代码。例如，我们经常用到的`System.out.print()`每次调用都要写`System.out`非常繁琐。为此我们可以调用一个工具类消除样板代码。

```java
import java.io.PrintStream;

public class Print {
    public static void println(Object obj) {
        System.out.println(obj);
    }
    
    public static void println() {
        System.out.println();
    }
    
     public static void print(Object obj) {
        System.out.print(obj);
    }
    
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
```

### 对包的建议

包名必须与文件结构一致。类的包名应该和文件结构保持一致，这一条虽然不是必须的。哪怕类名指定与其文件结构不一致编译IDE一般会报错，但还是可以编译成功并且运行。

## Java访问权限修饰符

**public**、**protected**、**private**这几个访问修饰符可以用来修饰类、成员、方法。每个访问权限修饰符仅控制它所修饰特定定义的访问权。

### 包访问修饰符

#### public

只要修饰为public整个项目都可以访问。假设定义了一个dessert包：

```java
package access.dessert;

public class Cookie {
    public Cookie() {}
    void bite() {}
}
```

现在创建一个调用Cookie的程序：

```java
package access;

public class Dinner {
    Cookie cookie = new Cookie();
    bookie.bite(); // 不能访问
}
```

可以创建一个Cookie对象，因为他的构造方法是public修饰符。但是，由于bite()类没有指定修饰符所以是默认修饰符，只能是在dessert包下创建的Cookie对象才能访问。

#### 默认修饰符

如果没有指定任何访问修饰符默认访问是包级别（有时也称为friendly），也就是说可以在包内的其他类都可以访问它。先来看一段代码：

```java
// access文件目录下的Cake.java。注意没有指定包名

class Cake {
    public static void main(String[] args) {
        Pie s = new Pie();
        x.f();
    }
}
```

第二个处于相同目录的类：

```java
// access文件目录下的Pie.java。注意没有指定包名

class Pie {
    void f() {
        System.out.print("Pie.f()");
    }
}
```

通过编译运行该段代码是没有问题的。注意最好是通过命令手动编译，不要借助IDE，要不然可能导致报错。Cake可以访问Pie类的f方法原因是它们同处于相同的目录并且没有给自己指定任何包名。Java将这样的文件自动看作是隶属于该目录的默认包，于是它们为该目录中所有其他的文件都提供了包访问权限。

#### private

除了类本身任何其他类都不能访问该类被修饰为**private**类和方法。如果类本身也是**private**那么它也不能被其他类访问。好的做法是尽量隐藏技术细节，这样利于修改。默认做法是将所有不需要对外公开的成员和方法都修饰为**private**，而类默认不指定任何访问修饰符只供包访问。

此次有一个使用**private**的示例。

```java
class Sundae {
    private Sundae {}
    static Sundae makeASundae() {
        return new Sundae();
    }
}

public class IceCream {
    // Sundae x = new Sundae(); // 编译报错
    Sundae x = Sundae.makeASundae();
}
```

这是一个说明private用武之地的示例：可以控制如何创建对象，并且阻止其他调用者直接访问构造方法。另外通过该例子还说明该类不能被其他类继承。

#### protected

如果某个类继承了另外一个类，那么子类可以访问父类除了**private**任何成员和方法（当然不是子类也能访问非私有的成员和方法）。如果父类的成员和方法只想被子类访问就需要用到修饰**protected**并且，被**protected**修饰的成员和方法，父类可以和子类不属于同一个包。**protected**也提供包访问权限，也就是说，相同包内的其他类可以访问**protected**元素。

回顾一下先前的例子Cookie类。假设ChocolateChip类继承了Cookie类（该类存放在access包名下），那么ChocolateChip也继承了bite方法。但是由于bite方法是包访问权限而且位于另外一个包内，所以ChocolateChip是无法使用它的。当然，可以把它指定为public，但是这样做所有的类都拥有了访问权限。如果我们将bite方法修改如下：

```java
package access.dessert;

public class Cookie {
    public Cookie() {}
    protected void bite() {}
}
```

现在bite方法对所有继承自Cookie的类而言，都是可以使用的。

```java
package access;

public class ChocolateChip extents Cookie {
   public void chomp() {
       bite();
   }
}
```

## 接口和实现

访问权限的控制常被称为是具体实现的封装。把数据可方法包装进类中，以及具体实现的隐藏，共同称为封装。其结果是一个同时带有特征和行为的数据类型。

出于两个重要的原因，需要访问权限控制。第一个原因在类中隐藏具体实现，对外只提供必要的元素，从而避免外部破坏内部数据结构。第二个原因，即将接口和具体实现进行分离，利于修改非public修饰符元素，避免破坏外部调用端代码。

为了清晰起见，可以采用一种将public成员放在开头，后面跟着protected，包访问权限和private成员的方式创建类。这样做的好处就是使用者可以从头读对他们而言最重要的部分。

## 类的访问权限

访问修饰符也可以用在类上，为了控制类的访问权限，访问修饰符必须出现在关键字**class**前面。因此可以像下面这样声明：

```java
package access;

public class Widget {}
```

1. 每个（编译单元）文件只能有一个public类。如果在某个文件**.java**中存在一个以上的public类，编译器就会报错。

2. public类的名称必须完全和文件名相同，包括大小写。
3. 虽然不是很常见，.java文件可以完全没有public类。在这种情况下，可以随意堆文件命名（尽量不要这么做，会使得阅读和维护代码的人产生混淆）。

请注意，类不可以是private的（这样除了类本身之外，其他任何类都不可以访问它）。也不可以是protected。所以对类的访问权限只有两种选择：包访问权限和public。如果不希望其他类对该类拥有访问权限，可以把所以的构造方法指定为private，从而阻止创建该类的对象。但是有一个例外，就是你在该类的static成员内部可以创建。如下示例：

## 总结

无论在什么样的关系之中，设立一些为各个成员所遵守的界限是很重要的。假设你是类库的设计者，如果不制定规则，客户端程序员就可以对类的所以成员任意修改，其中某些元素可能是你不希望被修改的。这样就会导致上面提到的破坏代码的内部结构出现异常。

控制堆成员的访问权限有两个原因。第一为了防止外部对程序内部的破坏，这些部分堆类内部的操作是必要的，但是它们并不属于对外开放的接口。因此，将不对外开放的方法和成员指定为private。对客户端程序员而言也是一种服务。他们可以很清楚知道哪些是重要的，简化对类的理解。

第二个原因，也是最重要的原因，能让类库的设计者更好的更改类的内部结构，不必担心修改会堆客户端程序员产生重大影响。例如，最初可能以某种方式创建一个类，后来发现有更好的方式提高运行速度。如果接口和实现被明确地隔离加以保护，那么实现就会变的简单，而不必强制客户端程序员重写代码。

类的公共接口是客户端程序员真正关心的，所以在类的设计过程中决定哪些对于公开非常重要。如果，最初对外公开了非必要的接口一旦外部使用了，有可能导致程序异常，也很难维护。