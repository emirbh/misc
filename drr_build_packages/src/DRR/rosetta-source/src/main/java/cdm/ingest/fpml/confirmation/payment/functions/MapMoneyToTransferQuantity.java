package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMoneyToTransferQuantity.MapMoneyToTransferQuantityDefault.class)
public abstract class MapMoneyToTransferQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlMoney 
	* @return quantity 
	*/
	public NonNegativeQuantity evaluate(Money fpmlMoney) {
		NonNegativeQuantity.NonNegativeQuantityBuilder quantityBuilder = doEvaluate(fpmlMoney);
		
		final NonNegativeQuantity quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantity.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(Money fpmlMoney);

	public static class MapMoneyToTransferQuantityDefault extends MapMoneyToTransferQuantity {
		@Override
		protected NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(Money fpmlMoney) {
			NonNegativeQuantity.NonNegativeQuantityBuilder quantity = NonNegativeQuantity.builder();
			return assignOutput(quantity, fpmlMoney);
		}
		
		protected NonNegativeQuantity.NonNegativeQuantityBuilder assignOutput(NonNegativeQuantity.NonNegativeQuantityBuilder quantity, Money fpmlMoney) {
			quantity = toBuilder(NonNegativeQuantity.builder()
				.setValue(MapperS.of(fpmlMoney).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrency(mapStringWithScheme.evaluate(MapperS.of(fpmlMoney).<Currency>map("getCurrency", money -> money.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), MapperS.of(fpmlMoney).<Currency>map("getCurrency", money -> money.getCurrency()).<String>map("getCurrencyScheme", currency -> currency.getCurrencyScheme()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
