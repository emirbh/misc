package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.functions.CommodityLeg1;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutLeg1.PayoutLeg1Default.class)
public abstract class PayoutLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg1 commodityLeg10;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.CommodityLeg1 commodityLeg11;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg1 interestRateLeg10;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.InterestRateLeg1 interestRateLeg11;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected PayoutMatches payoutMatches;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return payoutLeg1 
	*/
	public PayoutLegWithAuxiliary evaluate(ReportableEventBase reportableEvent) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg1Builder = doEvaluate(reportableEvent);
		
		final PayoutLegWithAuxiliary payoutLeg1;
		if (payoutLeg1Builder == null) {
			payoutLeg1 = null;
		} else {
			payoutLeg1 = payoutLeg1Builder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, payoutLeg1);
		}
		
		return payoutLeg1;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> csaInterestRateLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> drrInterestRateLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> csaCommodityLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> drrCommodityLeg1(ReportableEventBase reportableEvent);

	public static class PayoutLeg1Default extends PayoutLeg1 {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg1 = PayoutLegWithAuxiliary.builder();
			return assignOutput(payoutLeg1, reportableEvent);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg1, ReportableEventBase reportableEvent) {
			final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTerms(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				if (areEqual(MapperS.of(payoutMatches.evaluate(csaInterestRateLeg1(reportableEvent).get(), drrInterestRateLeg1(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					payoutLeg1 = toBuilder(payoutLeg2Rule.evaluate(reportableEvent));
				} else {
					payoutLeg1 = toBuilder(payoutLeg1Rule.evaluate(reportableEvent));
				}
			} else {
				final Boolean boolean1 = qualify_AssetClass_Commodity.evaluate(economicTerms(reportableEvent).get());
				if ((boolean1 == null ? false : boolean1)) {
					if (areEqual(MapperS.of(payoutMatches.evaluate(csaCommodityLeg1(reportableEvent).get(), drrCommodityLeg1(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						payoutLeg1 = toBuilder(payoutLeg2Rule.evaluate(reportableEvent));
					} else {
						payoutLeg1 = toBuilder(payoutLeg1Rule.evaluate(reportableEvent));
					}
				} else {
					payoutLeg1 = toBuilder(payoutLeg1Rule.evaluate(reportableEvent));
				}
			}
			
			return Optional.ofNullable(payoutLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> csaInterestRateLeg1(ReportableEventBase reportableEvent) {
			return MapperS.of(interestRateLeg11.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> drrInterestRateLeg1(ReportableEventBase reportableEvent) {
			return MapperS.of(interestRateLeg10.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends CommodityPayout> csaCommodityLeg1(ReportableEventBase reportableEvent) {
			return MapperS.of(commodityLeg11.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends CommodityPayout> drrCommodityLeg1(ReportableEventBase reportableEvent) {
			return MapperS.of(commodityLeg10.evaluate(product(reportableEvent).get()));
		}
	}
}
