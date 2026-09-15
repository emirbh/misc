package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CreditDefaultSwapMeta;
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
 * Provision In a credit default swap one party (the protection seller) agrees to compensate another party (the protection buyer) if a specified company or Sovereign (the reference entity) experiences a credit event, indicating it is or may be unable to service its debts. The protection seller is typically paid a fee and/or premium, expressed as an annualized percent of the notional in basis points, regularly over the life of the transaction or otherwise as agreed by the parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision In a credit default swap one party (the protection seller) agrees to compensate another party (the protection buyer) if a specified company or Sovereign (the reference entity) experiences a credit event, indicating it is or may be unable to service its debts. The protection seller is typically paid a fee and/or premium, expressed as an annualized percent of the notional in basis points, regularly over the life of the transaction or otherwise as agreed by the parties.
 *
 */
@RosettaDataType(value="CreditDefaultSwap", builder=CreditDefaultSwap.CreditDefaultSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditDefaultSwap", model="fpml", builder=CreditDefaultSwap.CreditDefaultSwapBuilderImpl.class, version="2.1.1")
public interface CreditDefaultSwap extends Product {

	CreditDefaultSwapMeta metaData = new CreditDefaultSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the data that appears in the section entitled "1. General Terms" in the 2003 ISDA Credit Derivatives Confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the data that appears in the section entitled "1. General Terms" in the 2003 ISDA Credit Derivatives Confirmation.
	 *
	 */
	GeneralTerms getGeneralTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the fixed amounts/payments per the applicable ISDA definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the fixed amounts/payments per the applicable ISDA definitions.
	 *
	 */
	FeeLeg getFeeLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the applicable floating rate payer calculation amount, credit events and associated conditions to settlement, and reference obligations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the applicable floating rate payer calculation amount, credit events and associated conditions to settlement, and reference obligations.
	 *
	 */
	List<? extends ProtectionTerms> getProtectionTerms();
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
	List<? extends CreditDefaultSwapChoice> getCreditDefaultSwapChoice();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwap build();
	
	CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder();
	
	static CreditDefaultSwap.CreditDefaultSwapBuilder builder() {
		return new CreditDefaultSwap.CreditDefaultSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDefaultSwap> getType() {
		return CreditDefaultSwap.class;
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
		processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.class, getGeneralTerms());
		processRosetta(path.newSubPath("feeLeg"), processor, FeeLeg.class, getFeeLeg());
		processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.class, getProtectionTerms());
		processRosetta(path.newSubPath("creditDefaultSwapChoice"), processor, CreditDefaultSwapChoice.class, getCreditDefaultSwapChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapBuilder extends CreditDefaultSwap, Product.ProductBuilder {
		GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms();
		@Override
		GeneralTerms.GeneralTermsBuilder getGeneralTerms();
		FeeLeg.FeeLegBuilder getOrCreateFeeLeg();
		@Override
		FeeLeg.FeeLegBuilder getFeeLeg();
		ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int index);
		@Override
		List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms();
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder getOrCreateCreditDefaultSwapChoice(int index);
		@Override
		List<? extends CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> getCreditDefaultSwapChoice();
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setId(String id);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(ProductType productType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(ProductId productId);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CreditDefaultSwap.CreditDefaultSwapBuilder setGeneralTerms(GeneralTerms generalTerms);
		CreditDefaultSwap.CreditDefaultSwapBuilder setFeeLeg(FeeLeg feeLeg);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms protectionTerms, int idx);
		CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultSwap.CreditDefaultSwapBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice creditDefaultSwapChoice, int idx);
		CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice);
		CreditDefaultSwap.CreditDefaultSwapBuilder setCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.GeneralTermsBuilder.class, getGeneralTerms());
			processRosetta(path.newSubPath("feeLeg"), processor, FeeLeg.FeeLegBuilder.class, getFeeLeg());
			processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.ProtectionTermsBuilder.class, getProtectionTerms());
			processRosetta(path.newSubPath("creditDefaultSwapChoice"), processor, CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder.class, getCreditDefaultSwapChoice());
		}
		

		CreditDefaultSwap.CreditDefaultSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwap  ***********************/
	class CreditDefaultSwapImpl extends Product.ProductImpl implements CreditDefaultSwap {
		private final GeneralTerms generalTerms;
		private final FeeLeg feeLeg;
		private final List<? extends ProtectionTerms> protectionTerms;
		private final List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoice;
		
		protected CreditDefaultSwapImpl(CreditDefaultSwap.CreditDefaultSwapBuilder builder) {
			super(builder);
			this.generalTerms = ofNullable(builder.getGeneralTerms()).map(f->f.build()).orElse(null);
			this.feeLeg = ofNullable(builder.getFeeLeg()).map(f->f.build()).orElse(null);
			this.protectionTerms = ofNullable(builder.getProtectionTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDefaultSwapChoice = ofNullable(builder.getCreditDefaultSwapChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("generalTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalTerms")
		public GeneralTerms getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		@RosettaAttribute("feeLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("feeLeg")
		public FeeLeg getFeeLeg() {
			return feeLeg;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("protectionTerms")
		public List<? extends ProtectionTerms> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwapChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditDefaultSwapChoice")
		public List<? extends CreditDefaultSwapChoice> getCreditDefaultSwapChoice() {
			return creditDefaultSwapChoice;
		}
		
		@Override
		public CreditDefaultSwap build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder() {
			CreditDefaultSwap.CreditDefaultSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwap.CreditDefaultSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGeneralTerms()).ifPresent(builder::setGeneralTerms);
			ofNullable(getFeeLeg()).ifPresent(builder::setFeeLeg);
			ofNullable(getProtectionTerms()).ifPresent(builder::setProtectionTerms);
			ofNullable(getCreditDefaultSwapChoice()).ifPresent(builder::setCreditDefaultSwapChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(feeLeg, _that.getFeeLeg())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!ListEquals.listEquals(creditDefaultSwapChoice, _that.getCreditDefaultSwapChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (feeLeg != null ? feeLeg.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwapChoice != null ? creditDefaultSwapChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwap {" +
				"generalTerms=" + this.generalTerms + ", " +
				"feeLeg=" + this.feeLeg + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"creditDefaultSwapChoice=" + this.creditDefaultSwapChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwap  ***********************/
	class CreditDefaultSwapBuilderImpl extends Product.ProductBuilderImpl implements CreditDefaultSwap.CreditDefaultSwapBuilder {
	
		protected GeneralTerms.GeneralTermsBuilder generalTerms;
		protected FeeLeg.FeeLegBuilder feeLeg;
		protected List<ProtectionTerms.ProtectionTermsBuilder> protectionTerms = new ArrayList<>();
		protected List<CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> creditDefaultSwapChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("generalTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalTerms")
		public GeneralTerms.GeneralTermsBuilder getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms() {
			GeneralTerms.GeneralTermsBuilder result;
			if (generalTerms!=null) {
				result = generalTerms;
			}
			else {
				result = generalTerms = GeneralTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("feeLeg")
		public FeeLeg.FeeLegBuilder getFeeLeg() {
			return feeLeg;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder getOrCreateFeeLeg() {
			FeeLeg.FeeLegBuilder result;
			if (feeLeg!=null) {
				result = feeLeg;
			}
			else {
				result = feeLeg = FeeLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("protectionTerms")
		public List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int index) {
			if (protectionTerms==null) {
				this.protectionTerms = new ArrayList<>();
			}
			return getIndex(protectionTerms, index, () -> {
						ProtectionTerms.ProtectionTermsBuilder newProtectionTerms = ProtectionTerms.builder();
						return newProtectionTerms;
					});
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwapChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditDefaultSwapChoice")
		public List<? extends CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder> getCreditDefaultSwapChoice() {
			return creditDefaultSwapChoice;
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder getOrCreateCreditDefaultSwapChoice(int index) {
			if (creditDefaultSwapChoice==null) {
				this.creditDefaultSwapChoice = new ArrayList<>();
			}
			return getIndex(creditDefaultSwapChoice, index, () -> {
						CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder newCreditDefaultSwapChoice = CreditDefaultSwapChoice.builder();
						return newCreditDefaultSwapChoice;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditDefaultSwap.CreditDefaultSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("generalTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("generalTerms")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setGeneralTerms(GeneralTerms _generalTerms) {
			this.generalTerms = _generalTerms == null ? null : _generalTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("feeLeg")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setFeeLeg(FeeLeg _feeLeg) {
			this.feeLeg = _feeLeg == null ? null : _feeLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("protectionTerms")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("protectionTerms")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms _protectionTerms) {
			if (_protectionTerms != null) {
				this.protectionTerms.add(_protectionTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(ProtectionTerms _protectionTerms, int idx) {
			getIndex(this.protectionTerms, idx, () -> _protectionTerms.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss != null) {
				for (final ProtectionTerms toAdd : protectionTermss) {
					this.protectionTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("protectionTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("protectionTerms")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss == null) {
				this.protectionTerms = new ArrayList<>();
			} else {
				this.protectionTerms = protectionTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditDefaultSwapChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditDefaultSwapChoice")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice _creditDefaultSwapChoice) {
			if (_creditDefaultSwapChoice != null) {
				this.creditDefaultSwapChoice.add(_creditDefaultSwapChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(CreditDefaultSwapChoice _creditDefaultSwapChoice, int idx) {
			getIndex(this.creditDefaultSwapChoice, idx, () -> _creditDefaultSwapChoice.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder addCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoices) {
			if (creditDefaultSwapChoices != null) {
				for (final CreditDefaultSwapChoice toAdd : creditDefaultSwapChoices) {
					this.creditDefaultSwapChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditDefaultSwapChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditDefaultSwapChoice")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder setCreditDefaultSwapChoice(List<? extends CreditDefaultSwapChoice> creditDefaultSwapChoices) {
			if (creditDefaultSwapChoices == null) {
				this.creditDefaultSwapChoice = new ArrayList<>();
			} else {
				this.creditDefaultSwapChoice = creditDefaultSwapChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwap build() {
			return new CreditDefaultSwap.CreditDefaultSwapImpl(this);
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder prune() {
			super.prune();
			if (generalTerms!=null && !generalTerms.prune().hasData()) generalTerms = null;
			if (feeLeg!=null && !feeLeg.prune().hasData()) feeLeg = null;
			protectionTerms = protectionTerms.stream().filter(b->b!=null).<ProtectionTerms.ProtectionTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditDefaultSwapChoice = creditDefaultSwapChoice.stream().filter(b->b!=null).<CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGeneralTerms()!=null && getGeneralTerms().hasData()) return true;
			if (getFeeLeg()!=null && getFeeLeg().hasData()) return true;
			if (getProtectionTerms()!=null && getProtectionTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDefaultSwapChoice()!=null && getCreditDefaultSwapChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditDefaultSwap.CreditDefaultSwapBuilder o = (CreditDefaultSwap.CreditDefaultSwapBuilder) other;
			
			merger.mergeRosetta(getGeneralTerms(), o.getGeneralTerms(), this::setGeneralTerms);
			merger.mergeRosetta(getFeeLeg(), o.getFeeLeg(), this::setFeeLeg);
			merger.mergeRosetta(getProtectionTerms(), o.getProtectionTerms(), this::getOrCreateProtectionTerms);
			merger.mergeRosetta(getCreditDefaultSwapChoice(), o.getCreditDefaultSwapChoice(), this::getOrCreateCreditDefaultSwapChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(feeLeg, _that.getFeeLeg())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!ListEquals.listEquals(creditDefaultSwapChoice, _that.getCreditDefaultSwapChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (feeLeg != null ? feeLeg.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwapChoice != null ? creditDefaultSwapChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapBuilder {" +
				"generalTerms=" + this.generalTerms + ", " +
				"feeLeg=" + this.feeLeg + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"creditDefaultSwapChoice=" + this.creditDefaultSwapChoice +
			'}' + " " + super.toString();
		}
	}
}
