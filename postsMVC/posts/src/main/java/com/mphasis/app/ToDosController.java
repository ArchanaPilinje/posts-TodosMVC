package com.mphasis.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.app.crud.Post;
import com.mphasis.app.crud.Status;
import com.mphasis.app.crud.ToDos;
import com.mphasis.app.dao.ToDosDAOImpl;

@Controller
public class ToDosController {
	private static final Logger logger = LoggerFactory.getLogger(ToDosController.class);
	
	ToDosDAOImpl impl=new ToDosDAOImpl();
	
	
	@RequestMapping(value = "/addT", method = RequestMethod.GET)
	public ModelAndView addPost(@RequestParam() String title, @RequestParam() String completed) {
		ToDos res = impl.insert(new ToDos(0, title, completed));

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "Your todo has been added successfully !");

		return mv;
	}
	
	@RequestMapping(value = "/updateT", method = RequestMethod.GET)
	public ModelAndView updatePost(@RequestParam() int id) {
		try {
			ToDos res=impl.update(id);
			ModelAndView mv1 = new ModelAndView("success");
			mv1.addObject("msg", "Your todo has been updated successfully !");
			return mv1;
		}
		catch (Exception e) {
			ModelAndView mv2 = new ModelAndView("error");
			mv2.addObject("msg", "Your todo couldn't be updated successfully !");
			return mv2;
		}
	}
	
	@RequestMapping(value = "/deleteT", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam() int id) {
		try {
			Status res=impl.delete(id);
			ModelAndView mv1 = new ModelAndView("success");
			mv1.addObject("msg", "Your todo has been deleted successfully !");
			return mv1;
		}
		catch (Exception e) {
			ModelAndView mv2 = new ModelAndView("error");
			mv2.addObject("msg", "Your todo couldn't be deleted successfully !");
			return mv2;
		}
	}
	
	
}
