package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.OrganisationIdentification15Choice__1;
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
	public OrganisationIdentification15Choice__1 evaluate(FCAValuationReport drrReport) {
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

	protected abstract OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(FCAValuationReport drrReport);

	public static class GetSubmitgAgtDefault extends GetSubmitgAgt {
		@Override
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(FCAValuationReport drrReport) {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt = OrganisationIdentification15Choice__1.builder();
			return assignOutput(submitgAgt, drrReport);
		}
		
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder assignOutput(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt, FCAValuationReport drrReport) {
			submitgAgt = toBuilder(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", fCAValuationReport -> fCAValuationReport.getReportSubmittingEntityID()).get()));
			
			return Optional.ofNullable(submitgAgt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
