package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import base.dao.AbstractDao;
import entity.MemberInfo;

@Repository
public class MemberDao extends AbstractDao<MemberInfo>{
	@SuppressWarnings("unused")
	public void insert(){
		String sql = "SELECT * FROM t_member where gender = 0";
		List<MemberInfo>list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<MemberInfo>(MemberInfo.class));
//		for (MemberInfo memberInfo : list) {
//			System.out.println();
//		}
	}
	
}
