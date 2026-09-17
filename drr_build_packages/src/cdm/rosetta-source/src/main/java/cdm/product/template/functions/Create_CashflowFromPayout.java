package cdm.product.template.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Price;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(Create_CashflowFromPayout.Create_CashflowFromPayoutDefault.class)
public abstract class Create_CashflowFromPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CashflowFromSettlementPayout create_CashflowFromSettlementPayout;

	/**
	* @param payout The settlement payout from which the cashflows are generated.
	* @return cashflows 
	*/
	public List<? extends Cashflow> evaluate(Payout payout) {
		List<Cashflow.CashflowBuilder> cashflowsBuilder = doEvaluate(payout);
		
		final List<? extends Cashflow> cashflows;
		if (cashflowsBuilder == null) {
			cashflows = null;
		} else {
			cashflows = cashflowsBuilder.stream().map(Cashflow::build).collect(Collectors.toList());
			objectValidator.validate(Cashflow.class, cashflows);
		}
		
		return cashflows;
	}

	protected abstract List<Cashflow.CashflowBuilder> doEvaluate(Payout payout);

	protected abstract MapperS<? extends SettlementPayout> settlementPayoutFromOptionPayout(Payout payout);

	public static class Create_CashflowFromPayoutDefault extends Create_CashflowFromPayout {
		@Override
		protected List<Cashflow.CashflowBuilder> doEvaluate(Payout payout) {
			List<Cashflow.CashflowBuilder> cashflows = new ArrayList<>();
			return assignOutput(cashflows, payout);
		}
		
		protected List<Cashflow.CashflowBuilder> assignOutput(List<Cashflow.CashflowBuilder> cashflows, Payout payout) {
			cashflows.addAll(toBuilder(MapperS.of(payout)
				.mapSingleToList(item -> {
					if (item.get() == null) {
						return MapperC.<Cashflow>ofNull();
					}
					if (item.<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get() != null) {
						final MapperS<OptionPayout> optionPayout = item.<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout());
						return MapperC.<Cashflow>of(create_CashflowFromSettlementPayout.evaluate(settlementPayoutFromOptionPayout(payout).get()));
					}
					if (item.<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get() != null) {
						final MapperS<SettlementPayout> settlementPayout = item.<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout());
						return MapperC.<Cashflow>of(create_CashflowFromSettlementPayout.evaluate(MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get()));
					}
					return MapperC.<Cashflow>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(cashflows)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends SettlementPayout> settlementPayoutFromOptionPayout(Payout payout) {
			return MapperS.of(payout).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout())
				.mapSingleToItem(item -> MapperS.of(SettlementPayout.builder()
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(item.<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get())
						.setPriceScheduleValue(item.<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).getMulti())
						.build())
					.setUnderlier(item.<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).get())
					.setSettlementTerms(item.<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get())
					.setPayerReceiver(item.<PayerReceiver>map("getPayerReceiver", optionPayout -> optionPayout.getPayerReceiver()).get())
					.build()));
		}
	}
}
