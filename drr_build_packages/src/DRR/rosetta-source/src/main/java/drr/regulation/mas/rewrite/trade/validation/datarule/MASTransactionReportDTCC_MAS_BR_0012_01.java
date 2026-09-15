package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0012_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0012_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0012_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0012_01";
	String DEFINITION = "(if actionType = ActionTypeEnum -> NEWT and eventType = EventTypeEnum -> ALOC then required choice priorUTI, priorUTIProprietary else True) and priorUTI <> uniqueTransactionIdentifier and priorUTIProprietary <> uniqueTransactionIdentifierProprietary";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0012_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				final ComparisonResult ifThenElseResult;
				if (areEqual(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<EventTypeEnum>map("getEventType", _mASTransactionReport -> _mASTransactionReport.getEventType()), MapperS.of(EventTypeEnum.ALOC), CardinalityOperator.All)).getOrDefault(false)) {
					ifThenElseResult = choice(MapperS.of(mASTransactionReport), Arrays.asList("priorUTI", "priorUTIProprietary"), ChoiceRuleValidationMethod.REQUIRED);
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ifThenElseResult.andNullSafe(notEqual(MapperS.of(mASTransactionReport).<String>map("getPriorUTI", _mASTransactionReport -> _mASTransactionReport.getPriorUTI()), MapperS.of(mASTransactionReport).<String>map("getUniqueTransactionIdentifier", _mASTransactionReport -> _mASTransactionReport.getUniqueTransactionIdentifier()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(mASTransactionReport).<String>map("getPriorUTIProprietary", _mASTransactionReport -> _mASTransactionReport.getPriorUTIProprietary()), MapperS.of(mASTransactionReport).<String>map("getUniqueTransactionIdentifierProprietary", _mASTransactionReport -> _mASTransactionReport.getUniqueTransactionIdentifierProprietary()), CardinalityOperator.Any));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0012_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
