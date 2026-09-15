package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.ReturnSwapMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A type describing return swaps including return swaps (long form), total return swaps, and variance swaps.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing return swaps including return swaps (long form), total return swaps, and variance swaps.
 *
 */
@RosettaDataType(value="ReturnSwap", builder=ReturnSwap.ReturnSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwap", model="fpml", builder=ReturnSwap.ReturnSwapBuilderImpl.class, version="2.1.1")
public interface ReturnSwap extends ReturnSwapBase {

	ReturnSwapMeta metaData = new ReturnSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, for one or for both the parties to the trade, the date from which it can early terminate it.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, for one or for both the parties to the trade, the date from which it can early terminate it.
	 *
	 */
	List<? extends ReturnSwapEarlyTermination> getEarlyTermination();
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
	ReturnSwap build();
	
	ReturnSwap.ReturnSwapBuilder toBuilder();
	
	static ReturnSwap.ReturnSwapBuilder builder() {
		return new ReturnSwap.ReturnSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwap> getType() {
		return ReturnSwap.class;
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
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.class, getReturnSwapLeg());
		processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.class, getPrincipalExchangeFeatures());
		processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("earlyTermination"), processor, ReturnSwapEarlyTermination.class, getEarlyTermination());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapBuilder extends ReturnSwap, ReturnSwapBase.ReturnSwapBaseBuilder {
		ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int index);
		@Override
		List<? extends ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> getEarlyTermination();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		@Override
		ReturnSwap.ReturnSwapBuilder setId(String id);
		@Override
		ReturnSwap.ReturnSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductType(ProductType productType);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		ReturnSwap.ReturnSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductId(ProductId productId);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		ReturnSwap.ReturnSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		ReturnSwap.ReturnSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		ReturnSwap.ReturnSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		ReturnSwap.ReturnSwapBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		ReturnSwap.ReturnSwapBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		ReturnSwap.ReturnSwapBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		ReturnSwap.ReturnSwapBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg);
		@Override
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		@Override
		ReturnSwap.ReturnSwapBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		@Override
		ReturnSwap.ReturnSwapBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		@Override
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment);
		@Override
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int idx);
		@Override
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);
		@Override
		ReturnSwap.ReturnSwapBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination, int idx);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTermination);
		ReturnSwap.ReturnSwapBuilder setEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTermination);
		ReturnSwap.ReturnSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.DirectionalLegBuilder.class, getReturnSwapLeg());
			processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder.class, getPrincipalExchangeFeatures());
			processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("earlyTermination"), processor, ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder.class, getEarlyTermination());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		ReturnSwap.ReturnSwapBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwap  ***********************/
	class ReturnSwapImpl extends ReturnSwapBase.ReturnSwapBaseImpl implements ReturnSwap {
		private final List<? extends ReturnSwapEarlyTermination> earlyTermination;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected ReturnSwapImpl(ReturnSwap.ReturnSwapBuilder builder) {
			super(builder);
			this.earlyTermination = ofNullable(builder.getEarlyTermination()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		public List<? extends ReturnSwapEarlyTermination> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ReturnSwap build() {
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder toBuilder() {
			ReturnSwap.ReturnSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwap.ReturnSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEarlyTermination()).ifPresent(builder::setEarlyTermination);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwap {" +
				"earlyTermination=" + this.earlyTermination + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwap  ***********************/
	class ReturnSwapBuilderImpl extends ReturnSwapBase.ReturnSwapBaseBuilderImpl implements ReturnSwap.ReturnSwapBuilder {
	
		protected List<ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> earlyTermination = new ArrayList<>();
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		
		@Override
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		public List<? extends ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int index) {
			if (earlyTermination==null) {
				this.earlyTermination = new ArrayList<>();
			}
			return getIndex(earlyTermination, index, () -> {
						ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder newEarlyTermination = ReturnSwapEarlyTermination.builder();
						return newEarlyTermination;
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
		public ReturnSwap.ReturnSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public ReturnSwap.ReturnSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReturnSwap.ReturnSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReturnSwap.ReturnSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public ReturnSwap.ReturnSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public ReturnSwap.ReturnSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public ReturnSwap.ReturnSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public ReturnSwap.ReturnSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public ReturnSwap.ReturnSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public ReturnSwap.ReturnSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public ReturnSwap.ReturnSwapBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public ReturnSwap.ReturnSwapBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public ReturnSwap.ReturnSwapBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public ReturnSwap.ReturnSwapBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		@Override
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg) {
			if (_returnSwapLeg != null) {
				this.returnSwapLeg.add(_returnSwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg, int idx) {
			getIndex(this.returnSwapLeg, idx, () -> _returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs != null) {
				for (final DirectionalLeg toAdd : returnSwapLegs) {
					this.returnSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		@Override
		public ReturnSwap.ReturnSwapBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs == null) {
				this.returnSwapLeg = new ArrayList<>();
			} else {
				this.returnSwapLeg = returnSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("principalExchangeFeatures")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchangeFeatures")
		@Override
		public ReturnSwap.ReturnSwapBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures _principalExchangeFeatures) {
			this.principalExchangeFeatures = _principalExchangeFeatures == null ? null : _principalExchangeFeatures.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments != null) {
				for (final ReturnSwapAdditionalPayment toAdd : additionalPayments) {
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
		public ReturnSwap.ReturnSwapBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("earlyTermination")
		@Override
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination _earlyTermination) {
			if (_earlyTermination != null) {
				this.earlyTermination.add(_earlyTermination.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination _earlyTermination, int idx) {
			getIndex(this.earlyTermination, idx, () -> _earlyTermination.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations != null) {
				for (final ReturnSwapEarlyTermination toAdd : earlyTerminations) {
					this.earlyTermination.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("earlyTermination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("earlyTermination")
		@Override
		public ReturnSwap.ReturnSwapBuilder setEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations == null) {
				this.earlyTermination = new ArrayList<>();
			} else {
				this.earlyTermination = earlyTerminations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public ReturnSwap.ReturnSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwap build() {
			return new ReturnSwap.ReturnSwapImpl(this);
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwap.ReturnSwapBuilder prune() {
			super.prune();
			earlyTermination = earlyTermination.stream().filter(b->b!=null).<ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEarlyTermination()!=null && getEarlyTermination().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwap.ReturnSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnSwap.ReturnSwapBuilder o = (ReturnSwap.ReturnSwapBuilder) other;
			
			merger.mergeRosetta(getEarlyTermination(), o.getEarlyTermination(), this::getOrCreateEarlyTermination);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBuilder {" +
				"earlyTermination=" + this.earlyTermination + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
