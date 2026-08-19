package org.isda.mapper.util;

import cdm.base.datetime.*;
import cdm.base.datetime.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.base.staticdata.party.*;
import cdm.event.common.TradeIdentifier;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.lib.records.Date;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CdmBuilderUtil {

    private static final Pattern TENOR_PATTERN = Pattern.compile("^(\\d+)([DWMY])$");

    private CdmBuilderUtil() {}

    /** Parse "3M", "1Y", "1D" etc. into a CDM Period. */
    public static Frequency parseFrequency(String tenor) {
        if (tenor == null) return null;
        Matcher m = TENOR_PATTERN.matcher(tenor);
        if (!m.matches()) throw new IllegalArgumentException("Invalid tenor: " + tenor);
        return Frequency.builder()
                .setPeriodMultiplier(Integer.parseInt(m.group(1)))
                .setPeriod(parsePeriodEnum(m.group(2)))
                .build();
    }

    public static PeriodExtendedEnum parsePeriodEnum(String code) {
        switch (code) {
            case "D": return PeriodExtendedEnum.D;
            case "W": return PeriodExtendedEnum.W;
            case "M": return PeriodExtendedEnum.M;
            case "Y": return PeriodExtendedEnum.Y;
            default: throw new IllegalArgumentException("Unknown period: " + code);
        }
    }

    public static CalculationPeriodFrequency parseCalcFrequency(String tenor) {
        if (tenor == null) return null;
        Matcher m = TENOR_PATTERN.matcher(tenor);
        if (!m.matches()) throw new IllegalArgumentException("Invalid tenor: " + tenor);
        return CalculationPeriodFrequency.builder()
                .setPeriodMultiplier(Integer.parseInt(m.group(1)))
                .setPeriod(parsePeriodEnum(m.group(2)))
                .build();
    }

    public static DayCountFractionEnum parseDayCount(String dc) {
        if (dc == null) return null;
        switch (dc) {
            case "ACT/360": return DayCountFractionEnum.ACT_360;
            case "ACT/365": return DayCountFractionEnum.ACT_365_FIXED;
            case "ACT/ACT": return DayCountFractionEnum.ACT_ACT_ISDA;
            case "30/360": return DayCountFractionEnum._30_360;
            case "30E/360": return DayCountFractionEnum._30E_360;
            case "ACT/365L": return DayCountFractionEnum.ACT_365L;
            case "BUS/252": return DayCountFractionEnum.BUS_252;
            default: throw new IllegalArgumentException("Unknown day count: " + dc);
        }
    }

    public static FieldWithMetaDayCountFractionEnum dayCountField(String dc) {
        return FieldWithMetaDayCountFractionEnum.builder()
                .setValue(parseDayCount(dc))
                .build();
    }

    public static BusinessDayConventionEnum parseBusinessDayConvention(String bdc) {
        if (bdc == null) return BusinessDayConventionEnum.MODFOLLOWING;
        switch (bdc) {
            case "FOLLOWING": return BusinessDayConventionEnum.FOLLOWING;
            case "MODFOLLOWING": return BusinessDayConventionEnum.MODFOLLOWING;
            case "PRECEDING": return BusinessDayConventionEnum.PRECEDING;
            case "MODPRECEDING": return BusinessDayConventionEnum.MODPRECEDING;
            case "NONE": return BusinessDayConventionEnum.NONE;
            default: return BusinessDayConventionEnum.MODFOLLOWING;
        }
    }

    public static Date toDate(LocalDate ld) {
        return Date.of(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
    }

    public static FieldWithMetaDate toDateField(LocalDate ld) {
        return FieldWithMetaDate.builder()
                .setValue(toDate(ld))
                .build();
    }

    public static AdjustableDate adjustableDate(LocalDate ld) {
        return AdjustableDate.builder()
                .setAdjustedDate(toDateField(ld))
                .build();
    }

    public static AdjustableOrRelativeDate adjustableOrRelativeDate(LocalDate ld) {
        return AdjustableOrRelativeDate.builder()
                .setAdjustableDate(adjustableDate(ld))
                .build();
    }

    public static Party buildParty(String externalKey, String lei, String name) {
        return Party.builder()
                .setMeta(MetaFields.builder().setExternalKey(externalKey))
                .addPartyId(PartyIdentifier.builder()
                        .setIdentifierType(PartyIdentifierTypeEnum.LEI)
                        .setIdentifier(FieldWithMetaString.builder().setValue(lei)))
                .setName(FieldWithMetaString.builder().setValue(name))
                .build();
    }

    public static TradeIdentifier buildTradeIdentifier(String lei, String tradeId, int version) {
        return TradeIdentifier.builder()
                .setIdentifierType(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER)
                .setIssuer(FieldWithMetaString.builder().setValue(lei))
                .addAssignedIdentifier(AssignedIdentifier.builder()
                        .setIdentifier(FieldWithMetaString.builder().setValue(tradeId))
                        .setVersion(version))
                .build();
    }

    public static FieldWithMetaNonNegativeQuantitySchedule quantityField(BigDecimal amount, String currency) {
        return FieldWithMetaNonNegativeQuantitySchedule.builder()
                .setValue(NonNegativeQuantitySchedule.builder()
                        .setValue(amount)
                        .setUnit(UnitType.builder()
                                .setCurrency(FieldWithMetaString.builder()
                                        .setValue(currency)
                                        .setMeta(MetaFields.builder()
                                                .setScheme("http://www.fpml.org/coding-scheme/external/iso4217")))))
                .build();
    }
}
