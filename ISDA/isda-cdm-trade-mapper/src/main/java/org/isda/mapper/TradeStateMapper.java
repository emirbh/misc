package org.isda.mapper;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.*;
import com.rosetta.model.metafields.MetaFields;
import org.isda.mapper.product.FxNdfMapper;
import org.isda.mapper.product.VanillaSwapMapper;
import org.isda.mapper.util.CdmBuilderUtil;

import java.util.Collections;

import static org.isda.mapper.util.CdmBuilderUtil.*;

/**
 * Top-level mapper: SwapTrade → CDM TradeState.
 *
 * Dispatches to product-specific mappers based on productType,
 * then wraps the result in Trade → TradableProduct → TradeState.
 */
public final class TradeStateMapper {

    private TradeStateMapper() {}

    public static TradeState map(SwapTrade trade) {
        NonTransferableProduct product = mapProduct(trade);

        Party p1 = buildParty("Party1", trade.getParty1().getLei(), trade.getParty1().getName());
        Party p2 = buildParty("Party2", trade.getParty2().getLei(), trade.getParty2().getName());

        // CDM 6 dissolves TradableProduct: product, trade lots and
        // counterparties now sit directly on Trade.
        Trade cdmTrade = Trade.builder()
                .addTradeIdentifier(buildTradeIdentifier(
                        trade.getParty1().getLei(),
                        trade.getTradeId(),
                        trade.getTradeVersion()))
                .setTradeDate(toDateField(trade.getTradeDate()))
                .setProduct(product)
                .addTradeLot(buildTradeLot(trade))
                .addCounterparty(Counterparty.builder()
                        .setRole(CounterpartyRoleEnum.PARTY_1)
                        .setPartyReference(cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference("Party1")))
                .addCounterparty(Counterparty.builder()
                        .setRole(CounterpartyRoleEnum.PARTY_2)
                        .setPartyReference(cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference("Party2")))
                .addParty(p1)
                .addParty(p2)
                .setExecutionDetails(cdm.event.common.ExecutionDetails.builder()
                        .setExecutionType(cdm.event.common.ExecutionTypeEnum.OFF_FACILITY))
                .setContractDetails(buildContractDetails(trade))
                .build();

        return TradeState.builder()
                .setTrade(cdmTrade)
                .build();
    }

    private static NonTransferableProduct mapProduct(SwapTrade trade) {
        switch (trade.getProductType()) {
            case "vanilla_swap":
            case "ois":
            case "basic_swap":
            case "swap_spread":
            case "ratelock":
                return VanillaSwapMapper.map(trade);

            case "fra":
                return VanillaSwapMapper.map(trade);

            case "cap_floor":
                return VanillaSwapMapper.map(trade);

            case "swaption":
            case "ois_swaption":
            case "bond_option":
            case "fx_simple_option":
            case "di_option":
            case "idi_option":
                return VanillaSwapMapper.map(trade);

            case "cancelable_swap":
                return VanillaSwapMapper.map(trade);

            case "fx_ndf":
                return FxNdfMapper.map(trade);

            case "fx_leg":
            case "fx_swap":
            case "fx_reset":
                return VanillaSwapMapper.map(trade);

            case "inflation_swap":
            case "inflation_yoy_swap":
                return VanillaSwapMapper.map(trade);

            case "fee_only":
            case "rates_fee_only":
            case "credit_fee_only":
            case "cmd_rate_lock":
                return VanillaSwapMapper.map(trade);

            default:
                throw new IllegalArgumentException("Unsupported product type: " + trade.getProductType());
        }
    }

    /**
     * The trade lot carries the economics DRR's report rules read. An FX
     * forward states both exchanged amounts and the rate on a single
     * PriceQuantity; a swap states one per leg.
     */
    private static TradeLot buildTradeLot(SwapTrade trade) {
        if ("fx_ndf".equals(trade.getProductType())) {
            return TradeLot.builder()
                    .addPriceQuantity(buildFxPriceQuantity(trade))
                    .build();
        }
        return TradeLot.builder()
                .addPriceQuantity(buildFixedLegPriceQuantity(trade))
                .addPriceQuantity(buildFloatingLegPriceQuantity(trade))
                .build();
    }

    /**
     * Both currency amounts plus the exchange rate, keyed on a cash observable
     * in the settlement currency — the shape DRR's FX rules expect.
     */
    private static PriceQuantity buildFxPriceQuantity(SwapTrade trade) {
        String settlementCurrency = trade.getSettlementCurrency() != null
                ? trade.getSettlementCurrency() : trade.getNotionalCurrency();
        String referenceCurrency = trade.getReferenceCurrency() != null
                ? trade.getReferenceCurrency() : trade.getNotionalCurrency2();

        PriceQuantity.PriceQuantityBuilder builder = PriceQuantity.builder()
                .setObservable(cdm.observable.asset.metafields.FieldWithMetaObservable.builder()
                        .setValue(cdm.observable.asset.Observable.builder()
                                .setAsset(cdm.base.staticdata.asset.common.Asset.builder()
                                        .setCash(cashInCurrency(settlementCurrency)))));

        // Reference-currency amount first, settlement-currency second — the
        // order DRR's leg1/leg2 assignment expects for a non-deliverable forward.
        boolean firstIsReference = referenceCurrency != null
                && referenceCurrency.equals(trade.getNotionalCurrency());

        if (firstIsReference) {
            builder.addQuantity(quantityField(trade.getNotionalAmount(), trade.getNotionalCurrency()));
            if (trade.getNotionalAmount2() != null) {
                builder.addQuantity(quantityField(trade.getNotionalAmount2(), trade.getNotionalCurrency2()));
            }
        } else {
            if (trade.getNotionalAmount2() != null) {
                builder.addQuantity(quantityField(trade.getNotionalAmount2(), trade.getNotionalCurrency2()));
            }
            builder.addQuantity(quantityField(trade.getNotionalAmount(), trade.getNotionalCurrency()));
        }

        if (trade.getFxRate() != null) {
            builder.addPrice(cdm.observable.asset.metafields.FieldWithMetaPriceSchedule.builder()
                    .setValue(cdm.observable.asset.PriceSchedule.builder()
                            .setValue(trade.getFxRate())
                            .setPriceType(cdm.observable.asset.PriceTypeEnum.EXCHANGE_RATE)
                            .setUnit(cdm.base.math.UnitType.builder()
                                    .setCurrency(com.rosetta.model.metafields.FieldWithMetaString.builder()
                                            .setValue(referenceCurrency)))
                            .setPerUnitOf(cdm.base.math.UnitType.builder()
                                    .setCurrency(com.rosetta.model.metafields.FieldWithMetaString.builder()
                                            .setValue(settlementCurrency)))));
        }

        return builder.build();
    }

    private static cdm.base.staticdata.asset.common.Cash cashInCurrency(String currency) {
        cdm.base.staticdata.asset.common.Cash.CashBuilder cash =
                cdm.base.staticdata.asset.common.Cash.builder();
        if (currency != null) {
            cash.addIdentifier(cdm.base.staticdata.asset.common.AssetIdentifier.builder()
                    .setIdentifierValue(currency)
                    .setIdentifierType(cdm.base.staticdata.asset.common.AssetIdTypeEnum.CURRENCY_CODE));
        }
        return cash.build();
    }

    private static PriceQuantity buildFixedLegPriceQuantity(SwapTrade trade) {
        PriceQuantity.PriceQuantityBuilder builder = PriceQuantity.builder()
                .addQuantity(quantityField(trade.getNotionalAmount(), trade.getNotionalCurrency()));

        if (trade.getFixedRate() != null) {
            builder.addPrice(cdm.observable.asset.metafields.FieldWithMetaPriceSchedule.builder()
                    .setValue(cdm.observable.asset.PriceSchedule.builder()
                            .setValue(trade.getFixedRate())
                            .setUnit(cdm.base.math.UnitType.builder()
                                    .setCurrency(com.rosetta.model.metafields.FieldWithMetaString.builder()
                                            .setValue(trade.getNotionalCurrency())))
                            .setPerUnitOf(cdm.base.math.UnitType.builder()
                                    .setCurrency(com.rosetta.model.metafields.FieldWithMetaString.builder()
                                            .setValue(trade.getNotionalCurrency())))
                            .setPriceType(cdm.observable.asset.PriceTypeEnum.INTEREST_RATE)));
        }

        return builder.build();
    }

    private static PriceQuantity buildFloatingLegPriceQuantity(SwapTrade trade) {
        return PriceQuantity.builder()
                .addQuantity(quantityField(
                        trade.getNotionalAmount2() != null ? trade.getNotionalAmount2() : trade.getNotionalAmount(),
                        trade.getNotionalCurrency2() != null ? trade.getNotionalCurrency2() : trade.getNotionalCurrency()))
                .build();
    }

    private static cdm.event.common.ContractDetails buildContractDetails(SwapTrade trade) {
        String maType = trade.getMasterAgreementType() != null
                ? trade.getMasterAgreementType() : "ISDAMaster";

        return cdm.event.common.ContractDetails.builder()
                .addDocumentation(cdm.legaldocumentation.common.LegalAgreement.builder()
                        .setLegalAgreementIdentification(
                                cdm.legaldocumentation.common.LegalAgreementIdentification.builder()
                                        .setAgreementName(cdm.legaldocumentation.common.AgreementName.builder()
                                                .setAgreementType(cdm.legaldocumentation.common.LegalAgreementTypeEnum.MASTER_AGREEMENT)
                                                .setMasterAgreementTypeValue(
                                                        parseMasterAgreementType(maType)))))
                .build();
    }
}
