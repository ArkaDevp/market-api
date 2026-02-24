package com.arka.market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ShoppingProduct {
    @EmbeddedId
    private ShoppingProductPK id;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    @Column(name = "cantidad")
    private int quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Shopping shopping;
}
