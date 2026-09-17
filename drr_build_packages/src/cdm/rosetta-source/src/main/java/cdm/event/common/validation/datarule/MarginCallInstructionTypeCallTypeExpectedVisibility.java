package cdm.event.common.validation.datarule;

import cdm.event.common.CallTypeEnum;
import cdm.event.common.MarginCallInstructionType;
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
@RosettaDataRule("MarginCallInstructionTypeCallTypeExpectedVisibility")
@ImplementedBy(MarginCallInstructionTypeCallTypeExpectedVisibility.Default.class)
public interface MarginCallInstructionTypeCallTypeExpectedVisibility extends Validator<MarginCallInstructionType> {
	
	String NAME = "MarginCallInstructionTypeCallTypeExpectedVisibility";
	String DEFINITION = "if callType = CallTypeEnum -> ExpectedCall then visibilityIndicator exists";
	
	class Default implements MarginCallInstructionTypeCallTypeExpectedVisibility {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallInstructionType marginCallInstructionType) {
			ComparisonResult result = executeDataRule(marginCallInstructionType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallInstructionType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallInstructionType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MarginCallInstructionType marginCallInstructionType) {
			try {
				if (areEqual(MapperS.of(marginCallInstructionType).<CallTypeEnum>map("getCallType", _marginCallInstructionType -> _marginCallInstructionType.getCallType()), MapperS.of(CallTypeEnum.EXPECTED_CALL), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(marginCallInstructionType).<Boolean>map("getVisibilityIndicator", _marginCallInstructionType -> _marginCallInstructionType.getVisibilityIndicator()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MarginCallInstructionTypeCallTypeExpectedVisibility {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallInstructionType marginCallInstructionType) {
			return Collections.emptyList();
		}
	}
}
