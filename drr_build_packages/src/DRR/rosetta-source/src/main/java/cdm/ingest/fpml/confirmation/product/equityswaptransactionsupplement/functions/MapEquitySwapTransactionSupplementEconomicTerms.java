package cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.DirectionalLeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquitySwapTransactionSupplementEconomicTerms.MapEquitySwapTransactionSupplementEconomicTermsDefault.class)
public abstract class MapEquitySwapTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapReturnSwapLegListToPayoutList mapReturnSwapLegListToPayoutList;

	/**
	* @param fpmlEquitySwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlEquitySwapTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquitySwapTransactionSupplementEconomicTermsDefault extends MapEquitySwapTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlEquitySwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(distinctIgnoringPrecision(MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg()).<AdjustableOrRelativeDate>map("getEffectiveDate", directionalLeg -> directionalLeg.getEffectiveDate())).get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(distinctIgnoringPrecision(MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg()).<AdjustableOrRelativeDate>map("getTerminationDate", directionalLeg -> directionalLeg.getTerminationDate())).get()))
				.setPayout(new ArrayList(mapReturnSwapLegListToPayoutList.evaluate(MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg()).getMulti(), cdmCounterpartyList)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
