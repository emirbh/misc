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
import fpml.consolidated.business.events.meta.TouchRateObservationMeta;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
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
@RosettaDataType(value="TouchRateObservation", builder=TouchRateObservation.TouchRateObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TouchRateObservation", model="fpml", builder=TouchRateObservation.TouchRateObservationBuilderImpl.class, version="2.1.1")
public interface TouchRateObservation extends TriggerRateObservation {

	TouchRateObservationMeta metaData = new TouchRateObservationMeta();

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
	TouchRateObservation build();
	
	TouchRateObservation.TouchRateObservationBuilder toBuilder();
	
	static TouchRateObservation.TouchRateObservationBuilder builder() {
		return new TouchRateObservation.TouchRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TouchRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TouchRateObservation> getType() {
		return TouchRateObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.class, getObservedPrice());
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.class, getPhysicalSettlement());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.class, getClearingInstructions());
		processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TouchRateObservationBuilder extends TouchRateObservation, TriggerRateObservation.TriggerRateObservationBuilder {
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
		@Override
		TouchRateObservation.TouchRateObservationBuilder setObservationDate(ZonedDateTime observationDate);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setInformationSource(InformationSource informationSource);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setTriggerRate(BigDecimal triggerRate);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setObservedRate(BigDecimal observedRate);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setTriggerPrice(PositiveMoney triggerPrice);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setObservedPrice(PositiveMoney observedPrice);
		@Override
		TouchRateObservation.TouchRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		TouchRateObservation.TouchRateObservationBuilder setExerciseSide(ExerciseSideEnum exerciseSide);
		TouchRateObservation.TouchRateObservationBuilder setSettlementType(SettlementTypeEnum settlementType);
		TouchRateObservation.TouchRateObservationBuilder setCashSettlement(SimplePayment cashSettlement);
		TouchRateObservation.TouchRateObservationBuilder setPhysicalSettlement(PhysicalSettlement physicalSettlement);
		TouchRateObservation.TouchRateObservationBuilder setPayment(NonNegativePayment payment);
		TouchRateObservation.TouchRateObservationBuilder setClearingInstructions(ClearingInstructions clearingInstructions);
		TouchRateObservation.TouchRateObservationBuilder setIsExercisable(Boolean isExercisable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getObservedPrice());
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.SimplePaymentBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.PhysicalSettlementBuilder.class, getPhysicalSettlement());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.ClearingInstructionsBuilder.class, getClearingInstructions());
			processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
		}
		

		TouchRateObservation.TouchRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of TouchRateObservation  ***********************/
	class TouchRateObservationImpl extends TriggerRateObservation.TriggerRateObservationImpl implements TouchRateObservation {
		private final ExerciseSideEnum exerciseSide;
		private final SettlementTypeEnum settlementType;
		private final SimplePayment cashSettlement;
		private final PhysicalSettlement physicalSettlement;
		private final NonNegativePayment payment;
		private final ClearingInstructions clearingInstructions;
		private final Boolean isExercisable;
		
		protected TouchRateObservationImpl(TouchRateObservation.TouchRateObservationBuilder builder) {
			super(builder);
			this.exerciseSide = builder.getExerciseSide();
			this.settlementType = builder.getSettlementType();
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.isExercisable = builder.getIsExercisable();
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
		public TouchRateObservation build() {
			return this;
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder toBuilder() {
			TouchRateObservation.TouchRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TouchRateObservation.TouchRateObservationBuilder builder) {
			super.setBuilderFields(builder);
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
			if (!super.equals(o)) return false;
		
			TouchRateObservation _that = getType().cast(o);
		
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
			int _result = super.hashCode();
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
			return "TouchRateObservation {" +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"isExercisable=" + this.isExercisable +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TouchRateObservation  ***********************/
	class TouchRateObservationBuilderImpl extends TriggerRateObservation.TriggerRateObservationBuilderImpl implements TouchRateObservation.TouchRateObservationBuilder {
	
		protected ExerciseSideEnum exerciseSide;
		protected SettlementTypeEnum settlementType;
		protected SimplePayment.SimplePaymentBuilder cashSettlement;
		protected PhysicalSettlement.PhysicalSettlementBuilder physicalSettlement;
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		protected ClearingInstructions.ClearingInstructionsBuilder clearingInstructions;
		protected Boolean isExercisable;
		
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
		
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationDate")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setObservationDate(ZonedDateTime _observationDate) {
			this.observationDate = _observationDate == null ? null : _observationDate;
			return this;
		}
		
		@RosettaAttribute("observationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationTime")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setObservationTime(BusinessCenterTime _observationTime) {
			this.observationTime = _observationTime == null ? null : _observationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedRate")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setObservedRate(BigDecimal _observedRate) {
			this.observedRate = _observedRate == null ? null : _observedRate;
			return this;
		}
		
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerPrice")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setTriggerPrice(PositiveMoney _triggerPrice) {
			this.triggerPrice = _triggerPrice == null ? null : _triggerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedPrice")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setObservedPrice(PositiveMoney _observedPrice) {
			this.observedPrice = _observedPrice == null ? null : _observedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerCondition")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setTriggerCondition(TriggerConditionEnum _triggerCondition) {
			this.triggerCondition = _triggerCondition == null ? null : _triggerCondition;
			return this;
		}
		
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseSide")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setExerciseSide(ExerciseSideEnum _exerciseSide) {
			this.exerciseSide = _exerciseSide == null ? null : _exerciseSide;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setCashSettlement(SimplePayment _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setPhysicalSettlement(PhysicalSettlement _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setPayment(NonNegativePayment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingInstructions")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setClearingInstructions(ClearingInstructions _clearingInstructions) {
			this.clearingInstructions = _clearingInstructions == null ? null : _clearingInstructions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isExercisable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isExercisable")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder setIsExercisable(Boolean _isExercisable) {
			this.isExercisable = _isExercisable == null ? null : _isExercisable;
			return this;
		}
		
		@Override
		public TouchRateObservation build() {
			return new TouchRateObservation.TouchRateObservationImpl(this);
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder prune() {
			super.prune();
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
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
		public TouchRateObservation.TouchRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TouchRateObservation.TouchRateObservationBuilder o = (TouchRateObservation.TouchRateObservationBuilder) other;
			
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getExerciseSide(), o.getExerciseSide(), this::setExerciseSide);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getIsExercisable(), o.getIsExercisable(), this::setIsExercisable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TouchRateObservation _that = getType().cast(o);
		
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
			int _result = super.hashCode();
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
			return "TouchRateObservationBuilder {" +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"isExercisable=" + this.isExercisable +
			'}' + " " + super.toString();
		}
	}
}
