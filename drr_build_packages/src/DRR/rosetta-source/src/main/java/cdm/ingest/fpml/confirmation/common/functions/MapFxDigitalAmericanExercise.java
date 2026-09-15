package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
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
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxDigitalAmericanExercise.MapFxDigitalAmericanExerciseDefault.class)
public abstract class MapFxDigitalAmericanExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapDateToAdjustableOrRelativeDate mapDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlFxAmericanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(FxDigitalAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlFxAmericanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxDigitalAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapFxDigitalAmericanExerciseDefault extends MapFxDigitalAmericanExercise {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxDigitalAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlFxAmericanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, FxDigitalAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFxAmericanExercise).<ZonedDateTime>map("getExpiryDate", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getExpiryDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get());
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlFxAmericanExercise).<BusinessCenterTime>map("getExpiryTime", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getExpiryTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFxAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlFxAmericanExercise).<BusinessCenterTime>map("getExpiryTime", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getExpiryTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFxAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlFxAmericanExercise).<BusinessCenterTime>map("getExpiryTime", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getExpiryTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlFxAmericanExercise).<String>map("getId", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
