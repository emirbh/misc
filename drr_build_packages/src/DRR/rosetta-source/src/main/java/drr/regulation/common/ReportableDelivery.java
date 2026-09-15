package drr.regulation.common;

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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import drr.regulation.common.meta.ReportableDeliveryMeta;
import drr.standards.iso.DurationType1Code;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableDelivery", builder=ReportableDelivery.ReportableDeliveryBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableDelivery", model="drr", builder=ReportableDelivery.ReportableDeliveryBuilderImpl.class, version="7.7.0")
public interface ReportableDelivery extends RosettaModelObject {

	ReportableDeliveryMeta metaData = new ReportableDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	LocalTime getDeliveryStartTime();
	LocalTime getDeliveryEndTime();
	Date getDeliveryStartDate();
	Date getDeliveryEndDate();
	DurationType1Code getDuration();
	List<String> getDaysOfTheWeek();
	BigDecimal getDeliveryCapacity();
	EnergyQuantityUnit2Code getQuantityUnit();
	BigDecimal getPriceTimeIntervalQuantity();
	String getCurrencyOfThePriceTimeIntervalQuantity();

	/*********************** Build Methods  ***********************/
	ReportableDelivery build();
	
	ReportableDelivery.ReportableDeliveryBuilder toBuilder();
	
	static ReportableDelivery.ReportableDeliveryBuilder builder() {
		return new ReportableDelivery.ReportableDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableDelivery> getType() {
		return ReportableDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryStartTime"), LocalTime.class, getDeliveryStartTime(), this);
		processor.processBasic(path.newSubPath("deliveryEndTime"), LocalTime.class, getDeliveryEndTime(), this);
		processor.processBasic(path.newSubPath("deliveryStartDate"), Date.class, getDeliveryStartDate(), this);
		processor.processBasic(path.newSubPath("deliveryEndDate"), Date.class, getDeliveryEndDate(), this);
		processor.processBasic(path.newSubPath("duration"), DurationType1Code.class, getDuration(), this);
		processor.processBasic(path.newSubPath("daysOfTheWeek"), String.class, getDaysOfTheWeek(), this);
		processor.processBasic(path.newSubPath("deliveryCapacity"), BigDecimal.class, getDeliveryCapacity(), this);
		processor.processBasic(path.newSubPath("quantityUnit"), EnergyQuantityUnit2Code.class, getQuantityUnit(), this);
		processor.processBasic(path.newSubPath("priceTimeIntervalQuantity"), BigDecimal.class, getPriceTimeIntervalQuantity(), this);
		processor.processBasic(path.newSubPath("currencyOfThePriceTimeIntervalQuantity"), String.class, getCurrencyOfThePriceTimeIntervalQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableDeliveryBuilder extends ReportableDelivery, RosettaModelObjectBuilder {
		ReportableDelivery.ReportableDeliveryBuilder setDeliveryStartTime(LocalTime deliveryStartTime);
		ReportableDelivery.ReportableDeliveryBuilder setDeliveryEndTime(LocalTime deliveryEndTime);
		ReportableDelivery.ReportableDeliveryBuilder setDeliveryStartDate(Date deliveryStartDate);
		ReportableDelivery.ReportableDeliveryBuilder setDeliveryEndDate(Date deliveryEndDate);
		ReportableDelivery.ReportableDeliveryBuilder setDuration(DurationType1Code duration);
		ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(String daysOfTheWeek);
		ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(String daysOfTheWeek, int idx);
		ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(List<String> daysOfTheWeek);
		ReportableDelivery.ReportableDeliveryBuilder setDaysOfTheWeek(List<String> daysOfTheWeek);
		ReportableDelivery.ReportableDeliveryBuilder setDeliveryCapacity(BigDecimal deliveryCapacity);
		ReportableDelivery.ReportableDeliveryBuilder setQuantityUnit(EnergyQuantityUnit2Code quantityUnit);
		ReportableDelivery.ReportableDeliveryBuilder setPriceTimeIntervalQuantity(BigDecimal priceTimeIntervalQuantity);
		ReportableDelivery.ReportableDeliveryBuilder setCurrencyOfThePriceTimeIntervalQuantity(String currencyOfThePriceTimeIntervalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("deliveryStartTime"), LocalTime.class, getDeliveryStartTime(), this);
			processor.processBasic(path.newSubPath("deliveryEndTime"), LocalTime.class, getDeliveryEndTime(), this);
			processor.processBasic(path.newSubPath("deliveryStartDate"), Date.class, getDeliveryStartDate(), this);
			processor.processBasic(path.newSubPath("deliveryEndDate"), Date.class, getDeliveryEndDate(), this);
			processor.processBasic(path.newSubPath("duration"), DurationType1Code.class, getDuration(), this);
			processor.processBasic(path.newSubPath("daysOfTheWeek"), String.class, getDaysOfTheWeek(), this);
			processor.processBasic(path.newSubPath("deliveryCapacity"), BigDecimal.class, getDeliveryCapacity(), this);
			processor.processBasic(path.newSubPath("quantityUnit"), EnergyQuantityUnit2Code.class, getQuantityUnit(), this);
			processor.processBasic(path.newSubPath("priceTimeIntervalQuantity"), BigDecimal.class, getPriceTimeIntervalQuantity(), this);
			processor.processBasic(path.newSubPath("currencyOfThePriceTimeIntervalQuantity"), String.class, getCurrencyOfThePriceTimeIntervalQuantity(), this);
		}
		

		ReportableDelivery.ReportableDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableDelivery  ***********************/
	class ReportableDeliveryImpl implements ReportableDelivery {
		private final LocalTime deliveryStartTime;
		private final LocalTime deliveryEndTime;
		private final Date deliveryStartDate;
		private final Date deliveryEndDate;
		private final DurationType1Code duration;
		private final List<String> daysOfTheWeek;
		private final BigDecimal deliveryCapacity;
		private final EnergyQuantityUnit2Code quantityUnit;
		private final BigDecimal priceTimeIntervalQuantity;
		private final String currencyOfThePriceTimeIntervalQuantity;
		
		protected ReportableDeliveryImpl(ReportableDelivery.ReportableDeliveryBuilder builder) {
			this.deliveryStartTime = builder.getDeliveryStartTime();
			this.deliveryEndTime = builder.getDeliveryEndTime();
			this.deliveryStartDate = builder.getDeliveryStartDate();
			this.deliveryEndDate = builder.getDeliveryEndDate();
			this.duration = builder.getDuration();
			this.daysOfTheWeek = ofNullable(builder.getDaysOfTheWeek()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.deliveryCapacity = builder.getDeliveryCapacity();
			this.quantityUnit = builder.getQuantityUnit();
			this.priceTimeIntervalQuantity = builder.getPriceTimeIntervalQuantity();
			this.currencyOfThePriceTimeIntervalQuantity = builder.getCurrencyOfThePriceTimeIntervalQuantity();
		}
		
		@Override
		@RosettaAttribute("deliveryStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryStartTime")
		public LocalTime getDeliveryStartTime() {
			return deliveryStartTime;
		}
		
		@Override
		@RosettaAttribute("deliveryEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryEndTime")
		public LocalTime getDeliveryEndTime() {
			return deliveryEndTime;
		}
		
		@Override
		@RosettaAttribute("deliveryStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryStartDate")
		public Date getDeliveryStartDate() {
			return deliveryStartDate;
		}
		
		@Override
		@RosettaAttribute("deliveryEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryEndDate")
		public Date getDeliveryEndDate() {
			return deliveryEndDate;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public DurationType1Code getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("daysOfTheWeek")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("daysOfTheWeek")
		public List<String> getDaysOfTheWeek() {
			return daysOfTheWeek;
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCapacity")
		public BigDecimal getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityUnit")
		public EnergyQuantityUnit2Code getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceTimeIntervalQuantity")
		public BigDecimal getPriceTimeIntervalQuantity() {
			return priceTimeIntervalQuantity;
		}
		
		@Override
		@RosettaAttribute("currencyOfThePriceTimeIntervalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfThePriceTimeIntervalQuantity")
		public String getCurrencyOfThePriceTimeIntervalQuantity() {
			return currencyOfThePriceTimeIntervalQuantity;
		}
		
		@Override
		public ReportableDelivery build() {
			return this;
		}
		
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder toBuilder() {
			ReportableDelivery.ReportableDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableDelivery.ReportableDeliveryBuilder builder) {
			ofNullable(getDeliveryStartTime()).ifPresent(builder::setDeliveryStartTime);
			ofNullable(getDeliveryEndTime()).ifPresent(builder::setDeliveryEndTime);
			ofNullable(getDeliveryStartDate()).ifPresent(builder::setDeliveryStartDate);
			ofNullable(getDeliveryEndDate()).ifPresent(builder::setDeliveryEndDate);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getDaysOfTheWeek()).ifPresent(builder::setDaysOfTheWeek);
			ofNullable(getDeliveryCapacity()).ifPresent(builder::setDeliveryCapacity);
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getPriceTimeIntervalQuantity()).ifPresent(builder::setPriceTimeIntervalQuantity);
			ofNullable(getCurrencyOfThePriceTimeIntervalQuantity()).ifPresent(builder::setCurrencyOfThePriceTimeIntervalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryStartTime, _that.getDeliveryStartTime())) return false;
			if (!Objects.equals(deliveryEndTime, _that.getDeliveryEndTime())) return false;
			if (!Objects.equals(deliveryStartDate, _that.getDeliveryStartDate())) return false;
			if (!Objects.equals(deliveryEndDate, _that.getDeliveryEndDate())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(daysOfTheWeek, _that.getDaysOfTheWeek())) return false;
			if (!Objects.equals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(priceTimeIntervalQuantity, _that.getPriceTimeIntervalQuantity())) return false;
			if (!Objects.equals(currencyOfThePriceTimeIntervalQuantity, _that.getCurrencyOfThePriceTimeIntervalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryStartTime != null ? deliveryStartTime.hashCode() : 0);
			_result = 31 * _result + (deliveryEndTime != null ? deliveryEndTime.hashCode() : 0);
			_result = 31 * _result + (deliveryStartDate != null ? deliveryStartDate.hashCode() : 0);
			_result = 31 * _result + (deliveryEndDate != null ? deliveryEndDate.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (daysOfTheWeek != null ? daysOfTheWeek.hashCode() : 0);
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantity != null ? priceTimeIntervalQuantity.hashCode() : 0);
			_result = 31 * _result + (currencyOfThePriceTimeIntervalQuantity != null ? currencyOfThePriceTimeIntervalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableDelivery {" +
				"deliveryStartTime=" + this.deliveryStartTime + ", " +
				"deliveryEndTime=" + this.deliveryEndTime + ", " +
				"deliveryStartDate=" + this.deliveryStartDate + ", " +
				"deliveryEndDate=" + this.deliveryEndDate + ", " +
				"duration=" + this.duration + ", " +
				"daysOfTheWeek=" + this.daysOfTheWeek + ", " +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"priceTimeIntervalQuantity=" + this.priceTimeIntervalQuantity + ", " +
				"currencyOfThePriceTimeIntervalQuantity=" + this.currencyOfThePriceTimeIntervalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableDelivery  ***********************/
	class ReportableDeliveryBuilderImpl implements ReportableDelivery.ReportableDeliveryBuilder {
	
		protected LocalTime deliveryStartTime;
		protected LocalTime deliveryEndTime;
		protected Date deliveryStartDate;
		protected Date deliveryEndDate;
		protected DurationType1Code duration;
		protected List<String> daysOfTheWeek = new ArrayList<>();
		protected BigDecimal deliveryCapacity;
		protected EnergyQuantityUnit2Code quantityUnit;
		protected BigDecimal priceTimeIntervalQuantity;
		protected String currencyOfThePriceTimeIntervalQuantity;
		
		@Override
		@RosettaAttribute("deliveryStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryStartTime")
		public LocalTime getDeliveryStartTime() {
			return deliveryStartTime;
		}
		
		@Override
		@RosettaAttribute("deliveryEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryEndTime")
		public LocalTime getDeliveryEndTime() {
			return deliveryEndTime;
		}
		
		@Override
		@RosettaAttribute("deliveryStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryStartDate")
		public Date getDeliveryStartDate() {
			return deliveryStartDate;
		}
		
		@Override
		@RosettaAttribute("deliveryEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryEndDate")
		public Date getDeliveryEndDate() {
			return deliveryEndDate;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public DurationType1Code getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("daysOfTheWeek")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("daysOfTheWeek")
		public List<String> getDaysOfTheWeek() {
			return daysOfTheWeek;
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCapacity")
		public BigDecimal getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityUnit")
		public EnergyQuantityUnit2Code getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceTimeIntervalQuantity")
		public BigDecimal getPriceTimeIntervalQuantity() {
			return priceTimeIntervalQuantity;
		}
		
		@Override
		@RosettaAttribute("currencyOfThePriceTimeIntervalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyOfThePriceTimeIntervalQuantity")
		public String getCurrencyOfThePriceTimeIntervalQuantity() {
			return currencyOfThePriceTimeIntervalQuantity;
		}
		
		@RosettaAttribute("deliveryStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryStartTime")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDeliveryStartTime(LocalTime _deliveryStartTime) {
			this.deliveryStartTime = _deliveryStartTime == null ? null : _deliveryStartTime;
			return this;
		}
		
		@RosettaAttribute("deliveryEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryEndTime")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDeliveryEndTime(LocalTime _deliveryEndTime) {
			this.deliveryEndTime = _deliveryEndTime == null ? null : _deliveryEndTime;
			return this;
		}
		
		@RosettaAttribute("deliveryStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryStartDate")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDeliveryStartDate(Date _deliveryStartDate) {
			this.deliveryStartDate = _deliveryStartDate == null ? null : _deliveryStartDate;
			return this;
		}
		
		@RosettaAttribute("deliveryEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryEndDate")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDeliveryEndDate(Date _deliveryEndDate) {
			this.deliveryEndDate = _deliveryEndDate == null ? null : _deliveryEndDate;
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("duration")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDuration(DurationType1Code _duration) {
			this.duration = _duration == null ? null : _duration;
			return this;
		}
		
		@RosettaAttribute("daysOfTheWeek")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("daysOfTheWeek")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(String _daysOfTheWeek) {
			if (_daysOfTheWeek != null) {
				this.daysOfTheWeek.add(_daysOfTheWeek);
			}
			return this;
		}
		
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(String _daysOfTheWeek, int idx) {
			getIndex(this.daysOfTheWeek, idx, () -> _daysOfTheWeek);
			return this;
		}
		
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder addDaysOfTheWeek(List<String> daysOfTheWeeks) {
			if (daysOfTheWeeks != null) {
				for (final String toAdd : daysOfTheWeeks) {
					this.daysOfTheWeek.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("daysOfTheWeek")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("daysOfTheWeek")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDaysOfTheWeek(List<String> daysOfTheWeeks) {
			if (daysOfTheWeeks == null) {
				this.daysOfTheWeek = new ArrayList<>();
			} else {
				this.daysOfTheWeek = daysOfTheWeeks.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryCapacity")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setDeliveryCapacity(BigDecimal _deliveryCapacity) {
			this.deliveryCapacity = _deliveryCapacity == null ? null : _deliveryCapacity;
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnit")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setQuantityUnit(EnergyQuantityUnit2Code _quantityUnit) {
			this.quantityUnit = _quantityUnit == null ? null : _quantityUnit;
			return this;
		}
		
		@RosettaAttribute("priceTimeIntervalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceTimeIntervalQuantity")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setPriceTimeIntervalQuantity(BigDecimal _priceTimeIntervalQuantity) {
			this.priceTimeIntervalQuantity = _priceTimeIntervalQuantity == null ? null : _priceTimeIntervalQuantity;
			return this;
		}
		
		@RosettaAttribute("currencyOfThePriceTimeIntervalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyOfThePriceTimeIntervalQuantity")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder setCurrencyOfThePriceTimeIntervalQuantity(String _currencyOfThePriceTimeIntervalQuantity) {
			this.currencyOfThePriceTimeIntervalQuantity = _currencyOfThePriceTimeIntervalQuantity == null ? null : _currencyOfThePriceTimeIntervalQuantity;
			return this;
		}
		
		@Override
		public ReportableDelivery build() {
			return new ReportableDelivery.ReportableDeliveryImpl(this);
		}
		
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryStartTime()!=null) return true;
			if (getDeliveryEndTime()!=null) return true;
			if (getDeliveryStartDate()!=null) return true;
			if (getDeliveryEndDate()!=null) return true;
			if (getDuration()!=null) return true;
			if (getDaysOfTheWeek()!=null && !getDaysOfTheWeek().isEmpty()) return true;
			if (getDeliveryCapacity()!=null) return true;
			if (getQuantityUnit()!=null) return true;
			if (getPriceTimeIntervalQuantity()!=null) return true;
			if (getCurrencyOfThePriceTimeIntervalQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableDelivery.ReportableDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableDelivery.ReportableDeliveryBuilder o = (ReportableDelivery.ReportableDeliveryBuilder) other;
			
			
			merger.mergeBasic(getDeliveryStartTime(), o.getDeliveryStartTime(), this::setDeliveryStartTime);
			merger.mergeBasic(getDeliveryEndTime(), o.getDeliveryEndTime(), this::setDeliveryEndTime);
			merger.mergeBasic(getDeliveryStartDate(), o.getDeliveryStartDate(), this::setDeliveryStartDate);
			merger.mergeBasic(getDeliveryEndDate(), o.getDeliveryEndDate(), this::setDeliveryEndDate);
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getDaysOfTheWeek(), o.getDaysOfTheWeek(), (Consumer<String>) this::addDaysOfTheWeek);
			merger.mergeBasic(getDeliveryCapacity(), o.getDeliveryCapacity(), this::setDeliveryCapacity);
			merger.mergeBasic(getQuantityUnit(), o.getQuantityUnit(), this::setQuantityUnit);
			merger.mergeBasic(getPriceTimeIntervalQuantity(), o.getPriceTimeIntervalQuantity(), this::setPriceTimeIntervalQuantity);
			merger.mergeBasic(getCurrencyOfThePriceTimeIntervalQuantity(), o.getCurrencyOfThePriceTimeIntervalQuantity(), this::setCurrencyOfThePriceTimeIntervalQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryStartTime, _that.getDeliveryStartTime())) return false;
			if (!Objects.equals(deliveryEndTime, _that.getDeliveryEndTime())) return false;
			if (!Objects.equals(deliveryStartDate, _that.getDeliveryStartDate())) return false;
			if (!Objects.equals(deliveryEndDate, _that.getDeliveryEndDate())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(daysOfTheWeek, _that.getDaysOfTheWeek())) return false;
			if (!Objects.equals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(priceTimeIntervalQuantity, _that.getPriceTimeIntervalQuantity())) return false;
			if (!Objects.equals(currencyOfThePriceTimeIntervalQuantity, _that.getCurrencyOfThePriceTimeIntervalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryStartTime != null ? deliveryStartTime.hashCode() : 0);
			_result = 31 * _result + (deliveryEndTime != null ? deliveryEndTime.hashCode() : 0);
			_result = 31 * _result + (deliveryStartDate != null ? deliveryStartDate.hashCode() : 0);
			_result = 31 * _result + (deliveryEndDate != null ? deliveryEndDate.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (daysOfTheWeek != null ? daysOfTheWeek.hashCode() : 0);
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantity != null ? priceTimeIntervalQuantity.hashCode() : 0);
			_result = 31 * _result + (currencyOfThePriceTimeIntervalQuantity != null ? currencyOfThePriceTimeIntervalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableDeliveryBuilder {" +
				"deliveryStartTime=" + this.deliveryStartTime + ", " +
				"deliveryEndTime=" + this.deliveryEndTime + ", " +
				"deliveryStartDate=" + this.deliveryStartDate + ", " +
				"deliveryEndDate=" + this.deliveryEndDate + ", " +
				"duration=" + this.duration + ", " +
				"daysOfTheWeek=" + this.daysOfTheWeek + ", " +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"priceTimeIntervalQuantity=" + this.priceTimeIntervalQuantity + ", " +
				"currencyOfThePriceTimeIntervalQuantity=" + this.currencyOfThePriceTimeIntervalQuantity +
			'}';
		}
	}
}
