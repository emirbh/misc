package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.GenericIdentification175__1;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__2;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_NonFinancialInstitutionSector10__2.Create_NonFinancialInstitutionSector10__2Default.class)
public abstract class Create_NonFinancialInstitutionSector10__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param corporateSectorOfCounterparty 
	* @param clearingThresholdOfCounterparty 
	* @return out 
	*/
	public NonFinancialInstitutionSector10__2 evaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder outBuilder = doEvaluate(corporateSectorOfCounterparty, clearingThresholdOfCounterparty);
		
		final NonFinancialInstitutionSector10__2 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(NonFinancialInstitutionSector10__2.class, out);
		}
		
		return out;
	}

	protected abstract NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty);

	public static class Create_NonFinancialInstitutionSector10__2Default extends Create_NonFinancialInstitutionSector10__2 {
		@Override
		protected NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder doEvaluate(List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
			if (corporateSectorOfCounterparty == null) {
				corporateSectorOfCounterparty = Collections.emptyList();
			}
			NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder out = NonFinancialInstitutionSector10__2.builder();
			return assignOutput(out, corporateSectorOfCounterparty, clearingThresholdOfCounterparty);
		}
		
		protected NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder assignOutput(NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder out, List<String> corporateSectorOfCounterparty, Boolean clearingThresholdOfCounterparty) {
			out = toBuilder(NonFinancialInstitutionSector10__2.builder()
				.setSctr(MapperC.<String>of(corporateSectorOfCounterparty)
					.mapItem(item -> MapperS.of(GenericIdentification175__1.builder()
						.setId(item.get())
						.build())).getMulti())
				.setClrThrshld(clearingThresholdOfCounterparty)
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
