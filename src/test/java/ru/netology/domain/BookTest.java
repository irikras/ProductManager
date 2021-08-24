package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldMatchByNameBook() {
        Book book = new Book(1, "B1", 350, "A1");
        assertTrue(book.matches("B1"));
    }

    @Test
    public void shouldNotMatchByNameBook() {
        Book book = new Book(2, "B2", 800, "A2");
        assertFalse(book.matches("B3"));
    }

    @Test
    public void shouldMatchByAuthorBook() {
        Book book = new Book(1, "B1", 350, "A1");
        assertTrue(book.matches("A1"));
    }

    @Test
    public void shouldNotMatchByAuthorBook() {
        Book book = new Book(1, "B1", 350, "A1");
        assertFalse(book.matches("A3"));
    }
}