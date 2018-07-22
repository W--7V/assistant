package service;

import dto.PageDto;
import dto.SearchDto;
import dto.TaskDto;

public interface TaskService {
	public PageDto<TaskDto> page(SearchDto dto) throws Exception;
	
	public String saveOrUpdate(TaskDto taskDto) throws Exception;
	
	public void delete(String id) throws Exception;
}
