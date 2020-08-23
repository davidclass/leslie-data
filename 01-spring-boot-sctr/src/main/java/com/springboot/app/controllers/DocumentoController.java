package com.springboot.app.controllers;

import com.springboot.app.models.dao.IDodumentoDao;
import com.springboot.app.models.entity.Documento;
import com.springboot.app.models.service.IDocumentoService;
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
@SessionAttributes("documento")
public class DocumentoController {

    @Autowired
    @Qualifier("documentoServiceJPA")
    private IDocumentoService documentoService;

    @RequestMapping(value = "/listar/documentos", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Documentos");
        model.addAttribute("documentos", documentoService.findAll());
        return "listarDocumentos"; //Retornamos nombre de la vista (el nombre del archivo html)
    }

    /* Metodo para agregar un nuevo Documento */
    //primera fase : mostrar el formulario
    // ("/form/documento") Hace referencia  <a th:href="@{/form/documento}">Crear SCTR</a> de listarDocumentos.html
    @RequestMapping(value = "/form/documento")
    public String crear(Map<String, Object> model){
        Documento documento = new Documento();
        model.put("documento", documento);
        model.put("titulo", "Formulario de Documento");
        return "formDocumento"; //Retorna el nombre de la vista, tal cual como la URL del RequestMapping

    }

    /* Metodo para editar un Documento */
    @RequestMapping(value = "/form/documento/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Documento documento = null;

        if(id > 0){ //Si hay algun id a buscar
            documento = documentoService.findOne(id);
        }else{
            return "redirect:/listar/documentos";
        }

        //Pasamos los valores a la vista
        model.put("documento", documento);
        model.put("titulo", "Editar un Documento ");

        return "formDocumento";
    }

    //Segunda fase : enviar el formulario con los datos
    // (value = "/form/documento", method = RequestMethod.POST)  Hace referencia <form th:action="@{/form/documento}" th:object="${documento}" method="post">  de formDocumento.html
    @RequestMapping(value = "/form/documento", method = RequestMethod.POST)
    public String guardar(@Valid Documento documento, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de Documento");
            return "formDocumento";
        }
        documentoService.save(documento);
        status.setComplete();
        return "redirect:/listar/documentos";//Redirigimos a la vista del listar (el nombre del archivo listarDocumentos.html)
    }

    @RequestMapping(value = "/eliminar/documento/{id}")
    public  String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            documentoService.delete(id);
        }
        return "redirect:/listar/documentos";//Redirigimos a la vista del listar (el nombre del archivo listarDocumentos.html)
    }
}
