package cdm.ingest.fpml.confirmation.common.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.template.Composite;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapComposite.MapCompositeDefault.class)
public abstract class MapComposite implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlComposite 
	* @return composite 
	*/
	public Composite evaluate(fpml.consolidated.option.shared.Composite fpmlComposite) {
		Composite.CompositeBuilder compositeBuilder = doEvaluate(fpmlComposite);
		
		final Composite composite;
		if (compositeBuilder == null) {
			composite = null;
		} else {
			composite = compositeBuilder.build();
			objectValidator.validate(Composite.class, composite);
		}
		
		return composite;
	}

	protected abstract Composite.CompositeBuilder doEvaluate(fpml.consolidated.option.shared.Composite fpmlComposite);

	public static class MapCompositeDefault extends MapComposite {
		@Override
		protected Composite.CompositeBuilder doEvaluate(fpml.consolidated.option.shared.Composite fpmlComposite) {
			Composite.CompositeBuilder composite = Composite.builder();
			return assignOutput(composite, fpmlComposite);
		}
		
		protected Composite.CompositeBuilder assignOutput(Composite.CompositeBuilder composite, fpml.consolidated.option.shared.Composite fpmlComposite) {
			composite = toBuilder(Composite.builder()
				.setDeterminationMethod(MapperS.of(fpmlComposite).<DeterminationMethod>map("getDeterminationMethod", _composite -> _composite.getDeterminationMethod()).<String>map("getValue", determinationMethod -> determinationMethod.getValue()).checkedMap("to-enum", DeterminationMethodEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setRelativeDate(mapRelativeDateOffset.evaluate(MapperS.of(fpmlComposite).<RelativeDateOffset>map("getRelativeDate", _composite -> _composite.getRelativeDate()).get()))
				.setFxSpotRateSource(mapFxSpotRateSource.evaluate(MapperS.of(fpmlComposite).<FxSpotRateSource>map("getFxSpotRateSource", _composite -> _composite.getFxSpotRateSource()).get()))
				.setFixingTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlComposite).<FxSpotRateSource>map("getFxSpotRateSource", _composite -> _composite.getFxSpotRateSource()).<BusinessCenterTime>map("getFixingTime", fxSpotRateSource -> fxSpotRateSource.getFixingTime()).get()))
				.build());
			
			return Optional.ofNullable(composite)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
