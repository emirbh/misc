package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ReportableProductRule.ReportableProductRuleDefault.class)
public abstract class ReportableProductRule implements ReportFunction<TransactionReportInstruction, TransactionReportInstruction> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected HasContractRule hasContractRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public TransactionReportInstruction evaluate(TransactionReportInstruction input) {
		TransactionReportInstruction.TransactionReportInstructionBuilder outputBuilder = doEvaluate(input);
		
		final TransactionReportInstruction output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, output);
		}
		
		return output;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(TransactionReportInstruction input);

	public static class ReportableProductRuleDefault extends ReportableProductRule {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(TransactionReportInstruction input) {
			TransactionReportInstruction.TransactionReportInstructionBuilder output = TransactionReportInstruction.builder();
			return assignOutput(output, input);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder output, TransactionReportInstruction input) {
			output = toBuilder(MapperS.of(input)
				.filterSingleNullSafe(item -> hasContractRule.evaluate(item.get())).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
