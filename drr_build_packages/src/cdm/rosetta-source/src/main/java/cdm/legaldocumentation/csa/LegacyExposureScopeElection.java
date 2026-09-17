package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.LegacyExposureScopeElectionMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of amendments to the calculation of Exposure in terms of the Transactions and Products covered.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyExposureScopeElection", builder=LegacyExposureScopeElection.LegacyExposureScopeElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyExposureScopeElection", model="cdm", builder=LegacyExposureScopeElection.LegacyExposureScopeElectionBuilderImpl.class, version="6.23.0")
public interface LegacyExposureScopeElection extends RosettaModelObject {

	LegacyExposureScopeElectionMeta metaData = new LegacyExposureScopeElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * A boolean flag to represent whether any transactions are excluded (ie True) or not (ie False).
	 */
	Boolean getExcludedTransactions();
	/**
	 * Description of the relevant derivative transactions excluded from the calculation of exposure.
	 */
	List<? extends ExcludedProducts> getExcludedProducts();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyExposureScopeElection build();
	
	LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder toBuilder();
	
	static LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder builder() {
		return new LegacyExposureScopeElection.LegacyExposureScopeElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyExposureScopeElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyExposureScopeElection> getType() {
		return LegacyExposureScopeElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("excludedTransactions"), Boolean.class, getExcludedTransactions(), this);
		processRosetta(path.newSubPath("excludedProducts"), processor, ExcludedProducts.class, getExcludedProducts());
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyExposureScopeElectionBuilder extends LegacyExposureScopeElection, RosettaModelObjectBuilder {
		ExcludedProducts.ExcludedProductsBuilder getOrCreateExcludedProducts(int index);
		@Override
		List<? extends ExcludedProducts.ExcludedProductsBuilder> getExcludedProducts();
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setParty(CounterpartyRoleEnum party);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setExcludedTransactions(Boolean excludedTransactions);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(ExcludedProducts excludedProducts);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(ExcludedProducts excludedProducts, int idx);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(List<? extends ExcludedProducts> excludedProducts);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setExcludedProducts(List<? extends ExcludedProducts> excludedProducts);
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("excludedTransactions"), Boolean.class, getExcludedTransactions(), this);
			processRosetta(path.newSubPath("excludedProducts"), processor, ExcludedProducts.ExcludedProductsBuilder.class, getExcludedProducts());
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyExposureScopeElection  ***********************/
	class LegacyExposureScopeElectionImpl implements LegacyExposureScopeElection {
		private final CounterpartyRoleEnum party;
		private final Boolean excludedTransactions;
		private final List<? extends ExcludedProducts> excludedProducts;
		private final String additionalLanguage;
		
		protected LegacyExposureScopeElectionImpl(LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder builder) {
			this.party = builder.getParty();
			this.excludedTransactions = builder.getExcludedTransactions();
			this.excludedProducts = ofNullable(builder.getExcludedProducts()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("excludedTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("excludedTransactions")
		public Boolean getExcludedTransactions() {
			return excludedTransactions;
		}
		
		@Override
		@RosettaAttribute("excludedProducts")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("excludedProducts")
		public List<? extends ExcludedProducts> getExcludedProducts() {
			return excludedProducts;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyExposureScopeElection build() {
			return this;
		}
		
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder toBuilder() {
			LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getExcludedTransactions()).ifPresent(builder::setExcludedTransactions);
			ofNullable(getExcludedProducts()).ifPresent(builder::setExcludedProducts);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyExposureScopeElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(excludedTransactions, _that.getExcludedTransactions())) return false;
			if (!ListEquals.listEquals(excludedProducts, _that.getExcludedProducts())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (excludedTransactions != null ? excludedTransactions.hashCode() : 0);
			_result = 31 * _result + (excludedProducts != null ? excludedProducts.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyExposureScopeElection {" +
				"party=" + this.party + ", " +
				"excludedTransactions=" + this.excludedTransactions + ", " +
				"excludedProducts=" + this.excludedProducts + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyExposureScopeElection  ***********************/
	class LegacyExposureScopeElectionBuilderImpl implements LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean excludedTransactions;
		protected List<ExcludedProducts.ExcludedProductsBuilder> excludedProducts = new ArrayList<>();
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("excludedTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("excludedTransactions")
		public Boolean getExcludedTransactions() {
			return excludedTransactions;
		}
		
		@Override
		@RosettaAttribute("excludedProducts")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("excludedProducts")
		public List<? extends ExcludedProducts.ExcludedProductsBuilder> getExcludedProducts() {
			return excludedProducts;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder getOrCreateExcludedProducts(int index) {
			if (excludedProducts==null) {
				this.excludedProducts = new ArrayList<>();
			}
			return getIndex(excludedProducts, index, () -> {
						ExcludedProducts.ExcludedProductsBuilder newExcludedProducts = ExcludedProducts.builder();
						return newExcludedProducts;
					});
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("excludedTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("excludedTransactions")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setExcludedTransactions(Boolean _excludedTransactions) {
			this.excludedTransactions = _excludedTransactions == null ? null : _excludedTransactions;
			return this;
		}
		
		@RosettaAttribute("excludedProducts")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("excludedProducts")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(ExcludedProducts _excludedProducts) {
			if (_excludedProducts != null) {
				this.excludedProducts.add(_excludedProducts.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(ExcludedProducts _excludedProducts, int idx) {
			getIndex(this.excludedProducts, idx, () -> _excludedProducts.toBuilder());
			return this;
		}
		
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder addExcludedProducts(List<? extends ExcludedProducts> excludedProductss) {
			if (excludedProductss != null) {
				for (final ExcludedProducts toAdd : excludedProductss) {
					this.excludedProducts.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("excludedProducts")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("excludedProducts")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setExcludedProducts(List<? extends ExcludedProducts> excludedProductss) {
			if (excludedProductss == null) {
				this.excludedProducts = new ArrayList<>();
			} else {
				this.excludedProducts = excludedProductss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyExposureScopeElection build() {
			return new LegacyExposureScopeElection.LegacyExposureScopeElectionImpl(this);
		}
		
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder prune() {
			excludedProducts = excludedProducts.stream().filter(b->b!=null).<ExcludedProducts.ExcludedProductsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getExcludedTransactions()!=null) return true;
			if (getExcludedProducts()!=null && getExcludedProducts().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder o = (LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder) other;
			
			merger.mergeRosetta(getExcludedProducts(), o.getExcludedProducts(), this::getOrCreateExcludedProducts);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getExcludedTransactions(), o.getExcludedTransactions(), this::setExcludedTransactions);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyExposureScopeElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(excludedTransactions, _that.getExcludedTransactions())) return false;
			if (!ListEquals.listEquals(excludedProducts, _that.getExcludedProducts())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (excludedTransactions != null ? excludedTransactions.hashCode() : 0);
			_result = 31 * _result + (excludedProducts != null ? excludedProducts.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyExposureScopeElectionBuilder {" +
				"party=" + this.party + ", " +
				"excludedTransactions=" + this.excludedTransactions + ", " +
				"excludedProducts=" + this.excludedProducts + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
