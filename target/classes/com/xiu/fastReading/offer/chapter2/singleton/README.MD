# 面试题2-实现singleton模式

## 题目：设计一个类，只能生成该类的一个实例

### 解法1：只适用于单线程（线程不安全）

由于只能生成一个实例，因此必须把构造函数设为私有函数，以禁止他人创建实例。见 Solution1.java

### 解法2:在多线程中能工作，但效率不高

在实例创建之前需要加锁，保证只有一个线程创建出实例

### 解法3：加同步锁前后2次判断实例是否存在（复杂）

只有在没有创建时需要加锁，如果已经创建出来后，无需加锁，只有第一次创建时，需要加锁，这样效率会高很多
2个if主要了防止，第一个线程获取synchronized锁后，第二线程阻塞在synchronized锁。第一个线程
创建好后，释放sychronized锁，第二个线程被唤醒，获取synchronized锁，如果没有这一层if，还是会重新
创建一个对象，这样就不是单例了，因此需要加一层if，并且创建的对象需要volatile关键字，这样在多个线程中都是可见的。

### 解法4：饿汉模式（推荐，但过早创建实例）

过早创建实例




