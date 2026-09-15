package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(PerformanceSettlementDate.PerformanceSettlementDateDefault.class)
public abstract class PerformanceSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromObservationTerms settlementDateFromObservationTerms;
	@Inject protected SettlementDateFromPaymentDate settlementDateFromPaymentDate;

	/**
	* @param performancePayout 
	* @return performanceDate 
	*/
	public List<Date> evaluate(PerformancePayout performancePayout) {
		List<Date> performanceDate = doEvaluate(performancePayout);
		
		return performanceDate;
	}

	protected abstract List<Date> doEvaluate(PerformancePayout performancePayout);

	public static class PerformanceSettlementDateDefault extends PerformanceSettlementDate {
		@Override
		protected List<Date> doEvaluate(PerformancePayout performancePayout) {
			List<Date> performanceDate = new ArrayList<>();
			return assignOutput(performanceDate, performancePayout);
		}
		
		protected List<Date> assignOutput(List<Date> performanceDate, PerformancePayout performancePayout) {
			performanceDate.addAll(settlementDateFromPaymentDate.evaluate(MapperS.of(performancePayout).<PaymentDates>map("getPaymentDates", _performancePayout -> _performancePayout.getPaymentDates()).get()));
			
			performanceDate.addAll(settlementDateFromObservationTerms.evaluate(MapperS.of(performancePayout).<ObservationTerms>map("getObservationTerms", _performancePayout -> _performancePayout.getObservationTerms()).get()));
			
			return performanceDate;
		}
	}
}
