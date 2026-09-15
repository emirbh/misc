package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DTCC_UnderlyingAssetReportRule.DTCC_UnderlyingAssetReportRuleDefault.class)
public abstract class DTCC_UnderlyingAssetReportRule implements ReportFunction<TransactionReportInstruction, List<? extends UnderlyingAssetReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_UnderlyingAssetReportRule dTCC_UnderlyingAssetReportRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends UnderlyingAssetReport> evaluate(TransactionReportInstruction input) {
		List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends UnderlyingAssetReport> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(UnderlyingAssetReport::build).collect(Collectors.toList());
			objectValidator.validate(UnderlyingAssetReport.class, output);
		}
		
		return output;
	}

	protected abstract List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_UnderlyingAssetReportRuleDefault extends DTCC_UnderlyingAssetReportRule {
		@Override
		protected List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> assignOutput(List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = toBuilder(MapperC.<UnderlyingAssetReport>of(dTCC_UnderlyingAssetReportRule.evaluate(thenArg.get())).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
