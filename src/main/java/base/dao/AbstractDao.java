package base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import base.entity.BaseEntity;
import dto.PageDto;
import dto.SearchDto;

public class AbstractDao<E extends BaseEntity> extends BaseDao<E> {
	protected Class<E> entityClass;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractDao() {
		Type type = getClass().getGenericSuperclass();
		if (!(type instanceof ParameterizedType)) {
			return;
		}
		try {
			this.entityClass = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		} catch (Exception e) {
		}
	}
	
	@Transactional
	public E saveEntity(E e) {
		return super.save(e);
	}
	
	@Transactional
	public E updateEntity(E e) {
		return super.update(e);
	}
	
	@Transactional
	public E saveOrUpdateEntity(E e) {
		return super.saveOrUpdate(e);
	}
	
	public void deleteEntity(E e) {
		super.delete(e);
	}
	
	public void softDeleteEntity(E e) {
		super.softDelete(e);
	}
	
	public E getEntity(Serializable eid) {
		return super.get(this.entityClass, eid);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findByHqlToString(String hql, Map<String, Object>condition){
		Query q = getSession().createQuery(hql);
		q.setProperties(condition);
		return q.list();
	}
	
	public int findByHqlToCount(String hql, Map<String, Object> condition){
		Query q = getSession().createQuery(hql);
		if(condition != null){
			q.setProperties(condition);
		}
		return ((Long)q.uniqueResult()).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public PageDto<E> findDtoByHql(SearchDto dto, String hql){
		PageDto<E>pageDto = new PageDto<E>();
		String page = dto.getPage();
		String rows = dto.getRows();
		int currentPage = Integer.parseInt((page == null || page == "0") ? "1" : page);
		int pageSize = Integer.parseInt((rows == null || rows == "0") ? "10" : rows);
		Query q = getSession().createQuery(hql).setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize);
		int total = countAll(hql, null).intValue();
		pageDto.setRows(q.list());
		pageDto.setCurrentpage(currentPage);
		pageDto.setPageSize(pageSize);
		pageDto.setTotal(total);
		pageDto.setTotalPage(totalPage(total, pageSize));
		return pageDto;
	}
	
	protected int totalPage(int total, int pagesize) {
		int pagetotal = total / pagesize;
		int othertotal = total % pagesize;
		if (othertotal > 0) pagetotal++;
		return pagetotal;
	}
	
	/**
	 * 查找总条数
	 * 
	 * @param hql
	 * @param condition
	 * @return
	 */
	public Long countAll(String hql, Map<String, Object> condition) {
		if (hql == null) {
			return Long.valueOf(0L);
		}
		if (hql.toLowerCase().indexOf("order by") == -1) {
			hql = "select count(*) " + hql.substring(hql.toLowerCase().indexOf("from"));
		} else {
			hql = "select count(*) "
					+ hql.substring(hql.toLowerCase().indexOf("from"), hql.toLowerCase().indexOf("order by"));
		}
		Query q = getSession().createQuery(hql);
		if ((condition != null) && (condition.size() > 0)) {
			q.setProperties(condition);
		}
		return (Long) q.uniqueResult();
	}
}
