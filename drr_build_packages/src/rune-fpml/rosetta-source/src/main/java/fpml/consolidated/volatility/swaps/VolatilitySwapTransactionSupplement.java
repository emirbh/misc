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
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.volatility.swaps.meta.VolatilitySwapTransactionSupplementMeta;
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
@RosettaDataType(value="VolatilitySwapTransactionSupplement", builder=VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilitySwapTransactionSupplement", model="fpml", builder=VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl.class, version="2.1.1")
public interface VolatilitySwapTransactionSupplement extends Product {

	VolatilitySwapTransactionSupplementMeta metaData = new VolatilitySwapTransactionSupplementMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 */
	Boolean getMultipleExchangeIndexAnnexFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 */
	Boolean getComponentSecurityIndexAnnexFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 */
	CountryCode getLocalJurisdiction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Relevent Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties and similar charges that would be imposed by the taxing authority of the Country of Underlyer on a Hypothetical Broker Dealer assuming the Applicable Hedge Positions are held by its office in the Relevant Jurisdiction. If this element is not present Relevant Jurisdiction is Not Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Relevent Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties and similar charges that would be imposed by the taxing authority of the Country of Underlyer on a Hypothetical Broker Dealer assuming the Applicable Hedge Positions are held by its office in the Relevant Jurisdiction. If this element is not present Relevant Jurisdiction is Not Applicable.
	 *
	 */
	CountryCode getRelevantJurisdiction();

	/*********************** Build Methods  ***********************/
	VolatilitySwapTransactionSupplement build();
	
	VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder();
	
	static VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder() {
		return new VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilitySwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilitySwapTransactionSupplement> getType() {
		return VolatilitySwapTransactionSupplement.class;
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
		processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.class, getVolatilityLeg());
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.class, getRelevantJurisdiction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilitySwapTransactionSupplementBuilder extends VolatilitySwapTransactionSupplement, Product.ProductBuilder {
		VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int index);
		@Override
		List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg();
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getRelevantJurisdiction();
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setId(String id);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(ProductType productType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(ProductType productType, int idx);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(ProductId productId);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(ProductId productId, int idx);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg volatilityLeg, int idx);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode relevantJurisdiction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.VolatilityLegBuilder.class, getVolatilityLeg());
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getRelevantJurisdiction());
		}
		

		VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilitySwapTransactionSupplement  ***********************/
	class VolatilitySwapTransactionSupplementImpl extends Product.ProductImpl implements VolatilitySwapTransactionSupplement {
		private final List<? extends VolatilityLeg> volatilityLeg;
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		private final CountryCode localJurisdiction;
		private final CountryCode relevantJurisdiction;
		
		protected VolatilitySwapTransactionSupplementImpl(VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder) {
			super(builder);
			this.volatilityLeg = ofNullable(builder.getVolatilityLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.relevantJurisdiction = ofNullable(builder.getRelevantJurisdiction()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantJurisdiction")
		public CountryCode getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder() {
			VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatilityLeg()).ifPresent(builder::setVolatilityLeg);
			ofNullable(getMultipleExchangeIndexAnnexFallback()).ifPresent(builder::setMultipleExchangeIndexAnnexFallback);
			ofNullable(getComponentSecurityIndexAnnexFallback()).ifPresent(builder::setComponentSecurityIndexAnnexFallback);
			ofNullable(getLocalJurisdiction()).ifPresent(builder::setLocalJurisdiction);
			ofNullable(getRelevantJurisdiction()).ifPresent(builder::setRelevantJurisdiction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapTransactionSupplement {" +
				"volatilityLeg=" + this.volatilityLeg + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilitySwapTransactionSupplement  ***********************/
	class VolatilitySwapTransactionSupplementBuilderImpl extends Product.ProductBuilderImpl implements VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder {
	
		protected List<VolatilityLeg.VolatilityLegBuilder> volatilityLeg = new ArrayList<>();
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected CountryCode.CountryCodeBuilder relevantJurisdiction;
		
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
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode.CountryCodeBuilder getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (localJurisdiction!=null) {
				result = localJurisdiction;
			}
			else {
				result = localJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantJurisdiction")
		public CountryCode.CountryCodeBuilder getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (relevantJurisdiction!=null) {
				result = relevantJurisdiction;
			}
			else {
				result = relevantJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productIds) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productIds) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("volatilityLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("volatilityLeg")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg _volatilityLeg) {
			if (_volatilityLeg != null) {
				this.volatilityLeg.add(_volatilityLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(VolatilityLeg _volatilityLeg, int idx) {
			getIndex(this.volatilityLeg, idx, () -> _volatilityLeg.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
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
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs == null) {
				this.volatilityLeg = new ArrayList<>();
			} else {
				this.volatilityLeg = volatilityLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean _multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = _multipleExchangeIndexAnnexFallback == null ? null : _multipleExchangeIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean _componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = _componentSecurityIndexAnnexFallback == null ? null : _componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localJurisdiction")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode _localJurisdiction) {
			this.localJurisdiction = _localJurisdiction == null ? null : _localJurisdiction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantJurisdiction")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode _relevantJurisdiction) {
			this.relevantJurisdiction = _relevantJurisdiction == null ? null : _relevantJurisdiction.toBuilder();
			return this;
		}
		
		@Override
		public VolatilitySwapTransactionSupplement build() {
			return new VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementImpl(this);
		}
		
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder prune() {
			super.prune();
			volatilityLeg = volatilityLeg.stream().filter(b->b!=null).<VolatilityLeg.VolatilityLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (relevantJurisdiction!=null && !relevantJurisdiction.prune().hasData()) relevantJurisdiction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatilityLeg()!=null && getVolatilityLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getRelevantJurisdiction()!=null && getRelevantJurisdiction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder o = (VolatilitySwapTransactionSupplement.VolatilitySwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getVolatilityLeg(), o.getVolatilityLeg(), this::getOrCreateVolatilityLeg);
			merger.mergeRosetta(getLocalJurisdiction(), o.getLocalJurisdiction(), this::setLocalJurisdiction);
			merger.mergeRosetta(getRelevantJurisdiction(), o.getRelevantJurisdiction(), this::setRelevantJurisdiction);
			
			merger.mergeBasic(getMultipleExchangeIndexAnnexFallback(), o.getMultipleExchangeIndexAnnexFallback(), this::setMultipleExchangeIndexAnnexFallback);
			merger.mergeBasic(getComponentSecurityIndexAnnexFallback(), o.getComponentSecurityIndexAnnexFallback(), this::setComponentSecurityIndexAnnexFallback);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapTransactionSupplementBuilder {" +
				"volatilityLeg=" + this.volatilityLeg + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}' + " " + super.toString();
		}
	}
}
