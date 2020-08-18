package com.tensquare.qa.pojo;

import javax.persistence.*;

@Entity
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String coed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoed() {
        return coed;
    }

    public void setCoed(String coed) {
        this.coed = coed;
    }
}
