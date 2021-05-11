### 这个模块是swagger 3.0的配置模块
#### Java版本：JDK 1.8

#### 依赖：

这个依赖放在父项目 `pom.xml` 中
```xml
        <!-- 引入Swagger3依赖 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>
        <!--  这个依赖是为了美化swagger文档，使文档更加符合操作习惯-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <!--在引用时请在maven中央仓库搜索最新版本号-->
            <version>2.0.4</version>
        </dependency>
```
