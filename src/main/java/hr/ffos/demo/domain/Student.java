package hr.ffos.demo.domain;

import lombok.Data;

import javax.persistence.*;

//defines the 'domain' which will be created in the database as a table
@Entity
//getters and setters (lombok extension)
@Data
public class Student {

    //column 'id'
    @Id //defines that this property is an 'id' -> identifier
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate unique id's
    private int id;

    //column first_name
    private String firstName;

    //default would be 'last_name' but we changed it to 'prezime'
    @Column(name = "prezime")
    private String lastName;

}
