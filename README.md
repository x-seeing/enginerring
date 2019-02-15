# enginerring
撸羊毛框架

本框架采用http和chrome driver的方式，获取互联网中洒落的资源。

# Which a dome
- chrome-example
  切换至项目根目录
  运行: gradlew chrome-example:test --tests "com.see.enginerring.chrome.example.LoadPageFT.query" -Dspring.config.name=application,mongo-conf,mail-conf -Djasypt.encryptor.password= -Dspring.mail.username=
  即可使用chrome驱动打开页面（https://shop112990768.taobao.com/），进行牛逼的模拟操作

- baicm-example
  示例：使用比HttpClient效率高百倍的Http/Https组件进行
  
- baicm-example
  visiting -- 望京
  web集成视图应用
  
  
  本框架根据自己每年平均500万行源码的阅读量，总结、创新许多的最佳实践。完全从零开始写起。
  无论对于初级还是高级开发者都有很大的参考意义。也欢迎各位开发者、程序员/程序猿、大牛 提出issue & feature
  
# 最佳实践
  - 利用EJB/spring的思想将web中的用户（User/Principal）提取为组件
      参考：com.see.enginerring.efrost.web.controller.AuthController#principal
      详细资料，请查看（segmentfault.com）我写的文章。  -->>  https://segmentfault.com/u/seeing_5bdbefbfea520/articles
  - 采用极其简单的方式集成spring/spring boot进行功能测试
      参考：com.see.enginerring.chrome.example.LoadPageFT
  - 工业化，结构化的代码质量，采用clieng的方式集成功能组件
  - 等等等
  
  -- 未实践的地方：例如没有增强域模型的功能，命令查询的分离
  
  
  欢迎各位提供线报 & fork it
  另有一个**vue**写的前端，由于自己前端水平有限，没有开源。有兴趣的朋友可以联系我
  **sueeing@126.com**
  **suyaqiang**
  
  
  - 都略过什么？
  趣头条，10086，ICBC, 新华社，游戏平台，电商平台，OFO，携程 ... 
  
  
