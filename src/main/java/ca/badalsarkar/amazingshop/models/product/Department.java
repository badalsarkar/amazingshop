package ca.badalsarkar.amazingshop.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", cascade=CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Category> categories= new ArrayList<>();

    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Department(String name){
        this.name= name;
    }
    // method need to keep products in sync with department
    public void addProduct(Product product){

    }
    public void removeProduct(Product product){

    }

    // method needed to keep categories in sync with department
    public void addCategory(Category category){

    }

    public void removeCategory(Category category){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
