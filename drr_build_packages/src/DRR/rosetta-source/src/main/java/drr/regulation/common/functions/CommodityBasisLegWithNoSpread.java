package drr.regulation.common.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.SpreadSchedule;
import cdm.product.common.settlement.CommodityPriceReturnTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityBasisLegWithNoSpread.CommodityBasisLegWithNoSpreadDefault.class)
public abstract class CommodityBasisLegWithNoSpread implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

	/**
	* @param product 
	* @return commodityPayout 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityPayoutBuilder = doEvaluate(product);
		
		final CommodityPayout commodityPayout;
		if (commodityPayoutBuilder == null) {
			commodityPayout = null;
		} else {
			commodityPayout = commodityPayoutBuilder.build();
			objectValidator.validate(CommodityPayout.class, commodityPayout);
		}
		
		return commodityPayout;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class CommodityBasisLegWithNoSpreadDefault extends CommodityBasisLegWithNoSpread {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder commodityPayout = CommodityPayout.builder();
			return assignOutput(commodityPayout, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityPayout, NonTransferableProduct product) {
			final MapperC<CommodityPayout> thenArg = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())
				.filterItemNullSafe(item -> notExists(item.<CommodityPriceReturnTerms>map("getCommodityPriceReturnTerms", _commodityPayout -> _commodityPayout.getCommodityPriceReturnTerms()).<SpreadSchedule>map("getSpread", commodityPriceReturnTerms -> commodityPriceReturnTerms.getSpread())).orNullSafe(areEqual(item.<CommodityPriceReturnTerms>map("getCommodityPriceReturnTerms", _commodityPayout -> _commodityPayout.getCommodityPriceReturnTerms()).<SpreadSchedule>map("getSpread", commodityPriceReturnTerms -> commodityPriceReturnTerms.getSpread()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).get());
			commodityPayout = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(commodityPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
