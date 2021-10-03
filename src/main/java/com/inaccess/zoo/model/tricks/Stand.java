package com.inaccess.zoo.model.tricks;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("stands")
@Entity
public class Stand extends Trick{

	@Override
	public String doAction() {
		return "stands on 2 feet";
	}
	
	public Stand() {
	}

	
}
