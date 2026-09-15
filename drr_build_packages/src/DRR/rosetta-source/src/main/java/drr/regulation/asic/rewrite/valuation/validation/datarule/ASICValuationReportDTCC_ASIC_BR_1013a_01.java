package drr.regulation.asic.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICValuationReportDTCC_ASIC_BR_1013a_01")
@ImplementedBy(ASICValuationReportDTCC_ASIC_BR_1013a_01.Default.class)
public interface ASICValuationReportDTCC_ASIC_BR_1013a_01 extends Validator<ASICValuationReport> {
	
	String NAME = "ASICValuationReportDTCC_ASIC_BR_1013a_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> TERM, ActionTypeEnum -> PRTO, ActionTypeEnum -> VALU] any = actionType then if executionAgentOfTheCounterparty1 = \"NOAP\" then executionAgentOfTheCounterparty2 exists";
	
	class Default implements ASICValuationReportDTCC_ASIC_BR_1013a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			ComparisonResult result = executeDataRule(aSICValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICValuationReport aSICValuationReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(aSICValuationReport).<ActionTypeEnum>map("getActionType", _aSICValuationReport -> _aSICValuationReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICValuationReport).<String>map("getExecutionAgentOfTheCounterparty1", _aSICValuationReport -> _aSICValuationReport.getExecutionAgentOfTheCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(aSICValuationReport).<String>map("getExecutionAgentOfTheCounterparty2", _aSICValuationReport -> _aSICValuationReport.getExecutionAgentOfTheCounterparty2()));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICValuationReportDTCC_ASIC_BR_1013a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			return Collections.emptyList();
		}
	}
}
