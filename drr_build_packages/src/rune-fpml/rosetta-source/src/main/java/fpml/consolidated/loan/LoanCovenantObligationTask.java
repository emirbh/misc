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
import fpml.consolidated.loan.meta.LoanCovenantObligationTaskMeta;
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
 * Provision A structure to describe a covenant obligation task.
 *
 */
@RosettaDataType(value="LoanCovenantObligationTask", builder=LoanCovenantObligationTask.LoanCovenantObligationTaskBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationTask", model="fpml", builder=LoanCovenantObligationTask.LoanCovenantObligationTaskBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationTask extends AbstractTask {

	LoanCovenantObligationTaskMeta metaData = new LoanCovenantObligationTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a loan covenant obligation.
	 *
	 */
	LoanCovenantObligationReference getCovenantReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the loan covenant obligation task.
	 *
	 */
	LoanCovenantObligationTaskType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationTask build();
	
	LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder toBuilder();
	
	static LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder builder() {
		return new LoanCovenantObligationTask.LoanCovenantObligationTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationTask> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationTask> getType() {
		return LoanCovenantObligationTask.class;
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
		processRosetta(path.newSubPath("covenantReference"), processor, LoanCovenantObligationReference.class, getCovenantReference());
		processRosetta(path.newSubPath("type"), processor, LoanCovenantObligationTaskType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationTaskBuilder extends LoanCovenantObligationTask, AbstractTask.AbstractTaskBuilder {
		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getOrCreateCovenantReference();
		@Override
		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getCovenantReference();
		LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder getOrCreateType();
		@Override
		LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder _getType();
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(TaskIdentifier taskIdentifier, int idx);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier parentTaskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setPreviousTaskIdentifier(TaskIdentifier previousTaskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setDates(TaskDates dates);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setStatus(TaskStatusEnum status);
		@Override
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setComment(String comment);
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setCovenantReference(LoanCovenantObligationReference covenantReference);
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setType(LoanCovenantObligationTaskType type);
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setDescription(String description);

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
			processRosetta(path.newSubPath("covenantReference"), processor, LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder.class, getCovenantReference());
			processRosetta(path.newSubPath("type"), processor, LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationTask  ***********************/
	class LoanCovenantObligationTaskImpl extends AbstractTask.AbstractTaskImpl implements LoanCovenantObligationTask {
		private final LoanCovenantObligationReference covenantReference;
		private final LoanCovenantObligationTaskType type;
		private final String description;
		
		protected LoanCovenantObligationTaskImpl(LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder builder) {
			super(builder);
			this.covenantReference = ofNullable(builder.getCovenantReference()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("covenantReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantReference")
		public LoanCovenantObligationReference getCovenantReference() {
			return covenantReference;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanCovenantObligationTaskType _getType() {
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
		public LoanCovenantObligationTask build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder toBuilder() {
			LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCovenantReference()).ifPresent(builder::setCovenantReference);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationTask _that = getType().cast(o);
		
			if (!Objects.equals(covenantReference, _that.getCovenantReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (covenantReference != null ? covenantReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTask {" +
				"covenantReference=" + this.covenantReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationTask  ***********************/
	class LoanCovenantObligationTaskBuilderImpl extends AbstractTask.AbstractTaskBuilderImpl implements LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder {
	
		protected LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder covenantReference;
		protected LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder type;
		protected String description;
		
		@Override
		@RosettaAttribute("covenantReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantReference")
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getCovenantReference() {
			return covenantReference;
		}
		
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getOrCreateCovenantReference() {
			LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder result;
			if (covenantReference!=null) {
				result = covenantReference;
			}
			else {
				result = covenantReference = LoanCovenantObligationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder getOrCreateType() {
			LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanCovenantObligationTaskType.builder();
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
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier) {
			if (_taskIdentifier != null) {
				this.taskIdentifier.add(_taskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(TaskIdentifier _taskIdentifier, int idx) {
			getIndex(this.taskIdentifier, idx, () -> _taskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder addTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setTaskIdentifier(List<? extends TaskIdentifier> taskIdentifiers) {
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
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setParentTaskIdentifier(ParentTaskIdentifier _parentTaskIdentifier) {
			this.parentTaskIdentifier = _parentTaskIdentifier == null ? null : _parentTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousTaskIdentifier")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setPreviousTaskIdentifier(TaskIdentifier _previousTaskIdentifier) {
			this.previousTaskIdentifier = _previousTaskIdentifier == null ? null : _previousTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedTaskIdentifier")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier _correctedTaskIdentifier) {
			this.correctedTaskIdentifier = _correctedTaskIdentifier == null ? null : _correctedTaskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("responsibleParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("responsibleParty")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setResponsibleParty(PartyReference _responsibleParty) {
			this.responsibleParty = _responsibleParty == null ? null : _responsibleParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dates")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setDates(TaskDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setStatus(TaskStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("covenantReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("covenantReference")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setCovenantReference(LoanCovenantObligationReference _covenantReference) {
			this.covenantReference = _covenantReference == null ? null : _covenantReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setType(LoanCovenantObligationTaskType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public LoanCovenantObligationTask build() {
			return new LoanCovenantObligationTask.LoanCovenantObligationTaskImpl(this);
		}
		
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder prune() {
			super.prune();
			if (covenantReference!=null && !covenantReference.prune().hasData()) covenantReference = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCovenantReference()!=null && getCovenantReference().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder o = (LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder) other;
			
			merger.mergeRosetta(getCovenantReference(), o.getCovenantReference(), this::setCovenantReference);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationTask _that = getType().cast(o);
		
			if (!Objects.equals(covenantReference, _that.getCovenantReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (covenantReference != null ? covenantReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTaskBuilder {" +
				"covenantReference=" + this.covenantReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
