package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapMasterConfirmationTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.MasterConfirmationType;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterConfirmationTypeEnumWithScheme.MapMasterConfirmationTypeEnumWithSchemeDefault.class)
public abstract class MapMasterConfirmationTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterConfirmationTypeEnum mapMasterConfirmationTypeEnum;

	/**
	* @param fpmlMasterConfirmationType 
	* @return masterConfirmationTypeEnum 
	*/
	public FieldWithMetaMasterConfirmationTypeEnum evaluate(MasterConfirmationType fpmlMasterConfirmationType) {
		FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder masterConfirmationTypeEnumBuilder = doEvaluate(fpmlMasterConfirmationType);
		
		final FieldWithMetaMasterConfirmationTypeEnum masterConfirmationTypeEnum;
		if (masterConfirmationTypeEnumBuilder == null) {
			masterConfirmationTypeEnum = null;
		} else {
			masterConfirmationTypeEnum = masterConfirmationTypeEnumBuilder.build();
			objectValidator.validate(FieldWithMetaMasterConfirmationTypeEnum.class, masterConfirmationTypeEnum);
		}
		
		return masterConfirmationTypeEnum;
	}

	protected abstract FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder doEvaluate(MasterConfirmationType fpmlMasterConfirmationType);

	public static class MapMasterConfirmationTypeEnumWithSchemeDefault extends MapMasterConfirmationTypeEnumWithScheme {
		@Override
		protected FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder doEvaluate(MasterConfirmationType fpmlMasterConfirmationType) {
			FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder masterConfirmationTypeEnum = FieldWithMetaMasterConfirmationTypeEnum.builder();
			return assignOutput(masterConfirmationTypeEnum, fpmlMasterConfirmationType);
		}
		
		protected FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder assignOutput(FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder masterConfirmationTypeEnum, MasterConfirmationType fpmlMasterConfirmationType) {
			final MasterConfirmationTypeEnum withMetaArgument = mapMasterConfirmationTypeEnum.evaluate(MapperS.of(fpmlMasterConfirmationType).<String>map("getValue", masterConfirmationType -> masterConfirmationType.getValue()).get());
			masterConfirmationTypeEnum = toBuilder(FieldWithMetaMasterConfirmationTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlMasterConfirmationType).<String>map("getMasterConfirmationTypeScheme", masterConfirmationType -> masterConfirmationType.getMasterConfirmationTypeScheme()).get())));
			
			return Optional.ofNullable(masterConfirmationTypeEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
