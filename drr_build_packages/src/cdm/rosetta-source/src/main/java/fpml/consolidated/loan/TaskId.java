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
import fpml.consolidated.loan.meta.TaskIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines a task identifier based on a qualifying scheme.
 *
 */
@RosettaDataType(value="TaskId", builder=TaskId.TaskIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TaskId", model="fpml", builder=TaskId.TaskIdBuilderImpl.class, version="2.1.1")
public interface TaskId extends RosettaModelObject {

	TaskIdMeta metaData = new TaskIdMeta();

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
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getTaskIdScheme();
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

	/*********************** Build Methods  ***********************/
	TaskId build();
	
	TaskId.TaskIdBuilder toBuilder();
	
	static TaskId.TaskIdBuilder builder() {
		return new TaskId.TaskIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaskId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaskId> getType() {
		return TaskId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("taskIdScheme"), String.class, getTaskIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaskIdBuilder extends TaskId, RosettaModelObjectBuilder {
		TaskId.TaskIdBuilder setValue(String value);
		TaskId.TaskIdBuilder setTaskIdScheme(String taskIdScheme);
		TaskId.TaskIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("taskIdScheme"), String.class, getTaskIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TaskId.TaskIdBuilder prune();
	}

	/*********************** Immutable Implementation of TaskId  ***********************/
	class TaskIdImpl implements TaskId {
		private final String value;
		private final String taskIdScheme;
		private final String id;
		
		protected TaskIdImpl(TaskId.TaskIdBuilder builder) {
			this.value = builder.getValue();
			this.taskIdScheme = builder.getTaskIdScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taskIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taskIdScheme")
		public String getTaskIdScheme() {
			return taskIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TaskId build() {
			return this;
		}
		
		@Override
		public TaskId.TaskIdBuilder toBuilder() {
			TaskId.TaskIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaskId.TaskIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTaskIdScheme()).ifPresent(builder::setTaskIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taskIdScheme, _that.getTaskIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taskIdScheme != null ? taskIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskId {" +
				"value=" + this.value + ", " +
				"taskIdScheme=" + this.taskIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TaskId  ***********************/
	class TaskIdBuilderImpl implements TaskId.TaskIdBuilder {
	
		protected String value;
		protected String taskIdScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taskIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taskIdScheme")
		public String getTaskIdScheme() {
			return taskIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public TaskId.TaskIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("taskIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("taskIdScheme")
		@Override
		public TaskId.TaskIdBuilder setTaskIdScheme(String _taskIdScheme) {
			this.taskIdScheme = _taskIdScheme == null ? null : _taskIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TaskId.TaskIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public TaskId build() {
			return new TaskId.TaskIdImpl(this);
		}
		
		@Override
		public TaskId.TaskIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskId.TaskIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTaskIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskId.TaskIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaskId.TaskIdBuilder o = (TaskId.TaskIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTaskIdScheme(), o.getTaskIdScheme(), this::setTaskIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taskIdScheme, _that.getTaskIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taskIdScheme != null ? taskIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdBuilder {" +
				"value=" + this.value + ", " +
				"taskIdScheme=" + this.taskIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
