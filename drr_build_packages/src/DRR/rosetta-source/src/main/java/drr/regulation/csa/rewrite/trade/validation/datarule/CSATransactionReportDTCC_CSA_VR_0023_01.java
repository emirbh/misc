package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_0023_01")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_0023_01.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_0023_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_0023_01";
	String DEFINITION = "if [ExecutionVenueTypeEnum -> SEF, ExecutionVenueTypeEnum -> DCM] any = nonReportable -> executionVenueType or (actionType = TERM and ([EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType) and centralCounterparty exists) then platformAnonymousExecutionIndicator exists else platformAnonymousExecutionIndicator is absent";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_0023_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperC.<ExecutionVenueTypeEnum>of(MapperS.of(ExecutionVenueTypeEnum.SEF), MapperS.of(ExecutionVenueTypeEnum.DCM)), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", cSANonReportable -> cSANonReportable.getExecutionVenueType()), CardinalityOperator.Any).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(cSATransactionReport).<String>map("getCentralCounterparty", _cSATransactionReport -> _cSATransactionReport.getCentralCounterparty())))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<Boolean>map("getPlatformAnonymousExecutionIndicator", _cSATransactionReport -> _cSATransactionReport.getPlatformAnonymousExecutionIndicator()));
				}
				return notExists(MapperS.of(cSATransactionReport).<Boolean>map("getPlatformAnonymousExecutionIndicator", _cSATransactionReport -> _cSATransactionReport.getPlatformAnonymousExecutionIndicator()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_0023_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
