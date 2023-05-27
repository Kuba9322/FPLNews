package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> findAllArticles() {
        return articleRepository
                .findAll()
                .stream()
                .map(ArticleDtoMapper::map)
                .toList();
    }
    public List<ArticleDto> findFirstArticles(int numberOfArticles) {
        return articleRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Article::getCreateTime))
                .limit(numberOfArticles)
                .map(ArticleDtoMapper::map)
                .toList();
    }
}
