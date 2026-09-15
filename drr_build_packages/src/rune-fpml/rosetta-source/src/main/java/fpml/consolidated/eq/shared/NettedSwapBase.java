package fpml.consolidated.eq.shared;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.eq.shared.meta.NettedSwapBaseMeta;
import fpml.consolidated.option.shared.ClassifiablePayment;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
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
 * Provision An abstract base class for all swap types which have a single netted leg, such as Variance Swaps, and Correlation Swaps.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base class for all swap types which have a single netted leg, such as Variance Swaps, and Correlation Swaps.
 *
 */
@RosettaDataType(value="NettedSwapBase", builder=NettedSwapBase.NettedSwapBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NettedSwapBase", model="fpml", builder=NettedSwapBase.NettedSwapBaseBuilderImpl.class, version="2.1.1")
public interface NettedSwapBase extends Product {

	NettedSwapBaseMeta metaData = new NettedSwapBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies additional payment(s) between the principal parties to the netted swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies additional payment(s) between the principal parties to the netted swap.
	 *
	 */
	List<? extends ClassifiablePayment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	NettedSwapBase build();
	
	NettedSwapBase.NettedSwapBaseBuilder toBuilder();
	
	static NettedSwapBase.NettedSwapBaseBuilder builder() {
		return new NettedSwapBase.NettedSwapBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NettedSwapBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NettedSwapBase> getType() {
		return NettedSwapBase.class;
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
		processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NettedSwapBaseBuilder extends NettedSwapBase, Product.ProductBuilder {
		ClassifiablePayment.ClassifiablePaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends ClassifiablePayment.ClassifiablePaymentBuilder> getAdditionalPayment();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setId(String id);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductType(ProductType productType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductType(ProductType productType, int idx);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductType(List<? extends ProductType> productType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setProductType(List<? extends ProductType> productType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductId(ProductId productId);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductId(ProductId productId, int idx);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addProductId(List<? extends ProductId> productId);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setProductId(List<? extends ProductId> productId);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addAssetClass(AssetClass assetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		NettedSwapBase.NettedSwapBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int idx);
		NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		NettedSwapBase.NettedSwapBaseBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		NettedSwapBase.NettedSwapBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.ClassifiablePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		NettedSwapBase.NettedSwapBaseBuilder prune();
	}

	/*********************** Immutable Implementation of NettedSwapBase  ***********************/
	class NettedSwapBaseImpl extends Product.ProductImpl implements NettedSwapBase {
		private final List<? extends ClassifiablePayment> additionalPayment;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected NettedSwapBaseImpl(NettedSwapBase.NettedSwapBaseBuilder builder) {
			super(builder);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends ClassifiablePayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public NettedSwapBase build() {
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder toBuilder() {
			NettedSwapBase.NettedSwapBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NettedSwapBase.NettedSwapBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NettedSwapBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NettedSwapBase {" +
				"additionalPayment=" + this.additionalPayment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NettedSwapBase  ***********************/
	class NettedSwapBaseBuilderImpl extends Product.ProductBuilderImpl implements NettedSwapBase.NettedSwapBaseBuilder {
	
		protected List<ClassifiablePayment.ClassifiablePaymentBuilder> additionalPayment = new ArrayList<>();
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends ClassifiablePayment.ClassifiablePaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						ClassifiablePayment.ClassifiablePaymentBuilder newAdditionalPayment = ClassifiablePayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public NettedSwapBase.NettedSwapBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public NettedSwapBase.NettedSwapBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setProductId(List<? extends ProductId> productIds) {
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
		public NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public NettedSwapBase.NettedSwapBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
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
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (final ClassifiablePayment toAdd : additionalPayments) {
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
		public NettedSwapBase.NettedSwapBaseBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public NettedSwapBase build() {
			return new NettedSwapBase.NettedSwapBaseImpl(this);
		}
		
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder prune() {
			super.prune();
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<ClassifiablePayment.ClassifiablePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NettedSwapBase.NettedSwapBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NettedSwapBase.NettedSwapBaseBuilder o = (NettedSwapBase.NettedSwapBaseBuilder) other;
			
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NettedSwapBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NettedSwapBaseBuilder {" +
				"additionalPayment=" + this.additionalPayment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
