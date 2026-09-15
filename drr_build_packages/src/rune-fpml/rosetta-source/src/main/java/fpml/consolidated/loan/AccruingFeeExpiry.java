package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.AccruingFeeExpiryMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An event describing a future expiry of one of the accruing fees associated with a specific facility.
 *
 */
@RosettaDataType(value="AccruingFeeExpiry", builder=AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccruingFeeExpiry", model="fpml", builder=AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl.class, version="2.1.1")
public interface AccruingFeeExpiry extends AbstractFacilityEvent {

	AccruingFeeExpiryMeta metaData = new AccruingFeeExpiryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with the loan accrual type.
	 *
	 */
	AccrualTypeId getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The accruing fee type which is expiring.
	 *
	 */
	AccruingFeeType _getType();

	/*********************** Build Methods  ***********************/
	AccruingFeeExpiry build();
	
	AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder();
	
	static AccruingFeeExpiry.AccruingFeeExpiryBuilder builder() {
		return new AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeExpiry> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccruingFeeExpiry> getType() {
		return AccruingFeeExpiry.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.class, getPreviousEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("id"), processor, AccrualTypeId.class, getId());
		processRosetta(path.newSubPath("type"), processor, AccruingFeeType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeExpiryBuilder extends AccruingFeeExpiry, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateId();
		@Override
		AccrualTypeId.AccrualTypeIdBuilder getId();
		AccruingFeeType.AccruingFeeTypeBuilder getOrCreateType();
		@Override
		AccruingFeeType.AccruingFeeTypeBuilder _getType();
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setComment(String comment);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setId(AccrualTypeId id);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setType(AccruingFeeType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("id"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getId());
			processRosetta(path.newSubPath("type"), processor, AccruingFeeType.AccruingFeeTypeBuilder.class, _getType());
		}
		

		AccruingFeeExpiry.AccruingFeeExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeExpiry  ***********************/
	class AccruingFeeExpiryImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeeExpiry {
		private final AccrualTypeId id;
		private final AccruingFeeType type;
		
		protected AccruingFeeExpiryImpl(AccruingFeeExpiry.AccruingFeeExpiryBuilder builder) {
			super(builder);
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public AccrualTypeId getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public AccruingFeeType _getType() {
			return type;
		}
		
		@Override
		public AccruingFeeExpiry build() {
			return this;
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder() {
			AccruingFeeExpiry.AccruingFeeExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeExpiry.AccruingFeeExpiryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(_getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeExpiry _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeExpiry {" +
				"id=" + this.id + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeExpiry  ***********************/
	class AccruingFeeExpiryBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements AccruingFeeExpiry.AccruingFeeExpiryBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder id;
		protected AccruingFeeType.AccruingFeeTypeBuilder type;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public AccrualTypeId.AccrualTypeIdBuilder getId() {
			return id;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public AccruingFeeType.AccruingFeeTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder getOrCreateType() {
			AccruingFeeType.AccruingFeeTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = AccruingFeeType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentEventIdentifier")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setId(AccrualTypeId _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setType(AccruingFeeType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeeExpiry build() {
			return new AccruingFeeExpiry.AccruingFeeExpiryImpl(this);
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder prune() {
			super.prune();
			if (id!=null && !id.prune().hasData()) id = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AccruingFeeExpiry.AccruingFeeExpiryBuilder o = (AccruingFeeExpiry.AccruingFeeExpiryBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeExpiry _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeExpiryBuilder {" +
				"id=" + this.id + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
