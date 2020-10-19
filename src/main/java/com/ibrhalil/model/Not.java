package com.ibrhalil.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "not_table")
public class Not implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "not_id")
	private long id;
	
	@Column(length = 255)
	private String icerik;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tarih = new Date(System.currentTimeMillis());
	
	private boolean durum = true;
	
	public Not() 
	{
		
	}

	public Not(String icerik) 
	{
		this.icerik = icerik;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	public boolean isDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icerik == null) ? 0 : icerik.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Not other = (Not) obj;
		if (icerik == null) {
			if (other.icerik != null)
				return false;
		} else if (!icerik.equals(other.icerik))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Not [id=" + id + ", icerik=" + icerik + ", tarih=" + tarih + "]";
	}
	
	
}
