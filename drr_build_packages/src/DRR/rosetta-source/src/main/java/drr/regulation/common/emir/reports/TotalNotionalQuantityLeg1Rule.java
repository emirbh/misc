package drr.regulation.common.emir.reports;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.TotalNotionalQuantityLeg1;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TotalNotionalQuantityLeg1Rule.TotalNotionalQuantityLeg1RuleDefault.class)
public abstract class TotalNotionalQuantityLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TotalNotionalQuantityLeg1 totalNotionalQuantityLeg1;
	@Inject protected TradableProductForEvent tradableProductForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class TotalNotionalQuantityLeg1RuleDefault extends TotalNotionalQuantityLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final Boolean _boolean = isProductETD.evaluate(productForEvent.evaluate(thenArg0.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if ((_boolean == null ? false : _boolean)) {
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = MapperS.of(MapperS.of(tradableProductForEvent.evaluate(thenArg0.get())).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
				final MapperC<BigDecimal> thenArg2 = thenArg1
					.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()));
				final MapperS<BigDecimal> thenArg3 = MapperS.of(thenArg2.get());
				ifThenElseResult = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg3.get()));
			} else {
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				ifThenElseResult = MapperS.of(totalNotionalQuantityLeg1.evaluate(thenArg0.get(), (bigInteger == null ? null : new BigDecimal(bigInteger))));
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
