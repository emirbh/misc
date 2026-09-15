package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetSubmitgAgt.GetSubmitgAgtDefault.class)
public abstract class GetSubmitgAgt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__4 create_OrganisationIdentification15Choice__4;

	/**
	* @param drrReport 
	* @return submitgAgt 
	*/
	public OrganisationIdentification15Choice__4 evaluate(HKMATransactionReport drrReport) {
		OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder submitgAgtBuilder = doEvaluate(drrReport);
		
		final OrganisationIdentification15Choice__4 submitgAgt;
		if (submitgAgtBuilder == null) {
			submitgAgt = null;
		} else {
			submitgAgt = submitgAgtBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__4.class, submitgAgt);
		}
		
		return submitgAgt;
	}

	protected abstract OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetSubmitgAgtDefault extends GetSubmitgAgt {
		@Override
		protected OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder doEvaluate(HKMATransactionReport drrReport) {
			OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder submitgAgt = OrganisationIdentification15Choice__4.builder();
			return assignOutput(submitgAgt, drrReport);
		}
		
		protected OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder assignOutput(OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder submitgAgt, HKMATransactionReport drrReport) {
			submitgAgt = toBuilder(create_OrganisationIdentification15Choice__4.evaluate(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", hKMATransactionReport -> hKMATransactionReport.getReportSubmittingEntityID()).get()));
			
			return Optional.ofNullable(submitgAgt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
