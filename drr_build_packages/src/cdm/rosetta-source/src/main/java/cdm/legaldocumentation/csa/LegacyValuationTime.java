package cdm.legaldocumentation.csa;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.meta.LegacyValuationTimeMeta;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The time by which the value of the collateral and obligations to transfer or return collateral are to be calculated relative to the Valuation Date.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyValuationTime", builder=LegacyValuationTime.LegacyValuationTimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyValuationTime", model="cdm", builder=LegacyValuationTime.LegacyValuationTimeBuilderImpl.class, version="6.23.0")
public interface LegacyValuationTime extends RosettaModelObject {

	LegacyValuationTimeMeta metaData = new LegacyValuationTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The day in respect of which the Valuation Time is being specified. If not specified, addional language must be used to define the methodology.
	 */
	ValuationTimeDayEnum getDay();
	/**
	 * The location relevant to the timezone for the Valuation Time.
	 */
	List<BusinessCenterEnum> getLocation();
	/**
	 * The type of time specified for the Valuation Time.
	 */
	ValuationTimeEnum getTime();
	/**
	 * A time specified in a 24-hour notation, e.g. 3pm would be represented as 15:00.
	 */
	LocalTime getHourminutetime();
	/**
	 * Any relevant time zone where specified.
	 */
	BusinessCenterEnum getTimezone();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyValuationTime build();
	
	LegacyValuationTime.LegacyValuationTimeBuilder toBuilder();
	
	static LegacyValuationTime.LegacyValuationTimeBuilder builder() {
		return new LegacyValuationTime.LegacyValuationTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyValuationTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyValuationTime> getType() {
		return LegacyValuationTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("day"), ValuationTimeDayEnum.class, getDay(), this);
		processor.processBasic(path.newSubPath("location"), BusinessCenterEnum.class, getLocation(), this);
		processor.processBasic(path.newSubPath("time"), ValuationTimeEnum.class, getTime(), this);
		processor.processBasic(path.newSubPath("hourminutetime"), LocalTime.class, getHourminutetime(), this);
		processor.processBasic(path.newSubPath("timezone"), BusinessCenterEnum.class, getTimezone(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyValuationTimeBuilder extends LegacyValuationTime, RosettaModelObjectBuilder {
		LegacyValuationTime.LegacyValuationTimeBuilder setDay(ValuationTimeDayEnum day);
		LegacyValuationTime.LegacyValuationTimeBuilder addLocation(BusinessCenterEnum location);
		LegacyValuationTime.LegacyValuationTimeBuilder addLocation(BusinessCenterEnum location, int idx);
		LegacyValuationTime.LegacyValuationTimeBuilder addLocation(List<BusinessCenterEnum> location);
		LegacyValuationTime.LegacyValuationTimeBuilder setLocation(List<BusinessCenterEnum> location);
		LegacyValuationTime.LegacyValuationTimeBuilder setTime(ValuationTimeEnum time);
		LegacyValuationTime.LegacyValuationTimeBuilder setHourminutetime(LocalTime hourminutetime);
		LegacyValuationTime.LegacyValuationTimeBuilder setTimezone(BusinessCenterEnum timezone);
		LegacyValuationTime.LegacyValuationTimeBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("day"), ValuationTimeDayEnum.class, getDay(), this);
			processor.processBasic(path.newSubPath("location"), BusinessCenterEnum.class, getLocation(), this);
			processor.processBasic(path.newSubPath("time"), ValuationTimeEnum.class, getTime(), this);
			processor.processBasic(path.newSubPath("hourminutetime"), LocalTime.class, getHourminutetime(), this);
			processor.processBasic(path.newSubPath("timezone"), BusinessCenterEnum.class, getTimezone(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyValuationTime.LegacyValuationTimeBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyValuationTime  ***********************/
	class LegacyValuationTimeImpl implements LegacyValuationTime {
		private final ValuationTimeDayEnum day;
		private final List<BusinessCenterEnum> location;
		private final ValuationTimeEnum time;
		private final LocalTime hourminutetime;
		private final BusinessCenterEnum timezone;
		private final String additionalLanguage;
		
		protected LegacyValuationTimeImpl(LegacyValuationTime.LegacyValuationTimeBuilder builder) {
			this.day = builder.getDay();
			this.location = ofNullable(builder.getLocation()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.time = builder.getTime();
			this.hourminutetime = builder.getHourminutetime();
			this.timezone = builder.getTimezone();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("day")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("day")
		public ValuationTimeDayEnum getDay() {
			return day;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("location")
		public List<BusinessCenterEnum> getLocation() {
			return location;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public ValuationTimeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("hourminutetime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hourminutetime")
		public LocalTime getHourminutetime() {
			return hourminutetime;
		}
		
		@Override
		@RosettaAttribute("timezone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timezone")
		public BusinessCenterEnum getTimezone() {
			return timezone;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyValuationTime build() {
			return this;
		}
		
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder toBuilder() {
			LegacyValuationTime.LegacyValuationTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyValuationTime.LegacyValuationTimeBuilder builder) {
			ofNullable(getDay()).ifPresent(builder::setDay);
			ofNullable(getLocation()).ifPresent(builder::setLocation);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getHourminutetime()).ifPresent(builder::setHourminutetime);
			ofNullable(getTimezone()).ifPresent(builder::setTimezone);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationTime _that = getType().cast(o);
		
			if (!Objects.equals(day, _that.getDay())) return false;
			if (!ListEquals.listEquals(location, _that.getLocation())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(hourminutetime, _that.getHourminutetime())) return false;
			if (!Objects.equals(timezone, _that.getTimezone())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (day != null ? day.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (location != null ? location.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (hourminutetime != null ? hourminutetime.hashCode() : 0);
			_result = 31 * _result + (timezone != null ? timezone.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationTime {" +
				"day=" + this.day + ", " +
				"location=" + this.location + ", " +
				"time=" + this.time + ", " +
				"hourminutetime=" + this.hourminutetime + ", " +
				"timezone=" + this.timezone + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyValuationTime  ***********************/
	class LegacyValuationTimeBuilderImpl implements LegacyValuationTime.LegacyValuationTimeBuilder {
	
		protected ValuationTimeDayEnum day;
		protected List<BusinessCenterEnum> location = new ArrayList<>();
		protected ValuationTimeEnum time;
		protected LocalTime hourminutetime;
		protected BusinessCenterEnum timezone;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("day")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("day")
		public ValuationTimeDayEnum getDay() {
			return day;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("location")
		public List<BusinessCenterEnum> getLocation() {
			return location;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public ValuationTimeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("hourminutetime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hourminutetime")
		public LocalTime getHourminutetime() {
			return hourminutetime;
		}
		
		@Override
		@RosettaAttribute("timezone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timezone")
		public BusinessCenterEnum getTimezone() {
			return timezone;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("day")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("day")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setDay(ValuationTimeDayEnum _day) {
			this.day = _day == null ? null : _day;
			return this;
		}
		
		@RosettaAttribute("location")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("location")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder addLocation(BusinessCenterEnum _location) {
			if (_location != null) {
				this.location.add(_location);
			}
			return this;
		}
		
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder addLocation(BusinessCenterEnum _location, int idx) {
			getIndex(this.location, idx, () -> _location);
			return this;
		}
		
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder addLocation(List<BusinessCenterEnum> locations) {
			if (locations != null) {
				for (final BusinessCenterEnum toAdd : locations) {
					this.location.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("location")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("location")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setLocation(List<BusinessCenterEnum> locations) {
			if (locations == null) {
				this.location = new ArrayList<>();
			} else {
				this.location = locations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setTime(ValuationTimeEnum _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("hourminutetime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hourminutetime")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setHourminutetime(LocalTime _hourminutetime) {
			this.hourminutetime = _hourminutetime == null ? null : _hourminutetime;
			return this;
		}
		
		@RosettaAttribute("timezone")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timezone")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setTimezone(BusinessCenterEnum _timezone) {
			this.timezone = _timezone == null ? null : _timezone;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyValuationTime build() {
			return new LegacyValuationTime.LegacyValuationTimeImpl(this);
		}
		
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDay()!=null) return true;
			if (getLocation()!=null && !getLocation().isEmpty()) return true;
			if (getTime()!=null) return true;
			if (getHourminutetime()!=null) return true;
			if (getTimezone()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyValuationTime.LegacyValuationTimeBuilder o = (LegacyValuationTime.LegacyValuationTimeBuilder) other;
			
			
			merger.mergeBasic(getDay(), o.getDay(), this::setDay);
			merger.mergeBasic(getLocation(), o.getLocation(), (Consumer<BusinessCenterEnum>) this::addLocation);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			merger.mergeBasic(getHourminutetime(), o.getHourminutetime(), this::setHourminutetime);
			merger.mergeBasic(getTimezone(), o.getTimezone(), this::setTimezone);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationTime _that = getType().cast(o);
		
			if (!Objects.equals(day, _that.getDay())) return false;
			if (!ListEquals.listEquals(location, _that.getLocation())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(hourminutetime, _that.getHourminutetime())) return false;
			if (!Objects.equals(timezone, _that.getTimezone())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (day != null ? day.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (location != null ? location.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (hourminutetime != null ? hourminutetime.hashCode() : 0);
			_result = 31 * _result + (timezone != null ? timezone.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationTimeBuilder {" +
				"day=" + this.day + ", " +
				"location=" + this.location + ", " +
				"time=" + this.time + ", " +
				"hourminutetime=" + this.hourminutetime + ", " +
				"timezone=" + this.timezone + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
