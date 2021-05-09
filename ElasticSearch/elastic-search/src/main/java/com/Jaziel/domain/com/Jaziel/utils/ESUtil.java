package com.Jaziel.domain.com.Jaziel.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 王杰
 * @date 2021/5/9 14:18
 */
public class ESUtil {
    public static TransportClient getTransportClient(){
        // 构建 client 连接对象
        Settings build = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(build).addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
