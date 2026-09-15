package drr.regulation.csa.rewrite.margin.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSAMarginReportCSA_VR_0086_01")
@ImplementedBy(CSAMarginReportCSA_VR_0086_01.Default.class)
public interface CSAMarginReportCSA_VR_0086_01 extends Validator<CSAMarginReport> {
	
	String NAME = "CSAMarginReportCSA_VR_0086_01";
	String DEFINITION = "if initialMarginCollectedByCounterparty1PostHaircut exists or initialMarginCollectedByCounterparty1PreHaircut exists then initialMarginCollectedByCounterparty1Currency exists else initialMarginCollectedByCounterparty1Currency is absent";
	
	class Default implements CSAMarginReportCSA_VR_0086_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMarginReport cSAMarginReport) {
			ComparisonResult result = executeDataRule(cSAMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAMarginReport cSAMarginReport) {
			try {
				if (exists(MapperS.of(cSAMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PostHaircut", _cSAMarginReport -> _cSAMarginReport.getInitialMarginCollectedByCounterparty1PostHaircut())).orNullSafe(exists(MapperS.of(cSAMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _cSAMarginReport -> _cSAMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()))).getOrDefault(false)) {
					return exists(MapperS.of(cSAMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", _cSAMarginReport -> _cSAMarginReport.getInitialMarginCollectedByCounterparty1Currency()));
				}
				return notExists(MapperS.of(cSAMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", _cSAMarginReport -> _cSAMarginReport.getInitialMarginCollectedByCounterparty1Currency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAMarginReportCSA_VR_0086_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMarginReport cSAMarginReport) {
			return Collections.emptyList();
		}
	}
}
