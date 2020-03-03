package com.cts.ms.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ms.dao.ContactRepository;
import com.cts.ms.entity.ContactEntity;
import com.cts.ms.models.ContactModel;
import com.cts.ms.models.GroupModel;
import com.cts.ms.service.GroupProxyService;

@RestController
@RequestMapping("/contacts")
public class ContactApi {
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private GroupProxyService gps;

	@GetMapping("/{id}")
	public ResponseEntity<ContactModel> getContactById(@PathVariable(name = "id") Long contactId) {
		ResponseEntity<ContactModel> result;
		ContactEntity entity = contactRepo.findById(contactId).orElse(null);
		if (null != entity) {
			GroupModel groupModel=gps.getGroupModel(entity.getGroupCode());
		
			ContactModel model = new ContactModel(entity,groupModel);
			result = new ResponseEntity<ContactModel>(model, HttpStatus.OK);
		} else {
			result = new ResponseEntity<ContactModel>(HttpStatus.NOT_FOUND);
		}
		return result;
	}

}
