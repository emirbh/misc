package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.fpmlenum.DividendPeriodEnum;
import fpml.consolidated.shared.DateReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendConditionsChoice0")
@ImplementedBy(DividendConditionsChoice0.Default.class)
public interface DividendConditionsChoice0 extends Validator<DividendConditions> {
	
	String NAME = "DividendConditionsChoice0";
	String DEFINITION = "dividendPeriod is absent or dividendPeriodEffectiveDate is absent and dividendPeriodEndDate is absent";
	
	class Default implements DividendConditionsChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions dividendConditions) {
			ComparisonResult result = executeDataRule(dividendConditions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendConditions dividendConditions) {
			try {
				return notExists(MapperS.of(dividendConditions).<DividendPeriodEnum>map("getDividendPeriod", _dividendConditions -> _dividendConditions.getDividendPeriod())).orNullSafe(notExists(MapperS.of(dividendConditions).<DateReference>map("getDividendPeriodEffectiveDate", _dividendConditions -> _dividendConditions.getDividendPeriodEffectiveDate())).andNullSafe(notExists(MapperS.of(dividendConditions).<DateReference>map("getDividendPeriodEndDate", _dividendConditions -> _dividendConditions.getDividendPeriodEndDate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendConditionsChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions dividendConditions) {
			return Collections.emptyList();
		}
	}
}
