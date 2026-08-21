package org.isda.mapper.product;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Observable;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import org.isda.mapper.SwapTrade;

import java.util.Collections;

import static org.isda.mapper.util.CdmBuilderUtil.toDate;

/**
 * Maps an internal FX non-deliverable forward to the CDM 6 product structure.
 *
 * The shape is dictated by CDM's own qualification rule
 * (Qualify_ForeignExchange_NDF in product-qualification-func.rosetta), which
 * requires all three of:
 *
 *   - economicTerms.payout holds exactly ONE element, a SettlementPayout
 *   - that payout has settlementTerms.cashSettlementTerms
 *   - the underlier resolves to Observable -> Asset -> Cash, which is what
 *     Qualify_AssetClass_ForeignExchange keys off
 *
 * Note this differs from CDM 5, which modelled the same trade as a
 * forwardPayout with underlier.foreignExchange. Payout has no forwardPayout
 * in CDM 6.
 */
public final class FxNdfMapper {

    private FxNdfMapper() {}

    public static NonTransferableProduct map(SwapTrade trade) {
        validate(trade);

        return NonTransferableProduct.builder()
                .setTaxonomy(Collections.singletonList(ProductTaxonomy.builder()
                        .setSource(TaxonomySourceEnum.ISDA)
                        .setProductQualifier("ForeignExchange_NDF")))
                .setEconomicTerms(buildEconomicTerms(trade))
                .build();
    }

    private static void validate(SwapTrade trade) {
        if (trade.getSettlementCurrency() == null) {
            throw new IllegalArgumentException(
                    "FX NDF requires a settlementCurrency (the currency actually paid)");
        }
        if (trade.getNotionalAmount() == null || trade.getNotionalCurrency() == null) {
            throw new IllegalArgumentException("FX NDF requires a notional amount and currency");
        }
    }

    /** Exactly one payout, or Qualify_ForeignExchange_NDF will not match. */
    private static EconomicTerms buildEconomicTerms(SwapTrade trade) {
        return EconomicTerms.builder()
                .addPayout(Payout.builder()
                        .setSettlementPayout(buildSettlementPayout(trade)))
                .build();
    }

    private static SettlementPayout buildSettlementPayout(SwapTrade trade) {
        return SettlementPayout.builder()
                .setPayerReceiver(PayerReceiver.builder()
                        .setPayer(CounterpartyRoleEnum.PARTY_1)
                        .setReceiver(CounterpartyRoleEnum.PARTY_2))
                .setUnderlier(buildUnderlier(trade))
                .setSettlementTerms(buildSettlementTerms(trade))
                .build();
    }

    /**
     * Cash underlier denominated in the reference currency — the leg that is
     * never actually delivered, and the marker CDM uses to classify the trade
     * as foreign exchange.
     */
    private static Underlier buildUnderlier(SwapTrade trade) {
        String referenceCurrency = trade.getReferenceCurrency() != null
                ? trade.getReferenceCurrency()
                : trade.getNotionalCurrency2();

        // CDM 6 Cash has no currency field; the currency is an asset
        // identifier of type CURRENCY_CODE.
        Cash.CashBuilder cash = Cash.builder();
        if (referenceCurrency != null) {
            cash.addIdentifier(AssetIdentifier.builder()
                    .setIdentifierValue(referenceCurrency)
                    .setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE));
        }

        return Underlier.builder()
                .setObservableValue(Observable.builder()
                        .setAsset(Asset.builder()
                                .setCash(cash)))
                .build();
    }

    private static SettlementTerms buildSettlementTerms(SwapTrade trade) {
        SettlementTerms.SettlementTermsBuilder builder = SettlementTerms.builder()
                .setSettlementType(SettlementTypeEnum.CASH)
                .setSettlementCurrencyValue(trade.getSettlementCurrency())
                .addCashSettlementTerms(CashSettlementTerms.builder()
                        .setCashSettlementMethod(
                                cdm.product.common.settlement.CashSettlementMethodEnum.CASH_PRICE_METHOD));

        if (trade.getValueDate() != null) {
            builder.setSettlementDate(SettlementDate.builder()
                    .setValueDate(toDate(trade.getValueDate())));
        }

        return builder.build();
    }
}
