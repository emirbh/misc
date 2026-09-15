package drr.regulation.esma.emir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.ValuationTimestamp_06_Validation;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAValuationReportEMIR_VR_2023_06")
@ImplementedBy(ESMAValuationReportEMIR_VR_2023_06.Default.class)
public interface ESMAValuationReportEMIR_VR_2023_06 extends Validator<ESMAValuationReport> {
	
	String NAME = "ESMAValuationReportEMIR_VR_2023_06";
	String DEFINITION = "ValuationTimestamp_06_Validation(valuationAmount, valuationTimestamp, eventDate)";
	
	class Default implements ESMAValuationReportEMIR_VR_2023_06 {
	
		@Inject protected ValuationTimestamp_06_Validation valuationTimestamp_06_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAValuationReport eSMAValuationReport) {
			ComparisonResult result = executeDataRule(eSMAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAValuationReport eSMAValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(valuationTimestamp_06_Validation.evaluate(MapperS.of(eSMAValuationReport).<BigDecimal>map("getValuationAmount", _eSMAValuationReport -> _eSMAValuationReport.getValuationAmount()).get(), MapperS.of(eSMAValuationReport).<ZonedDateTime>map("getValuationTimestamp", _eSMAValuationReport -> _eSMAValuationReport.getValuationTimestamp()).get(), MapperS.of(eSMAValuationReport).<Date>map("getEventDate", _eSMAValuationReport -> _eSMAValuationReport.getEventDate()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAValuationReportEMIR_VR_2023_06 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAValuationReport eSMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
