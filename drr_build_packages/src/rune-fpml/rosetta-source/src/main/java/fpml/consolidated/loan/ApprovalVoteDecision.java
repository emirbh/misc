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
import fpml.consolidated.fpmlenum.VoteDecisionEnum;
import fpml.consolidated.loan.meta.ApprovalVoteDecisionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe a party's approval vote decision.
 *
 */
@RosettaDataType(value="ApprovalVoteDecision", builder=ApprovalVoteDecision.ApprovalVoteDecisionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApprovalVoteDecision", model="fpml", builder=ApprovalVoteDecision.ApprovalVoteDecisionBuilderImpl.class, version="2.1.1")
public interface ApprovalVoteDecision extends RosettaModelObject {

	ApprovalVoteDecisionMeta metaData = new ApprovalVoteDecisionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The vote decision of the party, based on an enumeration. This object represents the "functional" impact of the decision, and not the legal vernacular. Use either documentVoteDecision or description elements below to express the legal vernacular representing the vote decision.
	 *
	 */
	VoteDecisionEnum getVoteDecision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The vote decision of the party, based on a scheme. This object represents the documented description of the vote decision (i.e. the decision as described by the legal document).
	 *
	 */
	DocumentVoteDecisionType getDocumentVoteDecision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A free form field to provide a description of the vote decision of the party. This object represents the documented description of the vote decision (i.e. the decision as described by the legal document).
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	ApprovalVoteDecision build();
	
	ApprovalVoteDecision.ApprovalVoteDecisionBuilder toBuilder();
	
	static ApprovalVoteDecision.ApprovalVoteDecisionBuilder builder() {
		return new ApprovalVoteDecision.ApprovalVoteDecisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalVoteDecision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApprovalVoteDecision> getType() {
		return ApprovalVoteDecision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("voteDecision"), VoteDecisionEnum.class, getVoteDecision(), this);
		processRosetta(path.newSubPath("documentVoteDecision"), processor, DocumentVoteDecisionType.class, getDocumentVoteDecision());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalVoteDecisionBuilder extends ApprovalVoteDecision, RosettaModelObjectBuilder {
		DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder getOrCreateDocumentVoteDecision();
		@Override
		DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder getDocumentVoteDecision();
		ApprovalVoteDecision.ApprovalVoteDecisionBuilder setVoteDecision(VoteDecisionEnum voteDecision);
		ApprovalVoteDecision.ApprovalVoteDecisionBuilder setDocumentVoteDecision(DocumentVoteDecisionType documentVoteDecision);
		ApprovalVoteDecision.ApprovalVoteDecisionBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("voteDecision"), VoteDecisionEnum.class, getVoteDecision(), this);
			processRosetta(path.newSubPath("documentVoteDecision"), processor, DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder.class, getDocumentVoteDecision());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		ApprovalVoteDecision.ApprovalVoteDecisionBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalVoteDecision  ***********************/
	class ApprovalVoteDecisionImpl implements ApprovalVoteDecision {
		private final VoteDecisionEnum voteDecision;
		private final DocumentVoteDecisionType documentVoteDecision;
		private final String description;
		
		protected ApprovalVoteDecisionImpl(ApprovalVoteDecision.ApprovalVoteDecisionBuilder builder) {
			this.voteDecision = builder.getVoteDecision();
			this.documentVoteDecision = ofNullable(builder.getDocumentVoteDecision()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("voteDecision")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("voteDecision")
		public VoteDecisionEnum getVoteDecision() {
			return voteDecision;
		}
		
		@Override
		@RosettaAttribute("documentVoteDecision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentVoteDecision")
		public DocumentVoteDecisionType getDocumentVoteDecision() {
			return documentVoteDecision;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public ApprovalVoteDecision build() {
			return this;
		}
		
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder toBuilder() {
			ApprovalVoteDecision.ApprovalVoteDecisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalVoteDecision.ApprovalVoteDecisionBuilder builder) {
			ofNullable(getVoteDecision()).ifPresent(builder::setVoteDecision);
			ofNullable(getDocumentVoteDecision()).ifPresent(builder::setDocumentVoteDecision);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalVoteDecision _that = getType().cast(o);
		
			if (!Objects.equals(voteDecision, _that.getVoteDecision())) return false;
			if (!Objects.equals(documentVoteDecision, _that.getDocumentVoteDecision())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteDecision != null ? voteDecision.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (documentVoteDecision != null ? documentVoteDecision.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalVoteDecision {" +
				"voteDecision=" + this.voteDecision + ", " +
				"documentVoteDecision=" + this.documentVoteDecision + ", " +
				"description=" + this.description +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalVoteDecision  ***********************/
	class ApprovalVoteDecisionBuilderImpl implements ApprovalVoteDecision.ApprovalVoteDecisionBuilder {
	
		protected VoteDecisionEnum voteDecision;
		protected DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder documentVoteDecision;
		protected String description;
		
		@Override
		@RosettaAttribute("voteDecision")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("voteDecision")
		public VoteDecisionEnum getVoteDecision() {
			return voteDecision;
		}
		
		@Override
		@RosettaAttribute("documentVoteDecision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentVoteDecision")
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder getDocumentVoteDecision() {
			return documentVoteDecision;
		}
		
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder getOrCreateDocumentVoteDecision() {
			DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder result;
			if (documentVoteDecision!=null) {
				result = documentVoteDecision;
			}
			else {
				result = documentVoteDecision = DocumentVoteDecisionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("voteDecision")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("voteDecision")
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder setVoteDecision(VoteDecisionEnum _voteDecision) {
			this.voteDecision = _voteDecision == null ? null : _voteDecision;
			return this;
		}
		
		@RosettaAttribute("documentVoteDecision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("documentVoteDecision")
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder setDocumentVoteDecision(DocumentVoteDecisionType _documentVoteDecision) {
			this.documentVoteDecision = _documentVoteDecision == null ? null : _documentVoteDecision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public ApprovalVoteDecision build() {
			return new ApprovalVoteDecision.ApprovalVoteDecisionImpl(this);
		}
		
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder prune() {
			if (documentVoteDecision!=null && !documentVoteDecision.prune().hasData()) documentVoteDecision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVoteDecision()!=null) return true;
			if (getDocumentVoteDecision()!=null && getDocumentVoteDecision().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalVoteDecision.ApprovalVoteDecisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalVoteDecision.ApprovalVoteDecisionBuilder o = (ApprovalVoteDecision.ApprovalVoteDecisionBuilder) other;
			
			merger.mergeRosetta(getDocumentVoteDecision(), o.getDocumentVoteDecision(), this::setDocumentVoteDecision);
			
			merger.mergeBasic(getVoteDecision(), o.getVoteDecision(), this::setVoteDecision);
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalVoteDecision _that = getType().cast(o);
		
			if (!Objects.equals(voteDecision, _that.getVoteDecision())) return false;
			if (!Objects.equals(documentVoteDecision, _that.getDocumentVoteDecision())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteDecision != null ? voteDecision.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (documentVoteDecision != null ? documentVoteDecision.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalVoteDecisionBuilder {" +
				"voteDecision=" + this.voteDecision + ", " +
				"documentVoteDecision=" + this.documentVoteDecision + ", " +
				"description=" + this.description +
			'}';
		}
	}
}
