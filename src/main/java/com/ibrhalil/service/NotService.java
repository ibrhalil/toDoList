package com.ibrhalil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrhalil.model.Not;
import com.ibrhalil.repository.NotRepo;

@Service
public class NotService 
{
	@Autowired
	private NotRepo notRepo;
	
	public void notEkle(Not not) 
	{
		if(not.getIcerik()!=null || not.getIcerik().trim().length()>2)
			notRepo.save(not);
		else 
			System.out.println("icerik hatalı!!");
		
	}
	
	public Not notGosterId(long id) 
	{
		return notRepo.findById(id).get();
	}
	
	public List<Not> notlar() 
	{
		List<Not> notlar = new ArrayList<Not>();
		for (Not not : notRepo.findAll()) {
			notlar.add(not);
		}
		return notlar;
	}
	
	public void notSil(long id)
	{
		notRepo.deleteById(id);
	}
	
	public long notSayisi() 
	{
		return notRepo.count();
	}
	
	public void notlariSil()
	{
		notRepo.deleteAll();
	}
	
	public void notDurumGuncelle(long id)
	{
		Not tmpNot = notGosterId(id);
		notRepo.notDurumGuncelle(tmpNot.isDurum() ? false : true, id);
	}
	
}
