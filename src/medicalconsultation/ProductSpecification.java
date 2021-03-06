package medicalconsultation;

import data.ProductID;

import java.math.BigDecimal;

/**
 * The description of the product.
 */

public class ProductSpecification {
    private ProductID UPCcode;
    private String description;
    private BigDecimal price;

    public ProductSpecification(ProductID UPCcode, String description, BigDecimal price) {
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }

    public ProductID getUPCcode() {
        return UPCcode;
    }

    public void setUPCcode(ProductID UPCcode) {
        this.UPCcode = UPCcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductSpecification PS = (ProductSpecification) obj;
        return UPCcode.equals(PS.UPCcode) && description.equals(PS.description) && price.equals(PS.price);
    }
}
