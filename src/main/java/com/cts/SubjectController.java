package com.cts;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubjectController {
	@Autowired
	SubjectRepository srepo; 
	String message="";
	@RequestMapping(value="/subjects")
	public ModelAndView getSubjects(ModelAndView model){
		List<Subject> subList =  srepo.loadSubjects();
		model.addObject("listSubject", subList);
		model.addObject("message", message);
		model.setViewName("Subject");
		return model;
	}
	
	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
	public ModelAndView saveSubject(HttpServletRequest request) {
		Subject sub = new Subject();
		sub.setSubtitle(request.getParameter("subtitle"));
		sub.setDurationInHours(Integer.parseInt(request.getParameter("durationInHours")));
		srepo.saveSubject(sub);
		message = "Subject " + request.getParameter("subtitle") + " successfully added";
		return new ModelAndView("redirect:/subjects");
	}
	
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
	public ModelAndView deleteSubject(HttpServletRequest request) {
	    long subjectId = Long.parseLong(request.getParameter("subjectId"));
	    srepo.deleteSubject(subjectId);
	    message = "Subject is deleted";
	    return new ModelAndView("redirect:/subjects");
	}
	
	@RequestMapping(value = "/searchSubject", method = RequestMethod.POST)
	public ModelAndView searchSubject(HttpServletRequest request) {		
		List<Subject> subList = srepo.searchSubject(request.getParameter("searchBox"));
		ModelAndView model = new ModelAndView();	
		message = "";
		model.addObject("listSubject", subList);
		model.addObject("message", message);
		model.setViewName("Subject");
		return model;
	}
}
