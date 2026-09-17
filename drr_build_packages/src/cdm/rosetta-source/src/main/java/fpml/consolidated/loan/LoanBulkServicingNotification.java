package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanBulkServicingNotificationMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * Provision A loan servicing notification used to communicate multiple business events, within a single notification.
 *
 */
@RosettaDataType(value="LoanBulkServicingNotification", builder=LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanBulkServicingNotification", model="fpml", builder=LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl.class, version="2.1.1")
public interface LoanBulkServicingNotification extends AbstractContractNotification {

	LoanBulkServicingNotificationMeta metaData = new LoanBulkServicingNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanBulkServicingNotificationChoice> getLoanBulkServicingNotificationChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanBulkServicingNotificationSequence> getLoanBulkServicingNotificationSequence();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotification build();
	
	LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder();
	
	static LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder() {
		return new LoanBulkServicingNotification.LoanBulkServicingNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanBulkServicingNotification> getType() {
		return LoanBulkServicingNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("loanBulkServicingNotificationChoice"), processor, LoanBulkServicingNotificationChoice.class, getLoanBulkServicingNotificationChoice());
		processRosetta(path.newSubPath("loanBulkServicingNotificationSequence"), processor, LoanBulkServicingNotificationSequence.class, getLoanBulkServicingNotificationSequence());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationBuilder extends LoanBulkServicingNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder getOrCreateLoanBulkServicingNotificationChoice(int index);
		@Override
		List<? extends LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder> getLoanBulkServicingNotificationChoice();
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder getOrCreateLoanBulkServicingNotificationSequence(int index);
		@Override
		List<? extends LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder> getLoanBulkServicingNotificationSequence();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(Validation validation);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition, int idx);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		@Override
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice, int idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(List<? extends LoanBulkServicingNotificationChoice> loanBulkServicingNotificationChoice);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice(List<? extends LoanBulkServicingNotificationChoice> loanBulkServicingNotificationChoice);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(LoanBulkServicingNotificationSequence loanBulkServicingNotificationSequence);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(LoanBulkServicingNotificationSequence loanBulkServicingNotificationSequence, int idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(List<? extends LoanBulkServicingNotificationSequence> loanBulkServicingNotificationSequence);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationSequence(List<? extends LoanBulkServicingNotificationSequence> loanBulkServicingNotificationSequence);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party party, int idx);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(List<? extends Party> party);
		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("loanBulkServicingNotificationChoice"), processor, LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder.class, getLoanBulkServicingNotificationChoice());
			processRosetta(path.newSubPath("loanBulkServicingNotificationSequence"), processor, LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder.class, getLoanBulkServicingNotificationSequence());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotification  ***********************/
	class LoanBulkServicingNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LoanBulkServicingNotification {
		private final List<? extends LoanBulkServicingNotificationChoice> loanBulkServicingNotificationChoice;
		private final List<? extends LoanBulkServicingNotificationSequence> loanBulkServicingNotificationSequence;
		private final List<? extends Party> party;
		
		protected LoanBulkServicingNotificationImpl(LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder) {
			super(builder);
			this.loanBulkServicingNotificationChoice = ofNullable(builder.getLoanBulkServicingNotificationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanBulkServicingNotificationSequence = ofNullable(builder.getLoanBulkServicingNotificationSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationChoice")
		public List<? extends LoanBulkServicingNotificationChoice> getLoanBulkServicingNotificationChoice() {
			return loanBulkServicingNotificationChoice;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequence")
		public List<? extends LoanBulkServicingNotificationSequence> getLoanBulkServicingNotificationSequence() {
			return loanBulkServicingNotificationSequence;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanBulkServicingNotification build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder() {
			LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanBulkServicingNotificationChoice()).ifPresent(builder::setLoanBulkServicingNotificationChoice);
			ofNullable(getLoanBulkServicingNotificationSequence()).ifPresent(builder::setLoanBulkServicingNotificationSequence);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanBulkServicingNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice, _that.getLoanBulkServicingNotificationChoice())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationSequence, _that.getLoanBulkServicingNotificationSequence())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanBulkServicingNotificationChoice != null ? loanBulkServicingNotificationChoice.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationSequence != null ? loanBulkServicingNotificationSequence.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotification {" +
				"loanBulkServicingNotificationChoice=" + this.loanBulkServicingNotificationChoice + ", " +
				"loanBulkServicingNotificationSequence=" + this.loanBulkServicingNotificationSequence + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotification  ***********************/
	class LoanBulkServicingNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl implements LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder {
	
		protected List<LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder> loanBulkServicingNotificationChoice = new ArrayList<>();
		protected List<LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder> loanBulkServicingNotificationSequence = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationChoice")
		public List<? extends LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder> getLoanBulkServicingNotificationChoice() {
			return loanBulkServicingNotificationChoice;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder getOrCreateLoanBulkServicingNotificationChoice(int index) {
			if (loanBulkServicingNotificationChoice==null) {
				this.loanBulkServicingNotificationChoice = new ArrayList<>();
			}
			return getIndex(loanBulkServicingNotificationChoice, index, () -> {
						LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder newLoanBulkServicingNotificationChoice = LoanBulkServicingNotificationChoice.builder();
						return newLoanBulkServicingNotificationChoice;
					});
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequence")
		public List<? extends LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder> getLoanBulkServicingNotificationSequence() {
			return loanBulkServicingNotificationSequence;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder getOrCreateLoanBulkServicingNotificationSequence(int index) {
			if (loanBulkServicingNotificationSequence==null) {
				this.loanBulkServicingNotificationSequence = new ArrayList<>();
			}
			return getIndex(loanBulkServicingNotificationSequence, index, () -> {
						LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder newLoanBulkServicingNotificationSequence = LoanBulkServicingNotificationSequence.builder();
						return newLoanBulkServicingNotificationSequence;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (final EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition) {
			if (_facilityPosition != null) {
				this.facilityPosition.add(_facilityPosition.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition, int idx) {
			getIndex(this.facilityPosition, idx, () -> _facilityPosition.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions != null) {
				for (final FacilityPosition toAdd : facilityPositions) {
					this.facilityPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions == null) {
				this.facilityPosition = new ArrayList<>();
			} else {
				this.facilityPosition = facilityPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationChoice")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(LoanBulkServicingNotificationChoice _loanBulkServicingNotificationChoice) {
			if (_loanBulkServicingNotificationChoice != null) {
				this.loanBulkServicingNotificationChoice.add(_loanBulkServicingNotificationChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(LoanBulkServicingNotificationChoice _loanBulkServicingNotificationChoice, int idx) {
			getIndex(this.loanBulkServicingNotificationChoice, idx, () -> _loanBulkServicingNotificationChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationChoice(List<? extends LoanBulkServicingNotificationChoice> loanBulkServicingNotificationChoices) {
			if (loanBulkServicingNotificationChoices != null) {
				for (final LoanBulkServicingNotificationChoice toAdd : loanBulkServicingNotificationChoices) {
					this.loanBulkServicingNotificationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationChoice")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationChoice(List<? extends LoanBulkServicingNotificationChoice> loanBulkServicingNotificationChoices) {
			if (loanBulkServicingNotificationChoices == null) {
				this.loanBulkServicingNotificationChoice = new ArrayList<>();
			} else {
				this.loanBulkServicingNotificationChoice = loanBulkServicingNotificationChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequence")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(LoanBulkServicingNotificationSequence _loanBulkServicingNotificationSequence) {
			if (_loanBulkServicingNotificationSequence != null) {
				this.loanBulkServicingNotificationSequence.add(_loanBulkServicingNotificationSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(LoanBulkServicingNotificationSequence _loanBulkServicingNotificationSequence, int idx) {
			getIndex(this.loanBulkServicingNotificationSequence, idx, () -> _loanBulkServicingNotificationSequence.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addLoanBulkServicingNotificationSequence(List<? extends LoanBulkServicingNotificationSequence> loanBulkServicingNotificationSequences) {
			if (loanBulkServicingNotificationSequences != null) {
				for (final LoanBulkServicingNotificationSequence toAdd : loanBulkServicingNotificationSequences) {
					this.loanBulkServicingNotificationSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequence")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setLoanBulkServicingNotificationSequence(List<? extends LoanBulkServicingNotificationSequence> loanBulkServicingNotificationSequences) {
			if (loanBulkServicingNotificationSequences == null) {
				this.loanBulkServicingNotificationSequence = new ArrayList<>();
			} else {
				this.loanBulkServicingNotificationSequence = loanBulkServicingNotificationSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotification build() {
			return new LoanBulkServicingNotification.LoanBulkServicingNotificationImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder prune() {
			super.prune();
			loanBulkServicingNotificationChoice = loanBulkServicingNotificationChoice.stream().filter(b->b!=null).<LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanBulkServicingNotificationSequence = loanBulkServicingNotificationSequence.stream().filter(b->b!=null).<LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanBulkServicingNotificationChoice()!=null && getLoanBulkServicingNotificationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanBulkServicingNotificationSequence()!=null && getLoanBulkServicingNotificationSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder o = (LoanBulkServicingNotification.LoanBulkServicingNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanBulkServicingNotificationChoice(), o.getLoanBulkServicingNotificationChoice(), this::getOrCreateLoanBulkServicingNotificationChoice);
			merger.mergeRosetta(getLoanBulkServicingNotificationSequence(), o.getLoanBulkServicingNotificationSequence(), this::getOrCreateLoanBulkServicingNotificationSequence);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanBulkServicingNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanBulkServicingNotificationChoice, _that.getLoanBulkServicingNotificationChoice())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationSequence, _that.getLoanBulkServicingNotificationSequence())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanBulkServicingNotificationChoice != null ? loanBulkServicingNotificationChoice.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationSequence != null ? loanBulkServicingNotificationSequence.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationBuilder {" +
				"loanBulkServicingNotificationChoice=" + this.loanBulkServicingNotificationChoice + ", " +
				"loanBulkServicingNotificationSequence=" + this.loanBulkServicingNotificationSequence + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
