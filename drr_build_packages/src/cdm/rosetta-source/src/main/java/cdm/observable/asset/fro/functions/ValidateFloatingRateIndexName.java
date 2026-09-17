package cdm.observable.asset.fro.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import cdm.observable.asset.fro.FloatingRateIndexDefinition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValidateFloatingRateIndexName.ValidateFloatingRateIndexNameDefault.class)
public abstract class ValidateFloatingRateIndexName implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingRateIndexMetadata floatingRateIndexMetadata;

	/**
	* @param floatingRateIndexName The name of the floating rate index.
	* @param contractualDefs The contractual definitions to validate against.
	* @return isValid True if this is a floating rate index name that is valid.
	*/
	public Boolean evaluate(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
		Boolean isValid = doEvaluate(floatingRateIndexName, contractualDefs);
		
		return isValid;
	}

	protected abstract Boolean doEvaluate(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs);

	protected abstract MapperS<? extends FloatingRateIndexDefinition> defs(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs);

	protected abstract MapperS<Boolean> isPresent(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs);

	protected abstract MapperS<Boolean> defsOk(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs);

	protected abstract MapperS<Boolean> okDefs(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs);

	public static class ValidateFloatingRateIndexNameDefault extends ValidateFloatingRateIndexName {
		@Override
		protected Boolean doEvaluate(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			Boolean isValid = null;
			return assignOutput(isValid, floatingRateIndexName, contractualDefs);
		}
		
		protected Boolean assignOutput(Boolean isValid, FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			isValid = okDefs(floatingRateIndexName, contractualDefs).get();
			
			return isValid;
		}
		
		@Override
		protected MapperS<? extends FloatingRateIndexDefinition> defs(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			return MapperS.of(floatingRateIndexMetadata.evaluate(floatingRateIndexName));
		}
		
		@Override
		protected MapperS<Boolean> isPresent(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			return exists(defs(floatingRateIndexName, contractualDefs)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> defsOk(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			return contains(defs(floatingRateIndexName, contractualDefs).<ContractualDefinition>mapC("getSupportedDefinition", floatingRateIndexDefinition -> floatingRateIndexDefinition.getSupportedDefinition()).<ContractualDefinitionIdentifier>map("getContractualDefinitionIdentifier", contractualDefinition -> contractualDefinition.getContractualDefinitionIdentifier()).<ContractualDefinitionsEnum>map("getContractualDefinitionType", contractualDefinitionIdentifier -> contractualDefinitionIdentifier.getContractualDefinitionType()), MapperS.of(contractualDefs)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> okDefs(FloatingRateIndexEnum floatingRateIndexName, ContractualDefinitionsEnum contractualDefs) {
			if (exists(MapperS.of(contractualDefs)).getOrDefault(false)) {
				return defsOk(floatingRateIndexName, contractualDefs);
			}
			return exists(defs(floatingRateIndexName, contractualDefs)).asMapper();
		}
	}
}
