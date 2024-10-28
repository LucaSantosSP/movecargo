package com.LucaSantosSP.movecargo.objeto.conteiner;

import com.LucaSantosSP.movecargo.objeto.cliente.TabClienteObj;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tab_conteiner")
@Entity(name = "tab_conteiner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabConteinerObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_conteiner")
    private Integer cdConteiner;

    @Column(name = "tx_conteiner")
    private String txConteiner;

    @ManyToOne
    @JoinColumn(name = "cd_cliente")
    private TabClienteObj tabClienteObj;

    @Column(name = "cd_tipo")
    private Integer cdTipo;

    @Column(name = "ck_status")
    private Boolean ckStatus;

    @Column(name = "cd_categoria")
    private Integer cdCategoria;

}
