package com.LucaSantosSP.movecargo.controller.movimentacao;

import com.LucaSantosSP.movecargo.objeto.cliente.TabClienteObj;
import com.LucaSantosSP.movecargo.objeto.cliente.repository.TabClienteRepository;
import com.LucaSantosSP.movecargo.objeto.conteiner.TabConteinerObj;
import com.LucaSantosSP.movecargo.objeto.conteiner.repository.TabConteinerRepository;
import com.LucaSantosSP.movecargo.objeto.movimentacao.TabMovimentacaoObj;
import com.LucaSantosSP.movecargo.objeto.movimentacao.repository.TabMovimentacaoRepository;
import com.LucaSantosSP.movecargo.objeto.tipomovimentacao.TabTipoMovimentacaoObj;
import com.LucaSantosSP.movecargo.objeto.tipomovimentacao.repository.TabTipoMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/movimentacao")
public class TabMovimentacaoController {

    @Autowired
    private TabMovimentacaoRepository tabMovimentacaoRepository;

    @Autowired
    private TabTipoMovimentacaoRepository tabTipoMovimentacaoRepository;

    @Autowired
    private TabConteinerRepository tabConteinerRepository;

    String txUrlTela = "/movimentacao";
    String txUrlTelaPesquisa = "/movimentacaopesquisa";

    @GetMapping()
    public ModelAndView pesquisaGeral(){
        ModelAndView mv = new ModelAndView(txUrlTelaPesquisa);

        List<TabMovimentacaoObj> tabMovimentacaoObjList = tabMovimentacaoRepository.findAll();
        List<TabConteinerObj> tabConteinerObjList = tabConteinerRepository.findAll();

        mv.addObject("tabMovimentacaoObjList", tabMovimentacaoObjList);
        mv.addObject("tabConteinerObjList", tabConteinerObjList);

        return mv;
    }

    @GetMapping("/consultar/{cdMovimentacao}")
    public ModelAndView consultar(@PathVariable Integer cdMovimentacao){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabMovimentacaoObj tabMovimentacaoObj = tabMovimentacaoRepository.findById(cdMovimentacao).orElse(null);
        List<TabTipoMovimentacaoObj> tabTipoMovimentacaoObjs = tabTipoMovimentacaoRepository.findAll();
        List<TabConteinerObj> tabConteinerObjs = tabConteinerRepository.findAll();

        mv.addObject("tabMovimentacaoObj", tabMovimentacaoObj);
        mv.addObject("cdMovimentacao", cdMovimentacao);
        mv.addObject("tabTipoMovimentacaoObjs", tabTipoMovimentacaoObjs);
        mv.addObject("tabConteinerObjs", tabConteinerObjs);

        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabMovimentacaoObj tabMovimentacaoObj = new TabMovimentacaoObj();
        List<TabTipoMovimentacaoObj> tabTipoMovimentacaoObjs = tabTipoMovimentacaoRepository.findAll();
        List<TabConteinerObj> tabConteinerObjs = tabConteinerRepository.findAll();

        mv.addObject("tabMovimentacaoObj", tabMovimentacaoObj);
        mv.addObject("tabTipoMovimentacaoObjs", tabTipoMovimentacaoObjs);
        mv.addObject("tabConteinerObjs", tabConteinerObjs);

        return mv;
    }

    @PostMapping("salvar")
    public ModelAndView salvar(@ModelAttribute("tabContainerObj") TabMovimentacaoObj tabMovimentacaoObj){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabMovimentacaoObj tabMovimentacaoObjNew = tabMovimentacaoRepository.save(tabMovimentacaoObj);
        List<TabTipoMovimentacaoObj> tabTipoMovimentacaoObjs = tabTipoMovimentacaoRepository.findAll();
        List<TabConteinerObj> tabConteinerObjs = tabConteinerRepository.findAll();

        mv.addObject("tabMovimentacaoObj", tabMovimentacaoObjNew);
        mv.addObject("tabTipoMovimentacaoObjs", tabTipoMovimentacaoObjs);
        mv.addObject("cdMovimentacao", tabMovimentacaoObjNew.getCdMovimentacao());
        mv.addObject("tabConteinerObjs", tabConteinerObjs);

        return mv;
    }

    @PostMapping("/excluir")
    public String excluir(@ModelAttribute("tabContainerObj") TabMovimentacaoObj tabMovimentacaoObj){
        tabMovimentacaoRepository.delete(tabMovimentacaoObj);
        return "redirect:/movimentacao";
    }

}
