package cdm.base.math;

import cdm.base.datetime.Frequency;
import cdm.base.math.meta.QuantityMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Specifies a quantity as a single value to be associated to a financial product, for example a transfer amount resulting from a trade. This data type extends QuantitySchedule and requires that only the single amount value exists.
 * @version 6.23.0
 */
@RosettaDataType(value="Quantity", builder=Quantity.QuantityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Quantity", model="cdm", builder=Quantity.QuantityBuilderImpl.class, version="6.23.0")
public interface Quantity extends QuantitySchedule {

	QuantityMeta metaData = new QuantityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Quantity build();
	
	Quantity.QuantityBuilder toBuilder();
	
	static Quantity.QuantityBuilder builder() {
		return new Quantity.QuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Quantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Quantity> getType() {
		return Quantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("unit"), processor, UnitType.class, getUnit());
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
		processRosetta(path.newSubPath("multiplier"), processor, Measure.class, getMultiplier());
		processRosetta(path.newSubPath("frequency"), processor, Frequency.class, getFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityBuilder extends Quantity, QuantitySchedule.QuantityScheduleBuilder {
		@Override
		Quantity.QuantityBuilder setValue(BigDecimal value);
		@Override
		Quantity.QuantityBuilder setUnit(UnitType unit);
		@Override
		Quantity.QuantityBuilder addDatedValue(DatedValue datedValue);
		@Override
		Quantity.QuantityBuilder addDatedValue(DatedValue datedValue, int idx);
		@Override
		Quantity.QuantityBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Quantity.QuantityBuilder setDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Quantity.QuantityBuilder setMultiplier(Measure multiplier);
		@Override
		Quantity.QuantityBuilder setFrequency(Frequency frequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("multiplier"), processor, Measure.MeasureBuilder.class, getMultiplier());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
		}
		

		Quantity.QuantityBuilder prune();
	}

	/*********************** Immutable Implementation of Quantity  ***********************/
	class QuantityImpl extends QuantitySchedule.QuantityScheduleImpl implements Quantity {
		
		protected QuantityImpl(Quantity.QuantityBuilder builder) {
			super(builder);
		}
		
		@Override
		public Quantity build() {
			return this;
		}
		
		@Override
		public Quantity.QuantityBuilder toBuilder() {
			Quantity.QuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Quantity.QuantityBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Quantity {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Quantity  ***********************/
	class QuantityBuilderImpl extends QuantitySchedule.QuantityScheduleBuilderImpl implements Quantity.QuantityBuilder {
	
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public Quantity.QuantityBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public Quantity.QuantityBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("datedValue")
		@Override
		public Quantity.QuantityBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public Quantity.QuantityBuilder addDatedValue(DatedValue _datedValue, int idx) {
			getIndex(this.datedValue, idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override
		public Quantity.QuantityBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("datedValue")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("datedValue")
		@Override
		public Quantity.QuantityBuilder setDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues == null) {
				this.datedValue = new ArrayList<>();
			} else {
				this.datedValue = datedValues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public Quantity.QuantityBuilder setMultiplier(Measure _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frequency")
		@Override
		public Quantity.QuantityBuilder setFrequency(Frequency _frequency) {
			this.frequency = _frequency == null ? null : _frequency.toBuilder();
			return this;
		}
		
		@Override
		public Quantity build() {
			return new Quantity.QuantityImpl(this);
		}
		
		@Override
		public Quantity.QuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity.QuantityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity.QuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Quantity.QuantityBuilder o = (Quantity.QuantityBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
