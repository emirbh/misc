package drr.regulation.fca.ukemir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.emir.functions.EntityResponsibleForReporting_03_Validation;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.regulation.fca.ukemir.refit.valuation.NonReportable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAValuationReportUKEMIR_VR_1003_03")
@ImplementedBy(FCAValuationReportUKEMIR_VR_1003_03.Default.class)
public interface FCAValuationReportUKEMIR_VR_1003_03 extends Validator<FCAValuationReport> {
	
	String NAME = "FCAValuationReportUKEMIR_VR_1003_03";
	String DEFINITION = "EntityResponsibleForReporting_03_Validation( nonReportable -> enrichment, entityResponsibleForReporting, reportingTimestamp, eventDate )";
	
	class Default implements FCAValuationReportUKEMIR_VR_1003_03 {
	
		@Inject protected EntityResponsibleForReporting_03_Validation entityResponsibleForReporting_03_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			ComparisonResult result = executeDataRule(fCAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAValuationReport fCAValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(entityResponsibleForReporting_03_Validation.evaluate(MapperS.of(fCAValuationReport).<NonReportable>map("getNonReportable", _fCAValuationReport -> _fCAValuationReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).get(), MapperS.of(fCAValuationReport).<String>map("getEntityResponsibleForReporting", _fCAValuationReport -> _fCAValuationReport.getEntityResponsibleForReporting()).get(), MapperS.of(fCAValuationReport).<ZonedDateTime>map("getReportingTimestamp", _fCAValuationReport -> _fCAValuationReport.getReportingTimestamp()).get(), MapperS.of(fCAValuationReport).<Date>map("getEventDate", _fCAValuationReport -> _fCAValuationReport.getEventDate()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAValuationReportUKEMIR_VR_1003_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			return Collections.emptyList();
		}
	}
}
