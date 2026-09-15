package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BusinessCenterTimeMeta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining a time with respect to a business day calendar location. For example, 11:00am London time.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining a time with respect to a business day calendar location. For example, 11:00am London time.
 *
 */
@RosettaDataType(value="BusinessCenterTime", builder=BusinessCenterTime.BusinessCenterTimeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessCenterTime", model="fpml", builder=BusinessCenterTime.BusinessCenterTimeBuilderImpl.class, version="2.1.1")
public interface BusinessCenterTime extends RosettaModelObject {

	BusinessCenterTimeMeta metaData = new BusinessCenterTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
	 *
	 */
	LocalTime getHourMinuteTime();
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
	BusinessCenter getBusinessCenter();

	/*********************** Build Methods  ***********************/
	BusinessCenterTime build();
	
	BusinessCenterTime.BusinessCenterTimeBuilder toBuilder();
	
	static BusinessCenterTime.BusinessCenterTimeBuilder builder() {
		return new BusinessCenterTime.BusinessCenterTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCenterTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessCenterTime> getType() {
		return BusinessCenterTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCenterTimeBuilder extends BusinessCenterTime, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		@Override
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		BusinessCenterTime.BusinessCenterTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime);
		BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenter(BusinessCenter businessCenter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
		}
		

		BusinessCenterTime.BusinessCenterTimeBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCenterTime  ***********************/
	class BusinessCenterTimeImpl implements BusinessCenterTime {
		private final LocalTime hourMinuteTime;
		private final BusinessCenter businessCenter;
		
		protected BusinessCenterTimeImpl(BusinessCenterTime.BusinessCenterTimeBuilder builder) {
			this.hourMinuteTime = builder.getHourMinuteTime();
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("hourMinuteTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("hourMinuteTime")
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenterTime build() {
			return this;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder toBuilder() {
			BusinessCenterTime.BusinessCenterTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenterTime.BusinessCenterTimeBuilder builder) {
			ofNullable(getHourMinuteTime()).ifPresent(builder::setHourMinuteTime);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenterTime _that = getType().cast(o);
		
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterTime {" +
				"hourMinuteTime=" + this.hourMinuteTime + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCenterTime  ***********************/
	class BusinessCenterTimeBuilderImpl implements BusinessCenterTime.BusinessCenterTimeBuilder {
	
		protected LocalTime hourMinuteTime;
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
		
		@Override
		@RosettaAttribute("hourMinuteTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("hourMinuteTime")
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("hourMinuteTime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("hourMinuteTime")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder setHourMinuteTime(LocalTime _hourMinuteTime) {
			this.hourMinuteTime = _hourMinuteTime == null ? null : _hourMinuteTime;
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("businessCenter")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenter(BusinessCenter _businessCenter) {
			this.businessCenter = _businessCenter == null ? null : _businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public BusinessCenterTime build() {
			return new BusinessCenterTime.BusinessCenterTimeImpl(this);
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHourMinuteTime()!=null) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenterTime.BusinessCenterTimeBuilder o = (BusinessCenterTime.BusinessCenterTimeBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			merger.mergeBasic(getHourMinuteTime(), o.getHourMinuteTime(), this::setHourMinuteTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenterTime _that = getType().cast(o);
		
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterTimeBuilder {" +
				"hourMinuteTime=" + this.hourMinuteTime + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}
}
