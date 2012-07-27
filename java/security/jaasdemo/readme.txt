运行时切换到bin目录，参数配置如下：
java -Djava.security.manager \
 -Djava.security.auth.login.config==../conf/mylogin.conf \
 -Djava.security.policy==../conf/mylogin.policy cn.jhc.client.MyLogin

下面的参数是提供LoginModule的配置：
-Dlogin.configuration.provider=cn.jhc.MyProvider -Dlogin.config.url.1=../conf/mylogin.conf

build.xml功能还未实现。