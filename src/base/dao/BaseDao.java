package base.dao;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import util.ObjectHelper;
import base.entity.BaseEntity;

public class BaseDao <T extends BaseEntity>{
//	Logger logger = LoggerFactory.getLogger(BaseDao.class);

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Resource(name = "jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	public Session getSession(){
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}
	
	public Session  openSession(){
		return this.sessionFactory.openSession();
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplate;
	}
	
	protected T save(T obj){
		if(ObjectHelper.isEmpty(obj.getCreateTime())){
			obj.setCreateTime(new Date());
		}
		obj.setUpdateTime(new Date());
		if(ObjectHelper.isEmpty(obj.getIsDeleted())){
			obj.setIsDeleted(false);
		}
		getSession().save(obj);
		getSession().flush();
		return obj;
	}
	
	protected T saveOrUpdate(T obj){
		if(ObjectHelper.isEmpty(obj.getCreateTime())){
			obj.setCreateTime(new Date());
		}
		obj.setUpdateTime(new Date());
		if(ObjectHelper.isEmpty(obj.getIsDeleted())){
			obj.setIsDeleted(false);
		}
		getSession().saveOrUpdate(obj);
		getSession().flush();
		return obj;
	}
	
	protected T update(T obj)
	  {
	    obj.setUpdateTime(new Date());
	    if(ObjectHelper.isEmpty(obj.getIsDeleted())){
	    	obj.setIsDeleted(Boolean.valueOf(false));
	    }
	    getSession().update(obj);
	    getSession().flush();
	    return obj;
	  }
	
	protected void delete(T obj){
		getSession().delete(obj);
		getSession().flush();
	}
	
	protected void softDelete(T obj){
		obj.setIsDeleted(true);
		obj.setDeleteTime(new Date());
		getSession().update(obj);
		getSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	protected T get(Class<T> entityClass, Serializable id){
		return (T) getSession().get(entityClass, id);
	}
}
