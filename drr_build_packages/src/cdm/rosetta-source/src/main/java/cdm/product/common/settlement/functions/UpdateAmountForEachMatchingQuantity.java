package cdm.product.common.settlement.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(UpdateAmountForEachMatchingQuantity.UpdateAmountForEachMatchingQuantityDefault.class)
public abstract class UpdateAmountForEachMatchingQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected UpdatePriceAmountForEachMatchingQuantity updatePriceAmountForEachMatchingQuantity;
	@Inject protected UpdateQuantityAmountForEachMatchingQuantity updateQuantityAmountForEachMatchingQuantity;

	/**
	* @param priceQuantityList List of PriceQuantity to update.
	* @param change List of new PriceQuantity to use where the units match.
	* @param direction Enum specifying how the updated amounts should be applied, e.g., add, subtract or replace.
	* @return updatedPriceQuantity List of PriceQuantity with the price and quantity amounts updated.
	*/
	public List<? extends PriceQuantity> evaluate(List<? extends PriceQuantity> priceQuantityList, List<? extends PriceQuantity> change, QuantityChangeDirectionEnum direction) {
		List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantityBuilder = doEvaluate(priceQuantityList, change, direction);
		
		final List<? extends PriceQuantity> updatedPriceQuantity;
		if (updatedPriceQuantityBuilder == null) {
			updatedPriceQuantity = null;
		} else {
			updatedPriceQuantity = updatedPriceQuantityBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, updatedPriceQuantity);
		}
		
		return updatedPriceQuantity;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantityList, List<? extends PriceQuantity> change, QuantityChangeDirectionEnum direction);

	public static class UpdateAmountForEachMatchingQuantityDefault extends UpdateAmountForEachMatchingQuantity {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantityList, List<? extends PriceQuantity> change, QuantityChangeDirectionEnum direction) {
			if (priceQuantityList == null) {
				priceQuantityList = Collections.emptyList();
			}
			if (change == null) {
				change = Collections.emptyList();
			}
			List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity = new ArrayList<>();
			return assignOutput(updatedPriceQuantity, priceQuantityList, change, direction);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity, List<? extends PriceQuantity> priceQuantityList, List<? extends PriceQuantity> change, QuantityChangeDirectionEnum direction) {
			updatedPriceQuantity.addAll(toBuilder(MapperC.<PriceQuantity>of(priceQuantityList)
				.mapItem(priceQuantity -> MapperS.of(PriceQuantity.builder()
					.setPrice(priceQuantity.<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice())
						.mapItem(item -> MapperS.of(updatePriceAmountForEachMatchingQuantity.evaluate(item.get(), MapperC.<PriceQuantity>of(change).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti(), direction))).getMulti())
					.setQuantity(priceQuantity.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity())
						.mapItem(item -> MapperS.of(updateQuantityAmountForEachMatchingQuantity.evaluate(item.get(), MapperC.<PriceQuantity>of(change).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), direction))).getMulti())
					.setObservable(priceQuantity.<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).get())
					.setEffectiveDate(priceQuantity.<AdjustableOrRelativeDate>map("getEffectiveDate", _priceQuantity -> _priceQuantity.getEffectiveDate()).get())
					.build())).getMulti()));
			
			return Optional.ofNullable(updatedPriceQuantity)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
