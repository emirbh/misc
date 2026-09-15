package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.functions.CommodityLeg1;
import drr.regulation.common.functions.InterestRateLeg1;
import javax.inject.Inject;


@ImplementedBy(IsCSALeg1Aligned.IsCSALeg1AlignedDefault.class)
public abstract class IsCSALeg1Aligned implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg1 commodityLeg10;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.CommodityLeg1 commodityLeg11;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg1 interestRateLeg10;
	@Inject protected drr.regulation.csa.rewrite.trade.functions.InterestRateLeg1 interestRateLeg11;
	@Inject protected PayoutMatches payoutMatches;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> csaInterestRateLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> drrInterestRateLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> csaCommodityLeg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CommodityPayout> drrCommodityLeg1(ReportableEventBase reportableEvent);

	public static class IsCSALeg1AlignedDefault extends IsCSALeg1Aligned {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableEventBase reportableEvent) {
			final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTerms(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				result = payoutMatches.evaluate(csaInterestRateLeg1(reportableEvent).get(), drrInterestRateLeg1(reportableEvent).get());
			} else {
				final Boolean boolean1 = qualify_AssetClass_Commodity.evaluate(economicTerms(reportableEvent).get());
				if ((boolean1 == null ? false : boolean1)) {
					result = payoutMatches.evaluate(csaCommodityLeg1(reportableEvent).get(), drrCommodityLeg1(reportableEvent).get());
				} else {
					result = true;
				}
			}
			
			return result;
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
