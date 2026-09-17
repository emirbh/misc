package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapMasterAgreementTypeEnum;
import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.MasterAgreementType;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterAgreementTypeEnumWithScheme.MapMasterAgreementTypeEnumWithSchemeDefault.class)
public abstract class MapMasterAgreementTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterAgreementTypeEnum mapMasterAgreementTypeEnum;

	/**
	* @param fpmlMasterAgreementType 
	* @return masterAgreementTypeEnum 
	*/
	public FieldWithMetaMasterAgreementTypeEnum evaluate(MasterAgreementType fpmlMasterAgreementType) {
		FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder masterAgreementTypeEnumBuilder = doEvaluate(fpmlMasterAgreementType);
		
		final FieldWithMetaMasterAgreementTypeEnum masterAgreementTypeEnum;
		if (masterAgreementTypeEnumBuilder == null) {
			masterAgreementTypeEnum = null;
		} else {
			masterAgreementTypeEnum = masterAgreementTypeEnumBuilder.build();
			objectValidator.validate(FieldWithMetaMasterAgreementTypeEnum.class, masterAgreementTypeEnum);
		}
		
		return masterAgreementTypeEnum;
	}

	protected abstract FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder doEvaluate(MasterAgreementType fpmlMasterAgreementType);

	public static class MapMasterAgreementTypeEnumWithSchemeDefault extends MapMasterAgreementTypeEnumWithScheme {
		@Override
		protected FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder doEvaluate(MasterAgreementType fpmlMasterAgreementType) {
			FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder masterAgreementTypeEnum = FieldWithMetaMasterAgreementTypeEnum.builder();
			return assignOutput(masterAgreementTypeEnum, fpmlMasterAgreementType);
		}
		
		protected FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder assignOutput(FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder masterAgreementTypeEnum, MasterAgreementType fpmlMasterAgreementType) {
			final MasterAgreementTypeEnum withMetaArgument = mapMasterAgreementTypeEnum.evaluate(MapperS.of(fpmlMasterAgreementType).<String>map("getValue", masterAgreementType -> masterAgreementType.getValue()).get());
			masterAgreementTypeEnum = toBuilder(FieldWithMetaMasterAgreementTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlMasterAgreementType).<String>map("getMasterAgreementTypeScheme", masterAgreementType -> masterAgreementType.getMasterAgreementTypeScheme()).get())));
			
			return Optional.ofNullable(masterAgreementTypeEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
