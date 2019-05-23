"rende.me" 
多线程


队列
Queue ：一个队列就是一个先进先出的数据结构
Queue和List,Set同一级别，都继承Collection接口。LinkedList实现了Deque（双向队列）接口，因此LinkedList进行插入和删除操作效率更高。
Deque: 是Queue的子接口，双向队列是指该队列的两端的元素既能入队也能出列。如果将Deque限制为只能从一端入队和出队，则可以实现栈的数据结构。栈：遵循先进后出的原则。

双端队列：在头部、尾部进行插入、删除、获取元素，和 Queue类似； 
add(e)\offer(e):将元素追加到队列末尾,若添加成功则返回true。 
remove()\poll():从队首删除并返回该元素。 
element()\peek():返回队首元素，但是不删除 。 

栈：这时入栈、出栈元素都是在 双端队列的头部 进行。 
push(e):入栈。 
pop():出栈。 
peek():返回队首元素，但是不删除 。


