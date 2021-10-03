package com.inaccess.zoo.model.animals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fish")
public class Fish extends Animal {

}
