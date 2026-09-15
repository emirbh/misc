package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommoditySwapFloatFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CommodityLeg1.CommodityLeg1Default.class)
public abstract class CommodityLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityBasisLeg1 commodityBasisLeg1;
	@Inject protected drr.regulation.common.functions.CommodityLeg1 commodityLeg1;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;

	/**
	* @param product 
	* @return _commodityLeg1 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg1Builder = doEvaluate(product);
		
		final CommodityPayout _commodityLeg1;
		if (commodityLeg1Builder == null) {
			_commodityLeg1 = null;
		} else {
			_commodityLeg1 = commodityLeg1Builder.build();
			objectValidator.validate(CommodityPayout.class, _commodityLeg1);
		}
		
		return _commodityLeg1;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product);

	public static class CommodityLeg1Default extends CommodityLeg1 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder _commodityLeg1 = CommodityPayout.builder();
			return assignOutput(_commodityLeg1, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder _commodityLeg1, NonTransferableProduct product) {
			final Boolean _boolean = isCommoditySwapFloatFloat.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				_commodityLeg1 = toBuilder(commodityBasisLeg1.evaluate(product));
			} else {
				_commodityLeg1 = toBuilder(commodityLeg1.evaluate(product));
			}
			
			return Optional.ofNullable(_commodityLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
	}
}
