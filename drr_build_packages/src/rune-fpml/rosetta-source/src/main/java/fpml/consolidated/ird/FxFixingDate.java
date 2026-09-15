package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.FxFixingDateMeta;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.Offset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that is extending the Offset structure for providing the ability to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is extending the Offset structure for providing the ability to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 *
 */
@RosettaDataType(value="FxFixingDate", builder=FxFixingDate.FxFixingDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFixingDate", model="fpml", builder=FxFixingDate.FxFixingDateBuilderImpl.class, version="2.1.1")
public interface FxFixingDate extends Offset {

	FxFixingDateMeta metaData = new FxFixingDateMeta();

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
	 * Provision The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
	 *
	 */
	DateRelativeToPaymentDates getDateRelativeToPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
	 *
	 */
	DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates();

	/*********************** Build Methods  ***********************/
	FxFixingDate build();
	
	FxFixingDate.FxFixingDateBuilder toBuilder();
	
	static FxFixingDate.FxFixingDateBuilder builder() {
		return new FxFixingDate.FxFixingDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFixingDate> getType() {
		return FxFixingDate.class;
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
		processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.class, getDateRelativeToPaymentDates());
		processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.class, getDateRelativeToCalculationPeriodDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingDateBuilder extends FxFixingDate, Offset.OffsetBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates();
		@Override
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates();
		@Override
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates();
		@Override
		FxFixingDate.FxFixingDateBuilder setId(String id);
		@Override
		FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum period);
		@Override
		FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum dayType);
		FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		FxFixingDate.FxFixingDateBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		FxFixingDate.FxFixingDateBuilder setBusinessCenters(BusinessCenters businessCenters);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates dateRelativeToPaymentDates);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder.class, getDateRelativeToPaymentDates());
			processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder.class, getDateRelativeToCalculationPeriodDates());
		}
		

		FxFixingDate.FxFixingDateBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingDate  ***********************/
	class FxFixingDateImpl extends Offset.OffsetImpl implements FxFixingDate {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		private final DateRelativeToPaymentDates dateRelativeToPaymentDates;
		private final DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates;
		
		protected FxFixingDateImpl(FxFixingDate.FxFixingDateBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.dateRelativeToPaymentDates = ofNullable(builder.getDateRelativeToPaymentDates()).map(f->f.build()).orElse(null);
			this.dateRelativeToCalculationPeriodDates = ofNullable(builder.getDateRelativeToCalculationPeriodDates()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("dateRelativeToPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeToPaymentDates")
		public DateRelativeToPaymentDates getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeToCalculationPeriodDates")
		public DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public FxFixingDate build() {
			return this;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			FxFixingDate.FxFixingDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingDate.FxFixingDateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getDateRelativeToPaymentDates()).ifPresent(builder::setDateRelativeToPaymentDates);
			ofNullable(getDateRelativeToCalculationPeriodDates()).ifPresent(builder::setDateRelativeToCalculationPeriodDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDate {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFixingDate  ***********************/
	class FxFixingDateBuilderImpl extends Offset.OffsetBuilderImpl implements FxFixingDate.FxFixingDateBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDates;
		protected DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDates;
		
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
		@RosettaAttribute("dateRelativeToPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeToPaymentDates")
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder result;
			if (dateRelativeToPaymentDates!=null) {
				result = dateRelativeToPaymentDates;
			}
			else {
				result = dateRelativeToPaymentDates = DateRelativeToPaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeToCalculationPeriodDates")
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder result;
			if (dateRelativeToCalculationPeriodDates!=null) {
				result = dateRelativeToCalculationPeriodDates;
			}
			else {
				result = dateRelativeToCalculationPeriodDates = DateRelativeToCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxFixingDate.FxFixingDateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDayConvention")
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateRelativeToPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateRelativeToPaymentDates")
		@Override
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates _dateRelativeToPaymentDates) {
			this.dateRelativeToPaymentDates = _dateRelativeToPaymentDates == null ? null : _dateRelativeToPaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateRelativeToCalculationPeriodDates")
		@Override
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates _dateRelativeToCalculationPeriodDates) {
			this.dateRelativeToCalculationPeriodDates = _dateRelativeToCalculationPeriodDates == null ? null : _dateRelativeToCalculationPeriodDates.toBuilder();
			return this;
		}
		
		@Override
		public FxFixingDate build() {
			return new FxFixingDate.FxFixingDateImpl(this);
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder prune() {
			super.prune();
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (dateRelativeToPaymentDates!=null && !dateRelativeToPaymentDates.prune().hasData()) dateRelativeToPaymentDates = null;
			if (dateRelativeToCalculationPeriodDates!=null && !dateRelativeToCalculationPeriodDates.prune().hasData()) dateRelativeToCalculationPeriodDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getDateRelativeToPaymentDates()!=null && getDateRelativeToPaymentDates().hasData()) return true;
			if (getDateRelativeToCalculationPeriodDates()!=null && getDateRelativeToCalculationPeriodDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxFixingDate.FxFixingDateBuilder o = (FxFixingDate.FxFixingDateBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getDateRelativeToPaymentDates(), o.getDateRelativeToPaymentDates(), this::setDateRelativeToPaymentDates);
			merger.mergeRosetta(getDateRelativeToCalculationPeriodDates(), o.getDateRelativeToCalculationPeriodDates(), this::setDateRelativeToCalculationPeriodDates);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDateBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates +
			'}' + " " + super.toString();
		}
	}
}
