package fpml.consolidated.ird;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.ird.meta.CapFloorMeta;
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
 * Provision A type defining an interest rate cap, floor, or cap/floor strategy (e.g. collar) product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an interest rate cap, floor, or cap/floor strategy (e.g. collar) product.
 *
 */
@RosettaDataType(value="CapFloor", builder=CapFloor.CapFloorBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CapFloor", model="fpml", builder=CapFloor.CapFloorBuilderImpl.class, version="2.1.1")
public interface CapFloor extends Product {

	CapFloorMeta metaData = new CapFloorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the leg, where date adjustments may apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the leg, where date adjustments may apply.
	 *
	 */
	InterestRateStream getCapFloorStream();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The option premium amount payable by buyer to seller on the specified payment date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The option premium amount payable by buyer to seller on the specified payment date.
	 *
	 */
	List<? extends Payment> getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a CapFloor transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a CapFloor transaction.
	 *
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();

	/*********************** Build Methods  ***********************/
	CapFloor build();
	
	CapFloor.CapFloorBuilder toBuilder();
	
	static CapFloor.CapFloorBuilder builder() {
		return new CapFloor.CapFloorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CapFloor> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CapFloor> getType() {
		return CapFloor.class;
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
		processRosetta(path.newSubPath("capFloorStream"), processor, InterestRateStream.class, getCapFloorStream());
		processRosetta(path.newSubPath("premium"), processor, Payment.class, getPremium());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CapFloorBuilder extends CapFloor, Product.ProductBuilder {
		InterestRateStream.InterestRateStreamBuilder getOrCreateCapFloorStream();
		@Override
		InterestRateStream.InterestRateStreamBuilder getCapFloorStream();
		Payment.PaymentBuilder getOrCreatePremium(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPremium();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		@Override
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		@Override
		CapFloor.CapFloorBuilder setId(String id);
		@Override
		CapFloor.CapFloorBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CapFloor.CapFloorBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CapFloor.CapFloorBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CapFloor.CapFloorBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CapFloor.CapFloorBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CapFloor.CapFloorBuilder addProductType(ProductType productType);
		@Override
		CapFloor.CapFloorBuilder addProductType(ProductType productType, int idx);
		@Override
		CapFloor.CapFloorBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CapFloor.CapFloorBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CapFloor.CapFloorBuilder addProductId(ProductId productId);
		@Override
		CapFloor.CapFloorBuilder addProductId(ProductId productId, int idx);
		@Override
		CapFloor.CapFloorBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CapFloor.CapFloorBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CapFloor.CapFloorBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CapFloor.CapFloorBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CapFloor.CapFloorBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CapFloor.CapFloorBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CapFloor.CapFloorBuilder addAssetClass(AssetClass assetClass);
		@Override
		CapFloor.CapFloorBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CapFloor.CapFloorBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CapFloor.CapFloorBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CapFloor.CapFloorBuilder setCapFloorStream(InterestRateStream capFloorStream);
		CapFloor.CapFloorBuilder addPremium(Payment premium);
		CapFloor.CapFloorBuilder addPremium(Payment premium, int idx);
		CapFloor.CapFloorBuilder addPremium(List<? extends Payment> premium);
		CapFloor.CapFloorBuilder setPremium(List<? extends Payment> premium);
		CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment);
		CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		CapFloor.CapFloorBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		CapFloor.CapFloorBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);
		CapFloor.CapFloorBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("capFloorStream"), processor, InterestRateStream.InterestRateStreamBuilder.class, getCapFloorStream());
			processRosetta(path.newSubPath("premium"), processor, Payment.PaymentBuilder.class, getPremium());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
		}
		

		CapFloor.CapFloorBuilder prune();
	}

	/*********************** Immutable Implementation of CapFloor  ***********************/
	class CapFloorImpl extends Product.ProductImpl implements CapFloor {
		private final InterestRateStream capFloorStream;
		private final List<? extends Payment> premium;
		private final List<? extends Payment> additionalPayment;
		private final EarlyTerminationProvision earlyTerminationProvision;
		
		protected CapFloorImpl(CapFloor.CapFloorBuilder builder) {
			super(builder);
			this.capFloorStream = ofNullable(builder.getCapFloorStream()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("capFloorStream")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("capFloorStream")
		public InterestRateStream getCapFloorStream() {
			return capFloorStream;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends Payment> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public CapFloor build() {
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder toBuilder() {
			CapFloor.CapFloorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CapFloor.CapFloorBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCapFloorStream()).ifPresent(builder::setCapFloorStream);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CapFloor _that = getType().cast(o);
		
			if (!Objects.equals(capFloorStream, _that.getCapFloorStream())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (capFloorStream != null ? capFloorStream.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CapFloor {" +
				"capFloorStream=" + this.capFloorStream + ", " +
				"premium=" + this.premium + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CapFloor  ***********************/
	class CapFloorBuilderImpl extends Product.ProductBuilderImpl implements CapFloor.CapFloorBuilder {
	
		protected InterestRateStream.InterestRateStreamBuilder capFloorStream;
		protected List<Payment.PaymentBuilder> premium = new ArrayList<>();
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
		
		@Override
		@RosettaAttribute("capFloorStream")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("capFloorStream")
		public InterestRateStream.InterestRateStreamBuilder getCapFloorStream() {
			return capFloorStream;
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder getOrCreateCapFloorStream() {
			InterestRateStream.InterestRateStreamBuilder result;
			if (capFloorStream!=null) {
				result = capFloorStream;
			}
			else {
				result = capFloorStream = InterestRateStream.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends Payment.PaymentBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						Payment.PaymentBuilder newPremium = Payment.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder result;
			if (earlyTerminationProvision!=null) {
				result = earlyTerminationProvision;
			}
			else {
				result = earlyTerminationProvision = EarlyTerminationProvision.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CapFloor.CapFloorBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CapFloor.CapFloorBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CapFloor.CapFloorBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CapFloor.CapFloorBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CapFloor.CapFloorBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CapFloor.CapFloorBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CapFloor.CapFloorBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CapFloor.CapFloorBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CapFloor.CapFloorBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CapFloor.CapFloorBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CapFloor.CapFloorBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CapFloor.CapFloorBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("capFloorStream")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("capFloorStream")
		@Override
		public CapFloor.CapFloorBuilder setCapFloorStream(InterestRateStream _capFloorStream) {
			this.capFloorStream = _capFloorStream == null ? null : _capFloorStream.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public CapFloor.CapFloorBuilder addPremium(Payment _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addPremium(Payment _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addPremium(List<? extends Payment> premiums) {
			if (premiums != null) {
				for (final Payment toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public CapFloor.CapFloorBuilder setPremium(List<? extends Payment> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public CapFloor.CapFloorBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (final Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public CapFloor.CapFloorBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationProvision")
		@Override
		public CapFloor.CapFloorBuilder setEarlyTerminationProvision(EarlyTerminationProvision _earlyTerminationProvision) {
			this.earlyTerminationProvision = _earlyTerminationProvision == null ? null : _earlyTerminationProvision.toBuilder();
			return this;
		}
		
		@Override
		public CapFloor build() {
			return new CapFloor.CapFloorImpl(this);
		}
		
		@Override
		public CapFloor.CapFloorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CapFloor.CapFloorBuilder prune() {
			super.prune();
			if (capFloorStream!=null && !capFloorStream.prune().hasData()) capFloorStream = null;
			premium = premium.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCapFloorStream()!=null && getCapFloorStream().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CapFloor.CapFloorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CapFloor.CapFloorBuilder o = (CapFloor.CapFloorBuilder) other;
			
			merger.mergeRosetta(getCapFloorStream(), o.getCapFloorStream(), this::setCapFloorStream);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CapFloor _that = getType().cast(o);
		
			if (!Objects.equals(capFloorStream, _that.getCapFloorStream())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (capFloorStream != null ? capFloorStream.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CapFloorBuilder {" +
				"capFloorStream=" + this.capFloorStream + ", " +
				"premium=" + this.premium + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision +
			'}' + " " + super.toString();
		}
	}
}
