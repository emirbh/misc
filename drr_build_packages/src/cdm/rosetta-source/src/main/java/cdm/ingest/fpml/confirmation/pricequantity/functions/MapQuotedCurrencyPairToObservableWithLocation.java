package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapQuotedCurrencyPairWithLocation;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.RateSourcePage;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuotedCurrencyPairToObservableWithLocation.MapQuotedCurrencyPairToObservableWithLocationDefault.class)
public abstract class MapQuotedCurrencyPairToObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKeyForQuotedCurrencyPair createObservableKeyForQuotedCurrencyPair;
	@Inject protected MapQuotedCurrencyPairWithLocation mapQuotedCurrencyPairWithLocation;

	/**
	* @param fpmlQuotedCurrencyPair 
	* @param fpmlFixingInformationSource 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair, FxSpotRateSource fpmlFixingInformationSource) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlQuotedCurrencyPair, fpmlFixingInformationSource);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair, FxSpotRateSource fpmlFixingInformationSource);

	public static class MapQuotedCurrencyPairToObservableWithLocationDefault extends MapQuotedCurrencyPairToObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair, FxSpotRateSource fpmlFixingInformationSource) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlQuotedCurrencyPair, fpmlFixingInformationSource);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, QuotedCurrencyPair fpmlQuotedCurrencyPair, FxSpotRateSource fpmlFixingInformationSource) {
			final Observable.ObservableBuilder withMetaArgument = Observable.builder()
				.setIndex(Index.builder()
					.setForeignExchangeRateIndex(ForeignExchangeRateIndex.builder()
						.setIdentifier(Collections.<AssetIdentifier>emptyList())
						.setAssetClass(AssetClassEnum.FOREIGN_EXCHANGE)
						.setQuotedCurrencyPair(mapQuotedCurrencyPairWithLocation.evaluate(fpmlQuotedCurrencyPair))
						.setPrimaryFxSpotRateSource(InformationSource.builder()
							.setSourcePageValue(MapperS.of(fpmlFixingInformationSource).<fpml.consolidated.shared.InformationSource>map("getPrimaryRateSource", fxSpotRateSource -> fxSpotRateSource.getPrimaryRateSource()).<RateSourcePage>map("getRateSourcePage", informationSource -> informationSource.getRateSourcePage()).<String>map("getValue", rateSourcePage -> rateSourcePage.getValue()).get())
							.setSourceProviderValue(null)
							.build())
						.build())
					.build())
				.build() == null ? null : Observable.builder()
				.setIndex(Index.builder()
					.setForeignExchangeRateIndex(ForeignExchangeRateIndex.builder()
						.setIdentifier(Collections.<AssetIdentifier>emptyList())
						.setAssetClass(AssetClassEnum.FOREIGN_EXCHANGE)
						.setQuotedCurrencyPair(mapQuotedCurrencyPairWithLocation.evaluate(fpmlQuotedCurrencyPair))
						.setPrimaryFxSpotRateSource(InformationSource.builder()
							.setSourcePageValue(MapperS.of(fpmlFixingInformationSource).<fpml.consolidated.shared.InformationSource>map("getPrimaryRateSource", fxSpotRateSource -> fxSpotRateSource.getPrimaryRateSource()).<RateSourcePage>map("getRateSourcePage", informationSource -> informationSource.getRateSourcePage()).<String>map("getValue", rateSourcePage -> rateSourcePage.getValue()).get())
							.setSourceProviderValue(null)
							.build())
						.build())
					.build())
				.build().toBuilder();
			observable = toBuilder(FieldWithMetaObservable.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(createObservableKeyForQuotedCurrencyPair.evaluate(fpmlQuotedCurrencyPair))));
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
