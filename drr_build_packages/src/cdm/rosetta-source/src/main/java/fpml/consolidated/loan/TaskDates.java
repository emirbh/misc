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
import fpml.consolidated.loan.meta.TaskDatesMeta;
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
 * Provision A structure that details key dates related to a task.
 *
 */
@RosettaDataType(value="TaskDates", builder=TaskDates.TaskDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TaskDates", model="fpml", builder=TaskDates.TaskDatesBuilderImpl.class, version="2.1.1")
public interface TaskDates extends RosettaModelObject {

	TaskDatesMeta metaData = new TaskDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the task was raised.
	 *
	 */
	ZonedDateTime getRaisedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date by which the task is expected to be completed.
	 *
	 */
	ZonedDateTime getExpectedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the task was either cleared or cancelled.
	 *
	 */
	ZonedDateTime getClearedDate();

	/*********************** Build Methods  ***********************/
	TaskDates build();
	
	TaskDates.TaskDatesBuilder toBuilder();
	
	static TaskDates.TaskDatesBuilder builder() {
		return new TaskDates.TaskDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaskDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaskDates> getType() {
		return TaskDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("raisedDate"), ZonedDateTime.class, getRaisedDate(), this);
		processor.processBasic(path.newSubPath("expectedDate"), ZonedDateTime.class, getExpectedDate(), this);
		processor.processBasic(path.newSubPath("clearedDate"), ZonedDateTime.class, getClearedDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaskDatesBuilder extends TaskDates, RosettaModelObjectBuilder {
		TaskDates.TaskDatesBuilder setRaisedDate(ZonedDateTime raisedDate);
		TaskDates.TaskDatesBuilder setExpectedDate(ZonedDateTime expectedDate);
		TaskDates.TaskDatesBuilder setClearedDate(ZonedDateTime clearedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("raisedDate"), ZonedDateTime.class, getRaisedDate(), this);
			processor.processBasic(path.newSubPath("expectedDate"), ZonedDateTime.class, getExpectedDate(), this);
			processor.processBasic(path.newSubPath("clearedDate"), ZonedDateTime.class, getClearedDate(), this);
		}
		

		TaskDates.TaskDatesBuilder prune();
	}

	/*********************** Immutable Implementation of TaskDates  ***********************/
	class TaskDatesImpl implements TaskDates {
		private final ZonedDateTime raisedDate;
		private final ZonedDateTime expectedDate;
		private final ZonedDateTime clearedDate;
		
		protected TaskDatesImpl(TaskDates.TaskDatesBuilder builder) {
			this.raisedDate = builder.getRaisedDate();
			this.expectedDate = builder.getExpectedDate();
			this.clearedDate = builder.getClearedDate();
		}
		
		@Override
		@RosettaAttribute("raisedDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("raisedDate")
		public ZonedDateTime getRaisedDate() {
			return raisedDate;
		}
		
		@Override
		@RosettaAttribute("expectedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedDate")
		public ZonedDateTime getExpectedDate() {
			return expectedDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedDate")
		public ZonedDateTime getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public TaskDates build() {
			return this;
		}
		
		@Override
		public TaskDates.TaskDatesBuilder toBuilder() {
			TaskDates.TaskDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaskDates.TaskDatesBuilder builder) {
			ofNullable(getRaisedDate()).ifPresent(builder::setRaisedDate);
			ofNullable(getExpectedDate()).ifPresent(builder::setExpectedDate);
			ofNullable(getClearedDate()).ifPresent(builder::setClearedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskDates _that = getType().cast(o);
		
			if (!Objects.equals(raisedDate, _that.getRaisedDate())) return false;
			if (!Objects.equals(expectedDate, _that.getExpectedDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (raisedDate != null ? raisedDate.hashCode() : 0);
			_result = 31 * _result + (expectedDate != null ? expectedDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskDates {" +
				"raisedDate=" + this.raisedDate + ", " +
				"expectedDate=" + this.expectedDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of TaskDates  ***********************/
	class TaskDatesBuilderImpl implements TaskDates.TaskDatesBuilder {
	
		protected ZonedDateTime raisedDate;
		protected ZonedDateTime expectedDate;
		protected ZonedDateTime clearedDate;
		
		@Override
		@RosettaAttribute("raisedDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("raisedDate")
		public ZonedDateTime getRaisedDate() {
			return raisedDate;
		}
		
		@Override
		@RosettaAttribute("expectedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedDate")
		public ZonedDateTime getExpectedDate() {
			return expectedDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedDate")
		public ZonedDateTime getClearedDate() {
			return clearedDate;
		}
		
		@RosettaAttribute("raisedDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("raisedDate")
		@Override
		public TaskDates.TaskDatesBuilder setRaisedDate(ZonedDateTime _raisedDate) {
			this.raisedDate = _raisedDate == null ? null : _raisedDate;
			return this;
		}
		
		@RosettaAttribute("expectedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedDate")
		@Override
		public TaskDates.TaskDatesBuilder setExpectedDate(ZonedDateTime _expectedDate) {
			this.expectedDate = _expectedDate == null ? null : _expectedDate;
			return this;
		}
		
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearedDate")
		@Override
		public TaskDates.TaskDatesBuilder setClearedDate(ZonedDateTime _clearedDate) {
			this.clearedDate = _clearedDate == null ? null : _clearedDate;
			return this;
		}
		
		@Override
		public TaskDates build() {
			return new TaskDates.TaskDatesImpl(this);
		}
		
		@Override
		public TaskDates.TaskDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskDates.TaskDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRaisedDate()!=null) return true;
			if (getExpectedDate()!=null) return true;
			if (getClearedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskDates.TaskDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaskDates.TaskDatesBuilder o = (TaskDates.TaskDatesBuilder) other;
			
			
			merger.mergeBasic(getRaisedDate(), o.getRaisedDate(), this::setRaisedDate);
			merger.mergeBasic(getExpectedDate(), o.getExpectedDate(), this::setExpectedDate);
			merger.mergeBasic(getClearedDate(), o.getClearedDate(), this::setClearedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskDates _that = getType().cast(o);
		
			if (!Objects.equals(raisedDate, _that.getRaisedDate())) return false;
			if (!Objects.equals(expectedDate, _that.getExpectedDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (raisedDate != null ? raisedDate.hashCode() : 0);
			_result = 31 * _result + (expectedDate != null ? expectedDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskDatesBuilder {" +
				"raisedDate=" + this.raisedDate + ", " +
				"expectedDate=" + this.expectedDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}
}
