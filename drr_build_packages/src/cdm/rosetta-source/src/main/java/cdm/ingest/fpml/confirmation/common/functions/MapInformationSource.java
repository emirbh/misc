package cdm.ingest.fpml.confirmation.common.functions;

import cdm.observable.asset.InformationProviderEnum;
import cdm.observable.asset.InformationSource;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.InformationProvider;
import fpml.consolidated.shared.RateSourcePage;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInformationSource.MapInformationSourceDefault.class)
public abstract class MapInformationSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlInformationSource 
	* @return informationSource 
	*/
	public InformationSource evaluate(fpml.consolidated.shared.InformationSource fpmlInformationSource) {
		InformationSource.InformationSourceBuilder informationSourceBuilder = doEvaluate(fpmlInformationSource);
		
		final InformationSource informationSource;
		if (informationSourceBuilder == null) {
			informationSource = null;
		} else {
			informationSource = informationSourceBuilder.build();
			objectValidator.validate(InformationSource.class, informationSource);
		}
		
		return informationSource;
	}

	protected abstract InformationSource.InformationSourceBuilder doEvaluate(fpml.consolidated.shared.InformationSource fpmlInformationSource);

	public static class MapInformationSourceDefault extends MapInformationSource {
		@Override
		protected InformationSource.InformationSourceBuilder doEvaluate(fpml.consolidated.shared.InformationSource fpmlInformationSource) {
			InformationSource.InformationSourceBuilder informationSource = InformationSource.builder();
			return assignOutput(informationSource, fpmlInformationSource);
		}
		
		protected InformationSource.InformationSourceBuilder assignOutput(InformationSource.InformationSourceBuilder informationSource, fpml.consolidated.shared.InformationSource fpmlInformationSource) {
			informationSource = toBuilder(InformationSource.builder()
				.setSourceProviderValue(MapperS.of(fpmlInformationSource).<InformationProvider>map("getRateSource", _informationSource -> _informationSource.getRateSource()).<String>map("getValue", informationProvider -> informationProvider.getValue()).checkedMap("to-enum", InformationProviderEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setSourcePage(mapStringWithScheme.evaluate(MapperS.of(fpmlInformationSource).<RateSourcePage>map("getRateSourcePage", _informationSource -> _informationSource.getRateSourcePage()).<String>map("getValue", rateSourcePage -> rateSourcePage.getValue()).get(), MapperS.of(fpmlInformationSource).<RateSourcePage>map("getRateSourcePage", _informationSource -> _informationSource.getRateSourcePage()).<String>map("getRateSourcePageScheme", rateSourcePage -> rateSourcePage.getRateSourcePageScheme()).get()))
				.setSourcePageHeading(MapperS.of(fpmlInformationSource).<String>map("getRateSourcePageHeading", _informationSource -> _informationSource.getRateSourcePageHeading()).get())
				.build());
			
			return Optional.ofNullable(informationSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
