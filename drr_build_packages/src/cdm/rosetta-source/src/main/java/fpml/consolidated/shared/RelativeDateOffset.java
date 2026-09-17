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
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.meta.RelativeDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 *
 */
@RosettaDataType(value="RelativeDateOffset", builder=RelativeDateOffset.RelativeDateOffsetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelativeDateOffset", model="fpml", builder=RelativeDateOffset.RelativeDateOffsetBuilderImpl.class, version="2.1.1")
public interface RelativeDateOffset extends Offset {

	RelativeDateOffsetMeta metaData = new RelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 *
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 */
	BusinessCentersReference getBusinessCentersReference();
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
	BusinessCenters getBusinessCenters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 *
	 */
	DateReference getDateRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 */
	IdentifiedDate getAdjustedDate();

	/*********************** Build Methods  ***********************/
	RelativeDateOffset build();
	
	RelativeDateOffset.RelativeDateOffsetBuilder toBuilder();
	
	static RelativeDateOffset.RelativeDateOffsetBuilder builder() {
		return new RelativeDateOffset.RelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelativeDateOffset> getType() {
		return RelativeDateOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDateOffsetBuilder extends RelativeDateOffset, Offset.OffsetBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		DateReference.DateReferenceBuilder getOrCreateDateRelativeTo();
		@Override
		DateReference.DateReferenceBuilder getDateRelativeTo();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setId(String id);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(DateReference dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
		}
		

		RelativeDateOffset.RelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetImpl extends Offset.OffsetImpl implements RelativeDateOffset {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		private final DateReference dateRelativeTo;
		private final IdentifiedDate adjustedDate;
		
		protected RelativeDateOffsetImpl(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeTo")
		public DateReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public IdentifiedDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public RelativeDateOffset build() {
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			RelativeDateOffset.RelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffset {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetBuilderImpl extends Offset.OffsetBuilderImpl implements RelativeDateOffset.RelativeDateOffsetBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected DateReference.DateReferenceBuilder dateRelativeTo;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeTo")
		public DateReference.DateReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDateRelativeTo() {
			DateReference.DateReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDayConvention")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateRelativeTo")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(DateReference _dateRelativeTo) {
			this.dateRelativeTo = _dateRelativeTo == null ? null : _dateRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedDate")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset build() {
			return new RelativeDateOffset.RelativeDateOffsetImpl(this);
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder prune() {
			super.prune();
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RelativeDateOffset.RelativeDateOffsetBuilder o = (RelativeDateOffset.RelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffsetBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}
}
