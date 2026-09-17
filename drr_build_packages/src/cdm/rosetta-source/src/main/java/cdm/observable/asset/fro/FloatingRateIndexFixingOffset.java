package cdm.observable.asset.fro;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.fro.meta.FloatingRateIndexFixingOffsetMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This type holds parameters defining the normal fixing offset for a floating rate index.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexFixingOffset", builder=FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexFixingOffset", model="cdm", builder=FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexFixingOffset extends BusinessDayOffset {

	FloatingRateIndexFixingOffsetMeta metaData = new FloatingRateIndexFixingOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Allows a reason to be specified for using the alternative fixing offset.
	 */
	String getDesignatedMaturity();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexFixingOffset build();
	
	FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder toBuilder();
	
	static FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder builder() {
		return new FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexFixingOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexFixingOffset> getType() {
		return FloatingRateIndexFixingOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("fixingOffsetDefinition"), String.class, getFixingOffsetDefinition(), this);
		processor.processBasic(path.newSubPath("fixingOffsetReason"), String.class, getFixingOffsetReason(), this);
		processor.processBasic(path.newSubPath("designatedMaturity"), String.class, getDesignatedMaturity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexFixingOffsetBuilder extends FloatingRateIndexFixingOffset, BusinessDayOffset.BusinessDayOffsetBuilder {
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setMeta(MetaFields meta);
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setFixingOffsetDefinition(String fixingOffsetDefinition);
		@Override
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setFixingOffsetReason(String fixingOffsetReason);
		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setDesignatedMaturity(String designatedMaturity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("fixingOffsetDefinition"), String.class, getFixingOffsetDefinition(), this);
			processor.processBasic(path.newSubPath("fixingOffsetReason"), String.class, getFixingOffsetReason(), this);
			processor.processBasic(path.newSubPath("designatedMaturity"), String.class, getDesignatedMaturity(), this);
		}
		

		FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexFixingOffset  ***********************/
	class FloatingRateIndexFixingOffsetImpl extends BusinessDayOffset.BusinessDayOffsetImpl implements FloatingRateIndexFixingOffset {
		private final String designatedMaturity;
		
		protected FloatingRateIndexFixingOffsetImpl(FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder builder) {
			super(builder);
			this.designatedMaturity = builder.getDesignatedMaturity();
		}
		
		@Override
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturity")
		public String getDesignatedMaturity() {
			return designatedMaturity;
		}
		
		@Override
		public FloatingRateIndexFixingOffset build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder toBuilder() {
			FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDesignatedMaturity()).ifPresent(builder::setDesignatedMaturity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndexFixingOffset _that = getType().cast(o);
		
			if (!Objects.equals(designatedMaturity, _that.getDesignatedMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (designatedMaturity != null ? designatedMaturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingOffset {" +
				"designatedMaturity=" + this.designatedMaturity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexFixingOffset  ***********************/
	class FloatingRateIndexFixingOffsetBuilderImpl extends BusinessDayOffset.BusinessDayOffsetBuilderImpl implements FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder {
	
		protected String designatedMaturity;
		
		@Override
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturity")
		public String getDesignatedMaturity() {
			return designatedMaturity;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingOffsetDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingOffsetDefinition")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setFixingOffsetDefinition(String _fixingOffsetDefinition) {
			this.fixingOffsetDefinition = _fixingOffsetDefinition == null ? null : _fixingOffsetDefinition;
			return this;
		}
		
		@RosettaAttribute("fixingOffsetReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingOffsetReason")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setFixingOffsetReason(String _fixingOffsetReason) {
			this.fixingOffsetReason = _fixingOffsetReason == null ? null : _fixingOffsetReason;
			return this;
		}
		
		@RosettaAttribute("designatedMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("designatedMaturity")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder setDesignatedMaturity(String _designatedMaturity) {
			this.designatedMaturity = _designatedMaturity == null ? null : _designatedMaturity;
			return this;
		}
		
		@Override
		public FloatingRateIndexFixingOffset build() {
			return new FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetImpl(this);
		}
		
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDesignatedMaturity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder o = (FloatingRateIndexFixingOffset.FloatingRateIndexFixingOffsetBuilder) other;
			
			
			merger.mergeBasic(getDesignatedMaturity(), o.getDesignatedMaturity(), this::setDesignatedMaturity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndexFixingOffset _that = getType().cast(o);
		
			if (!Objects.equals(designatedMaturity, _that.getDesignatedMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (designatedMaturity != null ? designatedMaturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexFixingOffsetBuilder {" +
				"designatedMaturity=" + this.designatedMaturity +
			'}' + " " + super.toString();
		}
	}
}
