package com.Jaziel.test;

import com.Jaziel.domain.Article;
import com.Jaziel.domain.com.Jaziel.utils.ESUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * @author 王杰
 * @date 2021/5/7 20:30
 */
public class ES {

    // 创建索引
    @Test
    public void test1() throws UnknownHostException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient transportClient = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 创建名称为 index3 的索引
        transportClient.admin().indices().prepareCreate("index3").get();
        // 释放资源
        transportClient.close();
    }

    // 创建映射
    @Test
    public void test2() throws IOException, ExecutionException, InterruptedException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient transportClient = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 添加映射
        /**
         * 格式：
         * "mappings" : {
             "article" : {
                 "dynamic" : "false",
                 "properties" : {
                     "id" : { "type" : "string" },
                     "content" : { "type" : "string" },
                     "author" : { "type" : "string" }
                 }
             }
         }
         */
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("article").startObject("properties").
                startObject("id").field("type", "integer").field("store", "yes").endObject().
                startObject("title").field("type", "string").field("store", "yes").field("analyzer", "ik_smart").endObject().
                startObject("context").field("type", "string").field("store", "yes").field("analyzer", "ik_smart").endObject().
                endObject().endObject().endObject();
        // 创建映射
        PutMappingRequest source = Requests.putMappingRequest("index3").type("article").source(builder);
        transportClient.admin().indices().putMapping(source).get();
        // 释放资源
        transportClient.close();
    }

    // 建立文档
    @Test
    public void test3() throws IOException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient transportClient = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 创建文档内容
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().
                field("id", 1).
                field("title", "ElasticSearch是一个基于Lucene的搜索服务器").
                field("context", "它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便").
                endObject();
        // 建立文档对象
        /**
         * 参数一blog1：表示索引对象
         * 参数二article：类型
         * 参数三1：建立id
         */
        transportClient.prepareIndex("index2", "article", "1").setSource(builder).get();
        // 关闭资源
        transportClient.close();
    }

    // 建立文档(通过实体转json)
    @Test
    public void test4() throws IOException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient transportClient = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 描述 json 数据
        Article article = new Article();
        article.setId(2);
        article.setTitle("我很快乐");
        article.setContext("学习使我快乐，我爱学习！！！");

        ObjectMapper objectMapper = new ObjectMapper();
        // 建立文档对象
        /**
         * 参数一blog1：表示索引对象
         * 参数二article：类型
         * 参数三1：建立id
         */
        transportClient.prepareIndex("index2", "article", article.getId().toString()).
                setSource(objectMapper.writeValueAsString(article).getBytes(), XContentType.JSON).get();
        // 关闭资源
        transportClient.close();
    }

    // 关键词查询
    @Test
    public void termQueryTest() throws UnknownHostException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient client = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 创建搜索条件
        SearchResponse search = client.prepareSearch("index2").setTypes("article").
                setQuery(QueryBuilders.termQuery("context", "搜索")).get();
        // 遍历搜索结果
        SearchHits hits = search.getHits();// 获取命中次数，查询结果有多少对象
        System.out.println("记录数是：" + hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            // 每个查询对象
            SearchHit next = iterator.next();
            // 获取字符串格式打印
            System.out.println(next.getSourceAsString());
            System.out.println(next.getSource().get("title"));
        }
        client.close();
    }

    // 字符串查询
    @Test
    public void termStringTest() throws UnknownHostException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient client = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 创建搜索条件
        SearchResponse search = client.prepareSearch("index2").setTypes("article").
                setQuery(QueryBuilders.queryStringQuery("搜索")).get();
        // 遍历搜索结果
        SearchHits hits = search.getHits();// 获取命中次数，查询结果有多少对象
        System.out.println("记录数是：" + hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            // 每个查询对象
            SearchHit next = iterator.next();
            // 获取字符串格式打印
            System.out.println(next.getSourceAsString());
            System.out.println(next.getSource().get("title"));
        }
        client.close();
    }

    // Id 查询
    @Test
    public void termIdTest() throws UnknownHostException {
        //client对象为TransportClient对象
        TransportClient client = ESUtil.getTransportClient();
        SearchResponse search = client.prepareSearch("index2").setTypes("article").setQuery(QueryBuilders.idsQuery().addIds("1")).get();
        // 遍历搜索结果
        SearchHits hits = search.getHits();// 获取命中次数，查询结果有多少对象
        System.out.println("记录数是：" + hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            // 每个查询对象
            SearchHit next = iterator.next();
            // 获取字符串格式打印
            System.out.println(next.getSourceAsString());
            System.out.println(next.getSource().get("title"));
        }
        client.close();
    }

    // 批量建立文档
    @Test
    public void test6() throws IOException {
        // 构建 client 连接对象
        TransportClient client = ESUtil.getTransportClient();
        // 描述 json 数据
        Article article = new Article();
        article.setTitle("我很快乐");
        article.setContext("学习使我快乐，我爱学习！！！");

        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 2; i <= 10; i++){
            article.setId(i);
            // 建立文档对象
            /**
             * 参数一blog1：表示索引对象
             * 参数二article：类型
             * 参数三1：建立id
             */
            client.prepareIndex("index5", "article", article.getId().toString()).
                    setSource(objectMapper.writeValueAsString(article).getBytes(), XContentType.JSON).get();
        }

        // 关闭资源
        client.close();
    }

    // 分页查询
    @Test
    public void test7(){
        //client对象为TransportClient对象
        TransportClient client = ESUtil.getTransportClient();

        SearchRequestBuilder search = client.prepareSearch("index2").setTypes("article").
                setQuery(QueryBuilders.matchAllQuery());//默认每页10条记录
        // 查询第2页数据，每页20条
        //setFrom()：从第几条开始检索，默认是0。
        //setSize():每页最多显示的记录数。
        SearchResponse searchResponse = search.setFrom(0).setSize(5).get();
        // 遍历搜索结果
        SearchHits hits = searchResponse.getHits();// 获取命中次数，查询结果有多少对象
        System.out.println("记录数是：" + hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            // 每个查询对象
            SearchHit next = iterator.next();
            // 获取字符串格式打印
            System.out.println(next.getSourceAsString());
            System.out.println(next.getSource().get("id"));
            System.out.println(next.getSource().get("title"));
            System.out.println(next.getSource().get("context"));
            System.out.println("------------------------------------");
        }
        client.close();
    }

    // 查询结果高亮
    @Test
    public void test8(){
        //client对象为TransportClient对象
        TransportClient client = ESUtil.getTransportClient();

        SearchRequestBuilder search = client.prepareSearch("index2").setTypes("article").
                setQuery(QueryBuilders.matchAllQuery());//默认每页10条记录

        //设置高亮数据
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font style='color:red'>").postTags("</font>");
        highlightBuilder.field("title");
        search.highlighter(highlightBuilder);

        // 查询第2页数据，每页20条
        //setFrom()：从第几条开始检索，默认是0。
        //setSize():每页最多显示的记录数。
        SearchResponse searchResponse = search.setFrom(0).setSize(5).get();
        // 遍历搜索结果
        SearchHits hits = searchResponse.getHits();// 获取命中次数，查询结果有多少对象
        System.out.println("记录数是：" + hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            // 每个查询对象
            SearchHit next = iterator.next();
            // 获取字符串格式打印
            System.out.println(next.getSourceAsString());
            System.out.println(next.getHighlightFields());
            System.out.println(next.getSource().get("id"));
            System.out.println(next.getSource().get("title"));
            System.out.println(next.getSource().get("context"));
            System.out.println("------------------------------------");
        }
        client.close();
    }
}
