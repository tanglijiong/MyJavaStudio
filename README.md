# MyJavaStudio - Java Web

My Java Studio, some testing code and usage of open-source code, which are tested to verify the functionalities before being used in real projects, or tested for study/investigation.
一些测试代码和开源代码的使用测试，以便在正式项目中使用之前验证功能是否满足要求。

And some customized utilities, encapsulated open-source code. 
另外还有一些小工具、以及对开源代码的封装使用。

## Java and Framework:
- Cache related:
	- A local cache example using ConcurrentHashMap (package: com.xjj.cache.local)
	- Guava Cache: an example for using Guava cache framework, including management web page (refer to: http://blog.csdn.net/clementad/article/details/46491701)
	- Redis: A simple example using spring data redis
- Database related:
	- MyBatis (resource: db.properties, spring/db.xml; com.xjj.dao, com.xjj.mapper)
	- HikariCP connection pool (resource: spring/db.xml)
	- MySQL access
	- SQL Server (2000, version 8) access
- FreeMarker: A simple implementation of freeMarker (refer to: http://blog.csdn.net/clementad/article/details/41862155)
- FTP: A simple FTP client with progress shown
- HTTP Client
- Intercepter: MethodInterceptor
- Log4j 2.x Configuration (refer to: http://blog.csdn.net/clementad/article/details/44625787)
- Math and Format: BigDecimal, NumberFormat
- POI/Excel example
- Spring related:
	- Spring Batch (com.xjj.spring.batch)
	- SpringMVC example
- Timers
- Utilities:
	- ClassPathUtils
	- DateUtils
	- FileAccessUtils
	- RandomUtils
	- RegexUtils
	- StringUtils

## Java Web:
- Example to trigger the web browser to be in Full Screen state.
- HTML Dialogs
- NoCache Filter
- SpringMVC receive Form Data or Query String using Map, MultiValueMap. (refer to: http://blog.csdn.net/clementad/article/details/43955741)
- SpringMVC receive JSON data using Map. (refer to: http://blog.csdn.net/clementad/article/details/43955741)
- Usage of JQuery plug-in: bigautocomplete (test-tool.html) 
