package drr.regulation.mas.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASValuationReportDTCC_MAS_BR_0001a_01")
@ImplementedBy(MASValuationReportDTCC_MAS_BR_0001a_01.Default.class)
public interface MASValuationReportDTCC_MAS_BR_0001a_01 extends Validator<MASValuationReport> {
	
	String NAME = "MASValuationReportDTCC_MAS_BR_0001a_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> TERM, ActionTypeEnum -> PRTO, ActionTypeEnum -> EROR, ActionTypeEnum -> VALU] any = actionType then (executionAgentOfTheCounterparty1 <> counterparty1 or executionAgentOfTheCounterparty1 <> counterparty2 or executionAgentOfTheCounterparty1 <> reportSubmittingEntityID) and (if executionAgentOfTheCounterparty1 = \"NOAP\" then executionAgentOfTheCounterparty2 exists else True)";
	
	class Default implements MASValuationReportDTCC_MAS_BR_0001a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			ComparisonResult result = executeDataRule(mASValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASValuationReport mASValuationReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(mASValuationReport).<ActionTypeEnum>map("getActionType", _mASValuationReport -> _mASValuationReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperS.of(mASValuationReport).<String>map("getExecutionAgentOfTheCounterparty1", _mASValuationReport -> _mASValuationReport.getExecutionAgentOfTheCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(mASValuationReport).<String>map("getExecutionAgentOfTheCounterparty2", _mASValuationReport -> _mASValuationReport.getExecutionAgentOfTheCounterparty2()));
					} else {
						ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return notEqual(MapperS.of(mASValuationReport).<String>map("getExecutionAgentOfTheCounterparty1", _mASValuationReport -> _mASValuationReport.getExecutionAgentOfTheCounterparty1()), MapperS.of(mASValuationReport).<String>map("getCounterparty1", _mASValuationReport -> _mASValuationReport.getCounterparty1()), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(mASValuationReport).<String>map("getExecutionAgentOfTheCounterparty1", _mASValuationReport -> _mASValuationReport.getExecutionAgentOfTheCounterparty1()), MapperS.of(mASValuationReport).<String>map("getCounterparty2", _mASValuationReport -> _mASValuationReport.getCounterparty2()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(mASValuationReport).<String>map("getExecutionAgentOfTheCounterparty1", _mASValuationReport -> _mASValuationReport.getExecutionAgentOfTheCounterparty1()), MapperS.of(mASValuationReport).<String>map("getReportSubmittingEntityID", _mASValuationReport -> _mASValuationReport.getReportSubmittingEntityID()), CardinalityOperator.Any)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASValuationReportDTCC_MAS_BR_0001a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			return Collections.emptyList();
		}
	}
}
