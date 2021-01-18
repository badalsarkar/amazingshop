package ca.badalsarkar.amazingshop.utilities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class Address {
    private String streetNo;
    private String streetName;
    private String city;
    private String province;
    private String country;
    private String postCode;
}
