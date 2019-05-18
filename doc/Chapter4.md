# 　控制执行流程

## true和false

所有条件语句都利用条件表达式的真或假来决定执行流程。这里有一个条件表达式的例子。`a == b`。它用条件操作符`==`来判断a的值是否等于b的值。该表达式要么返回｀true｀或者返回`false`。但是Java不允许将数字作为布尔值使用。如果想用数值作为条件判断，可以使用条件表达式转换成布尔值，例如`if(!a)`。

## if-else

`if-else`语句是控制程序流程最基本的形式。其中`else`是可选的。布尔表达式必须产生一个布尔结果。

### if格式

```java
if (Boolean-expression) {
    statement
}
```

### if-else格式

```java
if (Boolean-expression) {
    statement
} else {
    statement
}
```

### if - else if -  else格式

```java
if (Boolean-expression) {
    statement
} else if (Boolean-expression) {
    statement
} else {
    statement
}
```

### 例子

```java
int a = 2, b = 3;
// if
if (a < b) {
    // 执行语句
}

// if-else
if (a < b) {
    // 执行语句
} else {
    // 执行语句
}

// if - else if - else
if (a < b) {
    //　执行语句
} else if (a > b) {
    // 执行语句
} else {
    // 执行语句
}
```

## 迭代

`while`、`do-while`和`for`用来控制循环，有时它们划分为迭代语句 （iteration statement）。循环语句会重复执行，直到控制循环布尔表达式（`Boolean-expression`）不成立则跳出循环体。

### while

每次执行while循环，都会判断条件是否成立，成立执行；不成立跳出while循环。

### while格式

```java
while(Boolean-expression) {
    statement
}
```

### 例子

```java
// 打印0-9的值
int i = 0;
while (i < 10) {
    System.out.println("i = " + i);
    i++;
}
```

### do-while

do-while和while唯一的区别就是do-while中的语句至少会执行一次，即便表达式第一次的条件不成立。而在while循环结构体中，如果条件第一次不成立，那么其中的语句就不会执行。实际引用中，while比do-while更常用一些。

### do-while

```java
do {
    statement
} while (Boolean-expression);
```

### 例子

条件成立情况

```java
// 打印0-9的值
int i = 0;
do {
    System.out.println("i = " + i);
    i++;
} while (i < 10);
```

条件不成立情况

```java
// 只会执行一次，打印10
int i = 10;
do {
    System.out.println("i = " + i);
    i++;
} while (i < 10);
```

### for

for循环可能是经常用到最多的迭代形式。分为四部分，初始化（initialization）表达式、条件表达式（Boolean-expression）、步进（step）以及循环体它们都可以为空。

首先，在第一次迭代之前初始化。随后，进行条件判断，如果条件成立则执行循环体语句；不成立跳出循环。在每次迭代结束时，执行一次步进。

### for格式

```java
for (initialization; Boolean-expression; step) {
    statement
}
```

### 例子

```java
for (int i=0; i<10; i++) {
    System.out.println("i = " + i);
}
```

### 逗号操作符

Java里唯一用到逗号操作符的地方就是for循环的控制表达式。在控制表达式的初始化和步进控制部分，可以使用一系列由逗号分隔的语句；而且那些语句均会独立执行。

通过使用逗号操作符，可以在for语句内定义多个变量，但是它们必须具有相同的类型。

```java
for (int i=1, j=1+10; i<5; i++, j=i*2) {
    System.out.println("i = " + i + " j = " + j);
}
```

### foreach语句

Java　SE5引入一种新的更加简洁的for语句用于数组和容器，即foreach语法，表示不必创建int变量去访问每个元素，foreach自动产生每一项。

### 例子

```java
char[] array = {'A', 'B', 'C', 'D', 'E'};
for(char c : array) {
    System.out.println(c + "");
}foreach不适合的地方
```

对于循环步进整形值，foreach语法将不起作用，除非创建一个int数组。

```java
// 不能使用foreach语法
for (int i = 0; i < 100; i++) {}
```

foreach一般用来遍历读取集合数组中的值，不能在遍历过程中，添加或者删除集合元素。

### return

在Java中多个关键字表示无条件分支。这些关键字包括`return`、`bread`、`continue`和一种与其他语言中类似`goto`的跳转到标号语句的方式。

return关键字有两方面的用途：在方法里返回一个值，另外一方面退出当前方法。

```java
boolean test() {
    int a = 2, b = 3;
    if (a < b) {
        return true;
    } 
    return false;
}

```

如果返回方法`void`的方法中没有return语句，那么在该方法的结尾处会有一个隐式的return。如果一个方法声明它将返回void之外的值，那么必须确保每个条件语句分支都有一个返回值。

### break和continue

在任何迭代语句的主体部分，都可以break和continue控制循环流程。break退出整个循环，不再执行剩余迭代。而continue则是停止执行当前的迭代，然后退回循环起始处，开始执行下一次迭代。

### break例子

```java
 for (int i = 0; i < 10; i++) {
     if (i > 6) {
         break; // i 大于6，退出循环
     }
 }
```

### continue例子

```java
 for (int i = 0; i < 10; i++) {
     if (i % 2 == 0) {
         continue; // i除以２取模等于０，跳出当前的迭代，执行下一次迭代
     }
 }
```

### 臭名昭著的goto

编程语言一开始就有goto关键字。事实上，goto起源于汇编语言的流程控制："若条件A成立，则跳到这里，否则跳到那里"。如果阅读由编译器最终生成的汇编代码，就会发现程序控制里包含了许多跳转。（Java编译器生成它自己的"汇编语言"，但是这些代码是运行在Java虚拟机上，而不是运行在CPU硬件上）。

goto语句在源代码级跳转，这使其招致不好的声誉。若一个程序总是从一个地方跳转到另外一个地方，会导致代码可读性差。自从Edsger Dijkstra发表著名论文《goto considered harmful》（goto有害），众人开始痛斥goto的不是，甚至建议把它从关键字扫地出门。

真正的问题并不在于使用goto，而在于goto的滥用；少数情况下，goto还是组织控制流程的最佳手段。

尽管goto仍然是Java保留关键字，但在语言中并没有使用它；Java没有goto。然而，Java也能完成一下类似跳转的操作，这与break和continue有关，它们其实不是一个跳转，而是中断迭代语句的方法。之所以把它们纳入goto问题中一起讨论，是由于它们使用了相同的机制：标签。

在Java中，标签起作用唯一的地方刚好是在迭代语句之前。在标签和迭代之间置入任何语句都不好。而在迭代之前设置标签唯一的理由是：我们希望在其中嵌套另外一个迭代或者一个switch。这是由于break和continue关键字通常只中断当前循环，若随标签一起使用，它们就会中断循环，到标签所在的地方。



### switch

switch有时也被划归为一种选择语句。switch表达式值只能是整数类型或者char类型。根据整数表达式的值，witch语句可以从一系列代码中选出一段去执行，他的格式如下：

```java
switch(integral-selector) {
    case integral-value1:
        statement;
        break;
    case intgral-value2:
        statement;
        break;
    default:
        statement;
        break;
}
```

其中，integral-selector是一个能产生整数的表达式，`switch`将表达式的结果与每个integral-value（整数值）相比。如果发现相符的，就执行对应的语句。如果没有发现相符的，就执行`default`（默认）语句。

在上面的定义中，每个`case`均以一个`break`结尾，这样可使执行流程跳转至`switch`主体的结尾。这是构建`switch`语句的一种传统的方式，但是`break`是可选的。如果省略`break`，会继续执行后面的`case`语句，直到遇到一个`break`为止。