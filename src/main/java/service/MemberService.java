package service;

import dto.MemberInfoDto;
import dto.PageDto;
import dto.SearchDto;

public interface MemberService {

	public PageDto<MemberInfoDto> page(SearchDto dto) throws Exception;
	
	public String saveOrUpdate(MemberInfoDto memberInfoDto) throws Exception;
	
	public String softDelete(MemberInfoDto dto) throws Exception;
	
	public String testDelete() throws Exception;
}
