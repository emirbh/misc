package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import fpml.consolidated.loan.meta.LegacyFloatingRateOptionMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents the legacy version (pre-IBOR replacement) of an accruing floating rate option associated within a facility.
 *
 */
@RosettaDataType(value="LegacyFloatingRateOption", builder=LegacyFloatingRateOption.LegacyFloatingRateOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegacyFloatingRateOption", model="fpml", builder=LegacyFloatingRateOption.LegacyFloatingRateOptionBuilderImpl.class, version="2.1.1")
public interface LegacyFloatingRateOption extends AbstractLegacyFloatingRateOptionBase {

	LegacyFloatingRateOptionMeta metaData = new LegacyFloatingRateOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	RateLimits getBaseRateLimits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	RateLimits getAllInRateLimits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the borrower(s) permitted to exercise the cash accrual option.
	 *
	 */
	List<? extends PartyReference> getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days that a lender must be notified prior to a drawdown event occurring.
	 *
	 */
	Integer getDrawdownNoticeDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days that a lender must be notified prior to an FX rate set event occurring.
	 *
	 */
	Integer getFxRateSetNoticeDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days that a lender must be notified prior to a rate set event occurring.
	 *
	 */
	Integer getRateSetNoticeDays();

	/*********************** Build Methods  ***********************/
	LegacyFloatingRateOption build();
	
	LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder toBuilder();
	
	static LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder builder() {
		return new LegacyFloatingRateOption.LegacyFloatingRateOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyFloatingRateOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyFloatingRateOption> getType() {
		return LegacyFloatingRateOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.class, getLegacyFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("baseRateLimits"), processor, RateLimits.class, getBaseRateLimits());
		processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.class, getAllInRateLimits());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
		processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
		processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyFloatingRateOptionBuilder extends LegacyFloatingRateOption, AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		RateLimits.RateLimitsBuilder getOrCreateBaseRateLimits();
		@Override
		RateLimits.RateLimitsBuilder getBaseRateLimits();
		RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits();
		@Override
		RateLimits.RateLimitsBuilder getAllInRateLimits();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference();
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan legacyFloatingRateIndex);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setIndexTenor(Period indexTenor);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setSpread(BigDecimal spread);
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setPikSpread(BigDecimal pikSpread);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setCurrency(Currency currency);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setStartDate(ZonedDateTime startDate);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setEndDate(ZonedDateTime endDate);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setBaseRateLimits(RateLimits baseRateLimits);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setAllInRateLimits(RateLimits allInRateLimits);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference, int idx);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setDrawdownNoticeDays(Integer drawdownNoticeDays);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setFxRateSetNoticeDays(Integer fxRateSetNoticeDays);
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setRateSetNoticeDays(Integer rateSetNoticeDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder.class, getLegacyFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("baseRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getBaseRateLimits());
			processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getAllInRateLimits());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
			processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
			processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
		}
		

		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyFloatingRateOption  ***********************/
	class LegacyFloatingRateOptionImpl extends AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseImpl implements LegacyFloatingRateOption {
		private final Currency currency;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final RateLimits baseRateLimits;
		private final RateLimits allInRateLimits;
		private final List<? extends PartyReference> borrowerPartyReference;
		private final Integer drawdownNoticeDays;
		private final Integer fxRateSetNoticeDays;
		private final Integer rateSetNoticeDays;
		
		protected LegacyFloatingRateOptionImpl(LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.baseRateLimits = ofNullable(builder.getBaseRateLimits()).map(f->f.build()).orElse(null);
			this.allInRateLimits = ofNullable(builder.getAllInRateLimits()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.drawdownNoticeDays = builder.getDrawdownNoticeDays();
			this.fxRateSetNoticeDays = builder.getFxRateSetNoticeDays();
			this.rateSetNoticeDays = builder.getRateSetNoticeDays();
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("baseRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRateLimits")
		public RateLimits getBaseRateLimits() {
			return baseRateLimits;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRateLimits")
		public RateLimits getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		public List<? extends PartyReference> getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("drawdownNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drawdownNoticeDays")
		public Integer getDrawdownNoticeDays() {
			return drawdownNoticeDays;
		}
		
		@Override
		@RosettaAttribute("fxRateSetNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRateSetNoticeDays")
		public Integer getFxRateSetNoticeDays() {
			return fxRateSetNoticeDays;
		}
		
		@Override
		@RosettaAttribute("rateSetNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSetNoticeDays")
		public Integer getRateSetNoticeDays() {
			return rateSetNoticeDays;
		}
		
		@Override
		public LegacyFloatingRateOption build() {
			return this;
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder toBuilder() {
			LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getBaseRateLimits()).ifPresent(builder::setBaseRateLimits);
			ofNullable(getAllInRateLimits()).ifPresent(builder::setAllInRateLimits);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getDrawdownNoticeDays()).ifPresent(builder::setDrawdownNoticeDays);
			ofNullable(getFxRateSetNoticeDays()).ifPresent(builder::setFxRateSetNoticeDays);
			ofNullable(getRateSetNoticeDays()).ifPresent(builder::setRateSetNoticeDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegacyFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(baseRateLimits, _that.getBaseRateLimits())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			if (!ListEquals.listEquals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(drawdownNoticeDays, _that.getDrawdownNoticeDays())) return false;
			if (!Objects.equals(fxRateSetNoticeDays, _that.getFxRateSetNoticeDays())) return false;
			if (!Objects.equals(rateSetNoticeDays, _that.getRateSetNoticeDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (baseRateLimits != null ? baseRateLimits.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateOption {" +
				"currency=" + this.currency + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"baseRateLimits=" + this.baseRateLimits + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LegacyFloatingRateOption  ***********************/
	class LegacyFloatingRateOptionBuilderImpl extends AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilderImpl implements LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected RateLimits.RateLimitsBuilder baseRateLimits;
		protected RateLimits.RateLimitsBuilder allInRateLimits;
		protected List<PartyReference.PartyReferenceBuilder> borrowerPartyReference = new ArrayList<>();
		protected Integer drawdownNoticeDays;
		protected Integer fxRateSetNoticeDays;
		protected Integer rateSetNoticeDays;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("baseRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRateLimits")
		public RateLimits.RateLimitsBuilder getBaseRateLimits() {
			return baseRateLimits;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder getOrCreateBaseRateLimits() {
			RateLimits.RateLimitsBuilder result;
			if (baseRateLimits!=null) {
				result = baseRateLimits;
			}
			else {
				result = baseRateLimits = RateLimits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRateLimits")
		public RateLimits.RateLimitsBuilder getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits() {
			RateLimits.RateLimitsBuilder result;
			if (allInRateLimits!=null) {
				result = allInRateLimits;
			}
			else {
				result = allInRateLimits = RateLimits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int index) {
			if (borrowerPartyReference==null) {
				this.borrowerPartyReference = new ArrayList<>();
			}
			return getIndex(borrowerPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newBorrowerPartyReference = PartyReference.builder();
						return newBorrowerPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("drawdownNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drawdownNoticeDays")
		public Integer getDrawdownNoticeDays() {
			return drawdownNoticeDays;
		}
		
		@Override
		@RosettaAttribute("fxRateSetNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRateSetNoticeDays")
		public Integer getFxRateSetNoticeDays() {
			return fxRateSetNoticeDays;
		}
		
		@Override
		@RosettaAttribute("rateSetNoticeDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSetNoticeDays")
		public Integer getRateSetNoticeDays() {
			return rateSetNoticeDays;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyFloatingRateIndex")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan _legacyFloatingRateIndex) {
			this.legacyFloatingRateIndex = _legacyFloatingRateIndex == null ? null : _legacyFloatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("spread")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("baseRateLimits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseRateLimits")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setBaseRateLimits(RateLimits _baseRateLimits) {
			this.baseRateLimits = _baseRateLimits == null ? null : _baseRateLimits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInRateLimits")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setAllInRateLimits(RateLimits _allInRateLimits) {
			this.allInRateLimits = _allInRateLimits == null ? null : _allInRateLimits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			if (_borrowerPartyReference != null) {
				this.borrowerPartyReference.add(_borrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference, int idx) {
			getIndex(this.borrowerPartyReference, idx, () -> _borrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
			if (borrowerPartyReferences != null) {
				for (final PartyReference toAdd : borrowerPartyReferences) {
					this.borrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
			if (borrowerPartyReferences == null) {
				this.borrowerPartyReference = new ArrayList<>();
			} else {
				this.borrowerPartyReference = borrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("drawdownNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drawdownNoticeDays")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setDrawdownNoticeDays(Integer _drawdownNoticeDays) {
			this.drawdownNoticeDays = _drawdownNoticeDays == null ? null : _drawdownNoticeDays;
			return this;
		}
		
		@RosettaAttribute("fxRateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRateSetNoticeDays")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setFxRateSetNoticeDays(Integer _fxRateSetNoticeDays) {
			this.fxRateSetNoticeDays = _fxRateSetNoticeDays == null ? null : _fxRateSetNoticeDays;
			return this;
		}
		
		@RosettaAttribute("rateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSetNoticeDays")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder setRateSetNoticeDays(Integer _rateSetNoticeDays) {
			this.rateSetNoticeDays = _rateSetNoticeDays == null ? null : _rateSetNoticeDays;
			return this;
		}
		
		@Override
		public LegacyFloatingRateOption build() {
			return new LegacyFloatingRateOption.LegacyFloatingRateOptionImpl(this);
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (baseRateLimits!=null && !baseRateLimits.prune().hasData()) baseRateLimits = null;
			if (allInRateLimits!=null && !allInRateLimits.prune().hasData()) allInRateLimits = null;
			borrowerPartyReference = borrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getBaseRateLimits()!=null && getBaseRateLimits().hasData()) return true;
			if (getAllInRateLimits()!=null && getAllInRateLimits().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDrawdownNoticeDays()!=null) return true;
			if (getFxRateSetNoticeDays()!=null) return true;
			if (getRateSetNoticeDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder o = (LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getBaseRateLimits(), o.getBaseRateLimits(), this::setBaseRateLimits);
			merger.mergeRosetta(getAllInRateLimits(), o.getAllInRateLimits(), this::setAllInRateLimits);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::getOrCreateBorrowerPartyReference);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getDrawdownNoticeDays(), o.getDrawdownNoticeDays(), this::setDrawdownNoticeDays);
			merger.mergeBasic(getFxRateSetNoticeDays(), o.getFxRateSetNoticeDays(), this::setFxRateSetNoticeDays);
			merger.mergeBasic(getRateSetNoticeDays(), o.getRateSetNoticeDays(), this::setRateSetNoticeDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegacyFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(baseRateLimits, _that.getBaseRateLimits())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			if (!ListEquals.listEquals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(drawdownNoticeDays, _that.getDrawdownNoticeDays())) return false;
			if (!Objects.equals(fxRateSetNoticeDays, _that.getFxRateSetNoticeDays())) return false;
			if (!Objects.equals(rateSetNoticeDays, _that.getRateSetNoticeDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (baseRateLimits != null ? baseRateLimits.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateOptionBuilder {" +
				"currency=" + this.currency + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"baseRateLimits=" + this.baseRateLimits + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}
}
