package drr.regulation.common.trade.quantity.reports;

import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.regulation.common.trade.quantity.functions.CommodityQuantityWithFrequency;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityRule.NotionalQuantityRuleDefault.class)
public abstract class NotionalQuantityRule implements ReportFunction<PayoutLegWithAuxiliary, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityQuantityWithFrequency commodityQuantityWithFrequency;
	@Inject protected EquityNotionalQuantityRule equityNotionalQuantityRule;
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(PayoutLegWithAuxiliary input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary input);

	public static class NotionalQuantityRuleDefault extends NotionalQuantityRule {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, PayoutLegWithAuxiliary input) {
			final MapperS<NonNegativeQuantitySchedule> thenArg0 = MapperS.of(commodityQuantityWithFrequency.evaluate(input));
			final MapperS<BigDecimal> thenArg1 = MapperS.of(MapperS.of(equityNotionalQuantityRule.evaluate(input)).getOrDefault(MapperS.of(thenArg0.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).getOrDefault(thenArg0.<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())
				.first().get())).get()));
			output = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
