package com.Jaziel.test;

import com.Jaziel.dao.ArticleRepository;
import com.Jaziel.domain.Article;
import com.Jaziel.service.ArticleService;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.transport.Transport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 王杰
 * @date 2021/5/9 16:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class springDataESTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TransportClient transportClient;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void creatIndex(){
        template.createIndex(Article.class);
        template.putMapping(Article.class);
    }

    @Test
    public void addTest(){
        Article article = new Article();
        Article article1 = new Article();
        article1.setId(7);
        article1.setTitle("SE");
        article1.setContext("spring data se");
        article.setId(6);
        article.setTitle("SpringData ElasticSearch");
        article.setContext("Spring Data为Elasticsearch Elasticsearch项目提供集成搜索引擎");
        articleService.save(article);
        articleService.save(article1);
    }

    @Test
    public void deleteTest(){
        Article article = new Article();
        article.setId(4);

        articleService.delete(article);
    }

    @Test
    public void queryTest(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Article> all = articleService.findAll(pageable);
        for (Article article : all.getContent()) {
            System.out.println(article);
        }
    }

    @Test
    public void findByTitle(){
        List<Article> se = articleService.findByTitle("快乐");
        for (Article article : se) {
            System.out.println(article);
        }
        System.out.println("--------------------------------");
        Pageable pageable = PageRequest.of(0,3);
        Page<Article> title = articleService.findByTitle("快乐", pageable);
        for (Article article : title.getContent()) {
            System.out.println(article);
        }
    }

}
