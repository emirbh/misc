package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.DividendPaymentDateMeta;
import fpml.consolidated.fpmlenum.DividendDateReferenceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Offset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the date on which the dividend will be paid/received. This type is also used to specify the date on which the FX rate will be determined, when applicable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the date on which the dividend will be paid/received. This type is also used to specify the date on which the FX rate will be determined, when applicable.
 *
 */
@RosettaDataType(value="DividendPaymentDate", builder=DividendPaymentDate.DividendPaymentDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendPaymentDate", model="fpml", builder=DividendPaymentDate.DividendPaymentDateBuilderImpl.class, version="2.1.1")
public interface DividendPaymentDate extends RosettaModelObject {

	DividendPaymentDateMeta metaData = new DividendPaymentDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specification of the dividend date using an enumeration, with values such as the pay date, the ex date or the record date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specification of the dividend date using an enumeration, with values such as the pay date, the ex date or the record date.
	 *
	 */
	DividendDateReferenceEnum getDividendDateReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
	 *
	 */
	Offset getPaymentDateOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 */
	AdjustableDate getAdjustableDate();

	/*********************** Build Methods  ***********************/
	DividendPaymentDate build();
	
	DividendPaymentDate.DividendPaymentDateBuilder toBuilder();
	
	static DividendPaymentDate.DividendPaymentDateBuilder builder() {
		return new DividendPaymentDate.DividendPaymentDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPaymentDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPaymentDate> getType() {
		return DividendPaymentDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendDateReference"), DividendDateReferenceEnum.class, getDividendDateReference(), this);
		processRosetta(path.newSubPath("paymentDateOffset"), processor, Offset.class, getPaymentDateOffset());
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPaymentDateBuilder extends DividendPaymentDate, RosettaModelObjectBuilder {
		Offset.OffsetBuilder getOrCreatePaymentDateOffset();
		@Override
		Offset.OffsetBuilder getPaymentDateOffset();
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		DividendPaymentDate.DividendPaymentDateBuilder setDividendDateReference(DividendDateReferenceEnum dividendDateReference);
		DividendPaymentDate.DividendPaymentDateBuilder setPaymentDateOffset(Offset paymentDateOffset);
		DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate adjustableDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendDateReference"), DividendDateReferenceEnum.class, getDividendDateReference(), this);
			processRosetta(path.newSubPath("paymentDateOffset"), processor, Offset.OffsetBuilder.class, getPaymentDateOffset());
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
		}
		

		DividendPaymentDate.DividendPaymentDateBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPaymentDate  ***********************/
	class DividendPaymentDateImpl implements DividendPaymentDate {
		private final DividendDateReferenceEnum dividendDateReference;
		private final Offset paymentDateOffset;
		private final AdjustableDate adjustableDate;
		
		protected DividendPaymentDateImpl(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			this.dividendDateReference = builder.getDividendDateReference();
			this.paymentDateOffset = ofNullable(builder.getPaymentDateOffset()).map(f->f.build()).orElse(null);
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendDateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendDateReference")
		public DividendDateReferenceEnum getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		@RosettaAttribute("paymentDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDateOffset")
		public Offset getPaymentDateOffset() {
			return paymentDateOffset;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public DividendPaymentDate build() {
			return this;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			DividendPaymentDate.DividendPaymentDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			ofNullable(getDividendDateReference()).ifPresent(builder::setDividendDateReference);
			ofNullable(getPaymentDateOffset()).ifPresent(builder::setPaymentDateOffset);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			if (!Objects.equals(paymentDateOffset, _that.getPaymentDateOffset())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDateOffset != null ? paymentDateOffset.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDate {" +
				"dividendDateReference=" + this.dividendDateReference + ", " +
				"paymentDateOffset=" + this.paymentDateOffset + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPaymentDate  ***********************/
	class DividendPaymentDateBuilderImpl implements DividendPaymentDate.DividendPaymentDateBuilder {
	
		protected DividendDateReferenceEnum dividendDateReference;
		protected Offset.OffsetBuilder paymentDateOffset;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		
		@Override
		@RosettaAttribute("dividendDateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendDateReference")
		public DividendDateReferenceEnum getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		@RosettaAttribute("paymentDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDateOffset")
		public Offset.OffsetBuilder getPaymentDateOffset() {
			return paymentDateOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreatePaymentDateOffset() {
			Offset.OffsetBuilder result;
			if (paymentDateOffset!=null) {
				result = paymentDateOffset;
			}
			else {
				result = paymentDateOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDate")
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dividendDateReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendDateReference")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder setDividendDateReference(DividendDateReferenceEnum _dividendDateReference) {
			this.dividendDateReference = _dividendDateReference == null ? null : _dividendDateReference;
			return this;
		}
		
		@RosettaAttribute("paymentDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDateOffset")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder setPaymentDateOffset(Offset _paymentDateOffset) {
			this.paymentDateOffset = _paymentDateOffset == null ? null : _paymentDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDate")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate _adjustableDate) {
			this.adjustableDate = _adjustableDate == null ? null : _adjustableDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendPaymentDate build() {
			return new DividendPaymentDate.DividendPaymentDateImpl(this);
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder prune() {
			if (paymentDateOffset!=null && !paymentDateOffset.prune().hasData()) paymentDateOffset = null;
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendDateReference()!=null) return true;
			if (getPaymentDateOffset()!=null && getPaymentDateOffset().hasData()) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPaymentDate.DividendPaymentDateBuilder o = (DividendPaymentDate.DividendPaymentDateBuilder) other;
			
			merger.mergeRosetta(getPaymentDateOffset(), o.getPaymentDateOffset(), this::setPaymentDateOffset);
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			
			merger.mergeBasic(getDividendDateReference(), o.getDividendDateReference(), this::setDividendDateReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			if (!Objects.equals(paymentDateOffset, _that.getPaymentDateOffset())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDateOffset != null ? paymentDateOffset.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDateBuilder {" +
				"dividendDateReference=" + this.dividendDateReference + ", " +
				"paymentDateOffset=" + this.paymentDateOffset + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}
}
