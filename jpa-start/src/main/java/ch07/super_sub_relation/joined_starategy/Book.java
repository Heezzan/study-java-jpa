package ch07.super_sub_relation.joined_starategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") // ID 로 ITME_ID 대신 BOOK_ID 로 재정의
public class Book extends Item {

    private String author;
    private String isbn;

}
