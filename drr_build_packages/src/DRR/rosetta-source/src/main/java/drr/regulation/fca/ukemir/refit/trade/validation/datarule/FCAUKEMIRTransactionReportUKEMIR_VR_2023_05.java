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
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2023_05")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2023_05.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2023_05 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2023_05";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> VALU, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> POSC] any = actionType then if valuationAmount exists then (if earlyTerminationDate exists then valuationTimestamp -> date <= earlyTerminationDate else valuationTimestamp -> date <= expirationDate)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2023_05 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<BigDecimal>map("getValuationAmount", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getValuationAmount())).getOrDefault(false)) {
						if (exists(MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEarlyTerminationDate())).getOrDefault(false)) {
							return lessThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getValuationTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getValuationTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEarlyTerminationDate()), CardinalityOperator.All);
						}
						return lessThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getValuationTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getValuationTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getExpirationDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExpirationDate()), CardinalityOperator.All);
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2023_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
