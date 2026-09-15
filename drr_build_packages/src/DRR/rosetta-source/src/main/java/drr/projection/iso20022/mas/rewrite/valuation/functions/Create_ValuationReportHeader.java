package drr.projection.iso20022.mas.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.mas.TradeReportHeader4__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ValuationReportHeader.Create_ValuationReportHeaderDefault.class)
public abstract class Create_ValuationReportHeader implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @return rptHdr 
	*/
	public TradeReportHeader4__1 evaluate() {
		TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdrBuilder = doEvaluate();
		
		final TradeReportHeader4__1 rptHdr;
		if (rptHdrBuilder == null) {
			rptHdr = null;
		} else {
			rptHdr = rptHdrBuilder.build();
			objectValidator.validate(TradeReportHeader4__1.class, rptHdr);
		}
		
		return rptHdr;
	}

	protected abstract TradeReportHeader4__1.TradeReportHeader4__1Builder doEvaluate();

	public static class Create_ValuationReportHeaderDefault extends Create_ValuationReportHeader {
		@Override
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder doEvaluate() {
			TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr = TradeReportHeader4__1.builder();
			return assignOutput(rptHdr);
		}
		
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder assignOutput(TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr) {
			rptHdr = toBuilder(TradeReportHeader4__1.builder()
				.setNbRcrds((long) 1)
				.build());
			
			return Optional.ofNullable(rptHdr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
