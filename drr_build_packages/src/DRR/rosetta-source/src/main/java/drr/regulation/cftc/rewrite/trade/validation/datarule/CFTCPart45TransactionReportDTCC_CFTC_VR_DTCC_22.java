package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22")
@ImplementedBy(CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22.Default.class)
public interface CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22 extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22";
	String DEFINITION = "if dtccAdditionalFields -> otherPaymentReceiverIDType exists then dtccAdditionalFields -> otherPaymentPayerIDType exists and dtccAdditionalFields -> otherPaymentPayerIDType count = dtccAdditionalFields -> otherPaymentReceiverIDType count";
	
	class Default implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (exists(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType())).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType())).andNullSafe(areEqual(MapperS.of(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType()).resultCount()), MapperS.of(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType()).resultCount()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_22 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
