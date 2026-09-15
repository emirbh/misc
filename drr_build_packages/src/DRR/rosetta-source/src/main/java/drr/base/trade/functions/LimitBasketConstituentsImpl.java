package drr.base.trade.functions;

import drr.base.trade.basket.BasketConstituentsReport;

import java.util.List;
import java.util.stream.Collectors;

public class LimitBasketConstituentsImpl extends LimitBasketConstituents {
    @Override
    protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(List<? extends BasketConstituentsReport> basketConstituents, Integer maxNumber) {
        return basketConstituents.stream()
                .limit(maxNumber != null ? maxNumber : Long.MAX_VALUE)
                .map(BasketConstituentsReport::toBuilder)
                .collect(Collectors.toList());
    }
}

 