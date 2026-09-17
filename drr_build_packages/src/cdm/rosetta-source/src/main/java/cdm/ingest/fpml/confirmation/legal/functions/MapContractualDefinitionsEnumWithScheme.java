package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapContractualDefinitionsEnum;
import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.ContractualDefinitions;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapContractualDefinitionsEnumWithScheme.MapContractualDefinitionsEnumWithSchemeDefault.class)
public abstract class MapContractualDefinitionsEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualDefinitionsEnum mapContractualDefinitionsEnum;

	/**
	* @param fpmlContractualDefinitions 
	* @return contractualDefinitionsEnum 
	*/
	public FieldWithMetaContractualDefinitionsEnum evaluate(ContractualDefinitions fpmlContractualDefinitions) {
		FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder contractualDefinitionsEnumBuilder = doEvaluate(fpmlContractualDefinitions);
		
		final FieldWithMetaContractualDefinitionsEnum contractualDefinitionsEnum;
		if (contractualDefinitionsEnumBuilder == null) {
			contractualDefinitionsEnum = null;
		} else {
			contractualDefinitionsEnum = contractualDefinitionsEnumBuilder.build();
			objectValidator.validate(FieldWithMetaContractualDefinitionsEnum.class, contractualDefinitionsEnum);
		}
		
		return contractualDefinitionsEnum;
	}

	protected abstract FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder doEvaluate(ContractualDefinitions fpmlContractualDefinitions);

	public static class MapContractualDefinitionsEnumWithSchemeDefault extends MapContractualDefinitionsEnumWithScheme {
		@Override
		protected FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder doEvaluate(ContractualDefinitions fpmlContractualDefinitions) {
			FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder contractualDefinitionsEnum = FieldWithMetaContractualDefinitionsEnum.builder();
			return assignOutput(contractualDefinitionsEnum, fpmlContractualDefinitions);
		}
		
		protected FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder assignOutput(FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder contractualDefinitionsEnum, ContractualDefinitions fpmlContractualDefinitions) {
			final ContractualDefinitionsEnum withMetaArgument = mapContractualDefinitionsEnum.evaluate(MapperS.of(fpmlContractualDefinitions).<String>map("getValue", contractualDefinitions -> contractualDefinitions.getValue()).get());
			contractualDefinitionsEnum = toBuilder(FieldWithMetaContractualDefinitionsEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlContractualDefinitions).<String>map("getContractualDefinitionsScheme", contractualDefinitions -> contractualDefinitions.getContractualDefinitionsScheme()).get())));
			
			return Optional.ofNullable(contractualDefinitionsEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
