package cdm.ingest.fpml.confirmation.common.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.BermudaExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBermudaExerciseTerms.MapBermudaExerciseTermsDefault.class)
public abstract class MapBermudaExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDates mapAdjustableOrRelativeDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlBermudaExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(BermudaExercise fpmlBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlBermudaExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(BermudaExercise fpmlBermudaExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapBermudaExerciseTermsDefault extends MapBermudaExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(BermudaExercise fpmlBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlBermudaExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, BermudaExercise fpmlBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getExpirationTime", bermudaExercise -> bermudaExercise.getExpirationTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.BERMUDA)
				.setExerciseDates(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlBermudaExercise).<AdjustableOrRelativeDates>map("getBermudaExerciseDates", bermudaExercise -> bermudaExercise.getBermudaExerciseDates()).get()))
				.setRelevantUnderlyingDate(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlBermudaExercise).<AdjustableOrRelativeDates>map("getRelevantUnderlyingDate", bermudaExercise -> bermudaExercise.getRelevantUnderlyingDate()).get()))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getEarliestExerciseTime", bermudaExercise -> bermudaExercise.getEarliestExerciseTime()).get()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getLatestExerciseTime", bermudaExercise -> bermudaExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getExpirationTime", bermudaExercise -> bermudaExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.BERMUDA)
				.setExerciseDates(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlBermudaExercise).<AdjustableOrRelativeDates>map("getBermudaExerciseDates", bermudaExercise -> bermudaExercise.getBermudaExerciseDates()).get()))
				.setRelevantUnderlyingDate(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlBermudaExercise).<AdjustableOrRelativeDates>map("getRelevantUnderlyingDate", bermudaExercise -> bermudaExercise.getRelevantUnderlyingDate()).get()))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getEarliestExerciseTime", bermudaExercise -> bermudaExercise.getEarliestExerciseTime()).get()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getLatestExerciseTime", bermudaExercise -> bermudaExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlBermudaExercise).<BusinessCenterTime>map("getExpirationTime", bermudaExercise -> bermudaExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlBermudaExercise).<String>map("getId", bermudaExercise -> bermudaExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
