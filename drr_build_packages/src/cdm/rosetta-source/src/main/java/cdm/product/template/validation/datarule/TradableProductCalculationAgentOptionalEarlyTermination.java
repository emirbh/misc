package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionalEarlyTermination;
import cdm.product.template.TerminationProvision;
import cdm.product.template.TradableProduct;
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
@RosettaDataRule("TradableProductCalculationAgentOptionalEarlyTermination")
@ImplementedBy(TradableProductCalculationAgentOptionalEarlyTermination.Default.class)
public interface TradableProductCalculationAgentOptionalEarlyTermination extends Validator<TradableProduct> {
	
	String NAME = "TradableProductCalculationAgentOptionalEarlyTermination";
	String DEFINITION = "if product -> economicTerms -> terminationProvision -> earlyTerminationProvision -> optionalEarlyTermination -> calculationAgent -> calculationAgentParty exists then ancillaryParty -> role contains AncillaryRoleEnum -> CalculationAgentOptionalEarlyTermination and if ancillaryParty -> role contains AncillaryRoleEnum -> CalculationAgentOptionalEarlyTermination then product -> economicTerms -> terminationProvision -> earlyTerminationProvision -> optionalEarlyTermination -> calculationAgent -> calculationAgentParty exists";
	
	class Default implements TradableProductCalculationAgentOptionalEarlyTermination {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			ComparisonResult result = executeDataRule(tradableProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
			try {
				if (exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).<CalculationAgent>map("getCalculationAgent", optionalEarlyTermination -> optionalEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION)).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).<CalculationAgent>map("getCalculationAgent", optionalEarlyTermination -> optionalEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductCalculationAgentOptionalEarlyTermination {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			return Collections.emptyList();
		}
	}
}
