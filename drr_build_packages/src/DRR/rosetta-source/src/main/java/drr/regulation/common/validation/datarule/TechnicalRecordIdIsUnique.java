package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TechnicalRecordId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("TechnicalRecordIdIsUnique")
@ImplementedBy(TechnicalRecordIdIsUnique.Default.class)
public interface TechnicalRecordIdIsUnique extends Validator<TechnicalRecordId> {
	
	String NAME = "TechnicalRecordIdIsUnique";
	String DEFINITION = "if isUnique exists then id exists";
	
	class Default implements TechnicalRecordIdIsUnique {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TechnicalRecordId technicalRecordId) {
			ComparisonResult result = executeDataRule(technicalRecordId);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TechnicalRecordId", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TechnicalRecordId", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TechnicalRecordId technicalRecordId) {
			try {
				if (exists(MapperS.of(technicalRecordId).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique())).getOrDefault(false)) {
					return exists(MapperS.of(technicalRecordId).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TechnicalRecordIdIsUnique {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TechnicalRecordId technicalRecordId) {
			return Collections.emptyList();
		}
	}
}
