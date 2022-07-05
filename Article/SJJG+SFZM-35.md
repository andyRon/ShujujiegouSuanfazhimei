## 35-Trie树：如何实现搜索引擎的搜索关键词提示功能？

搜索引擎的搜索关键词提示功能，我们经常使用。Google、百度等搜索引擎，这个功能肯定辽很多优化，但基本原理还是：**Trie树**。

![](/Users/andyron/myfield/github/ShujujiegouSuanfazhimei/Article/images/SJJG+SFZM-35-01.jpg)

### 什么是“Trie 树”？

Trie树，也叫“**字典树**”，它是一种专门处理**字符串匹配**的数据结构，用来解决在一组字符串集合中快速查找某个字符串的问题。

以例子看看Trie树。

有6个字符串，分别是：how，hi，her，hello，so，see。如何多次查找某个字符串是否在前面的几个字符串中？

一般情况下就是，拿要查找到的字符串依次和6个字符串匹配，这是可行的，但效率比较低下。

先对6个字符串预处理一下，组织成字典树的结构，然后在字典树中匹配查找。**Trie 树的本质，就是利用字符串之间的公共前缀，将重复的前缀合并在一起**。字典树的结构如下：

![](/Users/andyron/myfield/github/ShujujiegouSuanfazhimei/Article/images/SJJG+SFZM-35-02.jpg)

其中，字典树有几个特点：

- 根节点不包含任何信息
- 每个节点表示一个字符串中的一个字符

- 根节点到红色节点的一条路径表示一个字符串（注：红色节点不都是叶子节点）

字典树的具体构造过程：

![](/Users/andyron/myfield/github/ShujujiegouSuanfazhimei/Article/images/SJJG+SFZM-35-03.jpg)

在字典树种查找字符串的过程，就很好理解了，比如查找“her”，先把它分割成三个字符h、e、r，然后从根节点依次匹配：

![](/Users/andyron/myfield/github/ShujujiegouSuanfazhimei/Article/images/SJJG+SFZM-35-04.jpg)



### 如何实现一棵 Trie树？

上面的过程可以分为两步：

1. **将字符串集合构造成Trie树**。
2. **在Trie树中查询一个字符串**。



### Trie 树真的很耗内存吗？





### Trie 树与散列表、红黑树的比较



