package drr.regulation.esma.emir.refit.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(IsCollateralReportableRule.IsCollateralReportableRuleDefault.class)
public abstract class IsCollateralReportableRule implements ReportFunction<CollateralReportInstruction, CollateralReportInstruction> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected HasCollateralRule hasCollateralRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CollateralReportInstruction evaluate(CollateralReportInstruction input) {
		CollateralReportInstruction.CollateralReportInstructionBuilder outputBuilder = doEvaluate(input);
		
		final CollateralReportInstruction output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CollateralReportInstruction.class, output);
		}
		
		return output;
	}

	protected abstract CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(CollateralReportInstruction input);

	public static class IsCollateralReportableRuleDefault extends IsCollateralReportableRule {
		@Override
		protected CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(CollateralReportInstruction input) {
			CollateralReportInstruction.CollateralReportInstructionBuilder output = CollateralReportInstruction.builder();
			return assignOutput(output, input);
		}
		
		protected CollateralReportInstruction.CollateralReportInstructionBuilder assignOutput(CollateralReportInstruction.CollateralReportInstructionBuilder output, CollateralReportInstruction input) {
			output = toBuilder(MapperS.of(input)
				.filterSingleNullSafe(item -> hasCollateralRule.evaluate(item.get())).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
