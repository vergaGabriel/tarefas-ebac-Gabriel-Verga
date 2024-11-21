package br.com.gverga.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CAR")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="car_seq")
    @SequenceGenerator(name="car_seq", sequenceName="sq_car", initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "CODE", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "MODEL", length = 50, nullable = false)
    private String model;

    @Column(name = "COLOR", length = 20, nullable = false)
    private String color;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_brand_fk",
            foreignKey = @ForeignKey(name = "fk_car_brand"),
            referencedColumnName = "id", nullable = false)
    private Brand brand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CAR_ACCESSORY",
            joinColumns = { @JoinColumn(name = "id_car_fk") },
            inverseJoinColumns = { @JoinColumn(name = "id_accessory_fk")})
    private List<Accessory> accessories;

    public Car() {
        this.accessories = new ArrayList<Accessory>();
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public void add(Accessory accessory) {
        this.accessories.add(accessory);
    }
}
