package org.isi.web;

import org.isi.dao.ContactReposetory;
import org.isi.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	private ContactReposetory contactReposetory;
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContact(){
		return contactReposetory.findAll();
	}

	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactReposetory.findOne(id);
	}


	
	@RequestMapping(value="/contacts",method =RequestMethod.POST)
	public Contact save(@RequestBody Contact c){
		return contactReposetory.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		contactReposetory.delete(id);
		return true;
	}
	
	@RequestMapping(value="/contacts/{id}",method =RequestMethod.PUT)
	public Contact save(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);
		return contactReposetory.save(c);
	}
	
	@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Contact> chercher(
								@RequestParam(name="mc",defaultValue="") String mc,
								@RequestParam(name="page",defaultValue="0") int page,
								@RequestParam(name="size",defaultValue="5") int size
								){
								return  contactReposetory.chercher("%"+mc+"%", new PageRequest(page,size));
	}


}
