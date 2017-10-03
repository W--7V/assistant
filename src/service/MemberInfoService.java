package service;

import dto.MemberInfoDto;
import dto.PageDto;

public interface MemberInfoService {

	public PageDto<MemberInfoDto> page() throws Exception;
	
	public String saveOrUpdate(MemberInfoDto memberInfoDto) throws Exception;
}
