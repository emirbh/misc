package drr.base.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceNotationEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotationStringFromEnum.NotationStringFromEnumDefault.class)
public abstract class NotationStringFromEnum implements RosettaFunction {

	/**
	* @param notationEnum 
	* @return notationString 
	*/
	public String evaluate(PriceNotationEnum notationEnum) {
		String notationString = doEvaluate(notationEnum);
		
		return notationString;
	}

	protected abstract String doEvaluate(PriceNotationEnum notationEnum);

	public static class NotationStringFromEnumDefault extends NotationStringFromEnum {
		@Override
		protected String doEvaluate(PriceNotationEnum notationEnum) {
			String notationString = null;
			return assignOutput(notationString, notationEnum);
		}
		
		protected String assignOutput(String notationString, PriceNotationEnum notationEnum) {
			if (areEqual(MapperS.of(notationEnum), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				notationString = "1";
			} else if (areEqual(MapperS.of(notationEnum), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				notationString = "2";
			} else if (areEqual(MapperS.of(notationEnum), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				notationString = "3";
			} else if (areEqual(MapperS.of(notationEnum), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
				notationString = "4";
			} else {
				notationString = null;
			}
			
			return notationString;
		}
	}
}
