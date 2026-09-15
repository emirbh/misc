package drr.projection.iso20022.hkma.rewrite.valuation.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import iso20022.auth030.hkma.dtcc.TechnicalAttributes5__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TechnicalAttributes5__1.Create_TechnicalAttributes5__1Default.class)
public abstract class Create_TechnicalAttributes5__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return techAttrbts 
	*/
	public TechnicalAttributes5__1 evaluate(HKMAValuationReport drrReport) {
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

	protected abstract TechnicalAttributes5__1.TechnicalAttributes5__1Builder doEvaluate(HKMAValuationReport drrReport);

	public static class Create_TechnicalAttributes5__1Default extends Create_TechnicalAttributes5__1 {
		@Override
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder doEvaluate(HKMAValuationReport drrReport) {
			TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts = TechnicalAttributes5__1.builder();
			return assignOutput(techAttrbts, drrReport);
		}
		
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder assignOutput(TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts, HKMAValuationReport drrReport) {
			techAttrbts = toBuilder(TechnicalAttributes5__1.builder()
				.setTechRcrdId(MapperS.of(drrReport).<String>map("getTechnicalRecordId", hKMAValuationReport -> hKMAValuationReport.getTechnicalRecordId()).get())
				.build());
			
			return Optional.ofNullable(techAttrbts)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
