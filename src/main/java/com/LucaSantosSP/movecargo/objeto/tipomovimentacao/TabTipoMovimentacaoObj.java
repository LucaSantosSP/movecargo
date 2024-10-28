package com.LucaSantosSP.movecargo.objeto.tipomovimentacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tab_tipo_movimentacao")
@Entity(name = "tab_tipo_movimentacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabTipoMovimentacaoObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_tipo_movimentacao")
    private Integer cdTipoMovimentacao;

    @Column(name = "tx_tipo_movimentacao")
    private String txTipoMovimentacao;

}
