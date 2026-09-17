package cdm.base.datetime;

import cdm.base.datetime.meta.AdjustedRelativeDateOffsetMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.ReferenceWithMetaDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 * @version 6.23.0
 */
@RosettaDataType(value="AdjustedRelativeDateOffset", builder=AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdjustedRelativeDateOffset", model="cdm", builder=AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl.class, version="6.23.0")
public interface AdjustedRelativeDateOffset extends RelativeDateOffset {

	AdjustedRelativeDateOffsetMeta metaData = new AdjustedRelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getRelativeDateAdjustments();

	/*********************** Build Methods  ***********************/
	AdjustedRelativeDateOffset build();
	
	AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder();
	
	static AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder() {
		return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustedRelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustedRelativeDateOffset> getType() {
		return AdjustedRelativeDateOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, ReferenceWithMetaDate.class, getDateRelativeTo());
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.class, getRelativeDateAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustedRelativeDateOffsetBuilder extends AdjustedRelativeDateOffset, RelativeDateOffset.RelativeDateOffsetBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields meta);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate dateRelativeTo);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, ReferenceWithMetaDate.ReferenceWithMetaDateBuilder.class, getDateRelativeTo());
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
			processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getRelativeDateAdjustments());
		}
		

		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements AdjustedRelativeDateOffset {
		private final BusinessDayAdjustments relativeDateAdjustments;
		
		protected AdjustedRelativeDateOffsetImpl(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super(builder);
			this.relativeDateAdjustments = ofNullable(builder.getRelativeDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelativeDateAdjustments()).ifPresent(builder::setRelativeDateAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffset {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl implements AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder relativeDateAdjustments;
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (relativeDateAdjustments!=null) {
				result = relativeDateAdjustments;
			}
			else {
				result = relativeDateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("businessDayConvention")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters _businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(_businessCentersReference);
			return this;
		}
		
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateRelativeTo")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate _dateRelativeTo) {
			this.dateRelativeTo = _dateRelativeTo == null ? null : _dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date _dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(_dateRelativeTo);
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedDate")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@RosettaAttribute("relativeDateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDateAdjustments")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments _relativeDateAdjustments) {
			this.relativeDateAdjustments = _relativeDateAdjustments == null ? null : _relativeDateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl(this);
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune() {
			super.prune();
			if (relativeDateAdjustments!=null && !relativeDateAdjustments.prune().hasData()) relativeDateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelativeDateAdjustments()!=null && getRelativeDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder o = (AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getRelativeDateAdjustments(), o.getRelativeDateAdjustments(), this::setRelativeDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffsetBuilder {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}
}
