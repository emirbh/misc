package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CashSettlementTermsMeta;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.fpmlenum.ValuationMethodEnum;
import fpml.consolidated.option.shared.SettlementTerms;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CashSettlementTerms", builder=CashSettlementTerms.CashSettlementTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashSettlementTerms", model="fpml", builder=CashSettlementTerms.CashSettlementTermsBuilderImpl.class, version="2.1.1")
public interface CashSettlementTerms extends SettlementTerms {

	CashSettlementTermsMeta metaData = new CashSettlementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of business days after conditions to settlement have been satisfied when the calculation agent obtains a price quotation on the Reference Obligation for purposes of cash settlement. There may be one or more valuation dates. This is typically specified if the cash settlement amount is not a fixed amount. ISDA 2003 Term: Valuation Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days after conditions to settlement have been satisfied when the calculation agent obtains a price quotation on the Reference Obligation for purposes of cash settlement. There may be one or more valuation dates. This is typically specified if the cash settlement amount is not a fixed amount. ISDA 2003 Term: Valuation Date
	 *
	 */
	ValuationDate getValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time
	 *
	 */
	BusinessCenterTime getValuationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement. For example, Bid, Offer or Mid-market. ISDA 2003 Term: Quotation Method
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement. For example, Bid, Offer or Mid-market. ISDA 2003 Term: Quotation Method
	 *
	 */
	QuotationRateTypeEnum getQuotationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount
	 *
	 */
	Money getQuotationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount
	 *
	 */
	Money getMinimumQuotationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement. ISDA 2003 Term: Dealer
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement. ISDA 2003 Term: Dealer
	 *
	 */
	List<String> getDealer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of business days used in the determination of the cash settlement payment date. If a cash settlement amount is specified, the cash settlement payment date will be this number of business days following the calculation of the final price. If a cash settlement amount is not specified, the cash settlement payment date will be this number of business days after all conditions to settlement are satisfied. ISDA 2003 Term: Cash Settlement Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days used in the determination of the cash settlement payment date. If a cash settlement amount is specified, the cash settlement payment date will be this number of business days following the calculation of the final price. If a cash settlement amount is not specified, the cash settlement payment date will be this number of business days after all conditions to settlement are satisfied. ISDA 2003 Term: Cash Settlement Date
	 *
	 */
	Integer getCashSettlementBusinessDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
	 *
	 */
	Money getCashSettlementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used for fixed recovery, specifies the recovery level, determined at contract inception, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used for fixed recovery, specifies the recovery level, determined at contract inception, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
	 *
	 */
	BigDecimal getRecoveryFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and If Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and If Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
	 *
	 */
	Boolean getFixedSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest
	 *
	 */
	Boolean getAccruedInterest();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
	 *
	 */
	ValuationMethodEnum getValuationMethod();

	/*********************** Build Methods  ***********************/
	CashSettlementTerms build();
	
	CashSettlementTerms.CashSettlementTermsBuilder toBuilder();
	
	static CashSettlementTerms.CashSettlementTermsBuilder builder() {
		return new CashSettlementTerms.CashSettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashSettlementTerms> getType() {
		return CashSettlementTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.class, getValuationDate());
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
		processor.processBasic(path.newSubPath("quotationMethod"), QuotationRateTypeEnum.class, getQuotationMethod(), this);
		processRosetta(path.newSubPath("quotationAmount"), processor, Money.class, getQuotationAmount());
		processRosetta(path.newSubPath("minimumQuotationAmount"), processor, Money.class, getMinimumQuotationAmount());
		processor.processBasic(path.newSubPath("dealer"), String.class, getDealer(), this);
		processor.processBasic(path.newSubPath("cashSettlementBusinessDays"), Integer.class, getCashSettlementBusinessDays(), this);
		processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.class, getCashSettlementAmount());
		processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
		processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
		processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationMethodEnum.class, getValuationMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementTermsBuilder extends CashSettlementTerms, SettlementTerms.SettlementTermsBuilder {
		ValuationDate.ValuationDateBuilder getOrCreateValuationDate();
		@Override
		ValuationDate.ValuationDateBuilder getValuationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		Money.MoneyBuilder getOrCreateQuotationAmount();
		@Override
		Money.MoneyBuilder getQuotationAmount();
		Money.MoneyBuilder getOrCreateMinimumQuotationAmount();
		@Override
		Money.MoneyBuilder getMinimumQuotationAmount();
		Money.MoneyBuilder getOrCreateCashSettlementAmount();
		@Override
		Money.MoneyBuilder getCashSettlementAmount();
		@Override
		CashSettlementTerms.CashSettlementTermsBuilder setId(String id);
		@Override
		CashSettlementTerms.CashSettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate valuationDate);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime valuationTime);
		CashSettlementTerms.CashSettlementTermsBuilder setQuotationMethod(QuotationRateTypeEnum quotationMethod);
		CashSettlementTerms.CashSettlementTermsBuilder setQuotationAmount(Money quotationAmount);
		CashSettlementTerms.CashSettlementTermsBuilder setMinimumQuotationAmount(Money minimumQuotationAmount);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(String dealer, int idx);
		CashSettlementTerms.CashSettlementTermsBuilder addDealer(List<String> dealer);
		CashSettlementTerms.CashSettlementTermsBuilder setDealer(List<String> dealer);
		CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementBusinessDays(Integer cashSettlementBusinessDays);
		CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementAmount(Money cashSettlementAmount);
		CashSettlementTerms.CashSettlementTermsBuilder setRecoveryFactor(BigDecimal recoveryFactor);
		CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean fixedSettlement);
		CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean accruedInterest);
		CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethodEnum valuationMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("valuationDate"), processor, ValuationDate.ValuationDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
			processor.processBasic(path.newSubPath("quotationMethod"), QuotationRateTypeEnum.class, getQuotationMethod(), this);
			processRosetta(path.newSubPath("quotationAmount"), processor, Money.MoneyBuilder.class, getQuotationAmount());
			processRosetta(path.newSubPath("minimumQuotationAmount"), processor, Money.MoneyBuilder.class, getMinimumQuotationAmount());
			processor.processBasic(path.newSubPath("dealer"), String.class, getDealer(), this);
			processor.processBasic(path.newSubPath("cashSettlementBusinessDays"), Integer.class, getCashSettlementBusinessDays(), this);
			processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.MoneyBuilder.class, getCashSettlementAmount());
			processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
			processor.processBasic(path.newSubPath("fixedSettlement"), Boolean.class, getFixedSettlement(), this);
			processor.processBasic(path.newSubPath("accruedInterest"), Boolean.class, getAccruedInterest(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationMethodEnum.class, getValuationMethod(), this);
		}
		

		CashSettlementTerms.CashSettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementTerms  ***********************/
	class CashSettlementTermsImpl extends SettlementTerms.SettlementTermsImpl implements CashSettlementTerms {
		private final ValuationDate valuationDate;
		private final BusinessCenterTime valuationTime;
		private final QuotationRateTypeEnum quotationMethod;
		private final Money quotationAmount;
		private final Money minimumQuotationAmount;
		private final List<String> dealer;
		private final Integer cashSettlementBusinessDays;
		private final Money cashSettlementAmount;
		private final BigDecimal recoveryFactor;
		private final Boolean fixedSettlement;
		private final Boolean accruedInterest;
		private final ValuationMethodEnum valuationMethod;
		
		protected CashSettlementTermsImpl(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			super(builder);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
			this.quotationMethod = builder.getQuotationMethod();
			this.quotationAmount = ofNullable(builder.getQuotationAmount()).map(f->f.build()).orElse(null);
			this.minimumQuotationAmount = ofNullable(builder.getMinimumQuotationAmount()).map(f->f.build()).orElse(null);
			this.dealer = ofNullable(builder.getDealer()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cashSettlementBusinessDays = builder.getCashSettlementBusinessDays();
			this.cashSettlementAmount = ofNullable(builder.getCashSettlementAmount()).map(f->f.build()).orElse(null);
			this.recoveryFactor = builder.getRecoveryFactor();
			this.fixedSettlement = builder.getFixedSettlement();
			this.accruedInterest = builder.getAccruedInterest();
			this.valuationMethod = builder.getValuationMethod();
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ValuationDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTime")
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		@RosettaAttribute("quotationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationMethod")
		public QuotationRateTypeEnum getQuotationMethod() {
			return quotationMethod;
		}
		
		@Override
		@RosettaAttribute("quotationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationAmount")
		public Money getQuotationAmount() {
			return quotationAmount;
		}
		
		@Override
		@RosettaAttribute("minimumQuotationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumQuotationAmount")
		public Money getMinimumQuotationAmount() {
			return minimumQuotationAmount;
		}
		
		@Override
		@RosettaAttribute("dealer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealer")
		public List<String> getDealer() {
			return dealer;
		}
		
		@Override
		@RosettaAttribute("cashSettlementBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementBusinessDays")
		public Integer getCashSettlementBusinessDays() {
			return cashSettlementBusinessDays;
		}
		
		@Override
		@RosettaAttribute("cashSettlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementAmount")
		public Money getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		@RosettaAttribute("recoveryFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryFactor")
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		@RosettaAttribute("fixedSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedSettlement")
		public Boolean getFixedSettlement() {
			return fixedSettlement;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterest")
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationMethod")
		public ValuationMethodEnum getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		public CashSettlementTerms build() {
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			CashSettlementTerms.CashSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementTerms.CashSettlementTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
			ofNullable(getQuotationMethod()).ifPresent(builder::setQuotationMethod);
			ofNullable(getQuotationAmount()).ifPresent(builder::setQuotationAmount);
			ofNullable(getMinimumQuotationAmount()).ifPresent(builder::setMinimumQuotationAmount);
			ofNullable(getDealer()).ifPresent(builder::setDealer);
			ofNullable(getCashSettlementBusinessDays()).ifPresent(builder::setCashSettlementBusinessDays);
			ofNullable(getCashSettlementAmount()).ifPresent(builder::setCashSettlementAmount);
			ofNullable(getRecoveryFactor()).ifPresent(builder::setRecoveryFactor);
			ofNullable(getFixedSettlement()).ifPresent(builder::setFixedSettlement);
			ofNullable(getAccruedInterest()).ifPresent(builder::setAccruedInterest);
			ofNullable(getValuationMethod()).ifPresent(builder::setValuationMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(quotationMethod, _that.getQuotationMethod())) return false;
			if (!Objects.equals(quotationAmount, _that.getQuotationAmount())) return false;
			if (!Objects.equals(minimumQuotationAmount, _that.getMinimumQuotationAmount())) return false;
			if (!ListEquals.listEquals(dealer, _that.getDealer())) return false;
			if (!Objects.equals(cashSettlementBusinessDays, _that.getCashSettlementBusinessDays())) return false;
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (quotationMethod != null ? quotationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotationAmount != null ? quotationAmount.hashCode() : 0);
			_result = 31 * _result + (minimumQuotationAmount != null ? minimumQuotationAmount.hashCode() : 0);
			_result = 31 * _result + (dealer != null ? dealer.hashCode() : 0);
			_result = 31 * _result + (cashSettlementBusinessDays != null ? cashSettlementBusinessDays.hashCode() : 0);
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTerms {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"quotationMethod=" + this.quotationMethod + ", " +
				"quotationAmount=" + this.quotationAmount + ", " +
				"minimumQuotationAmount=" + this.minimumQuotationAmount + ", " +
				"dealer=" + this.dealer + ", " +
				"cashSettlementBusinessDays=" + this.cashSettlementBusinessDays + ", " +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"recoveryFactor=" + this.recoveryFactor + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"accruedInterest=" + this.accruedInterest + ", " +
				"valuationMethod=" + this.valuationMethod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CashSettlementTerms  ***********************/
	class CashSettlementTermsBuilderImpl extends SettlementTerms.SettlementTermsBuilderImpl implements CashSettlementTerms.CashSettlementTermsBuilder {
	
		protected ValuationDate.ValuationDateBuilder valuationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
		protected QuotationRateTypeEnum quotationMethod;
		protected Money.MoneyBuilder quotationAmount;
		protected Money.MoneyBuilder minimumQuotationAmount;
		protected List<String> dealer = new ArrayList<>();
		protected Integer cashSettlementBusinessDays;
		protected Money.MoneyBuilder cashSettlementAmount;
		protected BigDecimal recoveryFactor;
		protected Boolean fixedSettlement;
		protected Boolean accruedInterest;
		protected ValuationMethodEnum valuationMethod;
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ValuationDate.ValuationDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder getOrCreateValuationDate() {
			ValuationDate.ValuationDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = ValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationMethod")
		public QuotationRateTypeEnum getQuotationMethod() {
			return quotationMethod;
		}
		
		@Override
		@RosettaAttribute("quotationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationAmount")
		public Money.MoneyBuilder getQuotationAmount() {
			return quotationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateQuotationAmount() {
			Money.MoneyBuilder result;
			if (quotationAmount!=null) {
				result = quotationAmount;
			}
			else {
				result = quotationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumQuotationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumQuotationAmount")
		public Money.MoneyBuilder getMinimumQuotationAmount() {
			return minimumQuotationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumQuotationAmount() {
			Money.MoneyBuilder result;
			if (minimumQuotationAmount!=null) {
				result = minimumQuotationAmount;
			}
			else {
				result = minimumQuotationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealer")
		public List<String> getDealer() {
			return dealer;
		}
		
		@Override
		@RosettaAttribute("cashSettlementBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementBusinessDays")
		public Integer getCashSettlementBusinessDays() {
			return cashSettlementBusinessDays;
		}
		
		@Override
		@RosettaAttribute("cashSettlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementAmount")
		public Money.MoneyBuilder getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashSettlementAmount() {
			Money.MoneyBuilder result;
			if (cashSettlementAmount!=null) {
				result = cashSettlementAmount;
			}
			else {
				result = cashSettlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryFactor")
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		@RosettaAttribute("fixedSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedSettlement")
		public Boolean getFixedSettlement() {
			return fixedSettlement;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterest")
		public Boolean getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationMethod")
		public ValuationMethodEnum getValuationMethod() {
			return valuationMethod;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationDate(ValuationDate _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTime")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationTime(BusinessCenterTime _valuationTime) {
			this.valuationTime = _valuationTime == null ? null : _valuationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationMethod")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setQuotationMethod(QuotationRateTypeEnum _quotationMethod) {
			this.quotationMethod = _quotationMethod == null ? null : _quotationMethod;
			return this;
		}
		
		@RosettaAttribute("quotationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationAmount")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setQuotationAmount(Money _quotationAmount) {
			this.quotationAmount = _quotationAmount == null ? null : _quotationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumQuotationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumQuotationAmount")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setMinimumQuotationAmount(Money _minimumQuotationAmount) {
			this.minimumQuotationAmount = _minimumQuotationAmount == null ? null : _minimumQuotationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealer")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dealer")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(String _dealer) {
			if (_dealer != null) {
				this.dealer.add(_dealer);
			}
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(String _dealer, int idx) {
			getIndex(this.dealer, idx, () -> _dealer);
			return this;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder addDealer(List<String> dealers) {
			if (dealers != null) {
				for (final String toAdd : dealers) {
					this.dealer.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealer")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dealer")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setDealer(List<String> dealers) {
			if (dealers == null) {
				this.dealer = new ArrayList<>();
			} else {
				this.dealer = dealers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlementBusinessDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementBusinessDays")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementBusinessDays(Integer _cashSettlementBusinessDays) {
			this.cashSettlementBusinessDays = _cashSettlementBusinessDays == null ? null : _cashSettlementBusinessDays;
			return this;
		}
		
		@RosettaAttribute("cashSettlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementAmount")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setCashSettlementAmount(Money _cashSettlementAmount) {
			this.cashSettlementAmount = _cashSettlementAmount == null ? null : _cashSettlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("recoveryFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recoveryFactor")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setRecoveryFactor(BigDecimal _recoveryFactor) {
			this.recoveryFactor = _recoveryFactor == null ? null : _recoveryFactor;
			return this;
		}
		
		@RosettaAttribute("fixedSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedSettlement")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setFixedSettlement(Boolean _fixedSettlement) {
			this.fixedSettlement = _fixedSettlement == null ? null : _fixedSettlement;
			return this;
		}
		
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruedInterest")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setAccruedInterest(Boolean _accruedInterest) {
			this.accruedInterest = _accruedInterest == null ? null : _accruedInterest;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder setValuationMethod(ValuationMethodEnum _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@Override
		public CashSettlementTerms build() {
			return new CashSettlementTerms.CashSettlementTermsImpl(this);
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder prune() {
			super.prune();
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			if (quotationAmount!=null && !quotationAmount.prune().hasData()) quotationAmount = null;
			if (minimumQuotationAmount!=null && !minimumQuotationAmount.prune().hasData()) minimumQuotationAmount = null;
			if (cashSettlementAmount!=null && !cashSettlementAmount.prune().hasData()) cashSettlementAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			if (getQuotationMethod()!=null) return true;
			if (getQuotationAmount()!=null && getQuotationAmount().hasData()) return true;
			if (getMinimumQuotationAmount()!=null && getMinimumQuotationAmount().hasData()) return true;
			if (getDealer()!=null && !getDealer().isEmpty()) return true;
			if (getCashSettlementBusinessDays()!=null) return true;
			if (getCashSettlementAmount()!=null && getCashSettlementAmount().hasData()) return true;
			if (getRecoveryFactor()!=null) return true;
			if (getFixedSettlement()!=null) return true;
			if (getAccruedInterest()!=null) return true;
			if (getValuationMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CashSettlementTerms.CashSettlementTermsBuilder o = (CashSettlementTerms.CashSettlementTermsBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			merger.mergeRosetta(getQuotationAmount(), o.getQuotationAmount(), this::setQuotationAmount);
			merger.mergeRosetta(getMinimumQuotationAmount(), o.getMinimumQuotationAmount(), this::setMinimumQuotationAmount);
			merger.mergeRosetta(getCashSettlementAmount(), o.getCashSettlementAmount(), this::setCashSettlementAmount);
			
			merger.mergeBasic(getQuotationMethod(), o.getQuotationMethod(), this::setQuotationMethod);
			merger.mergeBasic(getDealer(), o.getDealer(), (Consumer<String>) this::addDealer);
			merger.mergeBasic(getCashSettlementBusinessDays(), o.getCashSettlementBusinessDays(), this::setCashSettlementBusinessDays);
			merger.mergeBasic(getRecoveryFactor(), o.getRecoveryFactor(), this::setRecoveryFactor);
			merger.mergeBasic(getFixedSettlement(), o.getFixedSettlement(), this::setFixedSettlement);
			merger.mergeBasic(getAccruedInterest(), o.getAccruedInterest(), this::setAccruedInterest);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(quotationMethod, _that.getQuotationMethod())) return false;
			if (!Objects.equals(quotationAmount, _that.getQuotationAmount())) return false;
			if (!Objects.equals(minimumQuotationAmount, _that.getMinimumQuotationAmount())) return false;
			if (!ListEquals.listEquals(dealer, _that.getDealer())) return false;
			if (!Objects.equals(cashSettlementBusinessDays, _that.getCashSettlementBusinessDays())) return false;
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			if (!Objects.equals(fixedSettlement, _that.getFixedSettlement())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (quotationMethod != null ? quotationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotationAmount != null ? quotationAmount.hashCode() : 0);
			_result = 31 * _result + (minimumQuotationAmount != null ? minimumQuotationAmount.hashCode() : 0);
			_result = 31 * _result + (dealer != null ? dealer.hashCode() : 0);
			_result = 31 * _result + (cashSettlementBusinessDays != null ? cashSettlementBusinessDays.hashCode() : 0);
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			_result = 31 * _result + (fixedSettlement != null ? fixedSettlement.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementTermsBuilder {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"quotationMethod=" + this.quotationMethod + ", " +
				"quotationAmount=" + this.quotationAmount + ", " +
				"minimumQuotationAmount=" + this.minimumQuotationAmount + ", " +
				"dealer=" + this.dealer + ", " +
				"cashSettlementBusinessDays=" + this.cashSettlementBusinessDays + ", " +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"recoveryFactor=" + this.recoveryFactor + ", " +
				"fixedSettlement=" + this.fixedSettlement + ", " +
				"accruedInterest=" + this.accruedInterest + ", " +
				"valuationMethod=" + this.valuationMethod +
			'}' + " " + super.toString();
		}
	}
}
