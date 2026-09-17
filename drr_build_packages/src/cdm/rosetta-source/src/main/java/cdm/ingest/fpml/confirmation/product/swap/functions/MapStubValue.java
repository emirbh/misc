package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.asset.StubValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubValue.MapStubValueDefault.class)
public abstract class MapStubValue implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInitialOrFinalStub mapInitialOrFinalStub;

	/**
	* @param fpmlStubValue 
	* @return stubValue 
	*/
	public StubValue evaluate(fpml.consolidated.shared.StubValue fpmlStubValue) {
		StubValue.StubValueBuilder stubValueBuilder = doEvaluate(fpmlStubValue);
		
		final StubValue stubValue;
		if (stubValueBuilder == null) {
			stubValue = null;
		} else {
			stubValue = stubValueBuilder.build();
			objectValidator.validate(StubValue.class, stubValue);
		}
		
		return stubValue;
	}

	protected abstract StubValue.StubValueBuilder doEvaluate(fpml.consolidated.shared.StubValue fpmlStubValue);

	public static class MapStubValueDefault extends MapStubValue {
		@Override
		protected StubValue.StubValueBuilder doEvaluate(fpml.consolidated.shared.StubValue fpmlStubValue) {
			StubValue.StubValueBuilder stubValue = StubValue.builder();
			return assignOutput(stubValue, fpmlStubValue);
		}
		
		protected StubValue.StubValueBuilder assignOutput(StubValue.StubValueBuilder stubValue, fpml.consolidated.shared.StubValue fpmlStubValue) {
			stubValue = toBuilder(StubValue.builder()
				.setStubRate(MapperS.of(fpmlStubValue).<BigDecimal>map("getStubRate", _stubValue -> _stubValue.getStubRate()).get())
				.setFloatingRate(new ArrayList(mapInitialOrFinalStub.evaluate(fpmlStubValue)))
				.build());
			
			return Optional.ofNullable(stubValue)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
