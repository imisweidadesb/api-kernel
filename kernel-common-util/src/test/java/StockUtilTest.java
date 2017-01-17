import com.zj.api.kernel.common.util.pattern.PatternUtil;
import com.zj.api.kernel.common.util.quote.QuoteUtil;
import com.zj.api.kernel.common.util.quote.impl.SinaQuoteUtilImpl;
import com.zj.api.model.stock.QuoteInfo;

import java.util.Date;
import java.util.Map;


/**
 * Created by js on 2017/1/16.
 */
public class StockUtilTest {

    public static void main(String agrs[]) {
//        QuoteUtil stockUtil = new SinaQuoteUtilImpl();
//        Date date = new Date();
//        QuoteInfo quoteInfo = stockUtil.getStockQuote("sh601006");
//        System.out.println(quoteInfo);
//        System.out.println(System.currentTimeMillis() - date.getTime());
        System.out.println(PatternUtil.checkStr("sh601007,sh601007"));

    }
}