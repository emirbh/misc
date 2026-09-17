package cdm.ingest.fpml.confirmation.common.functions;

import cdm.product.template.FxFeature;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.Composite;
import fpml.consolidated.option.shared.Quanto;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxFeature.MapFxFeatureDefault.class)
public abstract class MapFxFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapComposite mapComposite;
	@Inject protected MapQuanto mapQuanto;
	@Inject protected MapReferenceCurrency mapReferenceCurrency;

	/**
	* @param fpmlFxFeature 
	* @return fxFeature 
	*/
	public FxFeature evaluate(fpml.consolidated.option.shared.FxFeature fpmlFxFeature) {
		FxFeature.FxFeatureBuilder fxFeatureBuilder = doEvaluate(fpmlFxFeature);
		
		final FxFeature fxFeature;
		if (fxFeatureBuilder == null) {
			fxFeature = null;
		} else {
			fxFeature = fxFeatureBuilder.build();
			objectValidator.validate(FxFeature.class, fxFeature);
		}
		
		return fxFeature;
	}

	protected abstract FxFeature.FxFeatureBuilder doEvaluate(fpml.consolidated.option.shared.FxFeature fpmlFxFeature);

	public static class MapFxFeatureDefault extends MapFxFeature {
		@Override
		protected FxFeature.FxFeatureBuilder doEvaluate(fpml.consolidated.option.shared.FxFeature fpmlFxFeature) {
			FxFeature.FxFeatureBuilder fxFeature = FxFeature.builder();
			return assignOutput(fxFeature, fpmlFxFeature);
		}
		
		protected FxFeature.FxFeatureBuilder assignOutput(FxFeature.FxFeatureBuilder fxFeature, fpml.consolidated.option.shared.FxFeature fpmlFxFeature) {
			fxFeature = toBuilder(FxFeature.builder()
				.setReferenceCurrency(mapReferenceCurrency.evaluate(MapperS.of(fpmlFxFeature).<IdentifiedCurrency>map("getReferenceCurrency", _fxFeature -> _fxFeature.getReferenceCurrency()).get()))
				.setComposite(mapComposite.evaluate(MapperS.of(fpmlFxFeature).<Composite>map("getComposite", _fxFeature -> _fxFeature.getComposite()).get()))
				.setQuanto(mapQuanto.evaluate(MapperS.of(fpmlFxFeature).<Quanto>map("getQuanto", _fxFeature -> _fxFeature.getQuanto()).get()))
				.setCrossCurrency(mapComposite.evaluate(MapperS.of(fpmlFxFeature).<Composite>map("getCrossCurrency", _fxFeature -> _fxFeature.getCrossCurrency()).get()))
				.build());
			
			return Optional.ofNullable(fxFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
