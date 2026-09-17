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
import fpml.consolidated.eq.shared.meta.ReturnSwapBaseMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A type describing the components that are common for return type swaps, including short and long form return swaps representations.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the components that are common for return type swaps, including short and long form return swaps representations.
 *
 */
@RosettaDataType(value="ReturnSwapBase", builder=ReturnSwapBase.ReturnSwapBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapBase", model="fpml", builder=ReturnSwapBase.ReturnSwapBaseBuilderImpl.class, version="2.1.1")
public interface ReturnSwapBase extends Product {

	ReturnSwapBaseMeta metaData = new ReturnSwapBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
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
	List<? extends DirectionalLeg> getReturnSwapLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is used to document a Fully Funded Return Swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is used to document a Fully Funded Return Swap.
	 *
	 */
	PrincipalExchangeFeatures getPrincipalExchangeFeatures();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies additional payment(s) between the principal parties to the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies additional payment(s) between the principal parties to the trade.
	 *
	 */
	List<? extends ReturnSwapAdditionalPayment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	ReturnSwapBase build();
	
	ReturnSwapBase.ReturnSwapBaseBuilder toBuilder();
	
	static ReturnSwapBase.ReturnSwapBaseBuilder builder() {
		return new ReturnSwapBase.ReturnSwapBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapBase> getType() {
		return ReturnSwapBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapBaseBuilder extends ReturnSwapBase, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		DirectionalLeg.DirectionalLegBuilder getOrCreateReturnSwapLeg(int index);
		@Override
		List<? extends DirectionalLeg.DirectionalLegBuilder> getReturnSwapLeg();
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getOrCreatePrincipalExchangeFeatures();
		@Override
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getPrincipalExchangeFeatures();
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> getAdditionalPayment();
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setId(String id);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductType(ProductType productType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductType(ProductType productType, int idx);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductType(List<? extends ProductType> productType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setProductType(List<? extends ProductType> productType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductId(ProductId productId);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductId(ProductId productId, int idx);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addProductId(List<? extends ProductId> productId);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setProductId(List<? extends ProductId> productId);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(AssetClass assetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		ReturnSwapBase.ReturnSwapBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		ReturnSwapBase.ReturnSwapBaseBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		ReturnSwapBase.ReturnSwapBaseBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		ReturnSwapBase.ReturnSwapBaseBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		ReturnSwapBase.ReturnSwapBaseBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int idx);
		ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		ReturnSwapBase.ReturnSwapBaseBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		ReturnSwapBase.ReturnSwapBaseBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int idx);
		ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);
		ReturnSwapBase.ReturnSwapBaseBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);

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
		}
		

		ReturnSwapBase.ReturnSwapBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapBase  ***********************/
	class ReturnSwapBaseImpl extends Product.ProductImpl implements ReturnSwapBase {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final List<? extends DirectionalLeg> returnSwapLeg;
		private final PrincipalExchangeFeatures principalExchangeFeatures;
		private final List<? extends ReturnSwapAdditionalPayment> additionalPayment;
		
		protected ReturnSwapBaseImpl(ReturnSwapBase.ReturnSwapBaseBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.returnSwapLeg = ofNullable(builder.getReturnSwapLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.principalExchangeFeatures = ofNullable(builder.getPrincipalExchangeFeatures()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		public List<? extends DirectionalLeg> getReturnSwapLeg() {
			return returnSwapLeg;
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeFeatures")
		public PrincipalExchangeFeatures getPrincipalExchangeFeatures() {
			return principalExchangeFeatures;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends ReturnSwapAdditionalPayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public ReturnSwapBase build() {
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder toBuilder() {
			ReturnSwapBase.ReturnSwapBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapBase.ReturnSwapBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getReturnSwapLeg()).ifPresent(builder::setReturnSwapLeg);
			ofNullable(getPrincipalExchangeFeatures()).ifPresent(builder::setPrincipalExchangeFeatures);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(returnSwapLeg, _that.getReturnSwapLeg())) return false;
			if (!Objects.equals(principalExchangeFeatures, _that.getPrincipalExchangeFeatures())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (returnSwapLeg != null ? returnSwapLeg.hashCode() : 0);
			_result = 31 * _result + (principalExchangeFeatures != null ? principalExchangeFeatures.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBase {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"returnSwapLeg=" + this.returnSwapLeg + ", " +
				"principalExchangeFeatures=" + this.principalExchangeFeatures + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapBase  ***********************/
	class ReturnSwapBaseBuilderImpl extends Product.ProductBuilderImpl implements ReturnSwapBase.ReturnSwapBaseBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected List<DirectionalLeg.DirectionalLegBuilder> returnSwapLeg = new ArrayList<>();
		protected PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder principalExchangeFeatures;
		protected List<ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> additionalPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		public List<? extends DirectionalLeg.DirectionalLegBuilder> getReturnSwapLeg() {
			return returnSwapLeg;
		}
		
		@Override
		public DirectionalLeg.DirectionalLegBuilder getOrCreateReturnSwapLeg(int index) {
			if (returnSwapLeg==null) {
				this.returnSwapLeg = new ArrayList<>();
			}
			return getIndex(returnSwapLeg, index, () -> {
						DirectionalLeg.DirectionalLegBuilder newReturnSwapLeg = DirectionalLeg.builder();
						return newReturnSwapLeg;
					});
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeFeatures")
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getPrincipalExchangeFeatures() {
			return principalExchangeFeatures;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder getOrCreatePrincipalExchangeFeatures() {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder result;
			if (principalExchangeFeatures!=null) {
				result = principalExchangeFeatures;
			}
			else {
				result = principalExchangeFeatures = PrincipalExchangeFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder newAdditionalPayment = ReturnSwapAdditionalPayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setProductId(List<? extends ProductId> productIds) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg) {
			if (_returnSwapLeg != null) {
				this.returnSwapLeg.add(_returnSwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg, int idx) {
			getIndex(this.returnSwapLeg, idx, () -> _returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures _principalExchangeFeatures) {
			this.principalExchangeFeatures = _principalExchangeFeatures == null ? null : _principalExchangeFeatures.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
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
		public ReturnSwapBase.ReturnSwapBaseBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReturnSwapBase build() {
			return new ReturnSwapBase.ReturnSwapBaseImpl(this);
		}
		
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			returnSwapLeg = returnSwapLeg.stream().filter(b->b!=null).<DirectionalLeg.DirectionalLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (principalExchangeFeatures!=null && !principalExchangeFeatures.prune().hasData()) principalExchangeFeatures = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getReturnSwapLeg()!=null && getReturnSwapLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrincipalExchangeFeatures()!=null && getPrincipalExchangeFeatures().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapBase.ReturnSwapBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnSwapBase.ReturnSwapBaseBuilder o = (ReturnSwapBase.ReturnSwapBaseBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getReturnSwapLeg(), o.getReturnSwapLeg(), this::getOrCreateReturnSwapLeg);
			merger.mergeRosetta(getPrincipalExchangeFeatures(), o.getPrincipalExchangeFeatures(), this::setPrincipalExchangeFeatures);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(returnSwapLeg, _that.getReturnSwapLeg())) return false;
			if (!Objects.equals(principalExchangeFeatures, _that.getPrincipalExchangeFeatures())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (returnSwapLeg != null ? returnSwapLeg.hashCode() : 0);
			_result = 31 * _result + (principalExchangeFeatures != null ? principalExchangeFeatures.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBaseBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"returnSwapLeg=" + this.returnSwapLeg + ", " +
				"principalExchangeFeatures=" + this.principalExchangeFeatures + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
