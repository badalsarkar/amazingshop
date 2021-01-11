package ca.badalsarkar.amazingshop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String note;
    private String unitOfMeasure;
    private Money price;
    private float weight;
    private String dimension;
    private float rating;
    private int ranking;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> images;

    public Money getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Money.parse(price);
    }
}
