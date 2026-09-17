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
import fpml.consolidated.loan.meta.RolloverMeta;
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
 * Provision An event representing the prepayment structure associated within a facility.
 *
 */
@RosettaDataType(value="Rollover", builder=Rollover.RolloverBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Rollover", model="fpml", builder=Rollover.RolloverBuilderImpl.class, version="2.1.1")
public interface Rollover extends AbstractLoanServicingEvent {

	RolloverMeta metaData = new RolloverMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of references to all contracts whose rates are resetting or that are terminating as part of a rollover event.
	 *
	 */
	LoanContractsReference getCurrentContracts();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of all contracts whose rates are resetting or that are initiating as part of the rollover event.
	 *
	 */
	LoanContractList getNewContracts();

	/*********************** Build Methods  ***********************/
	Rollover build();
	
	Rollover.RolloverBuilder toBuilder();
	
	static Rollover.RolloverBuilder builder() {
		return new Rollover.RolloverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Rollover> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Rollover> getType() {
		return Rollover.class;
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
		processRosetta(path.newSubPath("currentContracts"), processor, LoanContractsReference.class, getCurrentContracts());
		processRosetta(path.newSubPath("newContracts"), processor, LoanContractList.class, getNewContracts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RolloverBuilder extends Rollover, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
		LoanContractsReference.LoanContractsReferenceBuilder getOrCreateCurrentContracts();
		@Override
		LoanContractsReference.LoanContractsReferenceBuilder getCurrentContracts();
		LoanContractList.LoanContractListBuilder getOrCreateNewContracts();
		@Override
		LoanContractList.LoanContractListBuilder getNewContracts();
		@Override
		Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		Rollover.RolloverBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		Rollover.RolloverBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		Rollover.RolloverBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		Rollover.RolloverBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		Rollover.RolloverBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		Rollover.RolloverBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		Rollover.RolloverBuilder setCashPayable(CashPayable cashPayable);
		@Override
		Rollover.RolloverBuilder setComment(String comment);
		@Override
		Rollover.RolloverBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		Rollover.RolloverBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		Rollover.RolloverBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		Rollover.RolloverBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		Rollover.RolloverBuilder setCurrentContracts(LoanContractsReference currentContracts);
		Rollover.RolloverBuilder setNewContracts(LoanContractList newContracts);

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
			processRosetta(path.newSubPath("currentContracts"), processor, LoanContractsReference.LoanContractsReferenceBuilder.class, getCurrentContracts());
			processRosetta(path.newSubPath("newContracts"), processor, LoanContractList.LoanContractListBuilder.class, getNewContracts());
		}
		

		Rollover.RolloverBuilder prune();
	}

	/*********************** Immutable Implementation of Rollover  ***********************/
	class RolloverImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventImpl implements Rollover {
		private final LoanContractsReference currentContracts;
		private final LoanContractList newContracts;
		
		protected RolloverImpl(Rollover.RolloverBuilder builder) {
			super(builder);
			this.currentContracts = ofNullable(builder.getCurrentContracts()).map(f->f.build()).orElse(null);
			this.newContracts = ofNullable(builder.getNewContracts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currentContracts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentContracts")
		public LoanContractsReference getCurrentContracts() {
			return currentContracts;
		}
		
		@Override
		@RosettaAttribute("newContracts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("newContracts")
		public LoanContractList getNewContracts() {
			return newContracts;
		}
		
		@Override
		public Rollover build() {
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder toBuilder() {
			Rollover.RolloverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Rollover.RolloverBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrentContracts()).ifPresent(builder::setCurrentContracts);
			ofNullable(getNewContracts()).ifPresent(builder::setNewContracts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Rollover _that = getType().cast(o);
		
			if (!Objects.equals(currentContracts, _that.getCurrentContracts())) return false;
			if (!Objects.equals(newContracts, _that.getNewContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentContracts != null ? currentContracts.hashCode() : 0);
			_result = 31 * _result + (newContracts != null ? newContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Rollover {" +
				"currentContracts=" + this.currentContracts + ", " +
				"newContracts=" + this.newContracts +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Rollover  ***********************/
	class RolloverBuilderImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl implements Rollover.RolloverBuilder {
	
		protected LoanContractsReference.LoanContractsReferenceBuilder currentContracts;
		protected LoanContractList.LoanContractListBuilder newContracts;
		
		@Override
		@RosettaAttribute("currentContracts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentContracts")
		public LoanContractsReference.LoanContractsReferenceBuilder getCurrentContracts() {
			return currentContracts;
		}
		
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder getOrCreateCurrentContracts() {
			LoanContractsReference.LoanContractsReferenceBuilder result;
			if (currentContracts!=null) {
				result = currentContracts;
			}
			else {
				result = currentContracts = LoanContractsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("newContracts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("newContracts")
		public LoanContractList.LoanContractListBuilder getNewContracts() {
			return newContracts;
		}
		
		@Override
		public LoanContractList.LoanContractListBuilder getOrCreateNewContracts() {
			LoanContractList.LoanContractListBuilder result;
			if (newContracts!=null) {
				result = newContracts;
			}
			else {
				result = newContracts = LoanContractList.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Rollover.RolloverBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Rollover.RolloverBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public Rollover.RolloverBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public Rollover.RolloverBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public Rollover.RolloverBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public Rollover.RolloverBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public Rollover.RolloverBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public Rollover.RolloverBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public Rollover.RolloverBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public Rollover.RolloverBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public Rollover.RolloverBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentContracts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentContracts")
		@Override
		public Rollover.RolloverBuilder setCurrentContracts(LoanContractsReference _currentContracts) {
			this.currentContracts = _currentContracts == null ? null : _currentContracts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("newContracts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("newContracts")
		@Override
		public Rollover.RolloverBuilder setNewContracts(LoanContractList _newContracts) {
			this.newContracts = _newContracts == null ? null : _newContracts.toBuilder();
			return this;
		}
		
		@Override
		public Rollover build() {
			return new Rollover.RolloverImpl(this);
		}
		
		@Override
		public Rollover.RolloverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rollover.RolloverBuilder prune() {
			super.prune();
			if (currentContracts!=null && !currentContracts.prune().hasData()) currentContracts = null;
			if (newContracts!=null && !newContracts.prune().hasData()) newContracts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrentContracts()!=null && getCurrentContracts().hasData()) return true;
			if (getNewContracts()!=null && getNewContracts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rollover.RolloverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Rollover.RolloverBuilder o = (Rollover.RolloverBuilder) other;
			
			merger.mergeRosetta(getCurrentContracts(), o.getCurrentContracts(), this::setCurrentContracts);
			merger.mergeRosetta(getNewContracts(), o.getNewContracts(), this::setNewContracts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Rollover _that = getType().cast(o);
		
			if (!Objects.equals(currentContracts, _that.getCurrentContracts())) return false;
			if (!Objects.equals(newContracts, _that.getNewContracts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentContracts != null ? currentContracts.hashCode() : 0);
			_result = 31 * _result + (newContracts != null ? newContracts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverBuilder {" +
				"currentContracts=" + this.currentContracts + ", " +
				"newContracts=" + this.newContracts +
			'}' + " " + super.toString();
		}
	}
}
