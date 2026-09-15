package drr.standards.iosco.cde.version3.execution.reports;

import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SettlementTermsRule.SettlementTermsRuleDefault.class)
public abstract class SettlementTermsRule implements ReportFunction<PayoutLegWithAuxiliary, SettlementTerms> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.execution.reports.SettlementTermsRule settlementTermsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SettlementTerms evaluate(PayoutLegWithAuxiliary input) {
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

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementTermsRuleDefault extends SettlementTermsRule {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			SettlementTerms.SettlementTermsBuilder output = SettlementTerms.builder();
			return assignOutput(output, input);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder output, PayoutLegWithAuxiliary input) {
			output = toBuilder(settlementTermsRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
