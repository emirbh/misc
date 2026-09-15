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
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.meta.LoanAllocationSettlementTaskMeta;
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
@RosettaDataType(value="LoanAllocationSettlementTask", builder=LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSettlementTask", model="fpml", builder=LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSettlementTask extends AbstractTask {

	LoanAllocationSettlementTaskMeta metaData = new LoanAllocationSettlementTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a unique allocation id used to identify the allocation record.
	 *
	 */
	List<? extends LoanAllocationReference> getAllocationReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the settlement task.
	 *
	 */
	LoanAllocationSettlementTaskType _getType();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementTask build();
	
	LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder();
	
	static LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder() {
		return new LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementTask> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSettlementTask> getType() {
		return LoanAllocationSettlementTask.class;
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
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("type"), processor, LoanAllocationSettlementTaskType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementTaskBuilder extends LoanAllocationSettlementTask, AbstractTask.AbstractTaskBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int index);
		@Override
		List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference();
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder getOrCreateType();
		@Override
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder _getType();
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier, int idx);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier parentTaskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setPreviousTaskIdentifier(TaskIdentifier previousTaskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setDates(TaskDates dates);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setStatus(TaskStatusEnum status);
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setComment(String comment);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(LoanAllocationReference allocationReference, int idx);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setType(LoanAllocationSettlementTaskType type);

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
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("type"), processor, LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder.class, _getType());
		}
		

		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementTask  ***********************/
	class LoanAllocationSettlementTaskImpl extends AbstractTask.AbstractTaskImpl implements LoanAllocationSettlementTask {
		private final List<? extends LoanAllocationReference> allocationReference;
		private final LoanAllocationSettlementTaskType type;
		
		protected LoanAllocationSettlementTaskImpl(LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		public List<? extends LoanAllocationReference> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanAllocationSettlementTaskType _getType() {
			return type;
		}
		
		@Override
		public LoanAllocationSettlementTask build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder() {
			LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
			ofNullable(_getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementTask _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTask {" +
				"allocationReference=" + this.allocationReference + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementTask  ***********************/
	class LoanAllocationSettlementTaskBuilderImpl extends AbstractTask.AbstractTaskBuilderImpl implements LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder {
	
		protected List<LoanAllocationReference.LoanAllocationReferenceBuilder> allocationReference = new ArrayList<>();
		protected LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder type;
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		public List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int index) {
			if (allocationReference==null) {
				this.allocationReference = new ArrayList<>();
			}
			return getIndex(allocationReference, index, () -> {
						LoanAllocationReference.LoanAllocationReferenceBuilder newAllocationReference = LoanAllocationReference.builder();
						return newAllocationReference;
					});
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder getOrCreateType() {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanAllocationSettlementTaskType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier) {
			if (_taskIdentifier != null) {
				this.taskIdentifier.add(_taskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier, int idx) {
			getIndex(this.taskIdentifier, idx, () -> _taskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier _parentTaskIdentifier) {
			this.parentTaskIdentifier = _parentTaskIdentifier == null ? null : _parentTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousTaskIdentifier")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setPreviousTaskIdentifier(TaskIdentifier _previousTaskIdentifier) {
			this.previousTaskIdentifier = _previousTaskIdentifier == null ? null : _previousTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedTaskIdentifier")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier _correctedTaskIdentifier) {
			this.correctedTaskIdentifier = _correctedTaskIdentifier == null ? null : _correctedTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("responsibleParty")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setResponsibleParty(PartyReference _responsibleParty) {
			this.responsibleParty = _responsibleParty == null ? null : _responsibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dates")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setDates(TaskDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setStatus(TaskStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(LoanAllocationReference _allocationReference) {
			if (_allocationReference != null) {
				this.allocationReference.add(_allocationReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(LoanAllocationReference _allocationReference, int idx) {
			getIndex(this.allocationReference, idx, () -> _allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (final LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null) {
				this.allocationReference = new ArrayList<>();
			} else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setType(LoanAllocationSettlementTaskType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask build() {
			return new LoanAllocationSettlementTask.LoanAllocationSettlementTaskImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder prune() {
			super.prune();
			allocationReference = allocationReference.stream().filter(b->b!=null).<LoanAllocationReference.LoanAllocationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder o = (LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::getOrCreateAllocationReference);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementTask _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskBuilder {" +
				"allocationReference=" + this.allocationReference + ", " +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
