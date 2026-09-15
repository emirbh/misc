package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.LeiRegistrationStatusIsValidForStatus;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3003_02")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3003_02.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3003_02 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3003_02";
	String DEFINITION = "LeiRegistrationStatusIsValidForStatus( empty, entityResponsibleForReporting, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] )";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3003_02 {
	
		@Inject protected LeiRegistrationStatusIsValidForStatus leiRegistrationStatusIsValidForStatus;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(Collections.<LeiData>emptyList(), MapperS.of(eSMAEMIRMarginReport).<String>map("getEntityResponsibleForReporting", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getEntityResponsibleForReporting()).get(), MapperS.of(eSMAEMIRMarginReport).<Date>map("getEventDate", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getEventDate()).get(), MapperS.of(eSMAEMIRMarginReport).<ZonedDateTime>map("getReportingTimestamp", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3003_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
