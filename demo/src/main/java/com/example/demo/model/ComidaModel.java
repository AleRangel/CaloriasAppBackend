package com.example.demo.model;

import javax.persistence.*;




@Entity
@Table(name = "comidas")
public class ComidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comida", nullable = false)
    private String comida;

    @Column(name = "gramos", nullable = false, columnDefinition = "DECIMAL (10,2)")
    private double gramos;

    @Column(name = "proteinas", nullable = false, columnDefinition = "DECIMAL (10,2)")
    private double proteinas;

    @Column(name = "calorias", nullable = false, columnDefinition = "DECIMAL (10,2)")
    private double calorias;

    @Column(name = "carbohidratos", nullable = false, columnDefinition = "DECIMAL (10,2)")
    private double carbohidratos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_Id", nullable = false)    
    private UsuarioModel usuarioModel;

    public ComidaModel() {
        super();
    }

    public ComidaModel(long id, String comida, double gramos, double proteinas, double calorias,
            Double carbohidratos, UsuarioModel usuarioModel) {
        super();
        this.id = id;
        this.comida = comida;
        this.gramos = gramos;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.usuarioModel = usuarioModel;

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

    /**
     * @return UsuarioModel return the usuarioModel
     */
    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    /**
     * @param usuarioModel the usuarioModel to set
     */
    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

}
