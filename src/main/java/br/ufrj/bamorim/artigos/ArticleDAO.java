package br.ufrj.bamorim.artigos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({"unchecked","rawtypes"})
public class ArticleDAO {	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Article> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List articles = session.createQuery("from Article").list();
        return articles;
    }
    
    @Transactional
    public List<Article> findAllWithKeywords(){
        Session session = sessionFactory.getCurrentSession();
        List articles = session.createQuery("SELECT a from Article a JOIN FETCH a.keywords").list();
        return articles;
    }
}
