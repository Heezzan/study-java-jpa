package ch07.super_sub_relation.joined_starategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artis;

}
