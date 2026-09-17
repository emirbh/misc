package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.datetime.functions.MapOffset;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCapRateScheduleWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFloorRateScheduleWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSpreadScheduleWithAddress;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.product.asset.InflationRateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RateSourcePage;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.StrikeSchedule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInflationRateSpecification.MapInflationRateSpecificationDefault.class)
public abstract class MapInflationRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCapRateScheduleWithAddress mapCapRateScheduleWithAddress;
	@Inject protected MapFinalRateRounding mapFinalRateRounding;
	@Inject protected MapFloorRateScheduleWithAddress mapFloorRateScheduleWithAddress;
	@Inject protected MapInitialRate mapInitialRate;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapRateOptionWithAddress mapRateOptionWithAddress;
	@Inject protected MapSpreadScheduleWithAddress mapSpreadScheduleWithAddress;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlInflationRateCalculation 
	* @param fpmlLeg 
	* @return inflationRateSpecification 
	*/
	public InflationRateSpecification evaluate(InflationRateCalculation fpmlInflationRateCalculation, Leg fpmlLeg) {
		InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecificationBuilder = doEvaluate(fpmlInflationRateCalculation, fpmlLeg);
		
		final InflationRateSpecification inflationRateSpecification;
		if (inflationRateSpecificationBuilder == null) {
			inflationRateSpecification = null;
		} else {
			inflationRateSpecification = inflationRateSpecificationBuilder.build();
			objectValidator.validate(InflationRateSpecification.class, inflationRateSpecification);
		}
		
		return inflationRateSpecification;
	}

	protected abstract InflationRateSpecification.InflationRateSpecificationBuilder doEvaluate(InflationRateCalculation fpmlInflationRateCalculation, Leg fpmlLeg);

	public static class MapInflationRateSpecificationDefault extends MapInflationRateSpecification {
		@Override
		protected InflationRateSpecification.InflationRateSpecificationBuilder doEvaluate(InflationRateCalculation fpmlInflationRateCalculation, Leg fpmlLeg) {
			InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecification = InflationRateSpecification.builder();
			return assignOutput(inflationRateSpecification, fpmlInflationRateCalculation, fpmlLeg);
		}
		
		protected InflationRateSpecification.InflationRateSpecificationBuilder assignOutput(InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecification, InflationRateCalculation fpmlInflationRateCalculation, Leg fpmlLeg) {
			inflationRateSpecification = toBuilder(MapperS.of(fpmlInflationRateCalculation)
				.mapSingleToItem(item -> MapperS.of(InflationRateSpecification.builder()
					.setRateOption(mapRateOptionWithAddress.evaluate(item.get(), fpmlLeg))
					.setSpreadSchedule(mapSpreadScheduleWithAddress.evaluate(item.<SpreadSchedule>mapC("getSpreadSchedule", inflationRateCalculation -> inflationRateCalculation.getSpreadSchedule()).getMulti(), fpmlLeg))
					.setCapRateSchedule(mapCapRateScheduleWithAddress.evaluate(item.<StrikeSchedule>mapC("getCapRateSchedule", inflationRateCalculation -> inflationRateCalculation.getCapRateSchedule()).getMulti(), fpmlLeg))
					.setFloorRateSchedule(mapFloorRateScheduleWithAddress.evaluate(item.<StrikeSchedule>mapC("getFloorRateSchedule", inflationRateCalculation -> inflationRateCalculation.getFloorRateSchedule()).getMulti(), fpmlLeg))
					.setInitialRate(mapInitialRate.evaluate(item.<BigDecimal>map("getInitialRate", inflationRateCalculation -> inflationRateCalculation.getInitialRate()).get(), item.<FloatingRateIndex>map("getFloatingRateIndex", inflationRateCalculation -> inflationRateCalculation.getFloatingRateIndex()).get()))
					.setFinalRateRounding(mapFinalRateRounding.evaluate(item.<Rounding>map("getFinalRateRounding", inflationRateCalculation -> inflationRateCalculation.getFinalRateRounding()).get()))
					.setRateTreatment(item.<RateTreatmentEnum>map("getRateTreatment", inflationRateCalculation -> inflationRateCalculation.getRateTreatment()).checkedMap("to-enum", e -> cdm.product.asset.RateTreatmentEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setInflationLag(mapOffset.evaluate(item.<Offset>map("getInflationLag", inflationRateCalculation -> inflationRateCalculation.getInflationLag()).get()))
					.setIndexSource(mapStringWithScheme.evaluate(item.<RateSourcePage>map("getIndexSource", inflationRateCalculation -> inflationRateCalculation.getIndexSource()).<String>map("getValue", rateSourcePage -> rateSourcePage.getValue()).get(), item.<RateSourcePage>map("getIndexSource", inflationRateCalculation -> inflationRateCalculation.getIndexSource()).<String>map("getRateSourcePageScheme", rateSourcePage -> rateSourcePage.getRateSourcePageScheme()).get()))
					.setMainPublication(mapStringWithScheme.evaluate(item.<MainPublication>map("getMainPublication", inflationRateCalculation -> inflationRateCalculation.getMainPublication()).<String>map("getValue", mainPublication -> mainPublication.getValue()).get(), item.<MainPublication>map("getMainPublication", inflationRateCalculation -> inflationRateCalculation.getMainPublication()).<String>map("getMainPublicationScheme", mainPublication -> mainPublication.getMainPublicationScheme()).get()))
					.setInterpolationMethodValue(item.<InterpolationMethod>map("getInterpolationMethod", inflationRateCalculation -> inflationRateCalculation.getInterpolationMethod()).<String>map("getValue", interpolationMethod -> interpolationMethod.getValue()).checkedMap("to-enum", InterpolationMethodEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setFallbackBondApplicable(item.<Boolean>map("getFallbackBondApplicable", inflationRateCalculation -> inflationRateCalculation.getFallbackBondApplicable()).get())
					.build())).get());
			
			return Optional.ofNullable(inflationRateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
