package ca.badalsarkar.amazingshop.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a product category. A category is owned by
 * a department. The uniqueness of a category is determined
 * by the category name and department name.
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

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!getName().equals(category.getName())) return false;
        return getDepartment().getName().equals(category.getDepartment().getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDepartment().hashCode();
        return result;
    }
}
