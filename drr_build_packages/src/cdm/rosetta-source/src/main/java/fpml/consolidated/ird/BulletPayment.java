package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.BulletPaymentMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A product to represent a single cashflow.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A product to represent a single cashflow.
 *
 */
@RosettaDataType(value="BulletPayment", builder=BulletPayment.BulletPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BulletPayment", model="fpml", builder=BulletPayment.BulletPaymentBuilderImpl.class, version="2.1.1")
public interface BulletPayment extends Product {

	BulletPaymentMeta metaData = new BulletPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A known payment between two parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A known payment between two parties.
	 *
	 */
	Payment getPayment();

	/*********************** Build Methods  ***********************/
	BulletPayment build();
	
	BulletPayment.BulletPaymentBuilder toBuilder();
	
	static BulletPayment.BulletPaymentBuilder builder() {
		return new BulletPayment.BulletPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BulletPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BulletPayment> getType() {
		return BulletPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BulletPaymentBuilder extends BulletPayment, Product.ProductBuilder {
		Payment.PaymentBuilder getOrCreatePayment();
		@Override
		Payment.PaymentBuilder getPayment();
		@Override
		BulletPayment.BulletPaymentBuilder setId(String id);
		@Override
		BulletPayment.BulletPaymentBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BulletPayment.BulletPaymentBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BulletPayment.BulletPaymentBuilder addProductType(ProductType productType);
		@Override
		BulletPayment.BulletPaymentBuilder addProductType(ProductType productType, int idx);
		@Override
		BulletPayment.BulletPaymentBuilder addProductType(List<? extends ProductType> productType);
		@Override
		BulletPayment.BulletPaymentBuilder setProductType(List<? extends ProductType> productType);
		@Override
		BulletPayment.BulletPaymentBuilder addProductId(ProductId productId);
		@Override
		BulletPayment.BulletPaymentBuilder addProductId(ProductId productId, int idx);
		@Override
		BulletPayment.BulletPaymentBuilder addProductId(List<? extends ProductId> productId);
		@Override
		BulletPayment.BulletPaymentBuilder setProductId(List<? extends ProductId> productId);
		@Override
		BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BulletPayment.BulletPaymentBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BulletPayment.BulletPaymentBuilder addAssetClass(AssetClass assetClass);
		@Override
		BulletPayment.BulletPaymentBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		BulletPayment.BulletPaymentBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		BulletPayment.BulletPaymentBuilder setAssetClass(List<? extends AssetClass> assetClass);
		BulletPayment.BulletPaymentBuilder setPayment(Payment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		BulletPayment.BulletPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of BulletPayment  ***********************/
	class BulletPaymentImpl extends Product.ProductImpl implements BulletPayment {
		private final Payment payment;
		
		protected BulletPaymentImpl(BulletPayment.BulletPaymentBuilder builder) {
			super(builder);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public Payment getPayment() {
			return payment;
		}
		
		@Override
		public BulletPayment build() {
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder toBuilder() {
			BulletPayment.BulletPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BulletPayment.BulletPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BulletPayment _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BulletPayment {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BulletPayment  ***********************/
	class BulletPaymentBuilderImpl extends Product.ProductBuilderImpl implements BulletPayment.BulletPaymentBuilder {
	
		protected Payment.PaymentBuilder payment;
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public Payment.PaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment() {
			Payment.PaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = Payment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BulletPayment.BulletPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public BulletPayment.BulletPaymentBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public BulletPayment.BulletPaymentBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public BulletPayment.BulletPaymentBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public BulletPayment.BulletPaymentBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public BulletPayment.BulletPaymentBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public BulletPayment.BulletPaymentBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public BulletPayment.BulletPaymentBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public BulletPayment.BulletPaymentBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public BulletPayment.BulletPaymentBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public BulletPayment.BulletPaymentBuilder setPayment(Payment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@Override
		public BulletPayment build() {
			return new BulletPayment.BulletPaymentImpl(this);
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BulletPayment.BulletPaymentBuilder prune() {
			super.prune();
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BulletPayment.BulletPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BulletPayment.BulletPaymentBuilder o = (BulletPayment.BulletPaymentBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BulletPayment _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BulletPaymentBuilder {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
