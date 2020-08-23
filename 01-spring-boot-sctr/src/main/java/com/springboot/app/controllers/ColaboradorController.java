package com.springboot.app.controllers;

import com.springboot.app.models.dao.IColaboradorDao;
import com.springboot.app.models.entity.Colaborador;
import com.springboot.app.models.service.IColaboradorService;
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
@SessionAttributes("colaborador")
public class ColaboradorController {

    @Autowired
    @Qualifier("colaboradorServiceJPA")
    private IColaboradorService colaboradorService;

    @RequestMapping(value = "/listar/colaboradores", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Colaboradores");
        model.addAttribute("colaboradores", colaboradorService.findAll());
        return "listarColaboradores"; //Retornamos nombre de la vista (el nombre del archivo html)
    }

    /* Metodo para agregar un nuevo Colaborador */
    //primera fase : mostrar el formulario
    // ("/form/colaborador") Hace referencia  <a th:href="@{/form/colaborador}">Crear Colaborador</a> de listarColaboradores.html
    @RequestMapping(value = "/form/colaborador")
    public String crear(Map<String, Object> model){
        Colaborador colaborador = new Colaborador();
        model.put("colaborador", colaborador);
        model.put("titulo", "Formulario de Colaborador");
        return "formColaborador"; //Retorna el nombre de la vista, tal cual como la URL del RequestMapping

    }

    /* Metodo para editar un Colaborador */
    @RequestMapping(value = "/form/colaborador/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        System.out.println("-1");
        Colaborador colaborador = null;
        System.out.println("0");
        if(id > 0){ //Si hay algun id a buscar
            System.out.println("1");
            colaborador = colaboradorService.findOne(id);
            System.out.println("2");
        }else{
            System.out.println("3");
            return "redirect:/listar/colaboradores";
        }

        //Pasamos los valores a la vista
        System.out.println("4");
        model.put("colaborador", colaborador);
        System.out.println("5");
        model.put("titulo", "Editar un Colaborador ");
        System.out.println("6");
        return "formColaborador";
    }

    //Segunda fase : enviar el formulario con los datos
    // (value = "/form/colaborador", method = RequestMethod.POST)  Hace referencia <form th:action="@{/form/colaborador}" th:object="${colaborador}" method="post">  de formSctrSalud.html
    @RequestMapping(value = "/form/colaborador", method = RequestMethod.POST)
    public String guardar(@Valid Colaborador colaborador, BindingResult result, Model model, SessionStatus status){
        System.out.println("7: " + result.getAllErrors());
        System.out.println("7.1: " + (Colaborador)model.getAttribute("colaborador"));
        if(result.hasErrors()){
            System.out.println("8");
            model.addAttribute("titulo", "Formulario de Colaborador");
            System.out.println("9");
            return "formColaborador";
        }
        System.out.println("10");
        colaboradorService.save(colaborador);
        System.out.println("11");
        status.setComplete();
        return "redirect:/listar/colaboradores";//Redirigimos a la vista del listar (el nombre del archivo listarColaboradores.html)
    }

    @RequestMapping(value = "/eliminar/colaborador/{id}")
    public  String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            colaboradorService.delete(id);
        }
        return "redirect:/listar/colaboradores";//Redirigimos a la vista del listar (el nombre del archivo listarColaboradores.html)
    }
}
