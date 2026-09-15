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
import fpml.consolidated.com.meta.CommodityMetalProducerMeta;
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
@RosettaDataType(value="CommodityMetalProducer", builder=CommodityMetalProducer.CommodityMetalProducerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityMetalProducer", model="fpml", builder=CommodityMetalProducer.CommodityMetalProducerBuilderImpl.class, version="2.1.1")
public interface CommodityMetalProducer extends RosettaModelObject {

	CommodityMetalProducerMeta metaData = new CommodityMetalProducerMeta();

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
	String getCommodityMetalProducerScheme();

	/*********************** Build Methods  ***********************/
	CommodityMetalProducer build();
	
	CommodityMetalProducer.CommodityMetalProducerBuilder toBuilder();
	
	static CommodityMetalProducer.CommodityMetalProducerBuilder builder() {
		return new CommodityMetalProducer.CommodityMetalProducerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalProducer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityMetalProducer> getType() {
		return CommodityMetalProducer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalProducerScheme"), String.class, getCommodityMetalProducerScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalProducerBuilder extends CommodityMetalProducer, RosettaModelObjectBuilder {
		CommodityMetalProducer.CommodityMetalProducerBuilder setValue(String value);
		CommodityMetalProducer.CommodityMetalProducerBuilder setCommodityMetalProducerScheme(String commodityMetalProducerScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalProducerScheme"), String.class, getCommodityMetalProducerScheme(), this);
		}
		

		CommodityMetalProducer.CommodityMetalProducerBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalProducer  ***********************/
	class CommodityMetalProducerImpl implements CommodityMetalProducer {
		private final String value;
		private final String commodityMetalProducerScheme;
		
		protected CommodityMetalProducerImpl(CommodityMetalProducer.CommodityMetalProducerBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalProducerScheme = builder.getCommodityMetalProducerScheme();
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
		@RosettaAttribute("commodityMetalProducerScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalProducerScheme")
		public String getCommodityMetalProducerScheme() {
			return commodityMetalProducerScheme;
		}
		
		@Override
		public CommodityMetalProducer build() {
			return this;
		}
		
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder toBuilder() {
			CommodityMetalProducer.CommodityMetalProducerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalProducer.CommodityMetalProducerBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalProducerScheme()).ifPresent(builder::setCommodityMetalProducerScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalProducer _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalProducerScheme, _that.getCommodityMetalProducerScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalProducerScheme != null ? commodityMetalProducerScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalProducer {" +
				"value=" + this.value + ", " +
				"commodityMetalProducerScheme=" + this.commodityMetalProducerScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalProducer  ***********************/
	class CommodityMetalProducerBuilderImpl implements CommodityMetalProducer.CommodityMetalProducerBuilder {
	
		protected String value;
		protected String commodityMetalProducerScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalProducerScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalProducerScheme")
		public String getCommodityMetalProducerScheme() {
			return commodityMetalProducerScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityMetalProducerScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityMetalProducerScheme")
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder setCommodityMetalProducerScheme(String _commodityMetalProducerScheme) {
			this.commodityMetalProducerScheme = _commodityMetalProducerScheme == null ? null : _commodityMetalProducerScheme;
			return this;
		}
		
		@Override
		public CommodityMetalProducer build() {
			return new CommodityMetalProducer.CommodityMetalProducerImpl(this);
		}
		
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalProducerScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalProducer.CommodityMetalProducerBuilder o = (CommodityMetalProducer.CommodityMetalProducerBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalProducerScheme(), o.getCommodityMetalProducerScheme(), this::setCommodityMetalProducerScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalProducer _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalProducerScheme, _that.getCommodityMetalProducerScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalProducerScheme != null ? commodityMetalProducerScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalProducerBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalProducerScheme=" + this.commodityMetalProducerScheme +
			'}';
		}
	}
}
