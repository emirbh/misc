package drr.regulation.mas.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASValuationReportDTCC_MAS_BR_0050_03")
@ImplementedBy(MASValuationReportDTCC_MAS_BR_0050_03.Default.class)
public interface MASValuationReportDTCC_MAS_BR_0050_03 extends Validator<MASValuationReport> {
	
	String NAME = "MASValuationReportDTCC_MAS_BR_0050_03";
	String DEFINITION = "if actionType = VALU then reportingTimestamp >= valuationTimestamp";
	
	class Default implements MASValuationReportDTCC_MAS_BR_0050_03 {
	
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
				if (areEqual(MapperS.of(mASValuationReport).<ActionTypeEnum>map("getActionType", _mASValuationReport -> _mASValuationReport.getActionType()), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(mASValuationReport).<ZonedDateTime>map("getReportingTimestamp", _mASValuationReport -> _mASValuationReport.getReportingTimestamp()), MapperS.of(mASValuationReport).<ZonedDateTime>map("getValuationTimestamp", _mASValuationReport -> _mASValuationReport.getValuationTimestamp()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASValuationReportDTCC_MAS_BR_0050_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			return Collections.emptyList();
		}
	}
}
