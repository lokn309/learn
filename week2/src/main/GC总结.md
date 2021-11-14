### 1、Serial GC

​		serial GC是一个单线程工作的垃圾收集器。

​		serial收集器用于年轻代，采用mark-copy（标记-复制）算法，其目标是响应速度优先，适用在单CPU环境喜爱的Client模式。

​		serial Old收集器用于老年代，采用mark-sweep-compact（标记-清除-整理）算法，其目的也是响应速度优先，适用于在单线程环境下的Client模式，是CMS的后备预案。

 		Serial收集器不能进行并行的垃圾回收，所以会触发全线暂停（STW），停止所有的应用线程。对于多核CPU的利用率不高。 适用于内存资源受限的环境。

​	 	通过GCLogAnalysis代码的测试，在当堆内存设置为：-Xmx512m、-Xms512m时，年轻代大概发生了10次GC，平均STW时间大概为25毫秒；老年代大概发生了6次GC，平均STW时间大概46毫秒。

​	 	经测试在不同堆内存下，GC发生的频率不一样。随着堆内存的增大，GC的发生频率降低，但是相应的STW时间也增大了。

<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114113033179.png" alt="image-20211114113033179" style="zoom:50%;" />

<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114113522694.png" alt="image-20211114113522694" style="zoom:50%;" />

### <img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114113626169.png" alt="image-20211114113626169" style="zoom:50%;" />	2、Parallel GC

​		Parallel收集器是一个并行收集的多线程收集器，在垃圾回收时也会进行STW操作。

​		Parallel Scavenger收集器作为新生代的垃圾收集器，采用mark-copy（标记-复制）算法，其目标是吞吐量优先，适用于后台运算而不需要太多交互的任务。

​		Parallel Old 收集器作为老年代的垃圾收集器，采用mark-compact（标记-整理）算法，其目标是吞吐量优先，适用于后台运算而不需要太多交互的任务。

​		随着堆内存的增加，GC的频率也随之降低。

<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114145322362.png" alt="image-20211114145322362" style="zoom:50%;" />		<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114145619443.png" alt="image-20211114145619443" style="zoom:50%;" />

### 3、CMS GC

​		CMS 收集器采用的是并发方式收集，作为老年代的垃圾收集器，采用mark-sweep（标记-清理）算法。其目标是响应速度优先。适用于集中在互联网站或B/S系统服务器端上。CMS收集器进行垃圾回收分为四个阶段：初始标记（CMS initial mark）、并发标记（CMS concurrent mark）、重新标记（CMS remark）和并发清理（CMS concurrent sweep），其中初始标记和重新标记也是需要进行STW操作的。

​		CMS GC的年轻代采用的是ParNew收集器。ParNew收集器实质就是Serial收集器的多线程并行版本，除了使用多线程外，其他的参数和Serial收集器一致。ParNew收集器采用mark-copy（标记-复制）算法，其目标是响应速度优先。多CPU环境下时在Server模式下配合CMS进行垃圾回收。

​		随着堆内存的增加，GC频率也相对降低。

 <img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114151005730.png" alt="image-20211114151005730" style="zoom:50%;" />

<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114150818470.png" alt="image-20211114150818470" style="zoom:50%;" />

### 4、G1 GC

​		G1收集器采用的是面向局部收集的设计思路和基于Region的内存布局形式。采用mark-compact+copy（标记-整理-复制）算法。G1不再坚持规定大小以及固定数量的分代区域来进行划分，而是把连续的Java堆划分为多个大小相等的独立区域（region），每个Region区域都可以根据需要扮演新生代的Eden空间、Survive空间或者老年代空间，同时Region还一个特色的区域Humongous区域，用于专门存储大对象。

​		G1是根据那一块的垃圾最多就优先清理。其最主要的目标就是将STW停顿时间和分布，变成可预期且可配置的。适用于服务端的垃圾收集。不过需要注意的是，

<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114153755090.png" alt="image-20211114153755090" style="zoom:50%;" />在某些情况下G1触发了Full GC，这时G1会退化使用Serial收集器来完成垃圾清理工作。

​		随着堆内存的增大，GC频率降低。

​	<img src="/Users/lokn/Library/Application Support/typora-user-images/image-20211114153700850.png" alt="image-20211114153700850" style="zoom:50%;" />

​	

