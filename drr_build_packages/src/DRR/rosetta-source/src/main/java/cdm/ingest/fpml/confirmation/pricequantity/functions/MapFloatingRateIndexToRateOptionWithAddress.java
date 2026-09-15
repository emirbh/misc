package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Period;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFloatingRateIndexToRateOptionWithAddress.MapFloatingRateIndexToRateOptionWithAddressDefault.class)
public abstract class MapFloatingRateIndexToRateOptionWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateInterestRateIndexWithAddress createInterestRateIndexWithAddress;
	@Inject protected CreateKey createKey;

	/**
	* @param fpmlFloatingRateIndex 
	* @param fpmlIndexTenor 
	* @param fpmlLeg 
	* @return interestRateIndex 
	*/
	public ReferenceWithMetaInterestRateIndex evaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
		ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndexBuilder = doEvaluate(fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		
		final ReferenceWithMetaInterestRateIndex interestRateIndex;
		if (interestRateIndexBuilder == null) {
			interestRateIndex = null;
		} else {
			interestRateIndex = interestRateIndexBuilder.build();
			objectValidator.validate(ReferenceWithMetaInterestRateIndex.class, interestRateIndex);
		}
		
		return interestRateIndex;
	}

	protected abstract ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg);

	public static class MapFloatingRateIndexToRateOptionWithAddressDefault extends MapFloatingRateIndexToRateOptionWithAddress {
		@Override
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndex = ReferenceWithMetaInterestRateIndex.builder();
			return assignOutput(interestRateIndex, fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		}
		
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder assignOutput(ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndex, FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFloatingRateIndex)).andNullSafe(exists(MapperS.of(fpmlIndexTenor))).getOrDefault(false)) {
				interestRateIndex = toBuilder(createInterestRateIndexWithAddress.evaluate(createKey.evaluate("InterestRateIndex", null, fpmlLeg)));
			} else {
				interestRateIndex = toBuilder(ReferenceWithMetaInterestRateIndex.builder().build());
			}
			
			return Optional.ofNullable(interestRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
