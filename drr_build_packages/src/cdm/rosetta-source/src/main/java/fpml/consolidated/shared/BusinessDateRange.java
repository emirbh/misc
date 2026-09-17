package fpml.consolidated.shared;

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
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.shared.meta.BusinessDateRangeMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 *
 */
@RosettaDataType(value="BusinessDateRange", builder=BusinessDateRange.BusinessDateRangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessDateRange", model="fpml", builder=BusinessDateRange.BusinessDateRangeBuilderImpl.class, version="2.1.1")
public interface BusinessDateRange extends DateRange {

	BusinessDateRangeMeta metaData = new BusinessDateRangeMeta();

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

	/*********************** Build Methods  ***********************/
	BusinessDateRange build();
	
	BusinessDateRange.BusinessDateRangeBuilder toBuilder();
	
	static BusinessDateRange.BusinessDateRangeBuilder builder() {
		return new BusinessDateRange.BusinessDateRangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessDateRange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessDateRange> getType() {
		return BusinessDateRange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedFirstDate"), ZonedDateTime.class, getUnadjustedFirstDate(), this);
		processor.processBasic(path.newSubPath("unadjustedLastDate"), ZonedDateTime.class, getUnadjustedLastDate(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessDateRangeBuilder extends BusinessDateRange, DateRange.DateRangeBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		@Override
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(ZonedDateTime unadjustedFirstDate);
		@Override
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(ZonedDateTime unadjustedLastDate);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedFirstDate"), ZonedDateTime.class, getUnadjustedFirstDate(), this);
			processor.processBasic(path.newSubPath("unadjustedLastDate"), ZonedDateTime.class, getUnadjustedLastDate(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		BusinessDateRange.BusinessDateRangeBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessDateRange  ***********************/
	class BusinessDateRangeImpl extends DateRange.DateRangeImpl implements BusinessDateRange {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		
		protected BusinessDateRangeImpl(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
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
		public BusinessDateRange build() {
			return this;
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			BusinessDateRange.BusinessDateRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRange {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessDateRange  ***********************/
	class BusinessDateRangeBuilderImpl extends DateRange.DateRangeBuilderImpl implements BusinessDateRange.BusinessDateRangeBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		
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
		
		@RosettaAttribute("unadjustedFirstDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedFirstDate")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(ZonedDateTime _unadjustedFirstDate) {
			this.unadjustedFirstDate = _unadjustedFirstDate == null ? null : _unadjustedFirstDate;
			return this;
		}
		
		@RosettaAttribute("unadjustedLastDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedLastDate")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(ZonedDateTime _unadjustedLastDate) {
			this.unadjustedLastDate = _unadjustedLastDate == null ? null : _unadjustedLastDate;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDayConvention")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public BusinessDateRange build() {
			return new BusinessDateRange.BusinessDateRangeImpl(this);
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder prune() {
			super.prune();
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BusinessDateRange.BusinessDateRangeBuilder o = (BusinessDateRange.BusinessDateRangeBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRangeBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}' + " " + super.toString();
		}
	}
}
