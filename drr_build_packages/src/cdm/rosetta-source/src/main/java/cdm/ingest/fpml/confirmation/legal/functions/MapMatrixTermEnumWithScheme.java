package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapMatrixTermEnum;
import cdm.legaldocumentation.common.MatrixTermEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaMatrixTermEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.MatrixTerm;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMatrixTermEnumWithScheme.MapMatrixTermEnumWithSchemeDefault.class)
public abstract class MapMatrixTermEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMatrixTermEnum mapMatrixTermEnum;

	/**
	* @param fpmlMatrixTerm 
	* @return matrixTermEnum 
	*/
	public FieldWithMetaMatrixTermEnum evaluate(MatrixTerm fpmlMatrixTerm) {
		FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder matrixTermEnumBuilder = doEvaluate(fpmlMatrixTerm);
		
		final FieldWithMetaMatrixTermEnum matrixTermEnum;
		if (matrixTermEnumBuilder == null) {
			matrixTermEnum = null;
		} else {
			matrixTermEnum = matrixTermEnumBuilder.build();
			objectValidator.validate(FieldWithMetaMatrixTermEnum.class, matrixTermEnum);
		}
		
		return matrixTermEnum;
	}

	protected abstract FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder doEvaluate(MatrixTerm fpmlMatrixTerm);

	public static class MapMatrixTermEnumWithSchemeDefault extends MapMatrixTermEnumWithScheme {
		@Override
		protected FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder doEvaluate(MatrixTerm fpmlMatrixTerm) {
			FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder matrixTermEnum = FieldWithMetaMatrixTermEnum.builder();
			return assignOutput(matrixTermEnum, fpmlMatrixTerm);
		}
		
		protected FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder assignOutput(FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder matrixTermEnum, MatrixTerm fpmlMatrixTerm) {
			final MatrixTermEnum withMetaArgument = mapMatrixTermEnum.evaluate(MapperS.of(fpmlMatrixTerm).<String>map("getValue", matrixTerm -> matrixTerm.getValue()).get());
			matrixTermEnum = toBuilder(FieldWithMetaMatrixTermEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlMatrixTerm).<String>map("getMatrixTermScheme", matrixTerm -> matrixTerm.getMatrixTermScheme()).get())));
			
			return Optional.ofNullable(matrixTermEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
