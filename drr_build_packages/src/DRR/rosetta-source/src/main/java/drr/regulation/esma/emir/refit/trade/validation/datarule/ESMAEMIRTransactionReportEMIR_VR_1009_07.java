package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.string.functions.SubString;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1009_07")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1009_07.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1009_07 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1009_07";
	String DEFINITION = "if counterparty2IdentifierType = False and [ActionTypeEnum -> NEWT, ActionTypeEnum -> POSC] any = actionType and counterparty2 exists then SubString(counterparty2, 1, 20) = counterparty1";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1009_07 {
	
		@Inject protected SubString subString;
		
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
				if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<Boolean>map("getCounterparty2IdentifierType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getCounterparty2", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty2()))).getOrDefault(false)) {
					return areEqual(MapperS.of(subString.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>map("getCounterparty2", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty2()).get(), 1, 20)), MapperS.of(eSMAEMIRTransactionReport).<String>map("getCounterparty1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty1()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1009_07 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
