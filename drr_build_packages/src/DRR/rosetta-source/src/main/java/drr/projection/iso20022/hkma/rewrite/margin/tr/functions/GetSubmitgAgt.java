package drr.projection.iso20022.hkma.rewrite.margin.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import iso20022.auth108.hkma.tr.OrganisationIdentification15Choice__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetSubmitgAgt.GetSubmitgAgtDefault.class)
public abstract class GetSubmitgAgt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;

	/**
	* @param marginReport 
	* @return submitgAgt 
	*/
	public OrganisationIdentification15Choice__3 evaluate(HKMAMarginReport marginReport) {
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder submitgAgtBuilder = doEvaluate(marginReport);
		
		final OrganisationIdentification15Choice__3 submitgAgt;
		if (submitgAgtBuilder == null) {
			submitgAgt = null;
		} else {
			submitgAgt = submitgAgtBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__3.class, submitgAgt);
		}
		
		return submitgAgt;
	}

	protected abstract OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(HKMAMarginReport marginReport);

	public static class GetSubmitgAgtDefault extends GetSubmitgAgt {
		@Override
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(HKMAMarginReport marginReport) {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder submitgAgt = OrganisationIdentification15Choice__3.builder();
			return assignOutput(submitgAgt, marginReport);
		}
		
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder assignOutput(OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder submitgAgt, HKMAMarginReport marginReport) {
			submitgAgt = toBuilder(create_OrganisationIdentification15Choice__3.evaluate(MapperS.of(marginReport).<String>map("getReportSubmittingEntityID", hKMAMarginReport -> hKMAMarginReport.getReportSubmittingEntityID()).get()));
			
			return Optional.ofNullable(submitgAgt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
