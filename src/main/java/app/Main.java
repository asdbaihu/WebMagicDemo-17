package app;

import config.Config;
import org.apache.log4j.BasicConfigurator;
import pipeline.TextFilePipeline;
import processor.ArticleProcessor;
import us.codecraft.webmagic.Spider;

public class Main {
    private static final String HOME_PAGE_URL = "https://www.jianshu.com/";

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Spider.create(new ArticleProcessor())
                .addUrl(HOME_PAGE_URL)
                .addPipeline(new TextFilePipeline())
                .thread(Config.THREAD_NUM)
                .run();
    }
}
