package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.FinancialInstitutionSector1__1;
import iso20022.auth030.fca.FinancialPartyClassification2Choice__1;
import iso20022.auth030.fca.FinancialPartySectorType3Code__1;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FinancialInstitutionSector1__1.Create_FinancialInstitutionSector1__1Default.class)
public abstract class Create_FinancialInstitutionSector1__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param corporateSectorOfCounterparty 
	* @param clearingThresholdOfCounterparty 
	* @return out 
	*/
	public FinancialInstitutionSector1__1 evaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
		FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder outBuilder = doEvaluate(corporateSectorOfCounterparty, clearingThresholdOfCounterparty);
		
		final FinancialInstitutionSector1__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FinancialInstitutionSector1__1.class, out);
		}
		
		return out;
	}

	protected abstract FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty);

	public static class Create_FinancialInstitutionSector1__1Default extends Create_FinancialInstitutionSector1__1 {
		@Override
		protected FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
			if (corporateSectorOfCounterparty == null) {
				corporateSectorOfCounterparty = Collections.emptyList();
			}
			FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder out = FinancialInstitutionSector1__1.builder();
			return assignOutput(out, corporateSectorOfCounterparty, clearingThresholdOfCounterparty);
		}
		
		protected FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder assignOutput(FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder out, List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
			out = toBuilder(FinancialInstitutionSector1__1.builder()
				.setSctr(MapperC.<String>of(corporateSectorOfCounterparty)
					.mapItem(item -> MapperS.of(FinancialPartyClassification2Choice__1.builder()
						.setCd(item.checkedMap("to-enum", FinancialPartySectorType3Code__1::fromDisplayName, IllegalArgumentException.class).get())
						.build())).getMulti())
				.setClrThrshld(clearingThresholdOfCounterparty)
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
