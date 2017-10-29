package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.MemberInfo;

@Repository
@Transactional
public class MemberInfoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Object list(String hql){
//		String hql = "From MemberInfo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MemberInfo> list = query.list();
		return list;
	}
	
	public void save(MemberInfo memberInfo){
		sessionFactory.getCurrentSession().save(memberInfo);
		sessionFactory.getCurrentSession().flush();
	}
	
	public MemberInfo get(String id){
		MemberInfo mi = (MemberInfo) sessionFactory.getCurrentSession().get(MemberInfo.class, id);
		return mi;
	}
}
