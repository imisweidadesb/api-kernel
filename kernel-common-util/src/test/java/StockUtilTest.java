import com.zj.api.kernel.common.util.quote.QuoteUtil;
import com.zj.api.kernel.common.util.quote.impl.QuoteUtilImpl;


/**
 * Created by js on 2017/1/16.
 */
public class StockUtilTest {

    public static void main(String agrs[]) {
        QuoteUtil stockUtil = new QuoteUtilImpl();
        stockUtil.getStockQuote("sz002594");
    }
}