package drr.regulation.csa.rewrite.valuation.validation.datarule;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSAValuationReportDTCC_CSA_VR_DTCC_05")
@ImplementedBy(CSAValuationReportDTCC_CSA_VR_DTCC_05.Default.class)
public interface CSAValuationReportDTCC_CSA_VR_DTCC_05 extends Validator<CSAValuationReport> {
	
	String NAME = "CSAValuationReportDTCC_CSA_VR_DTCC_05";
	String DEFINITION = "if dtccValuationFields -> tradeParty2ExecutionAgentID exists then dtccValuationFields -> tradeParty2ExecutionAgentIDType exists";
	
	class Default implements CSAValuationReportDTCC_CSA_VR_DTCC_05 {
	
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
				if (exists(MapperS.of(cSAValuationReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", _cSAValuationReport -> _cSAValuationReport.getDtccValuationFields()).<String>map("getTradeParty2ExecutionAgentID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty2ExecutionAgentID())).getOrDefault(false)) {
					return exists(MapperS.of(cSAValuationReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", _cSAValuationReport -> _cSAValuationReport.getDtccValuationFields()).<PartyIdentifierTypeEnum>map("getTradeParty2ExecutionAgentIDType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty2ExecutionAgentIDType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAValuationReportDTCC_CSA_VR_DTCC_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport cSAValuationReport) {
			return Collections.emptyList();
		}
	}
}
