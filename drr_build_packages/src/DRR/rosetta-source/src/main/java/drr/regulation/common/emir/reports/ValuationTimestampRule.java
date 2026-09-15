package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePOSC;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.regulation.common.TransactionReportInstruction;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ValuationTimestampRule.ValuationTimestampRuleDefault.class)
public abstract class ValuationTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.ValuationTimestampRule valuationTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstruction input);

	public static class ValuationTimestampRuleDefault extends ValuationTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeVALU.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePOSC.evaluate(item.get())))).get());
			output = MapperS.of(valuationTimestampRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
