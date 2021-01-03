package com.mn.projects.listjsframeworks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="js_frameworks")
public class JSFrameworks {
	
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="js_frameworks_id")
	private int id;
	
	@Column(name="nazev")
	private String nazev;
	
	@Column(name="version")
	private String version;
	
	@Column(name="deprecation_date")
	private String deprecationDate;
	
	@Column(name="hype_level")
	private int hypeLevel;
	
	
	// define constructors
	
	public JSFrameworks() {}


	public JSFrameworks(String nazev, String version, String deprecationDate, int hypeLevel) {
		this.nazev = nazev;
		this.version = version;
		this.deprecationDate = deprecationDate;
		this.hypeLevel = hypeLevel;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNazev() {
		return nazev;
	}


	public void setNazev(String nazev) {
		this.nazev = nazev;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getDeprecationDate() {
		return deprecationDate;
	}


	public void setDeprecationDate(String deprecationDate) {
		this.deprecationDate = deprecationDate;
	}


	public int getHypeLevel() {
		return hypeLevel;
	}


	public void setHypeLevel(int hypeLevel) {
		this.hypeLevel = hypeLevel;
	}

	// define tostring

	@Override
	public String toString() {
		return "JSFrameworks [id=" + id + ", nazev=" + nazev + ", version=" + version + ", deprecationDate="
				+ deprecationDate + ", hypeLevel=" + hypeLevel + "]";
	}
	
	
	
	
	
	

}
