package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.base.staticdata.asset.common.functions.DifferentOrdinalsCondition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TaxonomyDifferentOrdinals")
@ImplementedBy(TaxonomyDifferentOrdinals.Default.class)
public interface TaxonomyDifferentOrdinals extends Validator<Taxonomy> {
	
	String NAME = "TaxonomyDifferentOrdinals";
	String DEFINITION = "if value -> classification -> ordinal exists then DifferentOrdinalsCondition";
	
	class Default implements TaxonomyDifferentOrdinals {
	
		@Inject protected DifferentOrdinalsCondition differentOrdinalsCondition;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Taxonomy taxonomy) {
			ComparisonResult result = executeDataRule(taxonomy);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Taxonomy", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Taxonomy", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Taxonomy taxonomy) {
			try {
				if (exists(MapperS.of(taxonomy).<TaxonomyValue>map("getValue", _taxonomy -> _taxonomy.getValue()).<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification()).<Integer>map("getOrdinal", taxonomyClassification -> taxonomyClassification.getOrdinal())).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(differentOrdinalsCondition.evaluate(taxonomy)));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TaxonomyDifferentOrdinals {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Taxonomy taxonomy) {
			return Collections.emptyList();
		}
	}
}
