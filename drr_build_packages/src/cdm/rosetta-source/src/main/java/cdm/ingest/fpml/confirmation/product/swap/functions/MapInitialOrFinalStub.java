package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.asset.StubFloatingRate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.StubValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapInitialOrFinalStub.MapInitialOrFinalStubDefault.class)
public abstract class MapInitialOrFinalStub implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStubFloatingRate mapStubFloatingRate;

	/**
	* @param fpmlInitialStub 
	* @return floatingRate 
	*/
	public List<? extends StubFloatingRate> evaluate(StubValue fpmlInitialStub) {
		List<StubFloatingRate.StubFloatingRateBuilder> floatingRateBuilder = doEvaluate(fpmlInitialStub);
		
		final List<? extends StubFloatingRate> floatingRate;
		if (floatingRateBuilder == null) {
			floatingRate = null;
		} else {
			floatingRate = floatingRateBuilder.stream().map(StubFloatingRate::build).collect(Collectors.toList());
			objectValidator.validate(StubFloatingRate.class, floatingRate);
		}
		
		return floatingRate;
	}

	protected abstract List<StubFloatingRate.StubFloatingRateBuilder> doEvaluate(StubValue fpmlInitialStub);

	public static class MapInitialOrFinalStubDefault extends MapInitialOrFinalStub {
		@Override
		protected List<StubFloatingRate.StubFloatingRateBuilder> doEvaluate(StubValue fpmlInitialStub) {
			List<StubFloatingRate.StubFloatingRateBuilder> floatingRate = new ArrayList<>();
			return assignOutput(floatingRate, fpmlInitialStub);
		}
		
		protected List<StubFloatingRate.StubFloatingRateBuilder> assignOutput(List<StubFloatingRate.StubFloatingRateBuilder> floatingRate, StubValue fpmlInitialStub) {
			floatingRate.addAll(toBuilder(MapperS.of(fpmlInitialStub).<fpml.consolidated.shared.StubFloatingRate>mapC("getFloatingRate", stubValue -> stubValue.getFloatingRate())
				.mapItem(item -> MapperS.of(mapStubFloatingRate.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(floatingRate)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
