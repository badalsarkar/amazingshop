package ca.badalsarkar.amazingshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String fname;
    private String lname;
    private Long billingAddressId;
    private Long shippingAddressId;
    private Date dob;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (!getId().equals(customer.getId())) return false;
        if (!getFname().equals(customer.getFname())) return false;
        return getLname().equals(customer.getLname());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFname().hashCode();
        result = 31 * result + getLname().hashCode();
        return result;
    }
}
