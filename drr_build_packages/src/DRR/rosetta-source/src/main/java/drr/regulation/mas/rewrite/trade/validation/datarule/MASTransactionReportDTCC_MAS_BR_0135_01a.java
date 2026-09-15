package drr.regulation.mas.rewrite.trade.validation.datarule;

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
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0135_01a")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0135_01a.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0135_01a extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0135_01a";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR] any = actionType then eventTimestamp -> date >= executionTimestamp -> date and eventTimestamp -> date <= reportingTimestamp -> date else if ActionTypeEnum -> REVI = actionType then eventTimestamp <= reportingTimestamp else if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR] any = actionType then eventTimestamp -> date <= expirationDate";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0135_01a {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
						return greaterThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(mASTransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _mASTransactionReport -> _mASTransactionReport.getExecutionTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(mASTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _mASTransactionReport -> _mASTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), CardinalityOperator.All));
					}
					if (areEqual(MapperS.of(ActionTypeEnum.REVI), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.All).getOrDefault(false)) {
						return lessThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()), MapperS.of(mASTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _mASTransactionReport -> _mASTransactionReport.getReportingTimestamp()), CardinalityOperator.All);
					}
					if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
						return lessThanEquals(MapperS.of(mASTransactionReport).<ZonedDateTime>map("getEventTimestamp", _mASTransactionReport -> _mASTransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(mASTransactionReport).<Date>map("getExpirationDate", _mASTransactionReport -> _mASTransactionReport.getExpirationDate()), CardinalityOperator.All);
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
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0135_01a {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
