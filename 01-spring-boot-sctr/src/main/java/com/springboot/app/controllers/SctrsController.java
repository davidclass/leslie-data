package com.springboot.app.controllers;

import com.springboot.app.models.entity.Sctrs;
import com.springboot.app.models.service.ISctrsService;
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
@SessionAttributes("sctrs")
public class SctrsController {

    @Autowired
    @Qualifier("sctrsServiceJPA")
    private ISctrsService sctrsService;

    /* Metodo  para listar */
    @RequestMapping(value = "/listar/sctrSalues", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de SCTR - Salud");
        model.addAttribute("sctrSalues", sctrsService.findAll());
        return "listarSctrSalues"; //Retornamos nombre de la vista (el nombre del archivo html)
    }

    /* Metodo para agregar un nuevo SCTRS */
    //primera fase : mostrar el formulario
    // ("/form/sctrs") Hace referencia  <a th:href="@{/form/sctrs}">Crear SCTR</a> de listarSctrSalues.html
    @RequestMapping(value = "/form/sctrs")
    public String crear(Map<String, Object> model){
        Sctrs sctrs = new Sctrs();
        model.put("sctrs", sctrs);
        model.put("titulo", "Formulario de SCTR - Salud ");
        return "formSctrSalud"; //Retorna el nombre de la vista, tal cual como la URL del RequestMapping

    }

    /* Metodo para editar un SCTRS */
    @RequestMapping(value = "/form/sctrs/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Sctrs sctrs = null;

        if(id > 0){ //Si hay algun id a buscar
            sctrs = sctrsService.findOne(id);
        }else{
            return "redirect:/listar/sctrSalues";
        }

        //Pasamos los valores a la vista
        model.put("sctrs", sctrs);
        model.put("titulo", "Editar SCTR - Salud ");

        return "formSctrSalud";
    }


    //Segunda fase : enviar el formulario con los datos
    // (value = "/form/sctrs", method = RequestMethod.POST)  Hace referencia <form th:action="@{/form/sctrs}" th:object="${sctrs}" method="post">  de formSctrSalud.html
    @RequestMapping(value = "/form/sctrs", method = RequestMethod.POST)
    public String guardar(@Valid Sctrs sctrs, BindingResult result, Model model, SessionStatus status){ // "@Valid" habilitamos la validacion, "BindingResult" objeto para cargar los mensaje de error
        //(Ambos siempre van juntos) tanto el objeto como el BingingResult y luego el model
        //@Valid @ModelAttributes("clienteOtro") Sctrs sctrs, BindingResult result, Model model -> Usariamos @ModelAttributes cuando pasamos con otro nombre que no sea igual a la case el atributo
        //Preguntamos si hay error
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de SCTR - Salud");
            return "formSctrSalud";
        }
        sctrsService.save(sctrs);
        status.setComplete();
        return "redirect:/listar/sctrSalues";//Redirigimos a la vista del listar (el nombre del archivo listarSctrSalues.html)
    }

    @RequestMapping(value = "/eliminar/sctrs/{id}")
    public  String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            sctrsService.delete(id);
        }
        return "redirect:/listar/sctrSalues";//Redirigimos a la vista del listar (el nombre del archivo listarSctrSalues.html)
    }
}
