package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceCurrency.MapReferenceCurrencyDefault.class)
public abstract class MapReferenceCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlReferenceCurrency 
	* @return currency 
	*/
	public FieldWithMetaString evaluate(IdentifiedCurrency fpmlReferenceCurrency) {
		FieldWithMetaString.FieldWithMetaStringBuilder currencyBuilder = doEvaluate(fpmlReferenceCurrency);
		
		final FieldWithMetaString currency;
		if (currencyBuilder == null) {
			currency = null;
		} else {
			currency = currencyBuilder.build();
			objectValidator.validate(FieldWithMetaString.class, currency);
		}
		
		return currency;
	}

	protected abstract FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(IdentifiedCurrency fpmlReferenceCurrency);

	public static class MapReferenceCurrencyDefault extends MapReferenceCurrency {
		@Override
		protected FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(IdentifiedCurrency fpmlReferenceCurrency) {
			FieldWithMetaString.FieldWithMetaStringBuilder currency = FieldWithMetaString.builder();
			return assignOutput(currency, fpmlReferenceCurrency);
		}
		
		protected FieldWithMetaString.FieldWithMetaStringBuilder assignOutput(FieldWithMetaString.FieldWithMetaStringBuilder currency, IdentifiedCurrency fpmlReferenceCurrency) {
			final String withMetaArgument = MapperS.of(fpmlReferenceCurrency).<String>map("getValue", identifiedCurrency -> identifiedCurrency.getValue()).get();
			currency = toBuilder(FieldWithMetaString.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setExternalKey(MapperS.of(fpmlReferenceCurrency).<String>map("getId", identifiedCurrency -> identifiedCurrency.getId()).get()).setScheme(MapperS.of(fpmlReferenceCurrency).<String>map("getCurrencyScheme", identifiedCurrency -> identifiedCurrency.getCurrencyScheme()).get())));
			
			return Optional.ofNullable(currency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
