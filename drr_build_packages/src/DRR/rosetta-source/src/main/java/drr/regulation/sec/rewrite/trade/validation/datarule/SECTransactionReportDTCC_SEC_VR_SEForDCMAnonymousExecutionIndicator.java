package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
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
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator";
	String DEFINITION = "if actionType = TERM and ([EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType) and centralCounterparty exists then dtccAdditionalFields -> sefOrDcmAnonymousExecutionIndicator exists";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator {
	
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
				if (areEqual(MapperS.of(sECTransactionReport).<ActionTypeEnum>map("getActionType", _sECTransactionReport -> _sECTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(sECTransactionReport).<EventTypeEnum>map("getEventType", _sECTransactionReport -> _sECTransactionReport.getEventType()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(sECTransactionReport).<String>map("getCentralCounterparty", _sECTransactionReport -> _sECTransactionReport.getCentralCounterparty()))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSefOrDcmAnonymousExecutionIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getSefOrDcmAnonymousExecutionIndicator()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
