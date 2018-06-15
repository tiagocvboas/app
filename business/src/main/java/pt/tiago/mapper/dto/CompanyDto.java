package pt.tiago.mapper.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public class CompanyDto extends AbstractBaseId<Long> {
    private String companyIdentifier;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;


    @NotNull
    @Length(min = 1, max = 255)
    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public CompanyDto setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
        return this;
    }

    @NotNull
    @Length(min = 1, max = 255)
    public String getName() {
        return name;
    }

    public CompanyDto setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Length(min = 1, max = 255)
    public String getAddress() {
        return address;
    }

    public CompanyDto setAddress(String address) {
        this.address = address;
        return this;
    }

    @NotNull
    @Length(min = 1, max = 255)
    public String getCity() {
        return city;
    }

    public CompanyDto setCity(String city) {
        this.city = city;
        return this;
    }

    @NotNull
    @Length(min = 1, max = 255)
    public String getCountry() {
        return country;
    }

    public CompanyDto setCountry(String country) {
        this.country = country;
        return this;
    }

    @Email
    @Length(min = 1, max = 255)
    public String getEmail() {
        return email;
    }

    public CompanyDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min = 1, max = 255)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CompanyDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
