package cdm.observable.asset.fro;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.observable.asset.fro.meta.FloatingRateIndexFixingTimeMeta;
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
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This type holds parameters defining the normal fixing time for a floating rate index.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexFixingTime", builder=FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexFixingTime", model="cdm", builder=FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexFixingTime extends BusinessCenterTime {

	FloatingRateIndexFixingTimeMeta metaData = new FloatingRateIndexFixingTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Allows a designed maturity to be specified for the fixing time.
	 */
	String getDesignatedMaturity();
	/**
	 * Legal text that underlies the Fixing Time. ISDA Fixing Time Definition. (e.g. 09:30, Sydney time).
	 */
	String getFixingTimeDefinition();
	/**
	 * Fixing Reason
	 */
	String getFixingReason();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexFixingTime build();
	
	FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder toBuilder();
	
	static FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder builder() {
		return new FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexFixingTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexFixingTime> getType() {
		return FloatingRateIndexFixingTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
		processor.processBasic(path.newSubPath("designatedMaturity"), String.class, getDesignatedMaturity(), this);
		processor.processBasic(path.newSubPath("fixingTimeDefinition"), String.class, getFixingTimeDefinition(), this);
		processor.processBasic(path.newSubPath("fixingReason"), String.class, getFixingReason(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexFixingTimeBuilder extends FloatingRateIndexFixingTime, BusinessCenterTime.BusinessCenterTimeBuilder {
		@Override
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime);
		@Override
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		@Override
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter);
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setDesignatedMaturity(String designatedMaturity);
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setFixingTimeDefinition(String fixingTimeDefinition);
		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setFixingReason(String fixingReason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
			processor.processBasic(path.newSubPath("designatedMaturity"), String.class, getDesignatedMaturity(), this);
			processor.processBasic(path.newSubPath("fixingTimeDefinition"), String.class, getFixingTimeDefinition(), this);
			processor.processBasic(path.newSubPath("fixingReason"), String.class, getFixingReason(), this);
		}
		

		FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexFixingTime  ***********************/
	class FloatingRateIndexFixingTimeImpl extends BusinessCenterTime.BusinessCenterTimeImpl implements FloatingRateIndexFixingTime {
		private final String designatedMaturity;
		private final String fixingTimeDefinition;
		private final String fixingReason;
		
		protected FloatingRateIndexFixingTimeImpl(FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder builder) {
			super(builder);
			this.designatedMaturity = builder.getDesignatedMaturity();
			this.fixingTimeDefinition = builder.getFixingTimeDefinition();
			this.fixingReason = builder.getFixingReason();
		}
		
		@Override
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturity")
		public String getDesignatedMaturity() {
			return designatedMaturity;
		}
		
		@Override
		@RosettaAttribute("fixingTimeDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTimeDefinition")
		public String getFixingTimeDefinition() {
			return fixingTimeDefinition;
		}
		
		@Override
		@RosettaAttribute("fixingReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingReason")
		public String getFixingReason() {
			return fixingReason;
		}
		
		@Override
		public FloatingRateIndexFixingTime build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder toBuilder() {
			FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDesignatedMaturity()).ifPresent(builder::setDesignatedMaturity);
			ofNullable(getFixingTimeDefinition()).ifPresent(builder::setFixingTimeDefinition);
			ofNullable(getFixingReason()).ifPresent(builder::setFixingReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndexFixingTime _that = getType().cast(o);
		
			if (!Objects.equals(designatedMaturity, _that.getDesignatedMaturity())) return false;
			if (!Objects.equals(fixingTimeDefinition, _that.getFixingTimeDefinition())) return false;
			if (!Objects.equals(fixingReason, _that.getFixingReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (designatedMaturity != null ? designatedMaturity.hashCode() : 0);
			_result = 31 * _result + (fixingTimeDefinition != null ? fixingTimeDefinition.hashCode() : 0);
			_result = 31 * _result + (fixingReason != null ? fixingReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingTime {" +
				"designatedMaturity=" + this.designatedMaturity + ", " +
				"fixingTimeDefinition=" + this.fixingTimeDefinition + ", " +
				"fixingReason=" + this.fixingReason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexFixingTime  ***********************/
	class FloatingRateIndexFixingTimeBuilderImpl extends BusinessCenterTime.BusinessCenterTimeBuilderImpl implements FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder {
	
		protected String designatedMaturity;
		protected String fixingTimeDefinition;
		protected String fixingReason;
		
		@Override
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturity")
		public String getDesignatedMaturity() {
			return designatedMaturity;
		}
		
		@Override
		@RosettaAttribute("fixingTimeDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTimeDefinition")
		public String getFixingTimeDefinition() {
			return fixingTimeDefinition;
		}
		
		@Override
		@RosettaAttribute("fixingReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingReason")
		public String getFixingReason() {
			return fixingReason;
		}
		
		@RosettaAttribute("hourMinuteTime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("hourMinuteTime")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setHourMinuteTime(LocalTime _hourMinuteTime) {
			this.hourMinuteTime = _hourMinuteTime == null ? null : _hourMinuteTime;
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("businessCenter")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum _businessCenter) {
			this.businessCenter = _businessCenter == null ? null : _businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setBusinessCenterValue(BusinessCenterEnum _businessCenter) {
			this.getOrCreateBusinessCenter().setValue(_businessCenter);
			return this;
		}
		
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("designatedMaturity")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setDesignatedMaturity(String _designatedMaturity) {
			this.designatedMaturity = _designatedMaturity == null ? null : _designatedMaturity;
			return this;
		}
		
		@RosettaAttribute("fixingTimeDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTimeDefinition")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setFixingTimeDefinition(String _fixingTimeDefinition) {
			this.fixingTimeDefinition = _fixingTimeDefinition == null ? null : _fixingTimeDefinition;
			return this;
		}
		
		@RosettaAttribute("fixingReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingReason")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder setFixingReason(String _fixingReason) {
			this.fixingReason = _fixingReason == null ? null : _fixingReason;
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingTime build() {
			return new FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeImpl(this);
		}
		
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDesignatedMaturity()!=null) return true;
			if (getFixingTimeDefinition()!=null) return true;
			if (getFixingReason()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder o = (FloatingRateIndexFixingTime.FloatingRateIndexFixingTimeBuilder) other;
			
			
			merger.mergeBasic(getDesignatedMaturity(), o.getDesignatedMaturity(), this::setDesignatedMaturity);
			merger.mergeBasic(getFixingTimeDefinition(), o.getFixingTimeDefinition(), this::setFixingTimeDefinition);
			merger.mergeBasic(getFixingReason(), o.getFixingReason(), this::setFixingReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndexFixingTime _that = getType().cast(o);
		
			if (!Objects.equals(designatedMaturity, _that.getDesignatedMaturity())) return false;
			if (!Objects.equals(fixingTimeDefinition, _that.getFixingTimeDefinition())) return false;
			if (!Objects.equals(fixingReason, _that.getFixingReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (designatedMaturity != null ? designatedMaturity.hashCode() : 0);
			_result = 31 * _result + (fixingTimeDefinition != null ? fixingTimeDefinition.hashCode() : 0);
			_result = 31 * _result + (fixingReason != null ? fixingReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingTimeBuilder {" +
				"designatedMaturity=" + this.designatedMaturity + ", " +
				"fixingTimeDefinition=" + this.fixingTimeDefinition + ", " +
				"fixingReason=" + this.fixingReason +
			'}' + " " + super.toString();
		}
	}
}
