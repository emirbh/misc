package drr.projection.iso20022.jfsa.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetSubmitgAgt.GetSubmitgAgtDefault.class)
public abstract class GetSubmitgAgt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return submitgAgt 
	*/
	public OrganisationIdentification15Choice__1 evaluate(JFSAValuationReport drrReport) {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgtBuilder = doEvaluate(drrReport);
		
		final OrganisationIdentification15Choice__1 submitgAgt;
		if (submitgAgtBuilder == null) {
			submitgAgt = null;
		} else {
			submitgAgt = submitgAgtBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__1.class, submitgAgt);
		}
		
		return submitgAgt;
	}

	protected abstract OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(JFSAValuationReport drrReport);

	public static class GetSubmitgAgtDefault extends GetSubmitgAgt {
		@Override
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(JFSAValuationReport drrReport) {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt = OrganisationIdentification15Choice__1.builder();
			return assignOutput(submitgAgt, drrReport);
		}
		
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder assignOutput(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt, JFSAValuationReport drrReport) {
			submitgAgt = toBuilder(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", jFSAValuationReport -> jFSAValuationReport.getReportSubmittingEntityID()).get()));
			
			return Optional.ofNullable(submitgAgt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
