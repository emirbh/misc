package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.EntityId;
import fpml.consolidated.shared.EntityName;
import fpml.consolidated.shared.LegalEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LegalEntityChoice")
@ImplementedBy(LegalEntityChoice.Default.class)
public interface LegalEntityChoice extends Validator<LegalEntity> {
	
	String NAME = "LegalEntityChoice";
	String DEFINITION = "entityName exists or entityId exists";
	
	class Default implements LegalEntityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalEntity legalEntity) {
			ComparisonResult result = executeDataRule(legalEntity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalEntity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalEntity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegalEntity legalEntity) {
			try {
				return exists(MapperS.of(legalEntity).<EntityName>map("getEntityName", _legalEntity -> _legalEntity.getEntityName())).orNullSafe(exists(MapperS.of(legalEntity).<EntityId>mapC("getEntityId", _legalEntity -> _legalEntity.getEntityId())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegalEntityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalEntity legalEntity) {
			return Collections.emptyList();
		}
	}
}
