package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.PayRelativeToEnum;
import fpml.consolidated.ird.meta.PaymentDatesMeta;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Offset;
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
 * Provision A type defining parameters used to generate the payment dates schedule, including the specification of early or delayed payments. Payment dates are determined relative to the calculation period dates or the reset dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining parameters used to generate the payment dates schedule, including the specification of early or delayed payments. Payment dates are determined relative to the calculation period dates or the reset dates.
 *
 */
@RosettaDataType(value="PaymentDates", builder=PaymentDates.PaymentDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentDates", model="fpml", builder=PaymentDates.PaymentDatesBuilderImpl.class, version="2.1.1")
public interface PaymentDates extends RosettaModelObject {

	PaymentDatesMeta metaData = new PaymentDatesMeta();

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
	 * Provision A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 *
	 */
	CalculationPeriodDatesReference getCalculationPeriodDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the associated reset dates component defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated reset dates component defined elsewhere in the document.
	 *
	 */
	ResetDatesReference getResetDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the associated valuation dates component defined elsewhere in the document. Implemented for Brazilian-CDI Swaps where it will refer to the settlemementProvision/nonDeliverableSettlement/fxFixingDate structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated valuation dates component defined elsewhere in the document. Implemented for Brazilian-CDI Swaps where it will refer to the settlemementProvision/nonDeliverableSettlement/fxFixingDate structure.
	 *
	 */
	ValuationDatesReference getValuationDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which regular payment dates occur. If the payment frequency is equal to the frequency defined in the calculation period dates component then one calculation period contributes to each payment amount. If the payment frequency is less frequent than the frequency defined in the calculation period dates component then more than one calculation period will contribute to the payment amount. A payment frequency more frequent than the calculation period frequency or one that is not a multiple of the calculation period frequency is invalid. If the payment frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which regular payment dates occur. If the payment frequency is equal to the frequency defined in the calculation period dates component then one calculation period contributes to each payment amount. If the payment frequency is less frequent than the frequency defined in the calculation period dates component then more than one calculation period will contribute to the payment amount. A payment frequency more frequent than the calculation period frequency or one that is not a multiple of the calculation period frequency is invalid. If the payment frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
	 *
	 */
	Frequency getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is an initial stub. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual first payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is an initial stub. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual first payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 *
	 */
	ZonedDateTime getFirstPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last regular unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is a final stub. All calculation periods after this date contribute to the final payment. The final payment is made relative to the final set of calculation periods or the final reset date as the case may be. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual last regular payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last regular unadjusted payment date. This day may be subject to adjustment in accordance with any business day convention specified in paymentDatesAdjustments. This element must only be included if there is a final stub. All calculation periods after this date contribute to the final payment. The final payment is made relative to the final set of calculation periods or the final reset date as the case may be. This date will normally correspond to an unadjusted calculation period start or end date. This is true even if early or delayed payment is specified to be applicable since the actual last regular payment date will be the specified number of days before or after the applicable adjusted calculation period start or end date with the resulting payment date then being adjusted in accordance with any business day convention specified in paymentDatesAdjustments.
	 *
	 */
	ZonedDateTime getLastRegularPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the payments occur relative to each adjusted calculation period start date, adjusted calculation period end date or each reset date. The reset date is applicable in the case of certain euro (former French Franc) floating rate indices. Calculation period start date means relative to the start of the first calculation period contributing to a given payment. Similarly, calculation period end date means the end of the last calculation period contributing to a given payment.The valuation date is applicable for Brazilian-CDI swaps.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the payments occur relative to each adjusted calculation period start date, adjusted calculation period end date or each reset date. The reset date is applicable in the case of certain euro (former French Franc) floating rate indices. Calculation period start date means relative to the start of the first calculation period contributing to a given payment. Similarly, calculation period end date means the end of the last calculation period contributing to a given payment.The valuation date is applicable for Brazilian-CDI swaps.
	 *
	 */
	PayRelativeToEnum getPayRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If early payment or delayed payment is required, specifies the number of days offset that the payment occurs relative to what would otherwise be the unadjusted payment date. The offset can be specified in terms of either calendar or business days. Even in the case of a calendar days offset, the resulting payment date, adjusted for the specified calendar days offset, will still be adjusted in accordance with the specified payment dates adjustments. This element should only be included if early or delayed payment is applicable, i.e. if the periodMultiplier element value is not equal to zero. An early payment would be indicated by a negative periodMultiplier element value and a delayed payment (or payment lag) would be indicated by a positive periodMultiplier element value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If early payment or delayed payment is required, specifies the number of days offset that the payment occurs relative to what would otherwise be the unadjusted payment date. The offset can be specified in terms of either calendar or business days. Even in the case of a calendar days offset, the resulting payment date, adjusted for the specified calendar days offset, will still be adjusted in accordance with the specified payment dates adjustments. This element should only be included if early or delayed payment is applicable, i.e. if the periodMultiplier element value is not equal to zero. An early payment would be indicated by a negative periodMultiplier element value and a delayed payment (or payment lag) would be indicated by a positive periodMultiplier element value.
	 *
	 */
	Offset getPaymentDaysOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The business day convention to apply to each payment date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business day convention to apply to each payment date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 */
	BusinessDayAdjustments getPaymentDatesAdjustments();

	/*********************** Build Methods  ***********************/
	PaymentDates build();
	
	PaymentDates.PaymentDatesBuilder toBuilder();
	
	static PaymentDates.PaymentDatesBuilder builder() {
		return new PaymentDates.PaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentDates> getType() {
		return PaymentDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processRosetta(path.newSubPath("resetDatesReference"), processor, ResetDatesReference.class, getResetDatesReference());
		processRosetta(path.newSubPath("valuationDatesReference"), processor, ValuationDatesReference.class, getValuationDatesReference());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("firstPaymentDate"), ZonedDateTime.class, getFirstPaymentDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPaymentDate"), ZonedDateTime.class, getLastRegularPaymentDate(), this);
		processor.processBasic(path.newSubPath("payRelativeTo"), PayRelativeToEnum.class, getPayRelativeTo(), this);
		processRosetta(path.newSubPath("paymentDaysOffset"), processor, Offset.class, getPaymentDaysOffset());
		processRosetta(path.newSubPath("paymentDatesAdjustments"), processor, BusinessDayAdjustments.class, getPaymentDatesAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDatesBuilder extends PaymentDates, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		@Override
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		ResetDatesReference.ResetDatesReferenceBuilder getOrCreateResetDatesReference();
		@Override
		ResetDatesReference.ResetDatesReferenceBuilder getResetDatesReference();
		ValuationDatesReference.ValuationDatesReferenceBuilder getOrCreateValuationDatesReference();
		@Override
		ValuationDatesReference.ValuationDatesReferenceBuilder getValuationDatesReference();
		Frequency.FrequencyBuilder getOrCreatePaymentFrequency();
		@Override
		Frequency.FrequencyBuilder getPaymentFrequency();
		Offset.OffsetBuilder getOrCreatePaymentDaysOffset();
		@Override
		Offset.OffsetBuilder getPaymentDaysOffset();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePaymentDatesAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPaymentDatesAdjustments();
		PaymentDates.PaymentDatesBuilder setId(String id);
		PaymentDates.PaymentDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference);
		PaymentDates.PaymentDatesBuilder setResetDatesReference(ResetDatesReference resetDatesReference);
		PaymentDates.PaymentDatesBuilder setValuationDatesReference(ValuationDatesReference valuationDatesReference);
		PaymentDates.PaymentDatesBuilder setPaymentFrequency(Frequency paymentFrequency);
		PaymentDates.PaymentDatesBuilder setFirstPaymentDate(ZonedDateTime firstPaymentDate);
		PaymentDates.PaymentDatesBuilder setLastRegularPaymentDate(ZonedDateTime lastRegularPaymentDate);
		PaymentDates.PaymentDatesBuilder setPayRelativeTo(PayRelativeToEnum payRelativeTo);
		PaymentDates.PaymentDatesBuilder setPaymentDaysOffset(Offset paymentDaysOffset);
		PaymentDates.PaymentDatesBuilder setPaymentDatesAdjustments(BusinessDayAdjustments paymentDatesAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processRosetta(path.newSubPath("resetDatesReference"), processor, ResetDatesReference.ResetDatesReferenceBuilder.class, getResetDatesReference());
			processRosetta(path.newSubPath("valuationDatesReference"), processor, ValuationDatesReference.ValuationDatesReferenceBuilder.class, getValuationDatesReference());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("firstPaymentDate"), ZonedDateTime.class, getFirstPaymentDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPaymentDate"), ZonedDateTime.class, getLastRegularPaymentDate(), this);
			processor.processBasic(path.newSubPath("payRelativeTo"), PayRelativeToEnum.class, getPayRelativeTo(), this);
			processRosetta(path.newSubPath("paymentDaysOffset"), processor, Offset.OffsetBuilder.class, getPaymentDaysOffset());
			processRosetta(path.newSubPath("paymentDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getPaymentDatesAdjustments());
		}
		

		PaymentDates.PaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDates  ***********************/
	class PaymentDatesImpl implements PaymentDates {
		private final String id;
		private final CalculationPeriodDatesReference calculationPeriodDatesReference;
		private final ResetDatesReference resetDatesReference;
		private final ValuationDatesReference valuationDatesReference;
		private final Frequency paymentFrequency;
		private final ZonedDateTime firstPaymentDate;
		private final ZonedDateTime lastRegularPaymentDate;
		private final PayRelativeToEnum payRelativeTo;
		private final Offset paymentDaysOffset;
		private final BusinessDayAdjustments paymentDatesAdjustments;
		
		protected PaymentDatesImpl(PaymentDates.PaymentDatesBuilder builder) {
			this.id = builder.getId();
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.resetDatesReference = ofNullable(builder.getResetDatesReference()).map(f->f.build()).orElse(null);
			this.valuationDatesReference = ofNullable(builder.getValuationDatesReference()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.firstPaymentDate = builder.getFirstPaymentDate();
			this.lastRegularPaymentDate = builder.getLastRegularPaymentDate();
			this.payRelativeTo = builder.getPayRelativeTo();
			this.paymentDaysOffset = ofNullable(builder.getPaymentDaysOffset()).map(f->f.build()).orElse(null);
			this.paymentDatesAdjustments = ofNullable(builder.getPaymentDatesAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		@RosettaAttribute("resetDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDatesReference")
		public ResetDatesReference getResetDatesReference() {
			return resetDatesReference;
		}
		
		@Override
		@RosettaAttribute("valuationDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDatesReference")
		public ValuationDatesReference getValuationDatesReference() {
			return valuationDatesReference;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentFrequency")
		public Frequency getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPaymentDate")
		public ZonedDateTime getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPaymentDate")
		public ZonedDateTime getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeTo")
		public PayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDaysOffset")
		public Offset getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		@RosettaAttribute("paymentDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDatesAdjustments")
		public BusinessDayAdjustments getPaymentDatesAdjustments() {
			return paymentDatesAdjustments;
		}
		
		@Override
		public PaymentDates build() {
			return this;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder toBuilder() {
			PaymentDates.PaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDates.PaymentDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getResetDatesReference()).ifPresent(builder::setResetDatesReference);
			ofNullable(getValuationDatesReference()).ifPresent(builder::setValuationDatesReference);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getFirstPaymentDate()).ifPresent(builder::setFirstPaymentDate);
			ofNullable(getLastRegularPaymentDate()).ifPresent(builder::setLastRegularPaymentDate);
			ofNullable(getPayRelativeTo()).ifPresent(builder::setPayRelativeTo);
			ofNullable(getPaymentDaysOffset()).ifPresent(builder::setPaymentDaysOffset);
			ofNullable(getPaymentDatesAdjustments()).ifPresent(builder::setPaymentDatesAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetDatesReference, _that.getResetDatesReference())) return false;
			if (!Objects.equals(valuationDatesReference, _that.getValuationDatesReference())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(paymentDatesAdjustments, _that.getPaymentDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetDatesReference != null ? resetDatesReference.hashCode() : 0);
			_result = 31 * _result + (valuationDatesReference != null ? valuationDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (paymentDatesAdjustments != null ? paymentDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDates {" +
				"id=" + this.id + ", " +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetDatesReference=" + this.resetDatesReference + ", " +
				"valuationDatesReference=" + this.valuationDatesReference + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"paymentDatesAdjustments=" + this.paymentDatesAdjustments +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentDates  ***********************/
	class PaymentDatesBuilderImpl implements PaymentDates.PaymentDatesBuilder {
	
		protected String id;
		protected CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected ResetDatesReference.ResetDatesReferenceBuilder resetDatesReference;
		protected ValuationDatesReference.ValuationDatesReferenceBuilder valuationDatesReference;
		protected Frequency.FrequencyBuilder paymentFrequency;
		protected ZonedDateTime firstPaymentDate;
		protected ZonedDateTime lastRegularPaymentDate;
		protected PayRelativeToEnum payRelativeTo;
		protected Offset.OffsetBuilder paymentDaysOffset;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder paymentDatesAdjustments;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference() {
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = CalculationPeriodDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDatesReference")
		public ResetDatesReference.ResetDatesReferenceBuilder getResetDatesReference() {
			return resetDatesReference;
		}
		
		@Override
		public ResetDatesReference.ResetDatesReferenceBuilder getOrCreateResetDatesReference() {
			ResetDatesReference.ResetDatesReferenceBuilder result;
			if (resetDatesReference!=null) {
				result = resetDatesReference;
			}
			else {
				result = resetDatesReference = ResetDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDatesReference")
		public ValuationDatesReference.ValuationDatesReferenceBuilder getValuationDatesReference() {
			return valuationDatesReference;
		}
		
		@Override
		public ValuationDatesReference.ValuationDatesReferenceBuilder getOrCreateValuationDatesReference() {
			ValuationDatesReference.ValuationDatesReferenceBuilder result;
			if (valuationDatesReference!=null) {
				result = valuationDatesReference;
			}
			else {
				result = valuationDatesReference = ValuationDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentFrequency")
		public Frequency.FrequencyBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreatePaymentFrequency() {
			Frequency.FrequencyBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPaymentDate")
		public ZonedDateTime getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPaymentDate")
		public ZonedDateTime getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payRelativeTo")
		public PayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDaysOffset")
		public Offset.OffsetBuilder getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreatePaymentDaysOffset() {
			Offset.OffsetBuilder result;
			if (paymentDaysOffset!=null) {
				result = paymentDaysOffset;
			}
			else {
				result = paymentDaysOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPaymentDatesAdjustments() {
			return paymentDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePaymentDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (paymentDatesAdjustments!=null) {
				result = paymentDatesAdjustments;
			}
			else {
				result = paymentDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PaymentDates.PaymentDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		@Override
		public PaymentDates.PaymentDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference _calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = _calculationPeriodDatesReference == null ? null : _calculationPeriodDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetDatesReference")
		@Override
		public PaymentDates.PaymentDatesBuilder setResetDatesReference(ResetDatesReference _resetDatesReference) {
			this.resetDatesReference = _resetDatesReference == null ? null : _resetDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDatesReference")
		@Override
		public PaymentDates.PaymentDatesBuilder setValuationDatesReference(ValuationDatesReference _valuationDatesReference) {
			this.valuationDatesReference = _valuationDatesReference == null ? null : _valuationDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentFrequency")
		@Override
		public PaymentDates.PaymentDatesBuilder setPaymentFrequency(Frequency _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstPaymentDate")
		@Override
		public PaymentDates.PaymentDatesBuilder setFirstPaymentDate(ZonedDateTime _firstPaymentDate) {
			this.firstPaymentDate = _firstPaymentDate == null ? null : _firstPaymentDate;
			return this;
		}
		
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastRegularPaymentDate")
		@Override
		public PaymentDates.PaymentDatesBuilder setLastRegularPaymentDate(ZonedDateTime _lastRegularPaymentDate) {
			this.lastRegularPaymentDate = _lastRegularPaymentDate == null ? null : _lastRegularPaymentDate;
			return this;
		}
		
		@RosettaAttribute("payRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payRelativeTo")
		@Override
		public PaymentDates.PaymentDatesBuilder setPayRelativeTo(PayRelativeToEnum _payRelativeTo) {
			this.payRelativeTo = _payRelativeTo == null ? null : _payRelativeTo;
			return this;
		}
		
		@RosettaAttribute("paymentDaysOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDaysOffset")
		@Override
		public PaymentDates.PaymentDatesBuilder setPaymentDaysOffset(Offset _paymentDaysOffset) {
			this.paymentDaysOffset = _paymentDaysOffset == null ? null : _paymentDaysOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDatesAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDatesAdjustments")
		@Override
		public PaymentDates.PaymentDatesBuilder setPaymentDatesAdjustments(BusinessDayAdjustments _paymentDatesAdjustments) {
			this.paymentDatesAdjustments = _paymentDatesAdjustments == null ? null : _paymentDatesAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDates build() {
			return new PaymentDates.PaymentDatesImpl(this);
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDates.PaymentDatesBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (resetDatesReference!=null && !resetDatesReference.prune().hasData()) resetDatesReference = null;
			if (valuationDatesReference!=null && !valuationDatesReference.prune().hasData()) valuationDatesReference = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (paymentDaysOffset!=null && !paymentDaysOffset.prune().hasData()) paymentDaysOffset = null;
			if (paymentDatesAdjustments!=null && !paymentDatesAdjustments.prune().hasData()) paymentDatesAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getResetDatesReference()!=null && getResetDatesReference().hasData()) return true;
			if (getValuationDatesReference()!=null && getValuationDatesReference().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getFirstPaymentDate()!=null) return true;
			if (getLastRegularPaymentDate()!=null) return true;
			if (getPayRelativeTo()!=null) return true;
			if (getPaymentDaysOffset()!=null && getPaymentDaysOffset().hasData()) return true;
			if (getPaymentDatesAdjustments()!=null && getPaymentDatesAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDates.PaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDates.PaymentDatesBuilder o = (PaymentDates.PaymentDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getResetDatesReference(), o.getResetDatesReference(), this::setResetDatesReference);
			merger.mergeRosetta(getValuationDatesReference(), o.getValuationDatesReference(), this::setValuationDatesReference);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getPaymentDaysOffset(), o.getPaymentDaysOffset(), this::setPaymentDaysOffset);
			merger.mergeRosetta(getPaymentDatesAdjustments(), o.getPaymentDatesAdjustments(), this::setPaymentDatesAdjustments);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getFirstPaymentDate(), o.getFirstPaymentDate(), this::setFirstPaymentDate);
			merger.mergeBasic(getLastRegularPaymentDate(), o.getLastRegularPaymentDate(), this::setLastRegularPaymentDate);
			merger.mergeBasic(getPayRelativeTo(), o.getPayRelativeTo(), this::setPayRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetDatesReference, _that.getResetDatesReference())) return false;
			if (!Objects.equals(valuationDatesReference, _that.getValuationDatesReference())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(paymentDatesAdjustments, _that.getPaymentDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetDatesReference != null ? resetDatesReference.hashCode() : 0);
			_result = 31 * _result + (valuationDatesReference != null ? valuationDatesReference.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (paymentDatesAdjustments != null ? paymentDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDatesBuilder {" +
				"id=" + this.id + ", " +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetDatesReference=" + this.resetDatesReference + ", " +
				"valuationDatesReference=" + this.valuationDatesReference + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"paymentDatesAdjustments=" + this.paymentDatesAdjustments +
			'}';
		}
	}
}
