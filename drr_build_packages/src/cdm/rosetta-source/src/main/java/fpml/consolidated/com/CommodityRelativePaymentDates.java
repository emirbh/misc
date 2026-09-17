package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityRelativePaymentDatesMeta;
import fpml.consolidated.fpmlenum.CommodityPayRelativeToEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The Payment Dates of the trade relative to the Calculation Periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Payment Dates of the trade relative to the Calculation Periods.
 *
 */
@RosettaDataType(value="CommodityRelativePaymentDates", builder=CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityRelativePaymentDates", model="fpml", builder=CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl.class, version="2.1.1")
public interface CommodityRelativePaymentDates extends RosettaModelObject {

	CommodityRelativePaymentDatesMeta metaData = new CommodityRelativePaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the payment(s) occur relative to a date such as the end of each Calculation Period or the last Pricing Date in each Calculation Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the payment(s) occur relative to a date such as the end of each Calculation Period or the last Pricing Date in each Calculation Period.
	 *
	 */
	CommodityPayRelativeToEnum getPayRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the payment(s) occur relative to the date of a physical event such as issuance of a bill of lading.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the payment(s) occur relative to the date of a physical event such as issuance of a bill of lading.
	 *
	 */
	CommodityPayRelativeToEvent getPayRelativeToEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies any offset from the adjusted Calculation Period start date, adjusted Calculation Period end date or Calculation Date applicable to each Payment Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies any offset from the adjusted Calculation Period start date, adjusted Calculation Period end date or Calculation Date applicable to each Payment Date.
	 *
	 */
	DateOffset getPaymentDaysOffset();
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
	CommodityRelativePaymentDates build();
	
	CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder();
	
	static CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder() {
		return new CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityRelativePaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityRelativePaymentDates> getType() {
		return CommodityRelativePaymentDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("payRelativeTo"), CommodityPayRelativeToEnum.class, getPayRelativeTo(), this);
		processRosetta(path.newSubPath("payRelativeToEvent"), processor, CommodityPayRelativeToEvent.class, getPayRelativeToEvent());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
		processRosetta(path.newSubPath("paymentDaysOffset"), processor, DateOffset.class, getPaymentDaysOffset());
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityRelativePaymentDatesBuilder extends CommodityRelativePaymentDates, RosettaModelObjectBuilder {
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getOrCreatePayRelativeToEvent();
		@Override
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getPayRelativeToEvent();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		DateOffset.DateOffsetBuilder getOrCreatePaymentDaysOffset();
		@Override
		DateOffset.DateOffsetBuilder getPaymentDaysOffset();
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setId(String id);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeTo(CommodityPayRelativeToEnum payRelativeTo);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeToEvent(CommodityPayRelativeToEvent payRelativeToEvent);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPaymentDaysOffset(DateOffset paymentDaysOffset);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("payRelativeTo"), CommodityPayRelativeToEnum.class, getPayRelativeTo(), this);
			processRosetta(path.newSubPath("payRelativeToEvent"), processor, CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder.class, getPayRelativeToEvent());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
			processRosetta(path.newSubPath("paymentDaysOffset"), processor, DateOffset.DateOffsetBuilder.class, getPaymentDaysOffset());
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityRelativePaymentDates  ***********************/
	class CommodityRelativePaymentDatesImpl implements CommodityRelativePaymentDates {
		private final String id;
		private final CommodityPayRelativeToEnum payRelativeTo;
		private final CommodityPayRelativeToEvent payRelativeToEvent;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		private final DateOffset paymentDaysOffset;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		
		protected CommodityRelativePaymentDatesImpl(CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder) {
			this.id = builder.getId();
			this.payRelativeTo = builder.getPayRelativeTo();
			this.payRelativeToEvent = ofNullable(builder.getPayRelativeToEvent()).map(f->f.build()).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
			this.paymentDaysOffset = ofNullable(builder.getPaymentDaysOffset()).map(f->f.build()).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeTo")
		public CommodityPayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("payRelativeToEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeToEvent")
		public CommodityPayRelativeToEvent getPayRelativeToEvent() {
			return payRelativeToEvent;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDaysOffset")
		public DateOffset getPaymentDaysOffset() {
			return paymentDaysOffset;
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
		public CommodityRelativePaymentDates build() {
			return this;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPayRelativeTo()).ifPresent(builder::setPayRelativeTo);
			ofNullable(getPayRelativeToEvent()).ifPresent(builder::setPayRelativeToEvent);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
			ofNullable(getPaymentDaysOffset()).ifPresent(builder::setPaymentDaysOffset);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativePaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(payRelativeToEvent, _that.getPayRelativeToEvent())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payRelativeToEvent != null ? payRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativePaymentDates {" +
				"id=" + this.id + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"payRelativeToEvent=" + this.payRelativeToEvent + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityRelativePaymentDates  ***********************/
	class CommodityRelativePaymentDatesBuilderImpl implements CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder {
	
		protected String id;
		protected CommodityPayRelativeToEnum payRelativeTo;
		protected CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder payRelativeToEvent;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		protected DateOffset.DateOffsetBuilder paymentDaysOffset;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeTo")
		public CommodityPayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("payRelativeToEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeToEvent")
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getPayRelativeToEvent() {
			return payRelativeToEvent;
		}
		
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getOrCreatePayRelativeToEvent() {
			CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder result;
			if (payRelativeToEvent!=null) {
				result = payRelativeToEvent;
			}
			else {
				result = payRelativeToEvent = CommodityPayRelativeToEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDaysOffset")
		public DateOffset.DateOffsetBuilder getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreatePaymentDaysOffset() {
			DateOffset.DateOffsetBuilder result;
			if (paymentDaysOffset!=null) {
				result = paymentDaysOffset;
			}
			else {
				result = paymentDaysOffset = DateOffset.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payRelativeTo")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeTo(CommodityPayRelativeToEnum _payRelativeTo) {
			this.payRelativeTo = _payRelativeTo == null ? null : _payRelativeTo;
			return this;
		}
		
		@RosettaAttribute("payRelativeToEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payRelativeToEvent")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeToEvent(CommodityPayRelativeToEvent _payRelativeToEvent) {
			this.payRelativeToEvent = _payRelativeToEvent == null ? null : _payRelativeToEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDaysOffset")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPaymentDaysOffset(DateOffset _paymentDaysOffset) {
			this.paymentDaysOffset = _paymentDaysOffset == null ? null : _paymentDaysOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public CommodityRelativePaymentDates build() {
			return new CommodityRelativePaymentDates.CommodityRelativePaymentDatesImpl(this);
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder prune() {
			if (payRelativeToEvent!=null && !payRelativeToEvent.prune().hasData()) payRelativeToEvent = null;
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			if (paymentDaysOffset!=null && !paymentDaysOffset.prune().hasData()) paymentDaysOffset = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPayRelativeTo()!=null) return true;
			if (getPayRelativeToEvent()!=null && getPayRelativeToEvent().hasData()) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			if (getPaymentDaysOffset()!=null && getPaymentDaysOffset().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder o = (CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPayRelativeToEvent(), o.getPayRelativeToEvent(), this::setPayRelativeToEvent);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			merger.mergeRosetta(getPaymentDaysOffset(), o.getPaymentDaysOffset(), this::setPaymentDaysOffset);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPayRelativeTo(), o.getPayRelativeTo(), this::setPayRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativePaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(payRelativeToEvent, _that.getPayRelativeToEvent())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payRelativeToEvent != null ? payRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativePaymentDatesBuilder {" +
				"id=" + this.id + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"payRelativeToEvent=" + this.payRelativeToEvent + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}
}
