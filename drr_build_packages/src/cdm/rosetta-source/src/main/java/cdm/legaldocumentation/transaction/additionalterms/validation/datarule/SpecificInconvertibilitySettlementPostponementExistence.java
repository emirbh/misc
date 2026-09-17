package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.SpecificInconvertibility;
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
@RosettaDataRule("SpecificInconvertibilitySettlementPostponementExistence")
@ImplementedBy(SpecificInconvertibilitySettlementPostponementExistence.Default.class)
public interface SpecificInconvertibilitySettlementPostponementExistence extends Validator<SpecificInconvertibility> {
	
	String NAME = "SpecificInconvertibilitySettlementPostponementExistence";
	String DEFINITION = "if localSubstituteProvisionType = FxSubstitutionProvisionTypeEnum -> LocalCurrencySubstitute then maximumDaysOfDisruption exists";
	
	class Default implements SpecificInconvertibilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificInconvertibility specificInconvertibility) {
			ComparisonResult result = executeDataRule(specificInconvertibility);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificInconvertibility", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificInconvertibility", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SpecificInconvertibility specificInconvertibility) {
			try {
				if (areEqual(MapperS.of(specificInconvertibility).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _specificInconvertibility -> _specificInconvertibility.getLocalSubstituteProvisionType()), MapperS.of(FxSubstitutionProvisionTypeEnum.LOCAL_CURRENCY_SUBSTITUTE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(specificInconvertibility).<ValuationPostponement>map("getMaximumDaysOfDisruption", _specificInconvertibility -> _specificInconvertibility.getMaximumDaysOfDisruption()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SpecificInconvertibilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificInconvertibility specificInconvertibility) {
			return Collections.emptyList();
		}
	}
}
