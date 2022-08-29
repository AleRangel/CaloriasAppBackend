package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

public class ComidaDTO {
    private Long id;

    @NotEmpty    
    private String comida;

    @NotEmpty
    private double gramos;

    @NotEmpty
    private double proteinas;

    @NotEmpty
    private double calorias;

    @NotEmpty
    private double carbohidratos;

    public ComidaDTO(Long id, String comida, double gramos, double proteinas, double calorias, double carbohidratos) {
        super();
        this.id = id;
        this.comida = comida;
        this.gramos = gramos;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;

    }

    public ComidaDTO() {
        super();
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the comida
     */
    public String getComida() {
        return comida;
    }

    /**
     * @param comida the comida to set
     */
    public void setComida(String comida) {
        this.comida = comida;
    }

    /**
     * @return Double return the gramos
     */
    public double getGramos() {
        return gramos;
    }

    /**
     * @param gramos the gramos to set
     */
    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    /**
     * @return Double return the proteinas
     */
    public double getProteinas() {
        return proteinas;
    }

    /**
     * @param proteinas the proteinas to set
     */
    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    /**
     * @return Double return the calorias
     */
    public double getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    /**
     * @return Double return the carbohidratos
     */
    public double getCarbohidratos() {
        return carbohidratos;
    }

    /**
     * @param carbohidratos the carbohidratos to set
     */
    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

}
