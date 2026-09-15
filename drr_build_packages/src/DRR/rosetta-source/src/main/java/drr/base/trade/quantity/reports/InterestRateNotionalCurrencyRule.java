package drr.base.trade.quantity.reports;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateNotionalCurrencyRule.InterestRateNotionalCurrencyRuleDefault.class)
public abstract class InterestRateNotionalCurrencyRule implements ReportFunction<InterestRatePayout, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(InterestRatePayout input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(InterestRatePayout input);

	public static class InterestRateNotionalCurrencyRuleDefault extends InterestRateNotionalCurrencyRule {
		@Override
		protected String doEvaluate(InterestRatePayout input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, InterestRatePayout input) {
			if (exists(MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				if (fieldWithMetaString0 == null) {
					output = null;
				} else {
					output = fieldWithMetaString0.getValue();
				}
			} else if (exists(MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference())).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString1 = MapperS.of(input).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference()).<ResolvablePriceQuantity>map("Type coercion", referenceWithMetaResolvablePriceQuantity -> referenceWithMetaResolvablePriceQuantity == null ? null : referenceWithMetaResolvablePriceQuantity.getValue()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				if (fieldWithMetaString1 == null) {
					output = null;
				} else {
					output = fieldWithMetaString1.getValue();
				}
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
