package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.product.asset.StubFloatingRate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubFloatingRate.MapStubFloatingRateDefault.class)
public abstract class MapStubFloatingRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlStubFloatingRate 
	* @return stubFloatingRate 
	*/
	public StubFloatingRate evaluate(fpml.consolidated.shared.StubFloatingRate fpmlStubFloatingRate) {
		StubFloatingRate.StubFloatingRateBuilder stubFloatingRateBuilder = doEvaluate(fpmlStubFloatingRate);
		
		final StubFloatingRate stubFloatingRate;
		if (stubFloatingRateBuilder == null) {
			stubFloatingRate = null;
		} else {
			stubFloatingRate = stubFloatingRateBuilder.build();
			objectValidator.validate(StubFloatingRate.class, stubFloatingRate);
		}
		
		return stubFloatingRate;
	}

	protected abstract StubFloatingRate.StubFloatingRateBuilder doEvaluate(fpml.consolidated.shared.StubFloatingRate fpmlStubFloatingRate);

	public static class MapStubFloatingRateDefault extends MapStubFloatingRate {
		@Override
		protected StubFloatingRate.StubFloatingRateBuilder doEvaluate(fpml.consolidated.shared.StubFloatingRate fpmlStubFloatingRate) {
			StubFloatingRate.StubFloatingRateBuilder stubFloatingRate = StubFloatingRate.builder();
			return assignOutput(stubFloatingRate, fpmlStubFloatingRate);
		}
		
		protected StubFloatingRate.StubFloatingRateBuilder assignOutput(StubFloatingRate.StubFloatingRateBuilder stubFloatingRate, fpml.consolidated.shared.StubFloatingRate fpmlStubFloatingRate) {
			stubFloatingRate = toBuilder(StubFloatingRate.builder()
				.setFloatingRateIndex(MapperS.of(fpmlStubFloatingRate).<FloatingRateIndex>map("getFloatingRateIndex", _stubFloatingRate -> _stubFloatingRate.getFloatingRateIndex()).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).checkedMap("to-enum", FloatingRateIndexEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setIndexTenor(mapPeriod.evaluate(MapperS.of(fpmlStubFloatingRate).<Period>map("getIndexTenor", _stubFloatingRate -> _stubFloatingRate.getIndexTenor()).get()))
				.build());
			
			return Optional.ofNullable(stubFloatingRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
