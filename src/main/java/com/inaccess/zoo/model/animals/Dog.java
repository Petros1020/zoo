package com.inaccess.zoo.model.animals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.inaccess.zoo.model.tricks.Bark;
import com.inaccess.zoo.model.tricks.Cuddle;
import com.inaccess.zoo.model.tricks.Jump;
import com.inaccess.zoo.model.tricks.RollOver;
import com.inaccess.zoo.model.tricks.Stand;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Animal {

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
		tricks.add(cuddle);
	}

	@Override
	public void learnToBark(Bark bark) {
		tricks.add(bark);
	}

}
