package com.inaccess.zoo.model.tricks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("cuddle")
@Entity
public class Cuddle extends Trick {

//	private final String trick = "cuddles";
	
	@Override
	public String doAction() {
		return "cuddles";
	}
	
	public Cuddle () {
//		this.name = "cuddle";
	}
	
//	@Override
//	public int hashCode() {
//		return getClass().hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cuddle other = (Cuddle) obj;
//		if (!trick.equals(other.trick))
//			return false;
//		return true;
//	}
	
}
