package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.GetQuantityReference;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FXLeg1.FXLeg1Default.class)
public abstract class FXLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetQuantityReference getQuantityReference;

	/**
	* @param product 
	* @param tradeLot 
	* @return fxLeg1 
	*/
	public Cashflow evaluate(NonTransferableProduct product, TradeLot tradeLot) {
		Cashflow.CashflowBuilder fxLeg1Builder = doEvaluate(product, tradeLot);
		
		final Cashflow fxLeg1;
		if (fxLeg1Builder == null) {
			fxLeg1 = null;
		} else {
			fxLeg1 = fxLeg1Builder.build();
			objectValidator.validate(Cashflow.class, fxLeg1);
		}
		
		return fxLeg1;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends SettlementPayout> fxSettlementPayout(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends OptionPayout> fxOptionPayout(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends FieldWithMetaString> leg1Currency(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<String> quantityKeyLeg1(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> tlSwap1(NonTransferableProduct product, TradeLot tradeLot);

	public static class FXLeg1Default extends FXLeg1 {
		@Override
		protected Cashflow.CashflowBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot) {
			Cashflow.CashflowBuilder fxLeg1 = Cashflow.builder();
			return assignOutput(fxLeg1, product, tradeLot);
		}
		
		protected Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder fxLeg1, NonTransferableProduct product, TradeLot tradeLot) {
			final MapperS<? extends PayoutBase> thenArg;
			if (exists(fxSettlementPayout(product, tradeLot)).getOrDefault(false)) {
				thenArg = fxSettlementPayout(product, tradeLot);
			} else if (exists(fxOptionPayout(product, tradeLot)).getOrDefault(false)) {
				thenArg = fxOptionPayout(product, tradeLot);
			} else {
				thenArg = MapperS.<PayoutBase>ofNull();
			}
			final MapperS<Cashflow> ifThenElseResult;
			if (areEqual(thenArg.<ResolvablePriceQuantity>map("getPriceQuantity", payoutBase -> payoutBase.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), leg1Currency(product, tradeLot).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(Cashflow.builder()
					.setPayerReceiver(thenArg.<PayerReceiver>map("getPayerReceiver", payoutBase -> payoutBase.getPayerReceiver()).get())
					.setQuantity(NonNegativeQuantity.builder()
						.setValue(thenArg.<ResolvablePriceQuantity>map("getPriceQuantity", payoutBase -> payoutBase.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.setUnit(thenArg.<ResolvablePriceQuantity>map("getPriceQuantity", payoutBase -> payoutBase.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.build())
					.setCashflowType(null)
					.setPaymentDiscounting(null)
					.setAsset(null)
					.setSettlementDate(null)
					.build());
			} else {
				ifThenElseResult = MapperS.of(Cashflow.builder()
					.setPayerReceiver(PayerReceiver.builder()
						.setPayer(thenArg.<PayerReceiver>map("getPayerReceiver", payoutBase -> payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())
						.setReceiver(thenArg.<PayerReceiver>map("getPayerReceiver", payoutBase -> payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())
						.build())
					.setQuantity(NonNegativeQuantity.builder()
						.setValue(tlSwap1(product, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule0 -> fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.setUnit(tlSwap1(product, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule1 -> fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.build())
					.setCashflowType(null)
					.setPaymentDiscounting(null)
					.setAsset(null)
					.setSettlementDate(null)
					.build());
			}
			fxLeg1 = toBuilder(ifThenElseResult.get());
			
			return Optional.ofNullable(fxLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends SettlementPayout> fxSettlementPayout(NonTransferableProduct product, TradeLot tradeLot) {
			return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
		}
		
		@Override
		protected MapperS<? extends OptionPayout> fxOptionPayout(NonTransferableProduct product, TradeLot tradeLot) {
			return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> leg1Currency(NonTransferableProduct product, TradeLot tradeLot) {
			final MapperC<UnitType> thenArg0 = MapperC.<UnitType>of(fxSettlementPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()), fxSettlementPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf())).getMulti().isEmpty() ? MapperC.<UnitType>of(fxOptionPayout(product, tradeLot).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()), fxOptionPayout(product, tradeLot).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getPerUnitOf", price -> price.getPerUnitOf())) : MapperC.<UnitType>of(fxSettlementPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()), fxSettlementPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()));
			final MapperS<UnitType> thenArg1 = thenArg0
				.min(item -> item.<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			return thenArg1.<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
		}
		
		@Override
		protected MapperS<String> quantityKeyLeg1(NonTransferableProduct product, TradeLot tradeLot) {
			return MapperS.of(getQuantityReference.evaluate(fxSettlementPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).getOrDefault(fxOptionPayout(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).get())));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> tlSwap1(NonTransferableProduct product, TradeLot tradeLot) {
			final MapperC<PriceQuantity> thenArg0 = MapperS.of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity())
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).map("getMeta", a->a.getMeta()).map("getLocation", a->a.getScopedKey()), quantityKeyLeg1(product, tradeLot), CardinalityOperator.Any).get());
			final MapperS<PriceQuantity> thenArg1 = MapperS.of(thenArg0.get());
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), leg1Currency(product, tradeLot).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All).get());
			return MapperS.of(thenArg3.get());
		}
	}
}
