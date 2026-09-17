package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenter;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenters.MapBusinessCentersDefault.class)
public abstract class MapBusinessCenters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenter mapBusinessCenter;

	/**
	* @param fpmlBusinessCenters 
	* @return businessCenters 
	*/
	public BusinessCenters evaluate(fpml.consolidated.shared.BusinessCenters fpmlBusinessCenters) {
		BusinessCenters.BusinessCentersBuilder businessCentersBuilder = doEvaluate(fpmlBusinessCenters);
		
		final BusinessCenters businessCenters;
		if (businessCentersBuilder == null) {
			businessCenters = null;
		} else {
			businessCenters = businessCentersBuilder.build();
			objectValidator.validate(BusinessCenters.class, businessCenters);
		}
		
		return businessCenters;
	}

	protected abstract BusinessCenters.BusinessCentersBuilder doEvaluate(fpml.consolidated.shared.BusinessCenters fpmlBusinessCenters);

	public static class MapBusinessCentersDefault extends MapBusinessCenters {
		@Override
		protected BusinessCenters.BusinessCentersBuilder doEvaluate(fpml.consolidated.shared.BusinessCenters fpmlBusinessCenters) {
			BusinessCenters.BusinessCentersBuilder businessCenters = BusinessCenters.builder();
			return assignOutput(businessCenters, fpmlBusinessCenters);
		}
		
		protected BusinessCenters.BusinessCentersBuilder assignOutput(BusinessCenters.BusinessCentersBuilder businessCenters, fpml.consolidated.shared.BusinessCenters fpmlBusinessCenters) {
			final BusinessCenters.BusinessCentersBuilder withMetaArgument = BusinessCenters.builder()
				.setBusinessCenter(MapperS.of(fpmlBusinessCenters).<BusinessCenter>mapC("getBusinessCenter", _businessCenters -> _businessCenters.getBusinessCenter())
					.mapItem(item -> MapperS.of(mapBusinessCenter.evaluate(item.get()))).getMulti())
				.build() == null ? null : BusinessCenters.builder()
				.setBusinessCenter(MapperS.of(fpmlBusinessCenters).<BusinessCenter>mapC("getBusinessCenter", _businessCenters -> _businessCenters.getBusinessCenter())
					.mapItem(item -> MapperS.of(mapBusinessCenter.evaluate(item.get()))).getMulti())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlBusinessCenters).<String>map("getId", _businessCenters -> _businessCenters.getId()).get());
			businessCenters = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(businessCenters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
