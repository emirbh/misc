package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCapRateScheduleWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFloorRateScheduleWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSpreadScheduleWithAddress;
import cdm.product.asset.FloatingRateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.StrikeSchedule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateSpecification.MapFloatingRateSpecificationDefault.class)
public abstract class MapFloatingRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCapRateScheduleWithAddress mapCapRateScheduleWithAddress;
	@Inject protected MapFinalRateRounding mapFinalRateRounding;
	@Inject protected MapFloorRateScheduleWithAddress mapFloorRateScheduleWithAddress;
	@Inject protected MapInitialRate mapInitialRate;
	@Inject protected MapRateOptionWithAddress mapRateOptionWithAddress;
	@Inject protected MapSpreadScheduleWithAddress mapSpreadScheduleWithAddress;

	/**
	* @param fpmlFloatingRateCalculation 
	* @param fpmlLeg 
	* @return floatingRateSpecification 
	*/
	public FloatingRateSpecification evaluate(FloatingRateCalculation fpmlFloatingRateCalculation, Leg fpmlLeg) {
		FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecificationBuilder = doEvaluate(fpmlFloatingRateCalculation, fpmlLeg);
		
		final FloatingRateSpecification floatingRateSpecification;
		if (floatingRateSpecificationBuilder == null) {
			floatingRateSpecification = null;
		} else {
			floatingRateSpecification = floatingRateSpecificationBuilder.build();
			objectValidator.validate(FloatingRateSpecification.class, floatingRateSpecification);
		}
		
		return floatingRateSpecification;
	}

	protected abstract FloatingRateSpecification.FloatingRateSpecificationBuilder doEvaluate(FloatingRateCalculation fpmlFloatingRateCalculation, Leg fpmlLeg);

	public static class MapFloatingRateSpecificationDefault extends MapFloatingRateSpecification {
		@Override
		protected FloatingRateSpecification.FloatingRateSpecificationBuilder doEvaluate(FloatingRateCalculation fpmlFloatingRateCalculation, Leg fpmlLeg) {
			FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecification = FloatingRateSpecification.builder();
			return assignOutput(floatingRateSpecification, fpmlFloatingRateCalculation, fpmlLeg);
		}
		
		protected FloatingRateSpecification.FloatingRateSpecificationBuilder assignOutput(FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecification, FloatingRateCalculation fpmlFloatingRateCalculation, Leg fpmlLeg) {
			floatingRateSpecification = toBuilder(FloatingRateSpecification.builder()
				.setRateOption(mapRateOptionWithAddress.evaluate(fpmlFloatingRateCalculation, fpmlLeg))
				.setSpreadSchedule(mapSpreadScheduleWithAddress.evaluate(MapperS.of(fpmlFloatingRateCalculation).<SpreadSchedule>mapC("getSpreadSchedule", floatingRateCalculation -> floatingRateCalculation.getSpreadSchedule()).getMulti(), fpmlLeg))
				.setCapRateSchedule(mapCapRateScheduleWithAddress.evaluate(MapperS.of(fpmlFloatingRateCalculation).<StrikeSchedule>mapC("getCapRateSchedule", floatingRateCalculation -> floatingRateCalculation.getCapRateSchedule()).getMulti(), fpmlLeg))
				.setFloorRateSchedule(mapFloorRateScheduleWithAddress.evaluate(MapperS.of(fpmlFloatingRateCalculation).<StrikeSchedule>mapC("getFloorRateSchedule", floatingRateCalculation -> floatingRateCalculation.getFloorRateSchedule()).getMulti(), fpmlLeg))
				.setInitialRate(mapInitialRate.evaluate(MapperS.of(fpmlFloatingRateCalculation).<BigDecimal>map("getInitialRate", floatingRateCalculation -> floatingRateCalculation.getInitialRate()).get(), MapperS.of(fpmlFloatingRateCalculation).<FloatingRateIndex>map("getFloatingRateIndex", floatingRateCalculation -> floatingRateCalculation.getFloatingRateIndex()).get()))
				.setFinalRateRounding(mapFinalRateRounding.evaluate(MapperS.of(fpmlFloatingRateCalculation).<Rounding>map("getFinalRateRounding", floatingRateCalculation -> floatingRateCalculation.getFinalRateRounding()).get()))
				.setRateTreatment(MapperS.of(fpmlFloatingRateCalculation).<RateTreatmentEnum>map("getRateTreatment", floatingRateCalculation -> floatingRateCalculation.getRateTreatment()).checkedMap("to-enum", e -> cdm.product.asset.RateTreatmentEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(floatingRateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
