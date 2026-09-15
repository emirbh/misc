package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodity;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg1;
import drr.standards.iosco.cde.version3.quantity.functions.TotalNotionalQuantity;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(TotalNotionalQuantityLeg1Rule.TotalNotionalQuantityLeg1RuleDefault.class)
public abstract class TotalNotionalQuantityLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCommodity isCommodity;
	@Inject protected IsEquity isEquity;
	@Inject protected PayoutLeg1 payoutLeg1;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TotalNotionalQuantity totalNotionalQuantity;

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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForEvent.evaluate(thenArg.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodity.evaluate(productForEvent.evaluate(thenArg.get()))))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(totalNotionalQuantity.evaluate(payoutLeg1.evaluate(thenArg.get()), new BigDecimal("99999999999999999999.99999")));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
