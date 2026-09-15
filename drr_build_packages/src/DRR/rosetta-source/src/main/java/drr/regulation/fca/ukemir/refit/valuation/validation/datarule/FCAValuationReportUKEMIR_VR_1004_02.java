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
import drr.regulation.common.emir.functions.Counterparty1_02_Validation;
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
@RosettaDataRule("FCAValuationReportUKEMIR_VR_1004_02")
@ImplementedBy(FCAValuationReportUKEMIR_VR_1004_02.Default.class)
public interface FCAValuationReportUKEMIR_VR_1004_02 extends Validator<FCAValuationReport> {
	
	String NAME = "FCAValuationReportUKEMIR_VR_1004_02";
	String DEFINITION = "Counterparty1_02_Validation( nonReportable -> enrichment, counterparty1, eventDate, reportingTimestamp )";
	
	class Default implements FCAValuationReportUKEMIR_VR_1004_02 {
	
		@Inject protected Counterparty1_02_Validation counterparty1_02_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty1_02_Validation.evaluate(MapperS.of(fCAValuationReport).<NonReportable>map("getNonReportable", _fCAValuationReport -> _fCAValuationReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).get(), MapperS.of(fCAValuationReport).<String>map("getCounterparty1", _fCAValuationReport -> _fCAValuationReport.getCounterparty1()).get(), MapperS.of(fCAValuationReport).<Date>map("getEventDate", _fCAValuationReport -> _fCAValuationReport.getEventDate()).get(), MapperS.of(fCAValuationReport).<ZonedDateTime>map("getReportingTimestamp", _fCAValuationReport -> _fCAValuationReport.getReportingTimestamp()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAValuationReportUKEMIR_VR_1004_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			return Collections.emptyList();
		}
	}
}
