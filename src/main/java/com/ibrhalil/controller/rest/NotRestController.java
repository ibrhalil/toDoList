package com.ibrhalil.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibrhalil.model.Not;
import com.ibrhalil.service.NotService;

@RestController
@RequestMapping(path = "/api/v1")
public class NotRestController 
{
	@Autowired
	private NotService notService;
	
	@PostMapping("/not/ekle")
	public ResponseEntity<String> notEkle(@RequestBody Not not) 
	{
		notService.notEkle(not);
		
		return new ResponseEntity<>("Yeni Not Eklendi",HttpStatus.CREATED);
	}
	
	@PostMapping("/not/liste")
	public ResponseEntity<List<Not>> notlar() 
	{
		return new ResponseEntity<>(notService.notlar(),HttpStatus.OK);
				
	}
	
	@PostMapping("/not/durum")
	public ResponseEntity<String> notDurumDegistir(@RequestBody long id)
	{
		notService.notDurumGuncelle(id);
		return new ResponseEntity<>("durum güncellendi", HttpStatus.OK);
	}
	
	@PostMapping("/not/sil")
	public ResponseEntity<String> notSil(@RequestBody long id) 
	{
		notService.notSil(id);
		
		return new ResponseEntity<>(id+" Not silindi",HttpStatus.OK);
	}
}
