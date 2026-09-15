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
import fpml.consolidated.fpmlenum.ResetRelativeToEnum;
import fpml.consolidated.ird.meta.ResetDatesMeta;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.ResetFrequency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the parameters used to generate the reset dates schedule and associated fixing dates. The reset dates are determined relative to the calculation periods schedules dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters used to generate the reset dates schedule and associated fixing dates. The reset dates are determined relative to the calculation periods schedules dates.
 *
 */
@RosettaDataType(value="ResetDates", builder=ResetDates.ResetDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetDates", model="fpml", builder=ResetDates.ResetDatesBuilderImpl.class, version="2.1.1")
public interface ResetDates extends RosettaModelObject {

	ResetDatesMeta metaData = new ResetDatesMeta();

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
	 * Provision Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
	 *
	 */
	ResetRelativeToEnum getResetRelativeTo();
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
	RelativeDateOffset getInitialFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixing date relative to the reset date in terms of a business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction. The href attribute on the dateRelativeTo element should reference the id attribute on the resetDates element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixing date relative to the reset date in terms of a business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction. The href attribute on the dateRelativeTo element should reference the id attribute on the resetDates element.
	 *
	 */
	RelativeDateOffset getFixingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.
	 *
	 */
	Offset getRateCutOffDaysOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset date is established for each calculation period and some form of rate averaging is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset date is established for each calculation period and some form of rate averaging is applicable.
	 *
	 */
	ResetFrequency getResetFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The business day convention to apply to each reset date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business day convention to apply to each reset date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 */
	BusinessDayAdjustments getResetDatesAdjustments();

	/*********************** Build Methods  ***********************/
	ResetDates build();
	
	ResetDates.ResetDatesBuilder toBuilder();
	
	static ResetDates.ResetDatesBuilder builder() {
		return new ResetDates.ResetDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetDates> getType() {
		return ResetDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processor.processBasic(path.newSubPath("resetRelativeTo"), ResetRelativeToEnum.class, getResetRelativeTo(), this);
		processRosetta(path.newSubPath("initialFixingDate"), processor, RelativeDateOffset.class, getInitialFixingDate());
		processRosetta(path.newSubPath("fixingDates"), processor, RelativeDateOffset.class, getFixingDates());
		processRosetta(path.newSubPath("rateCutOffDaysOffset"), processor, Offset.class, getRateCutOffDaysOffset());
		processRosetta(path.newSubPath("resetFrequency"), processor, ResetFrequency.class, getResetFrequency());
		processRosetta(path.newSubPath("resetDatesAdjustments"), processor, BusinessDayAdjustments.class, getResetDatesAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetDatesBuilder extends ResetDates, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		@Override
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateInitialFixingDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getInitialFixingDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDates();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getFixingDates();
		Offset.OffsetBuilder getOrCreateRateCutOffDaysOffset();
		@Override
		Offset.OffsetBuilder getRateCutOffDaysOffset();
		ResetFrequency.ResetFrequencyBuilder getOrCreateResetFrequency();
		@Override
		ResetFrequency.ResetFrequencyBuilder getResetFrequency();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateResetDatesAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getResetDatesAdjustments();
		ResetDates.ResetDatesBuilder setId(String id);
		ResetDates.ResetDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference);
		ResetDates.ResetDatesBuilder setResetRelativeTo(ResetRelativeToEnum resetRelativeTo);
		ResetDates.ResetDatesBuilder setInitialFixingDate(RelativeDateOffset initialFixingDate);
		ResetDates.ResetDatesBuilder setFixingDates(RelativeDateOffset fixingDates);
		ResetDates.ResetDatesBuilder setRateCutOffDaysOffset(Offset rateCutOffDaysOffset);
		ResetDates.ResetDatesBuilder setResetFrequency(ResetFrequency resetFrequency);
		ResetDates.ResetDatesBuilder setResetDatesAdjustments(BusinessDayAdjustments resetDatesAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processor.processBasic(path.newSubPath("resetRelativeTo"), ResetRelativeToEnum.class, getResetRelativeTo(), this);
			processRosetta(path.newSubPath("initialFixingDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getInitialFixingDate());
			processRosetta(path.newSubPath("fixingDates"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFixingDates());
			processRosetta(path.newSubPath("rateCutOffDaysOffset"), processor, Offset.OffsetBuilder.class, getRateCutOffDaysOffset());
			processRosetta(path.newSubPath("resetFrequency"), processor, ResetFrequency.ResetFrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("resetDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getResetDatesAdjustments());
		}
		

		ResetDates.ResetDatesBuilder prune();
	}

	/*********************** Immutable Implementation of ResetDates  ***********************/
	class ResetDatesImpl implements ResetDates {
		private final String id;
		private final CalculationPeriodDatesReference calculationPeriodDatesReference;
		private final ResetRelativeToEnum resetRelativeTo;
		private final RelativeDateOffset initialFixingDate;
		private final RelativeDateOffset fixingDates;
		private final Offset rateCutOffDaysOffset;
		private final ResetFrequency resetFrequency;
		private final BusinessDayAdjustments resetDatesAdjustments;
		
		protected ResetDatesImpl(ResetDates.ResetDatesBuilder builder) {
			this.id = builder.getId();
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.resetRelativeTo = builder.getResetRelativeTo();
			this.initialFixingDate = ofNullable(builder.getInitialFixingDate()).map(f->f.build()).orElse(null);
			this.fixingDates = ofNullable(builder.getFixingDates()).map(f->f.build()).orElse(null);
			this.rateCutOffDaysOffset = ofNullable(builder.getRateCutOffDaysOffset()).map(f->f.build()).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).map(f->f.build()).orElse(null);
			this.resetDatesAdjustments = ofNullable(builder.getResetDatesAdjustments()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("resetRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetRelativeTo")
		public ResetRelativeToEnum getResetRelativeTo() {
			return resetRelativeTo;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFixingDate")
		public RelativeDateOffset getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDates")
		public RelativeDateOffset getFixingDates() {
			return fixingDates;
		}
		
		@Override
		@RosettaAttribute("rateCutOffDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCutOffDaysOffset")
		public Offset getRateCutOffDaysOffset() {
			return rateCutOffDaysOffset;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("resetFrequency")
		public ResetFrequency getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("resetDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDatesAdjustments")
		public BusinessDayAdjustments getResetDatesAdjustments() {
			return resetDatesAdjustments;
		}
		
		@Override
		public ResetDates build() {
			return this;
		}
		
		@Override
		public ResetDates.ResetDatesBuilder toBuilder() {
			ResetDates.ResetDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetDates.ResetDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getResetRelativeTo()).ifPresent(builder::setResetRelativeTo);
			ofNullable(getInitialFixingDate()).ifPresent(builder::setInitialFixingDate);
			ofNullable(getFixingDates()).ifPresent(builder::setFixingDates);
			ofNullable(getRateCutOffDaysOffset()).ifPresent(builder::setRateCutOffDaysOffset);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getResetDatesAdjustments()).ifPresent(builder::setResetDatesAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetRelativeTo, _that.getResetRelativeTo())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(fixingDates, _that.getFixingDates())) return false;
			if (!Objects.equals(rateCutOffDaysOffset, _that.getRateCutOffDaysOffset())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(resetDatesAdjustments, _that.getResetDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetRelativeTo != null ? resetRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingDates != null ? fixingDates.hashCode() : 0);
			_result = 31 * _result + (rateCutOffDaysOffset != null ? rateCutOffDaysOffset.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (resetDatesAdjustments != null ? resetDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetDates {" +
				"id=" + this.id + ", " +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetRelativeTo=" + this.resetRelativeTo + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"fixingDates=" + this.fixingDates + ", " +
				"rateCutOffDaysOffset=" + this.rateCutOffDaysOffset + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"resetDatesAdjustments=" + this.resetDatesAdjustments +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetDates  ***********************/
	class ResetDatesBuilderImpl implements ResetDates.ResetDatesBuilder {
	
		protected String id;
		protected CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected ResetRelativeToEnum resetRelativeTo;
		protected RelativeDateOffset.RelativeDateOffsetBuilder initialFixingDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder fixingDates;
		protected Offset.OffsetBuilder rateCutOffDaysOffset;
		protected ResetFrequency.ResetFrequencyBuilder resetFrequency;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder resetDatesAdjustments;
		
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
		@RosettaAttribute("resetRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetRelativeTo")
		public ResetRelativeToEnum getResetRelativeTo() {
			return resetRelativeTo;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFixingDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateInitialFixingDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (initialFixingDate!=null) {
				result = initialFixingDate;
			}
			else {
				result = initialFixingDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDates")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFixingDates() {
			return fixingDates;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDates() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (fixingDates!=null) {
				result = fixingDates;
			}
			else {
				result = fixingDates = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCutOffDaysOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCutOffDaysOffset")
		public Offset.OffsetBuilder getRateCutOffDaysOffset() {
			return rateCutOffDaysOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateRateCutOffDaysOffset() {
			Offset.OffsetBuilder result;
			if (rateCutOffDaysOffset!=null) {
				result = rateCutOffDaysOffset;
			}
			else {
				result = rateCutOffDaysOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("resetFrequency")
		public ResetFrequency.ResetFrequencyBuilder getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder getOrCreateResetFrequency() {
			ResetFrequency.ResetFrequencyBuilder result;
			if (resetFrequency!=null) {
				result = resetFrequency;
			}
			else {
				result = resetFrequency = ResetFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getResetDatesAdjustments() {
			return resetDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateResetDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (resetDatesAdjustments!=null) {
				result = resetDatesAdjustments;
			}
			else {
				result = resetDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ResetDates.ResetDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		@Override
		public ResetDates.ResetDatesBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference _calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = _calculationPeriodDatesReference == null ? null : _calculationPeriodDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetRelativeTo")
		@Override
		public ResetDates.ResetDatesBuilder setResetRelativeTo(ResetRelativeToEnum _resetRelativeTo) {
			this.resetRelativeTo = _resetRelativeTo == null ? null : _resetRelativeTo;
			return this;
		}
		
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialFixingDate")
		@Override
		public ResetDates.ResetDatesBuilder setInitialFixingDate(RelativeDateOffset _initialFixingDate) {
			this.initialFixingDate = _initialFixingDate == null ? null : _initialFixingDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDates")
		@Override
		public ResetDates.ResetDatesBuilder setFixingDates(RelativeDateOffset _fixingDates) {
			this.fixingDates = _fixingDates == null ? null : _fixingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateCutOffDaysOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateCutOffDaysOffset")
		@Override
		public ResetDates.ResetDatesBuilder setRateCutOffDaysOffset(Offset _rateCutOffDaysOffset) {
			this.rateCutOffDaysOffset = _rateCutOffDaysOffset == null ? null : _rateCutOffDaysOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("resetFrequency")
		@Override
		public ResetDates.ResetDatesBuilder setResetFrequency(ResetFrequency _resetFrequency) {
			this.resetFrequency = _resetFrequency == null ? null : _resetFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetDatesAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetDatesAdjustments")
		@Override
		public ResetDates.ResetDatesBuilder setResetDatesAdjustments(BusinessDayAdjustments _resetDatesAdjustments) {
			this.resetDatesAdjustments = _resetDatesAdjustments == null ? null : _resetDatesAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public ResetDates build() {
			return new ResetDates.ResetDatesImpl(this);
		}
		
		@Override
		public ResetDates.ResetDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetDates.ResetDatesBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (initialFixingDate!=null && !initialFixingDate.prune().hasData()) initialFixingDate = null;
			if (fixingDates!=null && !fixingDates.prune().hasData()) fixingDates = null;
			if (rateCutOffDaysOffset!=null && !rateCutOffDaysOffset.prune().hasData()) rateCutOffDaysOffset = null;
			if (resetFrequency!=null && !resetFrequency.prune().hasData()) resetFrequency = null;
			if (resetDatesAdjustments!=null && !resetDatesAdjustments.prune().hasData()) resetDatesAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getResetRelativeTo()!=null) return true;
			if (getInitialFixingDate()!=null && getInitialFixingDate().hasData()) return true;
			if (getFixingDates()!=null && getFixingDates().hasData()) return true;
			if (getRateCutOffDaysOffset()!=null && getRateCutOffDaysOffset().hasData()) return true;
			if (getResetFrequency()!=null && getResetFrequency().hasData()) return true;
			if (getResetDatesAdjustments()!=null && getResetDatesAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetDates.ResetDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetDates.ResetDatesBuilder o = (ResetDates.ResetDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getInitialFixingDate(), o.getInitialFixingDate(), this::setInitialFixingDate);
			merger.mergeRosetta(getFixingDates(), o.getFixingDates(), this::setFixingDates);
			merger.mergeRosetta(getRateCutOffDaysOffset(), o.getRateCutOffDaysOffset(), this::setRateCutOffDaysOffset);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::setResetFrequency);
			merger.mergeRosetta(getResetDatesAdjustments(), o.getResetDatesAdjustments(), this::setResetDatesAdjustments);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getResetRelativeTo(), o.getResetRelativeTo(), this::setResetRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetRelativeTo, _that.getResetRelativeTo())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(fixingDates, _that.getFixingDates())) return false;
			if (!Objects.equals(rateCutOffDaysOffset, _that.getRateCutOffDaysOffset())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(resetDatesAdjustments, _that.getResetDatesAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetRelativeTo != null ? resetRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingDates != null ? fixingDates.hashCode() : 0);
			_result = 31 * _result + (rateCutOffDaysOffset != null ? rateCutOffDaysOffset.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (resetDatesAdjustments != null ? resetDatesAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetDatesBuilder {" +
				"id=" + this.id + ", " +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetRelativeTo=" + this.resetRelativeTo + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"fixingDates=" + this.fixingDates + ", " +
				"rateCutOffDaysOffset=" + this.rateCutOffDaysOffset + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"resetDatesAdjustments=" + this.resetDatesAdjustments +
			'}';
		}
	}
}
