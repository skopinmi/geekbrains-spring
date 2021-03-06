package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Article;
import ru.geekbrains.lesson4.repositories.ArticlesRepository;
import ru.geekbrains.lesson4.services.ArticleService;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private ArticlesRepository articlesRepository;

    @Autowired
    public void setArticlesRepository(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getAll() {
        return articlesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Article get(Long id) {
        return articlesRepository.getOne(id);
    }

    @Override
    @Transactional
    public void save(Article article) {
        articlesRepository.save(article);
    }

}
