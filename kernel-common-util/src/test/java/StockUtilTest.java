import com.zj.api.kernel.common.util.quote.QuoteUtil;
import com.zj.api.kernel.common.util.quote.impl.QuoteUtilImpl;

import java.util.Date;


/**
 * Created by js on 2017/1/16.
 */
public class StockUtilTest {

    public static void main(String agrs[]) {
        QuoteUtil stockUtil = new QuoteUtilImpl();
        Date date = new Date();
        stockUtil.getStockQuote("sz002594,sh601006");
        System.out.println(System.currentTimeMillis() - date.getTime());

    }
}