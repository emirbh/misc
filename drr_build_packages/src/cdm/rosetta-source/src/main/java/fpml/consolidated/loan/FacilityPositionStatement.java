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
import fpml.consolidated.loan.meta.FacilityPositionStatementMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * Provision A statement containing the commitment amounts for a single facility at the global and (optionally) the lender postion levels, on a specific date.
 *
 */
@RosettaDataType(value="FacilityPositionStatement", builder=FacilityPositionStatement.FacilityPositionStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityPositionStatement", model="fpml", builder=FacilityPositionStatement.FacilityPositionStatementBuilderImpl.class, version="2.1.1")
public interface FacilityPositionStatement extends AbstractLoanStatement {

	FacilityPositionStatementMeta metaData = new FacilityPositionStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Commitment position details for a single facility. Positions can be stated at the global and (optionally) at the lender-specific level.
	 *
	 */
	FacilityPosition getFacilityPosition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party for whom positions are being reported (if applicable position amounts are populated).
	 *
	 */
	PartyReference getPositionPartyReference();
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
	 * Provision A facility identifier structure.
	 *
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility summary structure.
	 *
	 */
	FacilitySummary getFacilitySummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FacilityPositionStatementChoice> getFacilityPositionStatementChoice();
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
	FacilityPositionStatement build();
	
	FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder();
	
	static FacilityPositionStatement.FacilityPositionStatementBuilder builder() {
		return new FacilityPositionStatement.FacilityPositionStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityPositionStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityPositionStatement> getType() {
		return FacilityPositionStatement.class;
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
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.class, getPositionPartyReference());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("facilityPositionStatementChoice"), processor, FacilityPositionStatementChoice.class, getFacilityPositionStatementChoice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityPositionStatementBuilder extends FacilityPositionStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition();
		@Override
		FacilityPosition.FacilityPositionBuilder getFacilityPosition();
		PartyReference.PartyReferenceBuilder getOrCreatePositionPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPositionPartyReference();
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		@Override
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder getOrCreateFacilityPositionStatementChoice(int index);
		@Override
		List<? extends FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder> getFacilityPositionStatementChoice();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(Validation validation);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(Validation validation, int idx);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setStatementDate(ZonedDateTime statementDate);
		@Override
		FacilityPositionStatement.FacilityPositionStatementBuilder setComments(String comments);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPosition(FacilityPosition facilityPosition);
		FacilityPositionStatement.FacilityPositionStatementBuilder setPositionPartyReference(PartyReference positionPartyReference);
		FacilityPositionStatement.FacilityPositionStatementBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		FacilityPositionStatement.FacilityPositionStatementBuilder setDealSummary(DealSummary dealSummary);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilitySummary(FacilitySummary facilitySummary);
		FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(FacilityPositionStatementChoice facilityPositionStatementChoice);
		FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(FacilityPositionStatementChoice facilityPositionStatementChoice, int idx);
		FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(List<? extends FacilityPositionStatementChoice> facilityPositionStatementChoice);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPositionStatementChoice(List<? extends FacilityPositionStatementChoice> facilityPositionStatementChoice);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party, int idx);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(List<? extends Party> party);
		FacilityPositionStatement.FacilityPositionStatementBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPositionPartyReference());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("facilityPositionStatementChoice"), processor, FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder.class, getFacilityPositionStatementChoice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityPositionStatement.FacilityPositionStatementBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityPositionStatement  ***********************/
	class FacilityPositionStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements FacilityPositionStatement {
		private final FacilityPosition facilityPosition;
		private final PartyReference positionPartyReference;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends FacilityPositionStatementChoice> facilityPositionStatementChoice;
		private final List<? extends Party> party;
		
		protected FacilityPositionStatementImpl(FacilityPositionStatement.FacilityPositionStatementBuilder builder) {
			super(builder);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).map(f->f.build()).orElse(null);
			this.positionPartyReference = ofNullable(builder.getPositionPartyReference()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.facilityPositionStatementChoice = ofNullable(builder.getFacilityPositionStatementChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityPosition")
		public FacilityPosition getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		@RosettaAttribute("positionPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("positionPartyReference")
		public PartyReference getPositionPartyReference() {
			return positionPartyReference;
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
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		@RosettaAttribute("facilityPositionStatementChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityPositionStatementChoice")
		public List<? extends FacilityPositionStatementChoice> getFacilityPositionStatementChoice() {
			return facilityPositionStatementChoice;
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
		public FacilityPositionStatement build() {
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder() {
			FacilityPositionStatement.FacilityPositionStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityPositionStatement.FacilityPositionStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
			ofNullable(getPositionPartyReference()).ifPresent(builder::setPositionPartyReference);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getFacilityPositionStatementChoice()).ifPresent(builder::setFacilityPositionStatementChoice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(facilityPositionStatementChoice, _that.getFacilityPositionStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityPositionStatementChoice != null ? facilityPositionStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionStatement {" +
				"facilityPosition=" + this.facilityPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityPositionStatementChoice=" + this.facilityPositionStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityPositionStatement  ***********************/
	class FacilityPositionStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl implements FacilityPositionStatement.FacilityPositionStatementBuilder {
	
		protected FacilityPosition.FacilityPositionBuilder facilityPosition;
		protected PartyReference.PartyReferenceBuilder positionPartyReference;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder> facilityPositionStatementChoice = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityPosition")
		public FacilityPosition.FacilityPositionBuilder getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition() {
			FacilityPosition.FacilityPositionBuilder result;
			if (facilityPosition!=null) {
				result = facilityPosition;
			}
			else {
				result = facilityPosition = FacilityPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("positionPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("positionPartyReference")
		public PartyReference.PartyReferenceBuilder getPositionPartyReference() {
			return positionPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePositionPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (positionPartyReference!=null) {
				result = positionPartyReference;
			}
			else {
				result = positionPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary.FacilitySummaryBuilder getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary() {
			FacilitySummary.FacilitySummaryBuilder result;
			if (facilitySummary!=null) {
				result = facilitySummary;
			}
			else {
				result = facilitySummary = FacilitySummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityPositionStatementChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityPositionStatementChoice")
		public List<? extends FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder> getFacilityPositionStatementChoice() {
			return facilityPositionStatementChoice;
		}
		
		@Override
		public FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder getOrCreateFacilityPositionStatementChoice(int index) {
			if (facilityPositionStatementChoice==null) {
				this.facilityPositionStatementChoice = new ArrayList<>();
			}
			return getIndex(facilityPositionStatementChoice, index, () -> {
						FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder newFacilityPositionStatementChoice = FacilityPositionStatementChoice.builder();
						return newFacilityPositionStatementChoice;
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setStatementDate(ZonedDateTime _statementDate) {
			this.statementDate = _statementDate == null ? null : _statementDate;
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityPosition")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPosition(FacilityPosition _facilityPosition) {
			this.facilityPosition = _facilityPosition == null ? null : _facilityPosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("positionPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("positionPartyReference")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setPositionPartyReference(PartyReference _positionPartyReference) {
			this.positionPartyReference = _positionPartyReference == null ? null : _positionPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityPositionStatementChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityPositionStatementChoice")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(FacilityPositionStatementChoice _facilityPositionStatementChoice) {
			if (_facilityPositionStatementChoice != null) {
				this.facilityPositionStatementChoice.add(_facilityPositionStatementChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(FacilityPositionStatementChoice _facilityPositionStatementChoice, int idx) {
			getIndex(this.facilityPositionStatementChoice, idx, () -> _facilityPositionStatementChoice.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addFacilityPositionStatementChoice(List<? extends FacilityPositionStatementChoice> facilityPositionStatementChoices) {
			if (facilityPositionStatementChoices != null) {
				for (final FacilityPositionStatementChoice toAdd : facilityPositionStatementChoices) {
					this.facilityPositionStatementChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityPositionStatementChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityPositionStatementChoice")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPositionStatementChoice(List<? extends FacilityPositionStatementChoice> facilityPositionStatementChoices) {
			if (facilityPositionStatementChoices == null) {
				this.facilityPositionStatementChoice = new ArrayList<>();
			} else {
				this.facilityPositionStatementChoice = facilityPositionStatementChoices.stream()
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(List<? extends Party> partys) {
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setParty(List<? extends Party> partys) {
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
		public FacilityPositionStatement build() {
			return new FacilityPositionStatement.FacilityPositionStatementImpl(this);
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder prune() {
			super.prune();
			if (facilityPosition!=null && !facilityPosition.prune().hasData()) facilityPosition = null;
			if (positionPartyReference!=null && !positionPartyReference.prune().hasData()) positionPartyReference = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			facilityPositionStatementChoice = facilityPositionStatementChoice.stream().filter(b->b!=null).<FacilityPositionStatementChoice.FacilityPositionStatementChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().hasData()) return true;
			if (getPositionPartyReference()!=null && getPositionPartyReference().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getFacilityPositionStatementChoice()!=null && getFacilityPositionStatementChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FacilityPositionStatement.FacilityPositionStatementBuilder o = (FacilityPositionStatement.FacilityPositionStatementBuilder) other;
			
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::setFacilityPosition);
			merger.mergeRosetta(getPositionPartyReference(), o.getPositionPartyReference(), this::setPositionPartyReference);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getFacilityPositionStatementChoice(), o.getFacilityPositionStatementChoice(), this::getOrCreateFacilityPositionStatementChoice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(facilityPositionStatementChoice, _that.getFacilityPositionStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityPositionStatementChoice != null ? facilityPositionStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionStatementBuilder {" +
				"facilityPosition=" + this.facilityPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityPositionStatementChoice=" + this.facilityPositionStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
