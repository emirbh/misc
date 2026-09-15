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
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2004_04")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2004_04.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2004_04 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2004_04";
	String DEFINITION = "if [ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> REVI, ActionTypeEnum -> POSC] any = actionType then if subsequentPositionUTI exists then [uniqueTransactionIdentifier, reportTrackingNumber, priorUTI] all <> subsequentPositionUTI";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2004_04 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getSubsequentPositionUTI", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getSubsequentPositionUTI())).getOrDefault(false)) {
						return notEqual(MapperC.<String>of(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getUniqueTransactionIdentifier", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getUniqueTransactionIdentifier()), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReportTrackingNumber", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportTrackingNumber()), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getPriorUTI", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPriorUTI())), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getSubsequentPositionUTI", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getSubsequentPositionUTI()), CardinalityOperator.All);
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2004_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
