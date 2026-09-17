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
import fpml.consolidated.loan.meta.LoanPartyProfileStatementMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * Provision A profile generated and communicated by parties containing their relevant contact and payment details. This is communicated by parties to anyone who wishes to initiate payments and/or communicate with them.
 *
 */
@RosettaDataType(value="LoanPartyProfileStatement", builder=LoanPartyProfileStatement.LoanPartyProfileStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanPartyProfileStatement", model="fpml", builder=LoanPartyProfileStatement.LoanPartyProfileStatementBuilderImpl.class, version="2.1.1")
public interface LoanPartyProfileStatement extends AbstractLoanPartyProfileStatement {

	LoanPartyProfileStatementMeta metaData = new LoanPartyProfileStatementMeta();

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
	PartyProfile getPartyProfile();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanPartyProfileStatement build();
	
	LoanPartyProfileStatement.LoanPartyProfileStatementBuilder toBuilder();
	
	static LoanPartyProfileStatement.LoanPartyProfileStatementBuilder builder() {
		return new LoanPartyProfileStatement.LoanPartyProfileStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanPartyProfileStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanPartyProfileStatement> getType() {
		return LoanPartyProfileStatement.class;
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
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("partyProfile"), processor, PartyProfile.class, getPartyProfile());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanPartyProfileStatementBuilder extends LoanPartyProfileStatement, AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder {
		PartyProfile.PartyProfileBuilder getOrCreatePartyProfile();
		@Override
		PartyProfile.PartyProfileBuilder getPartyProfile();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(Validation validation);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(Validation validation, int idx);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setComments(String comments);
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setPartyProfile(PartyProfile partyProfile);
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(Party party);
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(Party party, int idx);
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(List<? extends Party> party);
		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setParty(List<? extends Party> party);

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
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("partyProfile"), processor, PartyProfile.PartyProfileBuilder.class, getPartyProfile());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanPartyProfileStatement.LoanPartyProfileStatementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanPartyProfileStatement  ***********************/
	class LoanPartyProfileStatementImpl extends AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementImpl implements LoanPartyProfileStatement {
		private final PartyProfile partyProfile;
		private final List<? extends Party> party;
		
		protected LoanPartyProfileStatementImpl(LoanPartyProfileStatement.LoanPartyProfileStatementBuilder builder) {
			super(builder);
			this.partyProfile = ofNullable(builder.getPartyProfile()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfile")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfile")
		public PartyProfile getPartyProfile() {
			return partyProfile;
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
		public LoanPartyProfileStatement build() {
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder toBuilder() {
			LoanPartyProfileStatement.LoanPartyProfileStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanPartyProfileStatement.LoanPartyProfileStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartyProfile()).ifPresent(builder::setPartyProfile);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyProfileStatement _that = getType().cast(o);
		
			if (!Objects.equals(partyProfile, _that.getPartyProfile())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfile != null ? partyProfile.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyProfileStatement {" +
				"partyProfile=" + this.partyProfile + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanPartyProfileStatement  ***********************/
	class LoanPartyProfileStatementBuilderImpl extends AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilderImpl implements LoanPartyProfileStatement.LoanPartyProfileStatementBuilder {
	
		protected PartyProfile.PartyProfileBuilder partyProfile;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyProfile")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfile")
		public PartyProfile.PartyProfileBuilder getPartyProfile() {
			return partyProfile;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder getOrCreatePartyProfile() {
			PartyProfile.PartyProfileBuilder result;
			if (partyProfile!=null) {
				result = partyProfile;
			}
			else {
				result = partyProfile = PartyProfile.builder();
			}
			
			return result;
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@RosettaAttribute("partyProfile")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyProfile")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setPartyProfile(PartyProfile _partyProfile) {
			this.partyProfile = _partyProfile == null ? null : _partyProfile.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder addParty(List<? extends Party> partys) {
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
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder setParty(List<? extends Party> partys) {
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
		public LoanPartyProfileStatement build() {
			return new LoanPartyProfileStatement.LoanPartyProfileStatementImpl(this);
		}
		
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder prune() {
			super.prune();
			if (partyProfile!=null && !partyProfile.prune().hasData()) partyProfile = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartyProfile()!=null && getPartyProfile().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyProfileStatement.LoanPartyProfileStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanPartyProfileStatement.LoanPartyProfileStatementBuilder o = (LoanPartyProfileStatement.LoanPartyProfileStatementBuilder) other;
			
			merger.mergeRosetta(getPartyProfile(), o.getPartyProfile(), this::setPartyProfile);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyProfileStatement _that = getType().cast(o);
		
			if (!Objects.equals(partyProfile, _that.getPartyProfile())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfile != null ? partyProfile.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyProfileStatementBuilder {" +
				"partyProfile=" + this.partyProfile + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
