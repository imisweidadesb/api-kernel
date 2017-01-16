package com.zj.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by js on 2017/1/16.
 */
public class Stock implements Serializable {

    private static final long serialVersionUID = 4493431298583920238L;

    private Integer id;

    private String stockName;

    private String stockCode;

    private String spell;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != null ? !id.equals(stock.id) : stock.id != null) return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;
        if (stockCode != null ? !stockCode.equals(stock.stockCode) : stock.stockCode != null) return false;
        if (spell != null ? !spell.equals(stock.spell) : stock.spell != null) return false;
        return createTime != null ? createTime.equals(stock.createTime) : stock.createTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (stockCode != null ? stockCode.hashCode() : 0);
        result = 31 * result + (spell != null ? spell.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockName='" + stockName + '\'' +
                ", stockCode='" + stockCode + '\'' +
                ", spell='" + spell + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
