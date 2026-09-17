package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.BespokeCalculationDate;
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
@RosettaDataRule("BespokeCalculationDateCalculationDateImTerms")
@ImplementedBy(BespokeCalculationDateCalculationDateImTerms.Default.class)
public interface BespokeCalculationDateCalculationDateImTerms extends Validator<BespokeCalculationDate> {
	
	String NAME = "BespokeCalculationDateCalculationDateImTerms";
	String DEFINITION = "if isApplicable = False then calculationDateImTerms is absent";
	
	class Default implements BespokeCalculationDateCalculationDateImTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BespokeCalculationDate bespokeCalculationDate) {
			ComparisonResult result = executeDataRule(bespokeCalculationDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BespokeCalculationDate bespokeCalculationDate) {
			try {
				if (areEqual(MapperS.of(bespokeCalculationDate).<Boolean>map("getIsApplicable", _bespokeCalculationDate -> _bespokeCalculationDate.getIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(bespokeCalculationDate).<String>map("getCalculationDateImTerms", _bespokeCalculationDate -> _bespokeCalculationDate.getCalculationDateImTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BespokeCalculationDateCalculationDateImTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BespokeCalculationDate bespokeCalculationDate) {
			return Collections.emptyList();
		}
	}
}
