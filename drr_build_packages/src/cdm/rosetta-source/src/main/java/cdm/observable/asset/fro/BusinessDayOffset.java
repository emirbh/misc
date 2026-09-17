package cdm.observable.asset.fro;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.fro.meta.BusinessDayOffsetMeta;
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
 * This allows an offset to be specified as, for instance, N business days, with a business centers specified as included.
 * @version 6.23.0
 */
@RosettaDataType(value="BusinessDayOffset", builder=BusinessDayOffset.BusinessDayOffsetBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BusinessDayOffset", model="cdm", builder=BusinessDayOffset.BusinessDayOffsetBuilderImpl.class, version="6.23.0")
public interface BusinessDayOffset extends Period {

	BusinessDayOffsetMeta metaData = new BusinessDayOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business centers for the offset.
	 */
	BusinessCenters getBusinessCenters();
	/**
	 * Legal text that underlies the Fixing Offset. ISDA Fixing Offset Definition. (e.g. One day that is either a Sydney Business Day or a Melbourne Business Day following the Reset Date)
	 */
	String getFixingOffsetDefinition();
	/**
	 * Fixing Offset Reason
	 */
	String getFixingOffsetReason();

	/*********************** Build Methods  ***********************/
	BusinessDayOffset build();
	
	BusinessDayOffset.BusinessDayOffsetBuilder toBuilder();
	
	static BusinessDayOffset.BusinessDayOffsetBuilder builder() {
		return new BusinessDayOffset.BusinessDayOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessDayOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessDayOffset> getType() {
		return BusinessDayOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("fixingOffsetDefinition"), String.class, getFixingOffsetDefinition(), this);
		processor.processBasic(path.newSubPath("fixingOffsetReason"), String.class, getFixingOffsetReason(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessDayOffsetBuilder extends BusinessDayOffset, Period.PeriodBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		@Override
		BusinessDayOffset.BusinessDayOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		BusinessDayOffset.BusinessDayOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		BusinessDayOffset.BusinessDayOffsetBuilder setMeta(MetaFields meta);
		BusinessDayOffset.BusinessDayOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		BusinessDayOffset.BusinessDayOffsetBuilder setFixingOffsetDefinition(String fixingOffsetDefinition);
		BusinessDayOffset.BusinessDayOffsetBuilder setFixingOffsetReason(String fixingOffsetReason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("fixingOffsetDefinition"), String.class, getFixingOffsetDefinition(), this);
			processor.processBasic(path.newSubPath("fixingOffsetReason"), String.class, getFixingOffsetReason(), this);
		}
		

		BusinessDayOffset.BusinessDayOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessDayOffset  ***********************/
	class BusinessDayOffsetImpl extends Period.PeriodImpl implements BusinessDayOffset {
		private final BusinessCenters businessCenters;
		private final String fixingOffsetDefinition;
		private final String fixingOffsetReason;
		
		protected BusinessDayOffsetImpl(BusinessDayOffset.BusinessDayOffsetBuilder builder) {
			super(builder);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.fixingOffsetDefinition = builder.getFixingOffsetDefinition();
			this.fixingOffsetReason = builder.getFixingOffsetReason();
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("fixingOffsetDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffsetDefinition")
		public String getFixingOffsetDefinition() {
			return fixingOffsetDefinition;
		}
		
		@Override
		@RosettaAttribute("fixingOffsetReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffsetReason")
		public String getFixingOffsetReason() {
			return fixingOffsetReason;
		}
		
		@Override
		public BusinessDayOffset build() {
			return this;
		}
		
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder toBuilder() {
			BusinessDayOffset.BusinessDayOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDayOffset.BusinessDayOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getFixingOffsetDefinition()).ifPresent(builder::setFixingOffsetDefinition);
			ofNullable(getFixingOffsetReason()).ifPresent(builder::setFixingOffsetReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDayOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(fixingOffsetDefinition, _that.getFixingOffsetDefinition())) return false;
			if (!Objects.equals(fixingOffsetReason, _that.getFixingOffsetReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (fixingOffsetDefinition != null ? fixingOffsetDefinition.hashCode() : 0);
			_result = 31 * _result + (fixingOffsetReason != null ? fixingOffsetReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayOffset {" +
				"businessCenters=" + this.businessCenters + ", " +
				"fixingOffsetDefinition=" + this.fixingOffsetDefinition + ", " +
				"fixingOffsetReason=" + this.fixingOffsetReason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessDayOffset  ***********************/
	class BusinessDayOffsetBuilderImpl extends Period.PeriodBuilderImpl implements BusinessDayOffset.BusinessDayOffsetBuilder {
	
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected String fixingOffsetDefinition;
		protected String fixingOffsetReason;
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingOffsetDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffsetDefinition")
		public String getFixingOffsetDefinition() {
			return fixingOffsetDefinition;
		}
		
		@Override
		@RosettaAttribute("fixingOffsetReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingOffsetReason")
		public String getFixingOffsetReason() {
			return fixingOffsetReason;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingOffsetDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingOffsetDefinition")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setFixingOffsetDefinition(String _fixingOffsetDefinition) {
			this.fixingOffsetDefinition = _fixingOffsetDefinition == null ? null : _fixingOffsetDefinition;
			return this;
		}
		
		@RosettaAttribute("fixingOffsetReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingOffsetReason")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder setFixingOffsetReason(String _fixingOffsetReason) {
			this.fixingOffsetReason = _fixingOffsetReason == null ? null : _fixingOffsetReason;
			return this;
		}
		
		@Override
		public BusinessDayOffset build() {
			return new BusinessDayOffset.BusinessDayOffsetImpl(this);
		}
		
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder prune() {
			super.prune();
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getFixingOffsetDefinition()!=null) return true;
			if (getFixingOffsetReason()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayOffset.BusinessDayOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BusinessDayOffset.BusinessDayOffsetBuilder o = (BusinessDayOffset.BusinessDayOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getFixingOffsetDefinition(), o.getFixingOffsetDefinition(), this::setFixingOffsetDefinition);
			merger.mergeBasic(getFixingOffsetReason(), o.getFixingOffsetReason(), this::setFixingOffsetReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDayOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(fixingOffsetDefinition, _that.getFixingOffsetDefinition())) return false;
			if (!Objects.equals(fixingOffsetReason, _that.getFixingOffsetReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (fixingOffsetDefinition != null ? fixingOffsetDefinition.hashCode() : 0);
			_result = 31 * _result + (fixingOffsetReason != null ? fixingOffsetReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayOffsetBuilder {" +
				"businessCenters=" + this.businessCenters + ", " +
				"fixingOffsetDefinition=" + this.fixingOffsetDefinition + ", " +
				"fixingOffsetReason=" + this.fixingOffsetReason +
			'}' + " " + super.toString();
		}
	}
}
