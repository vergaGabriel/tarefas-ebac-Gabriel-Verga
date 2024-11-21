package br.com.gverga.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ACCESSORY")
public class Accessory {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="access_seq")
    @SequenceGenerator(name="access_seq", sequenceName="sq_access", initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "CODE", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "OPTIONAL", nullable = false)
    private Boolean optional;

    @ManyToMany(mappedBy = "accessories")
    private List<Car> cars;

    public Accessory() {
        this.cars = new ArrayList<Car>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
