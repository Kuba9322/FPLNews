package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import pl.sturnusdev.fantasypremierleaguenews.user.UserMapper;

import static pl.sturnusdev.fantasypremierleaguenews.tools.LocalDateTimeToString.localDateTimeToString;

public class ArticleDtoMapper {
    static ArticleDto map(Article article){
        return new ArticleDto(article.getId(),
                article.getTitle(),
                article.getIntroduction(),
                article.getContent(),
                article.getCreateTime(),
                article.getModifiedTime(),
                UserMapper.map(article.getAuthor()));
    }
}
