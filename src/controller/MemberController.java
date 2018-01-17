package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberInfoDto;
import dto.PageDto;
import dto.SearchDto;
import service.MemberService;
import util.ResultMsg;

@Controller
@RequestMapping(value = "/member")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MemberController {
	@Autowired
	MemberService memberInfoService;
	
	@RequestMapping(value = "/tolist")
	public ModelAndView tolist(){
		ModelAndView mv = new ModelAndView("/member/listMember");
		return mv;
	}
	
	@RequestMapping(value = "/list",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public PageDto<MemberInfoDto> listMember(SearchDto dto){
		PageDto<MemberInfoDto>page = null;
		try {
			page = memberInfoService.page(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd(){
		ModelAndView mv = new ModelAndView("/member/add");
		return mv;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ResultMsg save(MemberInfoDto dto){
		ResultMsg msg = new ResultMsg();
		try {
			String id = memberInfoService.saveOrUpdate(dto);
			msg.setId(id);
			msg.setStatus(true);
			msg.setMsg("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PATCH)
	@ResponseBody
	public ResultMsg update(MemberInfoDto dto){
		ResultMsg msg = new ResultMsg();
		try {
			String id = memberInfoService.saveOrUpdate(dto);
			msg.setId(id);
			msg.setStatus(true);
			msg.setMsg("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value="/softDelete",method=RequestMethod.DELETE)
	@ResponseBody
	public ResultMsg softDelete(MemberInfoDto dto){
		ResultMsg msg = new ResultMsg();
		try {
			String id = memberInfoService.softDelete(dto);
			msg.setId(id);
			msg.setStatus(true);
			msg.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
