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
import fpml.consolidated.eqd.EquityAmericanExercise;
import fpml.consolidated.eqd.EquityMultipleExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityAmericanExerciseTerms.MapEquityAmericanExerciseTermsDefault.class)
public abstract class MapEquityAmericanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapEquityMultipleExercise mapEquityMultipleExercise;

	/**
	* @param fpmlEqutiyAmericanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(EquityAmericanExercise fpmlEqutiyAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlEqutiyAmericanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityAmericanExercise fpmlEqutiyAmericanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapEquityAmericanExerciseTermsDefault extends MapEquityAmericanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityAmericanExercise fpmlEqutiyAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlEqutiyAmericanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, EquityAmericanExercise fpmlEqutiyAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", equityAmericanExercise -> equityAmericanExercise.getExpirationDate()).get());
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", equityAmericanExercise -> equityAmericanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", equityAmericanExercise -> equityAmericanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityAmericanExercise -> equityAmericanExercise.getEquityExpirationTime()).get()))
				.setExpirationTimeType(MapperS.of(fpmlEqutiyAmericanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityAmericanExercise -> equityAmericanExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExerciseProcedure(cdmExerciseProcedure)
				.setMultipleExercise(mapEquityMultipleExercise.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<EquityMultipleExercise>map("getEquityMultipleExercise", equityAmericanExercise -> equityAmericanExercise.getEquityMultipleExercise()).get()))
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", equityAmericanExercise -> equityAmericanExercise.getCommencementDate()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", equityAmericanExercise -> equityAmericanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityAmericanExercise -> equityAmericanExercise.getEquityExpirationTime()).get()))
				.setExpirationTimeType(MapperS.of(fpmlEqutiyAmericanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityAmericanExercise -> equityAmericanExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExerciseProcedure(cdmExerciseProcedure)
				.setMultipleExercise(mapEquityMultipleExercise.evaluate(MapperS.of(fpmlEqutiyAmericanExercise).<EquityMultipleExercise>map("getEquityMultipleExercise", equityAmericanExercise -> equityAmericanExercise.getEquityMultipleExercise()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlEqutiyAmericanExercise).<String>map("getId", equityAmericanExercise -> equityAmericanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
