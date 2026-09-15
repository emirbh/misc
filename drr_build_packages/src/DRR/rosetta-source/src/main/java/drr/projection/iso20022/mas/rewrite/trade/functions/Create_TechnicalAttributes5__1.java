package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.TechnicalAttributes5__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TechnicalAttributes5__1.Create_TechnicalAttributes5__1Default.class)
public abstract class Create_TechnicalAttributes5__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return techAttrbts 
	*/
	public TechnicalAttributes5__1 evaluate(MASTransactionReport drrReport) {
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbtsBuilder = doEvaluate(drrReport);
		
		final TechnicalAttributes5__1 techAttrbts;
		if (techAttrbtsBuilder == null) {
			techAttrbts = null;
		} else {
			techAttrbts = techAttrbtsBuilder.build();
			objectValidator.validate(TechnicalAttributes5__1.class, techAttrbts);
		}
		
		return techAttrbts;
	}

	protected abstract TechnicalAttributes5__1.TechnicalAttributes5__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_TechnicalAttributes5__1Default extends Create_TechnicalAttributes5__1 {
		@Override
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder doEvaluate(MASTransactionReport drrReport) {
			TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts = TechnicalAttributes5__1.builder();
			return assignOutput(techAttrbts, drrReport);
		}
		
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder assignOutput(TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts, MASTransactionReport drrReport) {
			techAttrbts = toBuilder(TechnicalAttributes5__1.builder()
				.setTechRcrdId(MapperS.of(drrReport).<String>map("getTechnicalRecordId", mASTransactionReport -> mASTransactionReport.getTechnicalRecordId()).get())
				.setRptRctTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", mASTransactionReport -> mASTransactionReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(techAttrbts)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
