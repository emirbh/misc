package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxCoreDetailsModelPriceWithAddress.MapFxCoreDetailsModelPriceWithAddressDefault.class)
public abstract class MapFxCoreDetailsModelPriceWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlLeg 
	* @return price 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceBuilder = doEvaluate(fpmlExchangeRate, fpmlLeg);
		
		final ReferenceWithMetaPriceSchedule price;
		if (priceBuilder == null) {
			price = null;
		} else {
			price = priceBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, price);
		}
		
		return price;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg);

	public static class MapFxCoreDetailsModelPriceWithAddressDefault extends MapFxCoreDetailsModelPriceWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder price = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(price, fpmlExchangeRate, fpmlLeg);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder price, ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlExchangeRate)).getOrDefault(false)) {
				price = toBuilder(createPriceWithAddress.evaluate(createPriceKey.evaluate("exchangeRate", fpmlLeg)));
			} else {
				price = toBuilder(ReferenceWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(price)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
