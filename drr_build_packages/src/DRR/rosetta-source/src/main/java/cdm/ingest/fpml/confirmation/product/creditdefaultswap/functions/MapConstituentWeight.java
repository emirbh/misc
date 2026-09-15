package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.product.template.ConstituentWeight;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapConstituentWeight.MapConstituentWeightDefault.class)
public abstract class MapConstituentWeight implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlConstituentWeight 
	* @return constituentWeight 
	*/
	public ConstituentWeight evaluate(fpml.consolidated.asset.ConstituentWeight fpmlConstituentWeight) {
		ConstituentWeight.ConstituentWeightBuilder constituentWeightBuilder = doEvaluate(fpmlConstituentWeight);
		
		final ConstituentWeight constituentWeight;
		if (constituentWeightBuilder == null) {
			constituentWeight = null;
		} else {
			constituentWeight = constituentWeightBuilder.build();
			objectValidator.validate(ConstituentWeight.class, constituentWeight);
		}
		
		return constituentWeight;
	}

	protected abstract ConstituentWeight.ConstituentWeightBuilder doEvaluate(fpml.consolidated.asset.ConstituentWeight fpmlConstituentWeight);

	public static class MapConstituentWeightDefault extends MapConstituentWeight {
		@Override
		protected ConstituentWeight.ConstituentWeightBuilder doEvaluate(fpml.consolidated.asset.ConstituentWeight fpmlConstituentWeight) {
			ConstituentWeight.ConstituentWeightBuilder constituentWeight = ConstituentWeight.builder();
			return assignOutput(constituentWeight, fpmlConstituentWeight);
		}
		
		protected ConstituentWeight.ConstituentWeightBuilder assignOutput(ConstituentWeight.ConstituentWeightBuilder constituentWeight, fpml.consolidated.asset.ConstituentWeight fpmlConstituentWeight) {
			constituentWeight = toBuilder(ConstituentWeight.builder()
				.setOpenUnits(MapperS.of(fpmlConstituentWeight).<BigDecimal>map("getOpenUnits", _constituentWeight -> _constituentWeight.getOpenUnits()).get())
				.setBasketPercentage(MapperS.of(fpmlConstituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()).get())
				.build());
			
			return Optional.ofNullable(constituentWeight)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
