# java-websocket-service
基于Java实现的WS服务

# WebSocket简介
WebSocket协议是RFC6455草案的内容，由IETF发布，于2011年11月。

简单来讲，WebSocket通过HTTP协议实现握手，成功后使用TCP通道建立服务端与客户端全双工通信。

优点：
- 在一次TCP链上可发送多次消息，减少网络链接的开销。
- 全双工通信，适合实时性高、需要服务端主动推送、多人协作的系统。

需要注意，使用nginx代理服务，需要配置WS服务的具体的ip/端口。

# tools
```shell
git add .;git commit -m push;git pull;git push
```

