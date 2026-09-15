package drr.projection.iso20022.jfsa.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.TradeReportHeader4__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeReportHeader.Create_TradeReportHeaderDefault.class)
public abstract class Create_TradeReportHeader implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return rptHdr 
	*/
	public TradeReportHeader4__1 evaluate(JFSAValuationReport drrReport) {
		TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdrBuilder = doEvaluate(drrReport);
		
		final TradeReportHeader4__1 rptHdr;
		if (rptHdrBuilder == null) {
			rptHdr = null;
		} else {
			rptHdr = rptHdrBuilder.build();
			objectValidator.validate(TradeReportHeader4__1.class, rptHdr);
		}
		
		return rptHdr;
	}

	protected abstract TradeReportHeader4__1.TradeReportHeader4__1Builder doEvaluate(JFSAValuationReport drrReport);

	public static class Create_TradeReportHeaderDefault extends Create_TradeReportHeader {
		@Override
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder doEvaluate(JFSAValuationReport drrReport) {
			TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr = TradeReportHeader4__1.builder();
			return assignOutput(rptHdr, drrReport);
		}
		
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder assignOutput(TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr, JFSAValuationReport drrReport) {
			rptHdr = toBuilder(TradeReportHeader4__1.builder()
				.setNbRcrds((long) 1)
				.setNewTradRpstryIdr(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(drrReport).<String>map("getNewSDRIdentifier", jFSAValuationReport -> jFSAValuationReport.getNewSDRIdentifier()).get())
					.build())
				.build());
			
			return Optional.ofNullable(rptHdr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
