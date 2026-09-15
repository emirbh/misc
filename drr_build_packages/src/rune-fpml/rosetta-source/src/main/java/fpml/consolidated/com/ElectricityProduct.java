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
import fpml.consolidated.com.meta.ElectricityProductMeta;
import fpml.consolidated.fpmlenum.ElectricityProductTypeEnum;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification of the electricity to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification of the electricity to be delivered.
 *
 */
@RosettaDataType(value="ElectricityProduct", builder=ElectricityProduct.ElectricityProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityProduct", model="fpml", builder=ElectricityProduct.ElectricityProductBuilderImpl.class, version="2.1.1")
public interface ElectricityProduct extends RosettaModelObject {

	ElectricityProductMeta metaData = new ElectricityProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of electricity product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of electricity product to be delivered.
	 *
	 */
	ElectricityProductTypeEnum _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The voltage, expressed as a number of volts, of the electricity to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The voltage, expressed as a number of volts, of the electricity to be delivered.
	 *
	 */
	BigDecimal getVoltage();

	/*********************** Build Methods  ***********************/
	ElectricityProduct build();
	
	ElectricityProduct.ElectricityProductBuilder toBuilder();
	
	static ElectricityProduct.ElectricityProductBuilder builder() {
		return new ElectricityProduct.ElectricityProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityProduct> getType() {
		return ElectricityProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("type"), ElectricityProductTypeEnum.class, _getType(), this);
		processor.processBasic(path.newSubPath("voltage"), BigDecimal.class, getVoltage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityProductBuilder extends ElectricityProduct, RosettaModelObjectBuilder {
		ElectricityProduct.ElectricityProductBuilder setType(ElectricityProductTypeEnum type);
		ElectricityProduct.ElectricityProductBuilder setVoltage(BigDecimal voltage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("type"), ElectricityProductTypeEnum.class, _getType(), this);
			processor.processBasic(path.newSubPath("voltage"), BigDecimal.class, getVoltage(), this);
		}
		

		ElectricityProduct.ElectricityProductBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityProduct  ***********************/
	class ElectricityProductImpl implements ElectricityProduct {
		private final ElectricityProductTypeEnum type;
		private final BigDecimal voltage;
		
		protected ElectricityProductImpl(ElectricityProduct.ElectricityProductBuilder builder) {
			this.type = builder._getType();
			this.voltage = builder.getVoltage();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ElectricityProductTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("voltage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voltage")
		public BigDecimal getVoltage() {
			return voltage;
		}
		
		@Override
		public ElectricityProduct build() {
			return this;
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder toBuilder() {
			ElectricityProduct.ElectricityProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityProduct.ElectricityProductBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getVoltage()).ifPresent(builder::setVoltage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(voltage, _that.getVoltage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (voltage != null ? voltage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityProduct {" +
				"type=" + this.type + ", " +
				"voltage=" + this.voltage +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityProduct  ***********************/
	class ElectricityProductBuilderImpl implements ElectricityProduct.ElectricityProductBuilder {
	
		protected ElectricityProductTypeEnum type;
		protected BigDecimal voltage;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ElectricityProductTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("voltage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voltage")
		public BigDecimal getVoltage() {
			return voltage;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public ElectricityProduct.ElectricityProductBuilder setType(ElectricityProductTypeEnum _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("voltage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("voltage")
		@Override
		public ElectricityProduct.ElectricityProductBuilder setVoltage(BigDecimal _voltage) {
			this.voltage = _voltage == null ? null : _voltage;
			return this;
		}
		
		@Override
		public ElectricityProduct build() {
			return new ElectricityProduct.ElectricityProductImpl(this);
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityProduct.ElectricityProductBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null) return true;
			if (getVoltage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityProduct.ElectricityProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityProduct.ElectricityProductBuilder o = (ElectricityProduct.ElectricityProductBuilder) other;
			
			
			merger.mergeBasic(_getType(), o._getType(), this::setType);
			merger.mergeBasic(getVoltage(), o.getVoltage(), this::setVoltage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(voltage, _that.getVoltage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (voltage != null ? voltage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityProductBuilder {" +
				"type=" + this.type + ", " +
				"voltage=" + this.voltage +
			'}';
		}
	}
}
