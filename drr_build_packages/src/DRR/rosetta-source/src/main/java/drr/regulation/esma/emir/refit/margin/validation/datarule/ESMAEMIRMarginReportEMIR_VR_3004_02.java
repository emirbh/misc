package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.API_GetLeiData;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3004_02")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3004_02.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3004_02 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3004_02";
	String DEFINITION = "[LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] contains API_GetLeiData( counterparty1 ) -> registrationStatus";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3004_02 {
	
		@Inject protected API_GetLeiData aPI_GetLeiData;
		
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
				return contains(MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)), MapperS.of(aPI_GetLeiData.evaluate(MapperS.of(eSMAEMIRMarginReport).<String>map("getCounterparty1", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCounterparty1()).get())).<LeiRegistrationStatusEnum>map("getRegistrationStatus", leiData -> leiData.getRegistrationStatus()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3004_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
