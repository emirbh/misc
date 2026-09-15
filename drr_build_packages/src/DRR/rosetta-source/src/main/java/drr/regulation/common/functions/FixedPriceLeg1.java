package drr.regulation.common.functions;

import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityFixedPriceForward;
import drr.base.qualification.product.functions.IsCommoditySwapFixedFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(FixedPriceLeg1.FixedPriceLeg1Default.class)
public abstract class FixedPriceLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityFixedPriceForward isCommodityFixedPriceForward;
	@Inject protected IsCommoditySwapFixedFloat isCommoditySwapFixedFloat;

	/**
	* @param product 
	* @return fixedPrice 
	*/
	public FixedPricePayout evaluate(NonTransferableProduct product) {
		FixedPricePayout.FixedPricePayoutBuilder fixedPriceBuilder = doEvaluate(product);
		
		final FixedPricePayout fixedPrice;
		if (fixedPriceBuilder == null) {
			fixedPrice = null;
		} else {
			fixedPrice = fixedPriceBuilder.build();
			objectValidator.validate(FixedPricePayout.class, fixedPrice);
		}
		
		return fixedPrice;
	}

	protected abstract FixedPricePayout.FixedPricePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class FixedPriceLeg1Default extends FixedPriceLeg1 {
		@Override
		protected FixedPricePayout.FixedPricePayoutBuilder doEvaluate(NonTransferableProduct product) {
			FixedPricePayout.FixedPricePayoutBuilder fixedPrice = FixedPricePayout.builder();
			return assignOutput(fixedPrice, product);
		}
		
		protected FixedPricePayout.FixedPricePayoutBuilder assignOutput(FixedPricePayout.FixedPricePayoutBuilder fixedPrice, NonTransferableProduct product) {
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwapFixedFloat.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodityFixedPriceForward.evaluate(product)))).getOrDefault(false)) {
				fixedPrice = toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get());
			} else {
				fixedPrice = null;
			}
			
			return Optional.ofNullable(fixedPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
