package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.sturnusdev.fantasypremierleaguenews.storage.FileStorageService;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;
import pl.sturnusdev.fantasypremierleaguenews.user.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;
    private UserService userService;
    private final FileStorageService fileStorageService;

    public ArticleService(ArticleRepository articleRepository, UserService userService, FileStorageService fileStorageService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
        this.fileStorageService = fileStorageService;
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
    public void addArticle(ArticleSaveDto articleSaveDto){
        Article articleToSave = new Article();
        articleToSave.setTitle(articleSaveDto.getTitle());
        articleToSave.setIntroduction(articleSaveDto.getIntroduction());
        articleToSave.setContent(articleSaveDto.getContent());
        articleToSave.setCreateTime(articleSaveDto.getCreateTime());
        articleToSave.setModifiedTime(articleSaveDto.getModifiedTime());
        articleToSave.setAuthor(userService.findUserByUserDto(articleSaveDto.getAuthor()).orElseThrow());
        if (articleSaveDto.getImage() != null){
            String savedFileName = fileStorageService.saveImage(articleSaveDto.getImage());
            articleToSave.setImage(savedFileName);
        }
        articleRepository.save(articleToSave);
    }
}
