package com.jourdanwoodrich.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(min = 4, max = 25, message = "{addpart.partName.size}")
    @Column(name = "partName")
    private String partName;

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

    public PartUpdate(String partName){
        this.partName = partName;
    }

    public PartUpdate(String partName, Date added){
        this.partName = partName;
        this.added=added;
    }

    public PartUpdate(String text, BigDecimal materialCost, Date added){
        this.partName = text;
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

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
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
        if (partName != null ? !partName.equals(partUpdate.partName) : partUpdate.partName != null) return false;
        if (materialCost != null ? !materialCost.equals(partUpdate.materialCost) : partUpdate.materialCost != null)
            return false;
        return added != null ? added.equals(partUpdate.added) : partUpdate.added == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partName != null ? partName.hashCode() : 0);
        result = 31 * result + (materialCost != null ? materialCost.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PartUpdate{" +
                "id=" + id +
                ", text='" + partName + '\'' +
                ", materialCost=" + materialCost +
                ", added=" + added +
                '}';
    }
}
