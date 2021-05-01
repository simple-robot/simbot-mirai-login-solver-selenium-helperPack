# simbot-mirai-login-solver-selenium-helperPack

mirai2.0-M2更新后，增加了对「滑动验证」的支持，这是一个很好的事情。但是美中不足，支持滑动验证所需要的依赖经常会遇到难以下载的问题，且此功能在springboot环境下也经常存在各种问题。

此项目为一个预先提供的，拥有「滑动验证」模块的一个极简simbot-mirai工程。

## 获取
通过 [github releases](https://github.com/simple-robot/simbot-mirai-login-solver-selenium-helperPack/releases) 下载最新的编译jar文件，或者clone此项目自行编译打包。

## 使用

此项目提供编译后的可执行jar包，你只需要在桌面环境（推荐windows）下执行此jar包：
```
java -jar simbot-mirai-login-solver-selenium-helper.jar 
```

执行后，根据控制台提示信息填入所需的账号信息，并根据mirai提供的提示完成滑动验证操作。

如果验证成功，在最后会展示登录后的bot信息并终止当前程序，不出意外的话，你的bot就可以在simbot下进行使用了。

如果出现了错误且最终无法登录，请保留完整错误信息并通过[github issue](https://github.com/simple-robot/simbot-mirai-login-solver-selenium-helperPack/issues) 进行反馈。
