package drr.regulation.hkma.rewrite.margin.validation.datarule;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMAMarginReportDOC0011")
@ImplementedBy(HKMAMarginReportDOC0011.Default.class)
public interface HKMAMarginReportDOC0011 extends Validator<HKMAMarginReport> {
	
	String NAME = "HKMAMarginReportDOC0011";
	String DEFINITION = "if [MarginActionEnum -> MARU, MarginActionEnum -> CORR] any = actionType then reportingTimestamp <= Now";
	
	class Default implements HKMAMarginReportDOC0011 {
	
		@Inject protected Now now;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAMarginReport hKMAMarginReport) {
			ComparisonResult result = executeDataRule(hKMAMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMAMarginReport hKMAMarginReport) {
			try {
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.MARU), MapperS.of(MarginActionEnum.CORR)), MapperS.of(hKMAMarginReport).<MarginActionEnum>map("getActionType", _hKMAMarginReport -> _hKMAMarginReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return lessThanEquals(MapperS.of(hKMAMarginReport).<ZonedDateTime>map("getReportingTimestamp", _hKMAMarginReport -> _hKMAMarginReport.getReportingTimestamp()), MapperS.of(now.evaluate()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAMarginReportDOC0011 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAMarginReport hKMAMarginReport) {
			return Collections.emptyList();
		}
	}
}
