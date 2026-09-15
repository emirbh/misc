package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination";
	String DEFINITION = "if dtccAdditionalFields -> tradeParty1ReportingDestination exists then [SupervisoryBodyEnum -> CFTC, SupervisoryBodyEnum -> SEC, SupervisoryBodyEnum -> CA_AB_ASC, SupervisoryBodyEnum -> CA_BC_BCSC, SupervisoryBodyEnum -> CA_MB_MSC, SupervisoryBodyEnum -> CA_NB_FCSC, SupervisoryBodyEnum -> CA_NL_DSS, SupervisoryBodyEnum -> CA_NS_NSSC, SupervisoryBodyEnum -> CA_NT_NTSO, SupervisoryBodyEnum -> CA_NU_NSO, SupervisoryBodyEnum -> CA_ON_OSC, SupervisoryBodyEnum -> CA_PEI_OSS, SupervisoryBodyEnum -> CA_QC_AMF, SupervisoryBodyEnum -> CA_SK_FCAA, SupervisoryBodyEnum -> CA_YT_OSS] contains dtccAdditionalFields -> tradeParty1ReportingDestination";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination {
	
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
				if (exists(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination())).getOrDefault(false)) {
					return contains(MapperC.<SupervisoryBodyEnum>of(MapperS.of(SupervisoryBodyEnum.CFTC), MapperS.of(SupervisoryBodyEnum.SEC), MapperS.of(SupervisoryBodyEnum.CA_AB_ASC), MapperS.of(SupervisoryBodyEnum.CA_BC_BCSC), MapperS.of(SupervisoryBodyEnum.CA_MB_MSC), MapperS.of(SupervisoryBodyEnum.CA_NB_FCSC), MapperS.of(SupervisoryBodyEnum.CA_NL_DSS), MapperS.of(SupervisoryBodyEnum.CA_NS_NSSC), MapperS.of(SupervisoryBodyEnum.CA_NT_NTSO), MapperS.of(SupervisoryBodyEnum.CA_NU_NSO), MapperS.of(SupervisoryBodyEnum.CA_ON_OSC), MapperS.of(SupervisoryBodyEnum.CA_PEI_OSS), MapperS.of(SupervisoryBodyEnum.CA_QC_AMF), MapperS.of(SupervisoryBodyEnum.CA_SK_FCAA), MapperS.of(SupervisoryBodyEnum.CA_YT_OSS)), MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
