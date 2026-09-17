package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.PricingModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the types of pricing model used to evaluate the price of an asset. Examples include Intrinsic, ClosedForm, MonteCarlo, BackwardInduction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the types of pricing model used to evaluate the price of an asset. Examples include Intrinsic, ClosedForm, MonteCarlo, BackwardInduction.
 *
 */
@RosettaDataType(value="PricingModel", builder=PricingModel.PricingModelBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingModel", model="fpml", builder=PricingModel.PricingModelBuilderImpl.class, version="2.1.1")
public interface PricingModel extends RosettaModelObject {

	PricingModelMeta metaData = new PricingModelMeta();

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
	String getPricingModelScheme();

	/*********************** Build Methods  ***********************/
	PricingModel build();
	
	PricingModel.PricingModelBuilder toBuilder();
	
	static PricingModel.PricingModelBuilder builder() {
		return new PricingModel.PricingModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingModel> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingModel> getType() {
		return PricingModel.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("pricingModelScheme"), String.class, getPricingModelScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingModelBuilder extends PricingModel, RosettaModelObjectBuilder {
		PricingModel.PricingModelBuilder setValue(String value);
		PricingModel.PricingModelBuilder setPricingModelScheme(String pricingModelScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("pricingModelScheme"), String.class, getPricingModelScheme(), this);
		}
		

		PricingModel.PricingModelBuilder prune();
	}

	/*********************** Immutable Implementation of PricingModel  ***********************/
	class PricingModelImpl implements PricingModel {
		private final String value;
		private final String pricingModelScheme;
		
		protected PricingModelImpl(PricingModel.PricingModelBuilder builder) {
			this.value = builder.getValue();
			this.pricingModelScheme = builder.getPricingModelScheme();
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
		@RosettaAttribute("pricingModelScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingModelScheme")
		public String getPricingModelScheme() {
			return pricingModelScheme;
		}
		
		@Override
		public PricingModel build() {
			return this;
		}
		
		@Override
		public PricingModel.PricingModelBuilder toBuilder() {
			PricingModel.PricingModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingModel.PricingModelBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPricingModelScheme()).ifPresent(builder::setPricingModelScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingModel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingModelScheme, _that.getPricingModelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingModelScheme != null ? pricingModelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingModel {" +
				"value=" + this.value + ", " +
				"pricingModelScheme=" + this.pricingModelScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingModel  ***********************/
	class PricingModelBuilderImpl implements PricingModel.PricingModelBuilder {
	
		protected String value;
		protected String pricingModelScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pricingModelScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingModelScheme")
		public String getPricingModelScheme() {
			return pricingModelScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PricingModel.PricingModelBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("pricingModelScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingModelScheme")
		@Override
		public PricingModel.PricingModelBuilder setPricingModelScheme(String _pricingModelScheme) {
			this.pricingModelScheme = _pricingModelScheme == null ? null : _pricingModelScheme;
			return this;
		}
		
		@Override
		public PricingModel build() {
			return new PricingModel.PricingModelImpl(this);
		}
		
		@Override
		public PricingModel.PricingModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingModel.PricingModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPricingModelScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingModel.PricingModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingModel.PricingModelBuilder o = (PricingModel.PricingModelBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPricingModelScheme(), o.getPricingModelScheme(), this::setPricingModelScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingModel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingModelScheme, _that.getPricingModelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingModelScheme != null ? pricingModelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingModelBuilder {" +
				"value=" + this.value + ", " +
				"pricingModelScheme=" + this.pricingModelScheme +
			'}';
		}
	}
}
