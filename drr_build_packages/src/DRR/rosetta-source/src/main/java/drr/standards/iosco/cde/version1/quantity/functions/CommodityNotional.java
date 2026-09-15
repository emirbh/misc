package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.functions.VectorOperation;
import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityNotional.CommodityNotionalDefault.class)
public abstract class CommodityNotional implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected VectorOperation vectorOperation;

	/**
	* @param quantitySchedule 
	* @param price 
	* @return amount 
	*/
	public BigDecimal evaluate(NonNegativeQuantitySchedule quantitySchedule, PriceSchedule price) {
		BigDecimal amount = doEvaluate(quantitySchedule, price);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(NonNegativeQuantitySchedule quantitySchedule, PriceSchedule price);

	public static class CommodityNotionalDefault extends CommodityNotional {
		@Override
		protected BigDecimal doEvaluate(NonNegativeQuantitySchedule quantitySchedule, PriceSchedule price) {
			BigDecimal amount = null;
			return assignOutput(amount, quantitySchedule, price);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, NonNegativeQuantitySchedule quantitySchedule, PriceSchedule price) {
			if (exists(MapperS.of(price).<DatedValue>mapC("getDatedValue", priceSchedule -> priceSchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())).getOrDefault(false)) {
				amount = MapperC.<BigDecimal>of(vectorOperation.evaluate(ArithmeticOperationEnum.MULTIPLY, MapperS.of(price).<DatedValue>mapC("getDatedValue", priceSchedule -> priceSchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti(), MapperS.of(quantitySchedule).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti()))
					.sumBigDecimal().get();
			} else if (exists(MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).getOrDefault(false)) {
				if (exists(MapperS.of(quantitySchedule).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).getOrDefault(false)) {
					amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(quantitySchedule).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).get();
				} else if (exists(MapperS.of(quantitySchedule).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue())).getOrDefault(false)) {
					amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(quantitySchedule).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())
						.sumBigDecimal()).get();
				} else {
					amount = null;
				}
			} else {
				amount = null;
			}
			
			return amount;
		}
	}
}
