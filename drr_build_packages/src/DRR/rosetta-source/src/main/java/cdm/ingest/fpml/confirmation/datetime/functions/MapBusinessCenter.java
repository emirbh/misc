package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapBusinessCenterEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.BusinessCenter;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenter.MapBusinessCenterDefault.class)
public abstract class MapBusinessCenter implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterEnum mapBusinessCenterEnum;

	/**
	* @param fpmlBusinessCenter 
	* @return businessCenter 
	*/
	public FieldWithMetaBusinessCenterEnum evaluate(BusinessCenter fpmlBusinessCenter) {
		FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder businessCenterBuilder = doEvaluate(fpmlBusinessCenter);
		
		final FieldWithMetaBusinessCenterEnum businessCenter;
		if (businessCenterBuilder == null) {
			businessCenter = null;
		} else {
			businessCenter = businessCenterBuilder.build();
			objectValidator.validate(FieldWithMetaBusinessCenterEnum.class, businessCenter);
		}
		
		return businessCenter;
	}

	protected abstract FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder doEvaluate(BusinessCenter fpmlBusinessCenter);

	public static class MapBusinessCenterDefault extends MapBusinessCenter {
		@Override
		protected FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder doEvaluate(BusinessCenter fpmlBusinessCenter) {
			FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder businessCenter = FieldWithMetaBusinessCenterEnum.builder();
			return assignOutput(businessCenter, fpmlBusinessCenter);
		}
		
		protected FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder assignOutput(FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder businessCenter, BusinessCenter fpmlBusinessCenter) {
			final BusinessCenterEnum withMetaArgument = mapBusinessCenterEnum.evaluate(MapperS.of(fpmlBusinessCenter).<String>map("getValue", _businessCenter -> _businessCenter.getValue()).get());
			businessCenter = toBuilder(FieldWithMetaBusinessCenterEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlBusinessCenter).<String>map("getBusinessCenterScheme", _businessCenter -> _businessCenter.getBusinessCenterScheme()).get())));
			
			return Optional.ofNullable(businessCenter)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
