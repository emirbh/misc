package drr.regulation.common.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.qualification.product.functions.IsCommoditySwapFloatFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CommodityLeg1.CommodityLeg1Default.class)
public abstract class CommodityLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityCommodityLeg1 commodityCommodityLeg1;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;

	/**
	* @param product 
	* @return commodityLeg1 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg1Builder = doEvaluate(product);
		
		final CommodityPayout commodityLeg1;
		if (commodityLeg1Builder == null) {
			commodityLeg1 = null;
		} else {
			commodityLeg1 = commodityLeg1Builder.build();
			objectValidator.validate(CommodityPayout.class, commodityLeg1);
		}
		
		return commodityLeg1;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product);

	public static class CommodityLeg1Default extends CommodityLeg1 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder commodityLeg1 = CommodityPayout.builder();
			return assignOutput(commodityLeg1, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityLeg1, NonTransferableProduct product) {
			final Boolean boolean0 = isCommoditySwapFloatFloat.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				commodityLeg1 = toBuilder(commodityCommodityLeg1.evaluate(commodityPayouts(product).getMulti()));
			} else {
				final Boolean boolean1 = isCommodityFloatingPriceForward.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					commodityLeg1 = toBuilder(commodityPayouts(product).get());
				} else {
					commodityLeg1 = null;
				}
			}
			
			return Optional.ofNullable(commodityLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
	}
}
