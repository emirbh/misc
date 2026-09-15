package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.EnvironmentalTrackingSystemMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision For US Emissions Allowance Transactions. A system where all electronic certificates are stored and emissions are tracked.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision For US Emissions Allowance Transactions. A system where all electronic certificates are stored and emissions are tracked.
 *
 */
@RosettaDataType(value="EnvironmentalTrackingSystem", builder=EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EnvironmentalTrackingSystem", model="fpml", builder=EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl.class, version="2.1.1")
public interface EnvironmentalTrackingSystem extends RosettaModelObject {

	EnvironmentalTrackingSystemMeta metaData = new EnvironmentalTrackingSystemMeta();

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
	String getValue();
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
	String getCommodityEnvironmentalTrackingSystemScheme();

	/*********************** Build Methods  ***********************/
	EnvironmentalTrackingSystem build();
	
	EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder();
	
	static EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder() {
		return new EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalTrackingSystem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalTrackingSystem> getType() {
		return EnvironmentalTrackingSystem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityEnvironmentalTrackingSystemScheme"), String.class, getCommodityEnvironmentalTrackingSystemScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalTrackingSystemBuilder extends EnvironmentalTrackingSystem, RosettaModelObjectBuilder {
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setValue(String value);
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setCommodityEnvironmentalTrackingSystemScheme(String commodityEnvironmentalTrackingSystemScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityEnvironmentalTrackingSystemScheme"), String.class, getCommodityEnvironmentalTrackingSystemScheme(), this);
		}
		

		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalTrackingSystem  ***********************/
	class EnvironmentalTrackingSystemImpl implements EnvironmentalTrackingSystem {
		private final String value;
		private final String commodityEnvironmentalTrackingSystemScheme;
		
		protected EnvironmentalTrackingSystemImpl(EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder) {
			this.value = builder.getValue();
			this.commodityEnvironmentalTrackingSystemScheme = builder.getCommodityEnvironmentalTrackingSystemScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityEnvironmentalTrackingSystemScheme")
		public String getCommodityEnvironmentalTrackingSystemScheme() {
			return commodityEnvironmentalTrackingSystemScheme;
		}
		
		@Override
		public EnvironmentalTrackingSystem build() {
			return this;
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder() {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityEnvironmentalTrackingSystemScheme()).ifPresent(builder::setCommodityEnvironmentalTrackingSystemScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalTrackingSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityEnvironmentalTrackingSystemScheme, _that.getCommodityEnvironmentalTrackingSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityEnvironmentalTrackingSystemScheme != null ? commodityEnvironmentalTrackingSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalTrackingSystem {" +
				"value=" + this.value + ", " +
				"commodityEnvironmentalTrackingSystemScheme=" + this.commodityEnvironmentalTrackingSystemScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalTrackingSystem  ***********************/
	class EnvironmentalTrackingSystemBuilderImpl implements EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder {
	
		protected String value;
		protected String commodityEnvironmentalTrackingSystemScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityEnvironmentalTrackingSystemScheme")
		public String getCommodityEnvironmentalTrackingSystemScheme() {
			return commodityEnvironmentalTrackingSystemScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityEnvironmentalTrackingSystemScheme")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setCommodityEnvironmentalTrackingSystemScheme(String _commodityEnvironmentalTrackingSystemScheme) {
			this.commodityEnvironmentalTrackingSystemScheme = _commodityEnvironmentalTrackingSystemScheme == null ? null : _commodityEnvironmentalTrackingSystemScheme;
			return this;
		}
		
		@Override
		public EnvironmentalTrackingSystem build() {
			return new EnvironmentalTrackingSystem.EnvironmentalTrackingSystemImpl(this);
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityEnvironmentalTrackingSystemScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder o = (EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityEnvironmentalTrackingSystemScheme(), o.getCommodityEnvironmentalTrackingSystemScheme(), this::setCommodityEnvironmentalTrackingSystemScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalTrackingSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityEnvironmentalTrackingSystemScheme, _that.getCommodityEnvironmentalTrackingSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityEnvironmentalTrackingSystemScheme != null ? commodityEnvironmentalTrackingSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalTrackingSystemBuilder {" +
				"value=" + this.value + ", " +
				"commodityEnvironmentalTrackingSystemScheme=" + this.commodityEnvironmentalTrackingSystemScheme +
			'}';
		}
	}
}
