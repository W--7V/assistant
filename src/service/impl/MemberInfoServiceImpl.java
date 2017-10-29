package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.MemberInfoService;
import util.ObjectHelper;
import dao.MemberInfoDao;
import dto.MemberInfoDto;
import dto.PageDto;
import dto.SearchDto;
import entity.MemberInfo;

@Service("memberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	MemberInfoDao memberInfoDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public PageDto<MemberInfoDto> page(SearchDto dto) throws Exception {
		StringBuffer hql = new StringBuffer("FROM MemberInfo where isDeleted = 0");
		if(ObjectHelper.isNotEmpty(dto.getName())){
			hql.append(" and name like '%" + dto.getName() + "%'");
		}
		if(ObjectHelper.isNotEmpty(dto.getLoginName())){
			hql.append(" and loginName like '%" + dto.getLoginName() + "%'");
		}
		if(ObjectHelper.isNotEmpty(dto.getGender())){
			hql.append(" and gender = " + dto.getGender());
		}
		
		List<MemberInfo>_list = (List<MemberInfo>)memberInfoDao.list(hql.toString());
		List<MemberInfoDto>list = new ArrayList<MemberInfoDto>();
		PageDto<MemberInfoDto> pageDto = new PageDto<MemberInfoDto>();
		for (MemberInfo memberInfo : _list) {
			list.add(new MemberInfoDto(memberInfo));
		}
		pageDto.setRows(list);
		pageDto.setTotal(list.size());
		pageDto.setCurrentpage(1);
		pageDto.setTotalPage(list.size()/10 + 1);
		return pageDto;
	}

	@Override
	public String saveOrUpdate(MemberInfoDto dto) throws Exception {
		MemberInfo mi = null;
		if(dto != null && dto.getId() != null){
			mi = memberInfoDao.get(dto.getId());
		}else{
			mi = new MemberInfo();
		}
		BeanUtils.copyProperties(dto, mi);
		mi.setCreateTime(new Date());
		memberInfoDao.save(mi);
		return mi.getId();
	}

}