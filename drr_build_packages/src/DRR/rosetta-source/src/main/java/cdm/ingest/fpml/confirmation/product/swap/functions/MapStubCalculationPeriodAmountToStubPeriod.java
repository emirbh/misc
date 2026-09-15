package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.common.schedule.StubPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.shared.StubValue;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubCalculationPeriodAmountToStubPeriod.MapStubCalculationPeriodAmountToStubPeriodDefault.class)
public abstract class MapStubCalculationPeriodAmountToStubPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStubValue mapStubValue;

	/**
	* @param fpmlStubCalculationPeriodAmount 
	* @return stubPeriod 
	*/
	public StubPeriod evaluate(StubCalculationPeriodAmount fpmlStubCalculationPeriodAmount) {
		StubPeriod.StubPeriodBuilder stubPeriodBuilder = doEvaluate(fpmlStubCalculationPeriodAmount);
		
		final StubPeriod stubPeriod;
		if (stubPeriodBuilder == null) {
			stubPeriod = null;
		} else {
			stubPeriod = stubPeriodBuilder.build();
			objectValidator.validate(StubPeriod.class, stubPeriod);
		}
		
		return stubPeriod;
	}

	protected abstract StubPeriod.StubPeriodBuilder doEvaluate(StubCalculationPeriodAmount fpmlStubCalculationPeriodAmount);

	public static class MapStubCalculationPeriodAmountToStubPeriodDefault extends MapStubCalculationPeriodAmountToStubPeriod {
		@Override
		protected StubPeriod.StubPeriodBuilder doEvaluate(StubCalculationPeriodAmount fpmlStubCalculationPeriodAmount) {
			StubPeriod.StubPeriodBuilder stubPeriod = StubPeriod.builder();
			return assignOutput(stubPeriod, fpmlStubCalculationPeriodAmount);
		}
		
		protected StubPeriod.StubPeriodBuilder assignOutput(StubPeriod.StubPeriodBuilder stubPeriod, StubCalculationPeriodAmount fpmlStubCalculationPeriodAmount) {
			stubPeriod = toBuilder(StubPeriod.builder()
				.setCalculationPeriodDatesReferenceValue(null)
				.setFinalStub(mapStubValue.evaluate(MapperS.of(fpmlStubCalculationPeriodAmount).<StubValue>map("getFinalStub", stubCalculationPeriodAmount -> stubCalculationPeriodAmount.getFinalStub()).get()))
				.setInitialStub(mapStubValue.evaluate(MapperS.of(fpmlStubCalculationPeriodAmount).<StubValue>map("getInitialStub", stubCalculationPeriodAmount -> stubCalculationPeriodAmount.getInitialStub()).get()))
				.build(), () -> StubPeriod.builder());
			
			stubPeriod
				.getOrCreateCalculationPeriodDatesReference()
				.setExternalReference(MapperS.of(fpmlStubCalculationPeriodAmount).<CalculationPeriodDatesReference>map("getCalculationPeriodDatesReference", stubCalculationPeriodAmount -> stubCalculationPeriodAmount.getCalculationPeriodDatesReference()).<String>map("getHref", calculationPeriodDatesReference -> calculationPeriodDatesReference.getHref()).get());
			
			return Optional.ofNullable(stubPeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
