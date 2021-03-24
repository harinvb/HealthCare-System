package com.cg.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IAdminService adminService;
	@PostMapping("/registeradmin/{username}/{password}")
	public	void registerAdmin(@PathVariable String username,@PathVariable String password) throws Exception{
		adminService.registerAdmin(username, password);
	}
}
