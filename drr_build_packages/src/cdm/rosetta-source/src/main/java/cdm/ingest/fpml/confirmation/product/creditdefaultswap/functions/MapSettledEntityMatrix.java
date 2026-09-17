package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.product.asset.SettledEntityMatrix;
import cdm.product.asset.SettledEntityMatrixSourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.cd.MatrixSource;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettledEntityMatrix.MapSettledEntityMatrixDefault.class)
public abstract class MapSettledEntityMatrix implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlSettledEntityMatrix 
	* @return settledEntityMatrix 
	*/
	public SettledEntityMatrix evaluate(fpml.consolidated.cd.SettledEntityMatrix fpmlSettledEntityMatrix) {
		SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrixBuilder = doEvaluate(fpmlSettledEntityMatrix);
		
		final SettledEntityMatrix settledEntityMatrix;
		if (settledEntityMatrixBuilder == null) {
			settledEntityMatrix = null;
		} else {
			settledEntityMatrix = settledEntityMatrixBuilder.build();
			objectValidator.validate(SettledEntityMatrix.class, settledEntityMatrix);
		}
		
		return settledEntityMatrix;
	}

	protected abstract SettledEntityMatrix.SettledEntityMatrixBuilder doEvaluate(fpml.consolidated.cd.SettledEntityMatrix fpmlSettledEntityMatrix);

	public static class MapSettledEntityMatrixDefault extends MapSettledEntityMatrix {
		@Override
		protected SettledEntityMatrix.SettledEntityMatrixBuilder doEvaluate(fpml.consolidated.cd.SettledEntityMatrix fpmlSettledEntityMatrix) {
			SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix = SettledEntityMatrix.builder();
			return assignOutput(settledEntityMatrix, fpmlSettledEntityMatrix);
		}
		
		protected SettledEntityMatrix.SettledEntityMatrixBuilder assignOutput(SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix, fpml.consolidated.cd.SettledEntityMatrix fpmlSettledEntityMatrix) {
			settledEntityMatrix = toBuilder(SettledEntityMatrix.builder()
				.setMatrixSourceValue(MapperS.of(fpmlSettledEntityMatrix).<MatrixSource>map("getMatrixSource", _settledEntityMatrix -> _settledEntityMatrix.getMatrixSource()).<String>map("getValue", matrixSource -> matrixSource.getValue()).checkedMap("to-enum", SettledEntityMatrixSourceEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setPublicationDate(MapperS.of(fpmlSettledEntityMatrix).<ZonedDateTime>map("getPublicationDate", _settledEntityMatrix -> _settledEntityMatrix.getPublicationDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build(), () -> SettledEntityMatrix.builder());
			
			settledEntityMatrix
				.getOrCreateMatrixSource()
				.getOrCreateMeta().setScheme(MapperS.of(fpmlSettledEntityMatrix).<MatrixSource>map("getMatrixSource", _settledEntityMatrix -> _settledEntityMatrix.getMatrixSource()).<String>map("getSettledEntityMatrixSourceScheme", matrixSource -> matrixSource.getSettledEntityMatrixSourceScheme()).get());
			
			return Optional.ofNullable(settledEntityMatrix)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
