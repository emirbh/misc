package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI";
	String DEFINITION = "if actionType = MODI and eventType = TRAD then dtccAdditionalFields -> corporateActionNewTradeParty1Lei exists";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (areEqual(MapperS.of(sECTransactionReport).<ActionTypeEnum>map("getActionType", _sECTransactionReport -> _sECTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<EventTypeEnum>map("getEventType", _sECTransactionReport -> _sECTransactionReport.getEventType()), MapperS.of(EventTypeEnum.TRAD), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<String>map("getCorporateActionNewTradeParty1Lei", dTCCAdditionalFields -> dTCCAdditionalFields.getCorporateActionNewTradeParty1Lei()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
