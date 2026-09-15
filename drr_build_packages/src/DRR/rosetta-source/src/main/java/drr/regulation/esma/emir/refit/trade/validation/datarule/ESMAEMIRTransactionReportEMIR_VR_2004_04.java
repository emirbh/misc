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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2004_04")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2004_04.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2004_04 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2004_04";
	String DEFINITION = "if [ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> REVI, ActionTypeEnum -> POSC] any = actionType then if subsequentPositionUTI exists then [uniqueTransactionIdentifier, reportTrackingNumber, priorUTI] all <> subsequentPositionUTI";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2004_04 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getSubsequentPositionUTI", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getSubsequentPositionUTI())).getOrDefault(false)) {
						return notEqual(MapperC.<String>of(MapperS.of(eSMAEMIRTransactionReport).<String>map("getUniqueTransactionIdentifier", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getUniqueTransactionIdentifier()), MapperS.of(eSMAEMIRTransactionReport).<String>map("getReportTrackingNumber", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReportTrackingNumber()), MapperS.of(eSMAEMIRTransactionReport).<String>map("getPriorUTI", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getPriorUTI())), MapperS.of(eSMAEMIRTransactionReport).<String>map("getSubsequentPositionUTI", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getSubsequentPositionUTI()), CardinalityOperator.All);
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2004_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
