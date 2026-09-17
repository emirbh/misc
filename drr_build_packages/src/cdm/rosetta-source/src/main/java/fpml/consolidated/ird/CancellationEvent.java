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
import fpml.consolidated.ird.meta.CancellationEventMeta;
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
 * Provision The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 *
 */
@RosettaDataType(value="CancellationEvent", builder=CancellationEvent.CancellationEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CancellationEvent", model="fpml", builder=CancellationEvent.CancellationEventBuilderImpl.class, version="2.1.1")
public interface CancellationEvent extends RosettaModelObject {

	CancellationEventMeta metaData = new CancellationEventMeta();

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
	 * Provision The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedEarlyTerminationDate();

	/*********************** Build Methods  ***********************/
	CancellationEvent build();
	
	CancellationEvent.CancellationEventBuilder toBuilder();
	
	static CancellationEvent.CancellationEventBuilder builder() {
		return new CancellationEvent.CancellationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancellationEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CancellationEvent> getType() {
		return CancellationEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancellationEventBuilder extends CancellationEvent, RosettaModelObjectBuilder {
		CancellationEvent.CancellationEventBuilder setId(String id);
		CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(ZonedDateTime adjustedExerciseDate);
		CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(ZonedDateTime adjustedEarlyTerminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
		}
		

		CancellationEvent.CancellationEventBuilder prune();
	}

	/*********************** Immutable Implementation of CancellationEvent  ***********************/
	class CancellationEventImpl implements CancellationEvent {
		private final String id;
		private final ZonedDateTime adjustedExerciseDate;
		private final ZonedDateTime adjustedEarlyTerminationDate;
		
		protected CancellationEventImpl(CancellationEvent.CancellationEventBuilder builder) {
			this.id = builder.getId();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
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
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		public ZonedDateTime getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		public CancellationEvent build() {
			return this;
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			CancellationEvent.CancellationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancellationEvent.CancellationEventBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEvent {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CancellationEvent  ***********************/
	class CancellationEventBuilderImpl implements CancellationEvent.CancellationEventBuilder {
	
		protected String id;
		protected ZonedDateTime adjustedExerciseDate;
		protected ZonedDateTime adjustedEarlyTerminationDate;
		
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
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		public ZonedDateTime getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CancellationEvent.CancellationEventBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseDate")
		@Override
		public CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(ZonedDateTime _adjustedExerciseDate) {
			this.adjustedExerciseDate = _adjustedExerciseDate == null ? null : _adjustedExerciseDate;
			return this;
		}
		
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		@Override
		public CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(ZonedDateTime _adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = _adjustedEarlyTerminationDate == null ? null : _adjustedEarlyTerminationDate;
			return this;
		}
		
		@Override
		public CancellationEvent build() {
			return new CancellationEvent.CancellationEventImpl(this);
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancellationEvent.CancellationEventBuilder o = (CancellationEvent.CancellationEventBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEventBuilder {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate +
			'}';
		}
	}
}
