package processor;

import model.Article;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class ArticleProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .setUserAgent(Const.UserAgent.MAC_CHROME);

    @Override
    public void process(Page page) {
        String ARTICLE_PAGE_REGEX = "https://www.jianshu.com/p/.*";
        String HELPERS_PAGE_REGEX = "https://www.jianshu.com/$";

        if (page.getUrl().regex(HELPERS_PAGE_REGEX).match()) {
            List<Selectable> titles = page.getHtml().xpath("//div[@class='content']/a[@class='title']").nodes();
            String regex = "<a class=\"title\".*href=\"(.*)\">(.*)</a>";
            for (Selectable title : titles) {
                String link = title.regex(regex).get();
                page.addTargetRequest(link);
            }
        } else if(page.getUrl().regex(ARTICLE_PAGE_REGEX).match()) {
            Selectable articleHtml = page.getHtml().xpath("/html/body[@class='reader-black-font']/div[@class='note']/div[@class='post']/div[@class='article']");
            Article article = new Article();
            article.title   = articleHtml.xpath("//h1[@class='title']/text()").get();
            article.content = articleHtml.xpath("//div[@class='show-content']/div[@class='show-content-free']/tidyText()").get();
            page.putField(Const.FieldKey.ARTICLE, article);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}