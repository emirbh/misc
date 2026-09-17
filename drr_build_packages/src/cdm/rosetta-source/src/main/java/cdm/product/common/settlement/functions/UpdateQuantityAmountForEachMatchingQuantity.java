package cdm.product.common.settlement.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.math.functions.UnitEquals;
import cdm.base.math.functions.UpdateAmount;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(UpdateQuantityAmountForEachMatchingQuantity.UpdateQuantityAmountForEachMatchingQuantityDefault.class)
public abstract class UpdateQuantityAmountForEachMatchingQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected UnitEquals unitEquals;
	@Inject protected UpdateAmount updateAmount;

	/**
	* @param quantity List of NonNegativeQuantitySchedule to update.
	* @param change List of new NonNegativeQuantitySchedule to use where the units match.
	* @param direction Enum specifying how the updated amounts should be applied, e.g., add, subtract or replace.
	* @return updatedQuantity 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder updatedQuantityBuilder = doEvaluate(quantity, change, direction);
		
		final FieldWithMetaNonNegativeQuantitySchedule updatedQuantity;
		if (updatedQuantityBuilder == null) {
			updatedQuantity = null;
		} else {
			updatedQuantity = updatedQuantityBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, updatedQuantity);
		}
		
		return updatedQuantity;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction);

	protected abstract MapperS<BigDecimal> changedAmount(FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction);

	public static class UpdateQuantityAmountForEachMatchingQuantityDefault extends UpdateQuantityAmountForEachMatchingQuantity {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction) {
			if (change == null) {
				change = Collections.emptyList();
			}
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder updatedQuantity = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(updatedQuantity, quantity, change, direction);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder updatedQuantity, FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction) {
			updatedQuantity = toBuilder(quantity, () -> FieldWithMetaNonNegativeQuantitySchedule.builder());
			
			updatedQuantity
				.getOrCreateValue().setValue(changedAmount(quantity, change, direction).getOrDefault((quantity == null ? MapperS.<NonNegativeQuantitySchedule>ofNull() : MapperS.of(quantity.getValue())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get()));
			
			return Optional.ofNullable(updatedQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> changedAmount(FieldWithMetaNonNegativeQuantitySchedule quantity, List<? extends NonNegativeQuantitySchedule> change, QuantityChangeDirectionEnum direction) {
			final MapperC<NonNegativeQuantitySchedule> thenArg0 = MapperC.<NonNegativeQuantitySchedule>of(change)
				.filterItemNullSafe(item -> unitEquals.evaluate(item.<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get(), (quantity == null ? MapperS.<NonNegativeQuantitySchedule>ofNull() : MapperS.of(quantity.getValue())).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get()));
			final MapperS<NonNegativeQuantitySchedule> thenArg1 = thenArg0
				.first();
			return thenArg1
				.mapSingleToItem(item -> MapperS.of(updateAmount.evaluate((quantity == null ? MapperS.<NonNegativeQuantitySchedule>ofNull() : MapperS.of(quantity.getValue())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get(), item.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get(), direction)));
		}
	}
}
