package com.springboot.app.controllers;

import com.springboot.app.models.dao.ICarnetsDao;
import com.springboot.app.models.entity.Carnets;
import com.springboot.app.models.service.ICarnetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("carnets")
public class CarnetsController {

    @Autowired
    @Qualifier("carnetsServiceJPA")
    private ICarnetsService carnetsService;

    @RequestMapping(value = "/listar/carnetSanidades", method = RequestMethod.GET)
    public String listar(Model model){
        System.out.println("CDS: " + carnetsService.findAll());
        model.addAttribute("titulo", "Listado de Carnet de Sanidades");
        model.addAttribute("carnetSanidades", carnetsService.findAll());
        return "listarCarnetSanidades"; //Retornamos nombre de la vista (el nombre del archivo html)
    }

    /* Metodo para agregar un nuevo CARNET DE SANIDAD */
    //primera fase : mostrar el formulario
    // ("/form/carnets") Hace referencia  <a th:href="@{/form/carnets}">Crear Carnet</a> de listarCarnetSanidades.html
    @RequestMapping(value = "/form/carnets")
    public String crear(Map<String, Object> model){
        Carnets carnets = new Carnets();
        model.put("carnets", carnets);
        model.put("titulo", "Formulario del Carnet de Sanidad");
        return "formCarnetSanidad"; //Retorna el nombre de la vista, tal cual como la URL del RequestMapping

    }

    /* Metodo para editar un Carnet Sanidad */
    @RequestMapping(value = "/form/carnets/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Carnets carnets = null;

        if(id > 0){ //Si hay algun id a buscar
            carnets = carnetsService.findOne(id);
        }else{
            return "redirect:/listar/carnetSanidades";
        }

        //Pasamos los valores a la vista
        model.put("carnets", carnets);
        model.put("titulo", "Editar un Carnet de Sanidad");

        return "formCarnetSanidad";
    }

    //Segunda fase : enviar el formulario con los datos
    // (value = "/form/carnets", method = RequestMethod.POST)  Hace referencia <form th:action="@{/form/sctrs}" th:object="${sctrs}" method="post">  de formSctrSalud.html
    @RequestMapping(value = "/form/carnets", method = RequestMethod.POST)
    public String guardar(@Valid Carnets carnets, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario del Carnet de Sanidad");
            return "formCarnetSanidad";
        }
        carnetsService.save(carnets);
        status.setComplete();
        return "redirect:/listar/carnetSanidades";//Redirigimos a la vista del listar (el nombre del archivo listarCarnetSanidades.html)
    }

    @RequestMapping(value = "/eliminar/carnets/{id}")
    public  String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            carnetsService.delete(id);
        }
        return "redirect:/listar/carnetSanidades";//Redirigimos a la vista del listar (el nombre del archivo listarCarnetSanidades.html)
    }
}
