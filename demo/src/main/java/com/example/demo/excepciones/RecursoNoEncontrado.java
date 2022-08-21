package com.example.demo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;

    public RecursoNoEncontrado(String nombreDelRecurso, String nombreDelCampo, Long valorDelCampo) {
        super(String.format("%s no encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    /**
     * @return String return the nombreDelRecurso
     */
    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    /**
     * @param nombreDelRecurso the nombreDelRecurso to set
     */
    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    /**
     * @return String return the nombreDelCampo
     */
    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    /**
     * @param nombreDelCampo the nombreDelCampo to set
     */
    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    /**
     * @return Long return the valorDelCampo
     */
    public Long getValorDelCampo() {
        return valorDelCampo;
    }

    /**
     * @param valorDelCampo the valorDelCampo to set
     */
    public void setValorDelCampo(Long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }

}
