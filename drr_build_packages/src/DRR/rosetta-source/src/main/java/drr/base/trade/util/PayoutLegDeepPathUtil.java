package drr.base.trade.util;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLeg;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class PayoutLegDeepPathUtil {
    public PayerReceiver choosePayerReceiver(PayoutLeg payoutLeg) {
        final MapperS<CreditDefaultPayout> creditDefaultPayout = MapperS.of(payoutLeg).<CreditDefaultPayout>map("getCreditDefaultPayout", _payoutLeg -> _payoutLeg.getCreditDefaultPayout());
        if (exists(creditDefaultPayout).getOrDefault(false)) {
            return creditDefaultPayout.<PayerReceiver>map("getPayerReceiver", _creditDefaultPayout -> _creditDefaultPayout.getPayerReceiver()).get();
        }
        final MapperS<OptionPayout> optionPayout = MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", _payoutLeg -> _payoutLeg.getOptionPayout());
        if (exists(optionPayout).getOrDefault(false)) {
            return optionPayout.<PayerReceiver>map("getPayerReceiver", _optionPayout -> _optionPayout.getPayerReceiver()).get();
        }
        final MapperS<SettlementPayout> settlementPayout = MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", _payoutLeg -> _payoutLeg.getSettlementPayout());
        if (exists(settlementPayout).getOrDefault(false)) {
            return settlementPayout.<PayerReceiver>map("getPayerReceiver", _settlementPayout -> _settlementPayout.getPayerReceiver()).get();
        }
        final MapperS<PerformancePayout> performancePayout = MapperS.of(payoutLeg).<PerformancePayout>map("getPerformancePayout", _payoutLeg -> _payoutLeg.getPerformancePayout());
        if (exists(performancePayout).getOrDefault(false)) {
            return performancePayout.<PayerReceiver>map("getPayerReceiver", _performancePayout -> _performancePayout.getPayerReceiver()).get();
        }
        final MapperS<InterestRatePayout> interestRatePayout = MapperS.of(payoutLeg).<InterestRatePayout>map("getInterestRatePayout", _payoutLeg -> _payoutLeg.getInterestRatePayout());
        if (exists(interestRatePayout).getOrDefault(false)) {
            return interestRatePayout.<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).get();
        }
        final MapperS<Cashflow> cashflow = MapperS.of(payoutLeg).<Cashflow>map("getCashflow", _payoutLeg -> _payoutLeg.getCashflow());
        if (exists(cashflow).getOrDefault(false)) {
            return cashflow.<PayerReceiver>map("getPayerReceiver", _cashflow -> _cashflow.getPayerReceiver()).get();
        }
        final MapperS<FixedPricePayout> fixedPricePayout = MapperS.of(payoutLeg).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout());
        if (exists(fixedPricePayout).getOrDefault(false)) {
            return fixedPricePayout.<PayerReceiver>map("getPayerReceiver", _fixedPricePayout -> _fixedPricePayout.getPayerReceiver()).get();
        }
        final MapperS<CommodityPayout> commodityPayout = MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", _payoutLeg -> _payoutLeg.getCommodityPayout());
        if (exists(commodityPayout).getOrDefault(false)) {
            return commodityPayout.<PayerReceiver>map("getPayerReceiver", _commodityPayout -> _commodityPayout.getPayerReceiver()).get();
        }
        return null;
    }

}
