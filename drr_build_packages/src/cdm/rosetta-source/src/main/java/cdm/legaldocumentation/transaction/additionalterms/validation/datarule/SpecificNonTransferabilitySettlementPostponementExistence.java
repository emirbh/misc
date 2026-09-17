package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
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
@RosettaDataRule("SpecificNonTransferabilitySettlementPostponementExistence")
@ImplementedBy(SpecificNonTransferabilitySettlementPostponementExistence.Default.class)
public interface SpecificNonTransferabilitySettlementPostponementExistence extends Validator<SpecificNonTransferability> {
	
	String NAME = "SpecificNonTransferabilitySettlementPostponementExistence";
	String DEFINITION = "if localSubstituteProvisionType = FxSubstitutionProvisionTypeEnum -> LocalCurrencySubstitute then maximumDaysOfDisruption exists";
	
	class Default implements SpecificNonTransferabilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificNonTransferability specificNonTransferability) {
			ComparisonResult result = executeDataRule(specificNonTransferability);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificNonTransferability", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificNonTransferability", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SpecificNonTransferability specificNonTransferability) {
			try {
				if (areEqual(MapperS.of(specificNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _specificNonTransferability -> _specificNonTransferability.getLocalSubstituteProvisionType()), MapperS.of(FxSubstitutionProvisionTypeEnum.LOCAL_CURRENCY_SUBSTITUTE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(specificNonTransferability).<ValuationPostponement>map("getMaximumDaysOfDisruption", _specificNonTransferability -> _specificNonTransferability.getMaximumDaysOfDisruption()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SpecificNonTransferabilitySettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificNonTransferability specificNonTransferability) {
			return Collections.emptyList();
		}
	}
}
