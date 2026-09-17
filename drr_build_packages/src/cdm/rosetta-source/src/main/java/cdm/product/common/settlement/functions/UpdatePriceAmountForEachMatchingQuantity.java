package cdm.product.common.settlement.functions;

import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.functions.UpdateAmount;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
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


@ImplementedBy(UpdatePriceAmountForEachMatchingQuantity.UpdatePriceAmountForEachMatchingQuantityDefault.class)
public abstract class UpdatePriceAmountForEachMatchingQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PriceUnitEquals priceUnitEquals;
	@Inject protected UpdateAmount updateAmount;

	/**
	* @param price List of PriceSchedule to update.
	* @param change List of new PriceSchedule to use where the units match.
	* @param direction Enum specifying how the updated amounts should be applied, e.g., add, subtract or replace.
	* @return updatedPrice 
	*/
	public FieldWithMetaPriceSchedule evaluate(FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder updatedPriceBuilder = doEvaluate(price, change, direction);
		
		final FieldWithMetaPriceSchedule updatedPrice;
		if (updatedPriceBuilder == null) {
			updatedPrice = null;
		} else {
			updatedPrice = updatedPriceBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, updatedPrice);
		}
		
		return updatedPrice;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction);

	protected abstract MapperS<BigDecimal> changedAmount(FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction);

	public static class UpdatePriceAmountForEachMatchingQuantityDefault extends UpdatePriceAmountForEachMatchingQuantity {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction) {
			if (change == null) {
				change = Collections.emptyList();
			}
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder updatedPrice = FieldWithMetaPriceSchedule.builder();
			return assignOutput(updatedPrice, price, change, direction);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder updatedPrice, FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction) {
			updatedPrice = toBuilder(price, () -> FieldWithMetaPriceSchedule.builder());
			
			updatedPrice
				.getOrCreateValue().setValue(changedAmount(price, change, direction).getOrDefault((price == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(price.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get()));
			
			return Optional.ofNullable(updatedPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> changedAmount(FieldWithMetaPriceSchedule price, List<? extends PriceSchedule> change, QuantityChangeDirectionEnum direction) {
			final MapperC<PriceSchedule> thenArg0 = MapperC.<PriceSchedule>of(change)
				.filterItemNullSafe(item -> priceUnitEquals.evaluate(item.get(), (price == null ? null : price.getValue())));
			final MapperS<PriceSchedule> thenArg1 = thenArg0
				.first();
			return thenArg1
				.mapSingleToItem(item -> MapperS.of(updateAmount.evaluate((price == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(price.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get(), item.<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get(), direction)));
		}
	}
}
