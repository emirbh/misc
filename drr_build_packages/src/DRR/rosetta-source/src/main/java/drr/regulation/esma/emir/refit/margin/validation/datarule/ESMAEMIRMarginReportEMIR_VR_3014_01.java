package drr.regulation.esma.emir.refit.margin.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3014_01")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3014_01.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3014_01 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3014_01";
	String DEFINITION = "if [CollateralisationType3Code -> OWC1, CollateralisationType3Code -> OWP1, CollateralisationType3Code -> FLCL] any = collateralisationCategory then initialMarginPostedByCounterparty1Currency exists else initialMarginPostedByCounterparty1Currency is absent";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3014_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			try {
				if (areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.OWC1), MapperS.of(CollateralisationType3Code.OWP1), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(eSMAEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCollateralisationCategory()), CardinalityOperator.Any).getOrDefault(false)) {
					return exists(MapperS.of(eSMAEMIRMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginPostedByCounterparty1Currency", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getInitialMarginPostedByCounterparty1Currency()));
				}
				return notExists(MapperS.of(eSMAEMIRMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginPostedByCounterparty1Currency", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getInitialMarginPostedByCounterparty1Currency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3014_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
