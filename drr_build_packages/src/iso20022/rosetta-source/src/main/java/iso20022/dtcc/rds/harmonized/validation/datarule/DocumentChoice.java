package iso20022.dtcc.rds.harmonized.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Document;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DocumentChoice")
@ImplementedBy(DocumentChoice.Default.class)
public interface DocumentChoice extends Validator<Document> {
	
	String NAME = "DocumentChoice";
	String DEFINITION = "one-of";
	
	class Default implements DocumentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Document document) {
			ComparisonResult result = executeDataRule(document);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Document", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Document", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Document document) {
			try {
				return choice(MapperS.of(document), Arrays.asList("submission", "response"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DocumentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Document document) {
			return Collections.emptyList();
		}
	}
}
