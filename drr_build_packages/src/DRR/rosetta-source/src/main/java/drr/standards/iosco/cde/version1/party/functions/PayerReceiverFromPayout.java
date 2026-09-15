package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PayerReceiverFromPayout.PayerReceiverFromPayoutDefault.class)
public abstract class PayerReceiverFromPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payout 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(PayoutLegWithAuxiliary payout) {
		PayerReceiver.PayerReceiverBuilder payerReceiverBuilder = doEvaluate(payout);
		
		final PayerReceiver payerReceiver;
		if (payerReceiverBuilder == null) {
			payerReceiver = null;
		} else {
			payerReceiver = payerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, payerReceiver);
		}
		
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(PayoutLegWithAuxiliary payout);

	public static class PayerReceiverFromPayoutDefault extends PayerReceiverFromPayout {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(PayoutLegWithAuxiliary payout) {
			PayerReceiver.PayerReceiverBuilder payerReceiver = PayerReceiver.builder();
			return assignOutput(payerReceiver, payout);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, PayoutLegWithAuxiliary payout) {
			final MapperS<PayerReceiver> thenArg0 = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<PayerReceiver>map("getPayerReceiver", commodityPayout -> commodityPayout.getPayerReceiver());
			final MapperS<PayerReceiver> thenArg1 = MapperS.of(thenArg0.getOrDefault(MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<PayerReceiver>map("getPayerReceiver", fixedPricePayout -> fixedPricePayout.getPayerReceiver()).get()));
			final MapperS<PayerReceiver> thenArg2 = MapperS.of(thenArg1.getOrDefault(MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<PayerReceiver>map("getPayerReceiver", performancePayout -> performancePayout.getPayerReceiver()).get()));
			final MapperS<PayerReceiver> thenArg3 = MapperS.of(thenArg2.getOrDefault(MapperS.of(payout).<Cashflow>map("getCashflow", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCashflow()).<PayerReceiver>map("getPayerReceiver", cashflow -> cashflow.getPayerReceiver()).get()));
			final MapperS<PayerReceiver> thenArg4 = MapperS.of(thenArg3.getOrDefault(MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<PayerReceiver>map("getPayerReceiver", interestRatePayout -> interestRatePayout.getPayerReceiver()).get()));
			final MapperS<PayerReceiver> thenArg5 = MapperS.of(thenArg4.getOrDefault(MapperS.of(payout).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<CommodityPayout>map("getCommodityPayout", payoutLeg -> payoutLeg.getCommodityPayout()).<PayerReceiver>map("getPayerReceiver", commodityPayout -> commodityPayout.getPayerReceiver()).get()));
			payerReceiver = toBuilder(MapperS.of(thenArg5.getOrDefault(MapperS.of(payout).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<InterestRatePayout>map("getInterestRatePayout", payoutLeg -> payoutLeg.getInterestRatePayout()).<PayerReceiver>map("getPayerReceiver", interestRatePayout -> interestRatePayout.getPayerReceiver()).get())).get());
			
			return Optional.ofNullable(payerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
