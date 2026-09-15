package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.OrganisationIdentification15Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetNttyRspnsblForRpt.GetNttyRspnsblForRptDefault.class)
public abstract class GetNttyRspnsblForRpt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return nttyRspnsblForRpt 
	*/
	public OrganisationIdentification15Choice__1 evaluate(ESMAValuationReport drrReport) {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder nttyRspnsblForRptBuilder = doEvaluate(drrReport);
		
		final OrganisationIdentification15Choice__1 nttyRspnsblForRpt;
		if (nttyRspnsblForRptBuilder == null) {
			nttyRspnsblForRpt = null;
		} else {
			nttyRspnsblForRpt = nttyRspnsblForRptBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__1.class, nttyRspnsblForRpt);
		}
		
		return nttyRspnsblForRpt;
	}

	protected abstract OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(ESMAValuationReport drrReport);

	public static class GetNttyRspnsblForRptDefault extends GetNttyRspnsblForRpt {
		@Override
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(ESMAValuationReport drrReport) {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder nttyRspnsblForRpt = OrganisationIdentification15Choice__1.builder();
			return assignOutput(nttyRspnsblForRpt, drrReport);
		}
		
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder assignOutput(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder nttyRspnsblForRpt, ESMAValuationReport drrReport) {
			nttyRspnsblForRpt = toBuilder(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getEntityResponsibleForReporting", eSMAValuationReport -> eSMAValuationReport.getEntityResponsibleForReporting()).get()));
			
			return Optional.ofNullable(nttyRspnsblForRpt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
