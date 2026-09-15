package drr.regulation.common.trade.quantity.functions;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodity;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version3.quantity.functions.TotalNotionalQuantity;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(TotalNotionalQuantityLeg1.TotalNotionalQuantityLeg1Default.class)
public abstract class TotalNotionalQuantityLeg1 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCommodity isCommodity;
	@Inject protected IsEquity isEquity;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
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

	public static class TotalNotionalQuantityLeg1Default extends TotalNotionalQuantityLeg1 {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction transaction, BigDecimal defaultValue) {
			BigDecimal _totalNotionalQuantity = null;
			return assignOutput(_totalNotionalQuantity, transaction, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal _totalNotionalQuantity, TransactionReportInstruction transaction, BigDecimal defaultValue) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(productForEvent.evaluate(transaction));
			final MapperS<BigDecimal> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(thenArg.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodity.evaluate(thenArg.get())))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(totalNotionalQuantity.evaluate(payoutLeg1Rule.evaluate(transaction), defaultValue));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			_totalNotionalQuantity = ifThenElseResult.get();
			
			return _totalNotionalQuantity;
		}
	}
}
