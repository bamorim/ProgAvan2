package br.ufrj.bamorim.artigos;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class ArticleForm {
    private String titulo;
    private String autor;
    private String veiculo;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") private Date data;
    
    private String keywords;
    
    public ArticleForm(){}
    
    public ArticleForm(Article article){
        titulo = article.getTitulo();
        autor = article.getAutor();
        veiculo = article.getVeiculo();
        data = article.getData();
        
        LinkedList<String> keywordStrings = new LinkedList<String>();
        for(Keyword keyword : article.getKeywords()) {
            keywordStrings.push(keyword.getKeyword());
        }
        
        keywords = org.springframework.util.StringUtils.collectionToDelimitedString(keywordStrings, ",");
    }

    public Article buildArticle(){
        Article article = new Article();
        article.setAutor(this.getAutor());
        article.setData(this.getData());
        article.setTitulo(this.getTitulo());
        article.setVeiculo(this.getVeiculo());
        return article;
    }
    
    public List<String> buildKeywords(){
        return KeywordUtils.splitKeywords(keywords);
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
