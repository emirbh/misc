package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityEuropeanExerciseTerms.MapEquityEuropeanExerciseTermsDefault.class)
public abstract class MapEquityEuropeanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlEquityEuropeanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(EquityEuropeanExercise fpmlEquityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlEquityEuropeanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityEuropeanExercise fpmlEquityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapEquityEuropeanExerciseTermsDefault extends MapEquityEuropeanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityEuropeanExercise fpmlEquityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlEquityEuropeanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, EquityEuropeanExercise fpmlEquityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEquityEuropeanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", equityEuropeanExercise -> equityEuropeanExercise.getExpirationDate()).get());
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityEuropeanExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityEuropeanExercise -> equityEuropeanExercise.getEquityExpirationTime()).get()))
				.setExpirationTimeType(MapperS.of(fpmlEquityEuropeanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityEuropeanExercise -> equityEuropeanExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityEuropeanExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityEuropeanExercise -> equityEuropeanExercise.getEquityExpirationTime()).get()))
				.setExpirationTimeType(MapperS.of(fpmlEquityEuropeanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityEuropeanExercise -> equityEuropeanExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlEquityEuropeanExercise).<String>map("getId", equityEuropeanExercise -> equityEuropeanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
