# Prediction_Dispatcher_For_MedicineAI  

  
### 本项目由JDK1.8编写

### 需要java环境以及maven包管理器（测试通过版本:JDK 1.8.0, maven 3.9.3）  

### application.yml为通用配置文件，每次构建均需要确认其中信息；application-dev.yml为开发环境配置文件，application-web.yml为上线环境配置文件，后续按需修改  

### 需要编译成war包，在服务器上部署，可以直接在静态目录python文件夹下放入py文件后构建，也可以在部署后上传目标py文件到private文件目录，注意模块名需要和application.yml设置的保持一致 

### python文件用print输出目标结果，java会接受结果并给前端返回json，前端UI还有很大设计优化空间

### 如用户有上传文件，则文件会自动记录到/var/cache/tomcat9/web目录下（Tomcat8及以前视情况而定）

##    
## version-0.0.1 230722  
### done:  
1. 实现了上传文件并分析序列的功能   
### next：  
1. 实现文本输入序列的方法  
2. 实现UI显示预测结果而不是直接显示Json  

##  
## version-0.1.1 230724  
### fix:  
1. 修复了在某些网页环境下静态目录失效的问题  
### done：  
1. 新增了服务器ROOT首页，以便适配全新搭建的服务器  

##  
## version-0.2.0 230725  
### done：  
1. 重构了后端，更容易扩展
2. 完善显示格式，实现输入序列提交方法  
### fix：
1. 设置一定的数据校验判断  

##  
## version-0.9.9 230726  
### done：  
1. 完善了错误码和错误信息等  
2. 在web服务器测试通过  
3. 使用chatGPT改善了前端显示
4. 添加了smiles序列校验
### next：  
1. 完善404网页    
2. 改善UI美观度
3. 完善日志系统
4. 某些静态文件私密性改善

##
## version-1.0.0 230727
### done:
1. 花了亿点点力气，提升了一点点静态网站页面，应该勉强可以上线了
2. 日志基本设定好，不用担心冗余了
3. 改善静态资源文件私密性，py文件无法从前端直接访问了
### next:
1. 继续改善前端页面美观度
2. 完善网站拓扑结构，比如自定义404页面
3. 多模型上线，可以把大家的模型都弄上去
4. 用户登录系统，组员亦可从网页上上线自己的模型（涉及前端数据库事务序列化等等业务逻辑，工作量有一点大）
5. 使用Zookeeper注册组件
6. 使用Nginx搭建tomcat集群(真的2000并发量都不够？咱们组能做到刚需上万并发量的那一天？)

##
## version-1.0.1 230727
### fix:
1. 修复了服务器写入的Smiles文件会自动上传至仓库的问题
2. 修改了部分注释

##
## version-1.1.0 231205
### fix:
1. 生产环境上线，实现了DTI预测功能

##
## version-1.2.0 231208
### done：
1. 多模型上线
2. 参数，设置，配置分离
3. 部分流水线化，可以使后续上线模型工作量减少
4. 添加了前端部分文字提示
### fix:
1. 部分不合逻辑的bug

##
## version-1.3.0 231209
### done：
1. 自定义了应用内404错误页面

##
## version-1.9.9 231214
### done：
1. 参考华南理工类似项目的前端页面，重构了接口，实现了单页面多靶点预测
2. 新增了在线绘制分子图的数据源
3. 采用了thymeleaf模板技术，将结果页面展示出来
### fix:
1. 错误页面无法正常显示的bug
### next:
1. 执行预测需要时间较长，需要性能优化

##
## version-2.0.0 231215
### done：
1. 绘制分子图和转为base64代码改用JAVA CDK，性能有一定改善
