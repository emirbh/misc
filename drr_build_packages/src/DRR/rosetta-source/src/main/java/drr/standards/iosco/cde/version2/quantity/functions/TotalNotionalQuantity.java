package drr.standards.iosco.cde.version2.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(TotalNotionalQuantity.TotalNotionalQuantityDefault.class)
public abstract class TotalNotionalQuantity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.functions.TotalNotionalQuantity totalNotionalQuantity;

	/**
	* @param payout 
	* @param defaultValue 
	* @return totalTotalNotionalQuantity 
	*/
	public BigDecimal evaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
		BigDecimal totalTotalNotionalQuantity = doEvaluate(payout, defaultValue);
		
		return totalTotalNotionalQuantity;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue);

	public static class TotalNotionalQuantityDefault extends TotalNotionalQuantity {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal totalTotalNotionalQuantity = null;
			return assignOutput(totalTotalNotionalQuantity, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal totalTotalNotionalQuantity, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			totalTotalNotionalQuantity = totalNotionalQuantity.evaluate(payout, defaultValue);
			
			return totalTotalNotionalQuantity;
		}
	}
}
