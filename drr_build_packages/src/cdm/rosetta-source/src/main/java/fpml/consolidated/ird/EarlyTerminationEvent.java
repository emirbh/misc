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
import fpml.consolidated.ird.meta.EarlyTerminationEventMeta;
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
 * Provision A type to define the adjusted dates associated with an early termination provision.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define the adjusted dates associated with an early termination provision.
 *
 */
@RosettaDataType(value="EarlyTerminationEvent", builder=EarlyTerminationEvent.EarlyTerminationEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EarlyTerminationEvent", model="fpml", builder=EarlyTerminationEvent.EarlyTerminationEventBuilderImpl.class, version="2.1.1")
public interface EarlyTerminationEvent extends RosettaModelObject {

	EarlyTerminationEventMeta metaData = new EarlyTerminationEventMeta();

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
	EarlyTerminationEvent build();
	
	EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder();
	
	static EarlyTerminationEvent.EarlyTerminationEventBuilder builder() {
		return new EarlyTerminationEvent.EarlyTerminationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EarlyTerminationEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EarlyTerminationEvent> getType() {
		return EarlyTerminationEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), ZonedDateTime.class, getAdjustedExerciseFeePaymentDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EarlyTerminationEventBuilder extends EarlyTerminationEvent, RosettaModelObjectBuilder {
		EarlyTerminationEvent.EarlyTerminationEventBuilder setId(String id);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(ZonedDateTime adjustedExerciseDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(ZonedDateTime adjustedEarlyTerminationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime adjustedCashSettlementValuationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime adjustedCashSettlementPaymentDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(ZonedDateTime adjustedExerciseFeePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), ZonedDateTime.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), ZonedDateTime.class, getAdjustedExerciseFeePaymentDate(), this);
		}
		

		EarlyTerminationEvent.EarlyTerminationEventBuilder prune();
	}

	/*********************** Immutable Implementation of EarlyTerminationEvent  ***********************/
	class EarlyTerminationEventImpl implements EarlyTerminationEvent {
		private final String id;
		private final ZonedDateTime adjustedExerciseDate;
		private final ZonedDateTime adjustedEarlyTerminationDate;
		private final ZonedDateTime adjustedCashSettlementValuationDate;
		private final ZonedDateTime adjustedCashSettlementPaymentDate;
		private final ZonedDateTime adjustedExerciseFeePaymentDate;
		
		protected EarlyTerminationEventImpl(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			this.id = builder.getId();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
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
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		public ZonedDateTime getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
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
		public EarlyTerminationEvent build() {
			return this;
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			EarlyTerminationEvent.EarlyTerminationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
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
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEvent {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of EarlyTerminationEvent  ***********************/
	class EarlyTerminationEventBuilderImpl implements EarlyTerminationEvent.EarlyTerminationEventBuilder {
	
		protected String id;
		protected ZonedDateTime adjustedExerciseDate;
		protected ZonedDateTime adjustedEarlyTerminationDate;
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
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		public ZonedDateTime getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
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
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseDate")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(ZonedDateTime _adjustedExerciseDate) {
			this.adjustedExerciseDate = _adjustedExerciseDate == null ? null : _adjustedExerciseDate;
			return this;
		}
		
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(ZonedDateTime _adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = _adjustedEarlyTerminationDate == null ? null : _adjustedEarlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementValuationDate")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime _adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = _adjustedCashSettlementValuationDate == null ? null : _adjustedCashSettlementValuationDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementPaymentDate")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime _adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = _adjustedCashSettlementPaymentDate == null ? null : _adjustedCashSettlementPaymentDate;
			return this;
		}
		
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedExerciseFeePaymentDate")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(ZonedDateTime _adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = _adjustedExerciseFeePaymentDate == null ? null : _adjustedExerciseFeePaymentDate;
			return this;
		}
		
		@Override
		public EarlyTerminationEvent build() {
			return new EarlyTerminationEvent.EarlyTerminationEventImpl(this);
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationEvent.EarlyTerminationEventBuilder o = (EarlyTerminationEvent.EarlyTerminationEventBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedExerciseFeePaymentDate(), o.getAdjustedExerciseFeePaymentDate(), this::setAdjustedExerciseFeePaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
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
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEventBuilder {" +
				"id=" + this.id + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate +
			'}';
		}
	}
}
