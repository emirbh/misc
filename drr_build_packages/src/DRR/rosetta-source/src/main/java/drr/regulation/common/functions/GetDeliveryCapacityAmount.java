package drr.regulation.common.functions;

import cdm.base.math.Quantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(GetDeliveryCapacityAmount.GetDeliveryCapacityAmountDefault.class)
public abstract class GetDeliveryCapacityAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityToDeliveryCapacity quantityToDeliveryCapacity;

	/**
	* @param deliveryCapacity 
	* @return amount 
	*/
	public BigDecimal evaluate(Quantity deliveryCapacity) {
		BigDecimal amount = doEvaluate(deliveryCapacity);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(Quantity deliveryCapacity);

	public static class GetDeliveryCapacityAmountDefault extends GetDeliveryCapacityAmount {
		@Override
		protected BigDecimal doEvaluate(Quantity deliveryCapacity) {
			BigDecimal amount = null;
			return assignOutput(amount, deliveryCapacity);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, Quantity deliveryCapacity) {
			amount = MapperS.of(quantityToDeliveryCapacity.evaluate(deliveryCapacity)).<BigDecimal>map("getAmount", _deliveryCapacity -> _deliveryCapacity.getAmount()).get();
			
			return amount;
		}
	}
}
