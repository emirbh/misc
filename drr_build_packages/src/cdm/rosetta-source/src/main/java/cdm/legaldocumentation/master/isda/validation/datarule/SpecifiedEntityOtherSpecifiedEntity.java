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
@RosettaDataRule("SpecifiedEntityOtherSpecifiedEntity")
@ImplementedBy(SpecifiedEntityOtherSpecifiedEntity.Default.class)
public interface SpecifiedEntityOtherSpecifiedEntity extends Validator<SpecifiedEntity> {
	
	String NAME = "SpecifiedEntityOtherSpecifiedEntity";
	String DEFINITION = "if specifiedEntityTerms = SpecifiedEntityTermsEnum -> OtherSpecifiedEntity then otherSpecifiedEntityTerms exists";
	
	class Default implements SpecifiedEntityOtherSpecifiedEntity {
	
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
				if (areEqual(MapperS.of(specifiedEntity).<SpecifiedEntityTermsEnum>map("getSpecifiedEntityTerms", _specifiedEntity -> _specifiedEntity.getSpecifiedEntityTerms()), MapperS.of(SpecifiedEntityTermsEnum.OTHER_SPECIFIED_ENTITY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(specifiedEntity).<String>map("getOtherSpecifiedEntityTerms", _specifiedEntity -> _specifiedEntity.getOtherSpecifiedEntityTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SpecifiedEntityOtherSpecifiedEntity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedEntity specifiedEntity) {
			return Collections.emptyList();
		}
	}
}
