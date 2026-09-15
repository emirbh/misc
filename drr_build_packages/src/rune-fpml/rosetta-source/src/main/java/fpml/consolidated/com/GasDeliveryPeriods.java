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
import fpml.consolidated.com.meta.GasDeliveryPeriodsMeta;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.PrevailingTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The different options for specifying the Delivery Periods for a physically settled gas trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The different options for specifying the Delivery Periods for a physically settled gas trade.
 *
 */
@RosettaDataType(value="GasDeliveryPeriods", builder=GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasDeliveryPeriods", model="fpml", builder=GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl.class, version="2.1.1")
public interface GasDeliveryPeriods extends CommodityDeliveryPeriods {

	GasDeliveryPeriodsMeta metaData = new GasDeliveryPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which gas delivery should start on each day of the Delivery Period(s).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which gas delivery should start on each day of the Delivery Period(s).
	 *
	 */
	PrevailingTime getSupplyStartTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which gas delivery should end on each day of the Delivery Period(s).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which gas delivery should end on each day of the Delivery Period(s).
	 *
	 */
	PrevailingTime getSupplyEndTime();

	/*********************** Build Methods  ***********************/
	GasDeliveryPeriods build();
	
	GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder();
	
	static GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder() {
		return new GasDeliveryPeriods.GasDeliveryPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliveryPeriods> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasDeliveryPeriods> getType() {
		return GasDeliveryPeriods.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("periods"), processor, AdjustableDates.class, getPeriods());
		processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
		processRosetta(path.newSubPath("supplyStartTime"), processor, PrevailingTime.class, getSupplyStartTime());
		processRosetta(path.newSubPath("supplyEndTime"), processor, PrevailingTime.class, getSupplyEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryPeriodsBuilder extends GasDeliveryPeriods, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder {
		PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyStartTime();
		@Override
		PrevailingTime.PrevailingTimeBuilder getSupplyStartTime();
		PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyEndTime();
		@Override
		PrevailingTime.PrevailingTimeBuilder getSupplyEndTime();
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setId(String id);
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriods(AdjustableDates periods);
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule periodsSchedule);
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setSupplyStartTime(PrevailingTime supplyStartTime);
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder setSupplyEndTime(PrevailingTime supplyEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("periods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getPeriods());
			processRosetta(path.newSubPath("periodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
			processRosetta(path.newSubPath("supplyStartTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getSupplyStartTime());
			processRosetta(path.newSubPath("supplyEndTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getSupplyEndTime());
		}
		

		GasDeliveryPeriods.GasDeliveryPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliveryPeriods  ***********************/
	class GasDeliveryPeriodsImpl extends CommodityDeliveryPeriods.CommodityDeliveryPeriodsImpl implements GasDeliveryPeriods {
		private final PrevailingTime supplyStartTime;
		private final PrevailingTime supplyEndTime;
		
		protected GasDeliveryPeriodsImpl(GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder) {
			super(builder);
			this.supplyStartTime = ofNullable(builder.getSupplyStartTime()).map(f->f.build()).orElse(null);
			this.supplyEndTime = ofNullable(builder.getSupplyEndTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supplyStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supplyStartTime")
		public PrevailingTime getSupplyStartTime() {
			return supplyStartTime;
		}
		
		@Override
		@RosettaAttribute("supplyEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supplyEndTime")
		public PrevailingTime getSupplyEndTime() {
			return supplyEndTime;
		}
		
		@Override
		public GasDeliveryPeriods build() {
			return this;
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder() {
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliveryPeriods.GasDeliveryPeriodsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupplyStartTime()).ifPresent(builder::setSupplyStartTime);
			ofNullable(getSupplyEndTime()).ifPresent(builder::setSupplyEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(supplyStartTime, _that.getSupplyStartTime())) return false;
			if (!Objects.equals(supplyEndTime, _that.getSupplyEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supplyStartTime != null ? supplyStartTime.hashCode() : 0);
			_result = 31 * _result + (supplyEndTime != null ? supplyEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriods {" +
				"supplyStartTime=" + this.supplyStartTime + ", " +
				"supplyEndTime=" + this.supplyEndTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasDeliveryPeriods  ***********************/
	class GasDeliveryPeriodsBuilderImpl extends CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilderImpl implements GasDeliveryPeriods.GasDeliveryPeriodsBuilder {
	
		protected PrevailingTime.PrevailingTimeBuilder supplyStartTime;
		protected PrevailingTime.PrevailingTimeBuilder supplyEndTime;
		
		@Override
		@RosettaAttribute("supplyStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supplyStartTime")
		public PrevailingTime.PrevailingTimeBuilder getSupplyStartTime() {
			return supplyStartTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyStartTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (supplyStartTime!=null) {
				result = supplyStartTime;
			}
			else {
				result = supplyStartTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supplyEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supplyEndTime")
		public PrevailingTime.PrevailingTimeBuilder getSupplyEndTime() {
			return supplyEndTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyEndTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (supplyEndTime!=null) {
				result = supplyEndTime;
			}
			else {
				result = supplyEndTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periods")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriods(AdjustableDates _periods) {
			this.periods = _periods == null ? null : _periods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("periodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodsSchedule")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setPeriodsSchedule(CommodityCalculationPeriodsSchedule _periodsSchedule) {
			this.periodsSchedule = _periodsSchedule == null ? null : _periodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supplyStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supplyStartTime")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setSupplyStartTime(PrevailingTime _supplyStartTime) {
			this.supplyStartTime = _supplyStartTime == null ? null : _supplyStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supplyEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supplyEndTime")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder setSupplyEndTime(PrevailingTime _supplyEndTime) {
			this.supplyEndTime = _supplyEndTime == null ? null : _supplyEndTime.toBuilder();
			return this;
		}
		
		@Override
		public GasDeliveryPeriods build() {
			return new GasDeliveryPeriods.GasDeliveryPeriodsImpl(this);
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder prune() {
			super.prune();
			if (supplyStartTime!=null && !supplyStartTime.prune().hasData()) supplyStartTime = null;
			if (supplyEndTime!=null && !supplyEndTime.prune().hasData()) supplyEndTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupplyStartTime()!=null && getSupplyStartTime().hasData()) return true;
			if (getSupplyEndTime()!=null && getSupplyEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder o = (GasDeliveryPeriods.GasDeliveryPeriodsBuilder) other;
			
			merger.mergeRosetta(getSupplyStartTime(), o.getSupplyStartTime(), this::setSupplyStartTime);
			merger.mergeRosetta(getSupplyEndTime(), o.getSupplyEndTime(), this::setSupplyEndTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(supplyStartTime, _that.getSupplyStartTime())) return false;
			if (!Objects.equals(supplyEndTime, _that.getSupplyEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supplyStartTime != null ? supplyStartTime.hashCode() : 0);
			_result = 31 * _result + (supplyEndTime != null ? supplyEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriodsBuilder {" +
				"supplyStartTime=" + this.supplyStartTime + ", " +
				"supplyEndTime=" + this.supplyEndTime +
			'}' + " " + super.toString();
		}
	}
}
