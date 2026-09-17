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
import fpml.consolidated.loan.meta.LoanLegalActionStatementMeta;
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
 * Provision A loan legal action statement structure.
 *
 */
@RosettaDataType(value="LoanLegalActionStatement", builder=LoanLegalActionStatement.LoanLegalActionStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatement", model="fpml", builder=LoanLegalActionStatement.LoanLegalActionStatementBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatement extends AbstractLoanStatement {

	LoanLegalActionStatementMeta metaData = new LoanLegalActionStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A complete legal action structure.
	 *
	 */
	LoanLegalAction getLegalAction();
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
	 * Provision A complete deal structure.
	 *
	 */
	Deal getDeal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionStatementChoice0> getLoanLegalActionStatementChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionStatementChoice1> getLoanLegalActionStatementChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionStatementChoice2> getLoanLegalActionStatementChoice2();
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
	LoanLegalActionStatement build();
	
	LoanLegalActionStatement.LoanLegalActionStatementBuilder toBuilder();
	
	static LoanLegalActionStatement.LoanLegalActionStatementBuilder builder() {
		return new LoanLegalActionStatement.LoanLegalActionStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatement> getType() {
		return LoanLegalActionStatement.class;
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
		processRosetta(path.newSubPath("legalAction"), processor, LoanLegalAction.class, getLegalAction());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("deal"), processor, Deal.class, getDeal());
		processRosetta(path.newSubPath("loanLegalActionStatementChoice0"), processor, LoanLegalActionStatementChoice0.class, getLoanLegalActionStatementChoice0());
		processRosetta(path.newSubPath("loanLegalActionStatementChoice1"), processor, LoanLegalActionStatementChoice1.class, getLoanLegalActionStatementChoice1());
		processRosetta(path.newSubPath("loanLegalActionStatementChoice2"), processor, LoanLegalActionStatementChoice2.class, getLoanLegalActionStatementChoice2());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatementBuilder extends LoanLegalActionStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		LoanLegalAction.LoanLegalActionBuilder getOrCreateLegalAction();
		@Override
		LoanLegalAction.LoanLegalActionBuilder getLegalAction();
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		Deal.DealBuilder getOrCreateDeal();
		@Override
		Deal.DealBuilder getDeal();
		LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder getOrCreateLoanLegalActionStatementChoice0(int index);
		@Override
		List<? extends LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder> getLoanLegalActionStatementChoice0();
		LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder getOrCreateLoanLegalActionStatementChoice1(int index);
		@Override
		List<? extends LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder> getLoanLegalActionStatementChoice1();
		LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder getOrCreateLoanLegalActionStatementChoice2(int index);
		@Override
		List<? extends LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder> getLoanLegalActionStatementChoice2();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(Validation validation);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(Validation validation, int idx);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setStatementDate(ZonedDateTime statementDate);
		@Override
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setComments(String comments);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setLegalAction(LoanLegalAction legalAction);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setDealSummary(DealSummary dealSummary);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setDeal(Deal deal);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(LoanLegalActionStatementChoice0 loanLegalActionStatementChoice0);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(LoanLegalActionStatementChoice0 loanLegalActionStatementChoice0, int idx);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(List<? extends LoanLegalActionStatementChoice0> loanLegalActionStatementChoice0);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice0(List<? extends LoanLegalActionStatementChoice0> loanLegalActionStatementChoice0);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1, int idx);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(List<? extends LoanLegalActionStatementChoice1> loanLegalActionStatementChoice1);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice1(List<? extends LoanLegalActionStatementChoice1> loanLegalActionStatementChoice1);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(LoanLegalActionStatementChoice2 loanLegalActionStatementChoice2);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(LoanLegalActionStatementChoice2 loanLegalActionStatementChoice2, int idx);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(List<? extends LoanLegalActionStatementChoice2> loanLegalActionStatementChoice2);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice2(List<? extends LoanLegalActionStatementChoice2> loanLegalActionStatementChoice2);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(Party party);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(Party party, int idx);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(List<? extends Party> party);
		LoanLegalActionStatement.LoanLegalActionStatementBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("legalAction"), processor, LoanLegalAction.LoanLegalActionBuilder.class, getLegalAction());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("deal"), processor, Deal.DealBuilder.class, getDeal());
			processRosetta(path.newSubPath("loanLegalActionStatementChoice0"), processor, LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder.class, getLoanLegalActionStatementChoice0());
			processRosetta(path.newSubPath("loanLegalActionStatementChoice1"), processor, LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder.class, getLoanLegalActionStatementChoice1());
			processRosetta(path.newSubPath("loanLegalActionStatementChoice2"), processor, LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder.class, getLoanLegalActionStatementChoice2());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanLegalActionStatement.LoanLegalActionStatementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatement  ***********************/
	class LoanLegalActionStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements LoanLegalActionStatement {
		private final LoanLegalAction legalAction;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final Deal deal;
		private final List<? extends LoanLegalActionStatementChoice0> loanLegalActionStatementChoice0;
		private final List<? extends LoanLegalActionStatementChoice1> loanLegalActionStatementChoice1;
		private final List<? extends LoanLegalActionStatementChoice2> loanLegalActionStatementChoice2;
		private final List<? extends Party> party;
		
		protected LoanLegalActionStatementImpl(LoanLegalActionStatement.LoanLegalActionStatementBuilder builder) {
			super(builder);
			this.legalAction = ofNullable(builder.getLegalAction()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.deal = ofNullable(builder.getDeal()).map(f->f.build()).orElse(null);
			this.loanLegalActionStatementChoice0 = ofNullable(builder.getLoanLegalActionStatementChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalActionStatementChoice1 = ofNullable(builder.getLoanLegalActionStatementChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalActionStatementChoice2 = ofNullable(builder.getLoanLegalActionStatementChoice2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalAction")
		public LoanLegalAction getLegalAction() {
			return legalAction;
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
		@RosettaAttribute("deal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deal")
		public Deal getDeal() {
			return deal;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice0")
		public List<? extends LoanLegalActionStatementChoice0> getLoanLegalActionStatementChoice0() {
			return loanLegalActionStatementChoice0;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice1")
		public List<? extends LoanLegalActionStatementChoice1> getLoanLegalActionStatementChoice1() {
			return loanLegalActionStatementChoice1;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice2")
		public List<? extends LoanLegalActionStatementChoice2> getLoanLegalActionStatementChoice2() {
			return loanLegalActionStatementChoice2;
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
		public LoanLegalActionStatement build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder toBuilder() {
			LoanLegalActionStatement.LoanLegalActionStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatement.LoanLegalActionStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLegalAction()).ifPresent(builder::setLegalAction);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getDeal()).ifPresent(builder::setDeal);
			ofNullable(getLoanLegalActionStatementChoice0()).ifPresent(builder::setLoanLegalActionStatementChoice0);
			ofNullable(getLoanLegalActionStatementChoice1()).ifPresent(builder::setLoanLegalActionStatementChoice1);
			ofNullable(getLoanLegalActionStatementChoice2()).ifPresent(builder::setLoanLegalActionStatementChoice2);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionStatement _that = getType().cast(o);
		
			if (!Objects.equals(legalAction, _that.getLegalAction())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice0, _that.getLoanLegalActionStatementChoice0())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice1, _that.getLoanLegalActionStatementChoice1())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice2, _that.getLoanLegalActionStatementChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legalAction != null ? legalAction.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice0 != null ? loanLegalActionStatementChoice0.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice1 != null ? loanLegalActionStatementChoice1.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice2 != null ? loanLegalActionStatementChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatement {" +
				"legalAction=" + this.legalAction + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"deal=" + this.deal + ", " +
				"loanLegalActionStatementChoice0=" + this.loanLegalActionStatementChoice0 + ", " +
				"loanLegalActionStatementChoice1=" + this.loanLegalActionStatementChoice1 + ", " +
				"loanLegalActionStatementChoice2=" + this.loanLegalActionStatementChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatement  ***********************/
	class LoanLegalActionStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl implements LoanLegalActionStatement.LoanLegalActionStatementBuilder {
	
		protected LoanLegalAction.LoanLegalActionBuilder legalAction;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected Deal.DealBuilder deal;
		protected List<LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder> loanLegalActionStatementChoice0 = new ArrayList<>();
		protected List<LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder> loanLegalActionStatementChoice1 = new ArrayList<>();
		protected List<LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder> loanLegalActionStatementChoice2 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalAction")
		public LoanLegalAction.LoanLegalActionBuilder getLegalAction() {
			return legalAction;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder getOrCreateLegalAction() {
			LoanLegalAction.LoanLegalActionBuilder result;
			if (legalAction!=null) {
				result = legalAction;
			}
			else {
				result = legalAction = LoanLegalAction.builder();
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
		@RosettaAttribute("deal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deal")
		public Deal.DealBuilder getDeal() {
			return deal;
		}
		
		@Override
		public Deal.DealBuilder getOrCreateDeal() {
			Deal.DealBuilder result;
			if (deal!=null) {
				result = deal;
			}
			else {
				result = deal = Deal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice0")
		public List<? extends LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder> getLoanLegalActionStatementChoice0() {
			return loanLegalActionStatementChoice0;
		}
		
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder getOrCreateLoanLegalActionStatementChoice0(int index) {
			if (loanLegalActionStatementChoice0==null) {
				this.loanLegalActionStatementChoice0 = new ArrayList<>();
			}
			return getIndex(loanLegalActionStatementChoice0, index, () -> {
						LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder newLoanLegalActionStatementChoice0 = LoanLegalActionStatementChoice0.builder();
						return newLoanLegalActionStatementChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice1")
		public List<? extends LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder> getLoanLegalActionStatementChoice1() {
			return loanLegalActionStatementChoice1;
		}
		
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder getOrCreateLoanLegalActionStatementChoice1(int index) {
			if (loanLegalActionStatementChoice1==null) {
				this.loanLegalActionStatementChoice1 = new ArrayList<>();
			}
			return getIndex(loanLegalActionStatementChoice1, index, () -> {
						LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder newLoanLegalActionStatementChoice1 = LoanLegalActionStatementChoice1.builder();
						return newLoanLegalActionStatementChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatementChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice2")
		public List<? extends LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder> getLoanLegalActionStatementChoice2() {
			return loanLegalActionStatementChoice2;
		}
		
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder getOrCreateLoanLegalActionStatementChoice2(int index) {
			if (loanLegalActionStatementChoice2==null) {
				this.loanLegalActionStatementChoice2 = new ArrayList<>();
			}
			return getIndex(loanLegalActionStatementChoice2, index, () -> {
						LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder newLoanLegalActionStatementChoice2 = LoanLegalActionStatementChoice2.builder();
						return newLoanLegalActionStatementChoice2;
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setStatementDate(ZonedDateTime _statementDate) {
			this.statementDate = _statementDate == null ? null : _statementDate;
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalAction")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setLegalAction(LoanLegalAction _legalAction) {
			this.legalAction = _legalAction == null ? null : _legalAction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deal")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setDeal(Deal _deal) {
			this.deal = _deal == null ? null : _deal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice0")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(LoanLegalActionStatementChoice0 _loanLegalActionStatementChoice0) {
			if (_loanLegalActionStatementChoice0 != null) {
				this.loanLegalActionStatementChoice0.add(_loanLegalActionStatementChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(LoanLegalActionStatementChoice0 _loanLegalActionStatementChoice0, int idx) {
			getIndex(this.loanLegalActionStatementChoice0, idx, () -> _loanLegalActionStatementChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice0(List<? extends LoanLegalActionStatementChoice0> loanLegalActionStatementChoice0s) {
			if (loanLegalActionStatementChoice0s != null) {
				for (final LoanLegalActionStatementChoice0 toAdd : loanLegalActionStatementChoice0s) {
					this.loanLegalActionStatementChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice0")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice0(List<? extends LoanLegalActionStatementChoice0> loanLegalActionStatementChoice0s) {
			if (loanLegalActionStatementChoice0s == null) {
				this.loanLegalActionStatementChoice0 = new ArrayList<>();
			} else {
				this.loanLegalActionStatementChoice0 = loanLegalActionStatementChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice1")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(LoanLegalActionStatementChoice1 _loanLegalActionStatementChoice1) {
			if (_loanLegalActionStatementChoice1 != null) {
				this.loanLegalActionStatementChoice1.add(_loanLegalActionStatementChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(LoanLegalActionStatementChoice1 _loanLegalActionStatementChoice1, int idx) {
			getIndex(this.loanLegalActionStatementChoice1, idx, () -> _loanLegalActionStatementChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice1(List<? extends LoanLegalActionStatementChoice1> loanLegalActionStatementChoice1s) {
			if (loanLegalActionStatementChoice1s != null) {
				for (final LoanLegalActionStatementChoice1 toAdd : loanLegalActionStatementChoice1s) {
					this.loanLegalActionStatementChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice1")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice1(List<? extends LoanLegalActionStatementChoice1> loanLegalActionStatementChoice1s) {
			if (loanLegalActionStatementChoice1s == null) {
				this.loanLegalActionStatementChoice1 = new ArrayList<>();
			} else {
				this.loanLegalActionStatementChoice1 = loanLegalActionStatementChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice2")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(LoanLegalActionStatementChoice2 _loanLegalActionStatementChoice2) {
			if (_loanLegalActionStatementChoice2 != null) {
				this.loanLegalActionStatementChoice2.add(_loanLegalActionStatementChoice2.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(LoanLegalActionStatementChoice2 _loanLegalActionStatementChoice2, int idx) {
			getIndex(this.loanLegalActionStatementChoice2, idx, () -> _loanLegalActionStatementChoice2.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addLoanLegalActionStatementChoice2(List<? extends LoanLegalActionStatementChoice2> loanLegalActionStatementChoice2s) {
			if (loanLegalActionStatementChoice2s != null) {
				for (final LoanLegalActionStatementChoice2 toAdd : loanLegalActionStatementChoice2s) {
					this.loanLegalActionStatementChoice2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatementChoice2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionStatementChoice2")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setLoanLegalActionStatementChoice2(List<? extends LoanLegalActionStatementChoice2> loanLegalActionStatementChoice2s) {
			if (loanLegalActionStatementChoice2s == null) {
				this.loanLegalActionStatementChoice2 = new ArrayList<>();
			} else {
				this.loanLegalActionStatementChoice2 = loanLegalActionStatementChoice2s.stream()
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder addParty(List<? extends Party> partys) {
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
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder setParty(List<? extends Party> partys) {
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
		public LoanLegalActionStatement build() {
			return new LoanLegalActionStatement.LoanLegalActionStatementImpl(this);
		}
		
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder prune() {
			super.prune();
			if (legalAction!=null && !legalAction.prune().hasData()) legalAction = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (deal!=null && !deal.prune().hasData()) deal = null;
			loanLegalActionStatementChoice0 = loanLegalActionStatementChoice0.stream().filter(b->b!=null).<LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalActionStatementChoice1 = loanLegalActionStatementChoice1.stream().filter(b->b!=null).<LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalActionStatementChoice2 = loanLegalActionStatementChoice2.stream().filter(b->b!=null).<LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLegalAction()!=null && getLegalAction().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getDeal()!=null && getDeal().hasData()) return true;
			if (getLoanLegalActionStatementChoice0()!=null && getLoanLegalActionStatementChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalActionStatementChoice1()!=null && getLoanLegalActionStatementChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalActionStatementChoice2()!=null && getLoanLegalActionStatementChoice2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatement.LoanLegalActionStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionStatement.LoanLegalActionStatementBuilder o = (LoanLegalActionStatement.LoanLegalActionStatementBuilder) other;
			
			merger.mergeRosetta(getLegalAction(), o.getLegalAction(), this::setLegalAction);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getDeal(), o.getDeal(), this::setDeal);
			merger.mergeRosetta(getLoanLegalActionStatementChoice0(), o.getLoanLegalActionStatementChoice0(), this::getOrCreateLoanLegalActionStatementChoice0);
			merger.mergeRosetta(getLoanLegalActionStatementChoice1(), o.getLoanLegalActionStatementChoice1(), this::getOrCreateLoanLegalActionStatementChoice1);
			merger.mergeRosetta(getLoanLegalActionStatementChoice2(), o.getLoanLegalActionStatementChoice2(), this::getOrCreateLoanLegalActionStatementChoice2);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionStatement _that = getType().cast(o);
		
			if (!Objects.equals(legalAction, _that.getLegalAction())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice0, _that.getLoanLegalActionStatementChoice0())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice1, _that.getLoanLegalActionStatementChoice1())) return false;
			if (!ListEquals.listEquals(loanLegalActionStatementChoice2, _that.getLoanLegalActionStatementChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legalAction != null ? legalAction.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice0 != null ? loanLegalActionStatementChoice0.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice1 != null ? loanLegalActionStatementChoice1.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatementChoice2 != null ? loanLegalActionStatementChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatementBuilder {" +
				"legalAction=" + this.legalAction + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"deal=" + this.deal + ", " +
				"loanLegalActionStatementChoice0=" + this.loanLegalActionStatementChoice0 + ", " +
				"loanLegalActionStatementChoice1=" + this.loanLegalActionStatementChoice1 + ", " +
				"loanLegalActionStatementChoice2=" + this.loanLegalActionStatementChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
