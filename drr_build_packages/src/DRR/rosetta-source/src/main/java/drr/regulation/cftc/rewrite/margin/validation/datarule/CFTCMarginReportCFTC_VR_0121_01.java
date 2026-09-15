package drr.regulation.cftc.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.margin.CFTCMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCMarginReportCFTC_VR_0121_01")
@ImplementedBy(CFTCMarginReportCFTC_VR_0121_01.Default.class)
public interface CFTCMarginReportCFTC_VR_0121_01 extends Validator<CFTCMarginReport> {
	
	String NAME = "CFTCMarginReportCFTC_VR_0121_01";
	String DEFINITION = "if [\"OWC2\", \"OWP2\", \"FLCL\"] any = collateralisationCategory to-string then initialMarginCollectedByCounterparty1PostHaircut exists else initialMarginCollectedByCounterparty1PostHaircut is absent";
	
	class Default implements CFTCMarginReportCFTC_VR_0121_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCMarginReport cFTCMarginReport) {
			ComparisonResult result = executeDataRule(cFTCMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCMarginReport cFTCMarginReport) {
			try {
				if (areEqual(MapperC.<String>of(MapperS.of("OWC2"), MapperS.of("OWP2"), MapperS.of("FLCL")), MapperS.of(cFTCMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _cFTCMarginReport -> _cFTCMarginReport.getCollateralisationCategory()).map("to-string", CollateralisationType3Code::toDisplayString), CardinalityOperator.Any).getOrDefault(false)) {
					return exists(MapperS.of(cFTCMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PostHaircut", _cFTCMarginReport -> _cFTCMarginReport.getInitialMarginCollectedByCounterparty1PostHaircut()));
				}
				return notExists(MapperS.of(cFTCMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PostHaircut", _cFTCMarginReport -> _cFTCMarginReport.getInitialMarginCollectedByCounterparty1PostHaircut()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCMarginReportCFTC_VR_0121_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCMarginReport cFTCMarginReport) {
			return Collections.emptyList();
		}
	}
}
