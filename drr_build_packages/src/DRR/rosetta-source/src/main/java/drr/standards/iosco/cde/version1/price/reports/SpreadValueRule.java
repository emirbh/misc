package drr.standards.iosco.cde.version1.price.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(SpreadValueRule.SpreadValueRuleDefault.class)
public abstract class SpreadValueRule implements ReportFunction<PayoutLegWithAuxiliary, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected SpreadRule spreadRule;

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

	public static class SpreadValueRuleDefault extends SpreadValueRule {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, PayoutLegWithAuxiliary input) {
			final PriceSchedule priceSchedule = spreadRule.evaluate(input);
			final MapperS<ReferenceWithMetaPriceSchedule> thenArg = priceSchedule == null ? MapperS.<ReferenceWithMetaPriceSchedule>ofNull() : MapperS.of(ReferenceWithMetaPriceSchedule.builder().setValue(priceSchedule).build());
			output = thenArg.<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", _priceSchedule -> _priceSchedule.getValue()).get();
			
			return output;
		}
	}
}
