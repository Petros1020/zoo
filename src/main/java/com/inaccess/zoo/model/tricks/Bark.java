package com.inaccess.zoo.model.tricks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bark")
public class Bark extends Trick {

	@Override
	public String doAction() {
		return "barks at anything moving";
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
//		Bark other = (Bark) obj;
//		if (!trick.equals(other.trick))
//			return false;
//		return true;
//	}
}
