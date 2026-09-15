package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxCoreDetailsModelQuantityWithAddress.MapFxCoreDetailsModelQuantityWithAddressDefault.class)
public abstract class MapFxCoreDetailsModelQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlLeg 
	* @return quantity 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(fpmlExchangeRate, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg);

	protected abstract MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate, Leg fpmlLeg);

	public static class MapFxCoreDetailsModelQuantityWithAddressDefault extends MapFxCoreDetailsModelQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantity = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, fpmlExchangeRate, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantity, ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			if (areEqual(quotedCurrencyPair(fpmlExchangeRate, fpmlLeg).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1), CardinalityOperator.All).getOrDefault(false)) {
				quantity = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate(quotedCurrencyPair(fpmlExchangeRate, fpmlLeg).<Currency>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1()).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg)));
			} else {
				quantity = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate(quotedCurrencyPair(fpmlExchangeRate, fpmlLeg).<Currency>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2()).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg)));
			}
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			return MapperS.of(fpmlExchangeRate).<QuotedCurrencyPair>map("getQuotedCurrencyPair", exchangeRate -> exchangeRate.getQuotedCurrencyPair());
		}
	}
}
