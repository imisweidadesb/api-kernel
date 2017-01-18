package com.zj.api.kernel.common.dao.query;

/**
 * Created by js on 2017/1/17.
 */
public class StockQuery extends BaseQuery {

    private static final long serialVersionUID = -1142801390151452642L;

    private String stockName;

    private String stockCode;

    private String simpleName;

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

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StockQuery that = (StockQuery) o;

        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;
        if (stockCode != null ? !stockCode.equals(that.stockCode) : that.stockCode != null) return false;
        return simpleName != null ? simpleName.equals(that.simpleName) : that.simpleName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (stockCode != null ? stockCode.hashCode() : 0);
        result = 31 * result + (simpleName != null ? simpleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StockQuery{" +
                "stockName='" + stockName + '\'' +
                ", stockCode='" + stockCode + '\'' +
                ", simpleName='" + simpleName + '\'' +
                '}';
    }
}
