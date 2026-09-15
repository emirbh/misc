package drr.regulation.common.functions;

import cdm.base.math.Quantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.EnergyQuantityUnit2Code;
import javax.inject.Inject;


@ImplementedBy(GetDeliveryCapacityUnit.GetDeliveryCapacityUnitDefault.class)
public abstract class GetDeliveryCapacityUnit implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityToDeliveryCapacity quantityToDeliveryCapacity;

	/**
	* @param deliveryCapacity 
	* @return unit 
	*/
	public EnergyQuantityUnit2Code evaluate(Quantity deliveryCapacity) {
		EnergyQuantityUnit2Code unit = doEvaluate(deliveryCapacity);
		
		return unit;
	}

	protected abstract EnergyQuantityUnit2Code doEvaluate(Quantity deliveryCapacity);

	public static class GetDeliveryCapacityUnitDefault extends GetDeliveryCapacityUnit {
		@Override
		protected EnergyQuantityUnit2Code doEvaluate(Quantity deliveryCapacity) {
			EnergyQuantityUnit2Code unit = null;
			return assignOutput(unit, deliveryCapacity);
		}
		
		protected EnergyQuantityUnit2Code assignOutput(EnergyQuantityUnit2Code unit, Quantity deliveryCapacity) {
			unit = MapperS.of(quantityToDeliveryCapacity.evaluate(deliveryCapacity)).<EnergyQuantityUnit2Code>map("getUnit", _deliveryCapacity -> _deliveryCapacity.getUnit()).get();
			
			return unit;
		}
	}
}
