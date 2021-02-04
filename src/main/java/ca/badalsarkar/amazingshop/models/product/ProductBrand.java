package ca.badalsarkar.amazingshop.models.product;

import ca.badalsarkar.amazingshop.utilities.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product manufacturer or seller.
 */
@Entity
@Data
@NoArgsConstructor
public class ProductBrand {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NaturalId
    @Column(unique = true, nullable = false)
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products= new ArrayList<>();

    // Getters and Setters to keep ProductBrand and Product in sync
    public void addProduct(Product product){
        products.add(product);
        product.setBrand(this);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.setBrand(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBrand)) return false;

        ProductBrand that = (ProductBrand) o;

        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
