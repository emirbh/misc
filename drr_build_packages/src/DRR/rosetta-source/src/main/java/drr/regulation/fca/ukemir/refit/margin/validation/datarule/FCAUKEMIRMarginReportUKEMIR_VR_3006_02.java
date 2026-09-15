package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.API_GetLeiData;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3006_02")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3006_02.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3006_02 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3006_02";
	String DEFINITION = "if counterparty2IdentifierType = True then [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] any = API_GetLeiData( counterparty2 ) -> registrationStatus";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3006_02 {
	
		@Inject protected API_GetLeiData aPI_GetLeiData;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			try {
				if (areEqual(MapperS.of(fCAUKEMIRMarginReport).<Boolean>map("getCounterparty2IdentifierType", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)), MapperS.of(aPI_GetLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<String>map("getCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCounterparty2()).get())).<LeiRegistrationStatusEnum>map("getRegistrationStatus", leiData -> leiData.getRegistrationStatus()), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3006_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
