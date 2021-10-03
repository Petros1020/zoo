package com.inaccess.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.inaccess.zoo.model.animals.Animal;
import com.inaccess.zoo.model.animals.Cat;
import com.inaccess.zoo.model.animals.Dog;
import com.inaccess.zoo.model.animals.Fish;
import com.inaccess.zoo.model.tricks.Bark;
import com.inaccess.zoo.model.tricks.Cuddle;
import com.inaccess.zoo.model.tricks.Jump;
import com.inaccess.zoo.model.tricks.RollOver;
import com.inaccess.zoo.model.tricks.Stand;
import com.inaccess.zoo.repositories.AnimalRepository;
import com.inaccess.zoo.repositories.TrickRepository;

@SpringBootApplication
public class ZooApplication {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private TrickRepository trickRepository;

	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initilizeDbAfterStartup() {
		
		System.out.println("Initializing db in ZooApplication.class");

		Bark bark = new Bark();
		bark = trickRepository.save(bark);

		Cuddle cuddle = new Cuddle();
		cuddle = trickRepository.save(cuddle);

		Jump jump = new Jump();
		jump = trickRepository.save(jump);

		RollOver rollOver = new RollOver();
		rollOver = trickRepository.save(rollOver);

		Stand stand = new Stand();
		stand = trickRepository.save(stand);

		Animal cat1 = new Cat();
		cat1.setName("kitty");
		
		// adding same trick 2 times. It should now be inserted.
		cat1.learnToJump(jump);
		cat1.learnToJump(jump);

		animalRepository.save(cat1);
		
		Animal dog1 = new Dog();
		dog1.setName("Bob");
		dog1.learnToJump(jump);
		dog1.learnToRollOver(rollOver);
		dog1.learnToStand(stand);
		dog1.learnToBark(bark);
		dog1.learnToCuddle(cuddle);

		animalRepository.save(dog1);


		Animal cat2 = new Cat();
		cat2.setName("cater");
		cat2.learnToJump(jump);
		cat2.learnToRollOver(rollOver);
		cat2.learnToStand(stand);
		animalRepository.save(cat2);

		
		Animal dog2 = new Dog();
		dog2.setName("Lassy");
		dog2.learnToBark(bark);
		dog2.learnToCuddle(cuddle);
		dog2 = animalRepository.save(dog2);
		
		
		Animal fish1 = new Fish();
		fish1.setName("Goldie");
		fish1 = animalRepository.save(fish1);

		Animal dog3 = new Dog();
		dog3.setName("Rob");
		dog3.learnToJump(jump);
		dog3.learnToRollOver(rollOver);
		dog3.learnToStand(stand);
		dog3.learnToBark(bark);
		animalRepository.save(dog3);


		Animal fish2 = new Fish();
		fish2.setName("Goldie jr.");
		animalRepository.save(fish2);

		System.out.println("Initialization successful");
	}

}
