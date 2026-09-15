package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapDateToAdjustableOrRelativeDate;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxEuropeanExerciseTerms.MapFxEuropeanExerciseTermsDefault.class)
public abstract class MapFxEuropeanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapDateToAdjustableOrRelativeDate mapDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlFxEuropeanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(FxEuropeanExercise fpmlFxEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlFxEuropeanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxEuropeanExercise fpmlFxEuropeanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapFxEuropeanExerciseTermsDefault extends MapFxEuropeanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxEuropeanExercise fpmlFxEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlFxEuropeanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, FxEuropeanExercise fpmlFxEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFxEuropeanExercise).<ZonedDateTime>map("getExpiryDate", fxEuropeanExercise -> fxEuropeanExercise.getExpiryDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get());
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlFxEuropeanExercise).<BusinessCenterTime>map("getExpiryTime", fxEuropeanExercise -> fxEuropeanExercise.getExpiryTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlFxEuropeanExercise).<BusinessCenterTime>map("getExpiryTime", fxEuropeanExercise -> fxEuropeanExercise.getExpiryTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlFxEuropeanExercise).<BusinessCenterTime>map("getExpiryTime", fxEuropeanExercise -> fxEuropeanExercise.getExpiryTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlFxEuropeanExercise).<String>map("getId", fxEuropeanExercise -> fxEuropeanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
