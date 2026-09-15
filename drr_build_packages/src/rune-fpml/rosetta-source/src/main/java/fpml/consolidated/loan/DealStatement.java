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
import fpml.consolidated.loan.meta.DealStatementMeta;
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
 * Provision A full set of deal and facility definitions valid as of a specific date.
 *
 */
@RosettaDataType(value="DealStatement", builder=DealStatement.DealStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DealStatement", model="fpml", builder=DealStatement.DealStatementBuilderImpl.class, version="2.1.1")
public interface DealStatement extends AbstractLoanStatement {

	DealStatementMeta metaData = new DealStatementMeta();

	/*********************** Getter Methods  ***********************/
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
	List<? extends DealStatementChoice0> getDealStatementChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends DealStatementChoice1> getDealStatementChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends DealStatementChoice2> getDealStatementChoice2();
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
	DealStatement build();
	
	DealStatement.DealStatementBuilder toBuilder();
	
	static DealStatement.DealStatementBuilder builder() {
		return new DealStatement.DealStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DealStatement> getType() {
		return DealStatement.class;
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
		processRosetta(path.newSubPath("deal"), processor, Deal.class, getDeal());
		processRosetta(path.newSubPath("dealStatementChoice0"), processor, DealStatementChoice0.class, getDealStatementChoice0());
		processRosetta(path.newSubPath("dealStatementChoice1"), processor, DealStatementChoice1.class, getDealStatementChoice1());
		processRosetta(path.newSubPath("dealStatementChoice2"), processor, DealStatementChoice2.class, getDealStatementChoice2());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealStatementBuilder extends DealStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		Deal.DealBuilder getOrCreateDeal();
		@Override
		Deal.DealBuilder getDeal();
		DealStatementChoice0.DealStatementChoice0Builder getOrCreateDealStatementChoice0(int index);
		@Override
		List<? extends DealStatementChoice0.DealStatementChoice0Builder> getDealStatementChoice0();
		DealStatementChoice1.DealStatementChoice1Builder getOrCreateDealStatementChoice1(int index);
		@Override
		List<? extends DealStatementChoice1.DealStatementChoice1Builder> getDealStatementChoice1();
		DealStatementChoice2.DealStatementChoice2Builder getOrCreateDealStatementChoice2(int index);
		@Override
		List<? extends DealStatementChoice2.DealStatementChoice2Builder> getDealStatementChoice2();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		DealStatement.DealStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		DealStatement.DealStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		DealStatement.DealStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		DealStatement.DealStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		DealStatement.DealStatementBuilder addValidation(Validation validation);
		@Override
		DealStatement.DealStatementBuilder addValidation(Validation validation, int idx);
		@Override
		DealStatement.DealStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		DealStatement.DealStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		DealStatement.DealStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		DealStatement.DealStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		DealStatement.DealStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		DealStatement.DealStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		DealStatement.DealStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		DealStatement.DealStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		DealStatement.DealStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		DealStatement.DealStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		DealStatement.DealStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		DealStatement.DealStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		DealStatement.DealStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		DealStatement.DealStatementBuilder setStatementDate(ZonedDateTime statementDate);
		@Override
		DealStatement.DealStatementBuilder setComments(String comments);
		DealStatement.DealStatementBuilder setDeal(Deal deal);
		DealStatement.DealStatementBuilder addDealStatementChoice0(DealStatementChoice0 dealStatementChoice0);
		DealStatement.DealStatementBuilder addDealStatementChoice0(DealStatementChoice0 dealStatementChoice0, int idx);
		DealStatement.DealStatementBuilder addDealStatementChoice0(List<? extends DealStatementChoice0> dealStatementChoice0);
		DealStatement.DealStatementBuilder setDealStatementChoice0(List<? extends DealStatementChoice0> dealStatementChoice0);
		DealStatement.DealStatementBuilder addDealStatementChoice1(DealStatementChoice1 dealStatementChoice1);
		DealStatement.DealStatementBuilder addDealStatementChoice1(DealStatementChoice1 dealStatementChoice1, int idx);
		DealStatement.DealStatementBuilder addDealStatementChoice1(List<? extends DealStatementChoice1> dealStatementChoice1);
		DealStatement.DealStatementBuilder setDealStatementChoice1(List<? extends DealStatementChoice1> dealStatementChoice1);
		DealStatement.DealStatementBuilder addDealStatementChoice2(DealStatementChoice2 dealStatementChoice2);
		DealStatement.DealStatementBuilder addDealStatementChoice2(DealStatementChoice2 dealStatementChoice2, int idx);
		DealStatement.DealStatementBuilder addDealStatementChoice2(List<? extends DealStatementChoice2> dealStatementChoice2);
		DealStatement.DealStatementBuilder setDealStatementChoice2(List<? extends DealStatementChoice2> dealStatementChoice2);
		DealStatement.DealStatementBuilder addParty(Party party);
		DealStatement.DealStatementBuilder addParty(Party party, int idx);
		DealStatement.DealStatementBuilder addParty(List<? extends Party> party);
		DealStatement.DealStatementBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("deal"), processor, Deal.DealBuilder.class, getDeal());
			processRosetta(path.newSubPath("dealStatementChoice0"), processor, DealStatementChoice0.DealStatementChoice0Builder.class, getDealStatementChoice0());
			processRosetta(path.newSubPath("dealStatementChoice1"), processor, DealStatementChoice1.DealStatementChoice1Builder.class, getDealStatementChoice1());
			processRosetta(path.newSubPath("dealStatementChoice2"), processor, DealStatementChoice2.DealStatementChoice2Builder.class, getDealStatementChoice2());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		DealStatement.DealStatementBuilder prune();
	}

	/*********************** Immutable Implementation of DealStatement  ***********************/
	class DealStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements DealStatement {
		private final Deal deal;
		private final List<? extends DealStatementChoice0> dealStatementChoice0;
		private final List<? extends DealStatementChoice1> dealStatementChoice1;
		private final List<? extends DealStatementChoice2> dealStatementChoice2;
		private final List<? extends Party> party;
		
		protected DealStatementImpl(DealStatement.DealStatementBuilder builder) {
			super(builder);
			this.deal = ofNullable(builder.getDeal()).map(f->f.build()).orElse(null);
			this.dealStatementChoice0 = ofNullable(builder.getDealStatementChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dealStatementChoice1 = ofNullable(builder.getDealStatementChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dealStatementChoice2 = ofNullable(builder.getDealStatementChoice2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deal")
		public Deal getDeal() {
			return deal;
		}
		
		@Override
		@RosettaAttribute("dealStatementChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice0")
		public List<? extends DealStatementChoice0> getDealStatementChoice0() {
			return dealStatementChoice0;
		}
		
		@Override
		@RosettaAttribute("dealStatementChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice1")
		public List<? extends DealStatementChoice1> getDealStatementChoice1() {
			return dealStatementChoice1;
		}
		
		@Override
		@RosettaAttribute("dealStatementChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice2")
		public List<? extends DealStatementChoice2> getDealStatementChoice2() {
			return dealStatementChoice2;
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
		public DealStatement build() {
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder toBuilder() {
			DealStatement.DealStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealStatement.DealStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeal()).ifPresent(builder::setDeal);
			ofNullable(getDealStatementChoice0()).ifPresent(builder::setDealStatementChoice0);
			ofNullable(getDealStatementChoice1()).ifPresent(builder::setDealStatementChoice1);
			ofNullable(getDealStatementChoice2()).ifPresent(builder::setDealStatementChoice2);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealStatement _that = getType().cast(o);
		
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(dealStatementChoice0, _that.getDealStatementChoice0())) return false;
			if (!ListEquals.listEquals(dealStatementChoice1, _that.getDealStatementChoice1())) return false;
			if (!ListEquals.listEquals(dealStatementChoice2, _that.getDealStatementChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice0 != null ? dealStatementChoice0.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice1 != null ? dealStatementChoice1.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice2 != null ? dealStatementChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealStatement {" +
				"deal=" + this.deal + ", " +
				"dealStatementChoice0=" + this.dealStatementChoice0 + ", " +
				"dealStatementChoice1=" + this.dealStatementChoice1 + ", " +
				"dealStatementChoice2=" + this.dealStatementChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealStatement  ***********************/
	class DealStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl implements DealStatement.DealStatementBuilder {
	
		protected Deal.DealBuilder deal;
		protected List<DealStatementChoice0.DealStatementChoice0Builder> dealStatementChoice0 = new ArrayList<>();
		protected List<DealStatementChoice1.DealStatementChoice1Builder> dealStatementChoice1 = new ArrayList<>();
		protected List<DealStatementChoice2.DealStatementChoice2Builder> dealStatementChoice2 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("deal")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("dealStatementChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice0")
		public List<? extends DealStatementChoice0.DealStatementChoice0Builder> getDealStatementChoice0() {
			return dealStatementChoice0;
		}
		
		@Override
		public DealStatementChoice0.DealStatementChoice0Builder getOrCreateDealStatementChoice0(int index) {
			if (dealStatementChoice0==null) {
				this.dealStatementChoice0 = new ArrayList<>();
			}
			return getIndex(dealStatementChoice0, index, () -> {
						DealStatementChoice0.DealStatementChoice0Builder newDealStatementChoice0 = DealStatementChoice0.builder();
						return newDealStatementChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("dealStatementChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice1")
		public List<? extends DealStatementChoice1.DealStatementChoice1Builder> getDealStatementChoice1() {
			return dealStatementChoice1;
		}
		
		@Override
		public DealStatementChoice1.DealStatementChoice1Builder getOrCreateDealStatementChoice1(int index) {
			if (dealStatementChoice1==null) {
				this.dealStatementChoice1 = new ArrayList<>();
			}
			return getIndex(dealStatementChoice1, index, () -> {
						DealStatementChoice1.DealStatementChoice1Builder newDealStatementChoice1 = DealStatementChoice1.builder();
						return newDealStatementChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("dealStatementChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealStatementChoice2")
		public List<? extends DealStatementChoice2.DealStatementChoice2Builder> getDealStatementChoice2() {
			return dealStatementChoice2;
		}
		
		@Override
		public DealStatementChoice2.DealStatementChoice2Builder getOrCreateDealStatementChoice2(int index) {
			if (dealStatementChoice2==null) {
				this.dealStatementChoice2 = new ArrayList<>();
			}
			return getIndex(dealStatementChoice2, index, () -> {
						DealStatementChoice2.DealStatementChoice2Builder newDealStatementChoice2 = DealStatementChoice2.builder();
						return newDealStatementChoice2;
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
		public DealStatement.DealStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public DealStatement.DealStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public DealStatement.DealStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public DealStatement.DealStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public DealStatement.DealStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public DealStatement.DealStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public DealStatement.DealStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public DealStatement.DealStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public DealStatement.DealStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public DealStatement.DealStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public DealStatement.DealStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public DealStatement.DealStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public DealStatement.DealStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public DealStatement.DealStatementBuilder setStatementDate(ZonedDateTime _statementDate) {
			this.statementDate = _statementDate == null ? null : _statementDate;
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public DealStatement.DealStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@RosettaAttribute("deal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deal")
		@Override
		public DealStatement.DealStatementBuilder setDeal(Deal _deal) {
			this.deal = _deal == null ? null : _deal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dealStatementChoice0")
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice0(DealStatementChoice0 _dealStatementChoice0) {
			if (_dealStatementChoice0 != null) {
				this.dealStatementChoice0.add(_dealStatementChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice0(DealStatementChoice0 _dealStatementChoice0, int idx) {
			getIndex(this.dealStatementChoice0, idx, () -> _dealStatementChoice0.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice0(List<? extends DealStatementChoice0> dealStatementChoice0s) {
			if (dealStatementChoice0s != null) {
				for (final DealStatementChoice0 toAdd : dealStatementChoice0s) {
					this.dealStatementChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dealStatementChoice0")
		@Override
		public DealStatement.DealStatementBuilder setDealStatementChoice0(List<? extends DealStatementChoice0> dealStatementChoice0s) {
			if (dealStatementChoice0s == null) {
				this.dealStatementChoice0 = new ArrayList<>();
			} else {
				this.dealStatementChoice0 = dealStatementChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dealStatementChoice1")
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice1(DealStatementChoice1 _dealStatementChoice1) {
			if (_dealStatementChoice1 != null) {
				this.dealStatementChoice1.add(_dealStatementChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice1(DealStatementChoice1 _dealStatementChoice1, int idx) {
			getIndex(this.dealStatementChoice1, idx, () -> _dealStatementChoice1.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice1(List<? extends DealStatementChoice1> dealStatementChoice1s) {
			if (dealStatementChoice1s != null) {
				for (final DealStatementChoice1 toAdd : dealStatementChoice1s) {
					this.dealStatementChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dealStatementChoice1")
		@Override
		public DealStatement.DealStatementBuilder setDealStatementChoice1(List<? extends DealStatementChoice1> dealStatementChoice1s) {
			if (dealStatementChoice1s == null) {
				this.dealStatementChoice1 = new ArrayList<>();
			} else {
				this.dealStatementChoice1 = dealStatementChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dealStatementChoice2")
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice2(DealStatementChoice2 _dealStatementChoice2) {
			if (_dealStatementChoice2 != null) {
				this.dealStatementChoice2.add(_dealStatementChoice2.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice2(DealStatementChoice2 _dealStatementChoice2, int idx) {
			getIndex(this.dealStatementChoice2, idx, () -> _dealStatementChoice2.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addDealStatementChoice2(List<? extends DealStatementChoice2> dealStatementChoice2s) {
			if (dealStatementChoice2s != null) {
				for (final DealStatementChoice2 toAdd : dealStatementChoice2s) {
					this.dealStatementChoice2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealStatementChoice2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dealStatementChoice2")
		@Override
		public DealStatement.DealStatementBuilder setDealStatementChoice2(List<? extends DealStatementChoice2> dealStatementChoice2s) {
			if (dealStatementChoice2s == null) {
				this.dealStatementChoice2 = new ArrayList<>();
			} else {
				this.dealStatementChoice2 = dealStatementChoice2s.stream()
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
		public DealStatement.DealStatementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addParty(List<? extends Party> partys) {
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
		public DealStatement.DealStatementBuilder setParty(List<? extends Party> partys) {
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
		public DealStatement build() {
			return new DealStatement.DealStatementImpl(this);
		}
		
		@Override
		public DealStatement.DealStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealStatement.DealStatementBuilder prune() {
			super.prune();
			if (deal!=null && !deal.prune().hasData()) deal = null;
			dealStatementChoice0 = dealStatementChoice0.stream().filter(b->b!=null).<DealStatementChoice0.DealStatementChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			dealStatementChoice1 = dealStatementChoice1.stream().filter(b->b!=null).<DealStatementChoice1.DealStatementChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			dealStatementChoice2 = dealStatementChoice2.stream().filter(b->b!=null).<DealStatementChoice2.DealStatementChoice2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeal()!=null && getDeal().hasData()) return true;
			if (getDealStatementChoice0()!=null && getDealStatementChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDealStatementChoice1()!=null && getDealStatementChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDealStatementChoice2()!=null && getDealStatementChoice2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealStatement.DealStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DealStatement.DealStatementBuilder o = (DealStatement.DealStatementBuilder) other;
			
			merger.mergeRosetta(getDeal(), o.getDeal(), this::setDeal);
			merger.mergeRosetta(getDealStatementChoice0(), o.getDealStatementChoice0(), this::getOrCreateDealStatementChoice0);
			merger.mergeRosetta(getDealStatementChoice1(), o.getDealStatementChoice1(), this::getOrCreateDealStatementChoice1);
			merger.mergeRosetta(getDealStatementChoice2(), o.getDealStatementChoice2(), this::getOrCreateDealStatementChoice2);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealStatement _that = getType().cast(o);
		
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(dealStatementChoice0, _that.getDealStatementChoice0())) return false;
			if (!ListEquals.listEquals(dealStatementChoice1, _that.getDealStatementChoice1())) return false;
			if (!ListEquals.listEquals(dealStatementChoice2, _that.getDealStatementChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice0 != null ? dealStatementChoice0.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice1 != null ? dealStatementChoice1.hashCode() : 0);
			_result = 31 * _result + (dealStatementChoice2 != null ? dealStatementChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealStatementBuilder {" +
				"deal=" + this.deal + ", " +
				"dealStatementChoice0=" + this.dealStatementChoice0 + ", " +
				"dealStatementChoice1=" + this.dealStatementChoice1 + ", " +
				"dealStatementChoice2=" + this.dealStatementChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
