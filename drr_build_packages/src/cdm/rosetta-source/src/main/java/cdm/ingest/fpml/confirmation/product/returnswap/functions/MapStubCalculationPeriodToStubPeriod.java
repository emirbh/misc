package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.product.swap.functions.MapStubValue;
import cdm.product.common.schedule.StubPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.StubCalculationPeriod;
import fpml.consolidated.shared.Stub;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubCalculationPeriodToStubPeriod.MapStubCalculationPeriodToStubPeriodDefault.class)
public abstract class MapStubCalculationPeriodToStubPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStubValue mapStubValue;

	/**
	* @param fpmlStubCalculationPeriod 
	* @return stubPeriod 
	*/
	public StubPeriod evaluate(StubCalculationPeriod fpmlStubCalculationPeriod) {
		StubPeriod.StubPeriodBuilder stubPeriodBuilder = doEvaluate(fpmlStubCalculationPeriod);
		
		final StubPeriod stubPeriod;
		if (stubPeriodBuilder == null) {
			stubPeriod = null;
		} else {
			stubPeriod = stubPeriodBuilder.build();
			objectValidator.validate(StubPeriod.class, stubPeriod);
		}
		
		return stubPeriod;
	}

	protected abstract StubPeriod.StubPeriodBuilder doEvaluate(StubCalculationPeriod fpmlStubCalculationPeriod);

	public static class MapStubCalculationPeriodToStubPeriodDefault extends MapStubCalculationPeriodToStubPeriod {
		@Override
		protected StubPeriod.StubPeriodBuilder doEvaluate(StubCalculationPeriod fpmlStubCalculationPeriod) {
			StubPeriod.StubPeriodBuilder stubPeriod = StubPeriod.builder();
			return assignOutput(stubPeriod, fpmlStubCalculationPeriod);
		}
		
		protected StubPeriod.StubPeriodBuilder assignOutput(StubPeriod.StubPeriodBuilder stubPeriod, StubCalculationPeriod fpmlStubCalculationPeriod) {
			stubPeriod = toBuilder(StubPeriod.builder()
				.setCalculationPeriodDatesReferenceValue(null)
				.setFinalStub(mapStubValue.evaluate(MapperS.of(fpmlStubCalculationPeriod).<Stub>map("getFinalStub", stubCalculationPeriod -> stubCalculationPeriod.getFinalStub()).get()))
				.setInitialStub(mapStubValue.evaluate(MapperS.of(fpmlStubCalculationPeriod).<Stub>map("getInitialStub", stubCalculationPeriod -> stubCalculationPeriod.getInitialStub()).get()))
				.build());
			
			return Optional.ofNullable(stubPeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
