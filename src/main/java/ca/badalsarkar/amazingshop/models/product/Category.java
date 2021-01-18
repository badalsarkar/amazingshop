package ca.badalsarkar.amazingshop.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a product category.
 */
@Entity
@NoArgsConstructor
@Data
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> childCategories= new HashSet<>();

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.setCategory(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!getName().equals(category.getName())) return false;
        return getParentCategory() != null ? getParentCategory().equals(category.getParentCategory()) : category.getParentCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getParentCategory() != null ? getParentCategory().hashCode() : 0);
        return result;
    }
}
