package com.springboot.app.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "colaboradores")
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty
    @Column(name = "numero_doc")
    private String numeroDoc;

    @NotEmpty
    @Column(name = "empresa")
    private String empresa;

    //@NotEmpty
    @Column(name = "foto")
    private String foto;

    @NotNull
    @Column(name = "fech_nac")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @JoinColumn(name = "sctrp_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Sctrp sctrp_id;

/*
    @JoinColumn(name = "sctrs_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Sctrs sctrs_id;

^*/
    /////////////////////////////////////////

    @JoinColumn(name = "sctrs_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sctrs sctrs_id;

    /////////////////////////////////////////

    @JoinColumn(name = "carnets_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Carnets carnets_id;

    @JoinColumn(name = "documento_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Documento documento_id;

    @JoinColumn(name = "induccion_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Induccion induccion_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sctrp getSctrp_id() {
        return sctrp_id;
    }

    public void setSctrp_id(Sctrp sctrp_id) {
        this.sctrp_id = sctrp_id;
    }

    public Sctrs getSctrs_id() {
        return sctrs_id;
    }

    public void setSctrs_id(Sctrs sctrs_id) {
        this.sctrs_id = sctrs_id;
    }

    public Carnets getCarnets_id() {
        return carnets_id;
    }

    public void setCarnets_id(Carnets carnets_id) {
        this.carnets_id = carnets_id;
    }

    public Documento getDocumento_id() {
        return documento_id;
    }

    public void setDocumento_id(Documento documento_id) {
        this.documento_id = documento_id;
    }

    public Induccion getInduccion_id() {
        return induccion_id;
    }

    public void setInduccion_id(Induccion induccion_id) {
        this.induccion_id = induccion_id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

}
