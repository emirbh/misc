package drr.regulation.common.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommoditySwapFixedFloat;
import drr.base.qualification.product.functions.IsCommoditySwapFloatFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CommodityLeg2.CommodityLeg2Default.class)
public abstract class CommodityLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityCommodityLeg2 commodityCommodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommoditySwapFixedFloat isCommoditySwapFixedFloat;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;

	/**
	* @param product 
	* @return commodityLeg2 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg2Builder = doEvaluate(product);
		
		final CommodityPayout commodityLeg2;
		if (commodityLeg2Builder == null) {
			commodityLeg2 = null;
		} else {
			commodityLeg2 = commodityLeg2Builder.build();
			objectValidator.validate(CommodityPayout.class, commodityLeg2);
		}
		
		return commodityLeg2;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product);

	public static class CommodityLeg2Default extends CommodityLeg2 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder commodityLeg2 = CommodityPayout.builder();
			return assignOutput(commodityLeg2, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityLeg2, NonTransferableProduct product) {
			final Boolean boolean0 = isCommoditySwapFloatFloat.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				commodityLeg2 = toBuilder(commodityCommodityLeg2.evaluate(commodityPayouts(product).getMulti()));
			} else {
				final Boolean boolean1 = isCommoditySwapFixedFloat.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					commodityLeg2 = toBuilder(commodityPayouts(product).get());
				} else {
					commodityLeg2 = null;
				}
			}
			
			return Optional.ofNullable(commodityLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
	}
}
