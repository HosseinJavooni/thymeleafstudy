package thymeleaf.com.thymeleafstudy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Address address;
}
