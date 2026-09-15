package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.NoTouchRateObservationMeta;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.SimplePayment;
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
@RosettaDataType(value="NoTouchRateObservation", builder=NoTouchRateObservation.NoTouchRateObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NoTouchRateObservation", model="fpml", builder=NoTouchRateObservation.NoTouchRateObservationBuilderImpl.class, version="2.1.1")
public interface NoTouchRateObservation extends RosettaModelObject {

	NoTouchRateObservationMeta metaData = new NoTouchRateObservationMeta();

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
	ZonedDateTime getObservationStartDate();
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
	ZonedDateTime getObservationEndDate();
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
	NoTouchLowerBarrierObservation getLowerBarrier();
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
	NoTouchUpperBarrierObservation getUpperBarrier();
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
	ExerciseSideEnum getExerciseSide();
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
	SettlementTypeEnum getSettlementType();
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
	SimplePayment getCashSettlement();
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
	PhysicalSettlement getPhysicalSettlement();
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
	NonNegativePayment getPayment();
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
	ClearingInstructions getClearingInstructions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the touch or no touch event hasn't generated an exercise, then we specify whether the option is exercisable or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the touch or no touch event hasn't generated an exercise, then we specify whether the option is exercisable or not.
	 *
	 */
	Boolean getIsExercisable();

	/*********************** Build Methods  ***********************/
	NoTouchRateObservation build();
	
	NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder();
	
	static NoTouchRateObservation.NoTouchRateObservationBuilder builder() {
		return new NoTouchRateObservation.NoTouchRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NoTouchRateObservation> getType() {
		return NoTouchRateObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
		processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("lowerBarrier"), processor, NoTouchLowerBarrierObservation.class, getLowerBarrier());
		processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.class, getUpperBarrier());
		processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.class, getPhysicalSettlement());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.class, getClearingInstructions());
		processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchRateObservationBuilder extends NoTouchRateObservation, RosettaModelObjectBuilder {
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getOrCreateLowerBarrier();
		@Override
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getLowerBarrier();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier();
		@Override
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier();
		SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement();
		@Override
		SimplePayment.SimplePaymentBuilder getCashSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		@Override
		PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment();
		@Override
		NonNegativePayment.NonNegativePaymentBuilder getPayment();
		ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions();
		@Override
		ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions();
		NoTouchRateObservation.NoTouchRateObservationBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		NoTouchRateObservation.NoTouchRateObservationBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		NoTouchRateObservation.NoTouchRateObservationBuilder setLowerBarrier(NoTouchLowerBarrierObservation lowerBarrier);
		NoTouchRateObservation.NoTouchRateObservationBuilder setUpperBarrier(NoTouchUpperBarrierObservation upperBarrier);
		NoTouchRateObservation.NoTouchRateObservationBuilder setExerciseSide(ExerciseSideEnum exerciseSide);
		NoTouchRateObservation.NoTouchRateObservationBuilder setSettlementType(SettlementTypeEnum settlementType);
		NoTouchRateObservation.NoTouchRateObservationBuilder setCashSettlement(SimplePayment cashSettlement);
		NoTouchRateObservation.NoTouchRateObservationBuilder setPhysicalSettlement(PhysicalSettlement physicalSettlement);
		NoTouchRateObservation.NoTouchRateObservationBuilder setPayment(NonNegativePayment payment);
		NoTouchRateObservation.NoTouchRateObservationBuilder setClearingInstructions(ClearingInstructions clearingInstructions);
		NoTouchRateObservation.NoTouchRateObservationBuilder setIsExercisable(Boolean isExercisable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
			processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("lowerBarrier"), processor, NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder.class, getLowerBarrier());
			processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder.class, getUpperBarrier());
			processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.SimplePaymentBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.PhysicalSettlementBuilder.class, getPhysicalSettlement());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.ClearingInstructionsBuilder.class, getClearingInstructions());
			processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
		}
		

		NoTouchRateObservation.NoTouchRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchRateObservation  ***********************/
	class NoTouchRateObservationImpl implements NoTouchRateObservation {
		private final ZonedDateTime observationStartDate;
		private final ZonedDateTime observationEndDate;
		private final NoTouchLowerBarrierObservation lowerBarrier;
		private final NoTouchUpperBarrierObservation upperBarrier;
		private final ExerciseSideEnum exerciseSide;
		private final SettlementTypeEnum settlementType;
		private final SimplePayment cashSettlement;
		private final PhysicalSettlement physicalSettlement;
		private final NonNegativePayment payment;
		private final ClearingInstructions clearingInstructions;
		private final Boolean isExercisable;
		
		protected NoTouchRateObservationImpl(NoTouchRateObservation.NoTouchRateObservationBuilder builder) {
			this.observationStartDate = builder.getObservationStartDate();
			this.observationEndDate = builder.getObservationEndDate();
			this.lowerBarrier = ofNullable(builder.getLowerBarrier()).map(f->f.build()).orElse(null);
			this.upperBarrier = ofNullable(builder.getUpperBarrier()).map(f->f.build()).orElse(null);
			this.exerciseSide = builder.getExerciseSide();
			this.settlementType = builder.getSettlementType();
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.isExercisable = builder.getIsExercisable();
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public ZonedDateTime getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndDate")
		public ZonedDateTime getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("lowerBarrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBarrier")
		public NoTouchLowerBarrierObservation getLowerBarrier() {
			return lowerBarrier;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public SimplePayment getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public PhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public ClearingInstructions getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@Override
		public NoTouchRateObservation build() {
			return this;
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder() {
			NoTouchRateObservation.NoTouchRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchRateObservation.NoTouchRateObservationBuilder builder) {
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getLowerBarrier()).ifPresent(builder::setLowerBarrier);
			ofNullable(getUpperBarrier()).ifPresent(builder::setUpperBarrier);
			ofNullable(getExerciseSide()).ifPresent(builder::setExerciseSide);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getIsExercisable()).ifPresent(builder::setIsExercisable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(lowerBarrier, _that.getLowerBarrier())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (lowerBarrier != null ? lowerBarrier.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservation {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"lowerBarrier=" + this.lowerBarrier + ", " +
				"upperBarrier=" + this.upperBarrier + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"isExercisable=" + this.isExercisable +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchRateObservation  ***********************/
	class NoTouchRateObservationBuilderImpl implements NoTouchRateObservation.NoTouchRateObservationBuilder {
	
		protected ZonedDateTime observationStartDate;
		protected ZonedDateTime observationEndDate;
		protected NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder lowerBarrier;
		protected NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder upperBarrier;
		protected ExerciseSideEnum exerciseSide;
		protected SettlementTypeEnum settlementType;
		protected SimplePayment.SimplePaymentBuilder cashSettlement;
		protected PhysicalSettlement.PhysicalSettlementBuilder physicalSettlement;
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		protected ClearingInstructions.ClearingInstructionsBuilder clearingInstructions;
		protected Boolean isExercisable;
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public ZonedDateTime getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndDate")
		public ZonedDateTime getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("lowerBarrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBarrier")
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getLowerBarrier() {
			return lowerBarrier;
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getOrCreateLowerBarrier() {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder result;
			if (lowerBarrier!=null) {
				result = lowerBarrier;
			}
			else {
				result = lowerBarrier = NoTouchLowerBarrierObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier() {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder result;
			if (upperBarrier!=null) {
				result = upperBarrier;
			}
			else {
				result = upperBarrier = NoTouchUpperBarrierObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public SimplePayment.SimplePaymentBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement() {
			SimplePayment.SimplePaymentBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			PhysicalSettlement.PhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = PhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment.NonNegativePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions() {
			ClearingInstructions.ClearingInstructionsBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = ClearingInstructions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("lowerBarrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBarrier")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setLowerBarrier(NoTouchLowerBarrierObservation _lowerBarrier) {
			this.lowerBarrier = _lowerBarrier == null ? null : _lowerBarrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upperBarrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBarrier")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setUpperBarrier(NoTouchUpperBarrierObservation _upperBarrier) {
			this.upperBarrier = _upperBarrier == null ? null : _upperBarrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseSide")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setExerciseSide(ExerciseSideEnum _exerciseSide) {
			this.exerciseSide = _exerciseSide == null ? null : _exerciseSide;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setCashSettlement(SimplePayment _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setPhysicalSettlement(PhysicalSettlement _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setPayment(NonNegativePayment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingInstructions")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setClearingInstructions(ClearingInstructions _clearingInstructions) {
			this.clearingInstructions = _clearingInstructions == null ? null : _clearingInstructions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isExercisable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isExercisable")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder setIsExercisable(Boolean _isExercisable) {
			this.isExercisable = _isExercisable == null ? null : _isExercisable;
			return this;
		}
		
		@Override
		public NoTouchRateObservation build() {
			return new NoTouchRateObservation.NoTouchRateObservationImpl(this);
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder prune() {
			if (lowerBarrier!=null && !lowerBarrier.prune().hasData()) lowerBarrier = null;
			if (upperBarrier!=null && !upperBarrier.prune().hasData()) upperBarrier = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationStartDate()!=null) return true;
			if (getObservationEndDate()!=null) return true;
			if (getLowerBarrier()!=null && getLowerBarrier().hasData()) return true;
			if (getUpperBarrier()!=null && getUpperBarrier().hasData()) return true;
			if (getExerciseSide()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			if (getIsExercisable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchRateObservation.NoTouchRateObservationBuilder o = (NoTouchRateObservation.NoTouchRateObservationBuilder) other;
			
			merger.mergeRosetta(getLowerBarrier(), o.getLowerBarrier(), this::setLowerBarrier);
			merger.mergeRosetta(getUpperBarrier(), o.getUpperBarrier(), this::setUpperBarrier);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			merger.mergeBasic(getExerciseSide(), o.getExerciseSide(), this::setExerciseSide);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getIsExercisable(), o.getIsExercisable(), this::setIsExercisable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(lowerBarrier, _that.getLowerBarrier())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (lowerBarrier != null ? lowerBarrier.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationBuilder {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"lowerBarrier=" + this.lowerBarrier + ", " +
				"upperBarrier=" + this.upperBarrier + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"isExercisable=" + this.isExercisable +
			'}';
		}
	}
}
