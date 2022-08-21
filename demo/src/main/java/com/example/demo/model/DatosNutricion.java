package com.example.demo.model;

import java.util.ArrayList;

import scraper.Scraper;

public class DatosNutricion {

    private Integer gramos = 0;
    private Integer calorias = 0;
    private Double grasasTotales = 0.0;
    private Double carbohidratos = 0.0;
    private Double proteinas = 0.0;
    private String alimento = "";

    public DatosNutricion(String alimento) {
        this.alimento = alimento;

        mandarDatos();
    }

    Scraper datosNutricion = new Scraper();

    public ArrayList<String> mandarDatos() {

        ArrayList<String> datosDeAlimentos = datosNutricion.scrapingHtml(this.alimento);

        /*
         * String grString = datosDeAlimentos.get(2);
         * String kcalString = datosDeAlimentos.get(5);
         * String grasasString = datosDeAlimentos.get(8);
         * String carbohidratosString = datosDeAlimentos.get(25);
         * String proteinasString = datosDeAlimentos.get(35);
         */

        /*
         * int grInt = Integer.parseInt(grString);
         * int kcalInt = Integer.parseInt(kcalString);
         * double grasasTotalesDouble = Double.parseDouble(grasasString);
         * double carbohidratosDouble = Double.parseDouble(carbohidratosString);
         * double proteinasDouble = Double.parseDouble(proteinasString);
         */

        /*
         * this.gramos = grInt;
         * this.calorias = kcalInt;
         * this.grasasTotales = grasasTotalesDouble;
         * this.carbohidratos = carbohidratosDouble;
         * this.proteinas = proteinasDouble;
         */
        return datosDeAlimentos;
    }

    /**
     * @return Integer return the gramos
     */
    public Integer getGramos() {
        return gramos;
    }

    /**
     * @param gramos the gramos to set
     */
    public void setGramos(Integer gramos) {
        this.gramos = gramos;
    }

    /**
     * @return Integer return the calorias
     */
    public Integer getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    /**
     * @return Double return the grasasTotales
     */
    public Double getGrasasTotales() {
        return grasasTotales;
    }

    /**
     * @param grasasTotales the grasasTotales to set
     */
    public void setGrasasTotales(Double grasasTotales) {
        this.grasasTotales = grasasTotales;
    }

    /**
     * @return Double return the carbohidratos
     */
    public Double getCarbohidratos() {
        return carbohidratos;
    }

    /**
     * @param carbohidratos the carbohidratos to set
     */
    public void setCarbohidratos(Double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /**
     * @return Double return the proteinas
     */
    public Double getProteinas() {
        return proteinas;
    }

    /**
     * @param proteinas the proteinas to set
     */
    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
    }

    /**
     * @return String return the alimento
     */
    public String getAlimento() {
        return alimento;
    }

    /**
     * @param alimento the alimento to set
     */
    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

}
