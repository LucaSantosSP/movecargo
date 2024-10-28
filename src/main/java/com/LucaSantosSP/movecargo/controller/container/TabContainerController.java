package com.LucaSantosSP.movecargo.controller.container;

import com.LucaSantosSP.movecargo.objeto.cliente.TabClienteObj;
import com.LucaSantosSP.movecargo.objeto.cliente.repository.TabClienteRepository;
import com.LucaSantosSP.movecargo.objeto.conteiner.TabConteinerObj;
import com.LucaSantosSP.movecargo.objeto.conteiner.repository.TabConteinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/conteiner")
public class TabContainerController {

    @Autowired
    private TabConteinerRepository tabConteinerRepository;

    @Autowired
    private TabClienteRepository tabClienteRepository;

    String txUrlTela = "/conteiner";
    String txUrlTelaPesquisa = "/conteinerpesquisa";

    @GetMapping()
    public ModelAndView pesquisaGeral(){
        ModelAndView mv = new ModelAndView(txUrlTelaPesquisa);

        List<TabConteinerObj> tabConteinerObjList = tabConteinerRepository.findAll();

        mv.addObject("tabConteinerObjList", tabConteinerObjList);

        return mv;
    }

    @GetMapping("/consultar/{cdConteiner}")
    public ModelAndView consultar(@PathVariable Integer cdConteiner){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabConteinerObj tabConteinerObj = tabConteinerRepository.findById(cdConteiner).orElse(null);
        List<TabClienteObj> tabClienteObjList = tabClienteRepository.findAll();

        mv.addObject("tabConteinerObj", tabConteinerObj);
        mv.addObject("cdConteiner", cdConteiner);
        mv.addObject("tabClienteObjList", tabClienteObjList);

        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabConteinerObj tabConteinerObj = new TabConteinerObj();
        List<TabClienteObj> tabClienteObjList = tabClienteRepository.findAll();

        mv.addObject("tabConteinerObj", tabConteinerObj);
        mv.addObject("tabClienteObjList", tabClienteObjList);

        return mv;
    }

    @PostMapping("salvar")
    public ModelAndView salvar(@ModelAttribute("tabContainerObj") TabConteinerObj tabConteinerObj){
        ModelAndView mv = new ModelAndView(txUrlTela);

        TabConteinerObj tabConteinerObjNew = tabConteinerRepository.save(tabConteinerObj);
        List<TabClienteObj> tabClienteObjList = tabClienteRepository.findAll();

        mv.addObject("tabConteinerObj", tabConteinerObjNew);
        mv.addObject("tabClienteObjList", tabClienteObjList);
        mv.addObject("cdConteiner", tabConteinerObjNew.getCdConteiner());

        return mv;
    }

    @PostMapping("/excluir")
    public String excluir(@ModelAttribute("tabContainerObj") TabConteinerObj tabConteinerObj){
        tabConteinerRepository.delete(tabConteinerObj);
        return "redirect:/conteiner";
    }

}
