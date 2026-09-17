package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.PartialExercise;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.EuropeanExercise;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEuropeanExerciseTerms.MapEuropeanExerciseTermsDefault.class)
public abstract class MapEuropeanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlEuropeanExercise 
	* @param cdmExerciseProcedure 
	* @param payout 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(EuropeanExercise fpmlEuropeanExercise, ExerciseProcedure cdmExerciseProcedure, Payout payout) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlEuropeanExercise, cdmExerciseProcedure, payout);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(EuropeanExercise fpmlEuropeanExercise, ExerciseProcedure cdmExerciseProcedure, Payout payout);

	public static class MapEuropeanExerciseTermsDefault extends MapEuropeanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(EuropeanExercise fpmlEuropeanExercise, ExerciseProcedure cdmExerciseProcedure, Payout payout) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlEuropeanExercise, cdmExerciseProcedure, payout);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, EuropeanExercise fpmlEuropeanExercise, ExerciseProcedure cdmExerciseProcedure, Payout payout) {
			final AdjustableOrRelativeDate adjustableOrRelativeDate = mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.AdjustableOrRelativeDate>map("getExpirationDate", europeanExercise -> europeanExercise.getExpirationDate()).get());
			ExpirationTimeTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", europeanExercise -> europeanExercise.getExpirationTime())).getOrDefault(false)) {
				ifThenElseResult = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			}
			final ExerciseTerms.ExerciseTermsBuilder withMetaArgument = ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEuropeanExercise).<BusinessCenterTime>map("getEarliestExerciseTime", europeanExercise -> europeanExercise.getEarliestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", europeanExercise -> europeanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.setPartialExercise(PartialExercise.builder()
					.setNotionaReference(ReferenceWithMetaMoney.builder().setValue(null).setExternalReference(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<NotionalReference>mapC("getNotionalReference", partialExercise -> partialExercise.getNotionalReference()).<String>map("getHref", notionalReference -> notionalReference.getHref())
						.first().get()).build())
					.setIntegralMultipleAmount(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<BigDecimal>map("getIntegralMultipleAmount", partialExercise -> partialExercise.getIntegralMultipleAmount()).get())
					.setMinimumNotionalAmount(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<BigDecimal>map("getMinimumNotionalAmount", partialExercise -> partialExercise.getMinimumNotionalAmount()).get())
					.build())
				.build() == null ? null : ExerciseTerms.builder()
				.setStyle(OptionExerciseStyleEnum.EUROPEAN)
				.setExpirationDate((adjustableOrRelativeDate == null ? Collections.<AdjustableOrRelativeDate>emptyList() : Collections.singletonList(adjustableOrRelativeDate)))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEuropeanExercise).<BusinessCenterTime>map("getEarliestExerciseTime", europeanExercise -> europeanExercise.getEarliestExerciseTime()).get()))
				.setExpirationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEuropeanExercise).<BusinessCenterTime>map("getExpirationTime", europeanExercise -> europeanExercise.getExpirationTime()).get()))
				.setExpirationTimeType(ifThenElseResult)
				.setExerciseProcedure(cdmExerciseProcedure)
				.setPartialExercise(PartialExercise.builder()
					.setNotionaReference(ReferenceWithMetaMoney.builder().setValue(null).setExternalReference(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<NotionalReference>mapC("getNotionalReference", partialExercise -> partialExercise.getNotionalReference()).<String>map("getHref", notionalReference -> notionalReference.getHref())
						.first().get()).build())
					.setIntegralMultipleAmount(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<BigDecimal>map("getIntegralMultipleAmount", partialExercise -> partialExercise.getIntegralMultipleAmount()).get())
					.setMinimumNotionalAmount(MapperS.of(fpmlEuropeanExercise).<fpml.consolidated.shared.PartialExercise>map("getPartialExercise", europeanExercise -> europeanExercise.getPartialExercise()).<BigDecimal>map("getMinimumNotionalAmount", partialExercise -> partialExercise.getMinimumNotionalAmount()).get())
					.build())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlEuropeanExercise).<String>map("getId", europeanExercise -> europeanExercise.getId()).get());
			exerciseTerms = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
