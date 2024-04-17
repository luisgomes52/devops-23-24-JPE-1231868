package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static java.lang.Float.NaN;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void emptyEmployeeFirstName(){

        // Arrange
        String firstName = "";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void emptyEmployeeLastName(){

        // Arrange
        String firstName = "firstName";
        String lastName = "";
        String description = "description";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void emptyEmployeeDescription(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void emptyEmployeeEmail(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = "";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void invalidEmployeeEmail(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = "email";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void negativeEmployeeJobYears(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = -5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }


    @Test
    void nullEmployeeFirstName(){

        // Arrange
        String firstName = null;
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void nullEmployeeLastName(){

        // Arrange
        String firstName = "firstName";
        String lastName = null;
        String description = "description";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void nullEmployeeDescription(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = null;
        int jobYears = 5;
        String email = "name@mail.com";

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

    @Test
    void nullEmployeeEmail(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = null;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears, email));
    }

}
