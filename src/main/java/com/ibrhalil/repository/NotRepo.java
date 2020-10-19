package com.ibrhalil.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibrhalil.model.Not;

@Repository
@Transactional
public interface NotRepo extends CrudRepository<Not, Long>
{
	@Modifying
	@Query("update Not n set n.durum = ?1 where n.id = ?2")
	void notDurumGuncelle(boolean durum, long id);
	
}
