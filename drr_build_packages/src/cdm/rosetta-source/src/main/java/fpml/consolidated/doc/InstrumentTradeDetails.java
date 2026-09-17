package fpml.consolidated.doc;

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
import fpml.consolidated.asset.Asset;
import fpml.consolidated.doc.meta.InstrumentTradeDetailsMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
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
 * Provision The economics of a trade of a multiply traded instrument.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The economics of a trade of a multiply traded instrument.
 *
 */
@RosettaDataType(value="InstrumentTradeDetails", builder=InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InstrumentTradeDetails", model="fpml", builder=InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl.class, version="2.1.1")
public interface InstrumentTradeDetails extends Product {

	InstrumentTradeDetailsMeta metaData = new InstrumentTradeDetailsMeta();

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
	 * Provision The FpML asset description for the asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The FpML asset description for the asset.
	 *
	 */
	Asset getUnderlyingAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A description of how much of the instrument was traded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description of how much of the instrument was traded.
	 *
	 */
	InstrumentTradeQuantity getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price paid for the instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price paid for the instrument.
	 *
	 */
	InstrumentTradePricing getPricing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value, in instrument currency, of the amount of the instrument that was traded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value, in instrument currency, of the amount of the instrument that was traded.
	 *
	 */
	InstrumentTradePrincipal getPrincipal();

	/*********************** Build Methods  ***********************/
	InstrumentTradeDetails build();
	
	InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder();
	
	static InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder() {
		return new InstrumentTradeDetails.InstrumentTradeDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradeDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentTradeDetails> getType() {
		return InstrumentTradeDetails.class;
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
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("quantity"), processor, InstrumentTradeQuantity.class, getQuantity());
		processRosetta(path.newSubPath("pricing"), processor, InstrumentTradePricing.class, getPricing());
		processRosetta(path.newSubPath("principal"), processor, InstrumentTradePrincipal.class, getPrincipal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradeDetailsBuilder extends InstrumentTradeDetails, Product.ProductBuilder {
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
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		@Override
		Asset.AssetBuilder getUnderlyingAsset();
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getOrCreateQuantity();
		@Override
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getQuantity();
		InstrumentTradePricing.InstrumentTradePricingBuilder getOrCreatePricing();
		@Override
		InstrumentTradePricing.InstrumentTradePricingBuilder getPricing();
		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getOrCreatePrincipal();
		@Override
		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getPrincipal();
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setId(String id);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(ProductType productType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(ProductType productType, int idx);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(List<? extends ProductType> productType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductType(List<? extends ProductType> productType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(ProductId productId);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(ProductId productId, int idx);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(List<? extends ProductId> productId);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductId(List<? extends ProductId> productId);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(AssetClass assetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setAssetClass(List<? extends AssetClass> assetClass);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setUnderlyingAsset(Asset underlyingAsset);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setQuantity(InstrumentTradeQuantity quantity);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPricing(InstrumentTradePricing pricing);
		InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrincipal(InstrumentTradePrincipal principal);

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
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("quantity"), processor, InstrumentTradeQuantity.InstrumentTradeQuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("pricing"), processor, InstrumentTradePricing.InstrumentTradePricingBuilder.class, getPricing());
			processRosetta(path.newSubPath("principal"), processor, InstrumentTradePrincipal.InstrumentTradePrincipalBuilder.class, getPrincipal());
		}
		

		InstrumentTradeDetails.InstrumentTradeDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradeDetails  ***********************/
	class InstrumentTradeDetailsImpl extends Product.ProductImpl implements InstrumentTradeDetails {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final Asset underlyingAsset;
		private final InstrumentTradeQuantity quantity;
		private final InstrumentTradePricing pricing;
		private final InstrumentTradePrincipal principal;
		
		protected InstrumentTradeDetailsImpl(InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.pricing = ofNullable(builder.getPricing()).map(f->f.build()).orElse(null);
			this.principal = ofNullable(builder.getPrincipal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
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
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public InstrumentTradeQuantity getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("pricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricing")
		public InstrumentTradePricing getPricing() {
			return pricing;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principal")
		public InstrumentTradePrincipal getPrincipal() {
			return principal;
		}
		
		@Override
		public InstrumentTradeDetails build() {
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder() {
			InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradeDetails.InstrumentTradeDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getPricing()).ifPresent(builder::setPricing);
			ofNullable(getPrincipal()).ifPresent(builder::setPrincipal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentTradeDetails _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(pricing, _that.getPricing())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (pricing != null ? pricing.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeDetails {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quantity=" + this.quantity + ", " +
				"pricing=" + this.pricing + ", " +
				"principal=" + this.principal +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InstrumentTradeDetails  ***********************/
	class InstrumentTradeDetailsBuilderImpl extends Product.ProductBuilderImpl implements InstrumentTradeDetails.InstrumentTradeDetailsBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected Asset.AssetBuilder underlyingAsset;
		protected InstrumentTradeQuantity.InstrumentTradeQuantityBuilder quantity;
		protected InstrumentTradePricing.InstrumentTradePricingBuilder pricing;
		protected InstrumentTradePrincipal.InstrumentTradePrincipalBuilder principal;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
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
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder getOrCreateQuantity() {
			InstrumentTradeQuantity.InstrumentTradeQuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = InstrumentTradeQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricing")
		public InstrumentTradePricing.InstrumentTradePricingBuilder getPricing() {
			return pricing;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder getOrCreatePricing() {
			InstrumentTradePricing.InstrumentTradePricingBuilder result;
			if (pricing!=null) {
				result = pricing;
			}
			else {
				result = pricing = InstrumentTradePricing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principal")
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getPrincipal() {
			return principal;
		}
		
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder getOrCreatePrincipal() {
			InstrumentTradePrincipal.InstrumentTradePrincipalBuilder result;
			if (principal!=null) {
				result = principal;
			}
			else {
				result = principal = InstrumentTradePrincipal.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addProductId(List<? extends ProductId> productIds) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setProductId(List<? extends ProductId> productIds) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAsset")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setUnderlyingAsset(Asset _underlyingAsset) {
			this.underlyingAsset = _underlyingAsset == null ? null : _underlyingAsset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setQuantity(InstrumentTradeQuantity _quantity) {
			this.quantity = _quantity == null ? null : _quantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricing")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPricing(InstrumentTradePricing _pricing) {
			this.pricing = _pricing == null ? null : _pricing.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principal")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder setPrincipal(InstrumentTradePrincipal _principal) {
			this.principal = _principal == null ? null : _principal.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentTradeDetails build() {
			return new InstrumentTradeDetails.InstrumentTradeDetailsImpl(this);
		}
		
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (pricing!=null && !pricing.prune().hasData()) pricing = null;
			if (principal!=null && !principal.prune().hasData()) principal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getPricing()!=null && getPricing().hasData()) return true;
			if (getPrincipal()!=null && getPrincipal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeDetails.InstrumentTradeDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InstrumentTradeDetails.InstrumentTradeDetailsBuilder o = (InstrumentTradeDetails.InstrumentTradeDetailsBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getPricing(), o.getPricing(), this::setPricing);
			merger.mergeRosetta(getPrincipal(), o.getPrincipal(), this::setPrincipal);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentTradeDetails _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(pricing, _that.getPricing())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (pricing != null ? pricing.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeDetailsBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quantity=" + this.quantity + ", " +
				"pricing=" + this.pricing + ", " +
				"principal=" + this.principal +
			'}' + " " + super.toString();
		}
	}
}
