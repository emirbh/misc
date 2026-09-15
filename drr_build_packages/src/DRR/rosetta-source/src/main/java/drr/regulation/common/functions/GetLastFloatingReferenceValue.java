package drr.regulation.common.functions;

import cdm.base.datetime.functions.Today;
import cdm.event.common.Reset;
import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetLastFloatingReferenceValue.GetLastFloatingReferenceValueDefault.class)
public abstract class GetLastFloatingReferenceValue implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Today today;

	/**
	* @param resetHistory 
	* @return lastFloatingReferenceValue 
	*/
	public BigDecimal evaluate(List<? extends Reset> resetHistory) {
		BigDecimal lastFloatingReferenceValue = doEvaluate(resetHistory);
		
		return lastFloatingReferenceValue;
	}

	protected abstract BigDecimal doEvaluate(List<? extends Reset> resetHistory);

	public static class GetLastFloatingReferenceValueDefault extends GetLastFloatingReferenceValue {
		@Override
		protected BigDecimal doEvaluate(List<? extends Reset> resetHistory) {
			if (resetHistory == null) {
				resetHistory = Collections.emptyList();
			}
			BigDecimal lastFloatingReferenceValue = null;
			return assignOutput(lastFloatingReferenceValue, resetHistory);
		}
		
		protected BigDecimal assignOutput(BigDecimal lastFloatingReferenceValue, List<? extends Reset> resetHistory) {
			final MapperC<Reset> thenArg0 = MapperC.<Reset>of(resetHistory)
				.filterItemNullSafe(item -> lessThanEquals(item.<Date>map("getResetDate", reset -> reset.getResetDate()), MapperS.of(today.evaluate()), CardinalityOperator.All).get());
			final MapperS<Reset> thenArg1 = thenArg0
				.max(item -> item.<Date>map("getResetDate", reset -> reset.getResetDate()));
			lastFloatingReferenceValue = thenArg1.<Price>map("getResetValue", reset -> reset.getResetValue()).<BigDecimal>map("getValue", price -> price.getValue()).get();
			
			return lastFloatingReferenceValue;
		}
	}
}
