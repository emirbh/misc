package drr.base.trade.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsProductETD;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(EconomicTermsForProduct.EconomicTermsForProductDefault.class)
public abstract class EconomicTermsForProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;

	/**
	* @param product 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(NonTransferableProduct product) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(product);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(NonTransferableProduct product);

	public static class EconomicTermsForProductDefault extends EconomicTermsForProduct {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(NonTransferableProduct product) {
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, product);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, NonTransferableProduct product) {
			final Boolean _boolean = isProductETD.evaluate(product);
			EconomicTerms ifThenElseResult = null;
			if ((_boolean == null ? false : _boolean)) {
				ifThenElseResult = MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).get();
			}
			economicTerms = toBuilder(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).getOrDefault(ifThenElseResult));
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
