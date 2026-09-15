package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.loan.meta.ApprovalPartiesChoiceMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ApprovalPartiesChoice", builder=ApprovalPartiesChoice.ApprovalPartiesChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApprovalPartiesChoice", model="fpml", builder=ApprovalPartiesChoice.ApprovalPartiesChoiceBuilderImpl.class, version="2.1.1")
public interface ApprovalPartiesChoice extends RosettaModelObject {

	ApprovalPartiesChoiceMeta metaData = new ApprovalPartiesChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a lender eligible to vote on the approval.
	 *
	 */
	PartyReference getEligibleParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a lender ineligible to vote on the approval.
	 *
	 */
	PartyReference getIneligibleParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the reason a lender is ineligible to vote on the approval, based on a scheme.
	 *
	 */
	IneligiblePartyReasonType getIneligibleReason();

	/*********************** Build Methods  ***********************/
	ApprovalPartiesChoice build();
	
	ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder toBuilder();
	
	static ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder builder() {
		return new ApprovalPartiesChoice.ApprovalPartiesChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalPartiesChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApprovalPartiesChoice> getType() {
		return ApprovalPartiesChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eligibleParty"), processor, PartyReference.class, getEligibleParty());
		processRosetta(path.newSubPath("ineligibleParty"), processor, PartyReference.class, getIneligibleParty());
		processRosetta(path.newSubPath("ineligibleReason"), processor, IneligiblePartyReasonType.class, getIneligibleReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalPartiesChoiceBuilder extends ApprovalPartiesChoice, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateEligibleParty();
		@Override
		PartyReference.PartyReferenceBuilder getEligibleParty();
		PartyReference.PartyReferenceBuilder getOrCreateIneligibleParty();
		@Override
		PartyReference.PartyReferenceBuilder getIneligibleParty();
		IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder getOrCreateIneligibleReason();
		@Override
		IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder getIneligibleReason();
		ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setEligibleParty(PartyReference eligibleParty);
		ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setIneligibleParty(PartyReference ineligibleParty);
		ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setIneligibleReason(IneligiblePartyReasonType ineligibleReason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eligibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getEligibleParty());
			processRosetta(path.newSubPath("ineligibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getIneligibleParty());
			processRosetta(path.newSubPath("ineligibleReason"), processor, IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder.class, getIneligibleReason());
		}
		

		ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalPartiesChoice  ***********************/
	class ApprovalPartiesChoiceImpl implements ApprovalPartiesChoice {
		private final PartyReference eligibleParty;
		private final PartyReference ineligibleParty;
		private final IneligiblePartyReasonType ineligibleReason;
		
		protected ApprovalPartiesChoiceImpl(ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder builder) {
			this.eligibleParty = ofNullable(builder.getEligibleParty()).map(f->f.build()).orElse(null);
			this.ineligibleParty = ofNullable(builder.getIneligibleParty()).map(f->f.build()).orElse(null);
			this.ineligibleReason = ofNullable(builder.getIneligibleReason()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eligibleParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleParty")
		public PartyReference getEligibleParty() {
			return eligibleParty;
		}
		
		@Override
		@RosettaAttribute("ineligibleParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleParty")
		public PartyReference getIneligibleParty() {
			return ineligibleParty;
		}
		
		@Override
		@RosettaAttribute("ineligibleReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleReason")
		public IneligiblePartyReasonType getIneligibleReason() {
			return ineligibleReason;
		}
		
		@Override
		public ApprovalPartiesChoice build() {
			return this;
		}
		
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder toBuilder() {
			ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder builder) {
			ofNullable(getEligibleParty()).ifPresent(builder::setEligibleParty);
			ofNullable(getIneligibleParty()).ifPresent(builder::setIneligibleParty);
			ofNullable(getIneligibleReason()).ifPresent(builder::setIneligibleReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalPartiesChoice _that = getType().cast(o);
		
			if (!Objects.equals(eligibleParty, _that.getEligibleParty())) return false;
			if (!Objects.equals(ineligibleParty, _that.getIneligibleParty())) return false;
			if (!Objects.equals(ineligibleReason, _that.getIneligibleReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eligibleParty != null ? eligibleParty.hashCode() : 0);
			_result = 31 * _result + (ineligibleParty != null ? ineligibleParty.hashCode() : 0);
			_result = 31 * _result + (ineligibleReason != null ? ineligibleReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalPartiesChoice {" +
				"eligibleParty=" + this.eligibleParty + ", " +
				"ineligibleParty=" + this.ineligibleParty + ", " +
				"ineligibleReason=" + this.ineligibleReason +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalPartiesChoice  ***********************/
	class ApprovalPartiesChoiceBuilderImpl implements ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder {
	
		protected PartyReference.PartyReferenceBuilder eligibleParty;
		protected PartyReference.PartyReferenceBuilder ineligibleParty;
		protected IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder ineligibleReason;
		
		@Override
		@RosettaAttribute("eligibleParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleParty")
		public PartyReference.PartyReferenceBuilder getEligibleParty() {
			return eligibleParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateEligibleParty() {
			PartyReference.PartyReferenceBuilder result;
			if (eligibleParty!=null) {
				result = eligibleParty;
			}
			else {
				result = eligibleParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ineligibleParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleParty")
		public PartyReference.PartyReferenceBuilder getIneligibleParty() {
			return ineligibleParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIneligibleParty() {
			PartyReference.PartyReferenceBuilder result;
			if (ineligibleParty!=null) {
				result = ineligibleParty;
			}
			else {
				result = ineligibleParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ineligibleReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleReason")
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder getIneligibleReason() {
			return ineligibleReason;
		}
		
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder getOrCreateIneligibleReason() {
			IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder result;
			if (ineligibleReason!=null) {
				result = ineligibleReason;
			}
			else {
				result = ineligibleReason = IneligiblePartyReasonType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eligibleParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eligibleParty")
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setEligibleParty(PartyReference _eligibleParty) {
			this.eligibleParty = _eligibleParty == null ? null : _eligibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ineligibleParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ineligibleParty")
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setIneligibleParty(PartyReference _ineligibleParty) {
			this.ineligibleParty = _ineligibleParty == null ? null : _ineligibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ineligibleReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ineligibleReason")
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder setIneligibleReason(IneligiblePartyReasonType _ineligibleReason) {
			this.ineligibleReason = _ineligibleReason == null ? null : _ineligibleReason.toBuilder();
			return this;
		}
		
		@Override
		public ApprovalPartiesChoice build() {
			return new ApprovalPartiesChoice.ApprovalPartiesChoiceImpl(this);
		}
		
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder prune() {
			if (eligibleParty!=null && !eligibleParty.prune().hasData()) eligibleParty = null;
			if (ineligibleParty!=null && !ineligibleParty.prune().hasData()) ineligibleParty = null;
			if (ineligibleReason!=null && !ineligibleReason.prune().hasData()) ineligibleReason = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEligibleParty()!=null && getEligibleParty().hasData()) return true;
			if (getIneligibleParty()!=null && getIneligibleParty().hasData()) return true;
			if (getIneligibleReason()!=null && getIneligibleReason().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder o = (ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder) other;
			
			merger.mergeRosetta(getEligibleParty(), o.getEligibleParty(), this::setEligibleParty);
			merger.mergeRosetta(getIneligibleParty(), o.getIneligibleParty(), this::setIneligibleParty);
			merger.mergeRosetta(getIneligibleReason(), o.getIneligibleReason(), this::setIneligibleReason);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalPartiesChoice _that = getType().cast(o);
		
			if (!Objects.equals(eligibleParty, _that.getEligibleParty())) return false;
			if (!Objects.equals(ineligibleParty, _that.getIneligibleParty())) return false;
			if (!Objects.equals(ineligibleReason, _that.getIneligibleReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eligibleParty != null ? eligibleParty.hashCode() : 0);
			_result = 31 * _result + (ineligibleParty != null ? ineligibleParty.hashCode() : 0);
			_result = 31 * _result + (ineligibleReason != null ? ineligibleReason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalPartiesChoiceBuilder {" +
				"eligibleParty=" + this.eligibleParty + ", " +
				"ineligibleParty=" + this.ineligibleParty + ", " +
				"ineligibleReason=" + this.ineligibleReason +
			'}';
		}
	}
}
