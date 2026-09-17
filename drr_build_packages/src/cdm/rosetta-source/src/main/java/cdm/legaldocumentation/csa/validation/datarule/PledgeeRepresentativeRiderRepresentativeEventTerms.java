package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
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
@RosettaDataRule("PledgeeRepresentativeRiderRepresentativeEventTerms")
@ImplementedBy(PledgeeRepresentativeRiderRepresentativeEventTerms.Default.class)
public interface PledgeeRepresentativeRiderRepresentativeEventTerms extends Validator<PledgeeRepresentativeRider> {
	
	String NAME = "PledgeeRepresentativeRiderRepresentativeEventTerms";
	String DEFINITION = "if representativeEvent = ExceptionEnum -> Other then representativeEventTerms exists";
	
	class Default implements PledgeeRepresentativeRiderRepresentativeEventTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			ComparisonResult result = executeDataRule(pledgeeRepresentativeRider);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			try {
				if (areEqual(MapperS.of(pledgeeRepresentativeRider).<ExceptionEnum>map("getRepresentativeEvent", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEvent()), MapperS.of(ExceptionEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(pledgeeRepresentativeRider).<String>map("getRepresentativeEventTerms", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEventTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PledgeeRepresentativeRiderRepresentativeEventTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			return Collections.emptyList();
		}
	}
}
