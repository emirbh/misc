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
import fpml.consolidated.loan.meta.AbstractApprovalMeta;
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
 * Provision A abstract type to describe an approval.
 *
 */
@RosettaDataType(value="AbstractApproval", builder=AbstractApproval.AbstractApprovalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractApproval", model="fpml", builder=AbstractApproval.AbstractApprovalBuilderImpl.class, version="2.1.1")
public interface AbstractApproval extends RosettaModelObject {

	AbstractApprovalMeta metaData = new AbstractApprovalMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The effective date of the approval status details.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the approval votes, expressed as a percentage as well as a commitment with optional list of votes by voters.
	 *
	 */
	ApprovalVotes getApprovalVotes();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the date on which the approval is finalized.
	 *
	 */
	ZonedDateTime getFinalApprovalDate();

	/*********************** Build Methods  ***********************/
	AbstractApproval build();
	
	AbstractApproval.AbstractApprovalBuilder toBuilder();
	
	static AbstractApproval.AbstractApprovalBuilder builder() {
		return new AbstractApproval.AbstractApprovalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractApproval> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractApproval> getType() {
		return AbstractApproval.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("approvalVotes"), processor, ApprovalVotes.class, getApprovalVotes());
		processor.processBasic(path.newSubPath("finalApprovalDate"), ZonedDateTime.class, getFinalApprovalDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractApprovalBuilder extends AbstractApproval, RosettaModelObjectBuilder {
		ApprovalVotes.ApprovalVotesBuilder getOrCreateApprovalVotes();
		@Override
		ApprovalVotes.ApprovalVotesBuilder getApprovalVotes();
		AbstractApproval.AbstractApprovalBuilder setId(String id);
		AbstractApproval.AbstractApprovalBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		AbstractApproval.AbstractApprovalBuilder setApprovalVotes(ApprovalVotes approvalVotes);
		AbstractApproval.AbstractApprovalBuilder setFinalApprovalDate(ZonedDateTime finalApprovalDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("approvalVotes"), processor, ApprovalVotes.ApprovalVotesBuilder.class, getApprovalVotes());
			processor.processBasic(path.newSubPath("finalApprovalDate"), ZonedDateTime.class, getFinalApprovalDate(), this);
		}
		

		AbstractApproval.AbstractApprovalBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractApproval  ***********************/
	class AbstractApprovalImpl implements AbstractApproval {
		private final String id;
		private final ZonedDateTime effectiveDate;
		private final ApprovalVotes approvalVotes;
		private final ZonedDateTime finalApprovalDate;
		
		protected AbstractApprovalImpl(AbstractApproval.AbstractApprovalBuilder builder) {
			this.id = builder.getId();
			this.effectiveDate = builder.getEffectiveDate();
			this.approvalVotes = ofNullable(builder.getApprovalVotes()).map(f->f.build()).orElse(null);
			this.finalApprovalDate = builder.getFinalApprovalDate();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("approvalVotes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalVotes")
		public ApprovalVotes getApprovalVotes() {
			return approvalVotes;
		}
		
		@Override
		@RosettaAttribute("finalApprovalDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalApprovalDate")
		public ZonedDateTime getFinalApprovalDate() {
			return finalApprovalDate;
		}
		
		@Override
		public AbstractApproval build() {
			return this;
		}
		
		@Override
		public AbstractApproval.AbstractApprovalBuilder toBuilder() {
			AbstractApproval.AbstractApprovalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractApproval.AbstractApprovalBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getApprovalVotes()).ifPresent(builder::setApprovalVotes);
			ofNullable(getFinalApprovalDate()).ifPresent(builder::setFinalApprovalDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApproval _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(approvalVotes, _that.getApprovalVotes())) return false;
			if (!Objects.equals(finalApprovalDate, _that.getFinalApprovalDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (approvalVotes != null ? approvalVotes.hashCode() : 0);
			_result = 31 * _result + (finalApprovalDate != null ? finalApprovalDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApproval {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"approvalVotes=" + this.approvalVotes + ", " +
				"finalApprovalDate=" + this.finalApprovalDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractApproval  ***********************/
	class AbstractApprovalBuilderImpl implements AbstractApproval.AbstractApprovalBuilder {
	
		protected String id;
		protected ZonedDateTime effectiveDate;
		protected ApprovalVotes.ApprovalVotesBuilder approvalVotes;
		protected ZonedDateTime finalApprovalDate;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("approvalVotes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalVotes")
		public ApprovalVotes.ApprovalVotesBuilder getApprovalVotes() {
			return approvalVotes;
		}
		
		@Override
		public ApprovalVotes.ApprovalVotesBuilder getOrCreateApprovalVotes() {
			ApprovalVotes.ApprovalVotesBuilder result;
			if (approvalVotes!=null) {
				result = approvalVotes;
			}
			else {
				result = approvalVotes = ApprovalVotes.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalApprovalDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalApprovalDate")
		public ZonedDateTime getFinalApprovalDate() {
			return finalApprovalDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AbstractApproval.AbstractApprovalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractApproval.AbstractApprovalBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("approvalVotes")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approvalVotes")
		@Override
		public AbstractApproval.AbstractApprovalBuilder setApprovalVotes(ApprovalVotes _approvalVotes) {
			this.approvalVotes = _approvalVotes == null ? null : _approvalVotes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalApprovalDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalApprovalDate")
		@Override
		public AbstractApproval.AbstractApprovalBuilder setFinalApprovalDate(ZonedDateTime _finalApprovalDate) {
			this.finalApprovalDate = _finalApprovalDate == null ? null : _finalApprovalDate;
			return this;
		}
		
		@Override
		public AbstractApproval build() {
			return new AbstractApproval.AbstractApprovalImpl(this);
		}
		
		@Override
		public AbstractApproval.AbstractApprovalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApproval.AbstractApprovalBuilder prune() {
			if (approvalVotes!=null && !approvalVotes.prune().hasData()) approvalVotes = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getApprovalVotes()!=null && getApprovalVotes().hasData()) return true;
			if (getFinalApprovalDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApproval.AbstractApprovalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractApproval.AbstractApprovalBuilder o = (AbstractApproval.AbstractApprovalBuilder) other;
			
			merger.mergeRosetta(getApprovalVotes(), o.getApprovalVotes(), this::setApprovalVotes);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getFinalApprovalDate(), o.getFinalApprovalDate(), this::setFinalApprovalDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApproval _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(approvalVotes, _that.getApprovalVotes())) return false;
			if (!Objects.equals(finalApprovalDate, _that.getFinalApprovalDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (approvalVotes != null ? approvalVotes.hashCode() : 0);
			_result = 31 * _result + (finalApprovalDate != null ? finalApprovalDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApprovalBuilder {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"approvalVotes=" + this.approvalVotes + ", " +
				"finalApprovalDate=" + this.finalApprovalDate +
			'}';
		}
	}
}
