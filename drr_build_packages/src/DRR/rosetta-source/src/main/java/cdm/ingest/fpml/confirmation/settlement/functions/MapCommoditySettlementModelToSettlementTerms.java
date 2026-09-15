package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommoditySettlementModelToSettlementTerms.MapCommoditySettlementModelToSettlementTermsDefault.class)
public abstract class MapCommoditySettlementModelToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlSettlementCurrency 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(IdentifiedCurrency fpmlSettlementCurrency) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlSettlementCurrency);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(IdentifiedCurrency fpmlSettlementCurrency);

	public static class MapCommoditySettlementModelToSettlementTermsDefault extends MapCommoditySettlementModelToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(IdentifiedCurrency fpmlSettlementCurrency) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlSettlementCurrency);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, IdentifiedCurrency fpmlSettlementCurrency) {
			SettlementTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlSettlementCurrency)).getOrDefault(false)) {
				ifThenElseResult = SettlementTypeEnum.CASH;
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(ifThenElseResult)
				.setSettlementCurrency(mapStringWithScheme.evaluate(MapperS.of(fpmlSettlementCurrency).<String>map("getValue", identifiedCurrency -> identifiedCurrency.getValue()).get(), MapperS.of(fpmlSettlementCurrency).<String>map("getCurrencyScheme", identifiedCurrency -> identifiedCurrency.getCurrencyScheme()).get()))
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
