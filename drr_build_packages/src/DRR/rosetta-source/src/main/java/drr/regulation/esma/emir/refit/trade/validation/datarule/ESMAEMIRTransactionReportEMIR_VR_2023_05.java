package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2023_05")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2023_05.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2023_05 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2023_05";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> VALU, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> POSC] any = actionType then if valuationAmount exists then (if earlyTerminationDate exists then valuationTimestamp -> date <= earlyTerminationDate else valuationTimestamp -> date <= expirationDate)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2023_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(eSMAEMIRTransactionReport).<BigDecimal>map("getValuationAmount", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getValuationAmount())).getOrDefault(false)) {
						if (exists(MapperS.of(eSMAEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEarlyTerminationDate())).getOrDefault(false)) {
							return lessThanEquals(MapperS.of(eSMAEMIRTransactionReport).<ZonedDateTime>map("getValuationTimestamp", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getValuationTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(eSMAEMIRTransactionReport).<Date>map("getEarlyTerminationDate", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEarlyTerminationDate()), CardinalityOperator.All);
						}
						return lessThanEquals(MapperS.of(eSMAEMIRTransactionReport).<ZonedDateTime>map("getValuationTimestamp", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getValuationTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(eSMAEMIRTransactionReport).<Date>map("getExpirationDate", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getExpirationDate()), CardinalityOperator.All);
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2023_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
