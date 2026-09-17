package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.FxSettlementRateSource;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("FxSettlementRateSourceFxSettlementRateSourceChoice")
@ImplementedBy(FxSettlementRateSourceFxSettlementRateSourceChoice.Default.class)
public interface FxSettlementRateSourceFxSettlementRateSourceChoice extends Validator<FxSettlementRateSource> {
	
	String NAME = "FxSettlementRateSourceFxSettlementRateSourceChoice";
	String DEFINITION = "required choice settlementRateOption, nonstandardSettlementRate";
	
	class Default implements FxSettlementRateSourceFxSettlementRateSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementRateSource fxSettlementRateSource) {
			ComparisonResult result = executeDataRule(fxSettlementRateSource);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementRateSource", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementRateSource", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSettlementRateSource fxSettlementRateSource) {
			try {
				return choice(MapperS.of(fxSettlementRateSource), Arrays.asList("settlementRateOption", "nonstandardSettlementRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSettlementRateSourceFxSettlementRateSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementRateSource fxSettlementRateSource) {
			return Collections.emptyList();
		}
	}
}
