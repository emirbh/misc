package drr.base.trade.price.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.UnitType;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.PriceNotationEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotationFromPrice.NotationFromPriceDefault.class)
public abstract class NotationFromPrice implements RosettaFunction {

	/**
	* @param price 
	* @return notation 
	*/
	public PriceNotationEnum evaluate(PriceSchedule price) {
		PriceNotationEnum notation = doEvaluate(price);
		
		return notation;
	}

	protected abstract PriceNotationEnum doEvaluate(PriceSchedule price);

	public static class NotationFromPriceDefault extends NotationFromPrice {
		@Override
		protected PriceNotationEnum doEvaluate(PriceSchedule price) {
			PriceNotationEnum notation = null;
			return assignOutput(notation, price);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum notation, PriceSchedule price) {
			if (exists(MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).orNullSafe(exists(MapperS.of(price).<DatedValue>mapC("getDatedValue", priceSchedule -> priceSchedule.getDatedValue()))).getOrDefault(false)) {
				if (areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(price).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.ADD), CardinalityOperator.All)).getOrDefault(false)) {
					notation = PriceNotationEnum.BASIS;
				} else if (areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VARIANCE), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VOLATILITY), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).andNullSafe(exists(MapperS.of(price).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()))).andNullSafe(areEqual(MapperS.of(price).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()), MapperS.of(price).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()), CardinalityOperator.All))).orNullSafe(areEqual(MapperS.of(price).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), MapperS.of(PriceExpressionEnum.PERCENTAGE_OF_NOTIONAL), CardinalityOperator.All)).getOrDefault(false)) {
					notation = PriceNotationEnum.PERCENTAGE;
				} else if (areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All)).orNullSafe(exists(MapperS.of(price).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).orNullSafe(areEqual(MapperS.of(price).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), MapperS.of(PriceExpressionEnum.ABSOLUTE_TERMS), CardinalityOperator.All))).getOrDefault(false)) {
					notation = PriceNotationEnum.MONETARY;
				} else {
					notation = PriceNotationEnum.DECIMAL;
				}
			} else {
				notation = null;
			}
			
			return notation;
		}
	}
}
