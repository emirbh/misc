package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.staticdata.party.ReferenceBank;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ReferenceBankId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceBank.MapReferenceBankDefault.class)
public abstract class MapReferenceBank implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlReferenceBank 
	* @return referenceBank 
	*/
	public ReferenceBank evaluate(fpml.consolidated.shared.ReferenceBank fpmlReferenceBank) {
		ReferenceBank.ReferenceBankBuilder referenceBankBuilder = doEvaluate(fpmlReferenceBank);
		
		final ReferenceBank referenceBank;
		if (referenceBankBuilder == null) {
			referenceBank = null;
		} else {
			referenceBank = referenceBankBuilder.build();
			objectValidator.validate(ReferenceBank.class, referenceBank);
		}
		
		return referenceBank;
	}

	protected abstract ReferenceBank.ReferenceBankBuilder doEvaluate(fpml.consolidated.shared.ReferenceBank fpmlReferenceBank);

	public static class MapReferenceBankDefault extends MapReferenceBank {
		@Override
		protected ReferenceBank.ReferenceBankBuilder doEvaluate(fpml.consolidated.shared.ReferenceBank fpmlReferenceBank) {
			ReferenceBank.ReferenceBankBuilder referenceBank = ReferenceBank.builder();
			return assignOutput(referenceBank, fpmlReferenceBank);
		}
		
		protected ReferenceBank.ReferenceBankBuilder assignOutput(ReferenceBank.ReferenceBankBuilder referenceBank, fpml.consolidated.shared.ReferenceBank fpmlReferenceBank) {
			referenceBank = toBuilder(ReferenceBank.builder()
				.setReferenceBankId(mapStringWithScheme.evaluate(MapperS.of(fpmlReferenceBank).<ReferenceBankId>map("getReferenceBankId", _referenceBank -> _referenceBank.getReferenceBankId()).<String>map("getValue", referenceBankId -> referenceBankId.getValue()).get(), MapperS.of(fpmlReferenceBank).<ReferenceBankId>map("getReferenceBankId", _referenceBank -> _referenceBank.getReferenceBankId()).<String>map("getReferenceBankIdScheme", referenceBankId -> referenceBankId.getReferenceBankIdScheme()).get()))
				.setReferenceBankName(MapperS.of(fpmlReferenceBank).<String>map("getReferenceBankName", _referenceBank -> _referenceBank.getReferenceBankName()).get())
				.build());
			
			return Optional.ofNullable(referenceBank)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
