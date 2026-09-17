package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.ingest.fpml.confirmation.other.functions.MapResetRelativeToEnum;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapResetFrequency;
import cdm.product.common.schedule.InitialFixingDate;
import cdm.product.common.schedule.ResetDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDatesReference;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.fpmlenum.ResetRelativeToEnum;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.ResetFrequency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestLegResetDates.MapInterestLegResetDatesDefault.class)
public abstract class MapInterestLegResetDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapResetFrequency mapResetFrequency;
	@Inject protected MapResetRelativeToEnum mapResetRelativeToEnum;

	/**
	* @param fpmlInterestLegResetDates 
	* @return resetDates 
	*/
	public ResetDates evaluate(InterestLegResetDates fpmlInterestLegResetDates) {
		ResetDates.ResetDatesBuilder resetDatesBuilder = doEvaluate(fpmlInterestLegResetDates);
		
		final ResetDates resetDates;
		if (resetDatesBuilder == null) {
			resetDates = null;
		} else {
			resetDates = resetDatesBuilder.build();
			objectValidator.validate(ResetDates.class, resetDates);
		}
		
		return resetDates;
	}

	protected abstract ResetDates.ResetDatesBuilder doEvaluate(InterestLegResetDates fpmlInterestLegResetDates);

	public static class MapInterestLegResetDatesDefault extends MapInterestLegResetDates {
		@Override
		protected ResetDates.ResetDatesBuilder doEvaluate(InterestLegResetDates fpmlInterestLegResetDates) {
			ResetDates.ResetDatesBuilder resetDates = ResetDates.builder();
			return assignOutput(resetDates, fpmlInterestLegResetDates);
		}
		
		protected ResetDates.ResetDatesBuilder assignOutput(ResetDates.ResetDatesBuilder resetDates, InterestLegResetDates fpmlInterestLegResetDates) {
			resetDates = toBuilder(ResetDates.builder()
				.setResetRelativeTo(mapResetRelativeToEnum.evaluate(MapperS.of(fpmlInterestLegResetDates).<ResetRelativeToEnum>map("getResetRelativeTo", interestLegResetDates -> interestLegResetDates.getResetRelativeTo()).map("to-string", ResetRelativeToEnum::toDisplayString).get()))
				.setInitialFixingDate(InitialFixingDate.builder()
					.setRelativeDateOffset(mapRelativeDateOffset.evaluate(MapperS.of(fpmlInterestLegResetDates).<RelativeDateOffset>map("getInitialFixingDate", interestLegResetDates -> interestLegResetDates.getInitialFixingDate()).get()))
					.build())
				.setFixingDates(mapRelativeDateOffset.evaluate(MapperS.of(fpmlInterestLegResetDates).<AdjustableDatesOrRelativeDateOffset>map("getFixingDates", interestLegResetDates -> interestLegResetDates.getFixingDates()).<RelativeDateOffset>map("getRelativeDate", adjustableDatesOrRelativeDateOffset -> adjustableDatesOrRelativeDateOffset.getRelativeDate()).get()))
				.setResetFrequency(mapResetFrequency.evaluate(MapperS.of(fpmlInterestLegResetDates).<ResetFrequency>map("getResetFrequency", interestLegResetDates -> interestLegResetDates.getResetFrequency()).get()))
				.build(), () -> ResetDates.builder());
			
			resetDates
				.getOrCreateCalculationPeriodDatesReference()
				.setExternalReference(MapperS.of(fpmlInterestLegResetDates).<InterestLegCalculationPeriodDatesReference>map("getCalculationPeriodDatesReference", interestLegResetDates -> interestLegResetDates.getCalculationPeriodDatesReference()).<String>map("getHref", interestLegCalculationPeriodDatesReference -> interestLegCalculationPeriodDatesReference.getHref()).get());
			
			return Optional.ofNullable(resetDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
