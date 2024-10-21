package org.jsp.assign.entity;


import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private LocalDate dob;

	    @Column(nullable = false)
	    private double salary;

	    @Column(nullable = false)
	    private boolean status;

	    public int getAge() {
	        return Period.between(this.dob, LocalDate.now()).getYears();
	    }
}


