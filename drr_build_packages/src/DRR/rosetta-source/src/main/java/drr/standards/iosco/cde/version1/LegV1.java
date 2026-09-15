package drr.standards.iosco.cde.version1;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.quantity.NotionalPeriod;
import drr.standards.iosco.cde.version1.meta.LegV1Meta;
import drr.standards.iso.Direction2Enum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="LegV1", builder=LegV1.LegV1BuilderImpl.class, version="7.7.0")
@RuneDataType(value="LegV1", model="drr", builder=LegV1.LegV1BuilderImpl.class, version="7.7.0")
public interface LegV1 extends RosettaModelObject {

	LegV1Meta metaData = new LegV1Meta();

	/*********************** Getter Methods  ***********************/
	PeriodicPayment getPeriodicPayment();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "70"
	 *
	 * Provision For each leg of the transaction, where applicable:
	             - for OTC derivative transactions negotiated in monetary amounts, amount specified in the contract.
	             - for OTC derivative transactions negotiated in non-monetary amounts:
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "70"
	 *
	 * Provision - Commodity fixed/float swaps and similar products: Product of the fixed price and the total notional quantity.
	             - Commodity basis swaps and similar products: Product of the last available spot price at the time of the transaction of the underlying asset of the leg with no spread and the total notional quantity of the leg with no spread.
	             - Commodity options and similar products: Product of the strike price, and the total notional quantity.
	             - Commodity forwards and similar products: Product of the forward price and the total notional quantity
	             - Commodity swaptions and similar products: Notional amount of the underlying contract
	             - Commodity CFDs and similar products: Product of the initial price and the total notional quantity
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "70"
	 *
	 * Provision - Equity options and similar products: Product of the strike price and the number of shares or index units.
	             - Equity forwards and similar products: Product of the forward price and the number of shares or index units.
	             - Equity variance swaps and similar products: Variance amount.
	             - Equity dividend swaps and similar products: Product of the period fixed strike and the number of shares or index units
	             - Equity swaps, portfolio swaps, and similar products: Product of the initial price and the number of shares or index units
	             - Equity variance swaps and similar products: Variance amount
	             - Equity volatility swaps and similar products: Vega notional amount
	             - Equity CFDs and similar products: Product of the initial price and the number of shares or index units
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup ISDAWorkingGroup ISDA Working Group "This is an ISDA Working Group." 
	 * date "20210728"
	 *
	 * Provision CDEFXNotional is required due to jurisdictional specific leg level ordering.  When ordering rules are harmonised they could be combined with CDE rules
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup ISDAWorkingGroup ISDA Working Group "This is an ISDA Working Group." 
	 * date "20210728"
	 *
	 * Provision CDEForwardNotional is required due to jurisdictional specific leg level ordering.  When ordering rules are harmonised they could be combined with CDE rules
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup ISDAWorkingGroup ISDA Working Group "This is an ISDA Working Group." 
	 * date "20210728"
	 *
	 * Provision InterestRateNotional is required due to jurisdictional specific leg level ordering.  When ordering rules are harmonised they could be combined with CDE rules
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup ISDAWorkingGroup ISDA Working Group "This is an ISDA Working Group." 
	 * date "20210728"
	 *
	 * Provision See separate InterestRateNotional and FXNotional which is required due to jurisdictional specific leg level ordering. When ordering rules are harmonised they could be combined with CDE rules
	 *
	 */
	BigDecimal getNotionalAmount();
	/**
	 *
	 * effectiveDate
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "78.1"
	 *
	 * Provision Unadjusted date on which the associated notional amount of becomes effective.
	 *
	 *
	 * effectiveDate
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220811"
	 *
	 * Provision Model should contain a fall back for unadjustedDate when adjustedDate is only available. If an adjusted date is only provided then fields requiring an unadjusted date are left blank which will result in a NACK from the TR.  Functional rules should be updated to fall back on adjusted date if available.
	 *
	 *
	 * endDate
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "78.2"
	 *
	 * Provision Unadjusted end date of the notional amount (not applicable if the unadjusted end date of a given schedules period is back-to-back with the unadjusted effective date of the subsequent period).
	 *
	 *
	 * value
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "78.3"
	 *
	 * Provision Notional amount which becomes effective on the associated unadjusted effective date.
	 *
	 */
	List<? extends NotionalPeriod> getNotionalAmountSchedule();
	/**
	 *
	 * effectiveDate
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "80.1"
	 *
	 * Provision Unadjusted date on which the associated notional quantity of becomes effective.
	 *
	 *
	 * endDate
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "80.2"
	 *
	 * Provision Unadjusted end date of the notional quantity (not applicable if the unadjusted end date of a given schedules period is back-to-back with the unadjusted effective date of the subsequent period).
	 *
	 *
	 * value
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "80.3"
	 *
	 * Provision Notional quantity which becomes effective on the associated unadjusted effective date.
	 *
	 */
	List<? extends NotionalPeriod> getNotionalQuantitySchedule();
	ISOCurrencyCodeEnum getNotionalCurrency();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "79"
	 *
	 * Provision For each leg of the transaction, where applicable: aggregate Notional quantity of the underlying asset for the term of the transaction. Where the Total notional quantity is not known when a new transaction is reported, the Total notional quantity is updated as it becomes available.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240529"
	 *
	 * Provision This function only works with single tradeLot trades
	 *
	 */
	BigDecimal getTotalNotionalQuantity();
	BigDecimal getFixedRate();
	ISOCurrencyCodeEnum getSettlementCurrency();
	PriceFormat getSpread();
	PriceNotationEnum getSpreadNotation();
	ISOCurrencyCodeEnum getSpreadCurrency();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "77"
	 *
	 * Provision For each leg of the transaction, where applicable: unit of measure in which the Total notional quantity and the Notional quantity schedules are expressed.
	 *
	 */
	String getQuantityUnitOfMeasure();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "13.2"
	 *
	 * Provision Indicator of whether the reporting counterparty is the payer or the receiver of the leg as determined at the time of the    transaction.
	                 Or
	                 Identifier of the counterparty of the payer leg and the counterparty of the receiver leg as determined at the time of the transaction.
	                 A non-exhaustive list of examples of instruments for which this data element could apply are:
	                 - most swaps and swap-like contracts including interest rate swaps, credit total return swaps, and equity swaps (except for credit default swaps, variance, volatility, and correlation swaps)
	                 - foreign exchange swaps, forwards, non-deliverable forwards
	                 This data element is not applicable to instrument types covered by data elements Direction 1 or Buyer
	                 identifier and Seller identifier.
	 *
	 */
	Direction2Enum getDirection2();

	/*********************** Build Methods  ***********************/
	LegV1 build();
	
	LegV1.LegV1Builder toBuilder();
	
	static LegV1.LegV1Builder builder() {
		return new LegV1.LegV1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegV1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegV1> getType() {
		return LegV1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.class, getPeriodicPayment());
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processRosetta(path.newSubPath("notionalAmountSchedule"), processor, NotionalPeriod.class, getNotionalAmountSchedule());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, NotionalPeriod.class, getNotionalQuantitySchedule());
		processor.processBasic(path.newSubPath("notionalCurrency"), ISOCurrencyCodeEnum.class, getNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("settlementCurrency"), ISOCurrencyCodeEnum.class, getSettlementCurrency(), this);
		processRosetta(path.newSubPath("spread"), processor, PriceFormat.class, getSpread());
		processor.processBasic(path.newSubPath("spreadNotation"), PriceNotationEnum.class, getSpreadNotation(), this);
		processor.processBasic(path.newSubPath("spreadCurrency"), ISOCurrencyCodeEnum.class, getSpreadCurrency(), this);
		processor.processBasic(path.newSubPath("quantityUnitOfMeasure"), String.class, getQuantityUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("direction2"), Direction2Enum.class, getDirection2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegV1Builder extends LegV1, RosettaModelObjectBuilder {
		PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment();
		@Override
		PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment();
		NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalAmountSchedule(int index);
		@Override
		List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalAmountSchedule();
		NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalQuantitySchedule(int index);
		@Override
		List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalQuantitySchedule();
		PriceFormat.PriceFormatBuilder getOrCreateSpread();
		@Override
		PriceFormat.PriceFormatBuilder getSpread();
		LegV1.LegV1Builder setPeriodicPayment(PeriodicPayment periodicPayment);
		LegV1.LegV1Builder setNotionalAmount(BigDecimal notionalAmount);
		LegV1.LegV1Builder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule);
		LegV1.LegV1Builder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule, int idx);
		LegV1.LegV1Builder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		LegV1.LegV1Builder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		LegV1.LegV1Builder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule);
		LegV1.LegV1Builder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule, int idx);
		LegV1.LegV1Builder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		LegV1.LegV1Builder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		LegV1.LegV1Builder setNotionalCurrency(ISOCurrencyCodeEnum notionalCurrency);
		LegV1.LegV1Builder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		LegV1.LegV1Builder setFixedRate(BigDecimal fixedRate);
		LegV1.LegV1Builder setSettlementCurrency(ISOCurrencyCodeEnum settlementCurrency);
		LegV1.LegV1Builder setSpread(PriceFormat spread);
		LegV1.LegV1Builder setSpreadNotation(PriceNotationEnum spreadNotation);
		LegV1.LegV1Builder setSpreadCurrency(ISOCurrencyCodeEnum spreadCurrency);
		LegV1.LegV1Builder setQuantityUnitOfMeasure(String quantityUnitOfMeasure);
		LegV1.LegV1Builder setDirection2(Direction2Enum direction2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.PeriodicPaymentBuilder.class, getPeriodicPayment());
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processRosetta(path.newSubPath("notionalAmountSchedule"), processor, NotionalPeriod.NotionalPeriodBuilder.class, getNotionalAmountSchedule());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, NotionalPeriod.NotionalPeriodBuilder.class, getNotionalQuantitySchedule());
			processor.processBasic(path.newSubPath("notionalCurrency"), ISOCurrencyCodeEnum.class, getNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("settlementCurrency"), ISOCurrencyCodeEnum.class, getSettlementCurrency(), this);
			processRosetta(path.newSubPath("spread"), processor, PriceFormat.PriceFormatBuilder.class, getSpread());
			processor.processBasic(path.newSubPath("spreadNotation"), PriceNotationEnum.class, getSpreadNotation(), this);
			processor.processBasic(path.newSubPath("spreadCurrency"), ISOCurrencyCodeEnum.class, getSpreadCurrency(), this);
			processor.processBasic(path.newSubPath("quantityUnitOfMeasure"), String.class, getQuantityUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("direction2"), Direction2Enum.class, getDirection2(), this);
		}
		

		LegV1.LegV1Builder prune();
	}

	/*********************** Immutable Implementation of LegV1  ***********************/
	class LegV1Impl implements LegV1 {
		private final PeriodicPayment periodicPayment;
		private final BigDecimal notionalAmount;
		private final List<? extends NotionalPeriod> notionalAmountSchedule;
		private final List<? extends NotionalPeriod> notionalQuantitySchedule;
		private final ISOCurrencyCodeEnum notionalCurrency;
		private final BigDecimal totalNotionalQuantity;
		private final BigDecimal fixedRate;
		private final ISOCurrencyCodeEnum settlementCurrency;
		private final PriceFormat spread;
		private final PriceNotationEnum spreadNotation;
		private final ISOCurrencyCodeEnum spreadCurrency;
		private final String quantityUnitOfMeasure;
		private final Direction2Enum direction2;
		
		protected LegV1Impl(LegV1.LegV1Builder builder) {
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
			this.notionalAmount = builder.getNotionalAmount();
			this.notionalAmountSchedule = ofNullable(builder.getNotionalAmountSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notionalQuantitySchedule = ofNullable(builder.getNotionalQuantitySchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notionalCurrency = builder.getNotionalCurrency();
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
			this.fixedRate = builder.getFixedRate();
			this.settlementCurrency = builder.getSettlementCurrency();
			this.spread = ofNullable(builder.getSpread()).map(f->f.build()).orElse(null);
			this.spreadNotation = builder.getSpreadNotation();
			this.spreadCurrency = builder.getSpreadCurrency();
			this.quantityUnitOfMeasure = builder.getQuantityUnitOfMeasure();
			this.direction2 = builder.getDirection2();
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public PeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		public List<? extends NotionalPeriod> getNotionalAmountSchedule() {
			return notionalAmountSchedule;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		public List<? extends NotionalPeriod> getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency")
		public ISOCurrencyCodeEnum getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public ISOCurrencyCodeEnum getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public PriceFormat getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadNotation")
		public PriceNotationEnum getSpreadNotation() {
			return spreadNotation;
		}
		
		@Override
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadCurrency")
		public ISOCurrencyCodeEnum getSpreadCurrency() {
			return spreadCurrency;
		}
		
		@Override
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		public String getQuantityUnitOfMeasure() {
			return quantityUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction2")
		public Direction2Enum getDirection2() {
			return direction2;
		}
		
		@Override
		public LegV1 build() {
			return this;
		}
		
		@Override
		public LegV1.LegV1Builder toBuilder() {
			LegV1.LegV1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegV1.LegV1Builder builder) {
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalAmountSchedule()).ifPresent(builder::setNotionalAmountSchedule);
			ofNullable(getNotionalQuantitySchedule()).ifPresent(builder::setNotionalQuantitySchedule);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getSpreadNotation()).ifPresent(builder::setSpreadNotation);
			ofNullable(getSpreadCurrency()).ifPresent(builder::setSpreadCurrency);
			ofNullable(getQuantityUnitOfMeasure()).ifPresent(builder::setQuantityUnitOfMeasure);
			ofNullable(getDirection2()).ifPresent(builder::setDirection2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegV1 _that = getType().cast(o);
		
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(notionalAmountSchedule, _that.getNotionalAmountSchedule())) return false;
			if (!ListEquals.listEquals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(spreadNotation, _that.getSpreadNotation())) return false;
			if (!Objects.equals(spreadCurrency, _that.getSpreadCurrency())) return false;
			if (!Objects.equals(quantityUnitOfMeasure, _that.getQuantityUnitOfMeasure())) return false;
			if (!Objects.equals(direction2, _that.getDirection2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountSchedule != null ? notionalAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadNotation != null ? spreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadCurrency != null ? spreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityUnitOfMeasure != null ? quantityUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (direction2 != null ? direction2.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegV1 {" +
				"periodicPayment=" + this.periodicPayment + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountSchedule=" + this.notionalAmountSchedule + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalCurrency=" + this.notionalCurrency + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"spread=" + this.spread + ", " +
				"spreadNotation=" + this.spreadNotation + ", " +
				"spreadCurrency=" + this.spreadCurrency + ", " +
				"quantityUnitOfMeasure=" + this.quantityUnitOfMeasure + ", " +
				"direction2=" + this.direction2 +
			'}';
		}
	}

	/*********************** Builder Implementation of LegV1  ***********************/
	class LegV1BuilderImpl implements LegV1.LegV1Builder {
	
		protected PeriodicPayment.PeriodicPaymentBuilder periodicPayment;
		protected BigDecimal notionalAmount;
		protected List<NotionalPeriod.NotionalPeriodBuilder> notionalAmountSchedule = new ArrayList<>();
		protected List<NotionalPeriod.NotionalPeriodBuilder> notionalQuantitySchedule = new ArrayList<>();
		protected ISOCurrencyCodeEnum notionalCurrency;
		protected BigDecimal totalNotionalQuantity;
		protected BigDecimal fixedRate;
		protected ISOCurrencyCodeEnum settlementCurrency;
		protected PriceFormat.PriceFormatBuilder spread;
		protected PriceNotationEnum spreadNotation;
		protected ISOCurrencyCodeEnum spreadCurrency;
		protected String quantityUnitOfMeasure;
		protected Direction2Enum direction2;
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			PeriodicPayment.PeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = PeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		public List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalAmountSchedule() {
			return notionalAmountSchedule;
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalAmountSchedule(int index) {
			if (notionalAmountSchedule==null) {
				this.notionalAmountSchedule = new ArrayList<>();
			}
			return getIndex(notionalAmountSchedule, index, () -> {
						NotionalPeriod.NotionalPeriodBuilder newNotionalAmountSchedule = NotionalPeriod.builder();
						return newNotionalAmountSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		public List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalQuantitySchedule(int index) {
			if (notionalQuantitySchedule==null) {
				this.notionalQuantitySchedule = new ArrayList<>();
			}
			return getIndex(notionalQuantitySchedule, index, () -> {
						NotionalPeriod.NotionalPeriodBuilder newNotionalQuantitySchedule = NotionalPeriod.builder();
						return newNotionalQuantitySchedule;
					});
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency")
		public ISOCurrencyCodeEnum getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public ISOCurrencyCodeEnum getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public PriceFormat.PriceFormatBuilder getSpread() {
			return spread;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreateSpread() {
			PriceFormat.PriceFormatBuilder result;
			if (spread!=null) {
				result = spread;
			}
			else {
				result = spread = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadNotation")
		public PriceNotationEnum getSpreadNotation() {
			return spreadNotation;
		}
		
		@Override
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadCurrency")
		public ISOCurrencyCodeEnum getSpreadCurrency() {
			return spreadCurrency;
		}
		
		@Override
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		public String getQuantityUnitOfMeasure() {
			return quantityUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction2")
		public Direction2Enum getDirection2() {
			return direction2;
		}
		
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicPayment")
		@Override
		public LegV1.LegV1Builder setPeriodicPayment(PeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public LegV1.LegV1Builder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public LegV1.LegV1Builder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule) {
			if (_notionalAmountSchedule != null) {
				this.notionalAmountSchedule.add(_notionalAmountSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegV1.LegV1Builder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule, int idx) {
			getIndex(this.notionalAmountSchedule, idx, () -> _notionalAmountSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LegV1.LegV1Builder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
			if (notionalAmountSchedules != null) {
				for (final NotionalPeriod toAdd : notionalAmountSchedules) {
					this.notionalAmountSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public LegV1.LegV1Builder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
			if (notionalAmountSchedules == null) {
				this.notionalAmountSchedule = new ArrayList<>();
			} else {
				this.notionalAmountSchedule = notionalAmountSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public LegV1.LegV1Builder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule) {
			if (_notionalQuantitySchedule != null) {
				this.notionalQuantitySchedule.add(_notionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegV1.LegV1Builder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule, int idx) {
			getIndex(this.notionalQuantitySchedule, idx, () -> _notionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public LegV1.LegV1Builder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
			if (notionalQuantitySchedules != null) {
				for (final NotionalPeriod toAdd : notionalQuantitySchedules) {
					this.notionalQuantitySchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public LegV1.LegV1Builder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
			if (notionalQuantitySchedules == null) {
				this.notionalQuantitySchedule = new ArrayList<>();
			} else {
				this.notionalQuantitySchedule = notionalQuantitySchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalCurrency")
		@Override
		public LegV1.LegV1Builder setNotionalCurrency(ISOCurrencyCodeEnum _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public LegV1.LegV1Builder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public LegV1.LegV1Builder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public LegV1.LegV1Builder setSettlementCurrency(ISOCurrencyCodeEnum _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public LegV1.LegV1Builder setSpread(PriceFormat _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadNotation")
		@Override
		public LegV1.LegV1Builder setSpreadNotation(PriceNotationEnum _spreadNotation) {
			this.spreadNotation = _spreadNotation == null ? null : _spreadNotation;
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCurrency")
		@Override
		public LegV1.LegV1Builder setSpreadCurrency(ISOCurrencyCodeEnum _spreadCurrency) {
			this.spreadCurrency = _spreadCurrency == null ? null : _spreadCurrency;
			return this;
		}
		
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		@Override
		public LegV1.LegV1Builder setQuantityUnitOfMeasure(String _quantityUnitOfMeasure) {
			this.quantityUnitOfMeasure = _quantityUnitOfMeasure == null ? null : _quantityUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction2")
		@Override
		public LegV1.LegV1Builder setDirection2(Direction2Enum _direction2) {
			this.direction2 = _direction2 == null ? null : _direction2;
			return this;
		}
		
		@Override
		public LegV1 build() {
			return new LegV1.LegV1Impl(this);
		}
		
		@Override
		public LegV1.LegV1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegV1.LegV1Builder prune() {
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			notionalAmountSchedule = notionalAmountSchedule.stream().filter(b->b!=null).<NotionalPeriod.NotionalPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			notionalQuantitySchedule = notionalQuantitySchedule.stream().filter(b->b!=null).<NotionalPeriod.NotionalPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (spread!=null && !spread.prune().hasData()) spread = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			if (getNotionalAmount()!=null) return true;
			if (getNotionalAmountSchedule()!=null && getNotionalAmountSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getFixedRate()!=null) return true;
			if (getSettlementCurrency()!=null) return true;
			if (getSpread()!=null && getSpread().hasData()) return true;
			if (getSpreadNotation()!=null) return true;
			if (getSpreadCurrency()!=null) return true;
			if (getQuantityUnitOfMeasure()!=null) return true;
			if (getDirection2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegV1.LegV1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegV1.LegV1Builder o = (LegV1.LegV1Builder) other;
			
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			merger.mergeRosetta(getNotionalAmountSchedule(), o.getNotionalAmountSchedule(), this::getOrCreateNotionalAmountSchedule);
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::getOrCreateNotionalQuantitySchedule);
			merger.mergeRosetta(getSpread(), o.getSpread(), this::setSpread);
			
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeBasic(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeBasic(getSpreadNotation(), o.getSpreadNotation(), this::setSpreadNotation);
			merger.mergeBasic(getSpreadCurrency(), o.getSpreadCurrency(), this::setSpreadCurrency);
			merger.mergeBasic(getQuantityUnitOfMeasure(), o.getQuantityUnitOfMeasure(), this::setQuantityUnitOfMeasure);
			merger.mergeBasic(getDirection2(), o.getDirection2(), this::setDirection2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegV1 _that = getType().cast(o);
		
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(notionalAmountSchedule, _that.getNotionalAmountSchedule())) return false;
			if (!ListEquals.listEquals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(spreadNotation, _that.getSpreadNotation())) return false;
			if (!Objects.equals(spreadCurrency, _that.getSpreadCurrency())) return false;
			if (!Objects.equals(quantityUnitOfMeasure, _that.getQuantityUnitOfMeasure())) return false;
			if (!Objects.equals(direction2, _that.getDirection2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountSchedule != null ? notionalAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadNotation != null ? spreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadCurrency != null ? spreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityUnitOfMeasure != null ? quantityUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (direction2 != null ? direction2.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegV1Builder {" +
				"periodicPayment=" + this.periodicPayment + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountSchedule=" + this.notionalAmountSchedule + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalCurrency=" + this.notionalCurrency + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"spread=" + this.spread + ", " +
				"spreadNotation=" + this.spreadNotation + ", " +
				"spreadCurrency=" + this.spreadCurrency + ", " +
				"quantityUnitOfMeasure=" + this.quantityUnitOfMeasure + ", " +
				"direction2=" + this.direction2 +
			'}';
		}
	}
}
