package fpml.consolidated.generic;

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
import fpml.consolidated.fpmlenum.DayOfWeekExtEnum;
import fpml.consolidated.generic.meta.GenericCommodityDeliveryPeriodMeta;
import fpml.consolidated.shared.OffsetPrevailingTime;
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
@RosettaDataType(value="GenericCommodityDeliveryPeriod", builder=GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericCommodityDeliveryPeriod", model="fpml", builder=GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl.class, version="2.1.1")
public interface GenericCommodityDeliveryPeriod extends RosettaModelObject {

	GenericCommodityDeliveryPeriodMeta metaData = new GenericCommodityDeliveryPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Applicable Day with respect to a range of Settlement Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Applicable Day with respect to a range of Settlement Periods.
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
	 * Provision Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period "wraps around" midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 00:00 to 01:00 and 23:00 to 00:00 on each included day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the hour-ending End Time with respect to a range of Settlement Periods. If neither startTime nor endTime contain an offset element and endTime is earlier than startTime, this indicates that the time period "wraps around" midnight. For example, if startTime is 23:00 and endTime is 01:00 then Settlement Periods apply from 00:00 to 01:00 and 23:00 to 00:00 on each included day.
	 *
	 */
	OffsetPrevailingTime getEndTime();

	/*********************** Build Methods  ***********************/
	GenericCommodityDeliveryPeriod build();
	
	GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder();
	
	static GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder() {
		return new GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericCommodityDeliveryPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericCommodityDeliveryPeriod> getType() {
		return GenericCommodityDeliveryPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
		processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.class, getStartTime());
		processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.class, getEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericCommodityDeliveryPeriodBuilder extends GenericCommodityDeliveryPeriod, RosettaModelObjectBuilder {
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateStartTime();
		@Override
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getStartTime();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getOrCreateEndTime();
		@Override
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder getEndTime();
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay, int idx);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDay);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDay);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setStartTime(OffsetPrevailingTime startTime);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setEndTime(OffsetPrevailingTime endTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
			processRosetta(path.newSubPath("startTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getStartTime());
			processRosetta(path.newSubPath("endTime"), processor, OffsetPrevailingTime.OffsetPrevailingTimeBuilder.class, getEndTime());
		}
		

		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of GenericCommodityDeliveryPeriod  ***********************/
	class GenericCommodityDeliveryPeriodImpl implements GenericCommodityDeliveryPeriod {
		private final List<DayOfWeekExtEnum> applicableDay;
		private final OffsetPrevailingTime startTime;
		private final OffsetPrevailingTime endTime;
		
		protected GenericCommodityDeliveryPeriodImpl(GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder) {
			this.applicableDay = ofNullable(builder.getApplicableDay()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.startTime = ofNullable(builder.getStartTime()).map(f->f.build()).orElse(null);
			this.endTime = ofNullable(builder.getEndTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public GenericCommodityDeliveryPeriod build() {
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder() {
			GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder) {
			ofNullable(getApplicableDay()).ifPresent(builder::setApplicableDay);
			ofNullable(getStartTime()).ifPresent(builder::setStartTime);
			ofNullable(getEndTime()).ifPresent(builder::setEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriod {" +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericCommodityDeliveryPeriod  ***********************/
	class GenericCommodityDeliveryPeriodBuilderImpl implements GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder {
	
		protected List<DayOfWeekExtEnum> applicableDay = new ArrayList<>();
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder startTime;
		protected OffsetPrevailingTime.OffsetPrevailingTimeBuilder endTime;
		
		@Override
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.GETTER)
		@Required
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
		
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("applicableDay")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum _applicableDay) {
			if (_applicableDay != null) {
				this.applicableDay.add(_applicableDay);
			}
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum _applicableDay, int idx) {
			getIndex(this.applicableDay, idx, () -> _applicableDay);
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays != null) {
				for (final DayOfWeekExtEnum toAdd : applicableDays) {
					this.applicableDay.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("applicableDay")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("applicableDay")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
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
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setStartTime(OffsetPrevailingTime _startTime) {
			this.startTime = _startTime == null ? null : _startTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endTime")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setEndTime(OffsetPrevailingTime _endTime) {
			this.endTime = _endTime == null ? null : _endTime.toBuilder();
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod build() {
			return new GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodImpl(this);
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder prune() {
			if (startTime!=null && !startTime.prune().hasData()) startTime = null;
			if (endTime!=null && !endTime.prune().hasData()) endTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableDay()!=null && !getApplicableDay().isEmpty()) return true;
			if (getStartTime()!=null && getStartTime().hasData()) return true;
			if (getEndTime()!=null && getEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder o = (GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder) other;
			
			merger.mergeRosetta(getStartTime(), o.getStartTime(), this::setStartTime);
			merger.mergeRosetta(getEndTime(), o.getEndTime(), this::setEndTime);
			
			merger.mergeBasic(getApplicableDay(), o.getApplicableDay(), (Consumer<DayOfWeekExtEnum>) this::addApplicableDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(startTime, _that.getStartTime())) return false;
			if (!Objects.equals(endTime, _that.getEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (startTime != null ? startTime.hashCode() : 0);
			_result = 31 * _result + (endTime != null ? endTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriodBuilder {" +
				"applicableDay=" + this.applicableDay + ", " +
				"startTime=" + this.startTime + ", " +
				"endTime=" + this.endTime +
			'}';
		}
	}
}
