package com.Jaziel.service.impl;

import com.Jaziel.dao.ArticleRepository;
import com.Jaziel.domain.Article;
import com.Jaziel.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王杰
 * @date 2021/5/9 15:48
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public List<Article> findByTitle(String condition) {
        return articleRepository.findByTitle(condition);
    }

    @Override
    public Page<Article> findByTitle(String condition, Pageable pageable) {
        return articleRepository.findByTitle(condition, pageable);
    }
}
