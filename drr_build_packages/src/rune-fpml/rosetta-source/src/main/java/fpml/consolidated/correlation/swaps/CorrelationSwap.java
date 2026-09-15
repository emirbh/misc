package fpml.consolidated.correlation.swaps;

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
import fpml.consolidated.correlation.swaps.meta.CorrelationSwapMeta;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.NettedSwapBase;
import fpml.consolidated.option.shared.ClassifiablePayment;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
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
 * Provision A Correlation Swap modelled using a single netted leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Correlation Swap modelled using a single netted leg.
 *
 */
@RosettaDataType(value="CorrelationSwap", builder=CorrelationSwap.CorrelationSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrelationSwap", model="fpml", builder=CorrelationSwap.CorrelationSwapBuilderImpl.class, version="2.1.1")
public interface CorrelationSwap extends NettedSwapBase {

	CorrelationSwapMeta metaData = new CorrelationSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Correlation Leg. Correlation Buyer is deemed to be the Equity Amount Receiver, Correlation Seller is deemed to be the Equity Amount Payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Correlation Leg. Correlation Buyer is deemed to be the Equity Amount Receiver, Correlation Seller is deemed to be the Equity Amount Payer.
	 *
	 */
	CorrelationLeg getCorrelationLeg();

	/*********************** Build Methods  ***********************/
	CorrelationSwap build();
	
	CorrelationSwap.CorrelationSwapBuilder toBuilder();
	
	static CorrelationSwap.CorrelationSwapBuilder builder() {
		return new CorrelationSwap.CorrelationSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrelationSwap> getType() {
		return CorrelationSwap.class;
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
		processRosetta(path.newSubPath("correlationLeg"), processor, CorrelationLeg.class, getCorrelationLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationSwapBuilder extends CorrelationSwap, NettedSwapBase.NettedSwapBaseBuilder {
		CorrelationLeg.CorrelationLegBuilder getOrCreateCorrelationLeg();
		@Override
		CorrelationLeg.CorrelationLegBuilder getCorrelationLeg();
		@Override
		CorrelationSwap.CorrelationSwapBuilder setId(String id);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductType(ProductType productType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductId(ProductId productId);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int idx);
		@Override
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment);
		@Override
		CorrelationSwap.CorrelationSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		CorrelationSwap.CorrelationSwapBuilder setCorrelationLeg(CorrelationLeg correlationLeg);

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
			processRosetta(path.newSubPath("correlationLeg"), processor, CorrelationLeg.CorrelationLegBuilder.class, getCorrelationLeg());
		}
		

		CorrelationSwap.CorrelationSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationSwap  ***********************/
	class CorrelationSwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements CorrelationSwap {
		private final CorrelationLeg correlationLeg;
		
		protected CorrelationSwapImpl(CorrelationSwap.CorrelationSwapBuilder builder) {
			super(builder);
			this.correlationLeg = ofNullable(builder.getCorrelationLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationLeg")
		public CorrelationLeg getCorrelationLeg() {
			return correlationLeg;
		}
		
		@Override
		public CorrelationSwap build() {
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder toBuilder() {
			CorrelationSwap.CorrelationSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationSwap.CorrelationSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelationLeg()).ifPresent(builder::setCorrelationLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationSwap _that = getType().cast(o);
		
			if (!Objects.equals(correlationLeg, _that.getCorrelationLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationLeg != null ? correlationLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationSwap {" +
				"correlationLeg=" + this.correlationLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationSwap  ***********************/
	class CorrelationSwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl implements CorrelationSwap.CorrelationSwapBuilder {
	
		protected CorrelationLeg.CorrelationLegBuilder correlationLeg;
		
		@Override
		@RosettaAttribute("correlationLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationLeg")
		public CorrelationLeg.CorrelationLegBuilder getCorrelationLeg() {
			return correlationLeg;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder getOrCreateCorrelationLeg() {
			CorrelationLeg.CorrelationLegBuilder result;
			if (correlationLeg!=null) {
				result = correlationLeg;
			}
			else {
				result = correlationLeg = CorrelationLeg.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CorrelationSwap.CorrelationSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CorrelationSwap.CorrelationSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CorrelationSwap.CorrelationSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CorrelationSwap.CorrelationSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CorrelationSwap.CorrelationSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CorrelationSwap.CorrelationSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CorrelationSwap.CorrelationSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CorrelationSwap.CorrelationSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public CorrelationSwap.CorrelationSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public CorrelationSwap.CorrelationSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("correlationLeg")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder setCorrelationLeg(CorrelationLeg _correlationLeg) {
			this.correlationLeg = _correlationLeg == null ? null : _correlationLeg.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationSwap build() {
			return new CorrelationSwap.CorrelationSwapImpl(this);
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder prune() {
			super.prune();
			if (correlationLeg!=null && !correlationLeg.prune().hasData()) correlationLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelationLeg()!=null && getCorrelationLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CorrelationSwap.CorrelationSwapBuilder o = (CorrelationSwap.CorrelationSwapBuilder) other;
			
			merger.mergeRosetta(getCorrelationLeg(), o.getCorrelationLeg(), this::setCorrelationLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationSwap _that = getType().cast(o);
		
			if (!Objects.equals(correlationLeg, _that.getCorrelationLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationLeg != null ? correlationLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationSwapBuilder {" +
				"correlationLeg=" + this.correlationLeg +
			'}' + " " + super.toString();
		}
	}
}
