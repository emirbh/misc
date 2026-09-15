package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(API_AnnaDsbRetrieveUpi.API_AnnaDsbRetrieveUpiDefault.class)
public abstract class API_AnnaDsbRetrieveUpi implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param request 
	* @return response 
	*/
	public AnnaDsbUpiRecord evaluate(AnnaDsbUpiRequest request) {
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder responseBuilder = doEvaluate(request);
		
		final AnnaDsbUpiRecord response;
		if (responseBuilder == null) {
			response = null;
		} else {
			response = responseBuilder.build();
			objectValidator.validate(AnnaDsbUpiRecord.class, response);
		}
		
		return response;
	}

	protected abstract AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder doEvaluate(AnnaDsbUpiRequest request);

	public static class API_AnnaDsbRetrieveUpiDefault extends API_AnnaDsbRetrieveUpi {
		@Override
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder doEvaluate(AnnaDsbUpiRequest request) {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder response = AnnaDsbUpiRecord.builder();
			return assignOutput(response, request);
		}
		
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder assignOutput(AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder response, AnnaDsbUpiRequest request) {
			return Optional.ofNullable(response)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
