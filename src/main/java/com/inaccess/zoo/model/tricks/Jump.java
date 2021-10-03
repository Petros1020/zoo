package com.inaccess.zoo.model.tricks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("jump")
@Entity
public class Jump extends Trick {

//	private final String trick = "Jumps really high";
	
	@Override
	public String doAction() {
		return "Jumps really high";
	}
	
	public Jump () {
//		this.name = "jump";
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
//		Jump other = (Jump) obj;
//		if (!trick.equals(other.trick))
//			return false;
//		return true;
//	}
}
