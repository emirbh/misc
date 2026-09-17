package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.product.template.StrikeSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import fpml.consolidated.shared.Leg;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFloorRateScheduleWithAddress.MapFloorRateScheduleWithAddressDefault.class)
public abstract class MapFloorRateScheduleWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;

	/**
	* @param fpmlFloorRateScheduleList 
	* @param fpmlLeg 
	* @return strikeSchedule 
	*/
	public StrikeSchedule evaluate(List<? extends fpml.consolidated.shared.StrikeSchedule> fpmlFloorRateScheduleList, Leg fpmlLeg) {
		StrikeSchedule.StrikeScheduleBuilder strikeScheduleBuilder = doEvaluate(fpmlFloorRateScheduleList, fpmlLeg);
		
		final StrikeSchedule strikeSchedule;
		if (strikeScheduleBuilder == null) {
			strikeSchedule = null;
		} else {
			strikeSchedule = strikeScheduleBuilder.build();
			objectValidator.validate(StrikeSchedule.class, strikeSchedule);
		}
		
		return strikeSchedule;
	}

	protected abstract StrikeSchedule.StrikeScheduleBuilder doEvaluate(List<? extends fpml.consolidated.shared.StrikeSchedule> fpmlFloorRateScheduleList, Leg fpmlLeg);

	public static class MapFloorRateScheduleWithAddressDefault extends MapFloorRateScheduleWithAddress {
		@Override
		protected StrikeSchedule.StrikeScheduleBuilder doEvaluate(List<? extends fpml.consolidated.shared.StrikeSchedule> fpmlFloorRateScheduleList, Leg fpmlLeg) {
			if (fpmlFloorRateScheduleList == null) {
				fpmlFloorRateScheduleList = Collections.emptyList();
			}
			StrikeSchedule.StrikeScheduleBuilder strikeSchedule = StrikeSchedule.builder();
			return assignOutput(strikeSchedule, fpmlFloorRateScheduleList, fpmlLeg);
		}
		
		protected StrikeSchedule.StrikeScheduleBuilder assignOutput(StrikeSchedule.StrikeScheduleBuilder strikeSchedule, List<? extends fpml.consolidated.shared.StrikeSchedule> fpmlFloorRateScheduleList, Leg fpmlLeg) {
			if (exists(MapperC.<fpml.consolidated.shared.StrikeSchedule>of(fpmlFloorRateScheduleList)).getOrDefault(false)) {
				strikeSchedule = toBuilder(StrikeSchedule.builder()
					.setPrice(createPriceWithAddress.evaluate(createPriceKey.evaluate("floorRateSchedule", fpmlLeg)))
					.build());
			} else {
				strikeSchedule = null;
			}
			
			return Optional.ofNullable(strikeSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
