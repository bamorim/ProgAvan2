package br.ufrj.bamorim.artigos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.sql.JoinType;
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
    public List<Article> findAllWithCriteria(List<Criterion> criterions){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.setFetchMode("keywords", FetchMode.SELECT);
        criteria.createAlias("keywords", "kw", JoinType.LEFT_OUTER_JOIN);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        for(Criterion cr : criterions) {
            criteria.add(cr);
        }
        return criteria.list();
    }
    
    @Transactional
    public Article findById(Long id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct a from Article a join fetch a.keywords where a.id=:id");
        query.setParameter("id", id);
        return (Article)query.uniqueResult();
    }
    
    @Transactional
    public void destroy(Long id){
        Session session = sessionFactory.getCurrentSession();
        
        SQLQuery sqlQuery = session.createSQLQuery("delete from article_keywords where article_id=:id");
        sqlQuery.setParameter("id", id);
        
        Query query = session.createQuery("delete from Article where id=:id");
        query.setParameter("id", id);
        
        sqlQuery.executeUpdate();
        query.executeUpdate();
    }
    
    @Transactional
    public void update(Long id, Article article, List<String> keywords){
        Session session = sessionFactory.getCurrentSession();
        
        article.setId(id);
        
        for(String kw : keywords) {
            article.getKeywords().add(this.getOrCreateKeyword(kw));
        }
        
        session.update(article);
    }
    
    @Transactional
    public void insert(Article article, List<String> keywords){
        Session session = sessionFactory.getCurrentSession();

        for(String kw : keywords) {
            article.getKeywords().add(this.getOrCreateKeyword(kw));
        }
        
        session.save(article);
    }
    
    private Keyword getOrCreateKeyword(String kw){
        Session session = sessionFactory.getCurrentSession();
        Keyword keyword;
        Query query = session.createQuery("from Keyword where keyword=:key");
        query.setParameter("key", kw);

        keyword = (Keyword)query.uniqueResult();
        if(keyword == null) {
            keyword = new Keyword();
            keyword.setKeyword(kw);
        }
        return keyword;
    }
}