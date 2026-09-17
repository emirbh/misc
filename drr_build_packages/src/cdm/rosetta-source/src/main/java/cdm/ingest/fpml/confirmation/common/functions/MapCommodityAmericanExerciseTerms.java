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
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityExercisePeriods;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityAmericanExerciseTerms.MapCommodityAmericanExerciseTermsDefault.class)
public abstract class MapCommodityAmericanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlCommodityAmericanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(CommodityAmericanExercise fpmlCommodityAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlCommodityAmericanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityAmericanExercise fpmlCommodityAmericanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapCommodityAmericanExerciseTermsDefault extends MapCommodityAmericanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(CommodityAmericanExercise fpmlCommodityAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlCommodityAmericanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, CommodityAmericanExercise fpmlCommodityAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			final MapperC<AdjustableOrRelativeDate> thenArg = MapperS.of(fpmlCommodityAmericanExercise).<CommodityExercisePeriods>mapC("getExercisePeriod", commodityAmericanExercise -> commodityAmericanExercise.getExercisePeriod())
				.mapItem(item -> MapperS.of(mapAdjustableOrRelativeDate.evaluate(item.<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getCommencementDate", commodityExercisePeriods -> commodityExercisePeriods.getCommencementDate()).get())));
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlCommodityAmericanExercise).<BusinessCenterTime>map("getExpirationTime", commodityAmericanExercise -> commodityAmericanExercise.getExpirationTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(thenArg
					.first().get())
				.setExpirationDate(MapperS.of(fpmlCommodityAmericanExercise).<CommodityExercisePeriods>mapC("getExercisePeriod", commodityAmericanExercise -> commodityAmericanExercise.getExercisePeriod())
					.mapItem(item -> MapperS.of(mapAdjustableOrRelativeDate.evaluate(item.<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", commodityExercisePeriods -> commodityExercisePeriods.getExpirationDate()).get()))).getMulti())
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", commodityAmericanExercise -> commodityAmericanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityAmericanExercise).<BusinessCenterTime>map("getExpirationTime", commodityAmericanExercise -> commodityAmericanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.AMERICAN)
				.setCommencementDate(thenArg
					.first().get())
				.setExpirationDate(MapperS.of(fpmlCommodityAmericanExercise).<CommodityExercisePeriods>mapC("getExercisePeriod", commodityAmericanExercise -> commodityAmericanExercise.getExercisePeriod())
					.mapItem(item -> MapperS.of(mapAdjustableOrRelativeDate.evaluate(item.<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", commodityExercisePeriods -> commodityExercisePeriods.getExpirationDate()).get()))).getMulti())
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityAmericanExercise).<BusinessCenterTime>map("getLatestExerciseTime", commodityAmericanExercise -> commodityAmericanExercise.getLatestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCommodityAmericanExercise).<BusinessCenterTime>map("getExpirationTime", commodityAmericanExercise -> commodityAmericanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCommodityAmericanExercise).<String>map("getId", commodityAmericanExercise -> commodityAmericanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
