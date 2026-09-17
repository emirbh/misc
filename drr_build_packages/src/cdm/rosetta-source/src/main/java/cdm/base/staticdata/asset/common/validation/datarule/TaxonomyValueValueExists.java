package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TaxonomyValueValueExists")
@ImplementedBy(TaxonomyValueValueExists.Default.class)
public interface TaxonomyValueValueExists extends Validator<TaxonomyValue> {
	
	String NAME = "TaxonomyValueValueExists";
	String DEFINITION = "name exists or classification exists";
	
	class Default implements TaxonomyValueValueExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaxonomyValue taxonomyValue) {
			ComparisonResult result = executeDataRule(taxonomyValue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TaxonomyValue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TaxonomyValue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TaxonomyValue taxonomyValue) {
			try {
				return exists(MapperS.of(taxonomyValue).<FieldWithMetaString>map("getName", _taxonomyValue -> _taxonomyValue.getName())).orNullSafe(exists(MapperS.of(taxonomyValue).<TaxonomyClassification>mapC("getClassification", _taxonomyValue -> _taxonomyValue.getClassification())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TaxonomyValueValueExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaxonomyValue taxonomyValue) {
			return Collections.emptyList();
		}
	}
}
