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
import fpml.consolidated.ird.meta.MandatoryEarlyTerminationAdjustedDatesMeta;
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
 * Provision A type defining the adjusted dates associated with a mandatory early termination provision.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the adjusted dates associated with a mandatory early termination provision.
 *
 */
@RosettaDataType(value="MandatoryEarlyTerminationAdjustedDates", builder=MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MandatoryEarlyTerminationAdjustedDates", model="fpml", builder=MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilderImpl.class, version="2.1.1")
public interface MandatoryEarlyTerminationAdjustedDates extends RosettaModelObject {

	MandatoryEarlyTerminationAdjustedDatesMeta metaData = new MandatoryEarlyTerminationAdjustedDatesMeta();

	/*********************** Getter Methods  ***********************/
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

	/*********************** Build Methods  ***********************/
	MandatoryEarlyTerminationAdjustedDates build();
	
	MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder();
	
	static MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder() {
		return new MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTerminationAdjustedDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MandatoryEarlyTerminationAdjustedDates> getType() {
		return MandatoryEarlyTerminationAdjustedDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MandatoryEarlyTerminationAdjustedDatesBuilder extends MandatoryEarlyTerminationAdjustedDates, RosettaModelObjectBuilder {
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedEarlyTerminationDate(ZonedDateTime adjustedEarlyTerminationDate);
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime adjustedCashSettlementValuationDate);
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime adjustedCashSettlementPaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), ZonedDateTime.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), ZonedDateTime.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), ZonedDateTime.class, getAdjustedCashSettlementPaymentDate(), this);
		}
		

		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryEarlyTerminationAdjustedDates  ***********************/
	class MandatoryEarlyTerminationAdjustedDatesImpl implements MandatoryEarlyTerminationAdjustedDates {
		private final ZonedDateTime adjustedEarlyTerminationDate;
		private final ZonedDateTime adjustedCashSettlementValuationDate;
		private final ZonedDateTime adjustedCashSettlementPaymentDate;
		
		protected MandatoryEarlyTerminationAdjustedDatesImpl(MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder) {
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
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
		public MandatoryEarlyTerminationAdjustedDates build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder() {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder builder) {
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationAdjustedDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationAdjustedDates {" +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of MandatoryEarlyTerminationAdjustedDates  ***********************/
	class MandatoryEarlyTerminationAdjustedDatesBuilderImpl implements MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder {
	
		protected ZonedDateTime adjustedEarlyTerminationDate;
		protected ZonedDateTime adjustedCashSettlementValuationDate;
		protected ZonedDateTime adjustedCashSettlementPaymentDate;
		
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
		
		@RosettaAttribute("adjustedEarlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedEarlyTerminationDate")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedEarlyTerminationDate(ZonedDateTime _adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = _adjustedEarlyTerminationDate == null ? null : _adjustedEarlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementValuationDate")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementValuationDate(ZonedDateTime _adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = _adjustedCashSettlementValuationDate == null ? null : _adjustedCashSettlementValuationDate;
			return this;
		}
		
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedCashSettlementPaymentDate")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder setAdjustedCashSettlementPaymentDate(ZonedDateTime _adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = _adjustedCashSettlementPaymentDate == null ? null : _adjustedCashSettlementPaymentDate;
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates build() {
			return new MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesImpl(this);
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder o = (MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder) other;
			
			
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationAdjustedDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationAdjustedDatesBuilder {" +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate +
			'}';
		}
	}
}
