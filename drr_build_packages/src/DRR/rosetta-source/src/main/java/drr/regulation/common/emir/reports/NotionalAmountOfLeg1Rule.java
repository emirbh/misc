package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.standards.iosco.cde.version3.quantity.functions.NotionalAmountFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountOfLeg1Rule.NotionalAmountOfLeg1RuleDefault.class)
public abstract class NotionalAmountOfLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected NotionalAmountFormat notionalAmountFormat;
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;

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

	public static class NotionalAmountOfLeg1RuleDefault extends NotionalAmountOfLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
					return MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg1Rule.evaluate(item.get()), (bigInteger == null ? null : new BigDecimal(bigInteger))));
				}).get();
			
			return output;
		}
	}
}
