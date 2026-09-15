package drr.standards.iosco.cde.version1.quantity.reports;

import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Price;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityOptionNotionalRule.CommodityOptionNotionalRuleDefault.class)
public abstract class CommodityOptionNotionalRule implements ReportFunction<OptionPayout, BigDecimal> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(OptionPayout input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(OptionPayout input);

	public static class CommodityOptionNotionalRuleDefault extends CommodityOptionNotionalRule {
		@Override
		protected BigDecimal doEvaluate(OptionPayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, OptionPayout input) {
			if (exists(MapperS.of(input).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue())).getOrDefault(false)) {
				if (exists(MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).getOrDefault(false)) {
					output = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(input).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).get();
				} else if (exists(MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue())).getOrDefault(false)) {
					output = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(input).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())
						.sumBigDecimal()).get();
				} else {
					output = null;
				}
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
