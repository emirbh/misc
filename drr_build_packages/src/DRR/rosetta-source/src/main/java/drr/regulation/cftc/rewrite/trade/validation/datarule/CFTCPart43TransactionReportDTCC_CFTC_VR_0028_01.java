package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01")
@ImplementedBy(CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01.Default.class)
public interface CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01 extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01";
	String DEFINITION = "if actionType = NEWT and eventType = TRAD then amendmentIndicator <> True";
	
	class Default implements CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getEventType()), MapperS.of(EventTypeEnum.TRAD), CardinalityOperator.All)).getOrDefault(false)) {
					return notEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getAmendmentIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getAmendmentIndicator()), MapperS.of(true), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
