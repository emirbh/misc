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
import fpml.consolidated.loan.meta.OutstandingContractsStatementMeta;
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
 * Provision A collection of outstanding loan contract and/or letter of credit structures belonging to a single facility.
 *
 */
@RosettaDataType(value="OutstandingContractsStatement", builder=OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OutstandingContractsStatement", model="fpml", builder=OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl.class, version="2.1.1")
public interface OutstandingContractsStatement extends AbstractLoanStatement {

	OutstandingContractsStatementMeta metaData = new OutstandingContractsStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal identifier structure.
	 *
	 */
	DealIdentifier getDealIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal summary structure.
	 *
	 */
	DealSummary getDealSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The facility to which the loan contracts and/or letter of credits belong.
	 *
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends OutstandingContractsStatementChoice> getOutstandingContractsStatementChoice();
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
	OutstandingContractsStatement build();
	
	OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder();
	
	static OutstandingContractsStatement.OutstandingContractsStatementBuilder builder() {
		return new OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OutstandingContractsStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OutstandingContractsStatement> getType() {
		return OutstandingContractsStatement.class;
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
		processor.processBasic(path.newSubPath("statementDate"), ZonedDateTime.class, getStatementDate(), this);
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("outstandingContractsStatementChoice"), processor, OutstandingContractsStatementChoice.class, getOutstandingContractsStatementChoice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OutstandingContractsStatementBuilder extends OutstandingContractsStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder getOrCreateOutstandingContractsStatementChoice(int index);
		@Override
		List<? extends OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> getOutstandingContractsStatementChoice();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(Validation validation);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(Validation validation, int idx);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setStatementDate(ZonedDateTime statementDate);
		@Override
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setComments(String comments);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setDealSummary(DealSummary dealSummary);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice, int idx);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party, int idx);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(List<? extends Party> party);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setParty(List<? extends Party> party);

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
			processor.processBasic(path.newSubPath("statementDate"), ZonedDateTime.class, getStatementDate(), this);
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("outstandingContractsStatementChoice"), processor, OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder.class, getOutstandingContractsStatementChoice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		OutstandingContractsStatement.OutstandingContractsStatementBuilder prune();
	}

	/*********************** Immutable Implementation of OutstandingContractsStatement  ***********************/
	class OutstandingContractsStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements OutstandingContractsStatement {
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice;
		private final List<? extends Party> party;
		
		protected OutstandingContractsStatementImpl(OutstandingContractsStatement.OutstandingContractsStatementBuilder builder) {
			super(builder);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.outstandingContractsStatementChoice = ofNullable(builder.getOutstandingContractsStatementChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary getDealSummary() {
			return dealSummary;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("outstandingContractsStatementChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("outstandingContractsStatementChoice")
		public List<? extends OutstandingContractsStatementChoice> getOutstandingContractsStatementChoice() {
			return outstandingContractsStatementChoice;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public OutstandingContractsStatement build() {
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder() {
			OutstandingContractsStatement.OutstandingContractsStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OutstandingContractsStatement.OutstandingContractsStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getOutstandingContractsStatementChoice()).ifPresent(builder::setOutstandingContractsStatementChoice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OutstandingContractsStatement _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(outstandingContractsStatementChoice, _that.getOutstandingContractsStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (outstandingContractsStatementChoice != null ? outstandingContractsStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatement {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"outstandingContractsStatementChoice=" + this.outstandingContractsStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OutstandingContractsStatement  ***********************/
	class OutstandingContractsStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl implements OutstandingContractsStatement.OutstandingContractsStatementBuilder {
	
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected List<OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> outstandingContractsStatementChoice = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier.DealIdentifierBuilder getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier() {
			DealIdentifier.DealIdentifierBuilder result;
			if (dealIdentifier!=null) {
				result = dealIdentifier;
			}
			else {
				result = dealIdentifier = DealIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary.DealSummaryBuilder getDealSummary() {
			return dealSummary;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder getOrCreateDealSummary() {
			DealSummary.DealSummaryBuilder result;
			if (dealSummary!=null) {
				result = dealSummary;
			}
			else {
				result = dealSummary = DealSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingContractsStatementChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("outstandingContractsStatementChoice")
		public List<? extends OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> getOutstandingContractsStatementChoice() {
			return outstandingContractsStatementChoice;
		}
		
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder getOrCreateOutstandingContractsStatementChoice(int index) {
			if (outstandingContractsStatementChoice==null) {
				this.outstandingContractsStatementChoice = new ArrayList<>();
			}
			return getIndex(outstandingContractsStatementChoice, index, () -> {
						OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder newOutstandingContractsStatementChoice = OutstandingContractsStatementChoice.builder();
						return newOutstandingContractsStatementChoice;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("statementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("statementDate")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setStatementDate(ZonedDateTime _statementDate) {
			this.statementDate = _statementDate == null ? null : _statementDate;
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityIdentifier")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingContractsStatementChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("outstandingContractsStatementChoice")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice _outstandingContractsStatementChoice) {
			if (_outstandingContractsStatementChoice != null) {
				this.outstandingContractsStatementChoice.add(_outstandingContractsStatementChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice _outstandingContractsStatementChoice, int idx) {
			getIndex(this.outstandingContractsStatementChoice, idx, () -> _outstandingContractsStatementChoice.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoices) {
			if (outstandingContractsStatementChoices != null) {
				for (final OutstandingContractsStatementChoice toAdd : outstandingContractsStatementChoices) {
					this.outstandingContractsStatementChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("outstandingContractsStatementChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("outstandingContractsStatementChoice")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoices) {
			if (outstandingContractsStatementChoices == null) {
				this.outstandingContractsStatementChoice = new ArrayList<>();
			} else {
				this.outstandingContractsStatementChoice = outstandingContractsStatementChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setParty(List<? extends Party> partys) {
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
		public OutstandingContractsStatement build() {
			return new OutstandingContractsStatement.OutstandingContractsStatementImpl(this);
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder prune() {
			super.prune();
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			outstandingContractsStatementChoice = outstandingContractsStatementChoice.stream().filter(b->b!=null).<OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getOutstandingContractsStatementChoice()!=null && getOutstandingContractsStatementChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OutstandingContractsStatement.OutstandingContractsStatementBuilder o = (OutstandingContractsStatement.OutstandingContractsStatementBuilder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getOutstandingContractsStatementChoice(), o.getOutstandingContractsStatementChoice(), this::getOrCreateOutstandingContractsStatementChoice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OutstandingContractsStatement _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(outstandingContractsStatementChoice, _that.getOutstandingContractsStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (outstandingContractsStatementChoice != null ? outstandingContractsStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatementBuilder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"outstandingContractsStatementChoice=" + this.outstandingContractsStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
