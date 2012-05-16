在构建heritrix-1.14.4的扩展时，有两个大问题：
1.heritrix-1.14.4使用maven1作为构建工具，这是非常早的古董了。
2.www.archive.org的maven仓库在国内无法访问。
因此focus-crawler在pom.xml中只定义了heritrix之外的依赖，开发时通过eclipse环境添加对heritrix支持，这样能够正确编译出class文件。
打包时用mvn shade:shade，然后把生成的jar包放入heritrix的lib目录下即可。

添加site记录时要注意同时添加Context记录，添加Context记录时需要特别注意path值。
添加Context一般需要两步：
一是添加context记录，path值使用了某个默认值，如"NOPATH"。
二是更改新记录的path值。
这么做主要的原因是在插入context记录之前不能确定主键值，而path的值中最后一位正好是本记录的主键值。