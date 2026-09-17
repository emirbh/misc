package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.event.common.TermsChangeInstruction;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.template.NonTransferableProduct;
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
@RosettaDataRule("TermsChangeInstructionAtLeastOneOf")
@ImplementedBy(TermsChangeInstructionAtLeastOneOf.Default.class)
public interface TermsChangeInstructionAtLeastOneOf extends Validator<TermsChangeInstruction> {
	
	String NAME = "TermsChangeInstructionAtLeastOneOf";
	String DEFINITION = "(product exists or ancillaryParty exists or adjustment exists)";
	
	class Default implements TermsChangeInstructionAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermsChangeInstruction termsChangeInstruction) {
			ComparisonResult result = executeDataRule(termsChangeInstruction);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TermsChangeInstruction", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TermsChangeInstruction", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TermsChangeInstruction termsChangeInstruction) {
			try {
				return exists(MapperS.of(termsChangeInstruction).<NonTransferableProduct>map("getProduct", _termsChangeInstruction -> _termsChangeInstruction.getProduct())).orNullSafe(exists(MapperS.of(termsChangeInstruction).<AncillaryParty>mapC("getAncillaryParty", _termsChangeInstruction -> _termsChangeInstruction.getAncillaryParty()))).orNullSafe(exists(MapperS.of(termsChangeInstruction).<NotionalAdjustmentEnum>map("getAdjustment", _termsChangeInstruction -> _termsChangeInstruction.getAdjustment())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TermsChangeInstructionAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermsChangeInstruction termsChangeInstruction) {
			return Collections.emptyList();
		}
	}
}
