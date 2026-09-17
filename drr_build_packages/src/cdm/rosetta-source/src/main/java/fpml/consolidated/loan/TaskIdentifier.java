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
import fpml.consolidated.loan.meta.TaskIdentifierMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a task identifier issued by the indicated party.
 *
 */
@RosettaDataType(value="TaskIdentifier", builder=TaskIdentifier.TaskIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TaskIdentifier", model="fpml", builder=TaskIdentifier.TaskIdentifierBuilderImpl.class, version="2.1.1")
public interface TaskIdentifier extends RosettaModelObject {

	TaskIdentifierMeta metaData = new TaskIdentifierMeta();

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
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the task.
	 *
	 */
	TaskId getTaskId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	VersionedTaskId getVersionedTaskId();

	/*********************** Build Methods  ***********************/
	TaskIdentifier build();
	
	TaskIdentifier.TaskIdentifierBuilder toBuilder();
	
	static TaskIdentifier.TaskIdentifierBuilder builder() {
		return new TaskIdentifier.TaskIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaskIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaskIdentifier> getType() {
		return TaskIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("taskId"), processor, TaskId.class, getTaskId());
		processRosetta(path.newSubPath("versionedTaskId"), processor, VersionedTaskId.class, getVersionedTaskId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaskIdentifierBuilder extends TaskIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		TaskId.TaskIdBuilder getOrCreateTaskId();
		@Override
		TaskId.TaskIdBuilder getTaskId();
		VersionedTaskId.VersionedTaskIdBuilder getOrCreateVersionedTaskId();
		@Override
		VersionedTaskId.VersionedTaskIdBuilder getVersionedTaskId();
		TaskIdentifier.TaskIdentifierBuilder setId(String id);
		TaskIdentifier.TaskIdentifierBuilder setPartyReference(PartyReference partyReference);
		TaskIdentifier.TaskIdentifierBuilder setTaskId(TaskId taskId);
		TaskIdentifier.TaskIdentifierBuilder setVersionedTaskId(VersionedTaskId versionedTaskId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("taskId"), processor, TaskId.TaskIdBuilder.class, getTaskId());
			processRosetta(path.newSubPath("versionedTaskId"), processor, VersionedTaskId.VersionedTaskIdBuilder.class, getVersionedTaskId());
		}
		

		TaskIdentifier.TaskIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of TaskIdentifier  ***********************/
	class TaskIdentifierImpl implements TaskIdentifier {
		private final String id;
		private final PartyReference partyReference;
		private final TaskId taskId;
		private final VersionedTaskId versionedTaskId;
		
		protected TaskIdentifierImpl(TaskIdentifier.TaskIdentifierBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.taskId = ofNullable(builder.getTaskId()).map(f->f.build()).orElse(null);
			this.versionedTaskId = ofNullable(builder.getVersionedTaskId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taskId")
		public TaskId getTaskId() {
			return taskId;
		}
		
		@Override
		@RosettaAttribute("versionedTaskId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionedTaskId")
		public VersionedTaskId getVersionedTaskId() {
			return versionedTaskId;
		}
		
		@Override
		public TaskIdentifier build() {
			return this;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder toBuilder() {
			TaskIdentifier.TaskIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaskIdentifier.TaskIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getTaskId()).ifPresent(builder::setTaskId);
			ofNullable(getVersionedTaskId()).ifPresent(builder::setVersionedTaskId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(versionedTaskId, _that.getVersionedTaskId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (versionedTaskId != null ? versionedTaskId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdentifier {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"taskId=" + this.taskId + ", " +
				"versionedTaskId=" + this.versionedTaskId +
			'}';
		}
	}

	/*********************** Builder Implementation of TaskIdentifier  ***********************/
	class TaskIdentifierBuilderImpl implements TaskIdentifier.TaskIdentifierBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected TaskId.TaskIdBuilder taskId;
		protected VersionedTaskId.VersionedTaskIdBuilder versionedTaskId;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taskId")
		public TaskId.TaskIdBuilder getTaskId() {
			return taskId;
		}
		
		@Override
		public TaskId.TaskIdBuilder getOrCreateTaskId() {
			TaskId.TaskIdBuilder result;
			if (taskId!=null) {
				result = taskId;
			}
			else {
				result = taskId = TaskId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("versionedTaskId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionedTaskId")
		public VersionedTaskId.VersionedTaskIdBuilder getVersionedTaskId() {
			return versionedTaskId;
		}
		
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder getOrCreateVersionedTaskId() {
			VersionedTaskId.VersionedTaskIdBuilder result;
			if (versionedTaskId!=null) {
				result = versionedTaskId;
			}
			else {
				result = versionedTaskId = VersionedTaskId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taskId")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder setTaskId(TaskId _taskId) {
			this.taskId = _taskId == null ? null : _taskId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("versionedTaskId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("versionedTaskId")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder setVersionedTaskId(VersionedTaskId _versionedTaskId) {
			this.versionedTaskId = _versionedTaskId == null ? null : _versionedTaskId.toBuilder();
			return this;
		}
		
		@Override
		public TaskIdentifier build() {
			return new TaskIdentifier.TaskIdentifierImpl(this);
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (taskId!=null && !taskId.prune().hasData()) taskId = null;
			if (versionedTaskId!=null && !versionedTaskId.prune().hasData()) versionedTaskId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getTaskId()!=null && getTaskId().hasData()) return true;
			if (getVersionedTaskId()!=null && getVersionedTaskId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaskIdentifier.TaskIdentifierBuilder o = (TaskIdentifier.TaskIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getTaskId(), o.getTaskId(), this::setTaskId);
			merger.mergeRosetta(getVersionedTaskId(), o.getVersionedTaskId(), this::setVersionedTaskId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(versionedTaskId, _that.getVersionedTaskId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (versionedTaskId != null ? versionedTaskId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"taskId=" + this.taskId + ", " +
				"versionedTaskId=" + this.versionedTaskId +
			'}';
		}
	}
}
