package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenterTime;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenter;
import java.time.LocalTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenterTime.MapBusinessCenterTimeDefault.class)
public abstract class MapBusinessCenterTime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlBusinessCenterTime 
	* @return businessCenterTime 
	*/
	public BusinessCenterTime evaluate(fpml.consolidated.shared.BusinessCenterTime fpmlBusinessCenterTime) {
		BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTimeBuilder = doEvaluate(fpmlBusinessCenterTime);
		
		final BusinessCenterTime businessCenterTime;
		if (businessCenterTimeBuilder == null) {
			businessCenterTime = null;
		} else {
			businessCenterTime = businessCenterTimeBuilder.build();
			objectValidator.validate(BusinessCenterTime.class, businessCenterTime);
		}
		
		return businessCenterTime;
	}

	protected abstract BusinessCenterTime.BusinessCenterTimeBuilder doEvaluate(fpml.consolidated.shared.BusinessCenterTime fpmlBusinessCenterTime);

	public static class MapBusinessCenterTimeDefault extends MapBusinessCenterTime {
		@Override
		protected BusinessCenterTime.BusinessCenterTimeBuilder doEvaluate(fpml.consolidated.shared.BusinessCenterTime fpmlBusinessCenterTime) {
			BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTime = BusinessCenterTime.builder();
			return assignOutput(businessCenterTime, fpmlBusinessCenterTime);
		}
		
		protected BusinessCenterTime.BusinessCenterTimeBuilder assignOutput(BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTime, fpml.consolidated.shared.BusinessCenterTime fpmlBusinessCenterTime) {
			businessCenterTime = toBuilder(BusinessCenterTime.builder()
				.setHourMinuteTime(MapperS.of(fpmlBusinessCenterTime).<LocalTime>map("getHourMinuteTime", _businessCenterTime -> _businessCenterTime.getHourMinuteTime()).get())
				.setBusinessCenterValue(MapperS.of(fpmlBusinessCenterTime).<BusinessCenter>map("getBusinessCenter", _businessCenterTime -> _businessCenterTime.getBusinessCenter()).<String>map("getValue", businessCenter -> businessCenter.getValue()).checkedMap("to-enum", BusinessCenterEnum::fromDisplayName, IllegalArgumentException.class).get())
				.build(), () -> BusinessCenterTime.builder());
			
			businessCenterTime
				.getOrCreateBusinessCenter()
				.getOrCreateMeta().setScheme(MapperS.of(fpmlBusinessCenterTime).<BusinessCenter>map("getBusinessCenter", _businessCenterTime -> _businessCenterTime.getBusinessCenter()).<String>map("getBusinessCenterScheme", businessCenter -> businessCenter.getBusinessCenterScheme()).get());
			
			return Optional.ofNullable(businessCenterTime)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
