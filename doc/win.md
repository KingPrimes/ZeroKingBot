注意事项
---
---

- **请您务必下载最新的版本，因为其它的版本可能有意想不到的 Bug 或 错误**
- **放置 ZeroKingBot.jar 的文件夹路径不可以有 空格 不可以有 中文**
- 例如：
    - Program Files 文件夹 放到这个文件夹里是不可以的
    - <font color="red">会出现Windows 找不到 xxxx. 请确定文件名是否正确后，再试一次。</font>
  
详细部署
---
---

- 如果您没有安装 **Java** 请您先安装 **Java** 并且配置 **环境变量**
    - 使用搜索引擎 搜索 [Java8](https://www.java.com/zh-CN/) 下载并安装
    - 配置 **Java** 的 [环境变量](https://b23.tv/tnLP86i)
- 如果您安装了 **Java** 并配置完了 **环境变量**
- 那么请回到您放置 **ZeroKingBot.jar** 的**文件夹下**
    - 您可以通过在空白处鼠标右键选择在此处打开 PowerShell 窗口
        - 在窗口中输入 **java -jar ZeroKingBot.jar** 然后按下回车键即可
    - 您可以右键新建文本文档
        - 编辑文本文档，在文档里输入 **java -jar ZeroKingBot.jar** 保存退出
        - **更改文本文档的名字**。再次之前请打开 **查看/文件扩展名**
        - 更名为 **run.bat** 之后启动直接**双击 run.bat 运行**即可
        - 运行之后会自动下载所需的运行文件请稍等片刻……
        - 您需要自行配置gocqhttp文件下的config.yml 不配置也可以在同一局域网下使用手机扫码登录
      
          - 以下是配置config.yml的具体过程：
              - ![](../.github/image/go-cqhttp-up.png)
              - 在这里填写上你用作**机器人的QQ账号与密码。**
              - 注意：**密码需要填写到''中间**
              - 例如：**'123456'**
              - ![](../.github/image/go-cqhttp-ws.png)
              - 更改 **universal**后面的值
              - 更改为： **ws://localhost:8080/ws/shiro**
              - ![](../.github/image/go-cqhttp-lows.png)
          - 之后关闭go-cqhttp窗口
          - 双击 **"go-cqhttp.bat"** 启动，**根据提示操作**。
          - 查看go-cqhttp窗口中是否出现 **已连接到反向服务器** 若出现此提示则说明部署成功了