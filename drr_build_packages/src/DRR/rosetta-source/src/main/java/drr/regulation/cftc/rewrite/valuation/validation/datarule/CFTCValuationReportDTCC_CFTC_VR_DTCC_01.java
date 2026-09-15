package drr.regulation.cftc.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCValuationReportDTCC_CFTC_VR_DTCC_01")
@ImplementedBy(CFTCValuationReportDTCC_CFTC_VR_DTCC_01.Default.class)
public interface CFTCValuationReportDTCC_CFTC_VR_DTCC_01 extends Validator<CFTCValuationReport> {
	
	String NAME = "CFTCValuationReportDTCC_CFTC_VR_DTCC_01";
	String DEFINITION = "if [\"Party1\", \"BOTH\"] all <> dtccValuationFields -> submittedForParty then dtccValuationFields -> submittedForParty = counterparty1";
	
	class Default implements CFTCValuationReportDTCC_CFTC_VR_DTCC_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCValuationReport cFTCValuationReport) {
			ComparisonResult result = executeDataRule(cFTCValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCValuationReport cFTCValuationReport) {
			try {
				if (notEqual(MapperC.<String>of(MapperS.of("Party1"), MapperS.of("BOTH")), MapperS.of(cFTCValuationReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", _cFTCValuationReport -> _cFTCValuationReport.getDtccValuationFields()).<String>map("getSubmittedForParty", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getSubmittedForParty()), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(cFTCValuationReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", _cFTCValuationReport -> _cFTCValuationReport.getDtccValuationFields()).<String>map("getSubmittedForParty", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getSubmittedForParty()), MapperS.of(cFTCValuationReport).<String>map("getCounterparty1", _cFTCValuationReport -> _cFTCValuationReport.getCounterparty1()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCValuationReportDTCC_CFTC_VR_DTCC_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCValuationReport cFTCValuationReport) {
			return Collections.emptyList();
		}
	}
}
