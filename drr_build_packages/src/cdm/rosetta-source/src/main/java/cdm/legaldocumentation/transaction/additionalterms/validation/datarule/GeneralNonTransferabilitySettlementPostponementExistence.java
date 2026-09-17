package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralNonTransferability;
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
@RosettaDataRule("GeneralNonTransferabilitySettlementPostponementExistence")
@ImplementedBy(GeneralNonTransferabilitySettlementPostponementExistence.Default.class)
public interface GeneralNonTransferabilitySettlementPostponementExistence extends Validator<GeneralNonTransferability> {
	
	String NAME = "GeneralNonTransferabilitySettlementPostponementExistence";
	String DEFINITION = "if localSubstituteProvisionType = FxSubstitutionProvisionTypeEnum -> LocalCurrencySubstitute then maximumDaysOfDisruption exists";
	
	class Default implements GeneralNonTransferabilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralNonTransferability generalNonTransferability) {
			ComparisonResult result = executeDataRule(generalNonTransferability);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralNonTransferability", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralNonTransferability", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GeneralNonTransferability generalNonTransferability) {
			try {
				if (areEqual(MapperS.of(generalNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalNonTransferability -> _generalNonTransferability.getLocalSubstituteProvisionType()), MapperS.of(FxSubstitutionProvisionTypeEnum.LOCAL_CURRENCY_SUBSTITUTE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(generalNonTransferability).<ValuationPostponement>map("getMaximumDaysOfDisruption", _generalNonTransferability -> _generalNonTransferability.getMaximumDaysOfDisruption()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralNonTransferabilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralNonTransferability generalNonTransferability) {
			return Collections.emptyList();
		}
	}
}
