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
import fpml.consolidated.loan.meta.CommitmentAdjustmentMeta;
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
 * Provision An event defining a future change in facility commitment.
 *
 */
@RosettaDataType(value="CommitmentAdjustment", builder=CommitmentAdjustment.CommitmentAdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommitmentAdjustment", model="fpml", builder=CommitmentAdjustment.CommitmentAdjustmentBuilderImpl.class, version="2.1.1")
public interface CommitmentAdjustment extends AbstractFacilityEvent {

	CommitmentAdjustmentMeta metaData = new CommitmentAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the lender has an option to accept or deny the commitment change.
	 *
	 */
	Boolean getRefusalAllowed();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the commitment adjustment is scheduled.
	 *
	 */
	Boolean getScheduled();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the commitment adjustment is related to a PIK.
	 *
	 */
	Boolean getPik();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The global/lender commitment amount stated AFTER a commitment adjustment has taken place.
	 *
	 */
	FacilityCommitment getFacilityCommitment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the type of adjustment applied - increase or decrease.
	 *
	 */
	Adjustment getAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amortization schedule associated with the facility commitment.
	 *
	 */
	CommitmentSchedule getCommitmentSchedule();

	/*********************** Build Methods  ***********************/
	CommitmentAdjustment build();
	
	CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder();
	
	static CommitmentAdjustment.CommitmentAdjustmentBuilder builder() {
		return new CommitmentAdjustment.CommitmentAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommitmentAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommitmentAdjustment> getType() {
		return CommitmentAdjustment.class;
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
		processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
		processor.processBasic(path.newSubPath("scheduled"), Boolean.class, getScheduled(), this);
		processor.processBasic(path.newSubPath("pik"), Boolean.class, getPik(), this);
		processRosetta(path.newSubPath("facilityCommitment"), processor, FacilityCommitment.class, getFacilityCommitment());
		processRosetta(path.newSubPath("adjustment"), processor, Adjustment.class, getAdjustment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommitmentAdjustmentBuilder extends CommitmentAdjustment, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateFacilityCommitment();
		@Override
		FacilityCommitment.FacilityCommitmentBuilder getFacilityCommitment();
		Adjustment.AdjustmentBuilder getOrCreateAdjustment();
		@Override
		Adjustment.AdjustmentBuilder getAdjustment();
		CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule();
		@Override
		CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule();
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setComment(String comment);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityReference(FacilityReference facilityReference);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setRefusalAllowed(Boolean refusalAllowed);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setScheduled(Boolean scheduled);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setPik(Boolean pik);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityCommitment(FacilityCommitment facilityCommitment);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setAdjustment(Adjustment adjustment);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);

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
			processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
			processor.processBasic(path.newSubPath("scheduled"), Boolean.class, getScheduled(), this);
			processor.processBasic(path.newSubPath("pik"), Boolean.class, getPik(), this);
			processRosetta(path.newSubPath("facilityCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getFacilityCommitment());
			processRosetta(path.newSubPath("adjustment"), processor, Adjustment.AdjustmentBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
		}
		

		CommitmentAdjustment.CommitmentAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of CommitmentAdjustment  ***********************/
	class CommitmentAdjustmentImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements CommitmentAdjustment {
		private final Boolean refusalAllowed;
		private final Boolean scheduled;
		private final Boolean pik;
		private final FacilityCommitment facilityCommitment;
		private final Adjustment adjustment;
		private final CommitmentSchedule commitmentSchedule;
		
		protected CommitmentAdjustmentImpl(CommitmentAdjustment.CommitmentAdjustmentBuilder builder) {
			super(builder);
			this.refusalAllowed = builder.getRefusalAllowed();
			this.scheduled = builder.getScheduled();
			this.pik = builder.getPik();
			this.facilityCommitment = ofNullable(builder.getFacilityCommitment()).map(f->f.build()).orElse(null);
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.commitmentSchedule = ofNullable(builder.getCommitmentSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("scheduled")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("scheduled")
		public Boolean getScheduled() {
			return scheduled;
		}
		
		@Override
		@RosettaAttribute("pik")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pik")
		public Boolean getPik() {
			return pik;
		}
		
		@Override
		@RosettaAttribute("facilityCommitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityCommitment")
		public FacilityCommitment getFacilityCommitment() {
			return facilityCommitment;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentSchedule")
		public CommitmentSchedule getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentAdjustment build() {
			return this;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommitmentAdjustment.CommitmentAdjustmentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRefusalAllowed()).ifPresent(builder::setRefusalAllowed);
			ofNullable(getScheduled()).ifPresent(builder::setScheduled);
			ofNullable(getPik()).ifPresent(builder::setPik);
			ofNullable(getFacilityCommitment()).ifPresent(builder::setFacilityCommitment);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getCommitmentSchedule()).ifPresent(builder::setCommitmentSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommitmentAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(scheduled, _that.getScheduled())) return false;
			if (!Objects.equals(pik, _that.getPik())) return false;
			if (!Objects.equals(facilityCommitment, _that.getFacilityCommitment())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (scheduled != null ? scheduled.hashCode() : 0);
			_result = 31 * _result + (pik != null ? pik.hashCode() : 0);
			_result = 31 * _result + (facilityCommitment != null ? facilityCommitment.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentAdjustment {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"scheduled=" + this.scheduled + ", " +
				"pik=" + this.pik + ", " +
				"facilityCommitment=" + this.facilityCommitment + ", " +
				"adjustment=" + this.adjustment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommitmentAdjustment  ***********************/
	class CommitmentAdjustmentBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements CommitmentAdjustment.CommitmentAdjustmentBuilder {
	
		protected Boolean refusalAllowed;
		protected Boolean scheduled;
		protected Boolean pik;
		protected FacilityCommitment.FacilityCommitmentBuilder facilityCommitment;
		protected Adjustment.AdjustmentBuilder adjustment;
		protected CommitmentSchedule.CommitmentScheduleBuilder commitmentSchedule;
		
		@Override
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("scheduled")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("scheduled")
		public Boolean getScheduled() {
			return scheduled;
		}
		
		@Override
		@RosettaAttribute("pik")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pik")
		public Boolean getPik() {
			return pik;
		}
		
		@Override
		@RosettaAttribute("facilityCommitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getFacilityCommitment() {
			return facilityCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateFacilityCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (facilityCommitment!=null) {
				result = facilityCommitment;
			}
			else {
				result = facilityCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment.AdjustmentBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder getOrCreateAdjustment() {
			Adjustment.AdjustmentBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = Adjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentSchedule")
		public CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule() {
			CommitmentSchedule.CommitmentScheduleBuilder result;
			if (commitmentSchedule!=null) {
				result = commitmentSchedule;
			}
			else {
				result = commitmentSchedule = CommitmentSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setRefusalAllowed(Boolean _refusalAllowed) {
			this.refusalAllowed = _refusalAllowed == null ? null : _refusalAllowed;
			return this;
		}
		
		@RosettaAttribute("scheduled")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("scheduled")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setScheduled(Boolean _scheduled) {
			this.scheduled = _scheduled == null ? null : _scheduled;
			return this;
		}
		
		@RosettaAttribute("pik")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pik")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setPik(Boolean _pik) {
			this.pik = _pik == null ? null : _pik;
			return this;
		}
		
		@RosettaAttribute("facilityCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityCommitment")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityCommitment(FacilityCommitment _facilityCommitment) {
			this.facilityCommitment = _facilityCommitment == null ? null : _facilityCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustment")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setAdjustment(Adjustment _adjustment) {
			this.adjustment = _adjustment == null ? null : _adjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@Override
		public CommitmentAdjustment build() {
			return new CommitmentAdjustment.CommitmentAdjustmentImpl(this);
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder prune() {
			super.prune();
			if (facilityCommitment!=null && !facilityCommitment.prune().hasData()) facilityCommitment = null;
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (commitmentSchedule!=null && !commitmentSchedule.prune().hasData()) commitmentSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRefusalAllowed()!=null) return true;
			if (getScheduled()!=null) return true;
			if (getPik()!=null) return true;
			if (getFacilityCommitment()!=null && getFacilityCommitment().hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getCommitmentSchedule()!=null && getCommitmentSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommitmentAdjustment.CommitmentAdjustmentBuilder o = (CommitmentAdjustment.CommitmentAdjustmentBuilder) other;
			
			merger.mergeRosetta(getFacilityCommitment(), o.getFacilityCommitment(), this::setFacilityCommitment);
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getCommitmentSchedule(), o.getCommitmentSchedule(), this::setCommitmentSchedule);
			
			merger.mergeBasic(getRefusalAllowed(), o.getRefusalAllowed(), this::setRefusalAllowed);
			merger.mergeBasic(getScheduled(), o.getScheduled(), this::setScheduled);
			merger.mergeBasic(getPik(), o.getPik(), this::setPik);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommitmentAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(scheduled, _that.getScheduled())) return false;
			if (!Objects.equals(pik, _that.getPik())) return false;
			if (!Objects.equals(facilityCommitment, _that.getFacilityCommitment())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (scheduled != null ? scheduled.hashCode() : 0);
			_result = 31 * _result + (pik != null ? pik.hashCode() : 0);
			_result = 31 * _result + (facilityCommitment != null ? facilityCommitment.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentAdjustmentBuilder {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"scheduled=" + this.scheduled + ", " +
				"pik=" + this.pik + ", " +
				"facilityCommitment=" + this.facilityCommitment + ", " +
				"adjustment=" + this.adjustment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule +
			'}' + " " + super.toString();
		}
	}
}
