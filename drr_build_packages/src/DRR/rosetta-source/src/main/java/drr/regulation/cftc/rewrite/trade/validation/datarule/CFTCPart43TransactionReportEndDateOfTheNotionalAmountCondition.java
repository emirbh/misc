package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition")
@ImplementedBy(CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition.Default.class)
public interface CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition";
	String DEFINITION = "leg1 -> notionalAmountSchedule -> endDate count <= 10 and leg2 -> notionalAmountSchedule -> endDate count <= 10";
	
	class Default implements CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				return lessThanEquals(MapperS.of(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).resultCount()), MapperS.of(10), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).resultCount()), MapperS.of(10), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
