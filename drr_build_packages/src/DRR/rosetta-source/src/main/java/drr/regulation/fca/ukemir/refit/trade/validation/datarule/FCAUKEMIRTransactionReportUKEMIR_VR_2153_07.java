package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2153_07")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2153_07.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2153_07 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2153_07";
	String DEFINITION = "if [ActionTypeEnum -> REVI, ActionTypeEnum -> EROR] all <> actionType then (if earlyTerminationDate is absent then eventDate <= expirationDate else eventDate <= expirationDate and eventDate <= earlyTerminationDate)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2153_07 {
	
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
				if (notEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.EROR)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.All).getOrDefault(false)) {
					if (notExists(MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEarlyTerminationDate())).getOrDefault(false)) {
						return lessThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getExpirationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExpirationDate()), CardinalityOperator.All);
					}
					return lessThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getExpirationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExpirationDate()), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEarlyTerminationDate()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2153_07 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
