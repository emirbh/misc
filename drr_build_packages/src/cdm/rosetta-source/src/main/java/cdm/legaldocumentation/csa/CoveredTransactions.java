package cdm.legaldocumentation.csa;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.legaldocumentation.csa.meta.CoveredTransactionsMeta;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of Transactions covered by the legal agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CoveredTransactions", builder=CoveredTransactions.CoveredTransactionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CoveredTransactions", model="cdm", builder=CoveredTransactions.CoveredTransactionsBuilderImpl.class, version="6.23.0")
public interface CoveredTransactions extends RosettaModelObject {

	CoveredTransactionsMeta metaData = new CoveredTransactionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Includes any Transaction specified below that is entered into on or after the specified date.
	 */
	Date getInclusionDate();
	/**
	 * Covered Transactions when expressed using the ISDA taxonomy.
	 */
	List<? extends ProductTaxonomy> getCoveredTransactions();
	/**
	 * Covered Transactions when not expressed using the ISDA taxonomy.
	 */
	List<String> getBespokeCoveredTransactions();
	/**
	 * The party specific additional obligations applicable to the document.
	 */
	List<? extends AdditionalObligations> getAdditionalObligations();
	/**
	 * The bespoke definition of exposure for Covered Transactions as part of the agreement.
	 */
	String getExposure();
	/**
	 * Specification of amendments to the calculation of Exposure in terms of the Transactions covered.
	 */
	List<? extends ExposureScope> getLegacyExposure();

	/*********************** Build Methods  ***********************/
	CoveredTransactions build();
	
	CoveredTransactions.CoveredTransactionsBuilder toBuilder();
	
	static CoveredTransactions.CoveredTransactionsBuilder builder() {
		return new CoveredTransactions.CoveredTransactionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoveredTransactions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoveredTransactions> getType() {
		return CoveredTransactions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("inclusionDate"), Date.class, getInclusionDate(), this);
		processRosetta(path.newSubPath("coveredTransactions"), processor, ProductTaxonomy.class, getCoveredTransactions());
		processor.processBasic(path.newSubPath("bespokeCoveredTransactions"), String.class, getBespokeCoveredTransactions(), this);
		processRosetta(path.newSubPath("additionalObligations"), processor, AdditionalObligations.class, getAdditionalObligations());
		processor.processBasic(path.newSubPath("exposure"), String.class, getExposure(), this);
		processRosetta(path.newSubPath("legacyExposure"), processor, ExposureScope.class, getLegacyExposure());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoveredTransactionsBuilder extends CoveredTransactions, RosettaModelObjectBuilder {
		ProductTaxonomy.ProductTaxonomyBuilder getOrCreateCoveredTransactions(int index);
		@Override
		List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getCoveredTransactions();
		AdditionalObligations.AdditionalObligationsBuilder getOrCreateAdditionalObligations(int index);
		@Override
		List<? extends AdditionalObligations.AdditionalObligationsBuilder> getAdditionalObligations();
		ExposureScope.ExposureScopeBuilder getOrCreateLegacyExposure(int index);
		@Override
		List<? extends ExposureScope.ExposureScopeBuilder> getLegacyExposure();
		CoveredTransactions.CoveredTransactionsBuilder setInclusionDate(Date inclusionDate);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy coveredTransactions, int idx);
		CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder setCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String bespokeCoveredTransactions, int idx);
		CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(List<String> bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder setBespokeCoveredTransactions(List<String> bespokeCoveredTransactions);
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations additionalObligations, int idx);
		CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(List<? extends AdditionalObligations> additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder setAdditionalObligations(List<? extends AdditionalObligations> additionalObligations);
		CoveredTransactions.CoveredTransactionsBuilder setExposure(String exposure);
		CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(ExposureScope legacyExposure);
		CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(ExposureScope legacyExposure, int idx);
		CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(List<? extends ExposureScope> legacyExposure);
		CoveredTransactions.CoveredTransactionsBuilder setLegacyExposure(List<? extends ExposureScope> legacyExposure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("inclusionDate"), Date.class, getInclusionDate(), this);
			processRosetta(path.newSubPath("coveredTransactions"), processor, ProductTaxonomy.ProductTaxonomyBuilder.class, getCoveredTransactions());
			processor.processBasic(path.newSubPath("bespokeCoveredTransactions"), String.class, getBespokeCoveredTransactions(), this);
			processRosetta(path.newSubPath("additionalObligations"), processor, AdditionalObligations.AdditionalObligationsBuilder.class, getAdditionalObligations());
			processor.processBasic(path.newSubPath("exposure"), String.class, getExposure(), this);
			processRosetta(path.newSubPath("legacyExposure"), processor, ExposureScope.ExposureScopeBuilder.class, getLegacyExposure());
		}
		

		CoveredTransactions.CoveredTransactionsBuilder prune();
	}

	/*********************** Immutable Implementation of CoveredTransactions  ***********************/
	class CoveredTransactionsImpl implements CoveredTransactions {
		private final Date inclusionDate;
		private final List<? extends ProductTaxonomy> coveredTransactions;
		private final List<String> bespokeCoveredTransactions;
		private final List<? extends AdditionalObligations> additionalObligations;
		private final String exposure;
		private final List<? extends ExposureScope> legacyExposure;
		
		protected CoveredTransactionsImpl(CoveredTransactions.CoveredTransactionsBuilder builder) {
			this.inclusionDate = builder.getInclusionDate();
			this.coveredTransactions = ofNullable(builder.getCoveredTransactions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.bespokeCoveredTransactions = ofNullable(builder.getBespokeCoveredTransactions()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.additionalObligations = ofNullable(builder.getAdditionalObligations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exposure = builder.getExposure();
			this.legacyExposure = ofNullable(builder.getLegacyExposure()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inclusionDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("inclusionDate")
		public Date getInclusionDate() {
			return inclusionDate;
		}
		
		@Override
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("coveredTransactions")
		public List<? extends ProductTaxonomy> getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		@RosettaAttribute("bespokeCoveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("bespokeCoveredTransactions")
		public List<String> getBespokeCoveredTransactions() {
			return bespokeCoveredTransactions;
		}
		
		@Override
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalObligations")
		public List<? extends AdditionalObligations> getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		@RosettaAttribute("exposure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exposure")
		public String getExposure() {
			return exposure;
		}
		
		@Override
		@RosettaAttribute("legacyExposure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyExposure")
		public List<? extends ExposureScope> getLegacyExposure() {
			return legacyExposure;
		}
		
		@Override
		public CoveredTransactions build() {
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder toBuilder() {
			CoveredTransactions.CoveredTransactionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoveredTransactions.CoveredTransactionsBuilder builder) {
			ofNullable(getInclusionDate()).ifPresent(builder::setInclusionDate);
			ofNullable(getCoveredTransactions()).ifPresent(builder::setCoveredTransactions);
			ofNullable(getBespokeCoveredTransactions()).ifPresent(builder::setBespokeCoveredTransactions);
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
			ofNullable(getExposure()).ifPresent(builder::setExposure);
			ofNullable(getLegacyExposure()).ifPresent(builder::setLegacyExposure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoveredTransactions _that = getType().cast(o);
		
			if (!Objects.equals(inclusionDate, _that.getInclusionDate())) return false;
			if (!ListEquals.listEquals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!ListEquals.listEquals(bespokeCoveredTransactions, _that.getBespokeCoveredTransactions())) return false;
			if (!ListEquals.listEquals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(exposure, _that.getExposure())) return false;
			if (!ListEquals.listEquals(legacyExposure, _that.getLegacyExposure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (inclusionDate != null ? inclusionDate.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (bespokeCoveredTransactions != null ? bespokeCoveredTransactions.hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (exposure != null ? exposure.hashCode() : 0);
			_result = 31 * _result + (legacyExposure != null ? legacyExposure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoveredTransactions {" +
				"inclusionDate=" + this.inclusionDate + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"bespokeCoveredTransactions=" + this.bespokeCoveredTransactions + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"exposure=" + this.exposure + ", " +
				"legacyExposure=" + this.legacyExposure +
			'}';
		}
	}

	/*********************** Builder Implementation of CoveredTransactions  ***********************/
	class CoveredTransactionsBuilderImpl implements CoveredTransactions.CoveredTransactionsBuilder {
	
		protected Date inclusionDate;
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> coveredTransactions = new ArrayList<>();
		protected List<String> bespokeCoveredTransactions = new ArrayList<>();
		protected List<AdditionalObligations.AdditionalObligationsBuilder> additionalObligations = new ArrayList<>();
		protected String exposure;
		protected List<ExposureScope.ExposureScopeBuilder> legacyExposure = new ArrayList<>();
		
		@Override
		@RosettaAttribute("inclusionDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("inclusionDate")
		public Date getInclusionDate() {
			return inclusionDate;
		}
		
		@Override
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("coveredTransactions")
		public List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder getOrCreateCoveredTransactions(int index) {
			if (coveredTransactions==null) {
				this.coveredTransactions = new ArrayList<>();
			}
			return getIndex(coveredTransactions, index, () -> {
						ProductTaxonomy.ProductTaxonomyBuilder newCoveredTransactions = ProductTaxonomy.builder();
						return newCoveredTransactions;
					});
		}
		
		@Override
		@RosettaAttribute("bespokeCoveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("bespokeCoveredTransactions")
		public List<String> getBespokeCoveredTransactions() {
			return bespokeCoveredTransactions;
		}
		
		@Override
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalObligations")
		public List<? extends AdditionalObligations.AdditionalObligationsBuilder> getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder getOrCreateAdditionalObligations(int index) {
			if (additionalObligations==null) {
				this.additionalObligations = new ArrayList<>();
			}
			return getIndex(additionalObligations, index, () -> {
						AdditionalObligations.AdditionalObligationsBuilder newAdditionalObligations = AdditionalObligations.builder();
						return newAdditionalObligations;
					});
		}
		
		@Override
		@RosettaAttribute("exposure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exposure")
		public String getExposure() {
			return exposure;
		}
		
		@Override
		@RosettaAttribute("legacyExposure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyExposure")
		public List<? extends ExposureScope.ExposureScopeBuilder> getLegacyExposure() {
			return legacyExposure;
		}
		
		@Override
		public ExposureScope.ExposureScopeBuilder getOrCreateLegacyExposure(int index) {
			if (legacyExposure==null) {
				this.legacyExposure = new ArrayList<>();
			}
			return getIndex(legacyExposure, index, () -> {
						ExposureScope.ExposureScopeBuilder newLegacyExposure = ExposureScope.builder();
						return newLegacyExposure;
					});
		}
		
		@RosettaAttribute("inclusionDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("inclusionDate")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setInclusionDate(Date _inclusionDate) {
			this.inclusionDate = _inclusionDate == null ? null : _inclusionDate;
			return this;
		}
		
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("coveredTransactions")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy _coveredTransactions) {
			if (_coveredTransactions != null) {
				this.coveredTransactions.add(_coveredTransactions.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(ProductTaxonomy _coveredTransactions, int idx) {
			getIndex(this.coveredTransactions, idx, () -> _coveredTransactions.toBuilder());
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactionss) {
			if (coveredTransactionss != null) {
				for (final ProductTaxonomy toAdd : coveredTransactionss) {
					this.coveredTransactions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("coveredTransactions")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setCoveredTransactions(List<? extends ProductTaxonomy> coveredTransactionss) {
			if (coveredTransactionss == null) {
				this.coveredTransactions = new ArrayList<>();
			} else {
				this.coveredTransactions = coveredTransactionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("bespokeCoveredTransactions")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("bespokeCoveredTransactions")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String _bespokeCoveredTransactions) {
			if (_bespokeCoveredTransactions != null) {
				this.bespokeCoveredTransactions.add(_bespokeCoveredTransactions);
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(String _bespokeCoveredTransactions, int idx) {
			getIndex(this.bespokeCoveredTransactions, idx, () -> _bespokeCoveredTransactions);
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addBespokeCoveredTransactions(List<String> bespokeCoveredTransactionss) {
			if (bespokeCoveredTransactionss != null) {
				for (final String toAdd : bespokeCoveredTransactionss) {
					this.bespokeCoveredTransactions.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("bespokeCoveredTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("bespokeCoveredTransactions")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setBespokeCoveredTransactions(List<String> bespokeCoveredTransactionss) {
			if (bespokeCoveredTransactionss == null) {
				this.bespokeCoveredTransactions = new ArrayList<>();
			} else {
				this.bespokeCoveredTransactions = bespokeCoveredTransactionss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalObligations")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations _additionalObligations) {
			if (_additionalObligations != null) {
				this.additionalObligations.add(_additionalObligations.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(AdditionalObligations _additionalObligations, int idx) {
			getIndex(this.additionalObligations, idx, () -> _additionalObligations.toBuilder());
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addAdditionalObligations(List<? extends AdditionalObligations> additionalObligationss) {
			if (additionalObligationss != null) {
				for (final AdditionalObligations toAdd : additionalObligationss) {
					this.additionalObligations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalObligations")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setAdditionalObligations(List<? extends AdditionalObligations> additionalObligationss) {
			if (additionalObligationss == null) {
				this.additionalObligations = new ArrayList<>();
			} else {
				this.additionalObligations = additionalObligationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exposure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exposure")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setExposure(String _exposure) {
			this.exposure = _exposure == null ? null : _exposure;
			return this;
		}
		
		@RosettaAttribute("legacyExposure")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legacyExposure")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(ExposureScope _legacyExposure) {
			if (_legacyExposure != null) {
				this.legacyExposure.add(_legacyExposure.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(ExposureScope _legacyExposure, int idx) {
			getIndex(this.legacyExposure, idx, () -> _legacyExposure.toBuilder());
			return this;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder addLegacyExposure(List<? extends ExposureScope> legacyExposures) {
			if (legacyExposures != null) {
				for (final ExposureScope toAdd : legacyExposures) {
					this.legacyExposure.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legacyExposure")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legacyExposure")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder setLegacyExposure(List<? extends ExposureScope> legacyExposures) {
			if (legacyExposures == null) {
				this.legacyExposure = new ArrayList<>();
			} else {
				this.legacyExposure = legacyExposures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CoveredTransactions build() {
			return new CoveredTransactions.CoveredTransactionsImpl(this);
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder prune() {
			coveredTransactions = coveredTransactions.stream().filter(b->b!=null).<ProductTaxonomy.ProductTaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalObligations = additionalObligations.stream().filter(b->b!=null).<AdditionalObligations.AdditionalObligationsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			legacyExposure = legacyExposure.stream().filter(b->b!=null).<ExposureScope.ExposureScopeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInclusionDate()!=null) return true;
			if (getCoveredTransactions()!=null && getCoveredTransactions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBespokeCoveredTransactions()!=null && !getBespokeCoveredTransactions().isEmpty()) return true;
			if (getAdditionalObligations()!=null && getAdditionalObligations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExposure()!=null) return true;
			if (getLegacyExposure()!=null && getLegacyExposure().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoveredTransactions.CoveredTransactionsBuilder o = (CoveredTransactions.CoveredTransactionsBuilder) other;
			
			merger.mergeRosetta(getCoveredTransactions(), o.getCoveredTransactions(), this::getOrCreateCoveredTransactions);
			merger.mergeRosetta(getAdditionalObligations(), o.getAdditionalObligations(), this::getOrCreateAdditionalObligations);
			merger.mergeRosetta(getLegacyExposure(), o.getLegacyExposure(), this::getOrCreateLegacyExposure);
			
			merger.mergeBasic(getInclusionDate(), o.getInclusionDate(), this::setInclusionDate);
			merger.mergeBasic(getBespokeCoveredTransactions(), o.getBespokeCoveredTransactions(), (Consumer<String>) this::addBespokeCoveredTransactions);
			merger.mergeBasic(getExposure(), o.getExposure(), this::setExposure);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoveredTransactions _that = getType().cast(o);
		
			if (!Objects.equals(inclusionDate, _that.getInclusionDate())) return false;
			if (!ListEquals.listEquals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!ListEquals.listEquals(bespokeCoveredTransactions, _that.getBespokeCoveredTransactions())) return false;
			if (!ListEquals.listEquals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(exposure, _that.getExposure())) return false;
			if (!ListEquals.listEquals(legacyExposure, _that.getLegacyExposure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (inclusionDate != null ? inclusionDate.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (bespokeCoveredTransactions != null ? bespokeCoveredTransactions.hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (exposure != null ? exposure.hashCode() : 0);
			_result = 31 * _result + (legacyExposure != null ? legacyExposure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoveredTransactionsBuilder {" +
				"inclusionDate=" + this.inclusionDate + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"bespokeCoveredTransactions=" + this.bespokeCoveredTransactions + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"exposure=" + this.exposure + ", " +
				"legacyExposure=" + this.legacyExposure +
			'}';
		}
	}
}
