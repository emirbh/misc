package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.loan.meta.PartyApprovalVoteMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe a party's approval vote.
 *
 */
@RosettaDataType(value="PartyApprovalVote", builder=PartyApprovalVote.PartyApprovalVoteBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyApprovalVote", model="fpml", builder=PartyApprovalVote.PartyApprovalVoteBuilderImpl.class, version="2.1.1")
public interface PartyApprovalVote extends RosettaModelObject {

	PartyApprovalVoteMeta metaData = new PartyApprovalVoteMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the party providing its approval.
	 *
	 */
	PartyReference getVotePartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party's approval vote expressed as a number of votes, a percent of the total vote, or an amount (e.g. loan commitment amount).
	 *
	 */
	VoteQuantity getVoteQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The vote decision of the party.
	 *
	 */
	ApprovalVoteDecision getVote();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the party provided their vote.
	 *
	 */
	ZonedDateTime getVoteDate();

	/*********************** Build Methods  ***********************/
	PartyApprovalVote build();
	
	PartyApprovalVote.PartyApprovalVoteBuilder toBuilder();
	
	static PartyApprovalVote.PartyApprovalVoteBuilder builder() {
		return new PartyApprovalVote.PartyApprovalVoteBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyApprovalVote> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyApprovalVote> getType() {
		return PartyApprovalVote.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("votePartyReference"), processor, PartyReference.class, getVotePartyReference());
		processRosetta(path.newSubPath("voteQuantity"), processor, VoteQuantity.class, getVoteQuantity());
		processRosetta(path.newSubPath("vote"), processor, ApprovalVoteDecision.class, getVote());
		processor.processBasic(path.newSubPath("voteDate"), ZonedDateTime.class, getVoteDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyApprovalVoteBuilder extends PartyApprovalVote, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateVotePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getVotePartyReference();
		VoteQuantity.VoteQuantityBuilder getOrCreateVoteQuantity();
		@Override
		VoteQuantity.VoteQuantityBuilder getVoteQuantity();
		ApprovalVoteDecision.ApprovalVoteDecisionBuilder getOrCreateVote();
		@Override
		ApprovalVoteDecision.ApprovalVoteDecisionBuilder getVote();
		PartyApprovalVote.PartyApprovalVoteBuilder setVotePartyReference(PartyReference votePartyReference);
		PartyApprovalVote.PartyApprovalVoteBuilder setVoteQuantity(VoteQuantity voteQuantity);
		PartyApprovalVote.PartyApprovalVoteBuilder setVote(ApprovalVoteDecision vote);
		PartyApprovalVote.PartyApprovalVoteBuilder setVoteDate(ZonedDateTime voteDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("votePartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getVotePartyReference());
			processRosetta(path.newSubPath("voteQuantity"), processor, VoteQuantity.VoteQuantityBuilder.class, getVoteQuantity());
			processRosetta(path.newSubPath("vote"), processor, ApprovalVoteDecision.ApprovalVoteDecisionBuilder.class, getVote());
			processor.processBasic(path.newSubPath("voteDate"), ZonedDateTime.class, getVoteDate(), this);
		}
		

		PartyApprovalVote.PartyApprovalVoteBuilder prune();
	}

	/*********************** Immutable Implementation of PartyApprovalVote  ***********************/
	class PartyApprovalVoteImpl implements PartyApprovalVote {
		private final PartyReference votePartyReference;
		private final VoteQuantity voteQuantity;
		private final ApprovalVoteDecision vote;
		private final ZonedDateTime voteDate;
		
		protected PartyApprovalVoteImpl(PartyApprovalVote.PartyApprovalVoteBuilder builder) {
			this.votePartyReference = ofNullable(builder.getVotePartyReference()).map(f->f.build()).orElse(null);
			this.voteQuantity = ofNullable(builder.getVoteQuantity()).map(f->f.build()).orElse(null);
			this.vote = ofNullable(builder.getVote()).map(f->f.build()).orElse(null);
			this.voteDate = builder.getVoteDate();
		}
		
		@Override
		@RosettaAttribute("votePartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("votePartyReference")
		public PartyReference getVotePartyReference() {
			return votePartyReference;
		}
		
		@Override
		@RosettaAttribute("voteQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteQuantity")
		public VoteQuantity getVoteQuantity() {
			return voteQuantity;
		}
		
		@Override
		@RosettaAttribute("vote")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vote")
		public ApprovalVoteDecision getVote() {
			return vote;
		}
		
		@Override
		@RosettaAttribute("voteDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("voteDate")
		public ZonedDateTime getVoteDate() {
			return voteDate;
		}
		
		@Override
		public PartyApprovalVote build() {
			return this;
		}
		
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder toBuilder() {
			PartyApprovalVote.PartyApprovalVoteBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyApprovalVote.PartyApprovalVoteBuilder builder) {
			ofNullable(getVotePartyReference()).ifPresent(builder::setVotePartyReference);
			ofNullable(getVoteQuantity()).ifPresent(builder::setVoteQuantity);
			ofNullable(getVote()).ifPresent(builder::setVote);
			ofNullable(getVoteDate()).ifPresent(builder::setVoteDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyApprovalVote _that = getType().cast(o);
		
			if (!Objects.equals(votePartyReference, _that.getVotePartyReference())) return false;
			if (!Objects.equals(voteQuantity, _that.getVoteQuantity())) return false;
			if (!Objects.equals(vote, _that.getVote())) return false;
			if (!Objects.equals(voteDate, _that.getVoteDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (votePartyReference != null ? votePartyReference.hashCode() : 0);
			_result = 31 * _result + (voteQuantity != null ? voteQuantity.hashCode() : 0);
			_result = 31 * _result + (vote != null ? vote.hashCode() : 0);
			_result = 31 * _result + (voteDate != null ? voteDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyApprovalVote {" +
				"votePartyReference=" + this.votePartyReference + ", " +
				"voteQuantity=" + this.voteQuantity + ", " +
				"vote=" + this.vote + ", " +
				"voteDate=" + this.voteDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyApprovalVote  ***********************/
	class PartyApprovalVoteBuilderImpl implements PartyApprovalVote.PartyApprovalVoteBuilder {
	
		protected PartyReference.PartyReferenceBuilder votePartyReference;
		protected VoteQuantity.VoteQuantityBuilder voteQuantity;
		protected ApprovalVoteDecision.ApprovalVoteDecisionBuilder vote;
		protected ZonedDateTime voteDate;
		
		@Override
		@RosettaAttribute("votePartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("votePartyReference")
		public PartyReference.PartyReferenceBuilder getVotePartyReference() {
			return votePartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateVotePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (votePartyReference!=null) {
				result = votePartyReference;
			}
			else {
				result = votePartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("voteQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteQuantity")
		public VoteQuantity.VoteQuantityBuilder getVoteQuantity() {
			return voteQuantity;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder getOrCreateVoteQuantity() {
			VoteQuantity.VoteQuantityBuilder result;
			if (voteQuantity!=null) {
				result = voteQuantity;
			}
			else {
				result = voteQuantity = VoteQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vote")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vote")
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder getVote() {
			return vote;
		}
		
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder getOrCreateVote() {
			ApprovalVoteDecision.ApprovalVoteDecisionBuilder result;
			if (vote!=null) {
				result = vote;
			}
			else {
				result = vote = ApprovalVoteDecision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("voteDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("voteDate")
		public ZonedDateTime getVoteDate() {
			return voteDate;
		}
		
		@RosettaAttribute("votePartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("votePartyReference")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder setVotePartyReference(PartyReference _votePartyReference) {
			this.votePartyReference = _votePartyReference == null ? null : _votePartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("voteQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("voteQuantity")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder setVoteQuantity(VoteQuantity _voteQuantity) {
			this.voteQuantity = _voteQuantity == null ? null : _voteQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vote")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("vote")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder setVote(ApprovalVoteDecision _vote) {
			this.vote = _vote == null ? null : _vote.toBuilder();
			return this;
		}
		
		@RosettaAttribute("voteDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("voteDate")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder setVoteDate(ZonedDateTime _voteDate) {
			this.voteDate = _voteDate == null ? null : _voteDate;
			return this;
		}
		
		@Override
		public PartyApprovalVote build() {
			return new PartyApprovalVote.PartyApprovalVoteImpl(this);
		}
		
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder prune() {
			if (votePartyReference!=null && !votePartyReference.prune().hasData()) votePartyReference = null;
			if (voteQuantity!=null && !voteQuantity.prune().hasData()) voteQuantity = null;
			if (vote!=null && !vote.prune().hasData()) vote = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVotePartyReference()!=null && getVotePartyReference().hasData()) return true;
			if (getVoteQuantity()!=null && getVoteQuantity().hasData()) return true;
			if (getVote()!=null && getVote().hasData()) return true;
			if (getVoteDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyApprovalVote.PartyApprovalVoteBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyApprovalVote.PartyApprovalVoteBuilder o = (PartyApprovalVote.PartyApprovalVoteBuilder) other;
			
			merger.mergeRosetta(getVotePartyReference(), o.getVotePartyReference(), this::setVotePartyReference);
			merger.mergeRosetta(getVoteQuantity(), o.getVoteQuantity(), this::setVoteQuantity);
			merger.mergeRosetta(getVote(), o.getVote(), this::setVote);
			
			merger.mergeBasic(getVoteDate(), o.getVoteDate(), this::setVoteDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyApprovalVote _that = getType().cast(o);
		
			if (!Objects.equals(votePartyReference, _that.getVotePartyReference())) return false;
			if (!Objects.equals(voteQuantity, _that.getVoteQuantity())) return false;
			if (!Objects.equals(vote, _that.getVote())) return false;
			if (!Objects.equals(voteDate, _that.getVoteDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (votePartyReference != null ? votePartyReference.hashCode() : 0);
			_result = 31 * _result + (voteQuantity != null ? voteQuantity.hashCode() : 0);
			_result = 31 * _result + (vote != null ? vote.hashCode() : 0);
			_result = 31 * _result + (voteDate != null ? voteDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyApprovalVoteBuilder {" +
				"votePartyReference=" + this.votePartyReference + ", " +
				"voteQuantity=" + this.voteQuantity + ", " +
				"vote=" + this.vote + ", " +
				"voteDate=" + this.voteDate +
			'}';
		}
	}
}
