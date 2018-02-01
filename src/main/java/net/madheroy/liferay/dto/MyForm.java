package net.madheroy.liferay.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class MyForm implements Serializable {

    @NotEmpty
    @NotNull
    @Size(min = 4, max = 16)
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 32)
    private String lastName;

    public MyForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
