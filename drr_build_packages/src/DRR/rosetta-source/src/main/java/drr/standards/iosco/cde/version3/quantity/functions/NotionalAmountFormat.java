package drr.standards.iosco.cde.version3.quantity.functions;

import cdm.product.asset.CommodityPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.functions.FormatToNonNegativeShortFraction5DecimalNumber;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountFormat.NotionalAmountFormatDefault.class)
public abstract class NotionalAmountFormat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToNonNegativeShortFraction5DecimalNumber formatToNonNegativeShortFraction5DecimalNumber;
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
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
			if (exists(MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout())).getOrDefault(false)) {
				_notionalAmount = formatToShortFraction5DecimalNumber.evaluate(notionalAmount.evaluate(payout, defaultValue));
			} else {
				_notionalAmount = formatToNonNegativeShortFraction5DecimalNumber.evaluate(notionalAmount.evaluate(payout, defaultValue));
			}
			
			return _notionalAmount;
		}
	}
}
