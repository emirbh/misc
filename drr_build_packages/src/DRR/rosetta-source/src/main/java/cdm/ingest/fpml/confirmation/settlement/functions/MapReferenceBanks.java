package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.staticdata.party.ReferenceBanks;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.ReferenceBank;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceBanks.MapReferenceBanksDefault.class)
public abstract class MapReferenceBanks implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReferenceBank mapReferenceBank;

	/**
	* @param fpmlCashSettlementReferenceBanks 
	* @return referenceBanks 
	*/
	public ReferenceBanks evaluate(CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks) {
		ReferenceBanks.ReferenceBanksBuilder referenceBanksBuilder = doEvaluate(fpmlCashSettlementReferenceBanks);
		
		final ReferenceBanks referenceBanks;
		if (referenceBanksBuilder == null) {
			referenceBanks = null;
		} else {
			referenceBanks = referenceBanksBuilder.build();
			objectValidator.validate(ReferenceBanks.class, referenceBanks);
		}
		
		return referenceBanks;
	}

	protected abstract ReferenceBanks.ReferenceBanksBuilder doEvaluate(CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks);

	public static class MapReferenceBanksDefault extends MapReferenceBanks {
		@Override
		protected ReferenceBanks.ReferenceBanksBuilder doEvaluate(CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks) {
			ReferenceBanks.ReferenceBanksBuilder referenceBanks = ReferenceBanks.builder();
			return assignOutput(referenceBanks, fpmlCashSettlementReferenceBanks);
		}
		
		protected ReferenceBanks.ReferenceBanksBuilder assignOutput(ReferenceBanks.ReferenceBanksBuilder referenceBanks, CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks) {
			referenceBanks = toBuilder(ReferenceBanks.builder()
				.setReferenceBank(MapperS.of(fpmlCashSettlementReferenceBanks).<ReferenceBank>mapC("getReferenceBank", cashSettlementReferenceBanks -> cashSettlementReferenceBanks.getReferenceBank())
					.mapItem(item -> MapperS.of(mapReferenceBank.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(referenceBanks)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
