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
import fpml.consolidated.com.meta.CommodityPipelineMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The pipeline through which the physical commodity will be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The pipeline through which the physical commodity will be delivered.
 *
 */
@RosettaDataType(value="CommodityPipeline", builder=CommodityPipeline.CommodityPipelineBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPipeline", model="fpml", builder=CommodityPipeline.CommodityPipelineBuilderImpl.class, version="2.1.1")
public interface CommodityPipeline extends RosettaModelObject {

	CommodityPipelineMeta metaData = new CommodityPipelineMeta();

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
	String getPipelineScheme();

	/*********************** Build Methods  ***********************/
	CommodityPipeline build();
	
	CommodityPipeline.CommodityPipelineBuilder toBuilder();
	
	static CommodityPipeline.CommodityPipelineBuilder builder() {
		return new CommodityPipeline.CommodityPipelineBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPipeline> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPipeline> getType() {
		return CommodityPipeline.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("pipelineScheme"), String.class, getPipelineScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPipelineBuilder extends CommodityPipeline, RosettaModelObjectBuilder {
		CommodityPipeline.CommodityPipelineBuilder setValue(String value);
		CommodityPipeline.CommodityPipelineBuilder setPipelineScheme(String pipelineScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("pipelineScheme"), String.class, getPipelineScheme(), this);
		}
		

		CommodityPipeline.CommodityPipelineBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPipeline  ***********************/
	class CommodityPipelineImpl implements CommodityPipeline {
		private final String value;
		private final String pipelineScheme;
		
		protected CommodityPipelineImpl(CommodityPipeline.CommodityPipelineBuilder builder) {
			this.value = builder.getValue();
			this.pipelineScheme = builder.getPipelineScheme();
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
		@RosettaAttribute("pipelineScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipelineScheme")
		public String getPipelineScheme() {
			return pipelineScheme;
		}
		
		@Override
		public CommodityPipeline build() {
			return this;
		}
		
		@Override
		public CommodityPipeline.CommodityPipelineBuilder toBuilder() {
			CommodityPipeline.CommodityPipelineBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPipeline.CommodityPipelineBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPipelineScheme()).ifPresent(builder::setPipelineScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPipeline _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pipelineScheme, _that.getPipelineScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pipelineScheme != null ? pipelineScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPipeline {" +
				"value=" + this.value + ", " +
				"pipelineScheme=" + this.pipelineScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPipeline  ***********************/
	class CommodityPipelineBuilderImpl implements CommodityPipeline.CommodityPipelineBuilder {
	
		protected String value;
		protected String pipelineScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pipelineScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipelineScheme")
		public String getPipelineScheme() {
			return pipelineScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityPipeline.CommodityPipelineBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("pipelineScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pipelineScheme")
		@Override
		public CommodityPipeline.CommodityPipelineBuilder setPipelineScheme(String _pipelineScheme) {
			this.pipelineScheme = _pipelineScheme == null ? null : _pipelineScheme;
			return this;
		}
		
		@Override
		public CommodityPipeline build() {
			return new CommodityPipeline.CommodityPipelineImpl(this);
		}
		
		@Override
		public CommodityPipeline.CommodityPipelineBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPipeline.CommodityPipelineBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPipelineScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPipeline.CommodityPipelineBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPipeline.CommodityPipelineBuilder o = (CommodityPipeline.CommodityPipelineBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPipelineScheme(), o.getPipelineScheme(), this::setPipelineScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPipeline _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pipelineScheme, _that.getPipelineScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pipelineScheme != null ? pipelineScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPipelineBuilder {" +
				"value=" + this.value + ", " +
				"pipelineScheme=" + this.pipelineScheme +
			'}';
		}
	}
}
