package com.Jaziel.service;

import com.Jaziel.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 王杰
 * @date 2021/5/9 15:47
 */
public interface ArticleService {
    // 保存
    public void save(Article article);
// 删除
    public void delete(Article article);
    // 查询全部
    public Iterable<Article> findAll();
    // 分页查询
    public Page<Article> findAll(Pageable pageable);
    //根据标题查询
    List<Article> findByTitle(String condition);
    //根据标题查询(含分页)
    Page<Article> findByTitle(String condition, Pageable pageable);

}
