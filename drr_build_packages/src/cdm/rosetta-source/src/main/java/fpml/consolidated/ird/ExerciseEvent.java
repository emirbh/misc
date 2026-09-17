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
import fpml.consolidated.ird.meta.ExerciseEventMeta;
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
 * Provision A type defining the adjusted dates associated with a particular exercise event.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the adjusted dates associated with a particular exercise event.
 *
 */
@RosettaDataType(value="ExerciseEvent", builder=ExerciseEvent.ExerciseEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExerciseEvent", model="fpml", builder=ExerciseEvent.ExerciseEventBuilderImpl.class, version="2.1.1")
public interface ExerciseEvent extends RosettaModelObject {

	ExerciseEventMeta metaData = new ExerciseEventMeta();

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
	 * Provision The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedRelevantSwapEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedCashSettlementValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business dat convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business dat convention.
	 *
	 */
	ZonedDateTime getAdjustedCashSettlementPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedExerciseFeePaymentDate();

	/*********************** Build Methods  ***********************/
	ExerciseEvent build();
	
	ExerciseEvent.ExerciseEventBuilder toBuilder();
	
	static ExerciseEvent.ExerciseEventBuilder builder() {
		return new ExerciseEvent.ExerciseEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseEvent> getType() {
		return ExerciseEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), ZonedDateTime.class, getAdjustedRelevantSwapEffectiveDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), ZonedDateTime.class, getAdjustedExerciseFeePaymentDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseEventBuilder extends ExerciseEvent, RosettaModelObjectBuilder {
		ExerciseEvent.ExerciseEventBuilder setId(String id);
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(ZonedDateTime adjustedExerciseDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(ZonedDateTime adjustedRelevantSwapEffectiveDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime adjustedCashSettlementValuationDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime adjustedCashSettlementPaymentDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(ZonedDateTime adjustedExerciseFeePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), ZonedDateTime.class, getAdjustedRelevantSwapEffectiveDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), ZonedDateTime.class, getAdjustedExerciseFeePaymentDate(), this);
		}
		

		ExerciseEvent.ExerciseEventBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseEvent  ***********************/
	class ExerciseEventImpl implements ExerciseEvent {
		private final String id;
		private final ZonedDateTime adjustedExerciseDate;
		private final ZonedDateTime adjustedRelevantSwapEffectiveDate;
		private final ZonedDateTime adjustedCashSettlementValuationDate;
		private final ZonedDateTime adjustedCashSettlementPaymentDate;
		private final ZonedDateTime adjustedExerciseFeePaymentDate;
		
		protected ExerciseEventImpl(ExerciseEvent.ExerciseEventBuilder builder) {
			this.id = builder.getId();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedRelevantSwapEffectiveDate = builder.getAdjustedRelevantSwapEffectiveDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
			this.adjustedExerciseFeePaymentDate = builder.getAdjustedExerciseFeePaymentDate();
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
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedRelevantSwapEffectiveDate")
		public ZonedDateTime getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedCashSettlementValuationDate")
		public ZonedDateTime getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedCashSettlementPaymentDate")
		public ZonedDateTime getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExerciseFeePaymentDate")
		public ZonedDateTime getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@Override
		public ExerciseEvent build() {
			return this;
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			ExerciseEvent.ExerciseEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseEvent.ExerciseEventBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedRelevantSwapEffectiveDate()).ifPresent(builder::setAdjustedRelevantSwapEffectiveDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEvent {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseEvent  ***********************/
	class ExerciseEventBuilderImpl implements ExerciseEvent.ExerciseEventBuilder {
	
		protected String id;
		protected ZonedDateTime adjustedExerciseDate;
		protected ZonedDateTime adjustedRelevantSwapEffectiveDate;
		protected ZonedDateTime adjustedCashSettlementValuationDate;
		protected ZonedDateTime adjustedCashSettlementPaymentDate;
		protected ZonedDateTime adjustedExerciseFeePaymentDate;
		
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
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedRelevantSwapEffectiveDate")
		public ZonedDateTime getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedCashSettlementValuationDate")
		public ZonedDateTime getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedCashSettlementPaymentDate")
		public ZonedDateTime getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedExerciseFeePaymentDate")
		public ZonedDateTime getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseDate")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(ZonedDateTime _adjustedExerciseDate) {
			this.adjustedExerciseDate = _adjustedExerciseDate == null ? null : _adjustedExerciseDate;
			return this;
		}
		
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedRelevantSwapEffectiveDate")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(ZonedDateTime _adjustedRelevantSwapEffectiveDate) {
			this.adjustedRelevantSwapEffectiveDate = _adjustedRelevantSwapEffectiveDate == null ? null : _adjustedRelevantSwapEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementValuationDate")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime _adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = _adjustedCashSettlementValuationDate == null ? null : _adjustedCashSettlementValuationDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementPaymentDate")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime _adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = _adjustedCashSettlementPaymentDate == null ? null : _adjustedCashSettlementPaymentDate;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseFeePaymentDate")
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(ZonedDateTime _adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = _adjustedExerciseFeePaymentDate == null ? null : _adjustedExerciseFeePaymentDate;
			return this;
		}
		
		@Override
		public ExerciseEvent build() {
			return new ExerciseEvent.ExerciseEventImpl(this);
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedRelevantSwapEffectiveDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseEvent.ExerciseEventBuilder o = (ExerciseEvent.ExerciseEventBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedRelevantSwapEffectiveDate(), o.getAdjustedRelevantSwapEffectiveDate(), this::setAdjustedRelevantSwapEffectiveDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedExerciseFeePaymentDate(), o.getAdjustedExerciseFeePaymentDate(), this::setAdjustedExerciseFeePaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEventBuilder {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate +
			'}';
		}
	}
}
