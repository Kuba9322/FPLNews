package pl.sturnusdev.fantasypremierleaguenews.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleDto;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleService;
import pl.sturnusdev.fantasypremierleaguenews.user.UserService;

import java.time.LocalDateTime;

@Controller
public class ArticleManageController {
    private final ArticleService articleService;

    private final UserService userService;

    public ArticleManageController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @GetMapping("admin/dodaj-artykuł")
    public String addArticleForm(Model model){
        ArticleDto article = new ArticleDto();
        model.addAttribute("article", article);
        return "admin/article-form";
    }

    @PostMapping("admin/dodaj-artykuł")
    public String addArticle(ArticleDto article, RedirectAttributes redirectAttributes) {
        article.setCreateTime(LocalDateTime.now());
        article.setModifiedTime(LocalDateTime.now());
        //to correct
        article.setAuthor(userService.findUserByUsername("limak7373").orElseThrow());
        articleService.addArticle(article);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Artykuł \"%s\" został zapisany".formatted(article.getTitle()));
        return "redirect:/admin";
    }
}
