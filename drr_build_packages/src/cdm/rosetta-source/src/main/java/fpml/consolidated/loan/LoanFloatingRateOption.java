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
import fpml.consolidated.loan.meta.LoanFloatingRateOptionMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
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
 * Provision A structure that represents the accruing floating rate option associated within a facility.
 *
 */
@RosettaDataType(value="LoanFloatingRateOption", builder=LoanFloatingRateOption.LoanFloatingRateOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanFloatingRateOption", model="fpml", builder=LoanFloatingRateOption.LoanFloatingRateOptionBuilderImpl.class, version="2.1.1")
public interface LoanFloatingRateOption extends AbstractLoanFloatingRateOptionBase {

	LoanFloatingRateOptionMeta metaData = new LoanFloatingRateOptionMeta();

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
	LoanFloatingRateOption build();
	
	LoanFloatingRateOption.LoanFloatingRateOptionBuilder toBuilder();
	
	static LoanFloatingRateOption.LoanFloatingRateOptionBuilder builder() {
		return new LoanFloatingRateOption.LoanFloatingRateOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanFloatingRateOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanFloatingRateOption> getType() {
		return LoanFloatingRateOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.class, getRate());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
		processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
		processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanFloatingRateOptionBuilder extends LoanFloatingRateOption, AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference();
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setRate(LoanFloatingRate rate);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setCurrency(Currency currency);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setStartDate(ZonedDateTime startDate);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setEndDate(ZonedDateTime endDate);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference, int idx);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setDrawdownNoticeDays(Integer drawdownNoticeDays);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setFxRateSetNoticeDays(Integer fxRateSetNoticeDays);
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder setRateSetNoticeDays(Integer rateSetNoticeDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.LoanFloatingRateBuilder.class, getRate());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
			processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
			processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
		}
		

		LoanFloatingRateOption.LoanFloatingRateOptionBuilder prune();
	}

	/*********************** Immutable Implementation of LoanFloatingRateOption  ***********************/
	class LoanFloatingRateOptionImpl extends AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseImpl implements LoanFloatingRateOption {
		private final Currency currency;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final List<? extends PartyReference> borrowerPartyReference;
		private final Integer drawdownNoticeDays;
		private final Integer fxRateSetNoticeDays;
		private final Integer rateSetNoticeDays;
		
		protected LoanFloatingRateOptionImpl(LoanFloatingRateOption.LoanFloatingRateOptionBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
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
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
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
		public LoanFloatingRateOption build() {
			return this;
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder toBuilder() {
			LoanFloatingRateOption.LoanFloatingRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanFloatingRateOption.LoanFloatingRateOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
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
		
			LoanFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
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
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRateOption {" +
				"currency=" + this.currency + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanFloatingRateOption  ***********************/
	class LoanFloatingRateOptionBuilderImpl extends AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilderImpl implements LoanFloatingRateOption.LoanFloatingRateOptionBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
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
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
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
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setRate(LoanFloatingRate _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			if (_borrowerPartyReference != null) {
				this.borrowerPartyReference.add(_borrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(PartyReference _borrowerPartyReference, int idx) {
			getIndex(this.borrowerPartyReference, idx, () -> _borrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
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
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
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
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setDrawdownNoticeDays(Integer _drawdownNoticeDays) {
			this.drawdownNoticeDays = _drawdownNoticeDays == null ? null : _drawdownNoticeDays;
			return this;
		}
		
		@RosettaAttribute("fxRateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRateSetNoticeDays")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setFxRateSetNoticeDays(Integer _fxRateSetNoticeDays) {
			this.fxRateSetNoticeDays = _fxRateSetNoticeDays == null ? null : _fxRateSetNoticeDays;
			return this;
		}
		
		@RosettaAttribute("rateSetNoticeDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSetNoticeDays")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder setRateSetNoticeDays(Integer _rateSetNoticeDays) {
			this.rateSetNoticeDays = _rateSetNoticeDays == null ? null : _rateSetNoticeDays;
			return this;
		}
		
		@Override
		public LoanFloatingRateOption build() {
			return new LoanFloatingRateOption.LoanFloatingRateOptionImpl(this);
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			borrowerPartyReference = borrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDrawdownNoticeDays()!=null) return true;
			if (getFxRateSetNoticeDays()!=null) return true;
			if (getRateSetNoticeDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanFloatingRateOption.LoanFloatingRateOptionBuilder o = (LoanFloatingRateOption.LoanFloatingRateOptionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
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
		
			LoanFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
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
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRateOptionBuilder {" +
				"currency=" + this.currency + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}
}
