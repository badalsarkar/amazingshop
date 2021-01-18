package ca.badalsarkar.amazingshop.models.product;

import ca.badalsarkar.amazingshop.models.ProductBrand;
import ca.badalsarkar.amazingshop.utilities.Money;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(
                name= "currentPrice.currency",
                column = @Column(name = "currentPriceCurrency", nullable=false)
        ),
        @AttributeOverride(
                name = "listPrice.currency",
                column = @Column(name = "listPriceCurrency", nullable = false)
        ),
        @AttributeOverride(
                name = "currentPrice.value",
                column = @Column(name = "currentPriceValue", nullable = false)
        ),
        @AttributeOverride(
                name = "listPrice.value",
                column = @Column(name = "listPriceValue", nullable = false)
        )
})
public class Product {
    /**
     * TODO Test for equality
     *
     */
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private ProductBrand brand;
    @ManyToOne
    private Category category;
    @Embedded
    @Column(nullable = false)
    private Money currentPrice;
    @Embedded
    @Column(nullable = false)
    private Money listPrice;
    private float rating;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> topFeatures;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> images;

    // Product equality based on product name and brand name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!getName().equals(product.getName())) return false;
        if (!getBrand().equals(product.getBrand())) return false;
        return getCategory().equals(product.getCategory());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getCategory().hashCode();
        return result;
    }
}
