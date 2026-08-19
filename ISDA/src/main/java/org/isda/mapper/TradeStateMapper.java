package org.isda.mapper;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.event.common.TradeState;
import cdm.product.common.settlement.PriceQuantity;
import cdm.product.template.*;
import com.rosetta.model.metafields.MetaFields;
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
        ContractualProduct product = mapProduct(trade);

        Party p1 = buildParty("Party1", trade.getParty1().getLei(), trade.getParty1().getName());
        Party p2 = buildParty("Party2", trade.getParty2().getLei(), trade.getParty2().getName());

        TradableProduct tradableProduct = TradableProduct.builder()
                .setProduct(Product.builder()
                        .setContractualProduct(product))
                .addTradeLot(TradeLot.builder()
                        .addPriceQuantity(buildFixedLegPriceQuantity(trade))
                        .addPriceQuantity(buildFloatingLegPriceQuantity(trade)))
                .addCounterparty(Counterparty.builder()
                        .setRole(CounterpartyRoleEnum.PARTY_1)
                        .setPartyReference(cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference("Party1")))
                .addCounterparty(Counterparty.builder()
                        .setRole(CounterpartyRoleEnum.PARTY_2)
                        .setPartyReference(cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference("Party2")))
                .build();

        Trade cdmTrade = Trade.builder()
                .addTradeIdentifier(buildTradeIdentifier(
                        trade.getParty1().getLei(),
                        trade.getTradeId(),
                        trade.getTradeVersion()))
                .setTradeDate(toDateField(trade.getTradeDate()))
                .setTradableProduct(tradableProduct)
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

    private static ContractualProduct mapProduct(SwapTrade trade) {
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
                                                .setMasterAgreementType(
                                                        com.rosetta.model.metafields.FieldWithMetaString.builder()
                                                                .setValue(maType)))))
                .build();
    }
}
