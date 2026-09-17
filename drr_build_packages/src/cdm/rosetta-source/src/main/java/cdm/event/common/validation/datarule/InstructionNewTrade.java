package cdm.event.common.validation.datarule;

import cdm.event.common.ExecutionInstruction;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
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
@RosettaDataRule("InstructionNewTrade")
@ImplementedBy(InstructionNewTrade.Default.class)
public interface InstructionNewTrade extends Validator<Instruction> {
	
	String NAME = "InstructionNewTrade";
	String DEFINITION = "(if primitiveInstruction -> execution exists then before is absent else True) and (if before is absent then primitiveInstruction -> execution exists else True)";
	
	class Default implements InstructionNewTrade {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instruction instruction) {
			ComparisonResult result = executeDataRule(instruction);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Instruction", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Instruction", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Instruction instruction) {
			try {
				final ComparisonResult ifThenElseResult0;
				if (exists(MapperS.of(instruction).<PrimitiveInstruction>map("getPrimitiveInstruction", _instruction -> _instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution())).getOrDefault(false)) {
					ifThenElseResult0 = notExists(MapperS.of(instruction).<ReferenceWithMetaTradeState>map("getBefore", _instruction -> _instruction.getBefore()));
				} else {
					ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				final ComparisonResult ifThenElseResult1;
				if (notExists(MapperS.of(instruction).<ReferenceWithMetaTradeState>map("getBefore", _instruction -> _instruction.getBefore())).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(instruction).<PrimitiveInstruction>map("getPrimitiveInstruction", _instruction -> _instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution()));
				} else {
					ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstructionNewTrade {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instruction instruction) {
			return Collections.emptyList();
		}
	}
}
