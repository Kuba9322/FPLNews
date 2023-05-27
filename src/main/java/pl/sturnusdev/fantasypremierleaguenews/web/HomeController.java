package pl.sturnusdev.fantasypremierleaguenews.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleDto;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleService;

import java.util.List;

@Controller
public class HomeController {

    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ArticleDto> allArticles = articleService.findAllArticles();
        model.addAttribute("heading", "News");
        model.addAttribute("description", "Najświeższe informacje ze świata FANTASY Premier League");
        model.addAttribute("articles", allArticles);
        return "main-page-listing";
    }
}
