package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DTCC_ProductGradeRule.DTCC_ProductGradeRuleDefault.class)
public abstract class DTCC_ProductGradeRule implements ReportFunction<TransactionReportInstruction, List<? extends ProductGradeReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_ProductGradeRule dTCC_ProductGradeRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends ProductGradeReport> evaluate(TransactionReportInstruction input) {
		List<ProductGradeReport.ProductGradeReportBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends ProductGradeReport> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(ProductGradeReport::build).collect(Collectors.toList());
			objectValidator.validate(ProductGradeReport.class, output);
		}
		
		return output;
	}

	protected abstract List<ProductGradeReport.ProductGradeReportBuilder> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_ProductGradeRuleDefault extends DTCC_ProductGradeRule {
		@Override
		protected List<ProductGradeReport.ProductGradeReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<ProductGradeReport.ProductGradeReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ProductGradeReport.ProductGradeReportBuilder> assignOutput(List<ProductGradeReport.ProductGradeReportBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToList(item -> MapperC.<ProductGradeReport>of(dTCC_ProductGradeRule.evaluate(item.get()))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
