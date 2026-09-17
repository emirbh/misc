package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapNotionalAmountToQuantityList.MapNotionalAmountToQuantityListDefault.class)
public abstract class MapNotionalAmountToQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedules 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(NotionalAmount fpmlNotionalAmount, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedulesBuilder = doEvaluate(fpmlNotionalAmount, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> nonNegativeQuantitySchedules;
		if (nonNegativeQuantitySchedulesBuilder == null) {
			nonNegativeQuantitySchedules = null;
		} else {
			nonNegativeQuantitySchedules = nonNegativeQuantitySchedulesBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedules);
		}
		
		return nonNegativeQuantitySchedules;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(NotionalAmount fpmlNotionalAmount, Leg fpmlLeg);

	public static class MapNotionalAmountToQuantityListDefault extends MapNotionalAmountToQuantityList {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(NotionalAmount fpmlNotionalAmount, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedules = new ArrayList<>();
			return assignOutput(nonNegativeQuantitySchedules, fpmlNotionalAmount, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedules, NotionalAmount fpmlNotionalAmount, Leg fpmlLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlNotionalAmount).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlNotionalAmount).<Currency>map("getCurrency", notionalAmount -> notionalAmount.getCurrency()).get(), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule == null) {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)));
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedules)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
