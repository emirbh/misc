package drr.standards.iosco.cde.version1.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.functions.FormatToNonNegativeShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountFormat.NotionalAmountFormatDefault.class)
public abstract class NotionalAmountFormat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToNonNegativeShortFraction5DecimalNumber formatToNonNegativeShortFraction5DecimalNumber;
	@Inject protected NotionalAmount notionalAmount;

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

	public static class NotionalAmountFormatDefault extends NotionalAmountFormat {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal _notionalAmount = null;
			return assignOutput(_notionalAmount, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal _notionalAmount, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			_notionalAmount = formatToNonNegativeShortFraction5DecimalNumber.evaluate(notionalAmount.evaluate(payout, defaultValue));
			
			return _notionalAmount;
		}
	}
}
