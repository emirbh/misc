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
import fpml.consolidated.loan.meta.VersionedTaskIdMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Task ID with Version Support
 *
 */
@RosettaDataType(value="VersionedTaskId", builder=VersionedTaskId.VersionedTaskIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VersionedTaskId", model="fpml", builder=VersionedTaskId.VersionedTaskIdBuilderImpl.class, version="2.1.1")
public interface VersionedTaskId extends RosettaModelObject {

	VersionedTaskIdMeta metaData = new VersionedTaskIdMeta();

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
	TaskId getTaskId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version number
	 *
	 */
	Integer getVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optionally it is possible to specify a version effective date when a versionId is supplied.
	 *
	 */
	IdentifiedDate getEffectiveDate();

	/*********************** Build Methods  ***********************/
	VersionedTaskId build();
	
	VersionedTaskId.VersionedTaskIdBuilder toBuilder();
	
	static VersionedTaskId.VersionedTaskIdBuilder builder() {
		return new VersionedTaskId.VersionedTaskIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedTaskId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VersionedTaskId> getType() {
		return VersionedTaskId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("taskId"), processor, TaskId.class, getTaskId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedTaskIdBuilder extends VersionedTaskId, RosettaModelObjectBuilder {
		TaskId.TaskIdBuilder getOrCreateTaskId();
		@Override
		TaskId.TaskIdBuilder getTaskId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionedTaskId.VersionedTaskIdBuilder setTaskId(TaskId taskId);
		VersionedTaskId.VersionedTaskIdBuilder setVersion(Integer version);
		VersionedTaskId.VersionedTaskIdBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taskId"), processor, TaskId.TaskIdBuilder.class, getTaskId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionedTaskId.VersionedTaskIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedTaskId  ***********************/
	class VersionedTaskIdImpl implements VersionedTaskId {
		private final TaskId taskId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionedTaskIdImpl(VersionedTaskId.VersionedTaskIdBuilder builder) {
			this.taskId = ofNullable(builder.getTaskId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taskId")
		public TaskId getTaskId() {
			return taskId;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public VersionedTaskId build() {
			return this;
		}
		
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder toBuilder() {
			VersionedTaskId.VersionedTaskIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedTaskId.VersionedTaskIdBuilder builder) {
			ofNullable(getTaskId()).ifPresent(builder::setTaskId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTaskId _that = getType().cast(o);
		
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTaskId {" +
				"taskId=" + this.taskId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedTaskId  ***********************/
	class VersionedTaskIdBuilderImpl implements VersionedTaskId.VersionedTaskIdBuilder {
	
		protected TaskId.TaskIdBuilder taskId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate.IdentifiedDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("taskId")
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder setTaskId(TaskId _taskId) {
			this.taskId = _taskId == null ? null : _taskId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("version")
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionedTaskId build() {
			return new VersionedTaskId.VersionedTaskIdImpl(this);
		}
		
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder prune() {
			if (taskId!=null && !taskId.prune().hasData()) taskId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaskId()!=null && getTaskId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTaskId.VersionedTaskIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedTaskId.VersionedTaskIdBuilder o = (VersionedTaskId.VersionedTaskIdBuilder) other;
			
			merger.mergeRosetta(getTaskId(), o.getTaskId(), this::setTaskId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTaskId _that = getType().cast(o);
		
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTaskIdBuilder {" +
				"taskId=" + this.taskId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
