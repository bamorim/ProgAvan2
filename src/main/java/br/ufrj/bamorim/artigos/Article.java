package br.ufrj.bamorim.artigos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="articles_seq" ,sequenceName="articles_id_seq", allocationSize=1 ,initialValue=1)   
@Table(name = "articles")
public class Article {
    @Id @GeneratedValue(generator="articles_seq", strategy=GenerationType.SEQUENCE) private long id;
    private String titulo;
    private String autor;
    private String veiculo;
    private Date data;
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "article_keywords", joinColumns = {
        @JoinColumn(name = "article_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
        @JoinColumn(name = "keyword_id", nullable = false, updatable = false)
    })
    private Set<Keyword> keywords = new HashSet<Keyword>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public Set<Keyword> getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }
}
