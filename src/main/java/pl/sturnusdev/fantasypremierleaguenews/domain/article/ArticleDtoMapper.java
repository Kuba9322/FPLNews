package pl.sturnusdev.fantasypremierleaguenews.domain.article;

public class ArticleDtoMapper {
    static ArticleDto map(Article article){
        return new ArticleDto(article.getId(),
                article.getTitle(),
                article.getIntroduction(),
                article.getContent(),
                article.getCreateTime(),
                article.getModifiedTime(),
                article.getAuthor().getFullName());
    }
}
