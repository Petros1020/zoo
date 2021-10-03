package com.inaccess.zoo.model.animals;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.inaccess.zoo.model.tricks.AnimalTricks;
import com.inaccess.zoo.model.tricks.Bark;
import com.inaccess.zoo.model.tricks.Cuddle;
import com.inaccess.zoo.model.tricks.Jump;
import com.inaccess.zoo.model.tricks.RollOver;
import com.inaccess.zoo.model.tricks.Stand;
import com.inaccess.zoo.model.tricks.Trick;

@Entity(name = "ANIMALS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "species", discriminatorType = DiscriminatorType.STRING)
public abstract class Animal extends AnimalTricks {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	protected UUID id;

	protected String name;

	@Column(name = "species", nullable = false, updatable = false, insertable = false)
	protected String species;

	@ManyToMany
	@JoinTable(name = "ANIMALS_TO_TRICKS", joinColumns = @JoinColumn(name = "animal_id"), inverseJoinColumns = @JoinColumn(name = "trick_id"))
	protected Set<Trick> tricks = new HashSet<>();

	public Animal(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public Animal() {
	}

	public String doTrick() {

		if (this.tricks.size() == 0) {
			return "No tricks available";
		}

		Trick[] arrayTricks = this.tricks.toArray(new Trick[this.tricks.size()]);

		Random rndm = new Random();
		int rndmNumber = rndm.nextInt(this.tricks.size());

		Trick trick = arrayTricks[rndmNumber];

		return trick.doAction();

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Set<Trick> getTricks() {
		return tricks;
	}

	public void setTricks(Set<Trick> tricks) {
		this.tricks = tricks;
	}

	public boolean hasTrick(Trick trick) {
		return this.tricks.contains(trick);
	}

	@Override
	public Optional<Trick> newTrickToLearn(List<Trick> availableTricks) {

		for (Trick trick : availableTricks) {
			if (this.hasTrick(trick)) {
				continue;
			}

			try {
				if (trick instanceof Jump) {
					this.learnToJump((Jump) trick);

				} else if (trick instanceof RollOver) {
					this.learnToRollOver((RollOver) trick);
				}

				else if (trick instanceof Bark) {
					this.learnToBark((Bark) trick);
				}

				else if (trick instanceof Stand) {
					this.learnToStand((Stand) trick);
				}

				else if (trick instanceof Cuddle) {
					this.learnToCuddle((Cuddle) trick);
				}

				return Optional.of(trick);

			} catch (UnsupportedOperationException ex) {
				System.out.println("This animal cannot learn this trick");
			}

		}

		return Optional.empty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Animal))
			return false;

		Animal other = (Animal) o;

		return id != null && id.equals(other.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
