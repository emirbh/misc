package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.OptionFeature;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.option.shared.Knock;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapOptionFeature.MapSwapOptionFeatureDefault.class)
public abstract class MapSwapOptionFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapKnock mapKnock;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return feature 
	*/
	public OptionFeature evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		OptionFeature.OptionFeatureBuilder featureBuilder = doEvaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final OptionFeature feature;
		if (featureBuilder == null) {
			feature = null;
		} else {
			feature = featureBuilder.build();
			objectValidator.validate(OptionFeature.class, feature);
		}
		
		return feature;
	}

	protected abstract OptionFeature.OptionFeatureBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwapOptionFeatureDefault extends MapSwapOptionFeature {
		@Override
		protected OptionFeature.OptionFeatureBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			OptionFeature.OptionFeatureBuilder feature = OptionFeature.builder();
			return assignOutput(feature, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected OptionFeature.OptionFeatureBuilder assignOutput(OptionFeature.OptionFeatureBuilder feature, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			feature = toBuilder(OptionFeature.builder()
				.setKnock(mapKnock.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<fpml.consolidated.option.shared.OptionFeature>map("getFeature", creditDefaultSwapOption -> creditDefaultSwapOption.getFeature()).<Knock>map("getKnock", optionFeature -> optionFeature.getKnock()).get(), fpmlCreditDefaultSwapOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(feature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
