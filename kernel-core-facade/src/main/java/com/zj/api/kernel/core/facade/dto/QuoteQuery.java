package com.zj.api.kernel.core.facade.dto;

import java.io.Serializable;

/**
 * Created by js on 2017/1/17.
 */
public class QuoteQuery implements Serializable {

    private static final long serialVersionUID = 1916441997530389837L;

    private String stockCodes;

    public String getStockCodes() {
        return stockCodes;
    }

    public void setStockCodes(String stockCodes) {
        this.stockCodes = stockCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteQuery that = (QuoteQuery) o;

        return stockCodes != null ? stockCodes.equals(that.stockCodes) : that.stockCodes == null;

    }

    @Override
    public int hashCode() {
        return stockCodes != null ? stockCodes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "QuoteQuery{" +
                "stockCodes='" + stockCodes + '\'' +
                '}';
    }
}
