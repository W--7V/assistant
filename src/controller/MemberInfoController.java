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
import service.MemberInfoService;
import util.ResultMsg;

@Controller
@RequestMapping(value = "/member")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MemberInfoController {
	@Autowired
	MemberInfoService memberInfoService;
	
	@RequestMapping(value = "/tolist")
	public ModelAndView tolist(){
		ModelAndView mv = new ModelAndView("/member/listMember");
		return mv;
	}
	
	@RequestMapping(value = "/listMember",method = RequestMethod.POST)
	@ResponseBody
	public PageDto<MemberInfoDto> listMember(){
		PageDto<MemberInfoDto>page = null;
		try {
			page = memberInfoService.page();
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
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ResultMsg saveOrUpdate(MemberInfoDto dto){
		ResultMsg msg = new ResultMsg();
		try {
			memberInfoService.saveOrUpdate(dto);
			msg.setId(dto.getId());
			msg.setStatus(true);
			msg.setMsg("±£´æ³É¹¦");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
