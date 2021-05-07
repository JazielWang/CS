package com.Jaziel.test;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.analysis.PreBuiltAnalyzerProvider;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 王杰
 * @date 2021/5/7 20:30
 */
public class ES {
    @Test
    public void test1() throws UnknownHostException {
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my‐elasticsearch").build();
        TransportClient transportClient = new PreBuiltTransportClient(build).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 创建名称为 index2 的索引
        transportClient.admin().indices().prepareCreate("index2").get();
        // 释放资源
        transportClient.close();
    }
}
