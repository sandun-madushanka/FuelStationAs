package mypojos;
// Generated Aug 12, 2019 9:07:05 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * FuelstockHasUser generated by hbm2java
 */
public class FuelstockHasUser  implements java.io.Serializable {


     private Integer fuelstockHasUserid;
     private Fuelstock fuelstock;
     private User user;
     private Date dateintake;
     private Double qtyintake;
     private Double suprate;
     private Double total;
     private Integer status;

    public FuelstockHasUser() {
    }

	
    public FuelstockHasUser(Fuelstock fuelstock, User user) {
        this.fuelstock = fuelstock;
        this.user = user;
    }
    public FuelstockHasUser(Fuelstock fuelstock, User user, Date dateintake, Double qtyintake, Double suprate, Double total, Integer status) {
       this.fuelstock = fuelstock;
       this.user = user;
       this.dateintake = dateintake;
       this.qtyintake = qtyintake;
       this.suprate = suprate;
       this.total = total;
       this.status = status;
    }
   
    public Integer getFuelstockHasUserid() {
        return this.fuelstockHasUserid;
    }
    
    public void setFuelstockHasUserid(Integer fuelstockHasUserid) {
        this.fuelstockHasUserid = fuelstockHasUserid;
    }
    public Fuelstock getFuelstock() {
        return this.fuelstock;
    }
    
    public void setFuelstock(Fuelstock fuelstock) {
        this.fuelstock = fuelstock;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Date getDateintake() {
        return this.dateintake;
    }
    
    public void setDateintake(Date dateintake) {
        this.dateintake = dateintake;
    }
    public Double getQtyintake() {
        return this.qtyintake;
    }
    
    public void setQtyintake(Double qtyintake) {
        this.qtyintake = qtyintake;
    }
    public Double getSuprate() {
        return this.suprate;
    }
    
    public void setSuprate(Double suprate) {
        this.suprate = suprate;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }




}


