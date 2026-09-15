package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapDateListToAdjustableOrRelativeDates;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.EquityMultipleExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DateList;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityBermudaExerciseTerms.MapEquityBermudaExerciseTermsDefault.class)
public abstract class MapEquityBermudaExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapDateListToAdjustableOrRelativeDates mapDateListToAdjustableOrRelativeDates;
	@Inject protected MapEquityMultipleExercise mapEquityMultipleExercise;

	/**
	* @param fpmlEquityBermudaExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(EquityBermudaExercise fpmlEquityBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlEquityBermudaExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityBermudaExercise fpmlEquityBermudaExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapEquityBermudaExerciseTermsDefault extends MapEquityBermudaExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(EquityBermudaExercise fpmlEquityBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlEquityBermudaExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, EquityBermudaExercise fpmlEquityBermudaExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEquityBermudaExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", equityBermudaExercise -> equityBermudaExercise.getExpirationDate()).get());
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.BERMUDA)
				.setExpirationTimeType(MapperS.of(fpmlEquityBermudaExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityBermudaExercise -> equityBermudaExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEquityBermudaExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", equityBermudaExercise -> equityBermudaExercise.getCommencementDate()).get()))
				.setMultipleExercise(mapEquityMultipleExercise.evaluate(MapperS.of(fpmlEquityBermudaExercise).<EquityMultipleExercise>map("getEquityMultipleExercise", equityBermudaExercise -> equityBermudaExercise.getEquityMultipleExercise()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExerciseDates(mapDateListToAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlEquityBermudaExercise).<DateList>map("getBermudaExerciseDates", equityBermudaExercise -> equityBermudaExercise.getBermudaExerciseDates()).<ZonedDateTime>mapC("getDate", dateList -> dateList.getDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).getMulti()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityBermudaExercise).<BusinessCenterTime>map("getLatestExerciseTime", equityBermudaExercise -> equityBermudaExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityBermudaExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityBermudaExercise -> equityBermudaExercise.getEquityExpirationTime()).get()))
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.BERMUDA)
				.setExpirationTimeType(MapperS.of(fpmlEquityBermudaExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", equityBermudaExercise -> equityBermudaExercise.getEquityExpirationTimeType()).checkedMap("to-enum", e -> ExpirationTimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEquityBermudaExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", equityBermudaExercise -> equityBermudaExercise.getCommencementDate()).get()))
				.setMultipleExercise(mapEquityMultipleExercise.evaluate(MapperS.of(fpmlEquityBermudaExercise).<EquityMultipleExercise>map("getEquityMultipleExercise", equityBermudaExercise -> equityBermudaExercise.getEquityMultipleExercise()).get()))
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExerciseDates(mapDateListToAdjustableOrRelativeDates.evaluate(MapperS.of(fpmlEquityBermudaExercise).<DateList>map("getBermudaExerciseDates", equityBermudaExercise -> equityBermudaExercise.getBermudaExerciseDates()).<ZonedDateTime>mapC("getDate", dateList -> dateList.getDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).getMulti()))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityBermudaExercise).<BusinessCenterTime>map("getLatestExerciseTime", equityBermudaExercise -> equityBermudaExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityBermudaExercise).<BusinessCenterTime>map("getEquityExpirationTime", equityBermudaExercise -> equityBermudaExercise.getEquityExpirationTime()).get()))
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlEquityBermudaExercise).<String>map("getId", equityBermudaExercise -> equityBermudaExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
