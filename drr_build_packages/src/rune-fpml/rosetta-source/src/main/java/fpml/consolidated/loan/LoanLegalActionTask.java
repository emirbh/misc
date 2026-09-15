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
import fpml.consolidated.loan.meta.LoanLegalActionTaskMeta;
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
 * Provision A structure that details tasks and their statuses, the completion of which are prerequisites to a legal action.
 *
 */
@RosettaDataType(value="LoanLegalActionTask", builder=LoanLegalActionTask.LoanLegalActionTaskBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionTask", model="fpml", builder=LoanLegalActionTask.LoanLegalActionTaskBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionTask extends AbstractTask {

	LoanLegalActionTaskMeta metaData = new LoanLegalActionTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a legal action.
	 *
	 */
	LoanLegalActionReference getLegalActionReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the legal action task.
	 *
	 */
	LoanLegalActionTaskType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A free form field to provide addition description of the legal action task.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	LoanLegalActionTask build();
	
	LoanLegalActionTask.LoanLegalActionTaskBuilder toBuilder();
	
	static LoanLegalActionTask.LoanLegalActionTaskBuilder builder() {
		return new LoanLegalActionTask.LoanLegalActionTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionTask> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionTask> getType() {
		return LoanLegalActionTask.class;
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
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("type"), processor, LoanLegalActionTaskType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionTaskBuilder extends LoanLegalActionTask, AbstractTask.AbstractTaskBuilder {
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference();
		@Override
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference();
		LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder getOrCreateType();
		@Override
		LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder _getType();
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier, int idx);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier parentTaskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setPreviousTaskIdentifier(TaskIdentifier previousTaskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setDates(TaskDates dates);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setStatus(TaskStatusEnum status);
		@Override
		LoanLegalActionTask.LoanLegalActionTaskBuilder setComment(String comment);
		LoanLegalActionTask.LoanLegalActionTaskBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		LoanLegalActionTask.LoanLegalActionTaskBuilder setType(LoanLegalActionTaskType type);
		LoanLegalActionTask.LoanLegalActionTaskBuilder setDescription(String description);

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
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("type"), processor, LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		LoanLegalActionTask.LoanLegalActionTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionTask  ***********************/
	class LoanLegalActionTaskImpl extends AbstractTask.AbstractTaskImpl implements LoanLegalActionTask {
		private final LoanLegalActionReference legalActionReference;
		private final LoanLegalActionTaskType type;
		private final String description;
		
		protected LoanLegalActionTaskImpl(LoanLegalActionTask.LoanLegalActionTaskBuilder builder) {
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
		public LoanLegalActionTaskType _getType() {
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
		public LoanLegalActionTask build() {
			return this;
		}
		
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder toBuilder() {
			LoanLegalActionTask.LoanLegalActionTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionTask.LoanLegalActionTaskBuilder builder) {
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
		
			LoanLegalActionTask _that = getType().cast(o);
		
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
			return "LoanLegalActionTask {" +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionTask  ***********************/
	class LoanLegalActionTaskBuilderImpl extends AbstractTask.AbstractTaskBuilderImpl implements LoanLegalActionTask.LoanLegalActionTaskBuilder {
	
		protected LoanLegalActionReference.LoanLegalActionReferenceBuilder legalActionReference;
		protected LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder type;
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
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder getOrCreateType() {
			LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanLegalActionTaskType.builder();
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
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier) {
			if (_taskIdentifier != null) {
				this.taskIdentifier.add(_taskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier, int idx) {
			getIndex(this.taskIdentifier, idx, () -> _taskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier _parentTaskIdentifier) {
			this.parentTaskIdentifier = _parentTaskIdentifier == null ? null : _parentTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousTaskIdentifier")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setPreviousTaskIdentifier(TaskIdentifier _previousTaskIdentifier) {
			this.previousTaskIdentifier = _previousTaskIdentifier == null ? null : _previousTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedTaskIdentifier")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier _correctedTaskIdentifier) {
			this.correctedTaskIdentifier = _correctedTaskIdentifier == null ? null : _correctedTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("responsibleParty")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setResponsibleParty(PartyReference _responsibleParty) {
			this.responsibleParty = _responsibleParty == null ? null : _responsibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dates")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setDates(TaskDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setStatus(TaskStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionReference")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setType(LoanLegalActionTaskType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public LoanLegalActionTask build() {
			return new LoanLegalActionTask.LoanLegalActionTaskImpl(this);
		}
		
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionTask.LoanLegalActionTaskBuilder prune() {
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
		public LoanLegalActionTask.LoanLegalActionTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionTask.LoanLegalActionTaskBuilder o = (LoanLegalActionTask.LoanLegalActionTaskBuilder) other;
			
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
		
			LoanLegalActionTask _that = getType().cast(o);
		
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
			return "LoanLegalActionTaskBuilder {" +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
