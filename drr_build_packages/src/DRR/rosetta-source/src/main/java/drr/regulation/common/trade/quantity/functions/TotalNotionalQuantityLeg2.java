package drr.regulation.common.trade.quantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version3.quantity.functions.TotalNotionalQuantity;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TotalNotionalQuantityLeg2.TotalNotionalQuantityLeg2Default.class)
public abstract class TotalNotionalQuantityLeg2 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsEquity isEquity;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TotalNotionalQuantity totalNotionalQuantity;

	/**
	* @param transaction 
	* @param defaultValue 
	* @return _totalNotionalQuantity 
	*/
	public BigDecimal evaluate(TransactionReportInstruction transaction, BigDecimal defaultValue) {
		BigDecimal _totalNotionalQuantity = doEvaluate(transaction, defaultValue);
		
		return _totalNotionalQuantity;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction transaction, BigDecimal defaultValue);

	public static class TotalNotionalQuantityLeg2Default extends TotalNotionalQuantityLeg2 {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction transaction, BigDecimal defaultValue) {
			BigDecimal _totalNotionalQuantity = null;
			return assignOutput(_totalNotionalQuantity, transaction, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal _totalNotionalQuantity, TransactionReportInstruction transaction, BigDecimal defaultValue) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(productForEvent.evaluate(transaction));
			final MapperS<BigDecimal> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(thenArg.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(thenArg.get()))).andNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(thenArg.get())).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(totalNotionalQuantity.evaluate(payoutLeg2Rule.evaluate(transaction), defaultValue));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			_totalNotionalQuantity = ifThenElseResult.get();
			
			return _totalNotionalQuantity;
		}
	}
}
