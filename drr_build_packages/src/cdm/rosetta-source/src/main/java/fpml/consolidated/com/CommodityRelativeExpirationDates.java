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
import fpml.consolidated.com.meta.CommodityRelativeExpirationDatesMeta;
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
 * Provision The Expiration Dates of the trade relative to the Calculation Periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Expiration Dates of the trade relative to the Calculation Periods.
 *
 */
@RosettaDataType(value="CommodityRelativeExpirationDates", builder=CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityRelativeExpirationDates", model="fpml", builder=CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl.class, version="2.1.1")
public interface CommodityRelativeExpirationDates extends RosettaModelObject {

	CommodityRelativeExpirationDatesMeta metaData = new CommodityRelativeExpirationDatesMeta();

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
	 * Provision Specifies whether the payment(s) occur relative to the date of a physical event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the payment(s) occur relative to the date of a physical event.
	 *
	 */
	CommodityExpireRelativeToEvent getExpireRelativeToEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies any offset from the adjusted Calculation Period start date or adjusted Calculation Period end date applicable to each Payment Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies any offset from the adjusted Calculation Period start date or adjusted Calculation Period end date applicable to each Payment Date.
	 *
	 */
	DateOffset getExpirationDateOffset();
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
	CommodityRelativeExpirationDates build();
	
	CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder();
	
	static CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder() {
		return new CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityRelativeExpirationDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityRelativeExpirationDates> getType() {
		return CommodityRelativeExpirationDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expireRelativeToEvent"), processor, CommodityExpireRelativeToEvent.class, getExpireRelativeToEvent());
		processRosetta(path.newSubPath("expirationDateOffset"), processor, DateOffset.class, getExpirationDateOffset());
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityRelativeExpirationDatesBuilder extends CommodityRelativeExpirationDates, RosettaModelObjectBuilder {
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getOrCreateExpireRelativeToEvent();
		@Override
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getExpireRelativeToEvent();
		DateOffset.DateOffsetBuilder getOrCreateExpirationDateOffset();
		@Override
		DateOffset.DateOffsetBuilder getExpirationDateOffset();
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setId(String id);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpireRelativeToEvent(CommodityExpireRelativeToEvent expireRelativeToEvent);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpirationDateOffset(DateOffset expirationDateOffset);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expireRelativeToEvent"), processor, CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder.class, getExpireRelativeToEvent());
			processRosetta(path.newSubPath("expirationDateOffset"), processor, DateOffset.DateOffsetBuilder.class, getExpirationDateOffset());
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityRelativeExpirationDates  ***********************/
	class CommodityRelativeExpirationDatesImpl implements CommodityRelativeExpirationDates {
		private final String id;
		private final CommodityExpireRelativeToEvent expireRelativeToEvent;
		private final DateOffset expirationDateOffset;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		
		protected CommodityRelativeExpirationDatesImpl(CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder) {
			this.id = builder.getId();
			this.expireRelativeToEvent = ofNullable(builder.getExpireRelativeToEvent()).map(f->f.build()).orElse(null);
			this.expirationDateOffset = ofNullable(builder.getExpirationDateOffset()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("expireRelativeToEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expireRelativeToEvent")
		public CommodityExpireRelativeToEvent getExpireRelativeToEvent() {
			return expireRelativeToEvent;
		}
		
		@Override
		@RosettaAttribute("expirationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDateOffset")
		public DateOffset getExpirationDateOffset() {
			return expirationDateOffset;
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
		public CommodityRelativeExpirationDates build() {
			return this;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getExpireRelativeToEvent()).ifPresent(builder::setExpireRelativeToEvent);
			ofNullable(getExpirationDateOffset()).ifPresent(builder::setExpirationDateOffset);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativeExpirationDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(expireRelativeToEvent, _that.getExpireRelativeToEvent())) return false;
			if (!Objects.equals(expirationDateOffset, _that.getExpirationDateOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (expireRelativeToEvent != null ? expireRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (expirationDateOffset != null ? expirationDateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativeExpirationDates {" +
				"id=" + this.id + ", " +
				"expireRelativeToEvent=" + this.expireRelativeToEvent + ", " +
				"expirationDateOffset=" + this.expirationDateOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityRelativeExpirationDates  ***********************/
	class CommodityRelativeExpirationDatesBuilderImpl implements CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder {
	
		protected String id;
		protected CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder expireRelativeToEvent;
		protected DateOffset.DateOffsetBuilder expirationDateOffset;
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
		@RosettaAttribute("expireRelativeToEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expireRelativeToEvent")
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getExpireRelativeToEvent() {
			return expireRelativeToEvent;
		}
		
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getOrCreateExpireRelativeToEvent() {
			CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder result;
			if (expireRelativeToEvent!=null) {
				result = expireRelativeToEvent;
			}
			else {
				result = expireRelativeToEvent = CommodityExpireRelativeToEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDateOffset")
		public DateOffset.DateOffsetBuilder getExpirationDateOffset() {
			return expirationDateOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreateExpirationDateOffset() {
			DateOffset.DateOffsetBuilder result;
			if (expirationDateOffset!=null) {
				result = expirationDateOffset;
			}
			else {
				result = expirationDateOffset = DateOffset.builder();
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
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("expireRelativeToEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expireRelativeToEvent")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpireRelativeToEvent(CommodityExpireRelativeToEvent _expireRelativeToEvent) {
			this.expireRelativeToEvent = _expireRelativeToEvent == null ? null : _expireRelativeToEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDateOffset")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpirationDateOffset(DateOffset _expirationDateOffset) {
			this.expirationDateOffset = _expirationDateOffset == null ? null : _expirationDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public CommodityRelativeExpirationDates build() {
			return new CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesImpl(this);
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder prune() {
			if (expireRelativeToEvent!=null && !expireRelativeToEvent.prune().hasData()) expireRelativeToEvent = null;
			if (expirationDateOffset!=null && !expirationDateOffset.prune().hasData()) expirationDateOffset = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getExpireRelativeToEvent()!=null && getExpireRelativeToEvent().hasData()) return true;
			if (getExpirationDateOffset()!=null && getExpirationDateOffset().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder o = (CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder) other;
			
			merger.mergeRosetta(getExpireRelativeToEvent(), o.getExpireRelativeToEvent(), this::setExpireRelativeToEvent);
			merger.mergeRosetta(getExpirationDateOffset(), o.getExpirationDateOffset(), this::setExpirationDateOffset);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativeExpirationDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(expireRelativeToEvent, _that.getExpireRelativeToEvent())) return false;
			if (!Objects.equals(expirationDateOffset, _that.getExpirationDateOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (expireRelativeToEvent != null ? expireRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (expirationDateOffset != null ? expirationDateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativeExpirationDatesBuilder {" +
				"id=" + this.id + ", " +
				"expireRelativeToEvent=" + this.expireRelativeToEvent + ", " +
				"expirationDateOffset=" + this.expirationDateOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}
}
