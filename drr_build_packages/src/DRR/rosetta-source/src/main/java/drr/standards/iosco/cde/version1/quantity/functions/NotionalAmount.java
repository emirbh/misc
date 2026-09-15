package drr.standards.iosco.cde.version1.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmount.NotionalAmountDefault.class)
public abstract class NotionalAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Notional notional;

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

	public static class NotionalAmountDefault extends NotionalAmount {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal notionalAmount = null;
			return assignOutput(notionalAmount, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal notionalAmount, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			notionalAmount = MapperS.of(payout)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(notional.evaluate(item.get())).<BigDecimal>map("getValue", measure -> measure.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(areEqual(item.<Boolean>map("getZeroNotionalAmountDefaulting", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getZeroNotionalAmountDefaulting()), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(defaultValue);
					}
					return MapperS.of(notional.evaluate(item.get())).<BigDecimal>map("getValue", measure -> measure.getValue());
				}).get();
			
			return notionalAmount;
		}
	}
}
