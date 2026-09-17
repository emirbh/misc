package cdm.product.collateral.validation.datarule;

import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
import cdm.product.collateral.AgencyRatingCriteria;
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
@RosettaDataRule("AgencyRatingCriteriaReferenceAgency")
@ImplementedBy(AgencyRatingCriteriaReferenceAgency.Default.class)
public interface AgencyRatingCriteriaReferenceAgency extends Validator<AgencyRatingCriteria> {
	
	String NAME = "AgencyRatingCriteriaReferenceAgency";
	String DEFINITION = "if mismatchResolution = CreditNotationMismatchResolutionEnum -> ReferenceAgency then referenceAgency exists";
	
	class Default implements AgencyRatingCriteriaReferenceAgency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgencyRatingCriteria agencyRatingCriteria) {
			ComparisonResult result = executeDataRule(agencyRatingCriteria);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AgencyRatingCriteria", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AgencyRatingCriteria", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AgencyRatingCriteria agencyRatingCriteria) {
			try {
				if (areEqual(MapperS.of(agencyRatingCriteria).<CreditNotationMismatchResolutionEnum>map("getMismatchResolution", _agencyRatingCriteria -> _agencyRatingCriteria.getMismatchResolution()), MapperS.of(CreditNotationMismatchResolutionEnum.REFERENCE_AGENCY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(agencyRatingCriteria).<CreditRatingAgencyEnum>map("getReferenceAgency", _agencyRatingCriteria -> _agencyRatingCriteria.getReferenceAgency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AgencyRatingCriteriaReferenceAgency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgencyRatingCriteria agencyRatingCriteria) {
			return Collections.emptyList();
		}
	}
}
