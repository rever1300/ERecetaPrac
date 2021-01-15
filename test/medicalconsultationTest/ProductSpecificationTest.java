package medicalconsultationTest;

import Exceptions.dataE.ProductIDException;
import data.ProductID;
import medicalconsultation.ProductSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSpecificationTest {

    private ProductSpecification productSpecification;

    @BeforeEach
    public void initialize() throws ProductIDException {
        ProductID productID = new ProductID("123456789012");
        String description = "Pastilles per conciliar el son";
        BigDecimal price = new BigDecimal(8);
        productSpecification = new ProductSpecification(productID, description, price);
    }

    @Test
    public void getterProdID() throws ProductIDException {
        ProductID expProductID = new ProductID("123456789012");
        assertEquals(expProductID, productSpecification.getUPCcode());
    }

    @Test
    public void getterDesc() {
        String expDescription = "Pastilles per conciliar el son";
        assertEquals(expDescription, productSpecification.getDescription());
    }

    @Test
    public void getterPrice() {
        BigDecimal expPrice = new BigDecimal(8);
        assertEquals(expPrice, productSpecification.getPrice());
    }

    @Test
    public void setterProdID() throws ProductIDException {
        ProductID expProductID = new ProductID("014725836978");
        productSpecification.setUPCcode(expProductID);
        assertEquals(expProductID, productSpecification.getUPCcode());
    }

    @Test
    public void setterDesc() {
        String expDescription = "Pastilles pel mal de cap";
        productSpecification.setDescription(expDescription);
        assertEquals(expDescription, productSpecification.getDescription());
    }

    @Test
    public void setterPrice() {
        BigDecimal expPrice = new BigDecimal(78);
        productSpecification.setPrice(expPrice);
        assertEquals(expPrice, productSpecification.getPrice());
    }


}
