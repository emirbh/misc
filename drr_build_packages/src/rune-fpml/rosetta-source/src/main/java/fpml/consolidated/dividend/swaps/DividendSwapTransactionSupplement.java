package fpml.consolidated.dividend.swaps;

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
import fpml.consolidated.dividend.swaps.meta.DividendSwapTransactionSupplementMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
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
 * Provision A Dividend Swap Transaction Supplement.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Dividend Swap Transaction Supplement.
 *
 */
@RosettaDataType(value="DividendSwapTransactionSupplement", builder=DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendSwapTransactionSupplement", model="fpml", builder=DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl.class, version="2.1.1")
public interface DividendSwapTransactionSupplement extends Product {

	DividendSwapTransactionSupplementMeta metaData = new DividendSwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend leg.
	 *
	 */
	DividendLeg getDividendLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed payment leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed payment leg.
	 *
	 */
	FixedPaymentLeg getFixedLeg();
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
	DividendSwapTransactionSupplement build();
	
	DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder();
	
	static DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder() {
		return new DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendSwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendSwapTransactionSupplement> getType() {
		return DividendSwapTransactionSupplement.class;
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
		processRosetta(path.newSubPath("dividendLeg"), processor, DividendLeg.class, getDividendLeg());
		processRosetta(path.newSubPath("fixedLeg"), processor, FixedPaymentLeg.class, getFixedLeg());
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.class, getRelevantJurisdiction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendSwapTransactionSupplementBuilder extends DividendSwapTransactionSupplement, Product.ProductBuilder {
		DividendLeg.DividendLegBuilder getOrCreateDividendLeg();
		@Override
		DividendLeg.DividendLegBuilder getDividendLeg();
		FixedPaymentLeg.FixedPaymentLegBuilder getOrCreateFixedLeg();
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder getFixedLeg();
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getRelevantJurisdiction();
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setId(String id);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(ProductType productType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(ProductType productType, int idx);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(ProductId productId);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(ProductId productId, int idx);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setDividendLeg(DividendLeg dividendLeg);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setFixedLeg(FixedPaymentLeg fixedLeg);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode relevantJurisdiction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("dividendLeg"), processor, DividendLeg.DividendLegBuilder.class, getDividendLeg());
			processRosetta(path.newSubPath("fixedLeg"), processor, FixedPaymentLeg.FixedPaymentLegBuilder.class, getFixedLeg());
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getRelevantJurisdiction());
		}
		

		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of DividendSwapTransactionSupplement  ***********************/
	class DividendSwapTransactionSupplementImpl extends Product.ProductImpl implements DividendSwapTransactionSupplement {
		private final DividendLeg dividendLeg;
		private final FixedPaymentLeg fixedLeg;
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		private final CountryCode localJurisdiction;
		private final CountryCode relevantJurisdiction;
		
		protected DividendSwapTransactionSupplementImpl(DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder) {
			super(builder);
			this.dividendLeg = ofNullable(builder.getDividendLeg()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.relevantJurisdiction = ofNullable(builder.getRelevantJurisdiction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendLeg")
		public DividendLeg getDividendLeg() {
			return dividendLeg;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedLeg")
		public FixedPaymentLeg getFixedLeg() {
			return fixedLeg;
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
		public DividendSwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder() {
			DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividendLeg()).ifPresent(builder::setDividendLeg);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
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
		
			DividendSwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(dividendLeg, _that.getDividendLeg())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendLeg != null ? dividendLeg.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapTransactionSupplement {" +
				"dividendLeg=" + this.dividendLeg + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendSwapTransactionSupplement  ***********************/
	class DividendSwapTransactionSupplementBuilderImpl extends Product.ProductBuilderImpl implements DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder {
	
		protected DividendLeg.DividendLegBuilder dividendLeg;
		protected FixedPaymentLeg.FixedPaymentLegBuilder fixedLeg;
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected CountryCode.CountryCodeBuilder relevantJurisdiction;
		
		@Override
		@RosettaAttribute("dividendLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendLeg")
		public DividendLeg.DividendLegBuilder getDividendLeg() {
			return dividendLeg;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder getOrCreateDividendLeg() {
			DividendLeg.DividendLegBuilder result;
			if (dividendLeg!=null) {
				result = dividendLeg;
			}
			else {
				result = dividendLeg = DividendLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedLeg")
		public FixedPaymentLeg.FixedPaymentLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder getOrCreateFixedLeg() {
			FixedPaymentLeg.FixedPaymentLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = FixedPaymentLeg.builder();
			}
			
			return result;
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productIds) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productIds) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dividendLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendLeg")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setDividendLeg(DividendLeg _dividendLeg) {
			this.dividendLeg = _dividendLeg == null ? null : _dividendLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedLeg")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setFixedLeg(FixedPaymentLeg _fixedLeg) {
			this.fixedLeg = _fixedLeg == null ? null : _fixedLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean _multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = _multipleExchangeIndexAnnexFallback == null ? null : _multipleExchangeIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean _componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = _componentSecurityIndexAnnexFallback == null ? null : _componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localJurisdiction")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode _localJurisdiction) {
			this.localJurisdiction = _localJurisdiction == null ? null : _localJurisdiction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantJurisdiction")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode _relevantJurisdiction) {
			this.relevantJurisdiction = _relevantJurisdiction == null ? null : _relevantJurisdiction.toBuilder();
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement build() {
			return new DividendSwapTransactionSupplement.DividendSwapTransactionSupplementImpl(this);
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder prune() {
			super.prune();
			if (dividendLeg!=null && !dividendLeg.prune().hasData()) dividendLeg = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (relevantJurisdiction!=null && !relevantJurisdiction.prune().hasData()) relevantJurisdiction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividendLeg()!=null && getDividendLeg().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getRelevantJurisdiction()!=null && getRelevantJurisdiction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder o = (DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getDividendLeg(), o.getDividendLeg(), this::setDividendLeg);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
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
		
			DividendSwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(dividendLeg, _that.getDividendLeg())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendLeg != null ? dividendLeg.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapTransactionSupplementBuilder {" +
				"dividendLeg=" + this.dividendLeg + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction +
			'}' + " " + super.toString();
		}
	}
}
