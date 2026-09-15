package drr.regulation.esma.emir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.emir.functions.Counterparty2_01_Validation;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import drr.regulation.esma.emir.refit.valuation.NonReportable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAValuationReportEMIR_VR_1009_01")
@ImplementedBy(ESMAValuationReportEMIR_VR_1009_01.Default.class)
public interface ESMAValuationReportEMIR_VR_1009_01 extends Validator<ESMAValuationReport> {
	
	String NAME = "ESMAValuationReportEMIR_VR_1009_01";
	String DEFINITION = "Counterparty2_01_Validation( nonReportable -> enrichment, counterparty2IdentifierType, counterparty2 )";
	
	class Default implements ESMAValuationReportEMIR_VR_1009_01 {
	
		@Inject protected Counterparty2_01_Validation counterparty2_01_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty2_01_Validation.evaluate(MapperS.of(eSMAValuationReport).<NonReportable>map("getNonReportable", _eSMAValuationReport -> _eSMAValuationReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).get(), MapperS.of(eSMAValuationReport).<Boolean>map("getCounterparty2IdentifierType", _eSMAValuationReport -> _eSMAValuationReport.getCounterparty2IdentifierType()).get(), MapperS.of(eSMAValuationReport).<String>map("getCounterparty2", _eSMAValuationReport -> _eSMAValuationReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAValuationReportEMIR_VR_1009_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAValuationReport eSMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
