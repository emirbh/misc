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
import fpml.consolidated.loan.meta.LoanLegalActionApprovalStatusMeta;
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
 * Provision A structure that provides global level approval status on a legal action.
 *
 */
@RosettaDataType(value="LoanLegalActionApprovalStatus", builder=LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionApprovalStatus", model="fpml", builder=LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionApprovalStatus extends AbstractApproval {

	LoanLegalActionApprovalStatusMeta metaData = new LoanLegalActionApprovalStatusMeta();

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
	LoanLegalActionReference getLegalActionReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Approved status as of the effective date, based on a scheme.
	 *
	 */
	LoanLegalActionApprovalStatusType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A free form text field to further describe the approval status.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	LoanLegalActionApprovalStatus build();
	
	LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder toBuilder();
	
	static LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder builder() {
		return new LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionApprovalStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionApprovalStatus> getType() {
		return LoanLegalActionApprovalStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("approvalVotes"), processor, ApprovalVotes.class, getApprovalVotes());
		processor.processBasic(path.newSubPath("finalApprovalDate"), ZonedDateTime.class, getFinalApprovalDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("type"), processor, LoanLegalActionApprovalStatusType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionApprovalStatusBuilder extends LoanLegalActionApprovalStatus, AbstractApproval.AbstractApprovalBuilder {
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference();
		@Override
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference();
		LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder getOrCreateType();
		@Override
		LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder _getType();
		@Override
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setId(String id);
		@Override
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setApprovalVotes(ApprovalVotes approvalVotes);
		@Override
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setFinalApprovalDate(ZonedDateTime finalApprovalDate);
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setType(LoanLegalActionApprovalStatusType type);
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("approvalVotes"), processor, ApprovalVotes.ApprovalVotesBuilder.class, getApprovalVotes());
			processor.processBasic(path.newSubPath("finalApprovalDate"), ZonedDateTime.class, getFinalApprovalDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("type"), processor, LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionApprovalStatus  ***********************/
	class LoanLegalActionApprovalStatusImpl extends AbstractApproval.AbstractApprovalImpl implements LoanLegalActionApprovalStatus {
		private final LoanLegalActionReference legalActionReference;
		private final LoanLegalActionApprovalStatusType type;
		private final String description;
		
		protected LoanLegalActionApprovalStatusImpl(LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder builder) {
			super(builder);
			this.legalActionReference = ofNullable(builder.getLegalActionReference()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanLegalActionApprovalStatusType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public LoanLegalActionApprovalStatus build() {
			return this;
		}
		
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder toBuilder() {
			LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLegalActionReference()).ifPresent(builder::setLegalActionReference);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionApprovalStatus _that = getType().cast(o);
		
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionApprovalStatus {" +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionApprovalStatus  ***********************/
	class LoanLegalActionApprovalStatusBuilderImpl extends AbstractApproval.AbstractApprovalBuilderImpl implements LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder {
	
		protected LoanLegalActionReference.LoanLegalActionReferenceBuilder legalActionReference;
		protected LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder type;
		protected String description;
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference() {
			LoanLegalActionReference.LoanLegalActionReferenceBuilder result;
			if (legalActionReference!=null) {
				result = legalActionReference;
			}
			else {
				result = legalActionReference = LoanLegalActionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder getOrCreateType() {
			LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanLegalActionApprovalStatusType.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("approvalVotes")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approvalVotes")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setApprovalVotes(ApprovalVotes _approvalVotes) {
			this.approvalVotes = _approvalVotes == null ? null : _approvalVotes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalApprovalDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalApprovalDate")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setFinalApprovalDate(ZonedDateTime _finalApprovalDate) {
			this.finalApprovalDate = _finalApprovalDate == null ? null : _finalApprovalDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionReference")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setType(LoanLegalActionApprovalStatusType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public LoanLegalActionApprovalStatus build() {
			return new LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusImpl(this);
		}
		
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder prune() {
			super.prune();
			if (legalActionReference!=null && !legalActionReference.prune().hasData()) legalActionReference = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLegalActionReference()!=null && getLegalActionReference().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder o = (LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder) other;
			
			merger.mergeRosetta(getLegalActionReference(), o.getLegalActionReference(), this::setLegalActionReference);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionApprovalStatus _that = getType().cast(o);
		
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionApprovalStatusBuilder {" +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
