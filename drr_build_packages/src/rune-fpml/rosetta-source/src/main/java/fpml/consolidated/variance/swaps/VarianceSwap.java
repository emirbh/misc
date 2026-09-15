package fpml.consolidated.variance.swaps;

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
import fpml.consolidated.variance.swaps.meta.VarianceSwapMeta;
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
 * Provision A Variance Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Variance Swap.
 *
 */
@RosettaDataType(value="VarianceSwap", builder=VarianceSwap.VarianceSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VarianceSwap", model="fpml", builder=VarianceSwap.VarianceSwapBuilderImpl.class, version="2.1.1")
public interface VarianceSwap extends NettedSwapBase {

	VarianceSwapMeta metaData = new VarianceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Variance Leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Variance Leg.
	 *
	 */
	List<? extends VarianceLeg> getVarianceLeg();

	/*********************** Build Methods  ***********************/
	VarianceSwap build();
	
	VarianceSwap.VarianceSwapBuilder toBuilder();
	
	static VarianceSwap.VarianceSwapBuilder builder() {
		return new VarianceSwap.VarianceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VarianceSwap> getType() {
		return VarianceSwap.class;
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
		processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.class, getVarianceLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceSwapBuilder extends VarianceSwap, NettedSwapBase.NettedSwapBaseBuilder {
		VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int index);
		@Override
		List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg();
		@Override
		VarianceSwap.VarianceSwapBuilder setId(String id);
		@Override
		VarianceSwap.VarianceSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductType(ProductType productType);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		VarianceSwap.VarianceSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductId(ProductId productId);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		VarianceSwap.VarianceSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VarianceSwap.VarianceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VarianceSwap.VarianceSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment);
		@Override
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int idx);
		@Override
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		VarianceSwap.VarianceSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		VarianceSwap.VarianceSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg, int idx);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLeg);
		VarianceSwap.VarianceSwapBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLeg);

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
			processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.VarianceLegBuilder.class, getVarianceLeg());
		}
		

		VarianceSwap.VarianceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceSwap  ***********************/
	class VarianceSwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements VarianceSwap {
		private final List<? extends VarianceLeg> varianceLeg;
		
		protected VarianceSwapImpl(VarianceSwap.VarianceSwapBuilder builder) {
			super(builder);
			this.varianceLeg = ofNullable(builder.getVarianceLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("varianceLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("varianceLeg")
		public List<? extends VarianceLeg> getVarianceLeg() {
			return varianceLeg;
		}
		
		@Override
		public VarianceSwap build() {
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder toBuilder() {
			VarianceSwap.VarianceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceSwap.VarianceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceLeg()).ifPresent(builder::setVarianceLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwap {" +
				"varianceLeg=" + this.varianceLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceSwap  ***********************/
	class VarianceSwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl implements VarianceSwap.VarianceSwapBuilder {
	
		protected List<VarianceLeg.VarianceLegBuilder> varianceLeg = new ArrayList<>();
		
		@Override
		@RosettaAttribute("varianceLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("varianceLeg")
		public List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg() {
			return varianceLeg;
		}
		
		@Override
		public VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int index) {
			if (varianceLeg==null) {
				this.varianceLeg = new ArrayList<>();
			}
			return getIndex(varianceLeg, index, () -> {
						VarianceLeg.VarianceLegBuilder newVarianceLeg = VarianceLeg.builder();
						return newVarianceLeg;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VarianceSwap.VarianceSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public VarianceSwap.VarianceSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VarianceSwap.VarianceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VarianceSwap.VarianceSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public VarianceSwap.VarianceSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public VarianceSwap.VarianceSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public VarianceSwap.VarianceSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VarianceSwap.VarianceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VarianceSwap.VarianceSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VarianceSwap.VarianceSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public VarianceSwap.VarianceSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public VarianceSwap.VarianceSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("varianceLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("varianceLeg")
		@Override
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg _varianceLeg) {
			if (_varianceLeg != null) {
				this.varianceLeg.add(_varianceLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg _varianceLeg, int idx) {
			getIndex(this.varianceLeg, idx, () -> _varianceLeg.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs != null) {
				for (final VarianceLeg toAdd : varianceLegs) {
					this.varianceLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("varianceLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("varianceLeg")
		@Override
		public VarianceSwap.VarianceSwapBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs == null) {
				this.varianceLeg = new ArrayList<>();
			} else {
				this.varianceLeg = varianceLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public VarianceSwap build() {
			return new VarianceSwap.VarianceSwapImpl(this);
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwap.VarianceSwapBuilder prune() {
			super.prune();
			varianceLeg = varianceLeg.stream().filter(b->b!=null).<VarianceLeg.VarianceLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceLeg()!=null && getVarianceLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwap.VarianceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VarianceSwap.VarianceSwapBuilder o = (VarianceSwap.VarianceSwapBuilder) other;
			
			merger.mergeRosetta(getVarianceLeg(), o.getVarianceLeg(), this::getOrCreateVarianceLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwapBuilder {" +
				"varianceLeg=" + this.varianceLeg +
			'}' + " " + super.toString();
		}
	}
}
