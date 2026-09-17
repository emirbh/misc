package fpml.consolidated.valuation.fpmlreporting;

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
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.valuation.fpmlreporting.meta.ReportContentsMeta;
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
 * Provision A type used to describe the scope/contents of a report.
 *
 */
@RosettaDataType(value="ReportContents", builder=ReportContents.ReportContentsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportContents", model="fpml", builder=ReportContents.ReportContentsBuilderImpl.class, version="2.1.1")
public interface ReportContents extends RosettaModelObject {

	ReportContentsMeta metaData = new ReportContentsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party for which this report was generated.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The account for which this report was generated.
	 *
	 */
	AccountReference getAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 */
	List<? extends TradeCategory> getCategory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of the most important risk class of the trade. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	AssetClass getPrimaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of additional risk classes of the trade, if any. FpML defines a simple asset class categorization using a coding scheme.
	 *
	 */
	List<? extends AssetClass> getSecondaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of the type of product. FpML defines a simple product categorization using a coding scheme.
	 *
	 */
	List<? extends ProductType> getProductType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The desired query portfolio.
	 *
	 */
	QueryPortfolio getQueryPortfolio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The regulatory reporting regime for which this report contains information
	 *
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	ReportContents build();
	
	ReportContents.ReportContentsBuilder toBuilder();
	
	static ReportContents.ReportContentsBuilder builder() {
		return new ReportContents.ReportContentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportContents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportContents> getType() {
		return ReportContents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("category"), processor, TradeCategory.class, getCategory());
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("queryPortfolio"), processor, QueryPortfolio.class, getQueryPortfolio());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportContentsBuilder extends ReportContents, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index);
		@Override
		List<? extends TradeCategory.TradeCategoryBuilder> getCategory();
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		@Override
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int index);
		@Override
		List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass();
		ProductType.ProductTypeBuilder getOrCreateProductType(int index);
		@Override
		List<? extends ProductType.ProductTypeBuilder> getProductType();
		QueryPortfolio.QueryPortfolioBuilder getOrCreateQueryPortfolio();
		@Override
		QueryPortfolio.QueryPortfolioBuilder getQueryPortfolio();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index);
		@Override
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		ReportContents.ReportContentsBuilder setPartyReference(PartyReference partyReference);
		ReportContents.ReportContentsBuilder setAccountReference(AccountReference accountReference);
		ReportContents.ReportContentsBuilder addCategory(TradeCategory category);
		ReportContents.ReportContentsBuilder addCategory(TradeCategory category, int idx);
		ReportContents.ReportContentsBuilder addCategory(List<? extends TradeCategory> category);
		ReportContents.ReportContentsBuilder setCategory(List<? extends TradeCategory> category);
		ReportContents.ReportContentsBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		ReportContents.ReportContentsBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		ReportContents.ReportContentsBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		ReportContents.ReportContentsBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		ReportContents.ReportContentsBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		ReportContents.ReportContentsBuilder addProductType(ProductType productType);
		ReportContents.ReportContentsBuilder addProductType(ProductType productType, int idx);
		ReportContents.ReportContentsBuilder addProductType(List<? extends ProductType> productType);
		ReportContents.ReportContentsBuilder setProductType(List<? extends ProductType> productType);
		ReportContents.ReportContentsBuilder setQueryPortfolio(QueryPortfolio queryPortfolio);
		ReportContents.ReportContentsBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime);
		ReportContents.ReportContentsBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int idx);
		ReportContents.ReportContentsBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);
		ReportContents.ReportContentsBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("category"), processor, TradeCategory.TradeCategoryBuilder.class, getCategory());
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("queryPortfolio"), processor, QueryPortfolio.QueryPortfolioBuilder.class, getQueryPortfolio());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		ReportContents.ReportContentsBuilder prune();
	}

	/*********************** Immutable Implementation of ReportContents  ***********************/
	class ReportContentsImpl implements ReportContents {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final List<? extends TradeCategory> category;
		private final AssetClass primaryAssetClass;
		private final List<? extends AssetClass> secondaryAssetClass;
		private final List<? extends ProductType> productType;
		private final QueryPortfolio queryPortfolio;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected ReportContentsImpl(ReportContents.ReportContentsBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.secondaryAssetClass = ofNullable(builder.getSecondaryAssetClass()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.queryPortfolio = ofNullable(builder.getQueryPortfolio()).map(f->f.build()).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory> getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		public List<? extends AssetClass> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productType")
		public List<? extends ProductType> getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("queryPortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryPortfolio")
		public QueryPortfolio getQueryPortfolio() {
			return queryPortfolio;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportContents build() {
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder toBuilder() {
			ReportContents.ReportContentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportContents.ReportContentsBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getSecondaryAssetClass()).ifPresent(builder::setSecondaryAssetClass);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getQueryPortfolio()).ifPresent(builder::setQueryPortfolio);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportContents _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!Objects.equals(queryPortfolio, _that.getQueryPortfolio())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (queryPortfolio != null ? queryPortfolio.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportContents {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"category=" + this.category + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"queryPortfolio=" + this.queryPortfolio + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportContents  ***********************/
	class ReportContentsBuilderImpl implements ReportContents.ReportContentsBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected List<TradeCategory.TradeCategoryBuilder> category = new ArrayList<>();
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<AssetClass.AssetClassBuilder> secondaryAssetClass = new ArrayList<>();
		protected List<ProductType.ProductTypeBuilder> productType = new ArrayList<>();
		protected QueryPortfolio.QueryPortfolioBuilder queryPortfolio;
		protected List<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> reportingRegime = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory.TradeCategoryBuilder> getCategory() {
			return category;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index) {
			if (category==null) {
				this.category = new ArrayList<>();
			}
			return getIndex(category, index, () -> {
						TradeCategory.TradeCategoryBuilder newCategory = TradeCategory.builder();
						return newCategory;
					});
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass.AssetClassBuilder getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass() {
			AssetClass.AssetClassBuilder result;
			if (primaryAssetClass!=null) {
				result = primaryAssetClass;
			}
			else {
				result = primaryAssetClass = AssetClass.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		public List<? extends AssetClass.AssetClassBuilder> getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreateSecondaryAssetClass(int index) {
			if (secondaryAssetClass==null) {
				this.secondaryAssetClass = new ArrayList<>();
			}
			return getIndex(secondaryAssetClass, index, () -> {
						AssetClass.AssetClassBuilder newSecondaryAssetClass = AssetClass.builder();
						return newSecondaryAssetClass;
					});
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productType")
		public List<? extends ProductType.ProductTypeBuilder> getProductType() {
			return productType;
		}
		
		@Override
		public ProductType.ProductTypeBuilder getOrCreateProductType(int index) {
			if (productType==null) {
				this.productType = new ArrayList<>();
			}
			return getIndex(productType, index, () -> {
						ProductType.ProductTypeBuilder newProductType = ProductType.builder();
						return newProductType;
					});
		}
		
		@Override
		@RosettaAttribute("queryPortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryPortfolio")
		public QueryPortfolio.QueryPortfolioBuilder getQueryPortfolio() {
			return queryPortfolio;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder getOrCreateQueryPortfolio() {
			QueryPortfolio.QueryPortfolioBuilder result;
			if (queryPortfolio!=null) {
				result = queryPortfolio;
			}
			else {
				result = queryPortfolio = QueryPortfolio.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index) {
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			return getIndex(reportingRegime, index, () -> {
						ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder newReportingRegime = ReportingRegimeIdentifier.builder();
						return newReportingRegime;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public ReportContents.ReportContentsBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public ReportContents.ReportContentsBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("category")
		@Override
		public ReportContents.ReportContentsBuilder addCategory(TradeCategory _category) {
			if (_category != null) {
				this.category.add(_category.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addCategory(TradeCategory _category, int idx) {
			getIndex(this.category, idx, () -> _category.toBuilder());
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addCategory(List<? extends TradeCategory> categorys) {
			if (categorys != null) {
				for (final TradeCategory toAdd : categorys) {
					this.category.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("category")
		@Override
		public ReportContents.ReportContentsBuilder setCategory(List<? extends TradeCategory> categorys) {
			if (categorys == null) {
				this.category = new ArrayList<>();
			} else {
				this.category = categorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public ReportContents.ReportContentsBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public ReportContents.ReportContentsBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReportContents.ReportContentsBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public ReportContents.ReportContentsBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public ReportContents.ReportContentsBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("queryPortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("queryPortfolio")
		@Override
		public ReportContents.ReportContentsBuilder setQueryPortfolio(QueryPortfolio _queryPortfolio) {
			this.queryPortfolio = _queryPortfolio == null ? null : _queryPortfolio.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public ReportContents.ReportContentsBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime) {
			if (_reportingRegime != null) {
				this.reportingRegime.add(_reportingRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime, int idx) {
			getIndex(this.reportingRegime, idx, () -> _reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes != null) {
				for (final ReportingRegimeIdentifier toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public ReportContents.ReportContentsBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes == null) {
				this.reportingRegime = new ArrayList<>();
			} else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportContents build() {
			return new ReportContents.ReportContentsImpl(this);
		}
		
		@Override
		public ReportContents.ReportContentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportContents.ReportContentsBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			category = category.stream().filter(b->b!=null).<TradeCategory.TradeCategoryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			secondaryAssetClass = secondaryAssetClass.stream().filter(b->b!=null).<AssetClass.AssetClassBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productType = productType.stream().filter(b->b!=null).<ProductType.ProductTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (queryPortfolio!=null && !queryPortfolio.prune().hasData()) queryPortfolio = null;
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getCategory()!=null && getCategory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getSecondaryAssetClass()!=null && getSecondaryAssetClass().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQueryPortfolio()!=null && getQueryPortfolio().hasData()) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportContents.ReportContentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportContents.ReportContentsBuilder o = (ReportContents.ReportContentsBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::getOrCreateCategory);
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getSecondaryAssetClass(), o.getSecondaryAssetClass(), this::getOrCreateSecondaryAssetClass);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::getOrCreateProductType);
			merger.mergeRosetta(getQueryPortfolio(), o.getQueryPortfolio(), this::setQueryPortfolio);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportContents _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!ListEquals.listEquals(productType, _that.getProductType())) return false;
			if (!Objects.equals(queryPortfolio, _that.getQueryPortfolio())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (queryPortfolio != null ? queryPortfolio.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportContentsBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"category=" + this.category + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"productType=" + this.productType + ", " +
				"queryPortfolio=" + this.queryPortfolio + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
