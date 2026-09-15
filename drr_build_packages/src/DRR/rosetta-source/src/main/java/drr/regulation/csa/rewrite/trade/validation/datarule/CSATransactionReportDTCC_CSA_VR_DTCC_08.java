package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_DTCC_08")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_DTCC_08.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_DTCC_08 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_DTCC_08";
	String DEFINITION = "if dtccAdditionalFields -> tradeParty1ReportingDestination exists then [SupervisoryBodyEnum -> CFTC, SupervisoryBodyEnum -> SEC, SupervisoryBodyEnum -> CA_AB_ASC, SupervisoryBodyEnum -> CA_BC_BCSC, SupervisoryBodyEnum -> CA_MB_MSC, SupervisoryBodyEnum -> CA_NB_FCSC, SupervisoryBodyEnum -> CA_NL_DSS, SupervisoryBodyEnum -> CA_NS_NSSC, SupervisoryBodyEnum -> CA_NT_NTSO, SupervisoryBodyEnum -> CA_NU_NSO, SupervisoryBodyEnum -> CA_ON_OSC, SupervisoryBodyEnum -> CA_PEI_OSS, SupervisoryBodyEnum -> CA_QC_AMF, SupervisoryBodyEnum -> CA_SK_FCAA, SupervisoryBodyEnum -> CA_YT_OSS] contains dtccAdditionalFields -> tradeParty1ReportingDestination";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_DTCC_08 {
	
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
				if (exists(MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination())).getOrDefault(false)) {
					return contains(MapperC.<SupervisoryBodyEnum>of(MapperS.of(SupervisoryBodyEnum.CFTC), MapperS.of(SupervisoryBodyEnum.SEC), MapperS.of(SupervisoryBodyEnum.CA_AB_ASC), MapperS.of(SupervisoryBodyEnum.CA_BC_BCSC), MapperS.of(SupervisoryBodyEnum.CA_MB_MSC), MapperS.of(SupervisoryBodyEnum.CA_NB_FCSC), MapperS.of(SupervisoryBodyEnum.CA_NL_DSS), MapperS.of(SupervisoryBodyEnum.CA_NS_NSSC), MapperS.of(SupervisoryBodyEnum.CA_NT_NTSO), MapperS.of(SupervisoryBodyEnum.CA_NU_NSO), MapperS.of(SupervisoryBodyEnum.CA_ON_OSC), MapperS.of(SupervisoryBodyEnum.CA_PEI_OSS), MapperS.of(SupervisoryBodyEnum.CA_QC_AMF), MapperS.of(SupervisoryBodyEnum.CA_SK_FCAA), MapperS.of(SupervisoryBodyEnum.CA_YT_OSS)), MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_DTCC_08 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
