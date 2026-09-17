package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.observable.asset.FallbackReferencePrice;
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
@RosettaDataRule("FallbackReferencePriceFallbackCalculationAgent")
@ImplementedBy(FallbackReferencePriceFallbackCalculationAgent.Default.class)
public interface FallbackReferencePriceFallbackCalculationAgent extends Validator<FallbackReferencePrice> {
	
	String NAME = "FallbackReferencePriceFallbackCalculationAgent";
	String DEFINITION = "if calculationAgentDetermination -> calculationAgentParty exists then calculationAgentDetermination -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentFallback";
	
	class Default implements FallbackReferencePriceFallbackCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
			ComparisonResult result = executeDataRule(fallbackReferencePrice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FallbackReferencePrice fallbackReferencePrice) {
			try {
				if (exists(MapperS.of(fallbackReferencePrice).<CalculationAgent>map("getCalculationAgentDetermination", _fallbackReferencePrice -> _fallbackReferencePrice.getCalculationAgentDetermination()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty())).getOrDefault(false)) {
					return areEqual(MapperS.of(fallbackReferencePrice).<CalculationAgent>map("getCalculationAgentDetermination", _fallbackReferencePrice -> _fallbackReferencePrice.getCalculationAgentDetermination()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_FALLBACK), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FallbackReferencePriceFallbackCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
			return Collections.emptyList();
		}
	}
}
