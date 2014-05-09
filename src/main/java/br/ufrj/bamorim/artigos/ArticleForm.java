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
        article.setAutor(this.getTitulo());
        article.setData(this.getData());
        article.setTitulo(this.getTitulo());
        article.setVeiculo(this.getVeiculo());
        return article;
    }
    
    public List<String> buildKeywords(){
        return KeywordUtils.splitKeywords(keywords);
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the veiculo
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}
