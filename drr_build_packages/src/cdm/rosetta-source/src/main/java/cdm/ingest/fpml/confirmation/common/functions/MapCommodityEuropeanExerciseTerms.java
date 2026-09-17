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
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityEuropeanExerciseTerms.MapCommodityEuropeanExerciseTermsDefault.class)
public abstract class MapCommodityEuropeanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlCommodityEuropeanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(CommodityEuropeanExercise fpmlCommodityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlCommodityEuropeanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityEuropeanExercise fpmlCommodityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapCommodityEuropeanExerciseTermsDefault extends MapCommodityEuropeanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityEuropeanExercise fpmlCommodityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlCommodityEuropeanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, CommodityEuropeanExercise fpmlCommodityEuropeanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCommodityEuropeanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>mapC("getExpirationDate", commodityEuropeanExercise -> commodityEuropeanExercise.getExpirationDate())
				.last().get());
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlCommodityEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", commodityEuropeanExercise -> commodityEuropeanExercise.getExpirationTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", commodityEuropeanExercise -> commodityEuropeanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", commodityEuropeanExercise -> commodityEuropeanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCommodityEuropeanExercise).<String>map("getId", commodityEuropeanExercise -> commodityEuropeanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
