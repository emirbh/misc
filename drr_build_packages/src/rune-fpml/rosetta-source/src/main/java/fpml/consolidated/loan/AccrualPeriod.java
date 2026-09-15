package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.fpmlenum.AccrualReferenceAmountTypeEnum;
import fpml.consolidated.loan.meta.AccrualPeriodMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that describes the details of the underlying elements that explain the calculation of an accrual against a reference balance.
 *
 */
@RosettaDataType(value="AccrualPeriod", builder=AccrualPeriod.AccrualPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccrualPeriod", model="fpml", builder=AccrualPeriod.AccrualPeriodBuilderImpl.class, version="2.1.1")
public interface AccrualPeriod extends RosettaModelObject {

	AccrualPeriodMeta metaData = new AccrualPeriodMeta();

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
	 * Provision The actual number of days represented within the 'period'. This takes into account counting the appropriate convention.
	 *
	 */
	Integer getNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Global and lender share amounts.
	 *
	 */
	MoneyWithParticipantShare getReferenceAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the amount referenced in the accrual schedule calculation, based on an enumeration.
	 *
	 */
	AccrualReferenceAmountTypeEnum getReferenceAmountType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The aggregate rate applied to the accrual period. E.g. for loans, this is the all-in rate and for letters of credit this is the LC accruing fee rate.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The base rate applied to this period. In the case of a loan accrual period, some examples of this rate include the prime rate, the risk-free rate, or a legacy index rate.
	 *
	 */
	BigDecimal getBaseRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculated compounded rate applied to this period. This element is utilized if a accrual compounding method type (from the AccrualCompoundingMethod) of 'CompoundingRate' is selected.
	 *
	 */
	BigDecimal getCompoundedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An amount to be added to the calculated value before subsequent use, in order to more closely replicate the original term rate, by adjusting for the economic or credit spread between risk-free rates and risky term rates.
	 *
	 */
	BigDecimal getSpreadAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure representing additional adjustments to the base rate
	 *
	 */
	RateAdjustment getRateAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The accrual amount over the defined period.
	 *
	 */
	MoneyWithParticipantShare getAccrualAmount();

	/*********************** Build Methods  ***********************/
	AccrualPeriod build();
	
	AccrualPeriod.AccrualPeriodBuilder toBuilder();
	
	static AccrualPeriod.AccrualPeriodBuilder builder() {
		return new AccrualPeriod.AccrualPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccrualPeriod> getType() {
		return AccrualPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.class, getReferenceAmount());
		processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
		processor.processBasic(path.newSubPath("compoundedRate"), BigDecimal.class, getCompoundedRate(), this);
		processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
		processRosetta(path.newSubPath("rateAdjustment"), processor, RateAdjustment.class, getRateAdjustment());
		processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.class, getAccrualAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualPeriodBuilder extends AccrualPeriod, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateReferenceAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getReferenceAmount();
		RateAdjustment.RateAdjustmentBuilder getOrCreateRateAdjustment();
		@Override
		RateAdjustment.RateAdjustmentBuilder getRateAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAccrualAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAccrualAmount();
		AccrualPeriod.AccrualPeriodBuilder setStartDate(ZonedDateTime startDate);
		AccrualPeriod.AccrualPeriodBuilder setEndDate(ZonedDateTime endDate);
		AccrualPeriod.AccrualPeriodBuilder setNumberOfDays(Integer numberOfDays);
		AccrualPeriod.AccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare referenceAmount);
		AccrualPeriod.AccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum referenceAmountType);
		AccrualPeriod.AccrualPeriodBuilder setRate(BigDecimal rate);
		AccrualPeriod.AccrualPeriodBuilder setBaseRate(BigDecimal baseRate);
		AccrualPeriod.AccrualPeriodBuilder setCompoundedRate(BigDecimal compoundedRate);
		AccrualPeriod.AccrualPeriodBuilder setSpreadAdjustment(BigDecimal spreadAdjustment);
		AccrualPeriod.AccrualPeriodBuilder setRateAdjustment(RateAdjustment rateAdjustment);
		AccrualPeriod.AccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare accrualAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getReferenceAmount());
			processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
			processor.processBasic(path.newSubPath("compoundedRate"), BigDecimal.class, getCompoundedRate(), this);
			processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
			processRosetta(path.newSubPath("rateAdjustment"), processor, RateAdjustment.RateAdjustmentBuilder.class, getRateAdjustment());
			processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAccrualAmount());
		}
		

		AccrualPeriod.AccrualPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualPeriod  ***********************/
	class AccrualPeriodImpl implements AccrualPeriod {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfDays;
		private final MoneyWithParticipantShare referenceAmount;
		private final AccrualReferenceAmountTypeEnum referenceAmountType;
		private final BigDecimal rate;
		private final BigDecimal baseRate;
		private final BigDecimal compoundedRate;
		private final BigDecimal spreadAdjustment;
		private final RateAdjustment rateAdjustment;
		private final MoneyWithParticipantShare accrualAmount;
		
		protected AccrualPeriodImpl(AccrualPeriod.AccrualPeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.referenceAmount = ofNullable(builder.getReferenceAmount()).map(f->f.build()).orElse(null);
			this.referenceAmountType = builder.getReferenceAmountType();
			this.rate = builder.getRate();
			this.baseRate = builder.getBaseRate();
			this.compoundedRate = builder.getCompoundedRate();
			this.spreadAdjustment = builder.getSpreadAdjustment();
			this.rateAdjustment = ofNullable(builder.getRateAdjustment()).map(f->f.build()).orElse(null);
			this.accrualAmount = ofNullable(builder.getAccrualAmount()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("referenceAmount")
		public MoneyWithParticipantShare getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		@RosettaAttribute("referenceAmountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmountType")
		public AccrualReferenceAmountTypeEnum getReferenceAmountType() {
			return referenceAmountType;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("compoundedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundedRate")
		public BigDecimal getCompoundedRate() {
			return compoundedRate;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		@RosettaAttribute("rateAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateAdjustment")
		public RateAdjustment getRateAdjustment() {
			return rateAdjustment;
		}
		
		@Override
		@RosettaAttribute("accrualAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualAmount")
		public MoneyWithParticipantShare getAccrualAmount() {
			return accrualAmount;
		}
		
		@Override
		public AccrualPeriod build() {
			return this;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder toBuilder() {
			AccrualPeriod.AccrualPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualPeriod.AccrualPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getReferenceAmount()).ifPresent(builder::setReferenceAmount);
			ofNullable(getReferenceAmountType()).ifPresent(builder::setReferenceAmountType);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getBaseRate()).ifPresent(builder::setBaseRate);
			ofNullable(getCompoundedRate()).ifPresent(builder::setCompoundedRate);
			ofNullable(getSpreadAdjustment()).ifPresent(builder::setSpreadAdjustment);
			ofNullable(getRateAdjustment()).ifPresent(builder::setRateAdjustment);
			ofNullable(getAccrualAmount()).ifPresent(builder::setAccrualAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(compoundedRate, _that.getCompoundedRate())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			if (!Objects.equals(rateAdjustment, _that.getRateAdjustment())) return false;
			if (!Objects.equals(accrualAmount, _that.getAccrualAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (referenceAmountType != null ? referenceAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (compoundedRate != null ? compoundedRate.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			_result = 31 * _result + (rateAdjustment != null ? rateAdjustment.hashCode() : 0);
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualPeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"compoundedRate=" + this.compoundedRate + ", " +
				"spreadAdjustment=" + this.spreadAdjustment + ", " +
				"rateAdjustment=" + this.rateAdjustment + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualPeriod  ***********************/
	class AccrualPeriodBuilderImpl implements AccrualPeriod.AccrualPeriodBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfDays;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder referenceAmount;
		protected AccrualReferenceAmountTypeEnum referenceAmountType;
		protected BigDecimal rate;
		protected BigDecimal baseRate;
		protected BigDecimal compoundedRate;
		protected BigDecimal spreadAdjustment;
		protected RateAdjustment.RateAdjustmentBuilder rateAdjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder accrualAmount;
		
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
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("referenceAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateReferenceAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (referenceAmount!=null) {
				result = referenceAmount;
			}
			else {
				result = referenceAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceAmountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmountType")
		public AccrualReferenceAmountTypeEnum getReferenceAmountType() {
			return referenceAmountType;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("compoundedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundedRate")
		public BigDecimal getCompoundedRate() {
			return compoundedRate;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		@RosettaAttribute("rateAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateAdjustment")
		public RateAdjustment.RateAdjustmentBuilder getRateAdjustment() {
			return rateAdjustment;
		}
		
		@Override
		public RateAdjustment.RateAdjustmentBuilder getOrCreateRateAdjustment() {
			RateAdjustment.RateAdjustmentBuilder result;
			if (rateAdjustment!=null) {
				result = rateAdjustment;
			}
			else {
				result = rateAdjustment = RateAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAccrualAmount() {
			return accrualAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAccrualAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (accrualAmount!=null) {
				result = accrualAmount;
			}
			else {
				result = accrualAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("referenceAmount")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare _referenceAmount) {
			this.referenceAmount = _referenceAmount == null ? null : _referenceAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceAmountType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceAmountType")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum _referenceAmountType) {
			this.referenceAmountType = _referenceAmountType == null ? null : _referenceAmountType;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseRate")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setBaseRate(BigDecimal _baseRate) {
			this.baseRate = _baseRate == null ? null : _baseRate;
			return this;
		}
		
		@RosettaAttribute("compoundedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compoundedRate")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setCompoundedRate(BigDecimal _compoundedRate) {
			this.compoundedRate = _compoundedRate == null ? null : _compoundedRate;
			return this;
		}
		
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadAdjustment")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setSpreadAdjustment(BigDecimal _spreadAdjustment) {
			this.spreadAdjustment = _spreadAdjustment == null ? null : _spreadAdjustment;
			return this;
		}
		
		@RosettaAttribute("rateAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateAdjustment")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setRateAdjustment(RateAdjustment _rateAdjustment) {
			this.rateAdjustment = _rateAdjustment == null ? null : _rateAdjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualAmount")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare _accrualAmount) {
			this.accrualAmount = _accrualAmount == null ? null : _accrualAmount.toBuilder();
			return this;
		}
		
		@Override
		public AccrualPeriod build() {
			return new AccrualPeriod.AccrualPeriodImpl(this);
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder prune() {
			if (referenceAmount!=null && !referenceAmount.prune().hasData()) referenceAmount = null;
			if (rateAdjustment!=null && !rateAdjustment.prune().hasData()) rateAdjustment = null;
			if (accrualAmount!=null && !accrualAmount.prune().hasData()) accrualAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getNumberOfDays()!=null) return true;
			if (getReferenceAmount()!=null && getReferenceAmount().hasData()) return true;
			if (getReferenceAmountType()!=null) return true;
			if (getRate()!=null) return true;
			if (getBaseRate()!=null) return true;
			if (getCompoundedRate()!=null) return true;
			if (getSpreadAdjustment()!=null) return true;
			if (getRateAdjustment()!=null && getRateAdjustment().hasData()) return true;
			if (getAccrualAmount()!=null && getAccrualAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualPeriod.AccrualPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualPeriod.AccrualPeriodBuilder o = (AccrualPeriod.AccrualPeriodBuilder) other;
			
			merger.mergeRosetta(getReferenceAmount(), o.getReferenceAmount(), this::setReferenceAmount);
			merger.mergeRosetta(getRateAdjustment(), o.getRateAdjustment(), this::setRateAdjustment);
			merger.mergeRosetta(getAccrualAmount(), o.getAccrualAmount(), this::setAccrualAmount);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getReferenceAmountType(), o.getReferenceAmountType(), this::setReferenceAmountType);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getBaseRate(), o.getBaseRate(), this::setBaseRate);
			merger.mergeBasic(getCompoundedRate(), o.getCompoundedRate(), this::setCompoundedRate);
			merger.mergeBasic(getSpreadAdjustment(), o.getSpreadAdjustment(), this::setSpreadAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(compoundedRate, _that.getCompoundedRate())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			if (!Objects.equals(rateAdjustment, _that.getRateAdjustment())) return false;
			if (!Objects.equals(accrualAmount, _that.getAccrualAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (referenceAmountType != null ? referenceAmountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (compoundedRate != null ? compoundedRate.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			_result = 31 * _result + (rateAdjustment != null ? rateAdjustment.hashCode() : 0);
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"compoundedRate=" + this.compoundedRate + ", " +
				"spreadAdjustment=" + this.spreadAdjustment + ", " +
				"rateAdjustment=" + this.rateAdjustment + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}
}
