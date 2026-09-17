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
import fpml.consolidated.loan.meta.MiscFeePaymentMeta;
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
 * Provision An event describing a misc (one-off) fee being paid at either the loan contract or facility level.
 *
 */
@RosettaDataType(value="MiscFeePayment", builder=MiscFeePayment.MiscFeePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MiscFeePayment", model="fpml", builder=MiscFeePayment.MiscFeePaymentBuilderImpl.class, version="2.1.1")
public interface MiscFeePayment extends AbstractFacilityPaymentEvent {

	MiscFeePaymentMeta metaData = new MiscFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The misc fee type, based on a scheme.
	 *
	 */
	MiscFeeType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description of the misc fee.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	MiscFeePayment build();
	
	MiscFeePayment.MiscFeePaymentBuilder toBuilder();
	
	static MiscFeePayment.MiscFeePaymentBuilder builder() {
		return new MiscFeePayment.MiscFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MiscFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MiscFeePayment> getType() {
		return MiscFeePayment.class;
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
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("type"), processor, MiscFeeType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MiscFeePaymentBuilder extends MiscFeePayment, AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder {
		MiscFeeType.MiscFeeTypeBuilder getOrCreateType();
		@Override
		MiscFeeType.MiscFeeTypeBuilder _getType();
		@Override
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setComment(String comment);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		MiscFeePayment.MiscFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		MiscFeePayment.MiscFeePaymentBuilder setType(MiscFeeType type);
		MiscFeePayment.MiscFeePaymentBuilder setDescription(String description);

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
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("type"), processor, MiscFeeType.MiscFeeTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		MiscFeePayment.MiscFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of MiscFeePayment  ***********************/
	class MiscFeePaymentImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventImpl implements MiscFeePayment {
		private final MiscFeeType type;
		private final String description;
		
		protected MiscFeePaymentImpl(MiscFeePayment.MiscFeePaymentBuilder builder) {
			super(builder);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public MiscFeeType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public MiscFeePayment build() {
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder toBuilder() {
			MiscFeePayment.MiscFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MiscFeePayment.MiscFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MiscFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeePayment {" +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MiscFeePayment  ***********************/
	class MiscFeePaymentBuilderImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl implements MiscFeePayment.MiscFeePaymentBuilder {
	
		protected MiscFeeType.MiscFeeTypeBuilder type;
		protected String description;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public MiscFeeType.MiscFeeTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public MiscFeeType.MiscFeeTypeBuilder getOrCreateType() {
			MiscFeeType.MiscFeeTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = MiscFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MiscFeePayment.MiscFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MiscFeePayment.MiscFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setType(MiscFeeType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public MiscFeePayment build() {
			return new MiscFeePayment.MiscFeePaymentImpl(this);
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MiscFeePayment.MiscFeePaymentBuilder o = (MiscFeePayment.MiscFeePaymentBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MiscFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeePaymentBuilder {" +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
