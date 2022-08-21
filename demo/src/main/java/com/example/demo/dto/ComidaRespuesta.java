package com.example.demo.dto;

import java.util.List;

public class ComidaRespuesta {

    private List<ComidaDTO> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;

    public ComidaRespuesta() {
        super();
    }

    /**
     * @return List<ComidaDTO> return the contenido
     */
    public List<ComidaDTO> getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(List<ComidaDTO> contenido) {
        this.contenido = contenido;
    }

    /**
     * @return int return the numeroPagina
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * @param numeroPagina the numeroPagina to set
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    /**
     * @return int return the medidaPagina
     */
    public int getMedidaPagina() {
        return medidaPagina;
    }

    /**
     * @param medidaPagina the medidaPagina to set
     */
    public void setMedidaPagina(int medidaPagina) {
        this.medidaPagina = medidaPagina;
    }

    /**
     * @return long return the totalElementos
     */
    public long getTotalElementos() {
        return totalElementos;
    }

    /**
     * @param totalElementos the totalElementos to set
     */
    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    /**
     * @return int return the totalPaginas
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }

    /**
     * @param totalPaginas the totalPaginas to set
     */
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    /**
     * @return boolean return the ultima
     */
    public boolean isUltima() {
        return ultima;
    }

    /**
     * @param ultima the ultima to set
     */
    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

}
