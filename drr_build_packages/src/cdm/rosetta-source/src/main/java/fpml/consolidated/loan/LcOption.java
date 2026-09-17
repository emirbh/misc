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
import fpml.consolidated.loan.meta.LcOptionMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
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
 * Provision A structure that represents the accruing L/C rate option associated within a facility.
 *
 */
@RosettaDataType(value="LcOption", builder=LcOption.LcOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcOption", model="fpml", builder=LcOption.LcOptionBuilderImpl.class, version="2.1.1")
public interface LcOption extends FeeRateOptionBase {

	LcOptionMeta metaData = new LcOptionMeta();

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
	 * Provision The letter of credit type for which a fee rate is being provided.
	 *
	 */
	LcType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit notional amount. The amount is represented at the global and (optionally) atthe lender-specific level.
	 *
	 */
	MoneyWithParticipantShare getMinLcIssuanceFeeAmount();

	/*********************** Build Methods  ***********************/
	LcOption build();
	
	LcOption.LcOptionBuilder toBuilder();
	
	static LcOption.LcOptionBuilder builder() {
		return new LcOption.LcOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcOption> getType() {
		return LcOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("type"), processor, LcType.class, _getType());
		processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.class, getMinLcIssuanceFeeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcOptionBuilder extends LcOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		LcType.LcTypeBuilder getOrCreateType();
		@Override
		LcType.LcTypeBuilder _getType();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount();
		@Override
		LcOption.LcOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LcOption.LcOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LcOption.LcOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LcOption.LcOptionBuilder setRate(BigDecimal rate);
		LcOption.LcOptionBuilder setStartDate(ZonedDateTime startDate);
		LcOption.LcOptionBuilder setEndDate(ZonedDateTime endDate);
		LcOption.LcOptionBuilder setType(LcType type);
		LcOption.LcOptionBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("type"), processor, LcType.LcTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getMinLcIssuanceFeeAmount());
		}
		

		LcOption.LcOptionBuilder prune();
	}

	/*********************** Immutable Implementation of LcOption  ***********************/
	class LcOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements LcOption {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final LcType type;
		private final MoneyWithParticipantShare minLcIssuanceFeeAmount;
		
		protected LcOptionImpl(LcOption.LcOptionBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.minLcIssuanceFeeAmount = ofNullable(builder.getMinLcIssuanceFeeAmount()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LcType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public LcOption build() {
			return this;
		}
		
		@Override
		public LcOption.LcOptionBuilder toBuilder() {
			LcOption.LcOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcOption.LcOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getMinLcIssuanceFeeAmount()).ifPresent(builder::setMinLcIssuanceFeeAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOption {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"type=" + this.type + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcOption  ***********************/
	class LcOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl implements LcOption.LcOptionBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected LcType.LcTypeBuilder type;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder minLcIssuanceFeeAmount;
		
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
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LcType.LcTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LcType.LcTypeBuilder getOrCreateType() {
			LcType.LcTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LcType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (minLcIssuanceFeeAmount!=null) {
				result = minLcIssuanceFeeAmount;
			}
			else {
				result = minLcIssuanceFeeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public LcOption.LcOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LcOption.LcOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LcOption.LcOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LcOption.LcOptionBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LcOption.LcOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LcOption.LcOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LcOption.LcOptionBuilder setType(LcType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		@Override
		public LcOption.LcOptionBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare _minLcIssuanceFeeAmount) {
			this.minLcIssuanceFeeAmount = _minLcIssuanceFeeAmount == null ? null : _minLcIssuanceFeeAmount.toBuilder();
			return this;
		}
		
		@Override
		public LcOption build() {
			return new LcOption.LcOptionImpl(this);
		}
		
		@Override
		public LcOption.LcOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOption.LcOptionBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			if (minLcIssuanceFeeAmount!=null && !minLcIssuanceFeeAmount.prune().hasData()) minLcIssuanceFeeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getMinLcIssuanceFeeAmount()!=null && getMinLcIssuanceFeeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOption.LcOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcOption.LcOptionBuilder o = (LcOption.LcOptionBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getMinLcIssuanceFeeAmount(), o.getMinLcIssuanceFeeAmount(), this::setMinLcIssuanceFeeAmount);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOptionBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"type=" + this.type + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}' + " " + super.toString();
		}
	}
}
