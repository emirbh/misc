package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapProtectionTermsToPriceQuantity.MapProtectionTermsToPriceQuantityDefault.class)
public abstract class MapProtectionTermsToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;

	/**
	* @param fpmlProtectionTerms 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(List<? extends ProtectionTerms> fpmlProtectionTerms) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlProtectionTerms);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends ProtectionTerms> fpmlProtectionTerms);

	public static class MapProtectionTermsToPriceQuantityDefault extends MapProtectionTermsToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends ProtectionTerms> fpmlProtectionTerms) {
			if (fpmlProtectionTerms == null) {
				fpmlProtectionTerms = Collections.emptyList();
			}
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlProtectionTerms);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, List<? extends ProtectionTerms> fpmlProtectionTerms) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity(MapperC.<ProtectionTerms>of(fpmlProtectionTerms)
					.mapItem(item -> MapperS.of(mapNotionalAmountToQuantityWithLocation.evaluate(item.<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<BigDecimal>map("getAmount", money -> money.getAmount()).get(), Collections.<Step>emptyList(), item.<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<Currency>map("getCurrency", money -> money.getCurrency()).get(), null))).getMulti())
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
