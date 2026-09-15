package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateInterestRateIndexWithLocation.CreateInterestRateIndexWithLocationDefault.class)
public abstract class CreateInterestRateIndexWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param interestRateIndex 
	* @param keyValue 
	* @return interestRateIndexWithLocation 
	*/
	public FieldWithMetaInterestRateIndex evaluate(InterestRateIndex interestRateIndex, String keyValue) {
		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndexWithLocationBuilder = doEvaluate(interestRateIndex, keyValue);
		
		final FieldWithMetaInterestRateIndex interestRateIndexWithLocation;
		if (interestRateIndexWithLocationBuilder == null) {
			interestRateIndexWithLocation = null;
		} else {
			interestRateIndexWithLocation = interestRateIndexWithLocationBuilder.build();
			objectValidator.validate(FieldWithMetaInterestRateIndex.class, interestRateIndexWithLocation);
		}
		
		return interestRateIndexWithLocation;
	}

	protected abstract FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(InterestRateIndex interestRateIndex, String keyValue);

	public static class CreateInterestRateIndexWithLocationDefault extends CreateInterestRateIndexWithLocation {
		@Override
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(InterestRateIndex interestRateIndex, String keyValue) {
			FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndexWithLocation = FieldWithMetaInterestRateIndex.builder();
			return assignOutput(interestRateIndexWithLocation, interestRateIndex, keyValue);
		}
		
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder assignOutput(FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndexWithLocation, InterestRateIndex interestRateIndex, String keyValue) {
			final InterestRateIndex.InterestRateIndexBuilder withMetaArgument = interestRateIndex == null ? null : interestRateIndex.toBuilder();
			interestRateIndexWithLocation = toBuilder(FieldWithMetaInterestRateIndex.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(keyValue)));
			
			return Optional.ofNullable(interestRateIndexWithLocation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
