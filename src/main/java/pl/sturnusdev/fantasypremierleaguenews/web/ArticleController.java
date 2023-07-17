package pl.sturnusdev.fantasypremierleaguenews.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleDto;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleService;

import java.util.Optional;

@Controller
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/news/{id}")
    public String getArticle(@PathVariable long id, Model model){
        Optional<ArticleDto> articleOptional = articleService.findArticleById(id);
        articleOptional.ifPresent(article -> model.addAttribute("article", article));
        return "article";
    }
}
