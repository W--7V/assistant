package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.TaskDao;
import dto.PageDto;
import dto.SearchDto;
import dto.TaskDto;
import entity.Task;
import service.TaskService;
import util.ObjectHelper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskDao taskDao;
	
	@Override
	@Transactional
	public PageDto<TaskDto> page(SearchDto dto) throws Exception {
		StringBuffer hql = new StringBuffer("FROM Task where isDeleted = 0");
		PageDto<Task>_pageDto = taskDao.findDtoByHql(dto, hql.toString());
		PageDto<TaskDto> pageDto = new PageDto<TaskDto>();
		List<Task>_list = _pageDto.getRows();
		List<TaskDto>list = new ArrayList<TaskDto>();
		for (Task task : _list) {
			list.add(new TaskDto(task));
		}
		pageDto.setRows(list);
		pageDto.setPageSize(_pageDto.getPageSize());
		pageDto.setTotal(_pageDto.getTotal());
		pageDto.setTotalPage(_pageDto.getTotalPage());
		return pageDto;
	}

	@Override
	@Transactional
	public String saveOrUpdate(TaskDto dto) throws Exception {
		Task t = null;
		if(ObjectHelper.isNotEmpty(dto) && ObjectHelper.isNotEmpty(dto.getId())){
			t = taskDao.getEntity(dto.getId());
		}else{
			t = new Task();
		}
		BeanUtils.copyProperties(dto, t);
		taskDao.saveEntity(t);
		return t.getId();
	}

	@Override
	@Transactional
	public String delete(String id) throws Exception {
		Task t = taskDao.getEntity(id);
//		MemberInfo m = t.getMemberInfo();
		taskDao.deleteEntity(t);
		return null;
	}

}
