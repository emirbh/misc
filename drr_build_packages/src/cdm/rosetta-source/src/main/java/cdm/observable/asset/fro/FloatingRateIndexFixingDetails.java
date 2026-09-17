package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FloatingRateIndexFixingDetailsMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This type holds parameters defining the fixingt time and offset for a floating rate index.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexFixingDetails", builder=FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexFixingDetails", model="cdm", builder=FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexFixingDetails extends RosettaModelObject {

	FloatingRateIndexFixingDetailsMeta metaData = new FloatingRateIndexFixingDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Parameters defining the normal fixing time (can vary by index tenor / designated maturity).
	 */
	FloatingRateIndexFixingTime getFixingTime();
	/**
	 * Parameters defining the normal fixing offset (can vary by index tenor / designated maturity).
	 */
	BusinessDayOffset getFixingOffset();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexFixingDetails build();
	
	FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder toBuilder();
	
	static FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder builder() {
		return new FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexFixingDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexFixingDetails> getType() {
		return FloatingRateIndexFixingDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixingTime"), processor, FloatingRateIndexFixingTime.class, getFixingTime());
		processRosetta(path.newSubPath("fixingOffset"), processor, BusinessDayOffset.class, getFixingOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexFixingDetailsBuilder extends FloatingRateIndexFixingDetails, RosettaModelObjectBuilder {
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder getOrCreateFixingTime();
		@Override
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder getFixingTime();
		BusinessDayOffset.BusinessDayOffsetBuilder getOrCreateFixingOffset();
		@Override
		BusinessDayOffset.BusinessDayOffsetBuilder getFixingOffset();
		FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder setFixingTime(FloatingRateIndexFixingTime fixingTime);
		FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder setFixingOffset(BusinessDayOffset fixingOffset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixingTime"), processor, FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("fixingOffset"), processor, BusinessDayOffset.BusinessDayOffsetBuilder.class, getFixingOffset());
		}
		

		FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexFixingDetails  ***********************/
	class FloatingRateIndexFixingDetailsImpl implements FloatingRateIndexFixingDetails {
		private final FloatingRateIndexFixingTime fixingTime;
		private final BusinessDayOffset fixingOffset;
		
		protected FloatingRateIndexFixingDetailsImpl(FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder builder) {
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.fixingOffset = ofNullable(builder.getFixingOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public FloatingRateIndexFixingTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("fixingOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffset")
		public BusinessDayOffset getFixingOffset() {
			return fixingOffset;
		}
		
		@Override
		public FloatingRateIndexFixingDetails build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder toBuilder() {
			FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder builder) {
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getFixingOffset()).ifPresent(builder::setFixingOffset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexFixingDetails _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fixingOffset, _that.getFixingOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fixingOffset != null ? fixingOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingDetails {" +
				"fixingTime=" + this.fixingTime + ", " +
				"fixingOffset=" + this.fixingOffset +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexFixingDetails  ***********************/
	class FloatingRateIndexFixingDetailsBuilderImpl implements FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder {
	
		protected FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder fixingTime;
		protected BusinessDayOffset.BusinessDayOffsetBuilder fixingOffset;
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder getOrCreateFixingTime() {
			FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = FloatingRateIndexFixingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffset")
		public BusinessDayOffset.BusinessDayOffsetBuilder getFixingOffset() {
			return fixingOffset;
		}
		
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder getOrCreateFixingOffset() {
			BusinessDayOffset.BusinessDayOffsetBuilder result;
			if (fixingOffset!=null) {
				result = fixingOffset;
			}
			else {
				result = fixingOffset = BusinessDayOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder setFixingTime(FloatingRateIndexFixingTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingOffset")
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder setFixingOffset(BusinessDayOffset _fixingOffset) {
			this.fixingOffset = _fixingOffset == null ? null : _fixingOffset.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingDetails build() {
			return new FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsImpl(this);
		}
		
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder prune() {
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (fixingOffset!=null && !fixingOffset.prune().hasData()) fixingOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getFixingOffset()!=null && getFixingOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder o = (FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder) other;
			
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getFixingOffset(), o.getFixingOffset(), this::setFixingOffset);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexFixingDetails _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fixingOffset, _that.getFixingOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fixingOffset != null ? fixingOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingDetailsBuilder {" +
				"fixingTime=" + this.fixingTime + ", " +
				"fixingOffset=" + this.fixingOffset +
			'}';
		}
	}
}
