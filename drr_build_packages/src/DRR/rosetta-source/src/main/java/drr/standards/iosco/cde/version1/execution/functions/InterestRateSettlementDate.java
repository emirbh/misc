package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(InterestRateSettlementDate.InterestRateSettlementDateDefault.class)
public abstract class InterestRateSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromCalculationPeriodDates settlementDateFromCalculationPeriodDates;
	@Inject protected SettlementDateFromPaymentDate settlementDateFromPaymentDate;

	/**
	* @param interestRatePayout 
	* @return interestRateDate 
	*/
	public List<Date> evaluate(InterestRatePayout interestRatePayout) {
		List<Date> interestRateDate = doEvaluate(interestRatePayout);
		
		return interestRateDate;
	}

	protected abstract List<Date> doEvaluate(InterestRatePayout interestRatePayout);

	public static class InterestRateSettlementDateDefault extends InterestRateSettlementDate {
		@Override
		protected List<Date> doEvaluate(InterestRatePayout interestRatePayout) {
			List<Date> interestRateDate = new ArrayList<>();
			return assignOutput(interestRateDate, interestRatePayout);
		}
		
		protected List<Date> assignOutput(List<Date> interestRateDate, InterestRatePayout interestRatePayout) {
			interestRateDate.addAll(settlementDateFromPaymentDate.evaluate(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).get()));
			
			interestRateDate.addAll(settlementDateFromCalculationPeriodDates.evaluate(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).get()));
			
			return interestRateDate;
		}
	}
}
