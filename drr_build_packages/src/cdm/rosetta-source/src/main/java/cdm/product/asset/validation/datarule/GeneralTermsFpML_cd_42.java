package cdm.product.asset.validation.datarule;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.GeneralTerms;
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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("GeneralTermsFpML_cd_42")
@ImplementedBy(GeneralTermsFpML_cd_42.Default.class)
public interface GeneralTermsFpML_cd_42 extends Validator<GeneralTerms> {
	
	String NAME = "GeneralTermsFpML_cd_42";
	String DEFINITION = "if basketReferenceInformation is absent then substitution is absent";
	
	class Default implements GeneralTermsFpML_cd_42 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralTerms generalTerms) {
			ComparisonResult result = executeDataRule(generalTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GeneralTerms generalTerms) {
			try {
				if (notExists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation())).getOrDefault(false)) {
					return notExists(MapperS.of(generalTerms).<Boolean>map("getSubstitution", _generalTerms -> _generalTerms.getSubstitution()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralTermsFpML_cd_42 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralTerms generalTerms) {
			return Collections.emptyList();
		}
	}
}
