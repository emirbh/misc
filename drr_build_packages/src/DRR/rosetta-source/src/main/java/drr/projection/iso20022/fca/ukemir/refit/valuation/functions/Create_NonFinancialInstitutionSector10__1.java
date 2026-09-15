package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.GenericIdentification175__1;
import iso20022.auth030.fca.NonFinancialInstitutionSector10__1;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_NonFinancialInstitutionSector10__1.Create_NonFinancialInstitutionSector10__1Default.class)
public abstract class Create_NonFinancialInstitutionSector10__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param corporateSectorOfCounterparty 
	* @param clearingThresholdOfCounterparty 
	* @param directlyLinkedToCommercialActivityOrTreasuryFinancing 
	* @return out 
	*/
	public NonFinancialInstitutionSector10__1 evaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty, Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing) {
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder outBuilder = doEvaluate(corporateSectorOfCounterparty, clearingThresholdOfCounterparty, directlyLinkedToCommercialActivityOrTreasuryFinancing);
		
		final NonFinancialInstitutionSector10__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(NonFinancialInstitutionSector10__1.class, out);
		}
		
		return out;
	}

	protected abstract NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty, Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing);

	public static class Create_NonFinancialInstitutionSector10__1Default extends Create_NonFinancialInstitutionSector10__1 {
		@Override
		protected NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty, Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing) {
			if (corporateSectorOfCounterparty == null) {
				corporateSectorOfCounterparty = Collections.emptyList();
			}
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder out = NonFinancialInstitutionSector10__1.builder();
			return assignOutput(out, corporateSectorOfCounterparty, clearingThresholdOfCounterparty, directlyLinkedToCommercialActivityOrTreasuryFinancing);
		}
		
		protected NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder assignOutput(NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder out, List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty, Boolean directlyLinkedToCommercialActivityOrTreasuryFinancing) {
			out = toBuilder(NonFinancialInstitutionSector10__1.builder()
				.setSctr(MapperC.<String>of(corporateSectorOfCounterparty)
					.mapItem(item -> MapperS.of(GenericIdentification175__1.builder()
						.setId(item.get())
						.build())).getMulti())
				.setClrThrshld(clearingThresholdOfCounterparty)
				.setDrctlyLkdActvty(directlyLinkedToCommercialActivityOrTreasuryFinancing)
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
