package drr.regulation.common.functions;

import cdm.base.datetime.functions.Today;
import cdm.event.common.Reset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetLastFloatingReferenceResetDate.GetLastFloatingReferenceResetDateDefault.class)
public abstract class GetLastFloatingReferenceResetDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Today today;

	/**
	* @param resetHistory 
	* @return lastFloatingReferenceResetDate 
	*/
	public Date evaluate(List<? extends Reset> resetHistory) {
		Date lastFloatingReferenceResetDate = doEvaluate(resetHistory);
		
		return lastFloatingReferenceResetDate;
	}

	protected abstract Date doEvaluate(List<? extends Reset> resetHistory);

	public static class GetLastFloatingReferenceResetDateDefault extends GetLastFloatingReferenceResetDate {
		@Override
		protected Date doEvaluate(List<? extends Reset> resetHistory) {
			if (resetHistory == null) {
				resetHistory = Collections.emptyList();
			}
			Date lastFloatingReferenceResetDate = null;
			return assignOutput(lastFloatingReferenceResetDate, resetHistory);
		}
		
		protected Date assignOutput(Date lastFloatingReferenceResetDate, List<? extends Reset> resetHistory) {
			final MapperC<Reset> thenArg0 = MapperC.<Reset>of(resetHistory)
				.filterItemNullSafe(item -> lessThanEquals(item.<Date>map("getResetDate", reset -> reset.getResetDate()), MapperS.of(today.evaluate()), CardinalityOperator.All).get());
			final MapperC<Date> thenArg1 = thenArg0.<Date>map("getResetDate", reset -> reset.getResetDate());
			lastFloatingReferenceResetDate = thenArg1
				.max().get();
			
			return lastFloatingReferenceResetDate;
		}
	}
}
