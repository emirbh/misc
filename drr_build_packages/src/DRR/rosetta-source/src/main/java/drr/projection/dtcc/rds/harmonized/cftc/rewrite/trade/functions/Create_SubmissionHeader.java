package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
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
	public Header evaluate(CFTCTransactionReport drrReport) {
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

	protected abstract Header.HeaderBuilder doEvaluate(CFTCTransactionReport drrReport);

	public static class Create_SubmissionHeaderDefault extends Create_SubmissionHeader {
		@Override
		protected Header.HeaderBuilder doEvaluate(CFTCTransactionReport drrReport) {
			Header.HeaderBuilder header = Header.builder();
			return assignOutput(header, drrReport);
		}
		
		protected Header.HeaderBuilder assignOutput(Header.HeaderBuilder header, CFTCTransactionReport drrReport) {
			header = toBuilder(Header.builder()
				.setSender(MapperS.of(drrReport).<String>map("getCounterparty1", cFTCTransactionReport -> cFTCTransactionReport.getCounterparty1()).get())
				.setDocumentTrackingId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getMessageID", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageID()).get())
				.setDocumentCreationTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", cFTCTransactionReport -> cFTCTransactionReport.getReportingTimestamp()).getOrDefault(now.evaluate()))
				.build());
			
			return Optional.ofNullable(header)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
