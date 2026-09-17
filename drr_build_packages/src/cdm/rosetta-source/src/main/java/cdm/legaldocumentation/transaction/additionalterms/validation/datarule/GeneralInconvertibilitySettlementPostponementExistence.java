package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralInconvertibility;
import cdm.observable.asset.ValuationPostponement;
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
@RosettaDataRule("GeneralInconvertibilitySettlementPostponementExistence")
@ImplementedBy(GeneralInconvertibilitySettlementPostponementExistence.Default.class)
public interface GeneralInconvertibilitySettlementPostponementExistence extends Validator<GeneralInconvertibility> {
	
	String NAME = "GeneralInconvertibilitySettlementPostponementExistence";
	String DEFINITION = "if localSubstituteProvisionType = FxSubstitutionProvisionTypeEnum -> LocalCurrencySubstitute then maximumDaysOfDisruption exists";
	
	class Default implements GeneralInconvertibilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralInconvertibility generalInconvertibility) {
			ComparisonResult result = executeDataRule(generalInconvertibility);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralInconvertibility", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralInconvertibility", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GeneralInconvertibility generalInconvertibility) {
			try {
				if (areEqual(MapperS.of(generalInconvertibility).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalInconvertibility -> _generalInconvertibility.getLocalSubstituteProvisionType()), MapperS.of(FxSubstitutionProvisionTypeEnum.LOCAL_CURRENCY_SUBSTITUTE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(generalInconvertibility).<ValuationPostponement>map("getMaximumDaysOfDisruption", _generalInconvertibility -> _generalInconvertibility.getMaximumDaysOfDisruption()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralInconvertibilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralInconvertibility generalInconvertibility) {
			return Collections.emptyList();
		}
	}
}
