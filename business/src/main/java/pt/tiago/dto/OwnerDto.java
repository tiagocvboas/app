package pt.tiago.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public class OwnerDto extends AbstractBaseId<Long> {
    private String name;
    private String title;
    @NotNull
    @Length(min = 1, max = 255)
    public String getName() {
        return name;
    }

    public OwnerDto setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Length(min = 1, max = 255)
    public String getTitle() {
        return title;
    }

    public OwnerDto setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerDto)) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return Objects.equals(getName(), ownerDto.getName()) &&
                Objects.equals(getTitle(), ownerDto.getTitle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getTitle());
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
