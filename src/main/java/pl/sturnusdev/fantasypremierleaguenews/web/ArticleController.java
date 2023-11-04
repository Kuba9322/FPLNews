package pl.sturnusdev.fantasypremierleaguenews.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleDto;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.ArticleService;
import pl.sturnusdev.fantasypremierleaguenews.domain.comment.CommentDto;
import pl.sturnusdev.fantasypremierleaguenews.domain.comment.CommentService;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;
import pl.sturnusdev.fantasypremierleaguenews.user.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    private ArticleService articleService;
    private UserService userService;
    private CommentService commentService;

    public ArticleController(ArticleService articleService, UserService userService, CommentService commentService) {
        this.articleService = articleService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/news/{id}")
    public String getArticle(@PathVariable long id, Model model) {
        ArticleDto articleDto = articleService.findArticleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<CommentDto> allCommentsByArticleId = commentService.findAllCommentsByArticleId(id);
        model.addAttribute("article", articleDto);
        model.addAttribute("articleComments", allCommentsByArticleId);
        return "article";
    }

    @GetMapping("/author/{username}")
    public String getArticlesByAuthor(@PathVariable String username, Model model) {
        UserDto user = userService.findUserByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<ArticleDto> articlesByAuthor;
        List<CommentDto> commentsByAuthor;
        articlesByAuthor = articleService.findArticlesByAuthor(user);
        commentsByAuthor = commentService.findAllCommentsByAuthor(user);
        model.addAttribute("author", user);
        model.addAttribute("articles", articlesByAuthor);
        model.addAttribute("userComments", commentsByAuthor);
        return "user-presentation";
    }
}
