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
import fpml.consolidated.com.meta.CoalQualityAdjustmentsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the quality adjustment formulae for a physically settled coal trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the quality adjustment formulae for a physically settled coal trade.
 *
 */
@RosettaDataType(value="CoalQualityAdjustments", builder=CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalQualityAdjustments", model="fpml", builder=CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl.class, version="2.1.1")
public interface CoalQualityAdjustments extends RosettaModelObject {

	CoalQualityAdjustmentsMeta metaData = new CoalQualityAdjustmentsMeta();

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
	String getCommodityCoalQualityAdjustmentsScheme();

	/*********************** Build Methods  ***********************/
	CoalQualityAdjustments build();
	
	CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder();
	
	static CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder() {
		return new CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalQualityAdjustments> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalQualityAdjustments> getType() {
		return CoalQualityAdjustments.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityCoalQualityAdjustmentsScheme"), String.class, getCommodityCoalQualityAdjustmentsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalQualityAdjustmentsBuilder extends CoalQualityAdjustments, RosettaModelObjectBuilder {
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setValue(String value);
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setCommodityCoalQualityAdjustmentsScheme(String commodityCoalQualityAdjustmentsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityCoalQualityAdjustmentsScheme"), String.class, getCommodityCoalQualityAdjustmentsScheme(), this);
		}
		

		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder prune();
	}

	/*********************** Immutable Implementation of CoalQualityAdjustments  ***********************/
	class CoalQualityAdjustmentsImpl implements CoalQualityAdjustments {
		private final String value;
		private final String commodityCoalQualityAdjustmentsScheme;
		
		protected CoalQualityAdjustmentsImpl(CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder) {
			this.value = builder.getValue();
			this.commodityCoalQualityAdjustmentsScheme = builder.getCommodityCoalQualityAdjustmentsScheme();
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
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityCoalQualityAdjustmentsScheme")
		public String getCommodityCoalQualityAdjustmentsScheme() {
			return commodityCoalQualityAdjustmentsScheme;
		}
		
		@Override
		public CoalQualityAdjustments build() {
			return this;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityCoalQualityAdjustmentsScheme()).ifPresent(builder::setCommodityCoalQualityAdjustmentsScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalQualityAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalQualityAdjustmentsScheme, _that.getCommodityCoalQualityAdjustmentsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalQualityAdjustmentsScheme != null ? commodityCoalQualityAdjustmentsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalQualityAdjustments {" +
				"value=" + this.value + ", " +
				"commodityCoalQualityAdjustmentsScheme=" + this.commodityCoalQualityAdjustmentsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalQualityAdjustments  ***********************/
	class CoalQualityAdjustmentsBuilderImpl implements CoalQualityAdjustments.CoalQualityAdjustmentsBuilder {
	
		protected String value;
		protected String commodityCoalQualityAdjustmentsScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityCoalQualityAdjustmentsScheme")
		public String getCommodityCoalQualityAdjustmentsScheme() {
			return commodityCoalQualityAdjustmentsScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityCoalQualityAdjustmentsScheme")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setCommodityCoalQualityAdjustmentsScheme(String _commodityCoalQualityAdjustmentsScheme) {
			this.commodityCoalQualityAdjustmentsScheme = _commodityCoalQualityAdjustmentsScheme == null ? null : _commodityCoalQualityAdjustmentsScheme;
			return this;
		}
		
		@Override
		public CoalQualityAdjustments build() {
			return new CoalQualityAdjustments.CoalQualityAdjustmentsImpl(this);
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityCoalQualityAdjustmentsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder o = (CoalQualityAdjustments.CoalQualityAdjustmentsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityCoalQualityAdjustmentsScheme(), o.getCommodityCoalQualityAdjustmentsScheme(), this::setCommodityCoalQualityAdjustmentsScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalQualityAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalQualityAdjustmentsScheme, _that.getCommodityCoalQualityAdjustmentsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalQualityAdjustmentsScheme != null ? commodityCoalQualityAdjustmentsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalQualityAdjustmentsBuilder {" +
				"value=" + this.value + ", " +
				"commodityCoalQualityAdjustmentsScheme=" + this.commodityCoalQualityAdjustmentsScheme +
			'}';
		}
	}
}
