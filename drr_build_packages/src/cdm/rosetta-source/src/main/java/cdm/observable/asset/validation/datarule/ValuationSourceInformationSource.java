package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.ValuationSource;
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
@RosettaDataRule("ValuationSourceInformationSource")
@ImplementedBy(ValuationSourceInformationSource.Default.class)
public interface ValuationSourceInformationSource extends Validator<ValuationSource> {
	
	String NAME = "ValuationSourceInformationSource";
	String DEFINITION = "required choice informationSource, settlementRateOption, referenceBanks, dealerOrCCP";
	
	class Default implements ValuationSourceInformationSource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSource valuationSource) {
			ComparisonResult result = executeDataRule(valuationSource);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationSource", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationSource", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ValuationSource valuationSource) {
			try {
				return choice(MapperS.of(valuationSource), Arrays.asList("informationSource", "settlementRateOption", "referenceBanks", "dealerOrCCP"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ValuationSourceInformationSource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSource valuationSource) {
			return Collections.emptyList();
		}
	}
}
