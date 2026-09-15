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
import fpml.consolidated.loan.meta.ActionApprovalMeta;
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
 * Provision A structure to describe the approval of the action (e.g. a legal action), including votes required for approval and approval deadline.
 *
 */
@RosettaDataType(value="ActionApproval", builder=ActionApproval.ActionApprovalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ActionApproval", model="fpml", builder=ActionApproval.ActionApprovalBuilderImpl.class, version="2.1.1")
public interface ActionApproval extends RosettaModelObject {

	ActionApprovalMeta metaData = new ActionApprovalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the approval requirement. I.e. the number of "for" votes.
	 *
	 */
	VoteQuantity getApprovalRequirement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the eligible and ineligible parties to vote on the action (e.g. a legal action).
	 *
	 */
	ApprovalParties getApprovalParties();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Approval deadline.
	 *
	 */
	ZonedDateTime getApprovalDeadlineDate();

	/*********************** Build Methods  ***********************/
	ActionApproval build();
	
	ActionApproval.ActionApprovalBuilder toBuilder();
	
	static ActionApproval.ActionApprovalBuilder builder() {
		return new ActionApproval.ActionApprovalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActionApproval> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActionApproval> getType() {
		return ActionApproval.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("approvalRequirement"), processor, VoteQuantity.class, getApprovalRequirement());
		processRosetta(path.newSubPath("approvalParties"), processor, ApprovalParties.class, getApprovalParties());
		processor.processBasic(path.newSubPath("approvalDeadlineDate"), ZonedDateTime.class, getApprovalDeadlineDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActionApprovalBuilder extends ActionApproval, RosettaModelObjectBuilder {
		VoteQuantity.VoteQuantityBuilder getOrCreateApprovalRequirement();
		@Override
		VoteQuantity.VoteQuantityBuilder getApprovalRequirement();
		ApprovalParties.ApprovalPartiesBuilder getOrCreateApprovalParties();
		@Override
		ApprovalParties.ApprovalPartiesBuilder getApprovalParties();
		ActionApproval.ActionApprovalBuilder setApprovalRequirement(VoteQuantity approvalRequirement);
		ActionApproval.ActionApprovalBuilder setApprovalParties(ApprovalParties approvalParties);
		ActionApproval.ActionApprovalBuilder setApprovalDeadlineDate(ZonedDateTime approvalDeadlineDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("approvalRequirement"), processor, VoteQuantity.VoteQuantityBuilder.class, getApprovalRequirement());
			processRosetta(path.newSubPath("approvalParties"), processor, ApprovalParties.ApprovalPartiesBuilder.class, getApprovalParties());
			processor.processBasic(path.newSubPath("approvalDeadlineDate"), ZonedDateTime.class, getApprovalDeadlineDate(), this);
		}
		

		ActionApproval.ActionApprovalBuilder prune();
	}

	/*********************** Immutable Implementation of ActionApproval  ***********************/
	class ActionApprovalImpl implements ActionApproval {
		private final VoteQuantity approvalRequirement;
		private final ApprovalParties approvalParties;
		private final ZonedDateTime approvalDeadlineDate;
		
		protected ActionApprovalImpl(ActionApproval.ActionApprovalBuilder builder) {
			this.approvalRequirement = ofNullable(builder.getApprovalRequirement()).map(f->f.build()).orElse(null);
			this.approvalParties = ofNullable(builder.getApprovalParties()).map(f->f.build()).orElse(null);
			this.approvalDeadlineDate = builder.getApprovalDeadlineDate();
		}
		
		@Override
		@RosettaAttribute("approvalRequirement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalRequirement")
		public VoteQuantity getApprovalRequirement() {
			return approvalRequirement;
		}
		
		@Override
		@RosettaAttribute("approvalParties")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvalParties")
		public ApprovalParties getApprovalParties() {
			return approvalParties;
		}
		
		@Override
		@RosettaAttribute("approvalDeadlineDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalDeadlineDate")
		public ZonedDateTime getApprovalDeadlineDate() {
			return approvalDeadlineDate;
		}
		
		@Override
		public ActionApproval build() {
			return this;
		}
		
		@Override
		public ActionApproval.ActionApprovalBuilder toBuilder() {
			ActionApproval.ActionApprovalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActionApproval.ActionApprovalBuilder builder) {
			ofNullable(getApprovalRequirement()).ifPresent(builder::setApprovalRequirement);
			ofNullable(getApprovalParties()).ifPresent(builder::setApprovalParties);
			ofNullable(getApprovalDeadlineDate()).ifPresent(builder::setApprovalDeadlineDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionApproval _that = getType().cast(o);
		
			if (!Objects.equals(approvalRequirement, _that.getApprovalRequirement())) return false;
			if (!Objects.equals(approvalParties, _that.getApprovalParties())) return false;
			if (!Objects.equals(approvalDeadlineDate, _that.getApprovalDeadlineDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approvalRequirement != null ? approvalRequirement.hashCode() : 0);
			_result = 31 * _result + (approvalParties != null ? approvalParties.hashCode() : 0);
			_result = 31 * _result + (approvalDeadlineDate != null ? approvalDeadlineDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionApproval {" +
				"approvalRequirement=" + this.approvalRequirement + ", " +
				"approvalParties=" + this.approvalParties + ", " +
				"approvalDeadlineDate=" + this.approvalDeadlineDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ActionApproval  ***********************/
	class ActionApprovalBuilderImpl implements ActionApproval.ActionApprovalBuilder {
	
		protected VoteQuantity.VoteQuantityBuilder approvalRequirement;
		protected ApprovalParties.ApprovalPartiesBuilder approvalParties;
		protected ZonedDateTime approvalDeadlineDate;
		
		@Override
		@RosettaAttribute("approvalRequirement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalRequirement")
		public VoteQuantity.VoteQuantityBuilder getApprovalRequirement() {
			return approvalRequirement;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder getOrCreateApprovalRequirement() {
			VoteQuantity.VoteQuantityBuilder result;
			if (approvalRequirement!=null) {
				result = approvalRequirement;
			}
			else {
				result = approvalRequirement = VoteQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvalParties")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvalParties")
		public ApprovalParties.ApprovalPartiesBuilder getApprovalParties() {
			return approvalParties;
		}
		
		@Override
		public ApprovalParties.ApprovalPartiesBuilder getOrCreateApprovalParties() {
			ApprovalParties.ApprovalPartiesBuilder result;
			if (approvalParties!=null) {
				result = approvalParties;
			}
			else {
				result = approvalParties = ApprovalParties.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvalDeadlineDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvalDeadlineDate")
		public ZonedDateTime getApprovalDeadlineDate() {
			return approvalDeadlineDate;
		}
		
		@RosettaAttribute("approvalRequirement")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approvalRequirement")
		@Override
		public ActionApproval.ActionApprovalBuilder setApprovalRequirement(VoteQuantity _approvalRequirement) {
			this.approvalRequirement = _approvalRequirement == null ? null : _approvalRequirement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvalParties")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvalParties")
		@Override
		public ActionApproval.ActionApprovalBuilder setApprovalParties(ApprovalParties _approvalParties) {
			this.approvalParties = _approvalParties == null ? null : _approvalParties.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvalDeadlineDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approvalDeadlineDate")
		@Override
		public ActionApproval.ActionApprovalBuilder setApprovalDeadlineDate(ZonedDateTime _approvalDeadlineDate) {
			this.approvalDeadlineDate = _approvalDeadlineDate == null ? null : _approvalDeadlineDate;
			return this;
		}
		
		@Override
		public ActionApproval build() {
			return new ActionApproval.ActionApprovalImpl(this);
		}
		
		@Override
		public ActionApproval.ActionApprovalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionApproval.ActionApprovalBuilder prune() {
			if (approvalRequirement!=null && !approvalRequirement.prune().hasData()) approvalRequirement = null;
			if (approvalParties!=null && !approvalParties.prune().hasData()) approvalParties = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApprovalRequirement()!=null && getApprovalRequirement().hasData()) return true;
			if (getApprovalParties()!=null && getApprovalParties().hasData()) return true;
			if (getApprovalDeadlineDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionApproval.ActionApprovalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActionApproval.ActionApprovalBuilder o = (ActionApproval.ActionApprovalBuilder) other;
			
			merger.mergeRosetta(getApprovalRequirement(), o.getApprovalRequirement(), this::setApprovalRequirement);
			merger.mergeRosetta(getApprovalParties(), o.getApprovalParties(), this::setApprovalParties);
			
			merger.mergeBasic(getApprovalDeadlineDate(), o.getApprovalDeadlineDate(), this::setApprovalDeadlineDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionApproval _that = getType().cast(o);
		
			if (!Objects.equals(approvalRequirement, _that.getApprovalRequirement())) return false;
			if (!Objects.equals(approvalParties, _that.getApprovalParties())) return false;
			if (!Objects.equals(approvalDeadlineDate, _that.getApprovalDeadlineDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approvalRequirement != null ? approvalRequirement.hashCode() : 0);
			_result = 31 * _result + (approvalParties != null ? approvalParties.hashCode() : 0);
			_result = 31 * _result + (approvalDeadlineDate != null ? approvalDeadlineDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionApprovalBuilder {" +
				"approvalRequirement=" + this.approvalRequirement + ", " +
				"approvalParties=" + this.approvalParties + ", " +
				"approvalDeadlineDate=" + this.approvalDeadlineDate +
			'}';
		}
	}
}
