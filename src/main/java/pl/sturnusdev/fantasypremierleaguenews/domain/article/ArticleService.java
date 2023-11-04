package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;
import pl.sturnusdev.fantasypremierleaguenews.user.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    private UserService userService;

    public ArticleService(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
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

    public Optional<ArticleDto> findArticleById(long id) {
        return articleRepository
                .findById(id)
                .map(ArticleDtoMapper::map);
    }

    public List<ArticleDto> findArticlesByAuthor(UserDto user) {
        return articleRepository
                .findByAuthorId(user.getId())
                .stream()
                .map(ArticleDtoMapper::map)
                .toList();
    }

    @Transactional
    public void addArticle(ArticleDto article){
        Article articleToSave = new Article();
        articleToSave.setTitle(article.getTitle());
        articleToSave.setIntroduction(article.getIntroduction());
        articleToSave.setContent(article.getContent());
        articleToSave.setCreateTime(article.getCreateTime());
        articleToSave.setModifiedTime(article.getModifiedTime());
        articleToSave.setAuthor(userService.findUserByUserDto(article.getAuthor()).orElseThrow());
        articleRepository.save(articleToSave);
    }
}
