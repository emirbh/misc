package drr.projection.dtcc.rds.harmonized.csa.rewrite.valuation.functions;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import iso20022.dtcc.rds.harmonized.Header;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHeader.Create_SubmissionHeaderDefault.class)
public abstract class Create_SubmissionHeader implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Now now;

	/**
	* @param drrReport 
	* @return header 
	*/
	public Header evaluate(CSAValuationReport drrReport) {
		Header.HeaderBuilder headerBuilder = doEvaluate(drrReport);
		
		final Header header;
		if (headerBuilder == null) {
			header = null;
		} else {
			header = headerBuilder.build();
			objectValidator.validate(Header.class, header);
		}
		
		return header;
	}

	protected abstract Header.HeaderBuilder doEvaluate(CSAValuationReport drrReport);

	public static class Create_SubmissionHeaderDefault extends Create_SubmissionHeader {
		@Override
		protected Header.HeaderBuilder doEvaluate(CSAValuationReport drrReport) {
			Header.HeaderBuilder header = Header.builder();
			return assignOutput(header, drrReport);
		}
		
		protected Header.HeaderBuilder assignOutput(Header.HeaderBuilder header, CSAValuationReport drrReport) {
			header = toBuilder(Header.builder()
				.setSender(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", cSAValuationReport -> cSAValuationReport.getReportSubmittingEntityID()).get())
				.setDocumentTrackingId(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cSAValuationReport -> cSAValuationReport.getDtccValuationFields()).<String>map("getMessageID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getMessageID()).get())
				.setDocumentCreationTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", cSAValuationReport -> cSAValuationReport.getReportingTimestamp()).getOrDefault(now.evaluate()))
				.build());
			
			return Optional.ofNullable(header)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
