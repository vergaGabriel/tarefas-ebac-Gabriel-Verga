package br.com.gverga.domain;

import br.com.gverga.dao.Persistente;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TB_SALE")
public class Sale implements Persistente {

    public enum Status {
        STARTED, COMPLETED, CANCELED;

        public static Status getByName(String value) {
            for (Status status : Status.values()) {
                if (status.name().equals(value)) {
                    return status;
                }
            }
            return null;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="prod_quantity_seq")
    @SequenceGenerator(name="prod_quantity_seq", sequenceName="sq_prod_quantity", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_client_fk",
        foreignKey = @ForeignKey(name = "fk_sale_client"),
        referencedColumnName = "id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<ProductQuantity> products;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "SALE_DATE", nullable = false)
    private Instant saleDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "SALE_STATUS", nullable = false)
    private Status status;

    public Sale() {
        products = new HashSet<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ProductQuantity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductQuantity> products) {
        this.products = products;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Instant getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Instant saleDate) {
        this.saleDate = saleDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addProduct(Product product, Integer quantity) {
        validateStatus();
        Optional<ProductQuantity> op =
                products.stream().filter(filter -> filter.getProduct().getCode().equals(product.getCode())).findAny();
        if (op.isPresent()) {
            ProductQuantity productQuantity = op.get();
            productQuantity.add(quantity);
        } else {
            ProductQuantity productQuantity = new ProductQuantity();
            productQuantity.setSale(this);
            productQuantity.setProduct(product);
            productQuantity.add(quantity);
            products.add(productQuantity);
        }
        recalculateTotalSaleValue();
    }

    private void validateStatus() {
        if (this.status == Status.COMPLETED) {
            throw new UnsupportedOperationException("IMPOSSIBLE TO CHANGE FINALIZED SALE");
        }
    }

    public void removeProduct(Product product, Integer quantity) {
        validateStatus();
        Optional<ProductQuantity> op =
                products.stream().filter(filter -> filter.getProduct().getCode().equals(product.getCode())).findAny();

        if (op.isPresent()) {
            ProductQuantity productQuantity = op.get();
            if (productQuantity.getQuantity() > quantity) {
                productQuantity.remove(quantity);
                recalculateTotalSaleValue();
            } else {
                products.remove(op.get());
                recalculateTotalSaleValue();
            }
        }
    }

    public void removeAllProducts() {
        validateStatus();
        products.clear();
        totalValue = BigDecimal.ZERO;
    }

    public Integer getQuantityTotalProducts() {
        return products.stream()
                .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantity(), Integer::sum);
    }

    private void recalculateTotalSaleValue() {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (ProductQuantity productQuantity : this.products) {
            totalValue = totalValue.add(productQuantity.getTotalValue());
        }

        this.totalValue = totalValue;
    }
}
