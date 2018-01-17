package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.MemberService;
import util.ObjectHelper;
import dao.MemberDao;
import dao.TaskDao;
import dto.MemberInfoDto;
import dto.PageDto;
import dto.SearchDto;
import entity.MemberInfo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	TaskDao taskDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
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
		PageDto<MemberInfo>_pageDto = memberDao.findDtoByHql(dto, hql.toString());
		PageDto<MemberInfoDto> pageDto = new PageDto<MemberInfoDto>();
		List<MemberInfo>_list = _pageDto.getRows();
		List<MemberInfoDto>list = new ArrayList<MemberInfoDto>();
		for (MemberInfo memberInfo : _list) {
			list.add(new MemberInfoDto(memberInfo));
		}
		pageDto.setRows(list);
		pageDto.setPageSize(_pageDto.getPageSize());
		pageDto.setTotal(_pageDto.getTotal());
		pageDto.setTotalPage(_pageDto.getTotalPage());
		return pageDto;
	}

	@Override
	@Transactional
	public String saveOrUpdate(MemberInfoDto dto) throws Exception {
		MemberInfo mi = null;
		if(ObjectHelper.isNotEmpty(dto) && ObjectHelper.isNotEmpty(dto.getId())){
			mi = memberDao.getEntity(dto.getId());
			mi.getTask().get(0).setItemName("update");
		}else{
			mi = new MemberInfo();
		}
		BeanUtils.copyProperties(dto, mi);
		memberDao.saveEntity(mi);
		return mi.getId();
	}

	@Override
	@Transactional
	public String softDelete(MemberInfoDto dto) throws Exception {
		if(ObjectHelper.isEmpty(dto) || ObjectHelper.isEmpty(dto.getId())){
			
//		}else{
//			MemberInfo mi = memberDao.getEntity(dto.getId());
//			memberDao.softDeleteEntity(mi);
//			return mi.getId();
		}
		MemberInfo mi = memberDao.getEntity(dto.getId());
		memberDao.softDeleteEntity(mi);
		return mi.getId();
	}

}