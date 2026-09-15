package cdm.ingest.fpml.confirmation.common.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.product.template.Quanto;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.FxSpotRateSource;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuanto.MapQuantoDefault.class)
public abstract class MapQuanto implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxRate mapFxRate;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;

	/**
	* @param fpmlQuanto 
	* @return quanto 
	*/
	public Quanto evaluate(fpml.consolidated.option.shared.Quanto fpmlQuanto) {
		Quanto.QuantoBuilder quantoBuilder = doEvaluate(fpmlQuanto);
		
		final Quanto quanto;
		if (quantoBuilder == null) {
			quanto = null;
		} else {
			quanto = quantoBuilder.build();
			objectValidator.validate(Quanto.class, quanto);
		}
		
		return quanto;
	}

	protected abstract Quanto.QuantoBuilder doEvaluate(fpml.consolidated.option.shared.Quanto fpmlQuanto);

	public static class MapQuantoDefault extends MapQuanto {
		@Override
		protected Quanto.QuantoBuilder doEvaluate(fpml.consolidated.option.shared.Quanto fpmlQuanto) {
			Quanto.QuantoBuilder quanto = Quanto.builder();
			return assignOutput(quanto, fpmlQuanto);
		}
		
		protected Quanto.QuantoBuilder assignOutput(Quanto.QuantoBuilder quanto, fpml.consolidated.option.shared.Quanto fpmlQuanto) {
			quanto = toBuilder(Quanto.builder()
				.setFxRate(MapperS.of(fpmlQuanto).<FxRate>mapC("getFxRate", _quanto -> _quanto.getFxRate())
					.mapItem(item -> MapperS.of(mapFxRate.evaluate(item.get()))).getMulti())
				.setFxSpotRateSource(mapFxSpotRateSource.evaluate(MapperS.of(fpmlQuanto).<FxSpotRateSource>map("getFxSpotRateSource", _quanto -> _quanto.getFxSpotRateSource()).get()))
				.setFixingTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlQuanto).<FxSpotRateSource>map("getFxSpotRateSource", _quanto -> _quanto.getFxSpotRateSource()).<BusinessCenterTime>map("getFixingTime", fxSpotRateSource -> fxSpotRateSource.getFixingTime()).get()))
				.build());
			
			return Optional.ofNullable(quanto)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
