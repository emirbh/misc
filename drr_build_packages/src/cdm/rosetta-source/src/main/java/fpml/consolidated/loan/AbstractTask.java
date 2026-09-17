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
import fpml.consolidated.loan.meta.AbstractTaskMeta;
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
 * Provision An underlying abstract structure that defines the responsible party for tasks that must be completed.
 *
 */
@RosettaDataType(value="AbstractTask", builder=AbstractTask.AbstractTaskBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractTask", model="fpml", builder=AbstractTask.AbstractTaskBuilderImpl.class, version="2.1.1")
public interface AbstractTask extends RosettaModelObject {

	AbstractTaskMeta metaData = new AbstractTaskMeta();

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
	List<? extends TaskIdentifier> getTaskIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier used to identify a group of related tasks.
	 *
	 */
	ParentTaskIdentifier getParentTaskIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier associated with a previous ‘inaccurate task.’ Population of this identifier represents that this task is a ‘corrective measure’ to a previous task, rather than being a stand-alone task.
	 *
	 */
	TaskIdentifier getPreviousTaskIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier associated with a previous ‘inaccurate task.’ Population of this identifier represents that this task is a ‘corrective measure’ to a previous task, rather than being a stand-alone task.
	 *
	 */
	TaskIdentifier getCorrectedTaskIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for the completion of the task.
	 *
	 */
	PartyReference getResponsibleParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates relevant to the task.
	 *
	 */
	TaskDates getDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An enum to define the status of the task.
	 *
	 */
	TaskStatusEnum getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to add further details around the task.
	 *
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractTask build();
	
	AbstractTask.AbstractTaskBuilder toBuilder();
	
	static AbstractTask.AbstractTaskBuilder builder() {
		return new AbstractTask.AbstractTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractTask> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractTask> getType() {
		return AbstractTask.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractTaskBuilder extends AbstractTask, RosettaModelObjectBuilder {
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier(int index);
		@Override
		List<? extends TaskIdentifier.TaskIdentifierBuilder> getTaskIdentifier();
		ParentTaskIdentifier.ParentTaskIdentifierBuilder getOrCreateParentTaskIdentifier();
		@Override
		ParentTaskIdentifier.ParentTaskIdentifierBuilder getParentTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreatePreviousTaskIdentifier();
		@Override
		TaskIdentifier.TaskIdentifierBuilder getPreviousTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateCorrectedTaskIdentifier();
		@Override
		TaskIdentifier.TaskIdentifierBuilder getCorrectedTaskIdentifier();
		PartyReference.PartyReferenceBuilder getOrCreateResponsibleParty();
		@Override
		PartyReference.PartyReferenceBuilder getResponsibleParty();
		TaskDates.TaskDatesBuilder getOrCreateDates();
		@Override
		TaskDates.TaskDatesBuilder getDates();
		AbstractTask.AbstractTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier);
		AbstractTask.AbstractTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier, int idx);
		AbstractTask.AbstractTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		AbstractTask.AbstractTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		AbstractTask.AbstractTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier parentTaskIdentifier);
		AbstractTask.AbstractTaskBuilder setPreviousTaskIdentifier(TaskIdentifier previousTaskIdentifier);
		AbstractTask.AbstractTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		AbstractTask.AbstractTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		AbstractTask.AbstractTaskBuilder setDates(TaskDates dates);
		AbstractTask.AbstractTaskBuilder setStatus(TaskStatusEnum status);
		AbstractTask.AbstractTaskBuilder setComment(String comment);

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
		}
		

		AbstractTask.AbstractTaskBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractTask  ***********************/
	class AbstractTaskImpl implements AbstractTask {
		private final List<? extends TaskIdentifier> taskIdentifier;
		private final ParentTaskIdentifier parentTaskIdentifier;
		private final TaskIdentifier previousTaskIdentifier;
		private final TaskIdentifier correctedTaskIdentifier;
		private final PartyReference responsibleParty;
		private final TaskDates dates;
		private final TaskStatusEnum status;
		private final String comment;
		
		protected AbstractTaskImpl(AbstractTask.AbstractTaskBuilder builder) {
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parentTaskIdentifier = ofNullable(builder.getParentTaskIdentifier()).map(f->f.build()).orElse(null);
			this.previousTaskIdentifier = ofNullable(builder.getPreviousTaskIdentifier()).map(f->f.build()).orElse(null);
			this.correctedTaskIdentifier = ofNullable(builder.getCorrectedTaskIdentifier()).map(f->f.build()).orElse(null);
			this.responsibleParty = ofNullable(builder.getResponsibleParty()).map(f->f.build()).orElse(null);
			this.dates = ofNullable(builder.getDates()).map(f->f.build()).orElse(null);
			this.status = builder.getStatus();
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		public List<? extends TaskIdentifier> getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentTaskIdentifier")
		public ParentTaskIdentifier getParentTaskIdentifier() {
			return parentTaskIdentifier;
		}
		
		@Override
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("previousTaskIdentifier")
		public TaskIdentifier getPreviousTaskIdentifier() {
			return previousTaskIdentifier;
		}
		
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correctedTaskIdentifier")
		public TaskIdentifier getCorrectedTaskIdentifier() {
			return correctedTaskIdentifier;
		}
		
		@Override
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("responsibleParty")
		public PartyReference getResponsibleParty() {
			return responsibleParty;
		}
		
		@Override
		@RosettaAttribute("dates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dates")
		public TaskDates getDates() {
			return dates;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public TaskStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractTask build() {
			return this;
		}
		
		@Override
		public AbstractTask.AbstractTaskBuilder toBuilder() {
			AbstractTask.AbstractTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractTask.AbstractTaskBuilder builder) {
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
			ofNullable(getParentTaskIdentifier()).ifPresent(builder::setParentTaskIdentifier);
			ofNullable(getPreviousTaskIdentifier()).ifPresent(builder::setPreviousTaskIdentifier);
			ofNullable(getCorrectedTaskIdentifier()).ifPresent(builder::setCorrectedTaskIdentifier);
			ofNullable(getResponsibleParty()).ifPresent(builder::setResponsibleParty);
			ofNullable(getDates()).ifPresent(builder::setDates);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTask _that = getType().cast(o);
		
			if (!ListEquals.listEquals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(parentTaskIdentifier, _that.getParentTaskIdentifier())) return false;
			if (!Objects.equals(previousTaskIdentifier, _that.getPreviousTaskIdentifier())) return false;
			if (!Objects.equals(correctedTaskIdentifier, _that.getCorrectedTaskIdentifier())) return false;
			if (!Objects.equals(responsibleParty, _that.getResponsibleParty())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentTaskIdentifier != null ? parentTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (previousTaskIdentifier != null ? previousTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedTaskIdentifier != null ? correctedTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (responsibleParty != null ? responsibleParty.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTask {" +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"parentTaskIdentifier=" + this.parentTaskIdentifier + ", " +
				"previousTaskIdentifier=" + this.previousTaskIdentifier + ", " +
				"correctedTaskIdentifier=" + this.correctedTaskIdentifier + ", " +
				"responsibleParty=" + this.responsibleParty + ", " +
				"dates=" + this.dates + ", " +
				"status=" + this.status + ", " +
				"comment=" + this.comment +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractTask  ***********************/
	class AbstractTaskBuilderImpl implements AbstractTask.AbstractTaskBuilder {
	
		protected List<TaskIdentifier.TaskIdentifierBuilder> taskIdentifier = new ArrayList<>();
		protected ParentTaskIdentifier.ParentTaskIdentifierBuilder parentTaskIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder previousTaskIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder correctedTaskIdentifier;
		protected PartyReference.PartyReferenceBuilder responsibleParty;
		protected TaskDates.TaskDatesBuilder dates;
		protected TaskStatusEnum status;
		protected String comment;
		
		@Override
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		public List<? extends TaskIdentifier.TaskIdentifierBuilder> getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier(int index) {
			if (taskIdentifier==null) {
				this.taskIdentifier = new ArrayList<>();
			}
			return getIndex(taskIdentifier, index, () -> {
						TaskIdentifier.TaskIdentifierBuilder newTaskIdentifier = TaskIdentifier.builder();
						return newTaskIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentTaskIdentifier")
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder getParentTaskIdentifier() {
			return parentTaskIdentifier;
		}
		
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder getOrCreateParentTaskIdentifier() {
			ParentTaskIdentifier.ParentTaskIdentifierBuilder result;
			if (parentTaskIdentifier!=null) {
				result = parentTaskIdentifier;
			}
			else {
				result = parentTaskIdentifier = ParentTaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("previousTaskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getPreviousTaskIdentifier() {
			return previousTaskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreatePreviousTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (previousTaskIdentifier!=null) {
				result = previousTaskIdentifier;
			}
			else {
				result = previousTaskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correctedTaskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getCorrectedTaskIdentifier() {
			return correctedTaskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateCorrectedTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (correctedTaskIdentifier!=null) {
				result = correctedTaskIdentifier;
			}
			else {
				result = correctedTaskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("responsibleParty")
		public PartyReference.PartyReferenceBuilder getResponsibleParty() {
			return responsibleParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateResponsibleParty() {
			PartyReference.PartyReferenceBuilder result;
			if (responsibleParty!=null) {
				result = responsibleParty;
			}
			else {
				result = responsibleParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dates")
		public TaskDates.TaskDatesBuilder getDates() {
			return dates;
		}
		
		@Override
		public TaskDates.TaskDatesBuilder getOrCreateDates() {
			TaskDates.TaskDatesBuilder result;
			if (dates!=null) {
				result = dates;
			}
			else {
				result = dates = TaskDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public TaskStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		@Override
		public AbstractTask.AbstractTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier) {
			if (_taskIdentifier != null) {
				this.taskIdentifier.add(_taskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractTask.AbstractTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier, int idx) {
			getIndex(this.taskIdentifier, idx, () -> _taskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractTask.AbstractTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public AbstractTask.AbstractTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public AbstractTask.AbstractTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier _parentTaskIdentifier) {
			this.parentTaskIdentifier = _parentTaskIdentifier == null ? null : _parentTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousTaskIdentifier")
		@Override
		public AbstractTask.AbstractTaskBuilder setPreviousTaskIdentifier(TaskIdentifier _previousTaskIdentifier) {
			this.previousTaskIdentifier = _previousTaskIdentifier == null ? null : _previousTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedTaskIdentifier")
		@Override
		public AbstractTask.AbstractTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier _correctedTaskIdentifier) {
			this.correctedTaskIdentifier = _correctedTaskIdentifier == null ? null : _correctedTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("responsibleParty")
		@Override
		public AbstractTask.AbstractTaskBuilder setResponsibleParty(PartyReference _responsibleParty) {
			this.responsibleParty = _responsibleParty == null ? null : _responsibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dates")
		@Override
		public AbstractTask.AbstractTaskBuilder setDates(TaskDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public AbstractTask.AbstractTaskBuilder setStatus(TaskStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractTask.AbstractTaskBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@Override
		public AbstractTask build() {
			return new AbstractTask.AbstractTaskImpl(this);
		}
		
		@Override
		public AbstractTask.AbstractTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTask.AbstractTaskBuilder prune() {
			taskIdentifier = taskIdentifier.stream().filter(b->b!=null).<TaskIdentifier.TaskIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parentTaskIdentifier!=null && !parentTaskIdentifier.prune().hasData()) parentTaskIdentifier = null;
			if (previousTaskIdentifier!=null && !previousTaskIdentifier.prune().hasData()) previousTaskIdentifier = null;
			if (correctedTaskIdentifier!=null && !correctedTaskIdentifier.prune().hasData()) correctedTaskIdentifier = null;
			if (responsibleParty!=null && !responsibleParty.prune().hasData()) responsibleParty = null;
			if (dates!=null && !dates.prune().hasData()) dates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaskIdentifier()!=null && getTaskIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParentTaskIdentifier()!=null && getParentTaskIdentifier().hasData()) return true;
			if (getPreviousTaskIdentifier()!=null && getPreviousTaskIdentifier().hasData()) return true;
			if (getCorrectedTaskIdentifier()!=null && getCorrectedTaskIdentifier().hasData()) return true;
			if (getResponsibleParty()!=null && getResponsibleParty().hasData()) return true;
			if (getDates()!=null && getDates().hasData()) return true;
			if (getStatus()!=null) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTask.AbstractTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractTask.AbstractTaskBuilder o = (AbstractTask.AbstractTaskBuilder) other;
			
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::getOrCreateTaskIdentifier);
			merger.mergeRosetta(getParentTaskIdentifier(), o.getParentTaskIdentifier(), this::setParentTaskIdentifier);
			merger.mergeRosetta(getPreviousTaskIdentifier(), o.getPreviousTaskIdentifier(), this::setPreviousTaskIdentifier);
			merger.mergeRosetta(getCorrectedTaskIdentifier(), o.getCorrectedTaskIdentifier(), this::setCorrectedTaskIdentifier);
			merger.mergeRosetta(getResponsibleParty(), o.getResponsibleParty(), this::setResponsibleParty);
			merger.mergeRosetta(getDates(), o.getDates(), this::setDates);
			
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTask _that = getType().cast(o);
		
			if (!ListEquals.listEquals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(parentTaskIdentifier, _that.getParentTaskIdentifier())) return false;
			if (!Objects.equals(previousTaskIdentifier, _that.getPreviousTaskIdentifier())) return false;
			if (!Objects.equals(correctedTaskIdentifier, _that.getCorrectedTaskIdentifier())) return false;
			if (!Objects.equals(responsibleParty, _that.getResponsibleParty())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentTaskIdentifier != null ? parentTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (previousTaskIdentifier != null ? previousTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedTaskIdentifier != null ? correctedTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (responsibleParty != null ? responsibleParty.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTaskBuilder {" +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"parentTaskIdentifier=" + this.parentTaskIdentifier + ", " +
				"previousTaskIdentifier=" + this.previousTaskIdentifier + ", " +
				"correctedTaskIdentifier=" + this.correctedTaskIdentifier + ", " +
				"responsibleParty=" + this.responsibleParty + ", " +
				"dates=" + this.dates + ", " +
				"status=" + this.status + ", " +
				"comment=" + this.comment +
			'}';
		}
	}
}
