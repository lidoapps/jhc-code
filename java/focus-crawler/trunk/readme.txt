在构建heritrix-1.14.4的扩展时，有两个大问题：
1.heritrix-1.14.4使用maven1作为构建工具，这是非常早的古董了。
2.www.archive.org的maven仓库在国内无法访问。
因此focus-crawler在pom.xml中只定义了heritrix之外的依赖，开发时通过eclipse环境添加对heritrix支持，这样能够正确编译出class文件。打包时用mvn jar:jar。