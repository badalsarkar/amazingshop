package ca.badalsarkar.amazingshop.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents monetary value in a specific currency.
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Money {
    private Currency currency=Currency.getInstance("CAD");
    private BigDecimal value=new BigDecimal(0.00);
}
