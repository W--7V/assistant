package dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.dao.AbstractDao;
import entity.MemberInfo;

@Repository
@Transactional
public class MemberInfoDao extends AbstractDao<MemberInfo>{
	
}
