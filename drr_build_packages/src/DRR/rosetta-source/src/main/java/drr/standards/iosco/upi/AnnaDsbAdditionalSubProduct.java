package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbAdditionalSubProductMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbAdditionalSubProduct", builder=AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbAdditionalSubProduct", model="drr", builder=AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilderImpl.class, version="7.7.0")
public interface AnnaDsbAdditionalSubProduct extends RosettaModelObject {

	AnnaDsbAdditionalSubProductMeta metaData = new AnnaDsbAdditionalSubProductMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbAdditionalSubProductEnum getAdditionalSubProduct();

	/*********************** Build Methods  ***********************/
	AnnaDsbAdditionalSubProduct build();
	
	AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder toBuilder();
	
	static AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder builder() {
		return new AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbAdditionalSubProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbAdditionalSubProduct> getType() {
		return AnnaDsbAdditionalSubProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("AdditionalSubProduct"), AnnaDsbAdditionalSubProductEnum.class, getAdditionalSubProduct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbAdditionalSubProductBuilder extends AnnaDsbAdditionalSubProduct, RosettaModelObjectBuilder {
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder setAdditionalSubProduct(AnnaDsbAdditionalSubProductEnum AdditionalSubProduct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("AdditionalSubProduct"), AnnaDsbAdditionalSubProductEnum.class, getAdditionalSubProduct(), this);
		}
		

		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbAdditionalSubProduct  ***********************/
	class AnnaDsbAdditionalSubProductImpl implements AnnaDsbAdditionalSubProduct {
		private final AnnaDsbAdditionalSubProductEnum additionalSubProduct;
		
		protected AnnaDsbAdditionalSubProductImpl(AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder builder) {
			this.additionalSubProduct = builder.getAdditionalSubProduct();
		}
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("AdditionalSubProduct")
		public AnnaDsbAdditionalSubProductEnum getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct build() {
			return this;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder toBuilder() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder builder) {
			ofNullable(getAdditionalSubProduct()).ifPresent(builder::setAdditionalSubProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAdditionalSubProduct _that = getType().cast(o);
		
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAdditionalSubProduct {" +
				"AdditionalSubProduct=" + this.additionalSubProduct +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbAdditionalSubProduct  ***********************/
	class AnnaDsbAdditionalSubProductBuilderImpl implements AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder {
	
		protected AnnaDsbAdditionalSubProductEnum additionalSubProduct;
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("AdditionalSubProduct")
		public AnnaDsbAdditionalSubProductEnum getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("AdditionalSubProduct")
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder setAdditionalSubProduct(AnnaDsbAdditionalSubProductEnum _additionalSubProduct) {
			this.additionalSubProduct = _additionalSubProduct == null ? null : _additionalSubProduct;
			return this;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct build() {
			return new AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductImpl(this);
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalSubProduct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder o = (AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder) other;
			
			
			merger.mergeBasic(getAdditionalSubProduct(), o.getAdditionalSubProduct(), this::setAdditionalSubProduct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAdditionalSubProduct _that = getType().cast(o);
		
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAdditionalSubProductBuilder {" +
				"AdditionalSubProduct=" + this.additionalSubProduct +
			'}';
		}
	}
}
