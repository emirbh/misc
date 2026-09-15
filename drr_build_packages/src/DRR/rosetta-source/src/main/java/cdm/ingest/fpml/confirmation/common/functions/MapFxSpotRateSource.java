package cdm.ingest.fpml.confirmation.common.functions;

import cdm.observable.asset.FxSpotRateSource;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.InformationSource;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSpotRateSource.MapFxSpotRateSourceDefault.class)
public abstract class MapFxSpotRateSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInformationSource mapInformationSource;

	/**
	* @param fpmlFxSpotRateSource 
	* @return fxSpotRateSource 
	*/
	public FxSpotRateSource evaluate(fpml.consolidated.shared.FxSpotRateSource fpmlFxSpotRateSource) {
		FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSourceBuilder = doEvaluate(fpmlFxSpotRateSource);
		
		final FxSpotRateSource fxSpotRateSource;
		if (fxSpotRateSourceBuilder == null) {
			fxSpotRateSource = null;
		} else {
			fxSpotRateSource = fxSpotRateSourceBuilder.build();
			objectValidator.validate(FxSpotRateSource.class, fxSpotRateSource);
		}
		
		return fxSpotRateSource;
	}

	protected abstract FxSpotRateSource.FxSpotRateSourceBuilder doEvaluate(fpml.consolidated.shared.FxSpotRateSource fpmlFxSpotRateSource);

	public static class MapFxSpotRateSourceDefault extends MapFxSpotRateSource {
		@Override
		protected FxSpotRateSource.FxSpotRateSourceBuilder doEvaluate(fpml.consolidated.shared.FxSpotRateSource fpmlFxSpotRateSource) {
			FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource = FxSpotRateSource.builder();
			return assignOutput(fxSpotRateSource, fpmlFxSpotRateSource);
		}
		
		protected FxSpotRateSource.FxSpotRateSourceBuilder assignOutput(FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource, fpml.consolidated.shared.FxSpotRateSource fpmlFxSpotRateSource) {
			fxSpotRateSource = toBuilder(FxSpotRateSource.builder()
				.setPrimarySource(mapInformationSource.evaluate(MapperS.of(fpmlFxSpotRateSource).<InformationSource>map("getPrimaryRateSource", _fxSpotRateSource -> _fxSpotRateSource.getPrimaryRateSource()).get()))
				.setSecondarySource(mapInformationSource.evaluate(MapperS.of(fpmlFxSpotRateSource).<InformationSource>map("getSecondaryRateSource", _fxSpotRateSource -> _fxSpotRateSource.getSecondaryRateSource()).get()))
				.build());
			
			return Optional.ofNullable(fxSpotRateSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
