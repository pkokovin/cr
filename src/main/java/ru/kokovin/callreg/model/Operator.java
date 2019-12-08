package ru.kokovin.callreg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "operators", uniqueConstraints = {@UniqueConstraint(columnNames = "cname", name = "operators_unique_cname_idx")})
public class Operator  extends AbstractBaseEntity {

    @Column(name = "cname", nullable = false, unique = true)
    @NotBlank
    @Size(max = 10)
    private String cName;

    @Column(name = "fullname", nullable = false, unique = true)
    @NotBlank
//    @Size(max = 40)
    private String fullName;


    public Operator() {
    }

    public Operator(Integer id, String cName, String fullName) {
        this.id = id;
        this.cName = cName;
        this.fullName = fullName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "cName='" + cName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
