package drr.standards.iosco.cde.version3.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalAmount.NotionalAmountDefault.class)
public abstract class NotionalAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.quantity.functions.NotionalAmount notionalAmount;

	/**
	* @param payout 
	* @param defaultValue 
	* @return _notionalAmount 
	*/
	public BigDecimal evaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
		BigDecimal _notionalAmount = doEvaluate(payout, defaultValue);
		
		return _notionalAmount;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue);

	public static class NotionalAmountDefault extends NotionalAmount {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal _notionalAmount = null;
			return assignOutput(_notionalAmount, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal _notionalAmount, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			_notionalAmount = notionalAmount.evaluate(payout, defaultValue);
			
			return _notionalAmount;
		}
	}
}
