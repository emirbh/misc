package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.ExtensionEventMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define the adjusted dates associated with an individual extension event.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define the adjusted dates associated with an individual extension event.
 *
 */
@RosettaDataType(value="ExtensionEvent", builder=ExtensionEvent.ExtensionEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExtensionEvent", model="fpml", builder=ExtensionEvent.ExtensionEventBuilderImpl.class, version="2.1.1")
public interface ExtensionEvent extends RosettaModelObject {

	ExtensionEventMeta metaData = new ExtensionEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedExerciseDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedExtendedTerminationDate();

	/*********************** Build Methods  ***********************/
	ExtensionEvent build();
	
	ExtensionEvent.ExtensionEventBuilder toBuilder();
	
	static ExtensionEvent.ExtensionEventBuilder builder() {
		return new ExtensionEvent.ExtensionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtensionEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExtensionEvent> getType() {
		return ExtensionEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedExtendedTerminationDate"), ZonedDateTime.class, getAdjustedExtendedTerminationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtensionEventBuilder extends ExtensionEvent, RosettaModelObjectBuilder {
		ExtensionEvent.ExtensionEventBuilder setId(String id);
		ExtensionEvent.ExtensionEventBuilder setAdjustedExerciseDate(ZonedDateTime adjustedExerciseDate);
		ExtensionEvent.ExtensionEventBuilder setAdjustedExtendedTerminationDate(ZonedDateTime adjustedExtendedTerminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedExtendedTerminationDate"), ZonedDateTime.class, getAdjustedExtendedTerminationDate(), this);
		}
		

		ExtensionEvent.ExtensionEventBuilder prune();
	}

	/*********************** Immutable Implementation of ExtensionEvent  ***********************/
	class ExtensionEventImpl implements ExtensionEvent {
		private final String id;
		private final ZonedDateTime adjustedExerciseDate;
		private final ZonedDateTime adjustedExtendedTerminationDate;
		
		protected ExtensionEventImpl(ExtensionEvent.ExtensionEventBuilder builder) {
			this.id = builder.getId();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedExtendedTerminationDate = builder.getAdjustedExtendedTerminationDate();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExerciseDate")
		public ZonedDateTime getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExtendedTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExtendedTerminationDate")
		public ZonedDateTime getAdjustedExtendedTerminationDate() {
			return adjustedExtendedTerminationDate;
		}
		
		@Override
		public ExtensionEvent build() {
			return this;
		}
		
		@Override
		public ExtensionEvent.ExtensionEventBuilder toBuilder() {
			ExtensionEvent.ExtensionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtensionEvent.ExtensionEventBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedExtendedTerminationDate()).ifPresent(builder::setAdjustedExtendedTerminationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtensionEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExtendedTerminationDate, _that.getAdjustedExtendedTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExtendedTerminationDate != null ? adjustedExtendedTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtensionEvent {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExtendedTerminationDate=" + this.adjustedExtendedTerminationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtensionEvent  ***********************/
	class ExtensionEventBuilderImpl implements ExtensionEvent.ExtensionEventBuilder {
	
		protected String id;
		protected ZonedDateTime adjustedExerciseDate;
		protected ZonedDateTime adjustedExtendedTerminationDate;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExerciseDate")
		public ZonedDateTime getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExtendedTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExtendedTerminationDate")
		public ZonedDateTime getAdjustedExtendedTerminationDate() {
			return adjustedExtendedTerminationDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExtensionEvent.ExtensionEventBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseDate")
		@Override
		public ExtensionEvent.ExtensionEventBuilder setAdjustedExerciseDate(ZonedDateTime _adjustedExerciseDate) {
			this.adjustedExerciseDate = _adjustedExerciseDate == null ? null : _adjustedExerciseDate;
			return this;
		}
		
		@RosettaAttribute("adjustedExtendedTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExtendedTerminationDate")
		@Override
		public ExtensionEvent.ExtensionEventBuilder setAdjustedExtendedTerminationDate(ZonedDateTime _adjustedExtendedTerminationDate) {
			this.adjustedExtendedTerminationDate = _adjustedExtendedTerminationDate == null ? null : _adjustedExtendedTerminationDate;
			return this;
		}
		
		@Override
		public ExtensionEvent build() {
			return new ExtensionEvent.ExtensionEventImpl(this);
		}
		
		@Override
		public ExtensionEvent.ExtensionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtensionEvent.ExtensionEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedExtendedTerminationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtensionEvent.ExtensionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtensionEvent.ExtensionEventBuilder o = (ExtensionEvent.ExtensionEventBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedExtendedTerminationDate(), o.getAdjustedExtendedTerminationDate(), this::setAdjustedExtendedTerminationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtensionEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExtendedTerminationDate, _that.getAdjustedExtendedTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExtendedTerminationDate != null ? adjustedExtendedTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtensionEventBuilder {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExtendedTerminationDate=" + this.adjustedExtendedTerminationDate +
			'}';
		}
	}
}
