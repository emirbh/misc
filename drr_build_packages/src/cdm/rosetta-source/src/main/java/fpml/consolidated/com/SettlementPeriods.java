package fpml.consolidated.com;

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
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.meta.SettlementPeriodsMeta;
import fpml.consolidated.fpmlenum.DayOfWeekExtEnum;
import fpml.consolidated.fpmlenum.SettlementPeriodDurationEnum;
import fpml.consolidated.shared.OffsetPrevailingTime;
import java.time.LocalTime;
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
 * Provision Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
 *
 */
@RosettaDataType(value="SettlementPeriods", builder=SettlementPeriods.SettlementPeriodsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriods", model="fpml", builder=SettlementPeriods.SettlementPeriodsBuilderImpl.class, version="2.1.1")
public interface SettlementPeriods extends RosettaModelObject {

	SettlementPeriodsMeta metaData = new SettlementPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The length of each Settlement Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The length of each Settlement Period.
	 *
	 */
	SettlementPeriodDurationEnum getDuration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Applicable Day with respect to a range of Settlement Periods. This element can only be omitted if includesHolidays is present, in which case this range of Settlement Periods will apply to days that are holidays only.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Applicable Day with respect to a range of Settlement Periods. This element can only be omitted if includesHolidays is present, in which case this range of Settlement Periods will apply to days that are holidays only.
	 *
	 */
	List<DayOfWeekExtEnum> getApplicableDay();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the hour-ending Start Time with respect to a range of Settlement Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the hour-ending Start Time with respect to a range of Settlement Periods.
	 *
	 */
	OffsetPrevailingTime getStartTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period "wraps around" midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 22:00 to 23:00 and 23:00 to 00:00 and 00:00 to 01:00 on each included day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period "wraps around" midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 22:00 to 23:00 and 23:00 to 00:00 and 00:00 to 01:00 on each included day.
	 *
	 */
	OffsetPrevailingTime getEndTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the duration of the time window during which settlement/delivery occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the duration of the time window during which settlement/delivery occurs.
	 *
	 */
	LocalTime getTimeDuration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that days that are holidays according to the referenced commodity business calendar should be excluded from this range of Settlement Periods, even if such day is an applicable day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that days that are holidays according to the referenced commodity business calendar should be excluded from this range of Settlement Periods, even if such day is an applicable day.
	 *
	 */
	CommodityBusinessCalendar getExcludeHolidays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that days that are holidays according to the referenced commodity business calendar should be included in this range of Settlement Periods, even if such day is not an applicable day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that days that are holidays according to the referenced commodity business calendar should be included in this range of Settlement Periods, even if such day is not an applicable day.
	 *
	 */
	CommodityBusinessCalendar getIncludeHolidays();

	/*********************** Build Methods  ***********************/
	SettlementPeriods build();
	
	SettlementPeriods.SettlementPeriodsBuilder toBuilder();
	
	static SettlementPeriods.SettlementPeriodsBuilder builder() {
		return new SettlementPeriods.SettlementPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriods> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriods> getType() {
		return SettlementPeriods.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("duration"), SettlementPeriodDurationEnum.class, getDuration(), this);
		processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
		processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.class, getStartTime());
		processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.class, getEndTime());
		processor.processBasic(path.newSubPath("timeDuration"), LocalTime.class, getTimeDuration(), this);
		processRosetta(path.newSubPath("excludeHolidays"), processor, CommodityBusinessCalendar.class, getExcludeHolidays());
		processRosetta(path.newSubPath("includeHolidays"), processor, CommodityBusinessCalendar.class, getIncludeHolidays());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsBuilder extends SettlementPeriods, RosettaModelObjectBuilder {
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime();
		@Override
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime();
		@Override
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateExcludeHolidays();
		@Override
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getExcludeHolidays();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateIncludeHolidays();
		@Override
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getIncludeHolidays();
		SettlementPeriods.SettlementPeriodsBuilder setId(String id);
		SettlementPeriods.SettlementPeriodsBuilder setDuration(SettlementPeriodDurationEnum duration);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum applicableDay, int idx);
		SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDay);
		SettlementPeriods.SettlementPeriodsBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDay);
		SettlementPeriods.SettlementPeriodsBuilder setStartTime(OffsetPrevailingTime startTime);
		SettlementPeriods.SettlementPeriodsBuilder setEndTime(OffsetPrevailingTime endTime);
		SettlementPeriods.SettlementPeriodsBuilder setTimeDuration(LocalTime timeDuration);
		SettlementPeriods.SettlementPeriodsBuilder setExcludeHolidays(CommodityBusinessCalendar excludeHolidays);
		SettlementPeriods.SettlementPeriodsBuilder setIncludeHolidays(CommodityBusinessCalendar includeHolidays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("duration"), SettlementPeriodDurationEnum.class, getDuration(), this);
			processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
			processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getStartTime());
			processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getEndTime());
			processor.processBasic(path.newSubPath("timeDuration"), LocalTime.class, getTimeDuration(), this);
			processRosetta(path.newSubPath("excludeHolidays"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getExcludeHolidays());
			processRosetta(path.newSubPath("includeHolidays"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getIncludeHolidays());
		}
		

		SettlementPeriods.SettlementPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriods  ***********************/
	class SettlementPeriodsImpl implements SettlementPeriods {
		private final String id;
		private final SettlementPeriodDurationEnum duration;
		private final List<DayOfWeekExtEnum> applicableDay;
		private final OffsetPrevailingTime startTime;
		private final OffsetPrevailingTime endTime;
		private final LocalTime timeDuration;
		private final CommodityBusinessCalendar excludeHolidays;
		private final CommodityBusinessCalendar includeHolidays;
		
		protected SettlementPeriodsImpl(SettlementPeriods.SettlementPeriodsBuilder builder) {
			this.id = builder.getId();
			this.duration = builder.getDuration();
			this.applicableDay = ofNullable(builder.getApplicableDay()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.startTime = ofNullable(builder.getStartTime()).map(f->f.build()).orElse(null);
			this.endTime = ofNullable(builder.getEndTime()).map(f->f.build()).orElse(null);
			this.timeDuration = builder.getTimeDuration();
			this.excludeHolidays = ofNullable(builder.getExcludeHolidays()).map(f->f.build()).orElse(null);
			this.includeHolidays = ofNullable(builder.getIncludeHolidays()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public SettlementPeriodDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("startTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startTime")
		public OffsetPrevailingTime getStartTime() {
			return startTime;
		}
		
		@Override
		@RosettaAttribute("endTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endTime")
		public OffsetPrevailingTime getEndTime() {
			return endTime;
		}
		
		@Override
		@RosettaAttribute("timeDuration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timeDuration")
		public LocalTime getTimeDuration() {
			return timeDuration;
		}
		
		@Override
		@RosettaAttribute("excludeHolidays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludeHolidays")
		public CommodityBusinessCalendar getExcludeHolidays() {
			return excludeHolidays;
		}
		
		@Override
		@RosettaAttribute("includeHolidays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("includeHolidays")
		public CommodityBusinessCalendar getIncludeHolidays() {
			return includeHolidays;
		}
		
		@Override
		public SettlementPeriods build() {
			return this;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder toBuilder() {
			SettlementPeriods.SettlementPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriods.SettlementPeriodsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getApplicableDay()).ifPresent(builder::setApplicableDay);
			ofNullable(getStartTime()).ifPresent(builder::setStartTime);
			ofNullable(getEndTime()).ifPresent(builder::setEndTime);
			ofNullable(getTimeDuration()).ifPresent(builder::setTimeDuration);
			ofNullable(getExcludeHolidays()).ifPresent(builder::setExcludeHolidays);
			ofNullable(getIncludeHolidays()).ifPresent(builder::setIncludeHolidays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			if (!Objects.equals(timeDuration, _that.getTimeDuration())) return false;
			if (!Objects.equals(excludeHolidays, _that.getExcludeHolidays())) return false;
			if (!Objects.equals(includeHolidays, _that.getIncludeHolidays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			_result = 31 * _result + (timeDuration != null ? timeDuration.hashCode() : 0);
			_result = 31 * _result + (excludeHolidays != null ? excludeHolidays.hashCode() : 0);
			_result = 31 * _result + (includeHolidays != null ? includeHolidays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriods {" +
				"id=" + this.id + ", " +
				"duration=" + this.duration + ", " +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime + ", " +
				"timeDuration=" + this.timeDuration + ", " +
				"excludeHolidays=" + this.excludeHolidays + ", " +
				"includeHolidays=" + this.includeHolidays +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriods  ***********************/
	class SettlementPeriodsBuilderImpl implements SettlementPeriods.SettlementPeriodsBuilder {
	
		protected String id;
		protected SettlementPeriodDurationEnum duration;
		protected List<DayOfWeekExtEnum> applicableDay = new ArrayList<>();
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder startTime;
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder endTime;
		protected LocalTime timeDuration;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder excludeHolidays;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder includeHolidays;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public SettlementPeriodDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("startTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startTime")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime() {
			return startTime;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder result;
			if (startTime!=null) {
				result = startTime;
			}
			else {
				result = startTime = OffsetPrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endTime")
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime() {
			return endTime;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder result;
			if (endTime!=null) {
				result = endTime;
			}
			else {
				result = endTime = OffsetPrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timeDuration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timeDuration")
		public LocalTime getTimeDuration() {
			return timeDuration;
		}
		
		@Override
		@RosettaAttribute("excludeHolidays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludeHolidays")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getExcludeHolidays() {
			return excludeHolidays;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateExcludeHolidays() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (excludeHolidays!=null) {
				result = excludeHolidays;
			}
			else {
				result = excludeHolidays = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("includeHolidays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("includeHolidays")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getIncludeHolidays() {
			return includeHolidays;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateIncludeHolidays() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (includeHolidays!=null) {
				result = includeHolidays;
			}
			else {
				result = includeHolidays = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("duration")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setDuration(SettlementPeriodDurationEnum _duration) {
			this.duration = _duration == null ? null : _duration;
			return this;
		}
		
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("applicableDay")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum _applicableDay) {
			if (_applicableDay != null) {
				this.applicableDay.add(_applicableDay);
			}
			return this;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(DayOfWeekExtEnum _applicableDay, int idx) {
			getIndex(this.applicableDay, idx, () -> _applicableDay);
			return this;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays != null) {
				for (final DayOfWeekExtEnum toAdd : applicableDays) {
					this.applicableDay.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("applicableDay")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays == null) {
				this.applicableDay = new ArrayList<>();
			} else {
				this.applicableDay = applicableDays.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startTime")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setStartTime(OffsetPrevailingTime _startTime) {
			this.startTime = _startTime == null ? null : _startTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endTime")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setEndTime(OffsetPrevailingTime _endTime) {
			this.endTime = _endTime == null ? null : _endTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("timeDuration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timeDuration")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setTimeDuration(LocalTime _timeDuration) {
			this.timeDuration = _timeDuration == null ? null : _timeDuration;
			return this;
		}
		
		@RosettaAttribute("excludeHolidays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excludeHolidays")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setExcludeHolidays(CommodityBusinessCalendar _excludeHolidays) {
			this.excludeHolidays = _excludeHolidays == null ? null : _excludeHolidays.toBuilder();
			return this;
		}
		
		@RosettaAttribute("includeHolidays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("includeHolidays")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder setIncludeHolidays(CommodityBusinessCalendar _includeHolidays) {
			this.includeHolidays = _includeHolidays == null ? null : _includeHolidays.toBuilder();
			return this;
		}
		
		@Override
		public SettlementPeriods build() {
			return new SettlementPeriods.SettlementPeriodsImpl(this);
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder prune() {
			if (startTime!=null && !startTime.prune().hasData()) startTime = null;
			if (endTime!=null && !endTime.prune().hasData()) endTime = null;
			if (excludeHolidays!=null && !excludeHolidays.prune().hasData()) excludeHolidays = null;
			if (includeHolidays!=null && !includeHolidays.prune().hasData()) includeHolidays = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getDuration()!=null) return true;
			if (getApplicableDay()!=null && !getApplicableDay().isEmpty()) return true;
			if (getStartTime()!=null && getStartTime().hasData()) return true;
			if (getEndTime()!=null && getEndTime().hasData()) return true;
			if (getTimeDuration()!=null) return true;
			if (getExcludeHolidays()!=null && getExcludeHolidays().hasData()) return true;
			if (getIncludeHolidays()!=null && getIncludeHolidays().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriods.SettlementPeriodsBuilder o = (SettlementPeriods.SettlementPeriodsBuilder) other;
			
			merger.mergeRosetta(getStartTime(), o.getStartTime(), this::setStartTime);
			merger.mergeRosetta(getEndTime(), o.getEndTime(), this::setEndTime);
			merger.mergeRosetta(getExcludeHolidays(), o.getExcludeHolidays(), this::setExcludeHolidays);
			merger.mergeRosetta(getIncludeHolidays(), o.getIncludeHolidays(), this::setIncludeHolidays);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getApplicableDay(), o.getApplicableDay(), (Consumer<DayOfWeekExtEnum>) this::addApplicableDay);
			merger.mergeBasic(getTimeDuration(), o.getTimeDuration(), this::setTimeDuration);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			if (!Objects.equals(timeDuration, _that.getTimeDuration())) return false;
			if (!Objects.equals(excludeHolidays, _that.getExcludeHolidays())) return false;
			if (!Objects.equals(includeHolidays, _that.getIncludeHolidays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			_result = 31 * _result + (timeDuration != null ? timeDuration.hashCode() : 0);
			_result = 31 * _result + (excludeHolidays != null ? excludeHolidays.hashCode() : 0);
			_result = 31 * _result + (includeHolidays != null ? includeHolidays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsBuilder {" +
				"id=" + this.id + ", " +
				"duration=" + this.duration + ", " +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime + ", " +
				"timeDuration=" + this.timeDuration + ", " +
				"excludeHolidays=" + this.excludeHolidays + ", " +
				"includeHolidays=" + this.includeHolidays +
			'}';
		}
	}
}
