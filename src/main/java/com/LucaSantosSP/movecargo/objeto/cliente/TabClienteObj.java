package com.LucaSantosSP.movecargo.objeto.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "tab_cliente")
@Entity(name = "tab_cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabClienteObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cliente")
    private Integer cdCliente;

    @Column(name = "tx_cliente")
    private String txCliente;

}
