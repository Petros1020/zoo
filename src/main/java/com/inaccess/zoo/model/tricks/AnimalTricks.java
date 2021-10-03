package com.inaccess.zoo.model.tricks;

import java.util.List;
import java.util.Optional;

public abstract class AnimalTricks {

	public void learnToJump(Jump jump) {
		throw new UnsupportedOperationException();
	}

	public void learnToRollOver(RollOver rollOver) {
		throw new UnsupportedOperationException();
	}

	public void learnToBark(Bark bark) {
		throw new UnsupportedOperationException();
	}

	public void learnToStand(Stand stand) {
		throw new UnsupportedOperationException();
	}

	public void learnToCuddle(Cuddle cuddle) {
		throw new UnsupportedOperationException();
	}

	public abstract Optional<Trick> newTrickToLearn(List<Trick> availableTricks);

}
