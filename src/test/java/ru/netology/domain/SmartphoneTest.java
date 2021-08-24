package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    @Test
    public void shouldMatchByNameSmartphone() {
        Smartphone smartphone = new Smartphone(3, "S1", 14000, "M1");
        assertTrue(smartphone.matches("S1"));
    }

    @Test
    public void shouldNotMatchByNameSmartphone() {
        Smartphone smartphone = new Smartphone(4, "S2", 18000, "M2");
        assertFalse(smartphone.matches("S3"));
    }

    @Test
    public void shouldMatchByManufacturerSmartphone() {
        Smartphone smartphone = new Smartphone(4, "S2", 18000, "M2");
        assertTrue(smartphone.matches("M2"));
    }

    @Test
    public void shouldNotMatchByManufacturerSmartphone() {
        Smartphone smartphone = new Smartphone(3, "S1", 14000, "M1");
        assertFalse(smartphone.matches("M3"));
    }
}