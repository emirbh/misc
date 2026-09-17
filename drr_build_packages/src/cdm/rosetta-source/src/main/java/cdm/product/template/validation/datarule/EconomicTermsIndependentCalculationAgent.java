package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.EconomicTerms;
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
@RosettaDataRule("EconomicTermsIndependentCalculationAgent")
@ImplementedBy(EconomicTermsIndependentCalculationAgent.Default.class)
public interface EconomicTermsIndependentCalculationAgent extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsIndependentCalculationAgent";
	String DEFINITION = "if calculationAgent -> calculationAgentParty exists then calculationAgent -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentIndependent";
	
	class Default implements EconomicTermsIndependentCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				if (exists(MapperS.of(economicTerms).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty())).getOrDefault(false)) {
					return areEqual(MapperS.of(economicTerms).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsIndependentCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
