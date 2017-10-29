package service;

import dto.MemberInfoDto;
import dto.PageDto;
import dto.SearchDto;

public interface MemberInfoService {

	public PageDto<MemberInfoDto> page(SearchDto dto) throws Exception;
	
	public String saveOrUpdate(MemberInfoDto memberInfoDto) throws Exception;
}
