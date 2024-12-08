package br.com.gverga.domain;

import br.com.gverga.dao.Persistente;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUCT_QUANTITY")
public class ProductQuantity implements Persistente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="prod_quantity_seq")
    @SequenceGenerator(name="prod_quantity_seq", sequenceName="sq_prod_quantity", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private BigDecimal totalValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sale_fk",
        foreignKey = @ForeignKey(name = "fk_prod_quantity_sale"),
        referencedColumnName = "id", nullable = false)
    private Sale sale;

    public ProductQuantity() {
        this.quantity = 0;
        this.totalValue = BigDecimal.ZERO;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void add(Integer quantity) {
        this.quantity += quantity;
        BigDecimal newValue = this.product.getValue().multiply(BigDecimal.valueOf(quantity));
        newValue = this.totalValue.add(newValue);
        this.totalValue = newValue;
    }

    public void remove(Integer quantity) {
        this.quantity -= quantity;
        BigDecimal newValue = this.product.getValue().multiply(BigDecimal.valueOf(quantity));
        this.totalValue = this.totalValue.subtract(newValue);

    }
}
