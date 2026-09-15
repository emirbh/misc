package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.CalculationSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(CommoditySettlementDate.CommoditySettlementDateDefault.class)
public abstract class CommoditySettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromCalculationPeriodDates settlementDateFromCalculationPeriodDates;
	@Inject protected SettlementDateFromPaymentDate settlementDateFromPaymentDate;
	@Inject protected SettlementDateFromSchedule settlementDateFromSchedule;

	/**
	* @param commodityPayout 
	* @return commodityDate 
	*/
	public List<Date> evaluate(CommodityPayout commodityPayout) {
		List<Date> commodityDate = doEvaluate(commodityPayout);
		
		return commodityDate;
	}

	protected abstract List<Date> doEvaluate(CommodityPayout commodityPayout);

	public static class CommoditySettlementDateDefault extends CommoditySettlementDate {
		@Override
		protected List<Date> doEvaluate(CommodityPayout commodityPayout) {
			List<Date> commodityDate = new ArrayList<>();
			return assignOutput(commodityDate, commodityPayout);
		}
		
		protected List<Date> assignOutput(List<Date> commodityDate, CommodityPayout commodityPayout) {
			commodityDate.addAll(settlementDateFromPaymentDate.evaluate(MapperS.of(commodityPayout).<PaymentDates>map("getPaymentDates", _commodityPayout -> _commodityPayout.getPaymentDates()).get()));
			
			commodityDate.addAll(settlementDateFromCalculationPeriodDates.evaluate(MapperS.of(commodityPayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _commodityPayout -> _commodityPayout.getCalculationPeriodDates()).get()));
			
			commodityDate.addAll(settlementDateFromSchedule.evaluate(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).get()));
			
			return commodityDate;
		}
	}
}
