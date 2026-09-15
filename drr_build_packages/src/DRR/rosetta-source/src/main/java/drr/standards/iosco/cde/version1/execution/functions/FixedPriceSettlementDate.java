package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.FixedPricePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(FixedPriceSettlementDate.FixedPriceSettlementDateDefault.class)
public abstract class FixedPriceSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromPaymentDate settlementDateFromPaymentDate;
	@Inject protected SettlementDateFromSchedule settlementDateFromSchedule;

	/**
	* @param fixedPricePayout 
	* @return fixedPriceDate 
	*/
	public List<Date> evaluate(FixedPricePayout fixedPricePayout) {
		List<Date> fixedPriceDate = doEvaluate(fixedPricePayout);
		
		return fixedPriceDate;
	}

	protected abstract List<Date> doEvaluate(FixedPricePayout fixedPricePayout);

	public static class FixedPriceSettlementDateDefault extends FixedPriceSettlementDate {
		@Override
		protected List<Date> doEvaluate(FixedPricePayout fixedPricePayout) {
			List<Date> fixedPriceDate = new ArrayList<>();
			return assignOutput(fixedPriceDate, fixedPricePayout);
		}
		
		protected List<Date> assignOutput(List<Date> fixedPriceDate, FixedPricePayout fixedPricePayout) {
			fixedPriceDate.addAll(settlementDateFromSchedule.evaluate(MapperS.of(fixedPricePayout).<CalculationSchedule>map("getSchedule", _fixedPricePayout -> _fixedPricePayout.getSchedule()).get()));
			
			fixedPriceDate.addAll(settlementDateFromPaymentDate.evaluate(MapperS.of(fixedPricePayout).<PaymentDates>map("getPaymentDates", _fixedPricePayout -> _fixedPricePayout.getPaymentDates()).get()));
			
			return fixedPriceDate;
		}
	}
}
