package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "B1", 350, "A1");
    private Product second = new Book(2, "B2", 800, "A2");
    private Product third = new Smartphone(3, "S1", 14000, "M1");
    private Product fourth = new Smartphone(4, "S2", 18000, "M2");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("B2");
        Product[] expected = new Product[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorBook() {
        Product[] actual = manager.searchBy("A1");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("S1");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerBook() {
        Product[] actual = manager.searchBy("M2");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(expected, actual);
    }
}