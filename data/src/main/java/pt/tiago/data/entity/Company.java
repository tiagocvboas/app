package pt.tiago.data.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;

    private List<Owner> owners;


    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name="address", nullable = false)
    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    @Basic
    @Column(name="city", nullable = false)
    public String getCity() {
        return city;
    }

    public Company setCity(String city) {
        this.city = city;
        return this;
    }

    @Basic
    @Column(name="country", nullable = false)
    public String getCountry() {
        return country;
    }

    public Company setCountry(String country) {
        this.country = country;
        return this;
    }

    @Basic
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    @Basic
    @Column(name="phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "company_owner",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    public List<Owner> getOwners() {
        return owners;
    }

    public Company setOwners(List<Owner> owners) {
        this.owners = owners;
        return this;
    }

    public Company setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company rating = (Company) o;
        return Objects.equals(getId(), rating.getId()) &&
                Objects.equals(getName(), rating.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }
}