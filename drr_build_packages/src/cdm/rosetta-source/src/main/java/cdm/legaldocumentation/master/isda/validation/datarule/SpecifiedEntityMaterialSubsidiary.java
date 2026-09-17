package cdm.legaldocumentation.master.isda.validation.datarule;

import cdm.legaldocumentation.common.SpecifiedEntityTermsEnum;
import cdm.legaldocumentation.master.isda.SpecifiedEntity;
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
@RosettaDataRule("SpecifiedEntityMaterialSubsidiary")
@ImplementedBy(SpecifiedEntityMaterialSubsidiary.Default.class)
public interface SpecifiedEntityMaterialSubsidiary extends Validator<SpecifiedEntity> {
	
	String NAME = "SpecifiedEntityMaterialSubsidiary";
	String DEFINITION = "if specifiedEntityTerms = SpecifiedEntityTermsEnum -> MaterialSubsidiary then materialSubsidiaryTerms exists";
	
	class Default implements SpecifiedEntityMaterialSubsidiary {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedEntity specifiedEntity) {
			ComparisonResult result = executeDataRule(specifiedEntity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecifiedEntity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecifiedEntity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SpecifiedEntity specifiedEntity) {
			try {
				if (areEqual(MapperS.of(specifiedEntity).<SpecifiedEntityTermsEnum>map("getSpecifiedEntityTerms", _specifiedEntity -> _specifiedEntity.getSpecifiedEntityTerms()), MapperS.of(SpecifiedEntityTermsEnum.MATERIAL_SUBSIDIARY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(specifiedEntity).<String>map("getMaterialSubsidiaryTerms", _specifiedEntity -> _specifiedEntity.getMaterialSubsidiaryTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SpecifiedEntityMaterialSubsidiary {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedEntity specifiedEntity) {
			return Collections.emptyList();
		}
	}
}
