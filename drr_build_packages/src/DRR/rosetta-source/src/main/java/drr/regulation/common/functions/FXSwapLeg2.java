package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.GetQuantityReference;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FXSwapLeg2.FXSwapLeg2Default.class)
public abstract class FXSwapLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected GetQuantityReference getQuantityReference;

	/**
	* @param product 
	* @param tradeLot 
	* @return fxSwapLeg2 
	*/
	public Cashflow evaluate(NonTransferableProduct product, TradeLot tradeLot) {
		Cashflow.CashflowBuilder fxSwapLeg2Builder = doEvaluate(product, tradeLot);
		
		final Cashflow fxSwapLeg2;
		if (fxSwapLeg2Builder == null) {
			fxSwapLeg2 = null;
		} else {
			fxSwapLeg2 = fxSwapLeg2Builder.build();
			objectValidator.validate(Cashflow.class, fxSwapLeg2);
		}
		
		return fxSwapLeg2;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends SettlementPayout> fxFarLeg(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends FieldWithMetaString> leg2Currency(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<String> quantityKeyLeg2(NonTransferableProduct product, TradeLot tradeLot);

	protected abstract MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> tlSwap1(NonTransferableProduct product, TradeLot tradeLot);

	public static class FXSwapLeg2Default extends FXSwapLeg2 {
		@Override
		protected Cashflow.CashflowBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot) {
			Cashflow.CashflowBuilder fxSwapLeg2 = Cashflow.builder();
			return assignOutput(fxSwapLeg2, product, tradeLot);
		}
		
		protected Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder fxSwapLeg2, NonTransferableProduct product, TradeLot tradeLot) {
			if (areEqual(fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), leg2Currency(product, tradeLot).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All).getOrDefault(false)) {
				fxSwapLeg2 = toBuilder(Cashflow.builder()
					.setPayerReceiver(fxFarLeg(product, tradeLot).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).get())
					.setQuantity(NonNegativeQuantity.builder()
						.setValue(fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.setUnit(fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.build())
					.setCashflowType(null)
					.setPaymentDiscounting(null)
					.setAsset(null)
					.setSettlementDate(null)
					.build());
			} else {
				fxSwapLeg2 = toBuilder(Cashflow.builder()
					.setPayerReceiver(PayerReceiver.builder()
						.setPayer(fxFarLeg(product, tradeLot).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())
						.setReceiver(fxFarLeg(product, tradeLot).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())
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
			
			return Optional.ofNullable(fxSwapLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends SettlementPayout> fxFarLeg(NonTransferableProduct product, TradeLot tradeLot) {
			return MapperS.of(fXFarLeg.evaluate(product));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> leg2Currency(NonTransferableProduct product, TradeLot tradeLot) {
			final MapperS<UnitType> thenArg = MapperC.<UnitType>of(fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()), fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()))
				.max(item -> item.<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			return thenArg.<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
		}
		
		@Override
		protected MapperS<String> quantityKeyLeg2(NonTransferableProduct product, TradeLot tradeLot) {
			return MapperS.of(getQuantityReference.evaluate(fxFarLeg(product, tradeLot).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).get()));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> tlSwap1(NonTransferableProduct product, TradeLot tradeLot) {
			final MapperC<PriceQuantity> thenArg0 = MapperS.of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity())
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).map("getMeta", a->a.getMeta()).map("getLocation", a->a.getScopedKey()), quantityKeyLeg2(product, tradeLot), CardinalityOperator.Any).get());
			final MapperS<PriceQuantity> thenArg1 = MapperS.of(thenArg0.get());
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), leg2Currency(product, tradeLot).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All).get());
			return MapperS.of(thenArg3.get());
		}
	}
}
