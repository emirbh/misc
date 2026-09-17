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
import fpml.consolidated.loan.meta.LegacyAccrualPeriodMeta;
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
 * Provision A structure that describes the details of the legacy version (pre-IBOR replacement) of underlying elements that explain the calculation of an accrual against a reference balance.
 *
 */
@RosettaDataType(value="LegacyAccrualPeriod", builder=LegacyAccrualPeriod.LegacyAccrualPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegacyAccrualPeriod", model="fpml", builder=LegacyAccrualPeriod.LegacyAccrualPeriodBuilderImpl.class, version="2.1.1")
public interface LegacyAccrualPeriod extends RosettaModelObject {

	LegacyAccrualPeriodMeta metaData = new LegacyAccrualPeriodMeta();

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
	 * Provision The rate applied to this period.
	 *
	 */
	BigDecimal getRate();
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
	LegacyAccrualPeriod build();
	
	LegacyAccrualPeriod.LegacyAccrualPeriodBuilder toBuilder();
	
	static LegacyAccrualPeriod.LegacyAccrualPeriodBuilder builder() {
		return new LegacyAccrualPeriod.LegacyAccrualPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyAccrualPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyAccrualPeriod> getType() {
		return LegacyAccrualPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.class, getReferenceAmount());
		processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.class, getAccrualAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyAccrualPeriodBuilder extends LegacyAccrualPeriod, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateReferenceAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getReferenceAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAccrualAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAccrualAmount();
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setStartDate(ZonedDateTime startDate);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setEndDate(ZonedDateTime endDate);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setNumberOfDays(Integer numberOfDays);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare referenceAmount);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum referenceAmountType);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setRate(BigDecimal rate);
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare accrualAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processRosetta(path.newSubPath("referenceAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getReferenceAmount());
			processor.processBasic(path.newSubPath("referenceAmountType"), AccrualReferenceAmountTypeEnum.class, getReferenceAmountType(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("accrualAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAccrualAmount());
		}
		

		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyAccrualPeriod  ***********************/
	class LegacyAccrualPeriodImpl implements LegacyAccrualPeriod {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfDays;
		private final MoneyWithParticipantShare referenceAmount;
		private final AccrualReferenceAmountTypeEnum referenceAmountType;
		private final BigDecimal rate;
		private final MoneyWithParticipantShare accrualAmount;
		
		protected LegacyAccrualPeriodImpl(LegacyAccrualPeriod.LegacyAccrualPeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.referenceAmount = ofNullable(builder.getReferenceAmount()).map(f->f.build()).orElse(null);
			this.referenceAmountType = builder.getReferenceAmountType();
			this.rate = builder.getRate();
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
		@RosettaAttribute("accrualAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualAmount")
		public MoneyWithParticipantShare getAccrualAmount() {
			return accrualAmount;
		}
		
		@Override
		public LegacyAccrualPeriod build() {
			return this;
		}
		
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder toBuilder() {
			LegacyAccrualPeriod.LegacyAccrualPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyAccrualPeriod.LegacyAccrualPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getReferenceAmount()).ifPresent(builder::setReferenceAmount);
			ofNullable(getReferenceAmountType()).ifPresent(builder::setReferenceAmountType);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getAccrualAmount()).ifPresent(builder::setAccrualAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyAccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
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
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyAccrualPeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyAccrualPeriod  ***********************/
	class LegacyAccrualPeriodBuilderImpl implements LegacyAccrualPeriod.LegacyAccrualPeriodBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfDays;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder referenceAmount;
		protected AccrualReferenceAmountTypeEnum referenceAmountType;
		protected BigDecimal rate;
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
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("referenceAmount")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setReferenceAmount(MoneyWithParticipantShare _referenceAmount) {
			this.referenceAmount = _referenceAmount == null ? null : _referenceAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceAmountType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceAmountType")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setReferenceAmountType(AccrualReferenceAmountTypeEnum _referenceAmountType) {
			this.referenceAmountType = _referenceAmountType == null ? null : _referenceAmountType;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("accrualAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualAmount")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder setAccrualAmount(MoneyWithParticipantShare _accrualAmount) {
			this.accrualAmount = _accrualAmount == null ? null : _accrualAmount.toBuilder();
			return this;
		}
		
		@Override
		public LegacyAccrualPeriod build() {
			return new LegacyAccrualPeriod.LegacyAccrualPeriodImpl(this);
		}
		
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder prune() {
			if (referenceAmount!=null && !referenceAmount.prune().hasData()) referenceAmount = null;
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
			if (getAccrualAmount()!=null && getAccrualAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyAccrualPeriod.LegacyAccrualPeriodBuilder o = (LegacyAccrualPeriod.LegacyAccrualPeriodBuilder) other;
			
			merger.mergeRosetta(getReferenceAmount(), o.getReferenceAmount(), this::setReferenceAmount);
			merger.mergeRosetta(getAccrualAmount(), o.getAccrualAmount(), this::setAccrualAmount);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getReferenceAmountType(), o.getReferenceAmountType(), this::setReferenceAmountType);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyAccrualPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(referenceAmountType, _that.getReferenceAmountType())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
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
			_result = 31 * _result + (accrualAmount != null ? accrualAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyAccrualPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"referenceAmountType=" + this.referenceAmountType + ", " +
				"rate=" + this.rate + ", " +
				"accrualAmount=" + this.accrualAmount +
			'}';
		}
	}
}
