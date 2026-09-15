package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.party.functions.Direction2Leg1_Validation;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0011_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0011_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0011_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0011_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> PRTO, ActionTypeEnum -> EROR, ActionTypeEnum -> TERM] any = actionType then common.party.Direction2Leg1_Validation( direction1, leg1 -> direction2, leg2 -> direction2 )";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0011_01 {
	
		@Inject protected Direction2Leg1_Validation direction2Leg1_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(direction2Leg1_Validation.evaluate(MapperS.of(jFSATransactionReport).<Direction1Enum>map("getDirection1", _jFSATransactionReport -> _jFSATransactionReport.getDirection1()).get(), MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg1", _jFSATransactionReport -> _jFSATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).get(), MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg2", _jFSATransactionReport -> _jFSATransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).get())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0011_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
