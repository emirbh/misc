package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CreditSupportAmount;
import cdm.legaldocumentation.csa.CreditSupportAmountEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CreditSupportAmountAdditionalLanguage")
@ImplementedBy(CreditSupportAmountAdditionalLanguage.Default.class)
public interface CreditSupportAmountAdditionalLanguage extends Validator<CreditSupportAmount> {
	
	String NAME = "CreditSupportAmountAdditionalLanguage";
	String DEFINITION = "if creditSupportAmount = CreditSupportAmountEnum -> NonStandardOther then additionalLanguage exists";
	
	class Default implements CreditSupportAmountAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAmount creditSupportAmount) {
			ComparisonResult result = executeDataRule(creditSupportAmount);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportAmount", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportAmount", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditSupportAmount creditSupportAmount) {
			try {
				if (areEqual(MapperS.of(creditSupportAmount).<CreditSupportAmountEnum>map("getCreditSupportAmount", _creditSupportAmount -> _creditSupportAmount.getCreditSupportAmount()), MapperS.of(CreditSupportAmountEnum.NON_STANDARD_OTHER), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(creditSupportAmount).<String>map("getAdditionalLanguage", _creditSupportAmount -> _creditSupportAmount.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditSupportAmountAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAmount creditSupportAmount) {
			return Collections.emptyList();
		}
	}
}
