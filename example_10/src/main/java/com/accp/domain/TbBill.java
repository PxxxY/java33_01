package com.accp.domain;

import java.util.List;

public class TbBill {
    private String billno;

    private String billdate;

    private String suppliername;

    private String supplieraddress;

    private String department;

    private String warehouse;

    private String buyer;

    private String executor;
    private Double sumprice;
    public void setSumprice(Double sumprice) {
		this.sumprice = sumprice;
	}
    
    public Double getSumprice() {
		return sumprice;
	}
    private List<TbDetail> details;

   
    public List<TbDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TbDetail> details) {
		this.details = details;
	}

	public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public void setSupplieraddress(String supplieraddress) {
        this.supplieraddress = supplieraddress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }
}