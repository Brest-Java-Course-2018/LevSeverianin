package com.epam.brest.cource;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    public static final String LEV = "Lev";

    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName(LEV);
        Assert.assertEquals(LEV,employee.getEmployeeName());
    }
}
