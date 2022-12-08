package com.visitormanagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitormanagement.model.User;
import com.visitormanagement.model.Visitor;
import com.visitormanagement.services.IUserService;
import com.visitormanagement.services.IVisitorService;

@RestController
public class GateController {


	@Autowired
	private IVisitorService visitorService;
	@Autowired
	private IUserService userService;
	

	
	
	@GetMapping("/mark-visited/{id}")
	public String markVisited(@PathVariable("id") String id) {
		
		Visitor visitor = visitorService.findById(Integer.parseInt(id)).get();
		visitor.setVisited(1);
		visitorService.updateVisitor(visitor);
		
		
		return "success";
	}
	
	@GetMapping("/unmark-visited/{id}")
	public String unmarkVisited(@PathVariable("id") String id) {
		
		Visitor visitor = visitorService.findById(Integer.parseInt(id)).get();
		visitor.setVisited(0);
		visitorService.updateVisitor(visitor);
		
		return "gate-dashboard";
	}
}
