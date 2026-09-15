package drr.standards.iosco.cde.version2.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountFormat.NotionalAmountFormatDefault.class)
public abstract class NotionalAmountFormat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.functions.NotionalAmountFormat notionalAmountFormat;

	/**
	* @param payout 
	* @param defaultValue 
	* @return notionalAmount 
	*/
	public BigDecimal evaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
		BigDecimal notionalAmount = doEvaluate(payout, defaultValue);
		
		return notionalAmount;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue);

	public static class NotionalAmountFormatDefault extends NotionalAmountFormat {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal notionalAmount = null;
			return assignOutput(notionalAmount, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal notionalAmount, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			notionalAmount = notionalAmountFormat.evaluate(payout, defaultValue);
			
			return notionalAmount;
		}
	}
}
