package com.inaccess.zoo.model.tricks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("rollover")
@Entity
public class RollOver extends Trick {

//	private final String trick = "rolls over";
	
	@Override
	public String doAction() {
		return "rolls over";
	}
	
	public RollOver() {
//		this.name = "rollover";
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
//		RollOver other = (RollOver) obj;
//		if (!trick.equals(other.trick))
//			return false;
//		return true;
//	}

	
}
