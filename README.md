# Prediction_Dispatcher_For_MedicineAI  

  
### 本项目由JDK1.8编写

### 需要java环境以及maven包管理器（测试通过版本:JDK 1.8.0, maven 3.9.3）  

### application.yml为通用配置文件，每次构建均需要确认其中信息；application-dev.yml为开发环境配置文件，application-web.yml为上线环境配置文件，后续按需修改  

### 需要编译成war包，在服务器上部署，可以直接在静态目录python文件夹下放入py文件后构建，也可以在部署后上传目标py文件到静态文件目录，注意模块名需要和application.yml设置的保持一致 

### python文件用print输出目标结果，java会接受结果并给前端返回json，前端UI还有很大设计优化空间  

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
## next：  
1. 完善404网页    
2. 改善UI美观度  
  
