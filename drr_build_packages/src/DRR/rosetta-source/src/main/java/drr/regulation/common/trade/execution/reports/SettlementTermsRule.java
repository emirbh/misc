package drr.regulation.common.trade.execution.reports;

import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SettlementTermsRule.SettlementTermsRuleDefault.class)
public abstract class SettlementTermsRule implements ReportFunction<TransactionReportInstruction, SettlementTerms> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.SettlementTermsRule settlementTermsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SettlementTerms evaluate(TransactionReportInstruction input) {
		SettlementTerms.SettlementTermsBuilder outputBuilder = doEvaluate(input);
		
		final SettlementTerms output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(SettlementTerms.class, output);
		}
		
		return output;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(TransactionReportInstruction input);

	public static class SettlementTermsRuleDefault extends SettlementTermsRule {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(TransactionReportInstruction input) {
			SettlementTerms.SettlementTermsBuilder output = SettlementTerms.builder();
			return assignOutput(output, input);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder output, TransactionReportInstruction input) {
			output = toBuilder(MapperS.of(settlementTermsRule.evaluate(payoutLeg1Rule.evaluate(input))).getOrDefault(settlementTermsRule.evaluate(payoutLeg2Rule.evaluate(input))));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
