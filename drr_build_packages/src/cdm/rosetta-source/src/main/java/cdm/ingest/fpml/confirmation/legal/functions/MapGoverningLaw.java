package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.legaldocumentation.common.GoverningLawEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaGoverningLawEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.GoverningLaw;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGoverningLaw.MapGoverningLawDefault.class)
public abstract class MapGoverningLaw implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlGoverningLaw 
	* @return governingLawEnum 
	*/
	public FieldWithMetaGoverningLawEnum evaluate(GoverningLaw fpmlGoverningLaw) {
		FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder governingLawEnumBuilder = doEvaluate(fpmlGoverningLaw);
		
		final FieldWithMetaGoverningLawEnum governingLawEnum;
		if (governingLawEnumBuilder == null) {
			governingLawEnum = null;
		} else {
			governingLawEnum = governingLawEnumBuilder.build();
			objectValidator.validate(FieldWithMetaGoverningLawEnum.class, governingLawEnum);
		}
		
		return governingLawEnum;
	}

	protected abstract FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder doEvaluate(GoverningLaw fpmlGoverningLaw);

	public static class MapGoverningLawDefault extends MapGoverningLaw {
		@Override
		protected FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder doEvaluate(GoverningLaw fpmlGoverningLaw) {
			FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder governingLawEnum = FieldWithMetaGoverningLawEnum.builder();
			return assignOutput(governingLawEnum, fpmlGoverningLaw);
		}
		
		protected FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder assignOutput(FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder governingLawEnum, GoverningLaw fpmlGoverningLaw) {
			final GoverningLawEnum _governingLawEnum = MapperS.of(fpmlGoverningLaw).<String>map("getValue", governingLaw -> governingLaw.getValue()).checkedMap("to-enum", GoverningLawEnum::fromDisplayName, IllegalArgumentException.class).get();
			if (_governingLawEnum == null) {
				governingLawEnum = toBuilder(FieldWithMetaGoverningLawEnum.builder().build());
			} else {
				governingLawEnum = toBuilder(FieldWithMetaGoverningLawEnum.builder().setValue(_governingLawEnum).build());
			}
			
			return Optional.ofNullable(governingLawEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
