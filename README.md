# eng
撸羊毛框架

本框架采用http和driver的方式，获取互联网中洒落的资源。用微小的成本即可捕鱼。
博客地址：https://segmentfault.com/u/seeing_5bdbefbfea520/articles

# 最佳实践
- chrome-example
  切换至项目根目录  
  运行: gradlew chrome-example:test --tests "com.see.enginerring.chrome.example.LoadPageFT.query" -Dspring.config.name=application,mongo-conf,mail-conf -Djasypt.encryptor.password= -Dspring.mail.username=  
  使用chrome驱动打开页面（例： https://shop112990768.taobao.com/ ），进行操作

- baicm-example
  示例：使用比HttpClient效率高百倍的Http/Https组件进行
  
- baicm-example
  visiting
  集成视图应用
  
  
  本系统根据自己每年平均500万行源码的阅读量，6σ标准，总结、创新许多的最佳实践，完全从零开始写起。也欢迎各位开发者、程序员/程序媛、大牛 提出issue & feature
  
  
# Watch a dome &
  - 组件化
      详细资料，请查看（segmentfault.com）相关文章。  -->>  https://segmentfault.com/u/seeing_5bdbefbfea520/articles
  - 采用极其简单的方式集成spring/spring boot进行测试驱动开发
      参考：com.see.enginerring.chrome.example.LoadPageFT
  - 工业化6σ标准，结构化，采用client的方式集成功能组件
  - 等等
  
  欢迎各位提供线报 & fork it
  另有一个**vue**写的前端，由于自己前端水平有限，没有开源。有兴趣的朋友可以联系我
  **sueeing@126.com**
  **suyaqiang**
  
  
  - 都略过：
    10086，新华社，游戏平台，每日优鲜，淘宝联盟，OFO，携程， 趣头条，ICBC，Microsoft ... 
  
  
