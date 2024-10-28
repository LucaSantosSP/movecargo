package com.LucaSantosSP.movecargo.objeto.movimentacao;

import com.LucaSantosSP.movecargo.objeto.cliente.TabClienteObj;
import com.LucaSantosSP.movecargo.objeto.conteiner.TabConteinerObj;
import com.LucaSantosSP.movecargo.objeto.tipomovimentacao.TabTipoMovimentacaoObj;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Table(name = "tab_movimentacao")
@Entity(name = "tab_movimentacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabMovimentacaoObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_movimentacao")
    private Integer cdMovimentacao;

    @ManyToOne
    @JoinColumn(name = "cd_tipo_movimentacao")
    private TabTipoMovimentacaoObj tabTipoMovimentacaoObj;

    @Column(name = "dt_inicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtInicio;

    @Column(name = "dt_final")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtFinal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_conteiner")
    private TabConteinerObj tabConteinerObj;

}
