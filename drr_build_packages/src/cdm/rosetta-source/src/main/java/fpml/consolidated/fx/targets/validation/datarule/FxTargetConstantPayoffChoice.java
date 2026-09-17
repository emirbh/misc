package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetConstantPayoff;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PositiveMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetConstantPayoffChoice")
@ImplementedBy(FxTargetConstantPayoffChoice.Default.class)
public interface FxTargetConstantPayoffChoice extends Validator<FxTargetConstantPayoff> {
	
	String NAME = "FxTargetConstantPayoffChoice";
	String DEFINITION = "if fixingAdjustment exists then payerPartyReference is absent and receiverPartyReference is absent and payment is absent and payerAccountReference is absent and receiverAccountReference is absent else if payerPartyReference exists or payment exists then payerPartyReference exists and payment exists and fixingAdjustment is absent else False";
	
	class Default implements FxTargetConstantPayoffChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoff fxTargetConstantPayoff) {
			ComparisonResult result = executeDataRule(fxTargetConstantPayoff);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoff", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoff", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetConstantPayoff fxTargetConstantPayoff) {
			try {
				if (exists(MapperS.of(fxTargetConstantPayoff).<BigDecimal>map("getFixingAdjustment", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getFixingAdjustment())).getOrDefault(false)) {
					return notExists(MapperS.of(fxTargetConstantPayoff).<PartyReference>map("getPayerPartyReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayerPartyReference())).andNullSafe(notExists(MapperS.of(fxTargetConstantPayoff).<PartyReference>map("getReceiverPartyReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getReceiverPartyReference()))).andNullSafe(notExists(MapperS.of(fxTargetConstantPayoff).<PositiveMoney>map("getPayment", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayment()))).andNullSafe(notExists(MapperS.of(fxTargetConstantPayoff).<AccountReference>map("getPayerAccountReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayerAccountReference()))).andNullSafe(notExists(MapperS.of(fxTargetConstantPayoff).<AccountReference>map("getReceiverAccountReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getReceiverAccountReference())));
				}
				if (exists(MapperS.of(fxTargetConstantPayoff).<PartyReference>map("getPayerPartyReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayerPartyReference())).orNullSafe(exists(MapperS.of(fxTargetConstantPayoff).<PositiveMoney>map("getPayment", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayment()))).getOrDefault(false)) {
					return exists(MapperS.of(fxTargetConstantPayoff).<PartyReference>map("getPayerPartyReference", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayerPartyReference())).andNullSafe(exists(MapperS.of(fxTargetConstantPayoff).<PositiveMoney>map("getPayment", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getPayment()))).andNullSafe(notExists(MapperS.of(fxTargetConstantPayoff).<BigDecimal>map("getFixingAdjustment", _fxTargetConstantPayoff -> _fxTargetConstantPayoff.getFixingAdjustment())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetConstantPayoffChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoff fxTargetConstantPayoff) {
			return Collections.emptyList();
		}
	}
}
