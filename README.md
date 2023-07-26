# Prediction_Dispatcher_For_MedicineAI
本项目由JDK1.8编写

需要java环境以及maven包管理器（测试通过版本:JDK 1.8.0, maven 3.9.3）

application.yml为通用配置文件，每次构建均需要确认其中信息；application-dev.yml为开发环境配置文件，application-web.yml为上线环境配置文件，后续按需修改

需要编译成war包，在服务器上部署，并在部署后上传目标py文件到静态文件目录

python文件用print输出目标结果，java会接受并给前端返回json，前端UI还有很大设计优化空间


version-0.0.1 230722
done:
实现了上传文件并分析序列的功能

next：
实现文本输入序列的方法
实现UI显示预测结果而不是直接显示Json


version-0.1.1 230724
fix：
修复了在某些网页环境下静态目录失效的问题
done：
新增了服务器ROOT首页，以便适配全新搭建的服务器


version0.2.0 230725
done：
重构了后端，更容易扩展

next：完善显示格式，实现输入序列提交方法


version-0.99 230726
done：
完善了上传文件和输入序列两种提交方法
完善了错误码和错误信息等
在web服务器测试通过
使用chatGPT改善了前端显示

next：
完善404网页
改善UI美观度
