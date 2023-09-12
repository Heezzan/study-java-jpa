package ch07.super_sub_relation.single_table_startegy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album_S extends Item_S {

}
