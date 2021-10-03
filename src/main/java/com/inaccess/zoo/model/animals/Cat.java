package com.inaccess.zoo.model.animals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.inaccess.zoo.model.tricks.Cuddle;
import com.inaccess.zoo.model.tricks.Jump;
import com.inaccess.zoo.model.tricks.RollOver;
import com.inaccess.zoo.model.tricks.Stand;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Animal {

	public Cat() {
	}

	@Override
	public void learnToJump(Jump jump) {
		tricks.add(jump);
	}

	@Override
	public void learnToRollOver(RollOver rollOver) {
		tricks.add(rollOver);
	}

	@Override
	public void learnToStand(Stand stand) {
		tricks.add(stand);
	}

	@Override
	public void learnToCuddle(Cuddle cuddle) {
		throw new UnsupportedOperationException("AHAHAHAHAHAHHA");
	}


}
