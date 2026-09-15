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


@ImplementedBy(CommodityLeg2.CommodityLeg2Default.class)
public abstract class CommodityLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityBasisLeg2 commodityBasisLeg2;
	@Inject protected drr.regulation.common.functions.CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;

	/**
	* @param product 
	* @return _commodityLeg2 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg2Builder = doEvaluate(product);
		
		final CommodityPayout _commodityLeg2;
		if (commodityLeg2Builder == null) {
			_commodityLeg2 = null;
		} else {
			_commodityLeg2 = commodityLeg2Builder.build();
			objectValidator.validate(CommodityPayout.class, _commodityLeg2);
		}
		
		return _commodityLeg2;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product);

	public static class CommodityLeg2Default extends CommodityLeg2 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder _commodityLeg2 = CommodityPayout.builder();
			return assignOutput(_commodityLeg2, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder _commodityLeg2, NonTransferableProduct product) {
			final Boolean _boolean = isCommoditySwapFloatFloat.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				_commodityLeg2 = toBuilder(commodityBasisLeg2.evaluate(product));
			} else {
				_commodityLeg2 = toBuilder(commodityLeg2.evaluate(product));
			}
			
			return Optional.ofNullable(_commodityLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
	}
}
