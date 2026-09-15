package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.emir.functions.Counterparty2_01_Validation;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1009_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1009_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1009_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1009_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> VALU, ActionTypeEnum -> CORR, ActionTypeEnum -> POSC] any = actionType then Counterparty2_01_Validation( nonReportable -> enrichment, counterparty2IdentifierType, counterparty2 )";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_01 {
	
		@Inject protected Counterparty2_01_Validation counterparty2_01_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(counterparty2_01_Validation.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Boolean>map("getCounterparty2IdentifierType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2IdentifierType()).get(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2()).get())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
