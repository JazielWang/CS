package com.Jaziel.dao;

import com.Jaziel.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 王杰
 * @date 2021/5/9 15:23
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    //根据标题查询
    List<Article> findByTitle(String condition);

    //根据标题查询(含分页)
    Page<Article> findByTitle(String condition, Pageable pageable);
}
