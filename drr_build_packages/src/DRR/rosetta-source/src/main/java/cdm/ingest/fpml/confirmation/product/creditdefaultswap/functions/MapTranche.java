package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.product.asset.Tranche;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTranche.MapTrancheDefault.class)
public abstract class MapTranche implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlTranche 
	* @return tranche 
	*/
	public Tranche evaluate(fpml.consolidated.cd.Tranche fpmlTranche) {
		Tranche.TrancheBuilder trancheBuilder = doEvaluate(fpmlTranche);
		
		final Tranche tranche;
		if (trancheBuilder == null) {
			tranche = null;
		} else {
			tranche = trancheBuilder.build();
			objectValidator.validate(Tranche.class, tranche);
		}
		
		return tranche;
	}

	protected abstract Tranche.TrancheBuilder doEvaluate(fpml.consolidated.cd.Tranche fpmlTranche);

	public static class MapTrancheDefault extends MapTranche {
		@Override
		protected Tranche.TrancheBuilder doEvaluate(fpml.consolidated.cd.Tranche fpmlTranche) {
			Tranche.TrancheBuilder tranche = Tranche.builder();
			return assignOutput(tranche, fpmlTranche);
		}
		
		protected Tranche.TrancheBuilder assignOutput(Tranche.TrancheBuilder tranche, fpml.consolidated.cd.Tranche fpmlTranche) {
			tranche = toBuilder(Tranche.builder()
				.setAttachmentPoint(MapperS.of(fpmlTranche).<BigDecimal>map("getAttachmentPoint", _tranche -> _tranche.getAttachmentPoint()).get())
				.setExhaustionPoint(MapperS.of(fpmlTranche).<BigDecimal>map("getExhaustionPoint", _tranche -> _tranche.getExhaustionPoint()).get())
				.setIncurredRecoveryApplicable(MapperS.of(fpmlTranche).<Boolean>map("getIncurredRecoveryApplicable", _tranche -> _tranche.getIncurredRecoveryApplicable()).get())
				.build());
			
			return Optional.ofNullable(tranche)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
