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
import drr.regulation.common.functions.CommodityLeg2;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutLeg2.PayoutLeg2Default.class)
public abstract class PayoutLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg2 commodityLeg20;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.CommodityLeg2 commodityLeg21;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg2 interestRateLeg20;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.InterestRateLeg2 interestRateLeg21;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected PayoutMatches payoutMatches;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return payoutLeg2 
	*/
	public PayoutLegWithAuxiliary evaluate(ReportableEventBase reportableEvent) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg2Builder = doEvaluate(reportableEvent);
		
		final PayoutLegWithAuxiliary payoutLeg2;
		if (payoutLeg2Builder == null) {
			payoutLeg2 = null;
		} else {
			payoutLeg2 = payoutLeg2Builder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, payoutLeg2);
		}
		
		return payoutLeg2;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> csaInterestRateLeg2(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> drrInterestRateLeg2(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> csaCommodityLeg2(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> drrCommodityLeg2(ReportableEventBase reportableEvent);

	public static class PayoutLeg2Default extends PayoutLeg2 {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg2 = PayoutLegWithAuxiliary.builder();
			return assignOutput(payoutLeg2, reportableEvent);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg2, ReportableEventBase reportableEvent) {
			final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTerms(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				if (areEqual(MapperS.of(payoutMatches.evaluate(csaInterestRateLeg2(reportableEvent).get(), drrInterestRateLeg2(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					payoutLeg2 = toBuilder(payoutLeg1Rule.evaluate(reportableEvent));
				} else {
					payoutLeg2 = toBuilder(payoutLeg2Rule.evaluate(reportableEvent));
				}
			} else {
				final Boolean boolean1 = qualify_AssetClass_Commodity.evaluate(economicTerms(reportableEvent).get());
				if ((boolean1 == null ? false : boolean1)) {
					if (areEqual(MapperS.of(payoutMatches.evaluate(csaCommodityLeg2(reportableEvent).get(), drrCommodityLeg2(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						payoutLeg2 = toBuilder(payoutLeg1Rule.evaluate(reportableEvent));
					} else {
						payoutLeg2 = toBuilder(payoutLeg2Rule.evaluate(reportableEvent));
					}
				} else {
					payoutLeg2 = toBuilder(payoutLeg2Rule.evaluate(reportableEvent));
				}
			}
			
			return Optional.ofNullable(payoutLeg2)
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
		protected MapperS<? extends InterestRatePayout> csaInterestRateLeg2(ReportableEventBase reportableEvent) {
			return MapperS.of(interestRateLeg21.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> drrInterestRateLeg2(ReportableEventBase reportableEvent) {
			return MapperS.of(interestRateLeg20.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends CommodityPayout> csaCommodityLeg2(ReportableEventBase reportableEvent) {
			return MapperS.of(commodityLeg21.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<? extends CommodityPayout> drrCommodityLeg2(ReportableEventBase reportableEvent) {
			return MapperS.of(commodityLeg20.evaluate(product(reportableEvent).get()));
		}
	}
}
