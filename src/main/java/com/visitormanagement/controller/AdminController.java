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
public class AdminController {


	@Autowired
	private IVisitorService visitorService;
	@Autowired
	private IUserService userService;
	

	@RequestMapping("/check")
	public String checkMs() {
		System.out.println("ok checking");
		return "ok checking";
	}
	
	@GetMapping("/approve-visitor/{id}")
	public String approveVisitor(@PathVariable("id") String id) {
		System.out.println("inside 2");
		Visitor visitor = visitorService.findById(Integer.parseInt(id)).get();
		visitor.setApprovedStatus(1);
		visitorService.updateVisitor(visitor);
		return "success";
	}
	
	@GetMapping("/deny-visitor/{id}")
	public String denyVisitor(@PathVariable("id") String id) {
		System.out.println("inside 2 deny");
		Visitor visitor = visitorService.findById(Integer.parseInt(id)).get();
		visitor.setApprovedStatus(0);
		visitorService.updateVisitor(visitor);
		
		return "success";
	}
}
