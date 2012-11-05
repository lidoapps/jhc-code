package cn.jhc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jhc.dao.SpittleDao;

@Controller
public class HomeController {
	
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	@Autowired
	private SpittleDao spittleDao;
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String,Object> model) {
		model.put("spittles", 
				spittleDao.findAll(new PageRequest(0, 
						DEFAULT_SPITTLES_PER_PAGE, 
						Sort.Direction.DESC, "when")).getContent());
		return "home";
	}
}
