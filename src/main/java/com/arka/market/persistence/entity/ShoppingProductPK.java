package com.arka.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class ShoppingProductPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idShopping;

    @Column(name = "id_producto")
    private Integer idProduct;

}
