package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static java.lang.Float.NaN;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {
    @Test
    void validCreateEmployee() throws InstantiationException {

        // Arrange
        String firstName = "name";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;
        String email = "name@mail.com";

        // Act
        Employee employee = new Employee(firstName, lastName, description, jobYears, email);

        // Assert
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(description, employee.getDescription());
        assertEquals(String.valueOf(jobYears), employee.getJobYears());
        assertEquals(email, employee.getEmail());
    }

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
    void zeroEmployeeJobYears() throws InstantiationException {

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 0;
        String email = "name@mail.com";

        // Act
        Employee employee = new Employee(firstName, lastName, description, jobYears, email);

        // Assert
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(description, employee.getDescription());
        assertEquals(String.valueOf(jobYears), employee.getJobYears());

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
