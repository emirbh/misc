package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_DTCC_04")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_DTCC_04.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_DTCC_04 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_DTCC_04";
	String DEFINITION = "(if actionType = NEWT then dtccAdditionalFields -> usiID is absent else True) and (if uniqueTransactionIdentifier is absent then dtccAdditionalFields -> usiID exists else True)";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_DTCC_04 {
	
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
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = notExists(MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<String>map("getUsiID", dTCCAdditionalFields -> dTCCAdditionalFields.getUsiID()));
				} else {
					ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				final ComparisonResult ifThenElseResult1;
				if (notExists(MapperS.of(cSATransactionReport).<String>map("getUniqueTransactionIdentifier", _cSATransactionReport -> _cSATransactionReport.getUniqueTransactionIdentifier())).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<String>map("getUsiID", dTCCAdditionalFields -> dTCCAdditionalFields.getUsiID()));
				} else {
					ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_DTCC_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
