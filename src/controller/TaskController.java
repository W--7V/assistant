package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.PageDto;
import dto.SearchDto;
import dto.TaskDto;
import service.TaskService;
import util.ResultMsg;

@Controller
@RequestMapping(value = "/task")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaskController {
	@Autowired
	TaskService taskService;
	
	@RequestMapping(value = "/list",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public PageDto<TaskDto> listMember(SearchDto dto){
		PageDto<TaskDto>page = null;
		try {
			page = taskService.page(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ResultMsg save(TaskDto dto){
		ResultMsg msg = new ResultMsg();
		try {
			String id = taskService.saveOrUpdate(dto);
			msg.setId(id);
			msg.setStatus(true);
			msg.setMsg("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public ResultMsg delete(String id){
		ResultMsg msg = new ResultMsg();
		try {
			taskService.delete(id);
			msg.setStatus(true);
			msg.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
