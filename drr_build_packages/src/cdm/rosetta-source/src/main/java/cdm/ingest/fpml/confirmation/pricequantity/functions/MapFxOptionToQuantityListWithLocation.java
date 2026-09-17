package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionToQuantityListWithLocation.MapFxOptionToQuantityListWithLocationDefault.class)
public abstract class MapFxOptionToQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapCurrencyAmountToQuantity mapCurrencyAmountToQuantity;

	/**
	* @param fpmlFxOption 
	* @return quantityList 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(FxOption fpmlFxOption) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityListBuilder = doEvaluate(fpmlFxOption);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(FxOption fpmlFxOption);

	public static class MapFxOptionToQuantityListWithLocationDefault extends MapFxOptionToQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(FxOption fpmlFxOption) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList = new ArrayList<>();
			return assignOutput(quantityList, fpmlFxOption);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList, FxOption fpmlFxOption) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getPutCurrencyAmount", fxOption -> fxOption.getPutCurrencyAmount()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getPutCurrencyAmount", fxOption -> fxOption.getPutCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), null), createQuantityKey.evaluate("putCurrencyAmount", null));
			if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
			}
			
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getCallCurrencyAmount", fxOption -> fxOption.getCallCurrencyAmount()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getCallCurrencyAmount", fxOption -> fxOption.getCallCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), null), createQuantityKey.evaluate("callCurrencyAmount", null));
			if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
