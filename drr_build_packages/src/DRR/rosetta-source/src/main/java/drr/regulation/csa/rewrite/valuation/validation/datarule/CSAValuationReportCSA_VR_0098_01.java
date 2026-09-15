package drr.regulation.csa.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSAValuationReportCSA_VR_0098_01")
@ImplementedBy(CSAValuationReportCSA_VR_0098_01.Default.class)
public interface CSAValuationReportCSA_VR_0098_01 extends Validator<CSAValuationReport> {
	
	String NAME = "CSAValuationReportCSA_VR_0098_01";
	String DEFINITION = "actionType = VALU";
	
	class Default implements CSAValuationReportCSA_VR_0098_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport cSAValuationReport) {
			ComparisonResult result = executeDataRule(cSAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAValuationReport cSAValuationReport) {
			try {
				return areEqual(MapperS.of(cSAValuationReport).<ActionTypeEnum>map("getActionType", _cSAValuationReport -> _cSAValuationReport.getActionType()), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAValuationReportCSA_VR_0098_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport cSAValuationReport) {
			return Collections.emptyList();
		}
	}
}
