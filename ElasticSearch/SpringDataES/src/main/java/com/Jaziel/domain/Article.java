package com.Jaziel.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * @author 王杰
 * @date 2021/5/9 15:22
 */
@Data
//@Document 文档对象 （索引信息、文档类型 ）
@Document(indexName = "index5", type = "article")
public class Article {
    @Id
    @Field(store = true, index = false, type = FieldType.Integer)
    private Integer id;
    @Field(store = true, index = true, analyzer = "ik_smart", type = FieldType.text, searchAnalyzer = "ik_smart")
    private String title;
    @Field(store = true, index = true, analyzer = "ik_smart", type = FieldType.text, searchAnalyzer = "ik_smart")
    private String context;
}
