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
import fpml.consolidated.loan.meta.AccruingPikOptionMeta;
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
 * Provision A structure that represents the accruing PIK option associated within a facility.
 *
 */
@RosettaDataType(value="AccruingPikOption", builder=AccruingPikOption.AccruingPikOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccruingPikOption", model="fpml", builder=AccruingPikOption.AccruingPikOptionBuilderImpl.class, version="2.1.1")
public interface AccruingPikOption extends FeeRateOptionBase {

	AccruingPikOptionMeta metaData = new AccruingPikOptionMeta();

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

	/*********************** Build Methods  ***********************/
	AccruingPikOption build();
	
	AccruingPikOption.AccruingPikOptionBuilder toBuilder();
	
	static AccruingPikOption.AccruingPikOptionBuilder builder() {
		return new AccruingPikOption.AccruingPikOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingPikOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccruingPikOption> getType() {
		return AccruingPikOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingPikOptionBuilder extends AccruingPikOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		@Override
		AccruingPikOption.AccruingPikOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		AccruingPikOption.AccruingPikOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		AccruingPikOption.AccruingPikOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		AccruingPikOption.AccruingPikOptionBuilder setRate(BigDecimal rate);
		AccruingPikOption.AccruingPikOptionBuilder setStartDate(ZonedDateTime startDate);
		AccruingPikOption.AccruingPikOptionBuilder setEndDate(ZonedDateTime endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		}
		

		AccruingPikOption.AccruingPikOptionBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingPikOption  ***********************/
	class AccruingPikOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements AccruingPikOption {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		
		protected AccruingPikOptionImpl(AccruingPikOption.AccruingPikOptionBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
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
		public AccruingPikOption build() {
			return this;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder toBuilder() {
			AccruingPikOption.AccruingPikOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingPikOption.AccruingPikOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOption {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingPikOption  ***********************/
	class AccruingPikOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl implements AccruingPikOption.AccruingPikOptionBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		
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
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@Override
		public AccruingPikOption build() {
			return new AccruingPikOption.AccruingPikOptionImpl(this);
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AccruingPikOption.AccruingPikOptionBuilder o = (AccruingPikOption.AccruingPikOptionBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOption _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOptionBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}' + " " + super.toString();
		}
	}
}
