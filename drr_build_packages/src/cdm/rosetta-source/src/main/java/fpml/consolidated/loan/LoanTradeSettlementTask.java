package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.meta.LoanTradeSettlementTaskMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A structure that details tasks and their statuses, the completion of which are prerequisites to the settlement of a trade or allocation.
 *
 */
@RosettaDataType(value="LoanTradeSettlementTask", builder=LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeSettlementTask", model="fpml", builder=LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl.class, version="2.1.1")
public interface LoanTradeSettlementTask extends AbstractTask {

	LoanTradeSettlementTaskMeta metaData = new LoanTradeSettlementTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the master trade.
	 *
	 */
	LoanTradeReference getLoanTradeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the settlement task.
	 *
	 */
	LoanTradeSettlementTaskType _getType();

	/*********************** Build Methods  ***********************/
	LoanTradeSettlementTask build();
	
	LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder();
	
	static LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder() {
		return new LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSettlementTask> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeSettlementTask> getType() {
		return LoanTradeSettlementTask.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
		processRosetta(path.newSubPath("parentTaskIdentifier"), processor, ParentTaskIdentifier.class, getParentTaskIdentifier());
		processRosetta(path.newSubPath("previousTaskIdentifier"), processor, TaskIdentifier.class, getPreviousTaskIdentifier());
		processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.class, getCorrectedTaskIdentifier());
		processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.class, getResponsibleParty());
		processRosetta(path.newSubPath("dates"), processor, TaskDates.class, getDates());
		processor.processBasic(path.newSubPath("status"), TaskStatusEnum.class, getStatus(), this);
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("type"), processor, LoanTradeSettlementTaskType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSettlementTaskBuilder extends LoanTradeSettlementTask, AbstractTask.AbstractTaskBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		@Override
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder getOrCreateType();
		@Override
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder _getType();
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier, int idx);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier parentTaskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setPreviousTaskIdentifier(TaskIdentifier previousTaskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setDates(TaskDates dates);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setStatus(TaskStatusEnum status);
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setComment(String comment);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setType(LoanTradeSettlementTaskType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("parentTaskIdentifier"), processor, ParentTaskIdentifier.ParentTaskIdentifierBuilder.class, getParentTaskIdentifier());
			processRosetta(path.newSubPath("previousTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getPreviousTaskIdentifier());
			processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getCorrectedTaskIdentifier());
			processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getResponsibleParty());
			processRosetta(path.newSubPath("dates"), processor, TaskDates.TaskDatesBuilder.class, getDates());
			processor.processBasic(path.newSubPath("status"), TaskStatusEnum.class, getStatus(), this);
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("type"), processor, LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder.class, _getType());
		}
		

		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSettlementTask  ***********************/
	class LoanTradeSettlementTaskImpl extends AbstractTask.AbstractTaskImpl implements LoanTradeSettlementTask {
		private final LoanTradeReference loanTradeReference;
		private final LoanTradeSettlementTaskType type;
		
		protected LoanTradeSettlementTaskImpl(LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanTradeSettlementTaskType _getType() {
			return type;
		}
		
		@Override
		public LoanTradeSettlementTask build() {
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder() {
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
			ofNullable(_getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTask {" +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeSettlementTask  ***********************/
	class LoanTradeSettlementTaskBuilderImpl extends AbstractTask.AbstractTaskBuilderImpl implements LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
		protected LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder type;
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder getOrCreateType() {
			LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanTradeSettlementTaskType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier) {
			if (_taskIdentifier != null) {
				this.taskIdentifier.add(_taskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier, int idx) {
			getIndex(this.taskIdentifier, idx, () -> _taskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
			if (taskIdentifiers != null) {
				for (final TaskIdentifier toAdd : taskIdentifiers) {
					this.taskIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
			if (taskIdentifiers == null) {
				this.taskIdentifier = new ArrayList<>();
			} else {
				this.taskIdentifier = taskIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentTaskIdentifier")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier _parentTaskIdentifier) {
			this.parentTaskIdentifier = _parentTaskIdentifier == null ? null : _parentTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousTaskIdentifier")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setPreviousTaskIdentifier(TaskIdentifier _previousTaskIdentifier) {
			this.previousTaskIdentifier = _previousTaskIdentifier == null ? null : _previousTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedTaskIdentifier")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier _correctedTaskIdentifier) {
			this.correctedTaskIdentifier = _correctedTaskIdentifier == null ? null : _correctedTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("responsibleParty")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setResponsibleParty(PartyReference _responsibleParty) {
			this.responsibleParty = _responsibleParty == null ? null : _responsibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dates")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setDates(TaskDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setStatus(TaskStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setType(LoanTradeSettlementTaskType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask build() {
			return new LoanTradeSettlementTask.LoanTradeSettlementTaskImpl(this);
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder o = (LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskBuilder {" +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
