package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityDeliveryPeriodsMeta;
import fpml.consolidated.shared.AdjustableDates;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The different options for specifying the Delivery Periods of a physical leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The different options for specifying the Delivery Periods of a physical leg.
 *
 */
@RosettaDataType(value="CommodityDeliveryPeriods", builder=CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityDeliveryPeriods", model="fpml", builder=CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl.class, version="2.1.1")
public interface CommodityDeliveryPeriods extends RosettaModelObject {

	CommodityDeliveryPeriodsMeta metaData = new CommodityDeliveryPeriodsMeta();

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
	 * Provision The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	AdjustableDates getPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Delivery Periods for this leg of the swap. This type is only intended to be used if the Delivery Periods differ from the Calculation Periods on the fixed or floating leg. If DeliveryPeriods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	CommodityCalculationPeriodsSchedule getPeriodsSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPeriods build();
	
	CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder();
	
	static CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder() {
		return new CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPeriods> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityDeliveryPeriods> getType() {
		return CommodityDeliveryPeriods.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("periods"), processor, AdjustableDates.class, getPeriods());
		processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPeriodsBuilder extends CommodityDeliveryPeriods, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreatePeriods();
		@Override
		AdjustableDates.AdjustableDatesBuilder getPeriods();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreatePeriodsSchedule();
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getPeriodsSchedule();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setId(String id);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriods(AdjustableDates periods);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("periods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getPeriods());
			processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPeriods  ***********************/
	class CommodityDeliveryPeriodsImpl implements CommodityDeliveryPeriods {
		private final String id;
		private final AdjustableDates periods;
		private final CommodityCalculationPeriodsSchedule periodsSchedule;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommodityDeliveryPeriodsImpl(CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder) {
			this.id = builder.getId();
			this.periods = ofNullable(builder.getPeriods()).map(f->f.build()).orElse(null);
			this.periodsSchedule = ofNullable(builder.getPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periods")
		public AdjustableDates getPeriods() {
			return periods;
		}
		
		@Override
		@RosettaAttribute("periodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodsSchedule")
		public CommodityCalculationPeriodsSchedule getPeriodsSchedule() {
			return periodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CommodityDeliveryPeriods build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPeriods()).ifPresent(builder::setPeriods);
			ofNullable(getPeriodsSchedule()).ifPresent(builder::setPeriodsSchedule);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periods, _that.getPeriods())) return false;
			if (!Objects.equals(periodsSchedule, _that.getPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periods != null ? periods.hashCode() : 0);
			_result = 31 * _result + (periodsSchedule != null ? periodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriods {" +
				"id=" + this.id + ", " +
				"periods=" + this.periods + ", " +
				"periodsSchedule=" + this.periodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPeriods  ***********************/
	class CommodityDeliveryPeriodsBuilderImpl implements CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder {
	
		protected String id;
		protected AdjustableDates.AdjustableDatesBuilder periods;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder periodsSchedule;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periods")
		public AdjustableDates.AdjustableDatesBuilder getPeriods() {
			return periods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreatePeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (periods!=null) {
				result = periods;
			}
			else {
				result = periods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getPeriodsSchedule() {
			return periodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreatePeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (periodsSchedule!=null) {
				result = periodsSchedule;
			}
			else {
				result = periodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periods")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriods(AdjustableDates _periods) {
			this.periods = _periods == null ? null : _periods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("periodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodsSchedule")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule _periodsSchedule) {
			this.periodsSchedule = _periodsSchedule == null ? null : _periodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriods build() {
			return new CommodityDeliveryPeriods.CommodityDeliveryPeriodsImpl(this);
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder prune() {
			if (periods!=null && !periods.prune().hasData()) periods = null;
			if (periodsSchedule!=null && !periodsSchedule.prune().hasData()) periodsSchedule = null;
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPeriods()!=null && getPeriods().hasData()) return true;
			if (getPeriodsSchedule()!=null && getPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder o = (CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder) other;
			
			merger.mergeRosetta(getPeriods(), o.getPeriods(), this::setPeriods);
			merger.mergeRosetta(getPeriodsSchedule(), o.getPeriodsSchedule(), this::setPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periods, _that.getPeriods())) return false;
			if (!Objects.equals(periodsSchedule, _that.getPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periods != null ? periods.hashCode() : 0);
			_result = 31 * _result + (periodsSchedule != null ? periodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriodsBuilder {" +
				"id=" + this.id + ", " +
				"periods=" + this.periods + ", " +
				"periodsSchedule=" + this.periodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
