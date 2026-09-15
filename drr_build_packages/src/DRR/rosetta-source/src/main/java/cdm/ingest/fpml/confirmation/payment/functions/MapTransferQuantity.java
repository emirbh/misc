package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransferQuantity.MapTransferQuantityDefault.class)
public abstract class MapTransferQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlPaymentAmount 
	* @return quantity 
	*/
	public NonNegativeQuantity evaluate(NonNegativeMoney fpmlPaymentAmount) {
		NonNegativeQuantity.NonNegativeQuantityBuilder quantityBuilder = doEvaluate(fpmlPaymentAmount);
		
		final NonNegativeQuantity quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantity.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(NonNegativeMoney fpmlPaymentAmount);

	public static class MapTransferQuantityDefault extends MapTransferQuantity {
		@Override
		protected NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(NonNegativeMoney fpmlPaymentAmount) {
			NonNegativeQuantity.NonNegativeQuantityBuilder quantity = NonNegativeQuantity.builder();
			return assignOutput(quantity, fpmlPaymentAmount);
		}
		
		protected NonNegativeQuantity.NonNegativeQuantityBuilder assignOutput(NonNegativeQuantity.NonNegativeQuantityBuilder quantity, NonNegativeMoney fpmlPaymentAmount) {
			quantity = toBuilder(NonNegativeQuantity.builder()
				.setValue(MapperS.of(fpmlPaymentAmount).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrency(mapStringWithScheme.evaluate(MapperS.of(fpmlPaymentAmount).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), MapperS.of(fpmlPaymentAmount).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getCurrencyScheme", currency -> currency.getCurrencyScheme()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
