package fpml.consolidated.volatility.swaps;

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
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.NettedSwapBase;
import fpml.consolidated.option.shared.ClassifiablePayment;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.volatility.swaps.meta.VolatilitySwapMeta;
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
 * Provision A Volatility Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Volatility Swap.
 *
 */
@RosettaDataType(value="VolatilitySwap", builder=VolatilitySwap.VolatilitySwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilitySwap", model="fpml", builder=VolatilitySwap.VolatilitySwapBuilderImpl.class, version="2.1.1")
public interface VolatilitySwap extends NettedSwapBase {

	VolatilitySwapMeta metaData = new VolatilitySwapMeta();

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
	List<? extends VolatilityLeg> getVolatilityLeg();

	/*********************** Build Methods  ***********************/
	VolatilitySwap build();
	
	VolatilitySwap.VolatilitySwapBuilder toBuilder();
	
	static VolatilitySwap.VolatilitySwapBuilder builder() {
		return new VolatilitySwap.VolatilitySwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilitySwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilitySwap> getType() {
		return VolatilitySwap.class;
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
		processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.class, getVolatilityLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilitySwapBuilder extends VolatilitySwap, NettedSwapBase.NettedSwapBaseBuilder {
		VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int index);
		@Override
		List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg();
		@Override
		VolatilitySwap.VolatilitySwapBuilder setId(String id);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductType(ProductType productType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductType(ProductType productType, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductId(ProductId productId);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductId(ProductId productId, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int idx);
		@Override
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		VolatilitySwap.VolatilitySwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg, int idx);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg);
		VolatilitySwap.VolatilitySwapBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg);

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
			processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.VolatilityLegBuilder.class, getVolatilityLeg());
		}
		

		VolatilitySwap.VolatilitySwapBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilitySwap  ***********************/
	class VolatilitySwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements VolatilitySwap {
		private final List<? extends VolatilityLeg> volatilityLeg;
		
		protected VolatilitySwapImpl(VolatilitySwap.VolatilitySwapBuilder builder) {
			super(builder);
			this.volatilityLeg = ofNullable(builder.getVolatilityLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("volatilityLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("volatilityLeg")
		public List<? extends VolatilityLeg> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		@Override
		public VolatilitySwap build() {
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder toBuilder() {
			VolatilitySwap.VolatilitySwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilitySwap.VolatilitySwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatilityLeg()).ifPresent(builder::setVolatilityLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwap {" +
				"volatilityLeg=" + this.volatilityLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilitySwap  ***********************/
	class VolatilitySwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl implements VolatilitySwap.VolatilitySwapBuilder {
	
		protected List<VolatilityLeg.VolatilityLegBuilder> volatilityLeg = new ArrayList<>();
		
		@Override
		@RosettaAttribute("volatilityLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("volatilityLeg")
		public List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int index) {
			if (volatilityLeg==null) {
				this.volatilityLeg = new ArrayList<>();
			}
			return getIndex(volatilityLeg, index, () -> {
						VolatilityLeg.VolatilityLegBuilder newVolatilityLeg = VolatilityLeg.builder();
						return newVolatilityLeg;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VolatilitySwap.VolatilitySwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VolatilitySwap.VolatilitySwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public VolatilitySwap.VolatilitySwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public VolatilitySwap.VolatilitySwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public VolatilitySwap.VolatilitySwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VolatilitySwap.VolatilitySwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VolatilitySwap.VolatilitySwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VolatilitySwap.VolatilitySwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public VolatilitySwap.VolatilitySwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public VolatilitySwap.VolatilitySwapBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("volatilityLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("volatilityLeg")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg _volatilityLeg) {
			if (_volatilityLeg != null) {
				this.volatilityLeg.add(_volatilityLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg _volatilityLeg, int idx) {
			getIndex(this.volatilityLeg, idx, () -> _volatilityLeg.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs != null) {
				for (final VolatilityLeg toAdd : volatilityLegs) {
					this.volatilityLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("volatilityLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("volatilityLeg")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs == null) {
				this.volatilityLeg = new ArrayList<>();
			} else {
				this.volatilityLeg = volatilityLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public VolatilitySwap build() {
			return new VolatilitySwap.VolatilitySwapImpl(this);
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder prune() {
			super.prune();
			volatilityLeg = volatilityLeg.stream().filter(b->b!=null).<VolatilityLeg.VolatilityLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatilityLeg()!=null && getVolatilityLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilitySwap.VolatilitySwapBuilder o = (VolatilitySwap.VolatilitySwapBuilder) other;
			
			merger.mergeRosetta(getVolatilityLeg(), o.getVolatilityLeg(), this::getOrCreateVolatilityLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapBuilder {" +
				"volatilityLeg=" + this.volatilityLeg +
			'}' + " " + super.toString();
		}
	}
}
