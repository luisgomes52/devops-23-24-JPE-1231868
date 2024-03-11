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

        // Act
        Employee employee = new Employee(firstName, lastName, description, jobYears);

        // Assert
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(description, employee.getDescription());
        assertEquals(String.valueOf(jobYears), employee.getJobYears());
    }

    @Test
    void emptyEmployeeFirstName(){

        // Arrange
        String firstName = "";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void emptyEmployeeLastName(){

        // Arrange
        String firstName = "firstName";
        String lastName = "";
        String description = "description";
        int jobYears = 5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void emptyEmployeeDescription(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "";
        int jobYears = 5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void negativeEmployeeJobYears(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = -5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void zeroEmployeeJobYears() throws InstantiationException {

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = "description";
        int jobYears = 0;

        // Act
        Employee employee = new Employee(firstName, lastName, description, jobYears);

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

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void nullEmployeeLastName(){

        // Arrange
        String firstName = "firstName";
        String lastName = null;
        String description = "description";
        int jobYears = 5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

    @Test
    void nullEmployeeDescription(){

        // Arrange
        String firstName = "firstName";
        String lastName = "lastName";
        String description = null;
        int jobYears = 5;

        // Act and Assert
        assertThrows(InstantiationException.class, () -> new Employee(firstName, lastName, description, jobYears));
    }

}
