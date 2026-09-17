package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyValuationDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Details of the days on which calculations are to be made to determine the Delivery Amount and/or Return Amount. For example the language in the document may state &#39;Valuation Date means each day which is a Local Business Day&#39;, to capture this the values would be: Date: EACH, Day: LBD, Frequency: NULL. Alternatively the language may state: &#39;Valuation Date means the 1st Local Business Day of each week&#39;, this would be captured as: Date: 1st, Day: LBD, Frequency: WEEKLY.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyValuationDate", builder=LegacyValuationDate.LegacyValuationDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyValuationDate", model="cdm", builder=LegacyValuationDate.LegacyValuationDateBuilderImpl.class, version="6.23.0")
public interface LegacyValuationDate extends RosettaModelObject {

	LegacyValuationDateMeta metaData = new LegacyValuationDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines whether a date is defined by a certain day of the week or a particular date in the month. If not specified here, then additional language must be used.
	 */
	ValuationDateDateEnum getDate();
	/**
	 * Specific day(s) or day of the week, if any, specified for Valuation Time.
	 */
	ValuationDateDayEnum getDay();
	/**
	 * Defines the day of the calendar if this is specified for in the ValuationDateDateEnum.
	 */
	BigDecimal getCalendarDay();
	/**
	 * Defines the regularity of the date specified for the Valuation Date.
	 */
	ValuationDateFrequencyEnum getFrequency();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyValuationDate build();
	
	LegacyValuationDate.LegacyValuationDateBuilder toBuilder();
	
	static LegacyValuationDate.LegacyValuationDateBuilder builder() {
		return new LegacyValuationDate.LegacyValuationDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyValuationDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyValuationDate> getType() {
		return LegacyValuationDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), ValuationDateDateEnum.class, getDate(), this);
		processor.processBasic(path.newSubPath("day"), ValuationDateDayEnum.class, getDay(), this);
		processor.processBasic(path.newSubPath("calendarDay"), BigDecimal.class, getCalendarDay(), this);
		processor.processBasic(path.newSubPath("frequency"), ValuationDateFrequencyEnum.class, getFrequency(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyValuationDateBuilder extends LegacyValuationDate, RosettaModelObjectBuilder {
		LegacyValuationDate.LegacyValuationDateBuilder setDate(ValuationDateDateEnum date);
		LegacyValuationDate.LegacyValuationDateBuilder setDay(ValuationDateDayEnum day);
		LegacyValuationDate.LegacyValuationDateBuilder setCalendarDay(BigDecimal calendarDay);
		LegacyValuationDate.LegacyValuationDateBuilder setFrequency(ValuationDateFrequencyEnum frequency);
		LegacyValuationDate.LegacyValuationDateBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), ValuationDateDateEnum.class, getDate(), this);
			processor.processBasic(path.newSubPath("day"), ValuationDateDayEnum.class, getDay(), this);
			processor.processBasic(path.newSubPath("calendarDay"), BigDecimal.class, getCalendarDay(), this);
			processor.processBasic(path.newSubPath("frequency"), ValuationDateFrequencyEnum.class, getFrequency(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyValuationDate.LegacyValuationDateBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyValuationDate  ***********************/
	class LegacyValuationDateImpl implements LegacyValuationDate {
		private final ValuationDateDateEnum date;
		private final ValuationDateDayEnum day;
		private final BigDecimal calendarDay;
		private final ValuationDateFrequencyEnum frequency;
		private final String additionalLanguage;
		
		protected LegacyValuationDateImpl(LegacyValuationDate.LegacyValuationDateBuilder builder) {
			this.date = builder.getDate();
			this.day = builder.getDay();
			this.calendarDay = builder.getCalendarDay();
			this.frequency = builder.getFrequency();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ValuationDateDateEnum getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("day")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("day")
		public ValuationDateDayEnum getDay() {
			return day;
		}
		
		@Override
		@RosettaAttribute("calendarDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calendarDay")
		public BigDecimal getCalendarDay() {
			return calendarDay;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frequency")
		public ValuationDateFrequencyEnum getFrequency() {
			return frequency;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyValuationDate build() {
			return this;
		}
		
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder toBuilder() {
			LegacyValuationDate.LegacyValuationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyValuationDate.LegacyValuationDateBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getDay()).ifPresent(builder::setDay);
			ofNullable(getCalendarDay()).ifPresent(builder::setCalendarDay);
			ofNullable(getFrequency()).ifPresent(builder::setFrequency);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(day, _that.getDay())) return false;
			if (!Objects.equals(calendarDay, _that.getCalendarDay())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (day != null ? day.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calendarDay != null ? calendarDay.hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationDate {" +
				"date=" + this.date + ", " +
				"day=" + this.day + ", " +
				"calendarDay=" + this.calendarDay + ", " +
				"frequency=" + this.frequency + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyValuationDate  ***********************/
	class LegacyValuationDateBuilderImpl implements LegacyValuationDate.LegacyValuationDateBuilder {
	
		protected ValuationDateDateEnum date;
		protected ValuationDateDayEnum day;
		protected BigDecimal calendarDay;
		protected ValuationDateFrequencyEnum frequency;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ValuationDateDateEnum getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("day")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("day")
		public ValuationDateDayEnum getDay() {
			return day;
		}
		
		@Override
		@RosettaAttribute("calendarDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calendarDay")
		public BigDecimal getCalendarDay() {
			return calendarDay;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frequency")
		public ValuationDateFrequencyEnum getFrequency() {
			return frequency;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder setDate(ValuationDateDateEnum _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("day")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("day")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder setDay(ValuationDateDayEnum _day) {
			this.day = _day == null ? null : _day;
			return this;
		}
		
		@RosettaAttribute("calendarDay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calendarDay")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder setCalendarDay(BigDecimal _calendarDay) {
			this.calendarDay = _calendarDay == null ? null : _calendarDay;
			return this;
		}
		
		@RosettaAttribute("frequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frequency")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder setFrequency(ValuationDateFrequencyEnum _frequency) {
			this.frequency = _frequency == null ? null : _frequency;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyValuationDate build() {
			return new LegacyValuationDate.LegacyValuationDateImpl(this);
		}
		
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getDay()!=null) return true;
			if (getCalendarDay()!=null) return true;
			if (getFrequency()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyValuationDate.LegacyValuationDateBuilder o = (LegacyValuationDate.LegacyValuationDateBuilder) other;
			
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getDay(), o.getDay(), this::setDay);
			merger.mergeBasic(getCalendarDay(), o.getCalendarDay(), this::setCalendarDay);
			merger.mergeBasic(getFrequency(), o.getFrequency(), this::setFrequency);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(day, _that.getDay())) return false;
			if (!Objects.equals(calendarDay, _that.getCalendarDay())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (day != null ? day.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calendarDay != null ? calendarDay.hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationDateBuilder {" +
				"date=" + this.date + ", " +
				"day=" + this.day + ", " +
				"calendarDay=" + this.calendarDay + ", " +
				"frequency=" + this.frequency + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
