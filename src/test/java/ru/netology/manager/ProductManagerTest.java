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
    private Product fifth = new Book(5, "B2", 800, "A2");
    private Product sixth = new Smartphone(6, "S1", 14000, "M1");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("B1");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotToSearchByNameBook() {
        Product[] actual = manager.searchBy("B3");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOneByNameBook() {
        Product[] actual = manager.searchBy("B2");
        Product[] expected = new Product[]{second, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorBook() {
        Product[] actual = manager.searchBy("A1");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotToSearchByAuthorBook() {
        Product[] actual = manager.searchBy("A3");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOneByAuthorBook() {
        Product[] actual = manager.searchBy("A2");
        Product[] expected = new Product[]{second, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("S2");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotToSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("S3");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOneByNameSmartphone() {
        Product[] actual = manager.searchBy("S1");
        Product[] expected = new Product[]{third, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmartphone() {
        Product[] actual = manager.searchBy("M2");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotToSearchByManufacturerSmartphone() {
        Product[] actual = manager.searchBy("M3");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOneByManufacturerSmartphone() {
        Product[] actual = manager.searchBy("M1");
        Product[] expected = new Product[]{third, sixth};

        assertArrayEquals(expected, actual);
    }
}