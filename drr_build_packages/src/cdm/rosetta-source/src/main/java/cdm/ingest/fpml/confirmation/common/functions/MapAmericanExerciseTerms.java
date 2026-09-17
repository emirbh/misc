package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
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
import fpml.consolidated.shared.AmericanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.MultipleExercise;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAmericanExerciseTerms.MapAmericanExerciseTermsDefault.class)
public abstract class MapAmericanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableOrRelativeDates mapAdjustableOrRelativeDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapMultipleExercise mapMultipleExercise;

	/**
	* @param fpmlAmericanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(AmericanExercise fpmlAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlAmericanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(AmericanExercise fpmlAmericanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapAmericanExerciseTermsDefault extends MapAmericanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(AmericanExercise fpmlAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlAmericanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, AmericanExercise fpmlAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", americanExercise -> americanExercise.getExpirationDate()).get());
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getExpirationTime", americanExercise -> americanExercise.getExpirationTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", americanExercise -> americanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setRelevantUnderlyingDate(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlAmericanExercise).<AdjustableOrRelativeDates>map("getRelevantUnderlyingDate", americanExercise -> americanExercise.getRelevantUnderlyingDate()).get()))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getEarliestExerciseTime", americanExercise -> americanExercise.getEarliestExerciseTime()).get()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", americanExercise -> americanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getExpirationTime", americanExercise -> americanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.setMultipleExercise(mapMultipleExercise.evaluate(MapperS.of(fpmlAmericanExercise).<MultipleExercise>map("getMultipleExercise", americanExercise -> americanExercise.getMultipleExercise()).get()))
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", americanExercise -> americanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setRelevantUnderlyingDate(mapAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlAmericanExercise).<AdjustableOrRelativeDates>map("getRelevantUnderlyingDate", americanExercise -> americanExercise.getRelevantUnderlyingDate()).get()))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getEarliestExerciseTime", americanExercise -> americanExercise.getEarliestExerciseTime()).get()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", americanExercise -> americanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlAmericanExercise).<BusinessCenterTime>map("getExpirationTime", americanExercise -> americanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.setMultipleExercise(mapMultipleExercise.evaluate(MapperS.of(fpmlAmericanExercise).<MultipleExercise>map("getMultipleExercise", americanExercise -> americanExercise.getMultipleExercise()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAmericanExercise).<String>map("getId", americanExercise -> americanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
