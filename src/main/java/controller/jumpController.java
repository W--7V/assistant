package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import util.ResultMsg;
import dto.MemberInfoDto;
import dto.PageDto;

@Controller
@RequestMapping(value = "/jump")
public class jumpController {
	@Autowired
	MemberService memberInfoService;
	
	@RequestMapping(value = "/getStr")
	@ResponseBody
	public String getStr(){
		System.out.println("getStr");
		return "str";
	}
	
	@RequestMapping(value = "/tolist")
	public ModelAndView tolist(){
		ModelAndView mv = new ModelAndView("/listMember");
		return mv;
	}
	
	@RequestMapping(value = "/listMember")
	@ResponseBody
	public PageDto<MemberInfoDto> toMyjsp(HttpServletRequest request){
		request.getServletContext();
		PageDto<MemberInfoDto>page = null;
		try {
//			page = memberInfoService.page();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd(){
		ModelAndView mv = new ModelAndView("/add");
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
			msg.setMsg("����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
