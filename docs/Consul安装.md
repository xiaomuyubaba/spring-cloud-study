1. 官网下载：https://developer.hashicorp.com/consul/install?product_intent=consul
2. 在windows下无需安装，解压后就是要给 `.exe` 可执行文件
3. 运行 `Consul Agent`：`consul agent -dev`
    > 为了简单起见，我们现在是以开发模式启动Consul代理。 这种模式对于快速简单地启动单节点Consul环境非常有用。 它并不打算在生产中使用，因为它不会持续任何状态
    >
    > Consul安装之后，代理必须运行。 代理可以在服务器或客户端模式下运行。 每个数据中心都必须至少有一台服务器，但推荐使用3台或5台服务器。 一个单一的服务器部署是非常不推荐的，因为在故障情况下数据丢失是不可避免的。
4. 在另一个终端运行 `consul members`，可以看到Consul集群的成员。 应该只看到一个成员（你自己）