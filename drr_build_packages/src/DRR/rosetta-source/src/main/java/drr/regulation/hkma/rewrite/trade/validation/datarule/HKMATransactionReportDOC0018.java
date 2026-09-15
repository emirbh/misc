package drr.regulation.hkma.rewrite.trade.validation.datarule;

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
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMATransactionReportDOC0018")
@ImplementedBy(HKMATransactionReportDOC0018.Default.class)
public interface HKMATransactionReportDOC0018 extends Validator<HKMATransactionReport> {
	
	String NAME = "HKMATransactionReportDOC0018";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and direction1 is absent then leg1 -> direction2 exists and leg1 -> direction2 <> leg2 -> direction2 else if direction1 exists then leg1 -> direction2 is absent";
	
	class Default implements HKMATransactionReportDOC0018 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			ComparisonResult result = executeDataRule(hKMATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMATransactionReport hKMATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(hKMATransactionReport).<ActionTypeEnum>map("getActionType", _hKMATransactionReport -> _hKMATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(notExists(MapperS.of(hKMATransactionReport).<Direction1Enum>map("getDirection1", _hKMATransactionReport -> _hKMATransactionReport.getDirection1()))).getOrDefault(false)) {
					return exists(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2())).andNullSafe(notEqual(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()), MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg2", _hKMATransactionReport -> _hKMATransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()), CardinalityOperator.Any));
				}
				if (exists(MapperS.of(hKMATransactionReport).<Direction1Enum>map("getDirection1", _hKMATransactionReport -> _hKMATransactionReport.getDirection1())).getOrDefault(false)) {
					return notExists(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMATransactionReportDOC0018 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			return Collections.emptyList();
		}
	}
}
