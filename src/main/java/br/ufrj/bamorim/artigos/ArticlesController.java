package br.ufrj.bamorim.artigos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ArticlesController {
    
  @Autowired private ArticleDAO articleDAO;
  
  @RequestMapping(method = RequestMethod.GET)
  public String index(Model model) {
    List<Article> articles = articleDAO.findAllWithKeywords();
    model.addAttribute("articles",articles);
    return "index";
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String createForm(Model model) {
    model.addAttribute("article", new ArticleForm());
    return "create";
  }
  
  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public String edit(@PathVariable("id") Long id, Model model){
    Article article = articleDAO.findById(id);
    model.addAttribute("article", new ArticleForm(article));
    model.addAttribute("id",id);
    return "edit";
  }
  
  @RequestMapping(value="/{id}/", method = RequestMethod.POST)
  public String update(@PathVariable("id") Long id,@ModelAttribute("articleAttribute") ArticleForm articleForm) {
    articleDAO.update(id,articleForm.buildArticle(), articleForm.buildKeywords());
    return "redirect:/";
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String create(@ModelAttribute("articleAttribute") ArticleForm articleForm){
    articleDAO.insert(articleForm.buildArticle(), articleForm.buildKeywords());
    return "redirect:/";
  }
  
  @RequestMapping(method = RequestMethod.POST, value = "/{id}/destroy")
  public String destroy(@PathVariable("id") Long id){
    articleDAO.destroy(id);
    return "redirect:/";
  }
}
