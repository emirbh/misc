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
import drr.base.util.string.functions.SubString;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2005_04")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2005_04.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2005_04 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2005_04";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> REVI] any = actionType then if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> TERM] any = actionType then if ptrrId exists then SubString(ptrrId, 1, 20) = ptrrServiceProvider";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2005_04 {
	
		@Inject protected SubString subString;
		
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
						if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getPtrrId", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPtrrId())).getOrDefault(false)) {
							return areEqual(MapperS.of(subString.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getPtrrId", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPtrrId()).get(), 1, 20)), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getPtrrServiceProvider", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPtrrServiceProvider()), CardinalityOperator.All);
						}
						return ComparisonResult.ofEmpty();
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2005_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
