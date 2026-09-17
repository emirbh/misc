package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.shared.Currency;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCashSettlementToSettlementTerms.MapCashSettlementToSettlementTermsDefault.class)
public abstract class MapCashSettlementToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlCashSettlementCurrency getFpmlCashSettlementCurrency;
	@Inject protected MapCashSettlementToCashSettlementTerms mapCashSettlementToCashSettlementTerms;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlCashSettlement 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(CashSettlement fpmlCashSettlement) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlCashSettlement);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(CashSettlement fpmlCashSettlement);

	public static class MapCashSettlementToSettlementTermsDefault extends MapCashSettlementToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(CashSettlement fpmlCashSettlement) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlCashSettlement);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, CashSettlement fpmlCashSettlement) {
			if (exists(MapperS.of(fpmlCashSettlement)).getOrDefault(false)) {
				final CashSettlementTerms cashSettlementTerms = mapCashSettlementToCashSettlementTerms.evaluate(fpmlCashSettlement);
				settlementTerms = toBuilder(SettlementTerms.builder()
					.setSettlementType(SettlementTypeEnum.CASH)
					.setSettlementCurrency(mapCurrency.evaluate(MapperC.<Currency>of(getFpmlCashSettlementCurrency.evaluate(fpmlCashSettlement))
						.first().get()))
					.setCashSettlementTerms((cashSettlementTerms == null ? Collections.<CashSettlementTerms>emptyList() : Collections.singletonList(cashSettlementTerms)))
					.build());
			} else {
				settlementTerms = null;
			}
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
