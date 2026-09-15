package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.other.functions.MapBusinessDayConventionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessDayAdjustments.MapBusinessDayAdjustmentsDefault.class)
public abstract class MapBusinessDayAdjustments implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterOrBusinessCenterReference mapBusinessCenterOrBusinessCenterReference;
	@Inject protected MapBusinessDayConventionEnum mapBusinessDayConventionEnum;

	/**
	* @param fpmlBusinessDateAdjustments 
	* @return businessDayAdjustments 
	*/
	public BusinessDayAdjustments evaluate(fpml.consolidated.shared.BusinessDayAdjustments fpmlBusinessDateAdjustments) {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustmentsBuilder = doEvaluate(fpmlBusinessDateAdjustments);
		
		final BusinessDayAdjustments businessDayAdjustments;
		if (businessDayAdjustmentsBuilder == null) {
			businessDayAdjustments = null;
		} else {
			businessDayAdjustments = businessDayAdjustmentsBuilder.build();
			objectValidator.validate(BusinessDayAdjustments.class, businessDayAdjustments);
		}
		
		return businessDayAdjustments;
	}

	protected abstract BusinessDayAdjustments.BusinessDayAdjustmentsBuilder doEvaluate(fpml.consolidated.shared.BusinessDayAdjustments fpmlBusinessDateAdjustments);

	public static class MapBusinessDayAdjustmentsDefault extends MapBusinessDayAdjustments {
		@Override
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder doEvaluate(fpml.consolidated.shared.BusinessDayAdjustments fpmlBusinessDateAdjustments) {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustments = BusinessDayAdjustments.builder();
			return assignOutput(businessDayAdjustments, fpmlBusinessDateAdjustments);
		}
		
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder assignOutput(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustments, fpml.consolidated.shared.BusinessDayAdjustments fpmlBusinessDateAdjustments) {
			businessDayAdjustments = toBuilder(BusinessDayAdjustments.builder()
				.setBusinessDayConvention(mapBusinessDayConventionEnum.evaluate(MapperS.of(fpmlBusinessDateAdjustments).<BusinessDayConventionEnum>map("getBusinessDayConvention", _businessDayAdjustments -> _businessDayAdjustments.getBusinessDayConvention()).map("to-string", BusinessDayConventionEnum::toDisplayString).get()))
				.setBusinessCenters(mapBusinessCenterOrBusinessCenterReference.evaluate(MapperS.of(fpmlBusinessDateAdjustments).<BusinessCenters>map("getBusinessCenters", _businessDayAdjustments -> _businessDayAdjustments.getBusinessCenters()).get(), MapperS.of(fpmlBusinessDateAdjustments).<BusinessCentersReference>map("getBusinessCentersReference", _businessDayAdjustments -> _businessDayAdjustments.getBusinessCentersReference()).get()))
				.build());
			
			return Optional.ofNullable(businessDayAdjustments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
