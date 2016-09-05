package com.jourdanwoodrich.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */

@Entity
@Table(name = "parts")
public class PartUpdate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "materialCost")
    private BigDecimal materialCost;

    @Column(name = "added")
    @Temporal(TemporalType.DATE)
    private Date added;

    @PrePersist
    private void onCreate(){
        if (added == null){
            added = new Date();
        }
    }

    public PartUpdate(){

    }

    public PartUpdate(String text){
        this.text = text;
    }

    public PartUpdate(String text, Date added){
        this.text = text;
        this.added=added;
    }

    public PartUpdate(String text, BigDecimal materialCost, Date added){
        this.text = text;
        this.materialCost=materialCost;
        this.added=added;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartUpdate partUpdate = (PartUpdate) o;

        if (id != null ? !id.equals(partUpdate.id) : partUpdate.id != null) return false;
        if (text != null ? !text.equals(partUpdate.text) : partUpdate.text != null) return false;
        if (materialCost != null ? !materialCost.equals(partUpdate.materialCost) : partUpdate.materialCost != null)
            return false;
        return added != null ? added.equals(partUpdate.added) : partUpdate.added == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (materialCost != null ? materialCost.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PartUpdate{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", materialCost=" + materialCost +
                ", added=" + added +
                '}';
    }
}
