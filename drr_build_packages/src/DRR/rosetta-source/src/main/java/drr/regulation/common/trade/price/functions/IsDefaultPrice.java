package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsEquityOther;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.reports.PriceValueRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsDefaultPrice.IsDefaultPriceDefault.class)
public abstract class IsDefaultPrice implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsEquityOther isEquityOther;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected PriceValueRule priceValueRule;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param transaction 
	* @return isDefaultPrice 
	*/
	public Boolean evaluate(TransactionReportInstruction transaction) {
		Boolean isDefaultPrice = doEvaluate(transaction);
		
		return isDefaultPrice;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transaction);

	public static class IsDefaultPriceDefault extends IsDefaultPrice {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transaction) {
			Boolean isDefaultPrice = null;
			return assignOutput(isDefaultPrice, transaction);
		}
		
		protected Boolean assignOutput(Boolean isDefaultPrice, TransactionReportInstruction transaction) {
			isDefaultPrice = ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(productForEvent.evaluate(transaction)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(productForEvent.evaluate(transaction))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquityOther.evaluate(productForEvent.evaluate(transaction)))).andNullSafe(notExists(MapperS.of(priceValueRule.evaluate(transaction))))).get();
			
			return isDefaultPrice;
		}
	}
}
