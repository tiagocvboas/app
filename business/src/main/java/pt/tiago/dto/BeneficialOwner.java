package pt.tiago.dto;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public class BeneficialOwner extends AbstractBaseId<Long> {
    private String name;
    private String title;


    public String getName() {
        return name;
    }

    public BeneficialOwner setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BeneficialOwner setTitle(String title) {
        this.title = title;
        return this;
    }


    @Override
    public String toString() {
        return "BeneficialOwner{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
