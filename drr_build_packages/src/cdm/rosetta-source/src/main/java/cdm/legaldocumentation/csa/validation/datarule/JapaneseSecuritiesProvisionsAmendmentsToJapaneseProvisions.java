package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
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
@RosettaDataRule("JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions")
@ImplementedBy(JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions.Default.class)
public interface JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions extends Validator<JapaneseSecuritiesProvisions> {
	
	String NAME = "JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions";
	String DEFINITION = "if amendmentsToJapaneseProvisions = False then amendmentsToJapaneseProvisionsTerms is absent";
	
	class Default implements JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
			ComparisonResult result = executeDataRule(japaneseSecuritiesProvisions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JapaneseSecuritiesProvisions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JapaneseSecuritiesProvisions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
			try {
				if (areEqual(MapperS.of(japaneseSecuritiesProvisions).<Boolean>map("getAmendmentsToJapaneseProvisions", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getAmendmentsToJapaneseProvisions()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(japaneseSecuritiesProvisions).<String>map("getAmendmentsToJapaneseProvisionsTerms", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getAmendmentsToJapaneseProvisionsTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
			return Collections.emptyList();
		}
	}
}
