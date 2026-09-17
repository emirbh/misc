package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
import cdm.observable.asset.MultipleCreditNotations;
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
@RosettaDataRule("MultipleCreditNotationsReferenceAgency")
@ImplementedBy(MultipleCreditNotationsReferenceAgency.Default.class)
public interface MultipleCreditNotationsReferenceAgency extends Validator<MultipleCreditNotations> {
	
	String NAME = "MultipleCreditNotationsReferenceAgency";
	String DEFINITION = "if mismatchResolution = CreditNotationMismatchResolutionEnum -> ReferenceAgency then referenceAgency exists";
	
	class Default implements MultipleCreditNotationsReferenceAgency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleCreditNotations multipleCreditNotations) {
			ComparisonResult result = executeDataRule(multipleCreditNotations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleCreditNotations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleCreditNotations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MultipleCreditNotations multipleCreditNotations) {
			try {
				if (areEqual(MapperS.of(multipleCreditNotations).<CreditNotationMismatchResolutionEnum>map("getMismatchResolution", _multipleCreditNotations -> _multipleCreditNotations.getMismatchResolution()), MapperS.of(CreditNotationMismatchResolutionEnum.REFERENCE_AGENCY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(multipleCreditNotations).<CreditRatingAgencyEnum>map("getReferenceAgency", _multipleCreditNotations -> _multipleCreditNotations.getReferenceAgency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MultipleCreditNotationsReferenceAgency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleCreditNotations multipleCreditNotations) {
			return Collections.emptyList();
		}
	}
}
