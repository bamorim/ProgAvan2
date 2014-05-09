package br.ufrj.bamorim.artigos;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class ArticlesController {

    @Autowired
    private ArticleDAO articleDAO;
    
    @Autowired
    ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Article> articles = articleDAO.findAllWithKeywords();
        model.addAttribute("articles", articles);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("article", new ArticleForm());
        return "create";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        Article article = articleDAO.findById(id);
        model.addAttribute("article", new ArticleForm(article));
        model.addAttribute("id", id);
        return "edit";
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, 
            @ModelAttribute("articleAttribute") ArticleForm articleForm,
            @RequestParam("article_file") MultipartFile articleFile) {
        Article article = articleForm.buildArticle();
        prepareArticleToUpload(articleFile,article);
        articleDAO.update(id, article, articleForm.buildKeywords());
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("articleAttribute") ArticleForm articleForm,
            @RequestParam("article_file") MultipartFile articleFile) {
        Article article = articleForm.buildArticle();
        prepareArticleToUpload(articleFile,article);
        articleDAO.insert(article, articleForm.buildKeywords());
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/destroy")
    public String destroy(@PathVariable("id") Long id) {
        articleDAO.destroy(id);
        return "redirect:/";
    }
    
    private boolean prepareArticleToUpload(MultipartFile articleFile, Article article){
        if(articleFile != null){
            UUID fileId = UUID.randomUUID();
            String filename = String.valueOf(fileId) + "." + FilenameUtils.getExtension(articleFile.getOriginalFilename());
            article.setFilename(filename);
            return this.uploadFile(articleFile, filename);
        } else return false;
    }

    private boolean uploadFile(MultipartFile file,String newFilename) {
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream
                    = new BufferedOutputStream(new FileOutputStream(new File(servletContext.getRealPath("WEB-INF/uploads/"+newFilename))));
            stream.write(bytes);
            stream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
