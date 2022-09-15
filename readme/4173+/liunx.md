# Liunx 安装 ZeroKingBot

> 本教程部署环境为 Ubuntu 20.04

## 第一步: 安装 Java

```bash
sudo apt update
sudo apt install openjdk-8-jdk
```

> 通过检查 Java 版本，来验证安装过程：

```bash
java -version
```

> 输出将会像下面这样：

```bash
openjdk version "1.8.0_252"
OpenJDK Runtime Environment (build 1.8.0_252-8u252-b09-1ubuntu1-b09)
OpenJDK 64-Bit Server VM (build 25.252-b09, mixed mode)
```

> 这里我们就成功安装好Java啦

## 第二步: 安装 Redis

```bash
sudo apt update
sudo apt install redis-server
```

> 安装完成后检查服务的状态

```bash
sudo systemctl status redis-server
```

![image](https://user-images.githubusercontent.com/52833112/188269275-737bad27-8dcf-43e8-8c7b-84152189e32b.png)
> 显示运行中就代表安装成功了

## 第三步: 配置 Go-cqhttp

1.在 ZeroKingBot 文件夹内创建 go-cqhttp文件夹

2.在文件夹内下载 [go-cqhttp_linux_amd64.tar.gz](https://github.com/Mrs4s/go-cqhttp/releases/latest)

3.解压 go-cqhttp_linux_amd64.tar.gz

```bash
tar -zxvf go-cqhttp_linux_amd64.tar.gz
```

4.运行go-cqhttp

```bash
./go-cqhttp
```

![image](https://user-images.githubusercontent.com/52833112/188266382-70eb83ae-7100-43ef-bd02-c1e63bd29b18.png)
> 这里选择 3 然后回车
> 选择完之后会让你重启go-cqhttp，在此之前我们先修改一下 config.yml

5.回到 go-cqhttp文件夹
> 编辑config.yml文件

![image](https://user-images.githubusercontent.com/52833112/188266439-63a3c7d3-449b-4f2a-bc6b-8f3ab224e87c.png)
> 在这里填写上你用作机器人的QQ账号与密码。
> 注意：密码需要填写到''中间 例如：'123456'

![image](https://user-images.githubusercontent.com/52833112/188266461-03af123a-b2f1-4f7c-a8b9-fdd8a84d31be.png)
> 更改 universal后面的值
> 更改为： ws://localhost:8080/ws/shiro

![image](https://user-images.githubusercontent.com/52833112/188266483-fc17f7eb-54d1-4ccf-8707-5280662f0105.png)

> 这里我们就配置好Go-cqhttp了

## 第四步: 启动 Go-cqhttp

> 进入go-cqhttp文件夹

```bash
./go-cqhttp
```

根据提示登录你的账号
成功登录上就部署完成了

## 第五步: 部署 ZeroKingBot

1.在你喜欢的地方创建 ZeroKingBot 文件夹

2.在文件夹内下载 [ZeroKingBot.jar](https://github.com/KingPrimes/ZeroKingBot/releases/latest)

3.终端输入 java -jar ZeroKingBot.jar 启动 ZeroKingBot

```bash
java -jar ZeroKingBot.jar
```

![image](https://user-images.githubusercontent.com/52833112/188266172-91bceae4-cb33-43ac-894c-9b415752e3f9.png)
> 这里我们就部署好ZeroKingBot啦

### 注意事项

> **你得先打开 ZeroKingBot, 再打开 Go-cqhttp，并保持运行状态**
