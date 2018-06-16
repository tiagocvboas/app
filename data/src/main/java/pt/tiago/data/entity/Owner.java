package pt.tiago.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "owner")
public class Owner {
    private Long id;
    private String name;
    private String title;
    private List<Company> companies;

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public Owner setId(Long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name="title", nullable = false)
    public String getTitle() {
        return title;
    }

    public Owner setTitle(String title) {
        this.title = title;
        return this;
    }


    @ManyToMany(mappedBy = "owners")
    public List<Company> getCompanies() {
        return companies;
    }

    public Owner setCompanies(List<Company> companies) {
        this.companies = companies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner rating = (Owner) o;
        return Objects.equals(getId(), rating.getId()) &&
                Objects.equals(getName(), rating.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }
}