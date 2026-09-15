package drr.regulation.asic.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_0013_02")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_0013_02.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_0013_02 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_0013_02";
	String DEFINITION = "if [MarginActionEnum -> CORR, MarginActionEnum -> MARU] any = actionType then executionAgentOfCounterparty1 <> counterparty1 or executionAgentOfCounterparty1 <> counterparty2 or executionAgentOfCounterparty1 <> reportingEntity";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_0013_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			ComparisonResult result = executeDataRule(aSICMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICMarginReport aSICMarginReport) {
			try {
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.CORR), MapperS.of(MarginActionEnum.MARU)), MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return notEqual(MapperS.of(aSICMarginReport).<String>map("getExecutionAgentOfCounterparty1", _aSICMarginReport -> _aSICMarginReport.getExecutionAgentOfCounterparty1()), MapperS.of(aSICMarginReport).<String>map("getCounterparty1", _aSICMarginReport -> _aSICMarginReport.getCounterparty1()), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(aSICMarginReport).<String>map("getExecutionAgentOfCounterparty1", _aSICMarginReport -> _aSICMarginReport.getExecutionAgentOfCounterparty1()), MapperS.of(aSICMarginReport).<String>map("getCounterparty2", _aSICMarginReport -> _aSICMarginReport.getCounterparty2()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(aSICMarginReport).<String>map("getExecutionAgentOfCounterparty1", _aSICMarginReport -> _aSICMarginReport.getExecutionAgentOfCounterparty1()), MapperS.of(aSICMarginReport).<String>map("getReportingEntity", _aSICMarginReport -> _aSICMarginReport.getReportingEntity()), CardinalityOperator.Any));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_0013_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}
