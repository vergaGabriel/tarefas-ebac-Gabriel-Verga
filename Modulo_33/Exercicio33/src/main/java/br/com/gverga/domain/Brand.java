package br.com.gverga.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_BRAND")
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="brand_seq")
    @SequenceGenerator(name="brand_seq", sequenceName="sq_brand", initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "CODE", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
