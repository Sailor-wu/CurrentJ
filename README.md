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

new Thread 的弊端
1.每次都new 新建对象性能差。
2.线程缺乏统一管理，可能无限制新建线程，相互竞争。及可能占用过多的系统资源导致死机或者OOM（内存溢出）
3.缺乏更多功能，如定时执行，定期执行，线程中断。

线程池的好处：
1.重用存在的线程，减少对象创建，消亡的开销，性能较好。
2.可有小控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，便面堵塞。
3.提供定时执行，定期执行，单线程，并发数控制等功能、

Java通过Executors提供四种线程池，分别为：
newCachedThreadPool         创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool          创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool      创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor     创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行



int corePoolSize   要保存在池中的线程的数量，如果他们是空闲状态，除非设置了 allowCoreThreadTimeOut（
        allowCoreThreadTimeOut为true  --》该值为true，则线程池数量最后销毁到0个。
        allowCoreThreadTimeOut为false  ---》销毁机制：超过核心线程数时，而且（超过最大值或者timeout过），就会销毁。）
int maximumPoolSize,                线程池中默认的最大连接数
long keepAliveTime,                 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
TimeUnit unit,                      指定keepAliveTime的事件单位
BlockingQueue<Runnable> workQueue   执行的任务
ThreadFactory threadFactory,        线程工厂

RejectedExecutionHandler            提供了对于拒绝任务的处理的自定方法的机会。



--**************
自定义注解
Java 提供的四种注解，负责创建新的注解
@target
        表示该注解可以用在什么地方，参数有：
        CONSTRUCTOR     构造器
        FIELD           域声明（包括enum实例）
        local_variable  局部变量声明
        method          方法
        package         包
        parameter       参数声明
        type            类、接口(包括注解类型)、 enum声明


@Retention      
        表示需要在什么级别保存改注解信息。可选参数
        source          注解将被编译器丢弃        
        class           注解在class文件中可用，但是会被VM丢弃
        runtime         vm将在运行期间保留注解，因此可以通过反射机制读取注解的信息

@Document
        将注解包含在javaDoc中

@Inherited
        允许子类继承父类中的注解

        