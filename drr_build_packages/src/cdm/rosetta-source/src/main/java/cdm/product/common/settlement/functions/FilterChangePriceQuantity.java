package cdm.product.common.settlement.functions;

import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterChangePriceQuantity.FilterChangePriceQuantityDefault.class)
public abstract class FilterChangePriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity List of PriceQuantity to update.
	* @param change List of new PriceQuantity to use where the units match.
	* @return filteredChange 
	*/
	public List<? extends PriceQuantity> evaluate(PriceQuantity priceQuantity, List<? extends PriceQuantity> change) {
		List<PriceQuantity.PriceQuantityBuilder> filteredChangeBuilder = doEvaluate(priceQuantity, change);
		
		final List<? extends PriceQuantity> filteredChange;
		if (filteredChangeBuilder == null) {
			filteredChange = null;
		} else {
			filteredChange = filteredChangeBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, filteredChange);
		}
		
		return filteredChange;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(PriceQuantity priceQuantity, List<? extends PriceQuantity> change);

	protected abstract MapperC<? extends PriceQuantity> changeWithMatchingObservable(PriceQuantity priceQuantity, List<? extends PriceQuantity> change);

	public static class FilterChangePriceQuantityDefault extends FilterChangePriceQuantity {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(PriceQuantity priceQuantity, List<? extends PriceQuantity> change) {
			if (change == null) {
				change = Collections.emptyList();
			}
			List<PriceQuantity.PriceQuantityBuilder> filteredChange = new ArrayList<>();
			return assignOutput(filteredChange, priceQuantity, change);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> filteredChange, PriceQuantity priceQuantity, List<? extends PriceQuantity> change) {
			if (changeWithMatchingObservable(priceQuantity, change).getMulti().isEmpty()) {
				filteredChange.addAll(toBuilder(MapperC.<PriceQuantity>of(change).getMulti()));
			} else {
				filteredChange.addAll(toBuilder(changeWithMatchingObservable(priceQuantity, change).getMulti()));
			}
			
			return Optional.ofNullable(filteredChange)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PriceQuantity> changeWithMatchingObservable(PriceQuantity priceQuantity, List<? extends PriceQuantity> change) {
			return MapperC.<PriceQuantity>of(change)
				.filterItemNullSafe(item -> notExists(item.<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable())).andNullSafe(notExists(MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()))).orNullSafe(areEqual(item.<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable0 -> fieldWithMetaObservable0 == null ? null : fieldWithMetaObservable0.getValue()), MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable1 -> fieldWithMetaObservable1 == null ? null : fieldWithMetaObservable1.getValue()), CardinalityOperator.All)).get());
		}
	}
}
