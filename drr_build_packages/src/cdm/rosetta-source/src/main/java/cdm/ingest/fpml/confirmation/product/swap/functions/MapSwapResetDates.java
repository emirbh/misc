package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.ingest.fpml.confirmation.other.functions.MapResetRelativeToEnum;
import cdm.product.common.schedule.InitialFixingDate;
import cdm.product.common.schedule.ResetDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.ResetRelativeToEnum;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.ResetFrequency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapResetDates.MapSwapResetDatesDefault.class)
public abstract class MapSwapResetDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapResetFrequency mapResetFrequency;
	@Inject protected MapResetRelativeToEnum mapResetRelativeToEnum;

	/**
	* @param fpmlResetDates 
	* @return resetDates 
	*/
	public ResetDates evaluate(fpml.consolidated.ird.ResetDates fpmlResetDates) {
		ResetDates.ResetDatesBuilder resetDatesBuilder = doEvaluate(fpmlResetDates);
		
		final ResetDates resetDates;
		if (resetDatesBuilder == null) {
			resetDates = null;
		} else {
			resetDates = resetDatesBuilder.build();
			objectValidator.validate(ResetDates.class, resetDates);
		}
		
		return resetDates;
	}

	protected abstract ResetDates.ResetDatesBuilder doEvaluate(fpml.consolidated.ird.ResetDates fpmlResetDates);

	public static class MapSwapResetDatesDefault extends MapSwapResetDates {
		@Override
		protected ResetDates.ResetDatesBuilder doEvaluate(fpml.consolidated.ird.ResetDates fpmlResetDates) {
			ResetDates.ResetDatesBuilder resetDates = ResetDates.builder();
			return assignOutput(resetDates, fpmlResetDates);
		}
		
		protected ResetDates.ResetDatesBuilder assignOutput(ResetDates.ResetDatesBuilder resetDates, fpml.consolidated.ird.ResetDates fpmlResetDates) {
			final ResetDates.ResetDatesBuilder withMetaArgument = ResetDates.builder()
				.setResetRelativeTo(mapResetRelativeToEnum.evaluate(MapperS.of(fpmlResetDates).<ResetRelativeToEnum>map("getResetRelativeTo", _resetDates -> _resetDates.getResetRelativeTo()).map("to-string", ResetRelativeToEnum::toDisplayString).get()))
				.setInitialFixingDate(InitialFixingDate.builder()
					.setRelativeDateOffset(mapRelativeDateOffset.evaluate(MapperS.of(fpmlResetDates).<RelativeDateOffset>map("getInitialFixingDate", _resetDates -> _resetDates.getInitialFixingDate()).get()))
					.build())
				.setFixingDates(mapRelativeDateOffset.evaluate(MapperS.of(fpmlResetDates).<RelativeDateOffset>map("getFixingDates", _resetDates -> _resetDates.getFixingDates()).get()))
				.setResetFrequency(mapResetFrequency.evaluate(MapperS.of(fpmlResetDates).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).get()))
				.setResetDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlResetDates).<BusinessDayAdjustments>map("getResetDatesAdjustments", _resetDates -> _resetDates.getResetDatesAdjustments()).get()))
				.build() == null ? null : ResetDates.builder()
				.setResetRelativeTo(mapResetRelativeToEnum.evaluate(MapperS.of(fpmlResetDates).<ResetRelativeToEnum>map("getResetRelativeTo", _resetDates -> _resetDates.getResetRelativeTo()).map("to-string", ResetRelativeToEnum::toDisplayString).get()))
				.setInitialFixingDate(InitialFixingDate.builder()
					.setRelativeDateOffset(mapRelativeDateOffset.evaluate(MapperS.of(fpmlResetDates).<RelativeDateOffset>map("getInitialFixingDate", _resetDates -> _resetDates.getInitialFixingDate()).get()))
					.build())
				.setFixingDates(mapRelativeDateOffset.evaluate(MapperS.of(fpmlResetDates).<RelativeDateOffset>map("getFixingDates", _resetDates -> _resetDates.getFixingDates()).get()))
				.setResetFrequency(mapResetFrequency.evaluate(MapperS.of(fpmlResetDates).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).get()))
				.setResetDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlResetDates).<BusinessDayAdjustments>map("getResetDatesAdjustments", _resetDates -> _resetDates.getResetDatesAdjustments()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlResetDates).<String>map("getId", _resetDates -> _resetDates.getId()).get());
			resetDates = toBuilder(withMetaArgument, () -> ResetDates.builder());
			
			resetDates
				.getOrCreateCalculationPeriodDatesReference()
				.setExternalReference(MapperS.of(fpmlResetDates).<CalculationPeriodDatesReference>map("getCalculationPeriodDatesReference", _resetDates -> _resetDates.getCalculationPeriodDatesReference()).<String>map("getHref", calculationPeriodDatesReference -> calculationPeriodDatesReference.getHref()).get());
			
			return Optional.ofNullable(resetDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
