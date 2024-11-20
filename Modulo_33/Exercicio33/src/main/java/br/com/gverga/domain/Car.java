package br.com.gverga.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_CAR")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="car_seq")
    @SequenceGenerator(name="car_seq", sequenceName="sq_car", initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "MODEL", length = 50, nullable = false)
    private String model;

    @Column(name = "COLOR", length = 20, nullable = false)
    private String color;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
