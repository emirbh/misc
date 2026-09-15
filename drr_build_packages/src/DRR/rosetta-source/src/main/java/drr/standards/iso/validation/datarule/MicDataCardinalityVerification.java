package drr.standards.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iso.MicData;
import drr.standards.iso.MicTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MicDataCardinalityVerification")
@ImplementedBy(MicDataCardinalityVerification.Default.class)
public interface MicDataCardinalityVerification extends Validator<MicData> {
	
	String NAME = "MicDataCardinalityVerification";
	String DEFINITION = "if micValidation is absent or micValidation = True then micType exists";
	
	class Default implements MicDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData micData) {
			ComparisonResult result = executeDataRule(micData);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MicData", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MicData", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MicData micData) {
			try {
				if (notExists(MapperS.of(micData).<Boolean>map("getMicValidation", _micData -> _micData.getMicValidation())).orNullSafe(areEqual(MapperS.of(micData).<Boolean>map("getMicValidation", _micData -> _micData.getMicValidation()), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(micData).<MicTypeEnum>map("getMicType", _micData -> _micData.getMicType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MicDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData micData) {
			return Collections.emptyList();
		}
	}
}
