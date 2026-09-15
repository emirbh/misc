package drr.regulation.jfsa.rewrite.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MarginAmount_Validation.MarginAmount_ValidationDefault.class)
public abstract class MarginAmount_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param collateralisationCategory 
	* @param amount 
	* @param collateralisationCategories 
	* @return result 
	*/
	public Boolean evaluate(MarginActionEnum actionType, CollateralisationType3Code collateralisationCategory, BigDecimal amount, List<CollateralisationType3Code> collateralisationCategories) {
		Boolean result = doEvaluate(actionType, collateralisationCategory, amount, collateralisationCategories);
		
		return result;
	}

	protected abstract Boolean doEvaluate(MarginActionEnum actionType, CollateralisationType3Code collateralisationCategory, BigDecimal amount, List<CollateralisationType3Code> collateralisationCategories);

	public static class MarginAmount_ValidationDefault extends MarginAmount_Validation {
		@Override
		protected Boolean doEvaluate(MarginActionEnum actionType, CollateralisationType3Code collateralisationCategory, BigDecimal amount, List<CollateralisationType3Code> collateralisationCategories) {
			if (collateralisationCategories == null) {
				collateralisationCategories = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, collateralisationCategory, amount, collateralisationCategories);
		}
		
		protected Boolean assignOutput(Boolean result, MarginActionEnum actionType, CollateralisationType3Code collateralisationCategory, BigDecimal amount, List<CollateralisationType3Code> collateralisationCategories) {
			if (areEqual(MapperS.of(actionType), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<CollateralisationType3Code>of(collateralisationCategories), MapperS.of(collateralisationCategory), CardinalityOperator.Any)).getOrDefault(false)) {
				result = exists(MapperS.of(amount)).andNullSafe(greaterThanEquals(MapperS.of(amount), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
