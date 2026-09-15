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
import fpml.consolidated.loan.meta.ApprovalVotesMeta;
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
 * Provision A structure to describe the approval votes, expressed as a percentage as well as a commitment with optional list of votes by voters.
 *
 */
@RosettaDataType(value="ApprovalVotes", builder=ApprovalVotes.ApprovalVotesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApprovalVotes", model="fpml", builder=ApprovalVotes.ApprovalVotesBuilderImpl.class, version="2.1.1")
public interface ApprovalVotes extends RosettaModelObject {

	ApprovalVotesMeta metaData = new ApprovalVotesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe total "for" votes received.
	 *
	 */
	VoteQuantity getForVotesQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe a list of party approval votes.
	 *
	 */
	List<? extends PartyApprovalVote> getPartyApprovalVotesList();

	/*********************** Build Methods  ***********************/
	ApprovalVotes build();
	
	ApprovalVotes.ApprovalVotesBuilder toBuilder();
	
	static ApprovalVotes.ApprovalVotesBuilder builder() {
		return new ApprovalVotes.ApprovalVotesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalVotes> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApprovalVotes> getType() {
		return ApprovalVotes.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("forVotesQuantity"), processor, VoteQuantity.class, getForVotesQuantity());
		processRosetta(path.newSubPath("partyApprovalVotesList"), processor, PartyApprovalVote.class, getPartyApprovalVotesList());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalVotesBuilder extends ApprovalVotes, RosettaModelObjectBuilder {
		VoteQuantity.VoteQuantityBuilder getOrCreateForVotesQuantity();
		@Override
		VoteQuantity.VoteQuantityBuilder getForVotesQuantity();
		PartyApprovalVote.PartyApprovalVoteBuilder getOrCreatePartyApprovalVotesList(int index);
		@Override
		List<? extends PartyApprovalVote.PartyApprovalVoteBuilder> getPartyApprovalVotesList();
		ApprovalVotes.ApprovalVotesBuilder setForVotesQuantity(VoteQuantity forVotesQuantity);
		ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(PartyApprovalVote partyApprovalVotesList);
		ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(PartyApprovalVote partyApprovalVotesList, int idx);
		ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(List<? extends PartyApprovalVote> partyApprovalVotesList);
		ApprovalVotes.ApprovalVotesBuilder setPartyApprovalVotesList(List<? extends PartyApprovalVote> partyApprovalVotesList);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("forVotesQuantity"), processor, VoteQuantity.VoteQuantityBuilder.class, getForVotesQuantity());
			processRosetta(path.newSubPath("partyApprovalVotesList"), processor, PartyApprovalVote.PartyApprovalVoteBuilder.class, getPartyApprovalVotesList());
		}
		

		ApprovalVotes.ApprovalVotesBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalVotes  ***********************/
	class ApprovalVotesImpl implements ApprovalVotes {
		private final VoteQuantity forVotesQuantity;
		private final List<? extends PartyApprovalVote> partyApprovalVotesList;
		
		protected ApprovalVotesImpl(ApprovalVotes.ApprovalVotesBuilder builder) {
			this.forVotesQuantity = ofNullable(builder.getForVotesQuantity()).map(f->f.build()).orElse(null);
			this.partyApprovalVotesList = ofNullable(builder.getPartyApprovalVotesList()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("forVotesQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forVotesQuantity")
		public VoteQuantity getForVotesQuantity() {
			return forVotesQuantity;
		}
		
		@Override
		@RosettaAttribute("partyApprovalVotesList")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyApprovalVotesList")
		public List<? extends PartyApprovalVote> getPartyApprovalVotesList() {
			return partyApprovalVotesList;
		}
		
		@Override
		public ApprovalVotes build() {
			return this;
		}
		
		@Override
		public ApprovalVotes.ApprovalVotesBuilder toBuilder() {
			ApprovalVotes.ApprovalVotesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalVotes.ApprovalVotesBuilder builder) {
			ofNullable(getForVotesQuantity()).ifPresent(builder::setForVotesQuantity);
			ofNullable(getPartyApprovalVotesList()).ifPresent(builder::setPartyApprovalVotesList);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalVotes _that = getType().cast(o);
		
			if (!Objects.equals(forVotesQuantity, _that.getForVotesQuantity())) return false;
			if (!ListEquals.listEquals(partyApprovalVotesList, _that.getPartyApprovalVotesList())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forVotesQuantity != null ? forVotesQuantity.hashCode() : 0);
			_result = 31 * _result + (partyApprovalVotesList != null ? partyApprovalVotesList.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalVotes {" +
				"forVotesQuantity=" + this.forVotesQuantity + ", " +
				"partyApprovalVotesList=" + this.partyApprovalVotesList +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalVotes  ***********************/
	class ApprovalVotesBuilderImpl implements ApprovalVotes.ApprovalVotesBuilder {
	
		protected VoteQuantity.VoteQuantityBuilder forVotesQuantity;
		protected List<PartyApprovalVote.PartyApprovalVoteBuilder> partyApprovalVotesList = new ArrayList<>();
		
		@Override
		@RosettaAttribute("forVotesQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forVotesQuantity")
		public VoteQuantity.VoteQuantityBuilder getForVotesQuantity() {
			return forVotesQuantity;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder getOrCreateForVotesQuantity() {
			VoteQuantity.VoteQuantityBuilder result;
			if (forVotesQuantity!=null) {
				result = forVotesQuantity;
			}
			else {
				result = forVotesQuantity = VoteQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyApprovalVotesList")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyApprovalVotesList")
		public List<? extends PartyApprovalVote.PartyApprovalVoteBuilder> getPartyApprovalVotesList() {
			return partyApprovalVotesList;
		}
		
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder getOrCreatePartyApprovalVotesList(int index) {
			if (partyApprovalVotesList==null) {
				this.partyApprovalVotesList = new ArrayList<>();
			}
			return getIndex(partyApprovalVotesList, index, () -> {
						PartyApprovalVote.PartyApprovalVoteBuilder newPartyApprovalVotesList = PartyApprovalVote.builder();
						return newPartyApprovalVotesList;
					});
		}
		
		@RosettaAttribute("forVotesQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("forVotesQuantity")
		@Override
		public ApprovalVotes.ApprovalVotesBuilder setForVotesQuantity(VoteQuantity _forVotesQuantity) {
			this.forVotesQuantity = _forVotesQuantity == null ? null : _forVotesQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyApprovalVotesList")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyApprovalVotesList")
		@Override
		public ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(PartyApprovalVote _partyApprovalVotesList) {
			if (_partyApprovalVotesList != null) {
				this.partyApprovalVotesList.add(_partyApprovalVotesList.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(PartyApprovalVote _partyApprovalVotesList, int idx) {
			getIndex(this.partyApprovalVotesList, idx, () -> _partyApprovalVotesList.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalVotes.ApprovalVotesBuilder addPartyApprovalVotesList(List<? extends PartyApprovalVote> partyApprovalVotesLists) {
			if (partyApprovalVotesLists != null) {
				for (final PartyApprovalVote toAdd : partyApprovalVotesLists) {
					this.partyApprovalVotesList.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyApprovalVotesList")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyApprovalVotesList")
		@Override
		public ApprovalVotes.ApprovalVotesBuilder setPartyApprovalVotesList(List<? extends PartyApprovalVote> partyApprovalVotesLists) {
			if (partyApprovalVotesLists == null) {
				this.partyApprovalVotesList = new ArrayList<>();
			} else {
				this.partyApprovalVotesList = partyApprovalVotesLists.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApprovalVotes build() {
			return new ApprovalVotes.ApprovalVotesImpl(this);
		}
		
		@Override
		public ApprovalVotes.ApprovalVotesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalVotes.ApprovalVotesBuilder prune() {
			if (forVotesQuantity!=null && !forVotesQuantity.prune().hasData()) forVotesQuantity = null;
			partyApprovalVotesList = partyApprovalVotesList.stream().filter(b->b!=null).<PartyApprovalVote.PartyApprovalVoteBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getForVotesQuantity()!=null && getForVotesQuantity().hasData()) return true;
			if (getPartyApprovalVotesList()!=null && getPartyApprovalVotesList().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalVotes.ApprovalVotesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalVotes.ApprovalVotesBuilder o = (ApprovalVotes.ApprovalVotesBuilder) other;
			
			merger.mergeRosetta(getForVotesQuantity(), o.getForVotesQuantity(), this::setForVotesQuantity);
			merger.mergeRosetta(getPartyApprovalVotesList(), o.getPartyApprovalVotesList(), this::getOrCreatePartyApprovalVotesList);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalVotes _that = getType().cast(o);
		
			if (!Objects.equals(forVotesQuantity, _that.getForVotesQuantity())) return false;
			if (!ListEquals.listEquals(partyApprovalVotesList, _that.getPartyApprovalVotesList())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forVotesQuantity != null ? forVotesQuantity.hashCode() : 0);
			_result = 31 * _result + (partyApprovalVotesList != null ? partyApprovalVotesList.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalVotesBuilder {" +
				"forVotesQuantity=" + this.forVotesQuantity + ", " +
				"partyApprovalVotesList=" + this.partyApprovalVotesList +
			'}';
		}
	}
}
