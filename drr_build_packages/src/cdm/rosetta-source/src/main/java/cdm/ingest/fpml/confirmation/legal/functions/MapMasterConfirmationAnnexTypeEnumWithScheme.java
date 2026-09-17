package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapMasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.MasterConfirmationAnnexType;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterConfirmationAnnexTypeEnumWithScheme.MapMasterConfirmationAnnexTypeEnumWithSchemeDefault.class)
public abstract class MapMasterConfirmationAnnexTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterConfirmationAnnexTypeEnum mapMasterConfirmationAnnexTypeEnum;

	/**
	* @param fpmlMasterConfirmationAnnexType 
	* @return masterConfirmationAnnexType 
	*/
	public FieldWithMetaMasterConfirmationAnnexTypeEnum evaluate(MasterConfirmationAnnexType fpmlMasterConfirmationAnnexType) {
		FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder masterConfirmationAnnexTypeBuilder = doEvaluate(fpmlMasterConfirmationAnnexType);
		
		final FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType;
		if (masterConfirmationAnnexTypeBuilder == null) {
			masterConfirmationAnnexType = null;
		} else {
			masterConfirmationAnnexType = masterConfirmationAnnexTypeBuilder.build();
			objectValidator.validate(FieldWithMetaMasterConfirmationAnnexTypeEnum.class, masterConfirmationAnnexType);
		}
		
		return masterConfirmationAnnexType;
	}

	protected abstract FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder doEvaluate(MasterConfirmationAnnexType fpmlMasterConfirmationAnnexType);

	public static class MapMasterConfirmationAnnexTypeEnumWithSchemeDefault extends MapMasterConfirmationAnnexTypeEnumWithScheme {
		@Override
		protected FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder doEvaluate(MasterConfirmationAnnexType fpmlMasterConfirmationAnnexType) {
			FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder masterConfirmationAnnexType = FieldWithMetaMasterConfirmationAnnexTypeEnum.builder();
			return assignOutput(masterConfirmationAnnexType, fpmlMasterConfirmationAnnexType);
		}
		
		protected FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder assignOutput(FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder masterConfirmationAnnexType, MasterConfirmationAnnexType fpmlMasterConfirmationAnnexType) {
			final MasterConfirmationAnnexTypeEnum withMetaArgument = mapMasterConfirmationAnnexTypeEnum.evaluate(MapperS.of(fpmlMasterConfirmationAnnexType).<String>map("getValue", _masterConfirmationAnnexType -> _masterConfirmationAnnexType.getValue()).get());
			masterConfirmationAnnexType = toBuilder(FieldWithMetaMasterConfirmationAnnexTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlMasterConfirmationAnnexType).<String>map("getMasterConfirmationAnnexTypeScheme", _masterConfirmationAnnexType -> _masterConfirmationAnnexType.getMasterConfirmationAnnexTypeScheme()).get())));
			
			return Optional.ofNullable(masterConfirmationAnnexType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
