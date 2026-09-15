package drr.regulation.common.emir.contract.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.functions.GetVenueOfExecution;
import drr.standards.iso.MicData;
import drr.standards.iso.functions.GetOrFetchMicData;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetMicDataForFacility.GetMicDataForFacilityDefault.class)
public abstract class GetMicDataForFacility implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchMicData getOrFetchMicData;
	@Inject protected GetVenueOfExecution getVenueOfExecution;

	/**
	* @param reportableInformation 
	* @return micData 
	*/
	public MicData evaluate(ReportableInformation reportableInformation) {
		MicData.MicDataBuilder micDataBuilder = doEvaluate(reportableInformation);
		
		final MicData micData;
		if (micDataBuilder == null) {
			micData = null;
		} else {
			micData = micDataBuilder.build();
			objectValidator.validate(MicData.class, micData);
		}
		
		return micData;
	}

	protected abstract MicData.MicDataBuilder doEvaluate(ReportableInformation reportableInformation);

	protected abstract MapperS<String> executionFacility(ReportableInformation reportableInformation);

	public static class GetMicDataForFacilityDefault extends GetMicDataForFacility {
		@Override
		protected MicData.MicDataBuilder doEvaluate(ReportableInformation reportableInformation) {
			MicData.MicDataBuilder micData = MicData.builder();
			return assignOutput(micData, reportableInformation);
		}
		
		protected MicData.MicDataBuilder assignOutput(MicData.MicDataBuilder micData, ReportableInformation reportableInformation) {
			micData = toBuilder(getOrFetchMicData.evaluate(MapperS.of(reportableInformation).<EnrichmentData>map("getEnrichment", _reportableInformation -> _reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), executionFacility(reportableInformation).get()));
			
			return Optional.ofNullable(micData)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> executionFacility(ReportableInformation reportableInformation) {
			return MapperS.of(getVenueOfExecution.evaluate(reportableInformation));
		}
	}
}
