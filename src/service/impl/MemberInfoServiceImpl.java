package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.MemberInfoService;
import dao.MemberInfoDao;
import dto.MemberInfoDto;
import dto.PageDto;
import entity.MemberInfo;

@Service("memberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	MemberInfoDao memberInfoDao;
	
	@Override
	public PageDto<MemberInfoDto> page() throws Exception {
		@SuppressWarnings("unchecked")
		List<MemberInfo>_list = (List<MemberInfo>)memberInfoDao.list();
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
		MemberInfo mi = new MemberInfo();
		BeanUtils.copyProperties(dto, mi);
		mi.setCreateTime(new Date());
		memberInfoDao.save(mi);
		return mi.getId();
	}

}