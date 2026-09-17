package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPhysicalEuropeanExercise.MapCommodityPhysicalEuropeanExerciseDefault.class)
public abstract class MapCommodityPhysicalEuropeanExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityPhysicalEuropeanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(CommodityPhysicalEuropeanExercise fpmlCommodityPhysicalEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlCommodityPhysicalEuropeanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityPhysicalEuropeanExercise fpmlCommodityPhysicalEuropeanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapCommodityPhysicalEuropeanExerciseDefault extends MapCommodityPhysicalEuropeanExercise {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityPhysicalEuropeanExercise fpmlCommodityPhysicalEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlCommodityPhysicalEuropeanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, CommodityPhysicalEuropeanExercise fpmlCommodityPhysicalEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			exerciseTerms = toBuilder(ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate(MapperS.of(fpmlCommodityPhysicalEuropeanExercise).<AdjustableRelativeOrPeriodicDates2>map("getExpirationDates", commodityPhysicalEuropeanExercise -> commodityPhysicalEuropeanExercise.getExpirationDates()).<AdjustableDates>map("getAdjustableDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getAdjustableDates()).<IdentifiedDate>mapC("getUnadjustedDate", adjustableDates -> adjustableDates.getUnadjustedDate())
					.mapItem(item -> MapperS.of(AdjustableOrRelativeDate.builder()
						.setAdjustableDate(AdjustableDate.builder()
							.setUnadjustedDate(item.<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setRelativeDate(null)
						.build())).getMulti())
				.setExpirationTimeType(null)
				.build());
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
