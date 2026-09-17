package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReferencePrice.MapReferencePriceDefault.class)
public abstract class MapReferencePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlReferencePrice 
	* @param fpmlCurrency 
	* @return price 
	*/
	public Price evaluate(BigDecimal fpmlReferencePrice, Currency fpmlCurrency) {
		Price.PriceBuilder priceBuilder = doEvaluate(fpmlReferencePrice, fpmlCurrency);
		
		final Price price;
		if (priceBuilder == null) {
			price = null;
		} else {
			price = priceBuilder.build();
			objectValidator.validate(Price.class, price);
		}
		
		return price;
	}

	protected abstract Price.PriceBuilder doEvaluate(BigDecimal fpmlReferencePrice, Currency fpmlCurrency);

	protected abstract MapperS<? extends UnitType> priceUnits(BigDecimal fpmlReferencePrice, Currency fpmlCurrency);

	public static class MapReferencePriceDefault extends MapReferencePrice {
		@Override
		protected Price.PriceBuilder doEvaluate(BigDecimal fpmlReferencePrice, Currency fpmlCurrency) {
			Price.PriceBuilder price = Price.builder();
			return assignOutput(price, fpmlReferencePrice, fpmlCurrency);
		}
		
		protected Price.PriceBuilder assignOutput(Price.PriceBuilder price, BigDecimal fpmlReferencePrice, Currency fpmlCurrency) {
			if (exists(MapperS.of(fpmlReferencePrice)).getOrDefault(false)) {
				price = toBuilder(Price.builder()
					.setValue(fpmlReferencePrice)
					.setUnit(priceUnits(fpmlReferencePrice, fpmlCurrency).get())
					.setPerUnitOf(priceUnits(fpmlReferencePrice, fpmlCurrency).get())
					.setPriceType(PriceTypeEnum.ASSET_PRICE)
					.build());
			} else {
				price = null;
			}
			
			return Optional.ofNullable(price)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> priceUnits(BigDecimal fpmlReferencePrice, Currency fpmlCurrency) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(fpmlCurrency))
				.build());
		}
	}
}
