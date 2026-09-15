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
import fpml.consolidated.loan.meta.FixedRateOptionMeta;
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
 * Provision A structure that represents the accruing fixed rate option associated within a facility.
 *
 */
@RosettaDataType(value="FixedRateOption", builder=FixedRateOption.FixedRateOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FixedRateOption", model="fpml", builder=FixedRateOption.FixedRateOptionBuilderImpl.class, version="2.1.1")
public interface FixedRateOption extends AbstractFixedRateOptionBase {

	FixedRateOptionMeta metaData = new FixedRateOptionMeta();

	/*********************** Getter Methods  ***********************/
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
	Currency getCurrency();
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
	FixedRateOption build();
	
	FixedRateOption.FixedRateOptionBuilder toBuilder();
	
	static FixedRateOption.FixedRateOptionBuilder builder() {
		return new FixedRateOption.FixedRateOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRateOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedRateOption> getType() {
		return FixedRateOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.class, getAllInRateLimits());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
		processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
		processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateOptionBuilder extends FixedRateOption, AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits();
		@Override
		RateLimits.RateLimitsBuilder getAllInRateLimits();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference();
		@Override
		FixedRateOption.FixedRateOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		FixedRateOption.FixedRateOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		FixedRateOption.FixedRateOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		FixedRateOption.FixedRateOptionBuilder setRate(BigDecimal rate);
		@Override
		FixedRateOption.FixedRateOptionBuilder setPikSpread(BigDecimal pikSpread);
		FixedRateOption.FixedRateOptionBuilder setStartDate(ZonedDateTime startDate);
		FixedRateOption.FixedRateOptionBuilder setEndDate(ZonedDateTime endDate);
		FixedRateOption.FixedRateOptionBuilder setCurrency(Currency currency);
		FixedRateOption.FixedRateOptionBuilder setAllInRateLimits(RateLimits allInRateLimits);
		FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference);
		FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference, int idx);
		FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		FixedRateOption.FixedRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		FixedRateOption.FixedRateOptionBuilder setDrawdownNoticeDays(Integer drawdownNoticeDays);
		FixedRateOption.FixedRateOptionBuilder setFxRateSetNoticeDays(Integer fxRateSetNoticeDays);
		FixedRateOption.FixedRateOptionBuilder setRateSetNoticeDays(Integer rateSetNoticeDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getAllInRateLimits());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
			processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
			processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
		}
		

		FixedRateOption.FixedRateOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRateOption  ***********************/
	class FixedRateOptionImpl extends AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseImpl implements FixedRateOption {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Currency currency;
		private final RateLimits allInRateLimits;
		private final List<? extends PartyReference> borrowerPartyReference;
		private final Integer drawdownNoticeDays;
		private final Integer fxRateSetNoticeDays;
		private final Integer rateSetNoticeDays;
		
		protected FixedRateOptionImpl(FixedRateOption.FixedRateOptionBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.allInRateLimits = ofNullable(builder.getAllInRateLimits()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.drawdownNoticeDays = builder.getDrawdownNoticeDays();
			this.fxRateSetNoticeDays = builder.getFxRateSetNoticeDays();
			this.rateSetNoticeDays = builder.getRateSetNoticeDays();
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
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
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
		public FixedRateOption build() {
			return this;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder toBuilder() {
			FixedRateOption.FixedRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateOption.FixedRateOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
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
		
			FixedRateOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
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
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOption {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"currency=" + this.currency + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedRateOption  ***********************/
	class FixedRateOptionBuilderImpl extends AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilderImpl implements FixedRateOption.FixedRateOptionBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Currency.CurrencyBuilder currency;
		protected RateLimits.RateLimitsBuilder allInRateLimits;
		protected List<PartyReference.PartyReferenceBuilder> borrowerPartyReference = new ArrayList<>();
		protected Integer drawdownNoticeDays;
		protected Integer fxRateSetNoticeDays;
		protected Integer rateSetNoticeDays;
		
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
		public FixedRateOption.FixedRateOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInRateLimits")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setAllInRateLimits(RateLimits _allInRateLimits) {
			this.allInRateLimits = _allInRateLimits == null ? null : _allInRateLimits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		@Override
		public FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			if (_borrowerPartyReference != null) {
				this.borrowerPartyReference.add(_borrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference, int idx) {
			getIndex(this.borrowerPartyReference, idx, () -> _borrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
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
		public FixedRateOption.FixedRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
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
		public FixedRateOption.FixedRateOptionBuilder setDrawdownNoticeDays(Integer _drawdownNoticeDays) {
			this.drawdownNoticeDays = _drawdownNoticeDays == null ? null : _drawdownNoticeDays;
			return this;
		}
		
		@RosettaAttribute("fxRateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRateSetNoticeDays")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setFxRateSetNoticeDays(Integer _fxRateSetNoticeDays) {
			this.fxRateSetNoticeDays = _fxRateSetNoticeDays == null ? null : _fxRateSetNoticeDays;
			return this;
		}
		
		@RosettaAttribute("rateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSetNoticeDays")
		@Override
		public FixedRateOption.FixedRateOptionBuilder setRateSetNoticeDays(Integer _rateSetNoticeDays) {
			this.rateSetNoticeDays = _rateSetNoticeDays == null ? null : _rateSetNoticeDays;
			return this;
		}
		
		@Override
		public FixedRateOption build() {
			return new FixedRateOption.FixedRateOptionImpl(this);
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOption.FixedRateOptionBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (allInRateLimits!=null && !allInRateLimits.prune().hasData()) allInRateLimits = null;
			borrowerPartyReference = borrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getAllInRateLimits()!=null && getAllInRateLimits().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDrawdownNoticeDays()!=null) return true;
			if (getFxRateSetNoticeDays()!=null) return true;
			if (getRateSetNoticeDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOption.FixedRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FixedRateOption.FixedRateOptionBuilder o = (FixedRateOption.FixedRateOptionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
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
		
			FixedRateOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
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
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOptionBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"currency=" + this.currency + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}
}
