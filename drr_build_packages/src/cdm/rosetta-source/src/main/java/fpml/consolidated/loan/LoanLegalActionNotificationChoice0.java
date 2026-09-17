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
import fpml.consolidated.loan.meta.LoanLegalActionNotificationChoice0Meta;
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
@RosettaDataType(value="LoanLegalActionNotificationChoice0", builder=LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionNotificationChoice0", model="fpml", builder=LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionNotificationChoice0 extends RosettaModelObject {

	LoanLegalActionNotificationChoice0Meta metaData = new LoanLegalActionNotificationChoice0Meta();

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
	AbstractFacilityEvent getFacilityEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractLcEvent getLcEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractLoanServicingEvent getLoanContractEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that details tasks and their statuses, the completion of which are prerequisites to a legal action.
	 *
	 */
	LoanLegalActionTask getLegalActionTask();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the overall status of the loan legal action.
	 *
	 */
	LoanLegalActionStatus getLegalActionStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that provides global level approval status on a legal action.
	 *
	 */
	LoanLegalActionApprovalStatus getLegalActionApprovalStatus();

	/*********************** Build Methods  ***********************/
	LoanLegalActionNotificationChoice0 build();
	
	LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder toBuilder();
	
	static LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder builder() {
		return new LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionNotificationChoice0> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionNotificationChoice0> getType() {
		return LoanLegalActionNotificationChoice0.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.class, getFacilityEventGroup());
		processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.class, getLcEventGroup());
		processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.class, getLoanContractEventGroup());
		processRosetta(path.newSubPath("legalActionTask"), processor, LoanLegalActionTask.class, getLegalActionTask());
		processRosetta(path.newSubPath("legalActionStatus"), processor, LoanLegalActionStatus.class, getLegalActionStatus());
		processRosetta(path.newSubPath("legalActionApprovalStatus"), processor, LoanLegalActionApprovalStatus.class, getLegalActionApprovalStatus());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionNotificationChoice0Builder extends LoanLegalActionNotificationChoice0, RosettaModelObjectBuilder {
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup();
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup();
		AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup();
		@Override
		AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup();
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup();
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup();
		LoanLegalActionTask.LoanLegalActionTaskBuilder getOrCreateLegalActionTask();
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder getLegalActionTask();
		LoanLegalActionStatus.LoanLegalActionStatusBuilder getOrCreateLegalActionStatus();
		@Override
		LoanLegalActionStatus.LoanLegalActionStatusBuilder getLegalActionStatus();
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder getOrCreateLegalActionApprovalStatus();
		@Override
		LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder getLegalActionApprovalStatus();
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup);
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLcEventGroup(AbstractLcEvent lcEventGroup);
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLoanContractEventGroup(AbstractLoanServicingEvent loanContractEventGroup);
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionTask(LoanLegalActionTask legalActionTask);
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionStatus(LoanLegalActionStatus legalActionStatus);
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionApprovalStatus(LoanLegalActionApprovalStatus legalActionApprovalStatus);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getFacilityEventGroup());
			processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.AbstractLcEventBuilder.class, getLcEventGroup());
			processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder.class, getLoanContractEventGroup());
			processRosetta(path.newSubPath("legalActionTask"), processor, LoanLegalActionTask.LoanLegalActionTaskBuilder.class, getLegalActionTask());
			processRosetta(path.newSubPath("legalActionStatus"), processor, LoanLegalActionStatus.LoanLegalActionStatusBuilder.class, getLegalActionStatus());
			processRosetta(path.newSubPath("legalActionApprovalStatus"), processor, LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder.class, getLegalActionApprovalStatus());
		}
		

		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionNotificationChoice0  ***********************/
	class LoanLegalActionNotificationChoice0Impl implements LoanLegalActionNotificationChoice0 {
		private final AbstractFacilityEvent facilityEventGroup;
		private final AbstractLcEvent lcEventGroup;
		private final AbstractLoanServicingEvent loanContractEventGroup;
		private final LoanLegalActionTask legalActionTask;
		private final LoanLegalActionStatus legalActionStatus;
		private final LoanLegalActionApprovalStatus legalActionApprovalStatus;
		
		protected LoanLegalActionNotificationChoice0Impl(LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder builder) {
			this.facilityEventGroup = ofNullable(builder.getFacilityEventGroup()).map(f->f.build()).orElse(null);
			this.lcEventGroup = ofNullable(builder.getLcEventGroup()).map(f->f.build()).orElse(null);
			this.loanContractEventGroup = ofNullable(builder.getLoanContractEventGroup()).map(f->f.build()).orElse(null);
			this.legalActionTask = ofNullable(builder.getLegalActionTask()).map(f->f.build()).orElse(null);
			this.legalActionStatus = ofNullable(builder.getLegalActionStatus()).map(f->f.build()).orElse(null);
			this.legalActionApprovalStatus = ofNullable(builder.getLegalActionApprovalStatus()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		@RosettaAttribute("legalActionTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionTask")
		public LoanLegalActionTask getLegalActionTask() {
			return legalActionTask;
		}
		
		@Override
		@RosettaAttribute("legalActionStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionStatus")
		public LoanLegalActionStatus getLegalActionStatus() {
			return legalActionStatus;
		}
		
		@Override
		@RosettaAttribute("legalActionApprovalStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionApprovalStatus")
		public LoanLegalActionApprovalStatus getLegalActionApprovalStatus() {
			return legalActionApprovalStatus;
		}
		
		@Override
		public LoanLegalActionNotificationChoice0 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder toBuilder() {
			LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder builder) {
			ofNullable(getFacilityEventGroup()).ifPresent(builder::setFacilityEventGroup);
			ofNullable(getLcEventGroup()).ifPresent(builder::setLcEventGroup);
			ofNullable(getLoanContractEventGroup()).ifPresent(builder::setLoanContractEventGroup);
			ofNullable(getLegalActionTask()).ifPresent(builder::setLegalActionTask);
			ofNullable(getLegalActionStatus()).ifPresent(builder::setLegalActionStatus);
			ofNullable(getLegalActionApprovalStatus()).ifPresent(builder::setLegalActionApprovalStatus);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(legalActionTask, _that.getLegalActionTask())) return false;
			if (!Objects.equals(legalActionStatus, _that.getLegalActionStatus())) return false;
			if (!Objects.equals(legalActionApprovalStatus, _that.getLegalActionApprovalStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (legalActionTask != null ? legalActionTask.hashCode() : 0);
			_result = 31 * _result + (legalActionStatus != null ? legalActionStatus.hashCode() : 0);
			_result = 31 * _result + (legalActionApprovalStatus != null ? legalActionApprovalStatus.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoice0 {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"legalActionTask=" + this.legalActionTask + ", " +
				"legalActionStatus=" + this.legalActionStatus + ", " +
				"legalActionApprovalStatus=" + this.legalActionApprovalStatus +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionNotificationChoice0  ***********************/
	class LoanLegalActionNotificationChoice0BuilderImpl implements LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder {
	
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder facilityEventGroup;
		protected AbstractLcEvent.AbstractLcEventBuilder lcEventGroup;
		protected AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder loanContractEventGroup;
		protected LoanLegalActionTask.LoanLegalActionTaskBuilder legalActionTask;
		protected LoanLegalActionStatus.LoanLegalActionStatusBuilder legalActionStatus;
		protected LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder legalActionApprovalStatus;
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (facilityEventGroup!=null) {
				result = facilityEventGroup;
			}
			else {
				result = facilityEventGroup = AbstractFacilityEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup() {
			AbstractLcEvent.AbstractLcEventBuilder result;
			if (lcEventGroup!=null) {
				result = lcEventGroup;
			}
			else {
				result = lcEventGroup = AbstractLcEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup() {
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder result;
			if (loanContractEventGroup!=null) {
				result = loanContractEventGroup;
			}
			else {
				result = loanContractEventGroup = AbstractLoanServicingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legalActionTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionTask")
		public LoanLegalActionTask.LoanLegalActionTaskBuilder getLegalActionTask() {
			return legalActionTask;
		}
		
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder getOrCreateLegalActionTask() {
			LoanLegalActionTask.LoanLegalActionTaskBuilder result;
			if (legalActionTask!=null) {
				result = legalActionTask;
			}
			else {
				result = legalActionTask = LoanLegalActionTask.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legalActionStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionStatus")
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder getLegalActionStatus() {
			return legalActionStatus;
		}
		
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder getOrCreateLegalActionStatus() {
			LoanLegalActionStatus.LoanLegalActionStatusBuilder result;
			if (legalActionStatus!=null) {
				result = legalActionStatus;
			}
			else {
				result = legalActionStatus = LoanLegalActionStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legalActionApprovalStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionApprovalStatus")
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder getLegalActionApprovalStatus() {
			return legalActionApprovalStatus;
		}
		
		@Override
		public LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder getOrCreateLegalActionApprovalStatus() {
			LoanLegalActionApprovalStatus.LoanLegalActionApprovalStatusBuilder result;
			if (legalActionApprovalStatus!=null) {
				result = legalActionApprovalStatus;
			}
			else {
				result = legalActionApprovalStatus = LoanLegalActionApprovalStatus.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityEventGroup")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setFacilityEventGroup(AbstractFacilityEvent _facilityEventGroup) {
			this.facilityEventGroup = _facilityEventGroup == null ? null : _facilityEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcEventGroup")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLcEventGroup(AbstractLcEvent _lcEventGroup) {
			this.lcEventGroup = _lcEventGroup == null ? null : _lcEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanContractEventGroup")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLoanContractEventGroup(AbstractLoanServicingEvent _loanContractEventGroup) {
			this.loanContractEventGroup = _loanContractEventGroup == null ? null : _loanContractEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionTask")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionTask")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionTask(LoanLegalActionTask _legalActionTask) {
			this.legalActionTask = _legalActionTask == null ? null : _legalActionTask.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionStatus")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionStatus(LoanLegalActionStatus _legalActionStatus) {
			this.legalActionStatus = _legalActionStatus == null ? null : _legalActionStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionApprovalStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionApprovalStatus")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder setLegalActionApprovalStatus(LoanLegalActionApprovalStatus _legalActionApprovalStatus) {
			this.legalActionApprovalStatus = _legalActionApprovalStatus == null ? null : _legalActionApprovalStatus.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice0 build() {
			return new LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Impl(this);
		}
		
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder prune() {
			if (facilityEventGroup!=null && !facilityEventGroup.prune().hasData()) facilityEventGroup = null;
			if (lcEventGroup!=null && !lcEventGroup.prune().hasData()) lcEventGroup = null;
			if (loanContractEventGroup!=null && !loanContractEventGroup.prune().hasData()) loanContractEventGroup = null;
			if (legalActionTask!=null && !legalActionTask.prune().hasData()) legalActionTask = null;
			if (legalActionStatus!=null && !legalActionStatus.prune().hasData()) legalActionStatus = null;
			if (legalActionApprovalStatus!=null && !legalActionApprovalStatus.prune().hasData()) legalActionApprovalStatus = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityEventGroup()!=null && getFacilityEventGroup().hasData()) return true;
			if (getLcEventGroup()!=null && getLcEventGroup().hasData()) return true;
			if (getLoanContractEventGroup()!=null && getLoanContractEventGroup().hasData()) return true;
			if (getLegalActionTask()!=null && getLegalActionTask().hasData()) return true;
			if (getLegalActionStatus()!=null && getLegalActionStatus().hasData()) return true;
			if (getLegalActionApprovalStatus()!=null && getLegalActionApprovalStatus().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder o = (LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder) other;
			
			merger.mergeRosetta(getFacilityEventGroup(), o.getFacilityEventGroup(), this::setFacilityEventGroup);
			merger.mergeRosetta(getLcEventGroup(), o.getLcEventGroup(), this::setLcEventGroup);
			merger.mergeRosetta(getLoanContractEventGroup(), o.getLoanContractEventGroup(), this::setLoanContractEventGroup);
			merger.mergeRosetta(getLegalActionTask(), o.getLegalActionTask(), this::setLegalActionTask);
			merger.mergeRosetta(getLegalActionStatus(), o.getLegalActionStatus(), this::setLegalActionStatus);
			merger.mergeRosetta(getLegalActionApprovalStatus(), o.getLegalActionApprovalStatus(), this::setLegalActionApprovalStatus);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(legalActionTask, _that.getLegalActionTask())) return false;
			if (!Objects.equals(legalActionStatus, _that.getLegalActionStatus())) return false;
			if (!Objects.equals(legalActionApprovalStatus, _that.getLegalActionApprovalStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (legalActionTask != null ? legalActionTask.hashCode() : 0);
			_result = 31 * _result + (legalActionStatus != null ? legalActionStatus.hashCode() : 0);
			_result = 31 * _result + (legalActionApprovalStatus != null ? legalActionApprovalStatus.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoice0Builder {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"legalActionTask=" + this.legalActionTask + ", " +
				"legalActionStatus=" + this.legalActionStatus + ", " +
				"legalActionApprovalStatus=" + this.legalActionApprovalStatus +
			'}';
		}
	}
}
