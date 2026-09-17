package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualRegionMeta;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
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
 * Provision Defines a region of spot rate where the notional for the settlement period accrues by the accrued amount per fixing each time the spot rate fixes within the region.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a region of spot rate where the notional for the settlement period accrues by the accrued amount per fixing each time the spot rate fixes within the region.
 *
 */
@RosettaDataType(value="FxAccrualRegion", builder=FxAccrualRegion.FxAccrualRegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualRegion", model="fpml", builder=FxAccrualRegion.FxAccrualRegionBuilderImpl.class, version="2.1.1")
public interface FxAccrualRegion extends RosettaModelObject {

	FxAccrualRegionMeta metaData = new FxAccrualRegionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the FX rate used as the basis for the condition (the accrual region).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the FX rate used as the basis for the condition (the accrual region).
	 *
	 */
	FxRateObservableReference getObservableReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 */
	FxAccrualRegionUpperBound getUpperBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 */
	FxAccrualRegionLowerBound getLowerBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A multiplier applied to the notional amount per fixing of each currency to specify the amount accrued each time the spot rate fixes within the accrual region. If the accrualFactor is omitted, the factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A multiplier applied to the notional amount per fixing of each currency to specify the amount accrued each time the spot rate fixes within the accrual region. If the accrualFactor is omitted, the factor is one.
	 *
	 */
	Schedule getAccrualFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The opposite currency amount. The 'counterCurrencyAmount' element is supplied if the accrual process operates on specific amounts of both notional and counter currency within this accrual region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The opposite currency amount. The 'counterCurrencyAmount' element is supplied if the accrual process operates on specific amounts of both notional and counter currency within this accrual region.
	 *
	 */
	FxCounterCurrencyAmount getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualRegion build();
	
	FxAccrualRegion.FxAccrualRegionBuilder toBuilder();
	
	static FxAccrualRegion.FxAccrualRegionBuilder builder() {
		return new FxAccrualRegion.FxAccrualRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualRegion> getType() {
		return FxAccrualRegion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.class, getObservableReference());
		processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.class, getLowerBound());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("accrualFactor"), processor, Schedule.class, getAccrualFactor());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionBuilder extends FxAccrualRegion, RosettaModelObjectBuilder {
		FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference();
		@Override
		FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound();
		@Override
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound();
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound();
		@Override
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound();
		Schedule.ScheduleBuilder getOrCreateAccrualFactor();
		@Override
		Schedule.ScheduleBuilder getAccrualFactor();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount();
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount();
		FxAccrualRegion.FxAccrualRegionBuilder setObservableReference(FxRateObservableReference observableReference);
		FxAccrualRegion.FxAccrualRegionBuilder setUpperBound(FxAccrualRegionUpperBound upperBound);
		FxAccrualRegion.FxAccrualRegionBuilder setLowerBound(FxAccrualRegionLowerBound lowerBound);
		FxAccrualRegion.FxAccrualRegionBuilder setStartDate(ZonedDateTime startDate);
		FxAccrualRegion.FxAccrualRegionBuilder setEndDate(ZonedDateTime endDate);
		FxAccrualRegion.FxAccrualRegionBuilder setAccrualFactor(Schedule accrualFactor);
		FxAccrualRegion.FxAccrualRegionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualRegion.FxAccrualRegionBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.FxRateObservableReferenceBuilder.class, getObservableReference());
			processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder.class, getLowerBound());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("accrualFactor"), processor, Schedule.ScheduleBuilder.class, getAccrualFactor());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualRegion.FxAccrualRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegion  ***********************/
	class FxAccrualRegionImpl implements FxAccrualRegion {
		private final FxRateObservableReference observableReference;
		private final FxAccrualRegionUpperBound upperBound;
		private final FxAccrualRegionLowerBound lowerBound;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Schedule accrualFactor;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxCounterCurrencyAmount counterCurrencyAmount;
		
		protected FxAccrualRegionImpl(FxAccrualRegion.FxAccrualRegionBuilder builder) {
			this.observableReference = ofNullable(builder.getObservableReference()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.accrualFactor = ofNullable(builder.getAccrualFactor()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observableReference")
		public FxRateObservableReference getObservableReference() {
			return observableReference;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxAccrualRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxAccrualRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualFactor")
		public Schedule getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualRegion build() {
			return this;
		}
		
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder toBuilder() {
			FxAccrualRegion.FxAccrualRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegion.FxAccrualRegionBuilder builder) {
			ofNullable(getObservableReference()).ifPresent(builder::setObservableReference);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getAccrualFactor()).ifPresent(builder::setAccrualFactor);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegion _that = getType().cast(o);
		
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegion {" +
				"observableReference=" + this.observableReference + ", " +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegion  ***********************/
	class FxAccrualRegionBuilderImpl implements FxAccrualRegion.FxAccrualRegionBuilder {
	
		protected FxRateObservableReference.FxRateObservableReferenceBuilder observableReference;
		protected FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder upperBound;
		protected FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder lowerBound;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Schedule.ScheduleBuilder accrualFactor;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder counterCurrencyAmount;
		
		@Override
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observableReference")
		public FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference() {
			return observableReference;
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference() {
			FxRateObservableReference.FxRateObservableReferenceBuilder result;
			if (observableReference!=null) {
				result = observableReference;
			}
			else {
				result = observableReference = FxRateObservableReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxAccrualRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxAccrualRegionLowerBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualFactor")
		public Schedule.ScheduleBuilder getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateAccrualFactor() {
			Schedule.ScheduleBuilder result;
			if (accrualFactor!=null) {
				result = accrualFactor;
			}
			else {
				result = accrualFactor = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount() {
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = FxCounterCurrencyAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("observableReference")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setObservableReference(FxRateObservableReference _observableReference) {
			this.observableReference = _observableReference == null ? null : _observableReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setUpperBound(FxAccrualRegionUpperBound _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setLowerBound(FxAccrualRegionLowerBound _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrualFactor")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setAccrualFactor(Schedule _accrualFactor) {
			this.accrualFactor = _accrualFactor == null ? null : _accrualFactor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegion build() {
			return new FxAccrualRegion.FxAccrualRegionImpl(this);
		}
		
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder prune() {
			if (observableReference!=null && !observableReference.prune().hasData()) observableReference = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (accrualFactor!=null && !accrualFactor.prune().hasData()) accrualFactor = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservableReference()!=null && getObservableReference().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getAccrualFactor()!=null && getAccrualFactor().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegion.FxAccrualRegionBuilder o = (FxAccrualRegion.FxAccrualRegionBuilder) other;
			
			merger.mergeRosetta(getObservableReference(), o.getObservableReference(), this::setObservableReference);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getAccrualFactor(), o.getAccrualFactor(), this::setAccrualFactor);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegion _that = getType().cast(o);
		
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBuilder {" +
				"observableReference=" + this.observableReference + ", " +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
