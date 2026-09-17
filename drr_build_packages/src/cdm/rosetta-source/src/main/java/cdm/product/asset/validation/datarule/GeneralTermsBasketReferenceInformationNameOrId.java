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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("GeneralTermsBasketReferenceInformationNameOrId")
@ImplementedBy(GeneralTermsBasketReferenceInformationNameOrId.Default.class)
public interface GeneralTermsBasketReferenceInformationNameOrId extends Validator<GeneralTerms> {
	
	String NAME = "GeneralTermsBasketReferenceInformationNameOrId";
	String DEFINITION = "if basketReferenceInformation exists then basketReferenceInformation -> basketName exists or basketReferenceInformation -> basketId exists";
	
	class Default implements GeneralTermsBasketReferenceInformationNameOrId {
	
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
				if (exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation())).getOrDefault(false)) {
					return exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>map("getBasketName", basketReferenceInformation -> basketReferenceInformation.getBasketName())).orNullSafe(exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralTermsBasketReferenceInformationNameOrId {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralTerms generalTerms) {
			return Collections.emptyList();
		}
	}
}
