package drr.regulation.common;

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
import drr.regulation.common.meta.DeliveryCapacityMeta;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="DeliveryCapacity", builder=DeliveryCapacity.DeliveryCapacityBuilderImpl.class, version="7.7.0")
@RuneDataType(value="DeliveryCapacity", model="drr", builder=DeliveryCapacity.DeliveryCapacityBuilderImpl.class, version="7.7.0")
public interface DeliveryCapacity extends RosettaModelObject {

	DeliveryCapacityMeta metaData = new DeliveryCapacityMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getAmount();
	EnergyQuantityUnit2Code getUnit();

	/*********************** Build Methods  ***********************/
	DeliveryCapacity build();
	
	DeliveryCapacity.DeliveryCapacityBuilder toBuilder();
	
	static DeliveryCapacity.DeliveryCapacityBuilder builder() {
		return new DeliveryCapacity.DeliveryCapacityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeliveryCapacity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeliveryCapacity> getType() {
		return DeliveryCapacity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("unit"), EnergyQuantityUnit2Code.class, getUnit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeliveryCapacityBuilder extends DeliveryCapacity, RosettaModelObjectBuilder {
		DeliveryCapacity.DeliveryCapacityBuilder setAmount(BigDecimal amount);
		DeliveryCapacity.DeliveryCapacityBuilder setUnit(EnergyQuantityUnit2Code unit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("unit"), EnergyQuantityUnit2Code.class, getUnit(), this);
		}
		

		DeliveryCapacity.DeliveryCapacityBuilder prune();
	}

	/*********************** Immutable Implementation of DeliveryCapacity  ***********************/
	class DeliveryCapacityImpl implements DeliveryCapacity {
		private final BigDecimal amount;
		private final EnergyQuantityUnit2Code unit;
		
		protected DeliveryCapacityImpl(DeliveryCapacity.DeliveryCapacityBuilder builder) {
			this.amount = builder.getAmount();
			this.unit = builder.getUnit();
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public EnergyQuantityUnit2Code getUnit() {
			return unit;
		}
		
		@Override
		public DeliveryCapacity build() {
			return this;
		}
		
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder toBuilder() {
			DeliveryCapacity.DeliveryCapacityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryCapacity.DeliveryCapacityBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryCapacity _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryCapacity {" +
				"amount=" + this.amount + ", " +
				"unit=" + this.unit +
			'}';
		}
	}

	/*********************** Builder Implementation of DeliveryCapacity  ***********************/
	class DeliveryCapacityBuilderImpl implements DeliveryCapacity.DeliveryCapacityBuilder {
	
		protected BigDecimal amount;
		protected EnergyQuantityUnit2Code unit;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public EnergyQuantityUnit2Code getUnit() {
			return unit;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder setUnit(EnergyQuantityUnit2Code _unit) {
			this.unit = _unit == null ? null : _unit;
			return this;
		}
		
		@Override
		public DeliveryCapacity build() {
			return new DeliveryCapacity.DeliveryCapacityImpl(this);
		}
		
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryCapacity.DeliveryCapacityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryCapacity.DeliveryCapacityBuilder o = (DeliveryCapacity.DeliveryCapacityBuilder) other;
			
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryCapacity _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryCapacityBuilder {" +
				"amount=" + this.amount + ", " +
				"unit=" + this.unit +
			'}';
		}
	}
}
