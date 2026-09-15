package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0135_01b")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0135_01b.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0135_01b extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0135_01b";
	String DEFINITION = "if ActionTypeEnum -> TERM = actionType then eventTimestamp >= executionTimestamp and eventTimestamp <= reportingTimestamp";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0135_01b {
	
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
				if (areEqual(MapperS.of(ActionTypeEnum.TERM), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.All).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()), MapperS.of(mASTransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _mASTransactionReport -> _mASTransactionReport.getExecutionTimestamp()), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()), MapperS.of(mASTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _mASTransactionReport -> _mASTransactionReport.getReportingTimestamp()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0135_01b {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
