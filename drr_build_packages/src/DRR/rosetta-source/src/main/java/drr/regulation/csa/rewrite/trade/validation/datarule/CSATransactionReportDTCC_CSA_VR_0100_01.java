package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_0100_01")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_0100_01.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_0100_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_0100_01";
	String DEFINITION = "if actionType = NEWT and eventType = TRAD then amendmentIndicator <> True";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_0100_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), MapperS.of(EventTypeEnum.TRAD), CardinalityOperator.All)).getOrDefault(false)) {
					return notEqual(MapperS.of(cSATransactionReport).<Boolean>map("getAmendmentIndicator", _cSATransactionReport -> _cSATransactionReport.getAmendmentIndicator()), MapperS.of(true), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_0100_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
