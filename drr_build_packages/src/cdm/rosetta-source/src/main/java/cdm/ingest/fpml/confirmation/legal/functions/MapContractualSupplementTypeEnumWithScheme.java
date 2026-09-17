package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapContractualSupplementTypeEnum;
import cdm.legaldocumentation.common.ContractualSupplementTypeEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualSupplementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.ContractualSupplement;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapContractualSupplementTypeEnumWithScheme.MapContractualSupplementTypeEnumWithSchemeDefault.class)
public abstract class MapContractualSupplementTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualSupplementTypeEnum mapContractualSupplementTypeEnum;

	/**
	* @param fpmlContractualSupplement 
	* @return contractualSupplementTypeEnum 
	*/
	public FieldWithMetaContractualSupplementTypeEnum evaluate(ContractualSupplement fpmlContractualSupplement) {
		FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder contractualSupplementTypeEnumBuilder = doEvaluate(fpmlContractualSupplement);
		
		final FieldWithMetaContractualSupplementTypeEnum contractualSupplementTypeEnum;
		if (contractualSupplementTypeEnumBuilder == null) {
			contractualSupplementTypeEnum = null;
		} else {
			contractualSupplementTypeEnum = contractualSupplementTypeEnumBuilder.build();
			objectValidator.validate(FieldWithMetaContractualSupplementTypeEnum.class, contractualSupplementTypeEnum);
		}
		
		return contractualSupplementTypeEnum;
	}

	protected abstract FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder doEvaluate(ContractualSupplement fpmlContractualSupplement);

	public static class MapContractualSupplementTypeEnumWithSchemeDefault extends MapContractualSupplementTypeEnumWithScheme {
		@Override
		protected FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder doEvaluate(ContractualSupplement fpmlContractualSupplement) {
			FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder contractualSupplementTypeEnum = FieldWithMetaContractualSupplementTypeEnum.builder();
			return assignOutput(contractualSupplementTypeEnum, fpmlContractualSupplement);
		}
		
		protected FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder assignOutput(FieldWithMetaContractualSupplementTypeEnum.FieldWithMetaContractualSupplementTypeEnumBuilder contractualSupplementTypeEnum, ContractualSupplement fpmlContractualSupplement) {
			final ContractualSupplementTypeEnum withMetaArgument = mapContractualSupplementTypeEnum.evaluate(MapperS.of(fpmlContractualSupplement).<String>map("getValue", contractualSupplement -> contractualSupplement.getValue()).get());
			contractualSupplementTypeEnum = toBuilder(FieldWithMetaContractualSupplementTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlContractualSupplement).<String>map("getContractualSupplementScheme", contractualSupplement -> contractualSupplement.getContractualSupplementScheme()).get())));
			
			return Optional.ofNullable(contractualSupplementTypeEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
