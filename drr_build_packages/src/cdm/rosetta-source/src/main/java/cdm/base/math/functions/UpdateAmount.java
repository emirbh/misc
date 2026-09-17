package cdm.base.math.functions;

import cdm.base.math.QuantityChangeDirectionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;


@ImplementedBy(UpdateAmount.UpdateAmountDefault.class)
public abstract class UpdateAmount implements RosettaFunction {

	/**
	* @param oldAmount 
	* @param changeAmount 
	* @param direction 
	* @return newAmount 
	*/
	public BigDecimal evaluate(BigDecimal oldAmount, BigDecimal changeAmount, QuantityChangeDirectionEnum direction) {
		BigDecimal newAmount = doEvaluate(oldAmount, changeAmount, direction);
		
		return newAmount;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal oldAmount, BigDecimal changeAmount, QuantityChangeDirectionEnum direction);

	public static class UpdateAmountDefault extends UpdateAmount {
		@Override
		protected BigDecimal doEvaluate(BigDecimal oldAmount, BigDecimal changeAmount, QuantityChangeDirectionEnum direction) {
			BigDecimal newAmount = null;
			return assignOutput(newAmount, oldAmount, changeAmount, direction);
		}
		
		protected BigDecimal assignOutput(BigDecimal newAmount, BigDecimal oldAmount, BigDecimal changeAmount, QuantityChangeDirectionEnum direction) {
			if (direction == null) {
				newAmount = null;
			} else if (direction == QuantityChangeDirectionEnum.INCREASE) {
				newAmount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperS.of(oldAmount), MapperS.of(changeAmount)).get();
			} else if (direction == QuantityChangeDirectionEnum.DECREASE) {
				newAmount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(oldAmount), MapperS.of(changeAmount)).get();
			} else if (direction == QuantityChangeDirectionEnum.REPLACE) {
				newAmount = changeAmount;
			} else {
				newAmount = null;
			}
			
			return newAmount;
		}
	}
}
