package com.cts.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ms.dao.groupRepository;
import com.cts.ms.entity.GroupEntity;
import com.cts.ms.model.GroupModel;

@RestController
@RequestMapping("/group2")
public class GroupApi {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private groupRepository grpRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupModel> getGroupById(@PathVariable(name="id")String groupCode) {
		ResponseEntity<GroupModel> result;
		GroupEntity entity=grpRepo.findById(groupCode).orElse(null);
		
		if(entity==null)
			result=new ResponseEntity<GroupModel>(HttpStatus.NOT_FOUND);
			else {
				GroupModel model=new GroupModel(entity,Integer.parseInt(env.getProperty("local.server.port")));
				result=new ResponseEntity<GroupModel>(model,HttpStatus.OK);
			}
		return result;
	}

}
