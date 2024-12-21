# 服务注册发现

- Eureka (废弃)
- Consul (正在使用)
- Etcd (Go语言)
- Nacos (SpringCloudAlibaba)

# 服务调用与负载均衡

- Ribbon (废弃)
- OpenFeign (推荐使用)
- LoadBalancer (推荐使用)
- Dubbo (非HTTP协议内部RPC通讯调用)

# 分布式事务

- Seata (主流)
- LCN
- Hmily

# 服务熔断与服务降级

- Hystrix (废弃)
- Circuit Breaker (官方推荐)
  - Resilience4J (Java版本实现)
  - Spring Retry
- Sentinel (Alibaba 主流使用)

# 链路追踪

- Sleuth + Zipkin (不再推荐，可能会被新框架替代)
- Micrometer Tracing (推荐)

# 服务网关

- Zuul (废弃)
- Gate Way (推荐)

# 分布式配置

- Config + Bus (废弃)
- Consul (也可以用来实现分布式配置)
- Nacos (主流)
- Apollo (携程)

注意：

已废弃的组件在老项目中可能还在使用，如果要维护老项目，还是要了解已废弃的组件

