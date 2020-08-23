package com.springboot.app.controllers;

import com.springboot.app.models.entity.Sctrp;
import com.springboot.app.models.service.ISctrpService;
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
@SessionAttributes("sctrp")
public class SctrpController {

    @Autowired
    @Qualifier("sctrpServiceJPA")
    private ISctrpService sctrpService;

    @RequestMapping(value = "/listar/sctrPensiones", method = RequestMethod.GET)
    public String listar(Model model){
        //System.out.println(sctrpDao.findAll());
        model.addAttribute("titulo", "Listado de SCTR - Pension");
        model.addAttribute("sctrPensiones", sctrpService.findAll());
        return "listarSctrPensiones"; //Retornamos nombre de la vista (el nombre del archivo html)
    }

    /* Metodo para agregar un nuevo SCTRP */
    //primera fase : mostrar el formulario
    // ("/form/sctrp") Hace referencia  <a th:href="@{/form/sctrp}">Crear SCTR</a> de listarSctrPensiones.html
    @RequestMapping(value = "/form/sctrp")
    public String crear(Map<String, Object> model){
        Sctrp sctrp = new Sctrp();
        model.put("sctrp", sctrp);
        model.put("titulo", "Formulario de SCTR - Pensión");
        return "formSctrPension"; //Retorna el nombre de la vista, tal cual como la URL del RequestMapping

    }

    /* Metodo para editar un SCTRP */
    @RequestMapping(value = "/form/sctrp/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Sctrp sctrp = null;

        if(id > 0){ //Si hay algun id a buscar
            sctrp = sctrpService.findOne(id);
        }else{
            return "redirect:/listar/sctrPensiones";
        }

        //Pasamos los valores a la vista
        model.put("sctrp", sctrp);
        model.put("titulo", "Editar SCTR - Pensión ");

        return "formSctrPension";
    }

    //Segunda fase : enviar el formulario con los datos
    // (value = "/form/sctrp", method = RequestMethod.POST)  Hace referencia <form th:action="@{/form/sctrp}" th:object="${sctrp}" method="post">  de formSctrPension.html
    @RequestMapping(value = "/form/sctrp", method = RequestMethod.POST)
    public String guardar(@Valid Sctrp sctrp, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de SCTR - Pensión");
            return "formSctrPension";
        }
        sctrpService.save(sctrp);
        status.setComplete();
        return "redirect:/listar/sctrPensiones";//Redirigimos a la vista del listar (el nombre del archivo listarSctrPensiones.html)
    }

    @RequestMapping(value = "/eliminar/sctrp/{id}")
    public  String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            sctrpService.delete(id);
        }
        return "redirect:/listar/sctrPensiones";//Redirigimos a la vista del listar (el nombre del archivo listarSctrPensiones.html)
    }
}
