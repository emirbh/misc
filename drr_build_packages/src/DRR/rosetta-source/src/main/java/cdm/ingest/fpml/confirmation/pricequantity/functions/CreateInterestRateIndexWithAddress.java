package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateInterestRateIndexWithAddress.CreateInterestRateIndexWithAddressDefault.class)
public abstract class CreateInterestRateIndexWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param keyValue 
	* @return interestRateIndexWithAddress 
	*/
	public ReferenceWithMetaInterestRateIndex evaluate(String keyValue) {
		ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndexWithAddressBuilder = doEvaluate(keyValue);
		
		final ReferenceWithMetaInterestRateIndex interestRateIndexWithAddress;
		if (interestRateIndexWithAddressBuilder == null) {
			interestRateIndexWithAddress = null;
		} else {
			interestRateIndexWithAddress = interestRateIndexWithAddressBuilder.build();
			objectValidator.validate(ReferenceWithMetaInterestRateIndex.class, interestRateIndexWithAddress);
		}
		
		return interestRateIndexWithAddress;
	}

	protected abstract ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(String keyValue);

	public static class CreateInterestRateIndexWithAddressDefault extends CreateInterestRateIndexWithAddress {
		@Override
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(String keyValue) {
			ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndexWithAddress = ReferenceWithMetaInterestRateIndex.builder();
			return assignOutput(interestRateIndexWithAddress, keyValue);
		}
		
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder assignOutput(ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder interestRateIndexWithAddress, String keyValue) {
			interestRateIndexWithAddress = toBuilder(ReferenceWithMetaInterestRateIndex.builder().setValue(null).setReference(Reference.builder().setReference(keyValue)).build());
			
			return Optional.ofNullable(interestRateIndexWithAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
