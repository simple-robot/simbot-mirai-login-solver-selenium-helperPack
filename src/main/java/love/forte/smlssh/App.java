package love.forte.smlssh;

import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.bot.*;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.Scanner;

/**
 * @author ForteScarlet
 */
@SimbotApplication
public class App {
    private static final Logger logger = LoggerFactory.getLogger("Main-App");
    public static void main(String[] args) {

        Scanner scanReader = new Scanner(System.in);

        String code;
        String password;

        logger.info("#####################################################################");
        logger.info("#                                                                  #");
        logger.info("#  请确保当前为「桌面环境」，且系统默认浏览器为「chrome」。                #");
        logger.info("#  且系统默认浏览器为「chrome」。                                      #");
        logger.info("#  且系统默认浏览器为「chrome」。                                      #");
        logger.info("#  且系统默认浏览器为「CHROME」。                                      #");
        logger.info("#  且系统默认浏览器为「C-H-R-O-M-E」。                                 #");
        logger.info("#  过程中可能会下载部分所需文件，请保持网络流畅。                          #");
        logger.info("#                                                                  #");
        logger.info("#                                                                   #");
        logger.info("#   此工具目前已经失效，请前往参考：                                     #");
        logger.info("# 1. https://github.com/project-mirai/mirai-login-solver-selenium   #");
        logger.info("# 2. https://github.com/simple-robot/TxCaptchaHelper                #");
        logger.info("#                                                                   #");
        logger.info("#                                                                   #");
        logger.info("######################################################################");
        logger.info("请输入需要登陆的账号密码。");
        logger.info("输入您的账号：");
        System.out.print("账号：");

        code = scanReader.nextLine();
        System.out.println("您输入的账号：" + code);

        logger.info("输入您的密码：");
        System.out.print("密码：");

        Console console = System.console();
        if (console != null) {
            password = new String(console.readPassword());
        } else {
            password = scanReader.nextLine();
        }

        if (console != null) {
            logger.info("您输入的密码长度："+ password.length() +", 首位：「" + password.charAt(0) + "」, 末位：「" + password.charAt(password.length() - 1) + "」");
        }

        System.out.println("请输入登录成功后，发送消息提供的账号");
        System.out.println("※ 例如你的大号");
        System.out.println("※ 直接按回车跳过");
        String send = scanReader.nextLine();

        if (send == null || send.trim().isEmpty()) {
            logger.info("未输入提示账号，不发送提示。");
            send = null;
        } else {
            logger.info("成功后的提示账号：" + send);
        }

        scanReader.close();

        // run
        SimbotContext context = SimbotApp.run(App.class, args);

        BotVerifyInfo info = BotVerifyInfos.getInstance(code, password);

        // register.
        BotManager botManager = context.getBotManager();
        botManager.registerBot(info);


        Bot bot = botManager.getBot(code);


        System.out.println("登录账号信息：" + bot.getBotInfo());

        if (send != null) {
            BotSender sender = bot.getSender();
            sender.SENDER.sendPrivateMsg(send, "我好了！");
        }

        System.out.println("登录成功，程序即将结束.");

        System.exit(0);
    }
}
