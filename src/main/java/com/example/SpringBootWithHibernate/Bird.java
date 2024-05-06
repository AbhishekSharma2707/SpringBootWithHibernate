package com.example.SpringBootWithHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="birds")
public class Bird {
	@Id
	@Column(name="id")
    public int idofbird;
	@Column(name="nob")
    public String nameofbird;
	@Column(name="cob")
    public String colorofbird;
	public int getIdofbird() {
		return idofbird;
	}
	public void setIdofbird(int idofbird) {
		this.idofbird = idofbird;
	}
	public String getNameofbird() {
		return nameofbird;
	}
	public void setNameofbird(String nameofbird) {
		this.nameofbird = nameofbird;
	}
	public String getColorofbird() {
		return colorofbird;
	}
	public void setColorofbird(String colorofbird) {
		this.colorofbird = colorofbird;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return idofbird +" "+ nameofbird+" "+colorofbird;
	}
}
