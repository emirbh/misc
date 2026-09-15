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
import drr.base.util.string.functions.SubString;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMATransactionReportDOC0062")
@ImplementedBy(HKMATransactionReportDOC0062.Default.class)
public interface HKMATransactionReportDOC0062 extends Validator<HKMATransactionReport> {
	
	String NAME = "HKMATransactionReportDOC0062";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if exchangeRateBasis exists then SubString(exchangeRateBasis, 1, 3) <> SubString(exchangeRateBasis, 5, 7)";
	
	class Default implements HKMATransactionReportDOC0062 {
	
		@Inject protected SubString subString;
		
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(hKMATransactionReport).<ActionTypeEnum>map("getActionType", _hKMATransactionReport -> _hKMATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(hKMATransactionReport).<String>map("getExchangeRateBasis", _hKMATransactionReport -> _hKMATransactionReport.getExchangeRateBasis())).getOrDefault(false)) {
						return notEqual(MapperS.of(subString.evaluate(MapperS.of(hKMATransactionReport).<String>map("getExchangeRateBasis", _hKMATransactionReport -> _hKMATransactionReport.getExchangeRateBasis()).get(), 1, 3)), MapperS.of(subString.evaluate(MapperS.of(hKMATransactionReport).<String>map("getExchangeRateBasis", _hKMATransactionReport -> _hKMATransactionReport.getExchangeRateBasis()).get(), 5, 7)), CardinalityOperator.Any);
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
	class NoOp implements HKMATransactionReportDOC0062 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			return Collections.emptyList();
		}
	}
}
