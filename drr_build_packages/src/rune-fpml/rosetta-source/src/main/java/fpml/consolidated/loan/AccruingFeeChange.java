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
import fpml.consolidated.loan.meta.AccruingFeeChangeMeta;
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
 * Provision An event describing a future change to an accruing fee associated with a specific facility.
 *
 */
@RosettaDataType(value="AccruingFeeChange", builder=AccruingFeeChange.AccruingFeeChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccruingFeeChange", model="fpml", builder=AccruingFeeChange.AccruingFeeChangeBuilderImpl.class, version="2.1.1")
public interface AccruingFeeChange extends AbstractFacilityEvent {

	AccruingFeeChangeMeta metaData = new AccruingFeeChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines new rate and the date on which the rate is no longer valid.
	 *
	 */
	AccruingFeeOption getAccruingFeeOption();

	/*********************** Build Methods  ***********************/
	AccruingFeeChange build();
	
	AccruingFeeChange.AccruingFeeChangeBuilder toBuilder();
	
	static AccruingFeeChange.AccruingFeeChangeBuilder builder() {
		return new AccruingFeeChange.AccruingFeeChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccruingFeeChange> getType() {
		return AccruingFeeChange.class;
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
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeChangeBuilder extends AccruingFeeChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption();
		@Override
		AccruingFeeOption.AccruingFeeOptionBuilder getAccruingFeeOption();
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setComment(String comment);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AccruingFeeChange.AccruingFeeChangeBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingFeeChange.AccruingFeeChangeBuilder setAccruingFeeOption(AccruingFeeOption accruingFeeOption);

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
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
		}
		

		AccruingFeeChange.AccruingFeeChangeBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeChange  ***********************/
	class AccruingFeeChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeeChange {
		private final AccruingFeeOption accruingFeeOption;
		
		protected AccruingFeeChangeImpl(AccruingFeeChange.AccruingFeeChangeBuilder builder) {
			super(builder);
			this.accruingFeeOption = ofNullable(builder.getAccruingFeeOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accruingFeeOption")
		public AccruingFeeOption getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		public AccruingFeeChange build() {
			return this;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder toBuilder() {
			AccruingFeeChange.AccruingFeeChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeChange.AccruingFeeChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingFeeOption()).ifPresent(builder::setAccruingFeeOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChange {" +
				"accruingFeeOption=" + this.accruingFeeOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeChange  ***********************/
	class AccruingFeeChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements AccruingFeeChange.AccruingFeeChangeBuilder {
	
		protected AccruingFeeOption.AccruingFeeOptionBuilder accruingFeeOption;
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accruingFeeOption")
		public AccruingFeeOption.AccruingFeeOptionBuilder getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption() {
			AccruingFeeOption.AccruingFeeOptionBuilder result;
			if (accruingFeeOption!=null) {
				result = accruingFeeOption;
			}
			else {
				result = accruingFeeOption = AccruingFeeOption.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingFeeChange.AccruingFeeChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingFeeChange.AccruingFeeChangeBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accruingFeeOption")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder setAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			this.accruingFeeOption = _accruingFeeOption == null ? null : _accruingFeeOption.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeeChange build() {
			return new AccruingFeeChange.AccruingFeeChangeImpl(this);
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder prune() {
			super.prune();
			if (accruingFeeOption!=null && !accruingFeeOption.prune().hasData()) accruingFeeOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingFeeOption()!=null && getAccruingFeeOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AccruingFeeChange.AccruingFeeChangeBuilder o = (AccruingFeeChange.AccruingFeeChangeBuilder) other;
			
			merger.mergeRosetta(getAccruingFeeOption(), o.getAccruingFeeOption(), this::setAccruingFeeOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeBuilder {" +
				"accruingFeeOption=" + this.accruingFeeOption +
			'}' + " " + super.toString();
		}
	}
}
