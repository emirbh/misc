package iso20022.auth030.fca;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import iso20022.auth030.fca.meta.EnergyDeliveryAttribute10__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Information related to energy derivatives attributes.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyDeliveryAttribute10__1", builder=EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyDeliveryAttribute10__1", model="iso20022", builder=EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1BuilderImpl.class, version="${project.version}")
public interface EnergyDeliveryAttribute10__1 extends RosettaModelObject {

	EnergyDeliveryAttribute10__1Meta metaData = new EnergyDeliveryAttribute10__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Time interval for each block or shape.
	 */
	List<? extends TimePeriodDetails1> getDlvryIntrvl();
	/**
	 * Definition of delivery start date and end date.
	 */
	DatePeriod1 getDlvryDt();
	/**
	 * Duration of the delivery period.
	 */
	DurationType1Code getDrtn();
	/**
	 * Days of the week of the delivery.
	 */
	List<WeekDay3Code__1> getWkDay();
	/**
	 * Delivery capacity for each delivery interval specified.
	 */
	Quantity47Choice__1 getDlvryCpcty();
	/**
	 * Daily or hourly quantity in MWh or kWh/d which corresponds to the underlying commodity.
	 */
	EnergyQuantityUnit2Choice__1 getQtyUnit();
	/**
	 * Indicates if applicable the price per quantity per delivery time interval.
	 */
	AmountAndDirection106__3 getPricTmIntrvlQty();

	/*********************** Build Methods  ***********************/
	EnergyDeliveryAttribute10__1 build();
	
	EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder toBuilder();
	
	static EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder builder() {
		return new EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyDeliveryAttribute10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyDeliveryAttribute10__1> getType() {
		return EnergyDeliveryAttribute10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dlvryIntrvl"), processor, TimePeriodDetails1.class, getDlvryIntrvl());
		processRosetta(path.newSubPath("dlvryDt"), processor, DatePeriod1.class, getDlvryDt());
		processor.processBasic(path.newSubPath("drtn"), DurationType1Code.class, getDrtn(), this);
		processor.processBasic(path.newSubPath("wkDay"), WeekDay3Code__1.class, getWkDay(), this);
		processRosetta(path.newSubPath("dlvryCpcty"), processor, Quantity47Choice__1.class, getDlvryCpcty());
		processRosetta(path.newSubPath("qtyUnit"), processor, EnergyQuantityUnit2Choice__1.class, getQtyUnit());
		processRosetta(path.newSubPath("pricTmIntrvlQty"), processor, AmountAndDirection106__3.class, getPricTmIntrvlQty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyDeliveryAttribute10__1Builder extends EnergyDeliveryAttribute10__1, RosettaModelObjectBuilder {
		TimePeriodDetails1.TimePeriodDetails1Builder getOrCreateDlvryIntrvl(int index);
		@Override
		List<? extends TimePeriodDetails1.TimePeriodDetails1Builder> getDlvryIntrvl();
		DatePeriod1.DatePeriod1Builder getOrCreateDlvryDt();
		@Override
		DatePeriod1.DatePeriod1Builder getDlvryDt();
		Quantity47Choice__1.Quantity47Choice__1Builder getOrCreateDlvryCpcty();
		@Override
		Quantity47Choice__1.Quantity47Choice__1Builder getDlvryCpcty();
		EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder getOrCreateQtyUnit();
		@Override
		EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder getQtyUnit();
		AmountAndDirection106__3.AmountAndDirection106__3Builder getOrCreatePricTmIntrvlQty();
		@Override
		AmountAndDirection106__3.AmountAndDirection106__3Builder getPricTmIntrvlQty();
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(TimePeriodDetails1 dlvryIntrvl);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(TimePeriodDetails1 dlvryIntrvl, int idx);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(List<? extends TimePeriodDetails1> dlvryIntrvl);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryIntrvl(List<? extends TimePeriodDetails1> dlvryIntrvl);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryDt(DatePeriod1 dlvryDt);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDrtn(DurationType1Code drtn);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(WeekDay3Code__1 wkDay);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(WeekDay3Code__1 wkDay, int idx);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(List<WeekDay3Code__1> wkDay);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setWkDay(List<WeekDay3Code__1> wkDay);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryCpcty(Quantity47Choice__1 dlvryCpcty);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setQtyUnit(EnergyQuantityUnit2Choice__1 qtyUnit);
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setPricTmIntrvlQty(AmountAndDirection106__3 pricTmIntrvlQty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dlvryIntrvl"), processor, TimePeriodDetails1.TimePeriodDetails1Builder.class, getDlvryIntrvl());
			processRosetta(path.newSubPath("dlvryDt"), processor, DatePeriod1.DatePeriod1Builder.class, getDlvryDt());
			processor.processBasic(path.newSubPath("drtn"), DurationType1Code.class, getDrtn(), this);
			processor.processBasic(path.newSubPath("wkDay"), WeekDay3Code__1.class, getWkDay(), this);
			processRosetta(path.newSubPath("dlvryCpcty"), processor, Quantity47Choice__1.Quantity47Choice__1Builder.class, getDlvryCpcty());
			processRosetta(path.newSubPath("qtyUnit"), processor, EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder.class, getQtyUnit());
			processRosetta(path.newSubPath("pricTmIntrvlQty"), processor, AmountAndDirection106__3.AmountAndDirection106__3Builder.class, getPricTmIntrvlQty());
		}
		

		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder prune();
	}

	/*********************** Immutable Implementation of EnergyDeliveryAttribute10__1  ***********************/
	class EnergyDeliveryAttribute10__1Impl implements EnergyDeliveryAttribute10__1 {
		private final List<? extends TimePeriodDetails1> dlvryIntrvl;
		private final DatePeriod1 dlvryDt;
		private final DurationType1Code drtn;
		private final List<WeekDay3Code__1> wkDay;
		private final Quantity47Choice__1 dlvryCpcty;
		private final EnergyQuantityUnit2Choice__1 qtyUnit;
		private final AmountAndDirection106__3 pricTmIntrvlQty;
		
		protected EnergyDeliveryAttribute10__1Impl(EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder builder) {
			this.dlvryIntrvl = ofNullable(builder.getDlvryIntrvl()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dlvryDt = ofNullable(builder.getDlvryDt()).map(f->f.build()).orElse(null);
			this.drtn = builder.getDrtn();
			this.wkDay = ofNullable(builder.getWkDay()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dlvryCpcty = ofNullable(builder.getDlvryCpcty()).map(f->f.build()).orElse(null);
			this.qtyUnit = ofNullable(builder.getQtyUnit()).map(f->f.build()).orElse(null);
			this.pricTmIntrvlQty = ofNullable(builder.getPricTmIntrvlQty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dlvryIntrvl")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dlvryIntrvl")
		public List<? extends TimePeriodDetails1> getDlvryIntrvl() {
			return dlvryIntrvl;
		}
		
		@Override
		@RosettaAttribute("dlvryDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryDt")
		public DatePeriod1 getDlvryDt() {
			return dlvryDt;
		}
		
		@Override
		@RosettaAttribute("drtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drtn")
		public DurationType1Code getDrtn() {
			return drtn;
		}
		
		@Override
		@RosettaAttribute("wkDay")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("wkDay")
		public List<WeekDay3Code__1> getWkDay() {
			return wkDay;
		}
		
		@Override
		@RosettaAttribute("dlvryCpcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryCpcty")
		public Quantity47Choice__1 getDlvryCpcty() {
			return dlvryCpcty;
		}
		
		@Override
		@RosettaAttribute("qtyUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qtyUnit")
		public EnergyQuantityUnit2Choice__1 getQtyUnit() {
			return qtyUnit;
		}
		
		@Override
		@RosettaAttribute("pricTmIntrvlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricTmIntrvlQty")
		public AmountAndDirection106__3 getPricTmIntrvlQty() {
			return pricTmIntrvlQty;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1 build() {
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder toBuilder() {
			EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder builder) {
			ofNullable(getDlvryIntrvl()).ifPresent(builder::setDlvryIntrvl);
			ofNullable(getDlvryDt()).ifPresent(builder::setDlvryDt);
			ofNullable(getDrtn()).ifPresent(builder::setDrtn);
			ofNullable(getWkDay()).ifPresent(builder::setWkDay);
			ofNullable(getDlvryCpcty()).ifPresent(builder::setDlvryCpcty);
			ofNullable(getQtyUnit()).ifPresent(builder::setQtyUnit);
			ofNullable(getPricTmIntrvlQty()).ifPresent(builder::setPricTmIntrvlQty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyDeliveryAttribute10__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dlvryIntrvl, _that.getDlvryIntrvl())) return false;
			if (!Objects.equals(dlvryDt, _that.getDlvryDt())) return false;
			if (!Objects.equals(drtn, _that.getDrtn())) return false;
			if (!ListEquals.listEquals(wkDay, _that.getWkDay())) return false;
			if (!Objects.equals(dlvryCpcty, _that.getDlvryCpcty())) return false;
			if (!Objects.equals(qtyUnit, _that.getQtyUnit())) return false;
			if (!Objects.equals(pricTmIntrvlQty, _that.getPricTmIntrvlQty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryIntrvl != null ? dlvryIntrvl.hashCode() : 0);
			_result = 31 * _result + (dlvryDt != null ? dlvryDt.hashCode() : 0);
			_result = 31 * _result + (drtn != null ? drtn.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (wkDay != null ? wkDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dlvryCpcty != null ? dlvryCpcty.hashCode() : 0);
			_result = 31 * _result + (qtyUnit != null ? qtyUnit.hashCode() : 0);
			_result = 31 * _result + (pricTmIntrvlQty != null ? pricTmIntrvlQty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnergyDeliveryAttribute10__1 {" +
				"dlvryIntrvl=" + this.dlvryIntrvl + ", " +
				"dlvryDt=" + this.dlvryDt + ", " +
				"drtn=" + this.drtn + ", " +
				"wkDay=" + this.wkDay + ", " +
				"dlvryCpcty=" + this.dlvryCpcty + ", " +
				"qtyUnit=" + this.qtyUnit + ", " +
				"pricTmIntrvlQty=" + this.pricTmIntrvlQty +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyDeliveryAttribute10__1  ***********************/
	class EnergyDeliveryAttribute10__1BuilderImpl implements EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder {
	
		protected List<TimePeriodDetails1.TimePeriodDetails1Builder> dlvryIntrvl = new ArrayList<>();
		protected DatePeriod1.DatePeriod1Builder dlvryDt;
		protected DurationType1Code drtn;
		protected List<WeekDay3Code__1> wkDay = new ArrayList<>();
		protected Quantity47Choice__1.Quantity47Choice__1Builder dlvryCpcty;
		protected EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder qtyUnit;
		protected AmountAndDirection106__3.AmountAndDirection106__3Builder pricTmIntrvlQty;
		
		@Override
		@RosettaAttribute("dlvryIntrvl")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dlvryIntrvl")
		public List<? extends TimePeriodDetails1.TimePeriodDetails1Builder> getDlvryIntrvl() {
			return dlvryIntrvl;
		}
		
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder getOrCreateDlvryIntrvl(int index) {
			if (dlvryIntrvl==null) {
				this.dlvryIntrvl = new ArrayList<>();
			}
			return getIndex(dlvryIntrvl, index, () -> {
						TimePeriodDetails1.TimePeriodDetails1Builder newDlvryIntrvl = TimePeriodDetails1.builder();
						return newDlvryIntrvl;
					});
		}
		
		@Override
		@RosettaAttribute("dlvryDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryDt")
		public DatePeriod1.DatePeriod1Builder getDlvryDt() {
			return dlvryDt;
		}
		
		@Override
		public DatePeriod1.DatePeriod1Builder getOrCreateDlvryDt() {
			DatePeriod1.DatePeriod1Builder result;
			if (dlvryDt!=null) {
				result = dlvryDt;
			}
			else {
				result = dlvryDt = DatePeriod1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("drtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drtn")
		public DurationType1Code getDrtn() {
			return drtn;
		}
		
		@Override
		@RosettaAttribute("wkDay")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("wkDay")
		public List<WeekDay3Code__1> getWkDay() {
			return wkDay;
		}
		
		@Override
		@RosettaAttribute("dlvryCpcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryCpcty")
		public Quantity47Choice__1.Quantity47Choice__1Builder getDlvryCpcty() {
			return dlvryCpcty;
		}
		
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder getOrCreateDlvryCpcty() {
			Quantity47Choice__1.Quantity47Choice__1Builder result;
			if (dlvryCpcty!=null) {
				result = dlvryCpcty;
			}
			else {
				result = dlvryCpcty = Quantity47Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("qtyUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qtyUnit")
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder getQtyUnit() {
			return qtyUnit;
		}
		
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder getOrCreateQtyUnit() {
			EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder result;
			if (qtyUnit!=null) {
				result = qtyUnit;
			}
			else {
				result = qtyUnit = EnergyQuantityUnit2Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricTmIntrvlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricTmIntrvlQty")
		public AmountAndDirection106__3.AmountAndDirection106__3Builder getPricTmIntrvlQty() {
			return pricTmIntrvlQty;
		}
		
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder getOrCreatePricTmIntrvlQty() {
			AmountAndDirection106__3.AmountAndDirection106__3Builder result;
			if (pricTmIntrvlQty!=null) {
				result = pricTmIntrvlQty;
			}
			else {
				result = pricTmIntrvlQty = AmountAndDirection106__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dlvryIntrvl")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dlvryIntrvl")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(TimePeriodDetails1 _dlvryIntrvl) {
			if (_dlvryIntrvl != null) {
				this.dlvryIntrvl.add(_dlvryIntrvl.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(TimePeriodDetails1 _dlvryIntrvl, int idx) {
			getIndex(this.dlvryIntrvl, idx, () -> _dlvryIntrvl.toBuilder());
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addDlvryIntrvl(List<? extends TimePeriodDetails1> dlvryIntrvls) {
			if (dlvryIntrvls != null) {
				for (final TimePeriodDetails1 toAdd : dlvryIntrvls) {
					this.dlvryIntrvl.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dlvryIntrvl")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dlvryIntrvl")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryIntrvl(List<? extends TimePeriodDetails1> dlvryIntrvls) {
			if (dlvryIntrvls == null) {
				this.dlvryIntrvl = new ArrayList<>();
			} else {
				this.dlvryIntrvl = dlvryIntrvls.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dlvryDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dlvryDt")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryDt(DatePeriod1 _dlvryDt) {
			this.dlvryDt = _dlvryDt == null ? null : _dlvryDt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("drtn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drtn")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDrtn(DurationType1Code _drtn) {
			this.drtn = _drtn == null ? null : _drtn;
			return this;
		}
		
		@RosettaAttribute("wkDay")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("wkDay")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(WeekDay3Code__1 _wkDay) {
			if (_wkDay != null) {
				this.wkDay.add(_wkDay);
			}
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(WeekDay3Code__1 _wkDay, int idx) {
			getIndex(this.wkDay, idx, () -> _wkDay);
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder addWkDay(List<WeekDay3Code__1> wkDays) {
			if (wkDays != null) {
				for (final WeekDay3Code__1 toAdd : wkDays) {
					this.wkDay.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("wkDay")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("wkDay")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setWkDay(List<WeekDay3Code__1> wkDays) {
			if (wkDays == null) {
				this.wkDay = new ArrayList<>();
			} else {
				this.wkDay = wkDays.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dlvryCpcty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dlvryCpcty")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setDlvryCpcty(Quantity47Choice__1 _dlvryCpcty) {
			this.dlvryCpcty = _dlvryCpcty == null ? null : _dlvryCpcty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("qtyUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("qtyUnit")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setQtyUnit(EnergyQuantityUnit2Choice__1 _qtyUnit) {
			this.qtyUnit = _qtyUnit == null ? null : _qtyUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricTmIntrvlQty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricTmIntrvlQty")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder setPricTmIntrvlQty(AmountAndDirection106__3 _pricTmIntrvlQty) {
			this.pricTmIntrvlQty = _pricTmIntrvlQty == null ? null : _pricTmIntrvlQty.toBuilder();
			return this;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1 build() {
			return new EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Impl(this);
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder prune() {
			dlvryIntrvl = dlvryIntrvl.stream().filter(b->b!=null).<TimePeriodDetails1.TimePeriodDetails1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dlvryDt!=null && !dlvryDt.prune().hasData()) dlvryDt = null;
			if (dlvryCpcty!=null && !dlvryCpcty.prune().hasData()) dlvryCpcty = null;
			if (qtyUnit!=null && !qtyUnit.prune().hasData()) qtyUnit = null;
			if (pricTmIntrvlQty!=null && !pricTmIntrvlQty.prune().hasData()) pricTmIntrvlQty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDlvryIntrvl()!=null && getDlvryIntrvl().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDlvryDt()!=null && getDlvryDt().hasData()) return true;
			if (getDrtn()!=null) return true;
			if (getWkDay()!=null && !getWkDay().isEmpty()) return true;
			if (getDlvryCpcty()!=null && getDlvryCpcty().hasData()) return true;
			if (getQtyUnit()!=null && getQtyUnit().hasData()) return true;
			if (getPricTmIntrvlQty()!=null && getPricTmIntrvlQty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder o = (EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder) other;
			
			merger.mergeRosetta(getDlvryIntrvl(), o.getDlvryIntrvl(), this::getOrCreateDlvryIntrvl);
			merger.mergeRosetta(getDlvryDt(), o.getDlvryDt(), this::setDlvryDt);
			merger.mergeRosetta(getDlvryCpcty(), o.getDlvryCpcty(), this::setDlvryCpcty);
			merger.mergeRosetta(getQtyUnit(), o.getQtyUnit(), this::setQtyUnit);
			merger.mergeRosetta(getPricTmIntrvlQty(), o.getPricTmIntrvlQty(), this::setPricTmIntrvlQty);
			
			merger.mergeBasic(getDrtn(), o.getDrtn(), this::setDrtn);
			merger.mergeBasic(getWkDay(), o.getWkDay(), (Consumer<WeekDay3Code__1>) this::addWkDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyDeliveryAttribute10__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dlvryIntrvl, _that.getDlvryIntrvl())) return false;
			if (!Objects.equals(dlvryDt, _that.getDlvryDt())) return false;
			if (!Objects.equals(drtn, _that.getDrtn())) return false;
			if (!ListEquals.listEquals(wkDay, _that.getWkDay())) return false;
			if (!Objects.equals(dlvryCpcty, _that.getDlvryCpcty())) return false;
			if (!Objects.equals(qtyUnit, _that.getQtyUnit())) return false;
			if (!Objects.equals(pricTmIntrvlQty, _that.getPricTmIntrvlQty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryIntrvl != null ? dlvryIntrvl.hashCode() : 0);
			_result = 31 * _result + (dlvryDt != null ? dlvryDt.hashCode() : 0);
			_result = 31 * _result + (drtn != null ? drtn.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (wkDay != null ? wkDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dlvryCpcty != null ? dlvryCpcty.hashCode() : 0);
			_result = 31 * _result + (qtyUnit != null ? qtyUnit.hashCode() : 0);
			_result = 31 * _result + (pricTmIntrvlQty != null ? pricTmIntrvlQty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnergyDeliveryAttribute10__1Builder {" +
				"dlvryIntrvl=" + this.dlvryIntrvl + ", " +
				"dlvryDt=" + this.dlvryDt + ", " +
				"drtn=" + this.drtn + ", " +
				"wkDay=" + this.wkDay + ", " +
				"dlvryCpcty=" + this.dlvryCpcty + ", " +
				"qtyUnit=" + this.qtyUnit + ", " +
				"pricTmIntrvlQty=" + this.pricTmIntrvlQty +
			'}';
		}
	}
}
