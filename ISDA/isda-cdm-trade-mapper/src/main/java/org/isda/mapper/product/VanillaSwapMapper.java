package org.isda.mapper.product;

import cdm.base.datetime.*;
import cdm.base.math.*;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.*;
import cdm.product.asset.*;
import cdm.product.common.schedule.*;
import cdm.product.common.settlement.*;
import cdm.product.template.*;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import org.isda.mapper.SwapTrade;
import org.isda.mapper.util.CdmBuilderUtil;

import java.math.BigDecimal;

import static org.isda.mapper.util.CdmBuilderUtil.*;

/**
 * Maps internal vanilla swap (fixed/float IRS) to CDM 6 product structure.
 * Also serves as the base for OIS, basis swap, and other IRS variants.
 */
public final class VanillaSwapMapper {

    private VanillaSwapMapper() {}

    public static NonTransferableProduct map(SwapTrade trade) {
        return NonTransferableProduct.builder()
                .setTaxonomy(java.util.Collections.singletonList(
                        cdm.base.staticdata.asset.common.ProductTaxonomy.builder()
                                .setSource(cdm.base.staticdata.asset.common.TaxonomySourceEnum.ISDA)
                                .setProductQualifier("InterestRate_IRSwap_FixedFloat")))
                .setEconomicTerms(buildEconomicTerms(trade))
                .build();
    }

    /**
     * CDM 6 holds one payout per Payout wrapper, so the fixed and floating
     * legs become two entries in the economic terms payout list.
     */
    private static EconomicTerms buildEconomicTerms(SwapTrade trade) {
        return EconomicTerms.builder()
                .addPayout(Payout.builder()
                        .setInterestRatePayout(buildFixedLeg(trade)))
                .addPayout(Payout.builder()
                        .setInterestRatePayout(buildFloatingLeg(trade)))
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
                        .setFixedRateSpecification(FixedRateSpecification.builder()
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
        if (trade.getFloatingRateIndex() == null) {
            throw new IllegalArgumentException(
                    "Product type '" + trade.getProductType() + "' has no floatingRateIndex and "
                            + "cannot be modelled as a fixed/float interest rate swap. "
                            + "It needs a dedicated product mapper.");
        }

        String resetTenor = trade.getResetFrequency() != null
                ? trade.getResetFrequency()
                : trade.getFloatingRateIndexTenor();

        FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRate =
                FloatingRateSpecification.builder()
                        .setRateOptionValue(InterestRateIndex.builder()
                                .setFloatingRateIndex(FloatingRateIndex.builder()
                                        .setFloatingRateIndexValue(FloatingRateIndexEnum.valueOf(
                                                normalizeIndexName(trade.getFloatingRateIndex())))
                                        .setIndexTenor(parsePeriod(trade.getFloatingRateIndexTenor()))));

        if (trade.getSpread() != null) {
            floatingRate.setSpreadSchedule(SpreadSchedule.builder()
                    .setPrice(cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.builder()
                            .setValue(PriceSchedule.builder()
                                    .setValue(trade.getSpread())
                                    .setPriceType(PriceTypeEnum.INTEREST_RATE)
                                    .setArithmeticOperator(ArithmeticOperationEnum.ADD)))
                    .build());
        }

        return InterestRatePayout.builder()
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
                        .setFloatingRateSpecification(floatingRate))
                .setDayCountFraction(dayCountField(
                        trade.getFloatingDayCount() != null ? trade.getFloatingDayCount() : "ACT/360"))
                .setCalculationPeriodDates(buildCalcPeriodDates(trade, resetTenor))
                .setPaymentDates(buildPaymentDates(resetTenor))
                .setResetDates(ResetDates.builder()
                        .setResetFrequency(parseResetFrequency(resetTenor))
                        .setResetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE))
                .build();
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
     * E.g. "USD-SOFR" → "USD_SOFR", "EUR-EURIBOR-Reuters" → "EUR_EURIBOR_REUTERS"
     */
    static String normalizeIndexName(String indexName) {
        if (indexName == null) return null;
        return indexName.replace("-", "_").toUpperCase(java.util.Locale.ROOT);
    }
}
