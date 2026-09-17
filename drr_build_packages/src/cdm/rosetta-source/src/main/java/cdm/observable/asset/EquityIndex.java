package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.meta.EquityIndexMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Specification of an index based on equity securities, e.g. the S&amp;P 500..
 * @version 6.23.0
 */
@RosettaDataType(value="EquityIndex", builder=EquityIndex.EquityIndexBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EquityIndex", model="cdm", builder=EquityIndex.EquityIndexBuilderImpl.class, version="6.23.0")
public interface EquityIndex extends IndexBase {

	EquityIndexMeta metaData = new EquityIndexMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	EquityIndex build();
	
	EquityIndex.EquityIndexBuilder toBuilder();
	
	static EquityIndex.EquityIndexBuilder builder() {
		return new EquityIndex.EquityIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityIndex> getType() {
		return EquityIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("provider"), processor, LegalEntity.class, getProvider());
		processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityIndexBuilder extends EquityIndex, IndexBase.IndexBaseBuilder {
		@Override
		EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier identifier, int idx);
		@Override
		EquityIndex.EquityIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		EquityIndex.EquityIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy taxonomy, int idx);
		@Override
		EquityIndex.EquityIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		EquityIndex.EquityIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		EquityIndex.EquityIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		EquityIndex.EquityIndexBuilder setExchange(LegalEntity exchange);
		@Override
		EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int idx);
		@Override
		EquityIndex.EquityIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		EquityIndex.EquityIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		EquityIndex.EquityIndexBuilder setName(FieldWithMetaString name);
		@Override
		EquityIndex.EquityIndexBuilder setNameValue(String name);
		@Override
		EquityIndex.EquityIndexBuilder setProvider(LegalEntity provider);
		@Override
		EquityIndex.EquityIndexBuilder setAssetClass(AssetClassEnum assetClass);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("provider"), processor, LegalEntity.LegalEntityBuilder.class, getProvider());
			processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
		}
		

		EquityIndex.EquityIndexBuilder prune();
	}

	/*********************** Immutable Implementation of EquityIndex  ***********************/
	class EquityIndexImpl extends IndexBase.IndexBaseImpl implements EquityIndex {
		
		protected EquityIndexImpl(EquityIndex.EquityIndexBuilder builder) {
			super(builder);
		}
		
		@Override
		public EquityIndex build() {
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder toBuilder() {
			EquityIndex.EquityIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityIndex.EquityIndexBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityIndex {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityIndex  ***********************/
	class EquityIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements EquityIndex.EquityIndexBuilder {
	
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("identifier")
		@Override
		public EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addIdentifier(AssetIdentifier _identifier, int idx) {
			getIndex(this.identifier, idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("identifier")
		@Override
		public EquityIndex.EquityIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("taxonomy")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("taxonomy")
		@Override
		public EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addTaxonomy(Taxonomy _taxonomy, int idx) {
			getIndex(this.taxonomy, idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("taxonomy")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("taxonomy")
		@Override
		public EquityIndex.EquityIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null) {
				this.taxonomy = new ArrayList<>();
			} else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isExchangeListed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isExchangeListed")
		@Override
		public EquityIndex.EquityIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@RosettaAttribute("exchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchange")
		@Override
		public EquityIndex.EquityIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchange")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchange")
		@Override
		public EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int idx) {
			getIndex(this.relatedExchange, idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedExchange")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedExchange")
		@Override
		public EquityIndex.EquityIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null) {
				this.relatedExchange = new ArrayList<>();
			} else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public EquityIndex.EquityIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@RosettaAttribute("provider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("provider")
		@Override
		public EquityIndex.EquityIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public EquityIndex.EquityIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		public EquityIndex build() {
			return new EquityIndex.EquityIndexImpl(this);
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityIndex.EquityIndexBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityIndex.EquityIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityIndex.EquityIndexBuilder o = (EquityIndex.EquityIndexBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityIndexBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
