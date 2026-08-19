package org.isda.mapper.product;

import cdm.base.datetime.*;
import cdm.base.math.*;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.*;
import cdm.product.asset.*;
import cdm.product.common.settlement.*;
import cdm.product.template.*;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import org.isda.mapper.SwapTrade;
import org.isda.mapper.util.CdmBuilderUtil;

import java.math.BigDecimal;

import static org.isda.mapper.util.CdmBuilderUtil.*;

/**
 * Maps internal vanilla swap (fixed/float IRS) to CDM 5 product structure.
 * Also serves as the base for OIS, basis swap, and other IRS variants.
 */
public final class VanillaSwapMapper {

    private VanillaSwapMapper() {}

    public static ContractualProduct map(SwapTrade trade) {
        return ContractualProduct.builder()
                .setProductTaxonomy(java.util.Collections.singletonList(
                        cdm.base.staticdata.asset.common.ProductTaxonomy.builder()
                                .setSource(cdm.base.staticdata.asset.common.TaxonomySourceEnum.ISDA)
                                .setProductQualifier("InterestRate_IRSwap_FixedFloat")))
                .setEconomicTerms(buildEconomicTerms(trade))
                .build();
    }

    private static EconomicTerms buildEconomicTerms(SwapTrade trade) {
        return EconomicTerms.builder()
                .setPayout(Payout.builder()
                        .addInterestRatePayout(buildFixedLeg(trade))
                        .addInterestRatePayout(buildFloatingLeg(trade)))
                .build();
    }

    static InterestRatePayout buildFixedLeg(SwapTrade trade) {
        InterestRatePayout.InterestRatePayoutBuilder builder = InterestRatePayout.builder()
                .setPayerReceiver(PayerReceiver.builder()
                        .setPayer(cdm.base.staticdata.party.CounterpartyRoleEnum.PARTY_1)
                        .setReceiver(cdm.base.staticdata.party.CounterpartyRoleEnum.PARTY_2))
                .setPriceQuantity(ResolvablePriceQuantity.builder()
                        .setQuantitySchedule(
                                cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule.builder()
                                        .setValue(NonNegativeQuantitySchedule.builder()
                                                .setValue(trade.getNotionalAmount())
                                                .setUnit(UnitType.builder()
                                                        .setCurrency(FieldWithMetaString.builder()
                                                                .setValue(trade.getNotionalCurrency()))))))
                .setRateSpecification(RateSpecification.builder()
                        .setFixedRate(FixedRateSpecification.builder()
                                .setRateSchedule(RateSchedule.builder()
                                        .setPrice(cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.builder()
                                                .setValue(PriceSchedule.builder()
                                                        .setValue(trade.getFixedRate())
                                                        .setPriceType(PriceTypeEnum.INTEREST_RATE))))))
                .setDayCountFraction(dayCountField(
                        trade.getFixedDayCount() != null ? trade.getFixedDayCount() : "30/360"))
                .setCalculationPeriodDates(buildCalcPeriodDates(trade,
                        trade.getPaymentFrequency() != null ? trade.getPaymentFrequency() : "6M"))
                .setPaymentDates(buildPaymentDates(
                        trade.getPaymentFrequency() != null ? trade.getPaymentFrequency() : "6M"));

        return builder.build();
    }

    static InterestRatePayout buildFloatingLeg(SwapTrade trade) {
        String resetTenor = trade.getResetFrequency() != null
                ? trade.getResetFrequency()
                : trade.getFloatingRateIndexTenor();

        InterestRatePayout.InterestRatePayoutBuilder builder = InterestRatePayout.builder()
                .setPayerReceiver(PayerReceiver.builder()
                        .setPayer(cdm.base.staticdata.party.CounterpartyRoleEnum.PARTY_2)
                        .setReceiver(cdm.base.staticdata.party.CounterpartyRoleEnum.PARTY_1))
                .setPriceQuantity(ResolvablePriceQuantity.builder()
                        .setQuantitySchedule(
                                cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule.builder()
                                        .setValue(NonNegativeQuantitySchedule.builder()
                                                .setValue(trade.getNotionalAmount())
                                                .setUnit(UnitType.builder()
                                                        .setCurrency(FieldWithMetaString.builder()
                                                                .setValue(trade.getNotionalCurrency()))))))
                .setRateSpecification(RateSpecification.builder()
                        .setFloatingRate(FloatingRateSpecification.builder()
                                .setRateOption(FloatingRateOption.builder()
                                        .setFloatingRateIndex(FloatingRateIndexEnum.valueOf(
                                                normalizeIndexName(trade.getFloatingRateIndex())))
                                        .setIndexTenor(parseFrequency(trade.getFloatingRateIndexTenor()) != null
                                                ? cdm.base.datetime.Period.builder()
                                                        .setPeriodMultiplier(parseFrequency(trade.getFloatingRateIndexTenor()).getPeriodMultiplier())
                                                        .setPeriod(parseFrequency(trade.getFloatingRateIndexTenor()).getPeriod())
                                                        .build()
                                                : null))))
                .setDayCountFraction(dayCountField(
                        trade.getFloatingDayCount() != null ? trade.getFloatingDayCount() : "ACT/360"))
                .setCalculationPeriodDates(buildCalcPeriodDates(trade, resetTenor))
                .setPaymentDates(buildPaymentDates(resetTenor))
                .setResetDates(ResetDates.builder()
                        .setResetFrequency(parseCalcFrequency(resetTenor))
                        .setResetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE));

        if (trade.getSpread() != null) {
            builder.getRateSpecification().getFloatingRate().toBuilder()
                    .setSpreadSchedule(SpreadSchedule.builder()
                            .setPrice(cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.builder()
                                    .setValue(PriceSchedule.builder()
                                            .setValue(trade.getSpread())
                                            .setPriceType(PriceTypeEnum.SPREAD))));
        }

        return builder.build();
    }

    static CalculationPeriodDates buildCalcPeriodDates(SwapTrade trade, String tenor) {
        return CalculationPeriodDates.builder()
                .setEffectiveDate(AdjustableOrRelativeDate.builder()
                        .setAdjustableDate(AdjustableDate.builder()
                                .setAdjustedDate(toDateField(trade.getEffectiveDate()))))
                .setTerminationDate(AdjustableOrRelativeDate.builder()
                        .setAdjustableDate(AdjustableDate.builder()
                                .setAdjustedDate(toDateField(trade.getTerminationDate()))))
                .setCalculationPeriodFrequency(parseCalcFrequency(tenor))
                .build();
    }

    static PaymentDates buildPaymentDates(String tenor) {
        return PaymentDates.builder()
                .setPaymentFrequency(parseFrequency(tenor))
                .build();
    }

    /**
     * Normalise index names to match CDM FloatingRateIndexEnum values.
     * E.g. "USD-SOFR" → "USD_SOFR", "EUR-EURIBOR-Reuters" → "EUR_EURIBOR_Reuters"
     */
    static String normalizeIndexName(String indexName) {
        if (indexName == null) return null;
        return indexName.replace("-", "_");
    }
}
