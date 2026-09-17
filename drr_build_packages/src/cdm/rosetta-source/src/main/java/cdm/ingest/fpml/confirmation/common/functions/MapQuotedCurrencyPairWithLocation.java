package cdm.ingest.fpml.confirmation.common.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuotedCurrencyPairKey;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuotedCurrencyPairWithLocation.MapQuotedCurrencyPairWithLocationDefault.class)
public abstract class MapQuotedCurrencyPairWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuotedCurrencyPairKey createQuotedCurrencyPairKey;
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;

	/**
	* @param fpmlQuotedCurrencyPair 
	* @return quotedCurrencyPair 
	*/
	public FieldWithMetaQuotedCurrencyPair evaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
		FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder quotedCurrencyPairBuilder = doEvaluate(fpmlQuotedCurrencyPair);
		
		final FieldWithMetaQuotedCurrencyPair quotedCurrencyPair;
		if (quotedCurrencyPairBuilder == null) {
			quotedCurrencyPair = null;
		} else {
			quotedCurrencyPair = quotedCurrencyPairBuilder.build();
			objectValidator.validate(FieldWithMetaQuotedCurrencyPair.class, quotedCurrencyPair);
		}
		
		return quotedCurrencyPair;
	}

	protected abstract FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair);

	public static class MapQuotedCurrencyPairWithLocationDefault extends MapQuotedCurrencyPairWithLocation {
		@Override
		protected FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder quotedCurrencyPair = FieldWithMetaQuotedCurrencyPair.builder();
			return assignOutput(quotedCurrencyPair, fpmlQuotedCurrencyPair);
		}
		
		protected FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder assignOutput(FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder quotedCurrencyPair, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			final cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPairBuilder withMetaArgument = mapQuotedCurrencyPair.evaluate(fpmlQuotedCurrencyPair) == null ? null : mapQuotedCurrencyPair.evaluate(fpmlQuotedCurrencyPair).toBuilder();
			quotedCurrencyPair = toBuilder(FieldWithMetaQuotedCurrencyPair.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(createQuotedCurrencyPairKey.evaluate(fpmlQuotedCurrencyPair))));
			
			return Optional.ofNullable(quotedCurrencyPair)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
