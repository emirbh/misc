package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.BusinessEventIdentifierMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining an event identifier issued by the indicated party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an event identifier issued by the indicated party.
 *
 */
@RosettaDataType(value="BusinessEventIdentifier", builder=BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessEventIdentifier", model="fpml", builder=BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl.class, version="2.1.1")
public interface BusinessEventIdentifier extends RosettaModelObject {

	BusinessEventIdentifierMeta metaData = new BusinessEventIdentifierMeta();

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
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
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
	EventId getEventId();

	/*********************** Build Methods  ***********************/
	BusinessEventIdentifier build();
	
	BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder();
	
	static BusinessEventIdentifier.BusinessEventIdentifierBuilder builder() {
		return new BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessEventIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessEventIdentifier> getType() {
		return BusinessEventIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("eventId"), processor, EventId.class, getEventId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessEventIdentifierBuilder extends BusinessEventIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		EventId.EventIdBuilder getOrCreateEventId();
		@Override
		EventId.EventIdBuilder getEventId();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setId(String id);
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setPartyReference(PartyReference partyReference);
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setAccountReference(AccountReference accountReference);
		BusinessEventIdentifier.BusinessEventIdentifierBuilder setEventId(EventId eventId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("eventId"), processor, EventId.EventIdBuilder.class, getEventId());
		}
		

		BusinessEventIdentifier.BusinessEventIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessEventIdentifier  ***********************/
	class BusinessEventIdentifierImpl implements BusinessEventIdentifier {
		private final String id;
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final EventId eventId;
		
		protected BusinessEventIdentifierImpl(BusinessEventIdentifier.BusinessEventIdentifierBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.eventId = ofNullable(builder.getEventId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventId")
		public EventId getEventId() {
			return eventId;
		}
		
		@Override
		public BusinessEventIdentifier build() {
			return this;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessEventIdentifier.BusinessEventIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getEventId()).ifPresent(builder::setEventId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventIdentifier {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"eventId=" + this.eventId +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessEventIdentifier  ***********************/
	class BusinessEventIdentifierBuilderImpl implements BusinessEventIdentifier.BusinessEventIdentifierBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected EventId.EventIdBuilder eventId;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventId")
		public EventId.EventIdBuilder getEventId() {
			return eventId;
		}
		
		@Override
		public EventId.EventIdBuilder getOrCreateEventId() {
			EventId.EventIdBuilder result;
			if (eventId!=null) {
				result = eventId;
			}
			else {
				result = eventId = EventId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventId")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder setEventId(EventId _eventId) {
			this.eventId = _eventId == null ? null : _eventId.toBuilder();
			return this;
		}
		
		@Override
		public BusinessEventIdentifier build() {
			return new BusinessEventIdentifier.BusinessEventIdentifierImpl(this);
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			if (eventId!=null && !eventId.prune().hasData()) eventId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getEventId()!=null && getEventId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder o = (BusinessEventIdentifier.BusinessEventIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getEventId(), o.getEventId(), this::setEventId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"eventId=" + this.eventId +
			'}';
		}
	}
}
