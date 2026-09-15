package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapMatrixTypeEnum;
import cdm.legaldocumentation.common.MatrixTypeEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaMatrixTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.MatrixType;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMatrixTypeEnumWithScheme.MapMatrixTypeEnumWithSchemeDefault.class)
public abstract class MapMatrixTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMatrixTypeEnum mapMatrixTypeEnum;

	/**
	* @param fpmlMatrixType 
	* @return matrixTypeEnum 
	*/
	public FieldWithMetaMatrixTypeEnum evaluate(MatrixType fpmlMatrixType) {
		FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder matrixTypeEnumBuilder = doEvaluate(fpmlMatrixType);
		
		final FieldWithMetaMatrixTypeEnum matrixTypeEnum;
		if (matrixTypeEnumBuilder == null) {
			matrixTypeEnum = null;
		} else {
			matrixTypeEnum = matrixTypeEnumBuilder.build();
			objectValidator.validate(FieldWithMetaMatrixTypeEnum.class, matrixTypeEnum);
		}
		
		return matrixTypeEnum;
	}

	protected abstract FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder doEvaluate(MatrixType fpmlMatrixType);

	public static class MapMatrixTypeEnumWithSchemeDefault extends MapMatrixTypeEnumWithScheme {
		@Override
		protected FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder doEvaluate(MatrixType fpmlMatrixType) {
			FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder matrixTypeEnum = FieldWithMetaMatrixTypeEnum.builder();
			return assignOutput(matrixTypeEnum, fpmlMatrixType);
		}
		
		protected FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder assignOutput(FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder matrixTypeEnum, MatrixType fpmlMatrixType) {
			final MatrixTypeEnum withMetaArgument = mapMatrixTypeEnum.evaluate(MapperS.of(fpmlMatrixType).<String>map("getValue", matrixType -> matrixType.getValue()).get());
			matrixTypeEnum = toBuilder(FieldWithMetaMatrixTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlMatrixType).<String>map("getMatrixTypeScheme", matrixType -> matrixType.getMatrixTypeScheme()).get())));
			
			return Optional.ofNullable(matrixTypeEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
