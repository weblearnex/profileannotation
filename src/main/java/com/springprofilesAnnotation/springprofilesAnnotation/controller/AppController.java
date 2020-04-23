package com.springprofilesAnnotation.springprofilesAnnotation.controller;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AppController {

	@Autowired
	DataSource dataSource;
	
	@GetMapping("/")
	public String get() throws SQLException{
		String message = dataSource.getConnection().getCatalog().toLowerCase();
		return "Active profile is ="+message;
	}
}
