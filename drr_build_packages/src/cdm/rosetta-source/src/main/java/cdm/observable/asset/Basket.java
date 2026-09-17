package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.meta.BasketMeta;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
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
import com.rosetta.model.lib.annotations.RuneScopedAttributeKey;
import com.rosetta.model.lib.meta.Key;
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
 * Defines a custom basket by referencing an identifier and its constituents.
 * @version 6.23.0
 */
@RosettaDataType(value="Basket", builder=Basket.BasketBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Basket", model="cdm", builder=Basket.BasketBuilderImpl.class, version="6.23.0")
public interface Basket extends AssetBase {

	BasketMeta metaData = new BasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the constituents of the basket
	 */
	List<? extends FieldWithMetaBasketConstituent> getBasketConstituent();

	/*********************** Build Methods  ***********************/
	Basket build();
	
	Basket.BasketBuilder toBuilder();
	
	static Basket.BasketBuilder builder() {
		return new Basket.BasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Basket> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Basket> getType() {
		return Basket.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.class, getBasketConstituent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketBuilder extends Basket, AssetBase.AssetBaseBuilder {
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int index);
		@Override
		List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent();
		@Override
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier, int idx);
		@Override
		Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy, int idx);
		@Override
		Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Basket.BasketBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		Basket.BasketBuilder setExchange(LegalEntity exchange);
		@Override
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange, int idx);
		@Override
		Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent, int idx);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent, int idx);
		Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent);
		Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder.class, getBasketConstituent());
		}
		

		Basket.BasketBuilder prune();
	}

	/*********************** Immutable Implementation of Basket  ***********************/
	class BasketImpl extends AssetBase.AssetBaseImpl implements Basket {
		private final List<? extends FieldWithMetaBasketConstituent> basketConstituent;
		
		protected BasketImpl(Basket.BasketBuilder builder) {
			super(builder);
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaBasketConstituent> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public Basket build() {
			return this;
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			Basket.BasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Basket.BasketBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Basket {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Basket  ***********************/
	class BasketBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements Basket.BasketBuilder {
	
		protected List<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> basketConstituent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@RuneScopedAttributeKey
		public List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int index) {
			if (basketConstituent==null) {
				this.basketConstituent = new ArrayList<>();
			}
			return getIndex(basketConstituent, index, () -> {
						FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder newBasketConstituent = FieldWithMetaBasketConstituent.builder();
						newBasketConstituent.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newBasketConstituent;
					});
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("identifier")
		@Override
		public Basket.BasketBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addIdentifier(AssetIdentifier _identifier, int idx) {
			getIndex(this.identifier, idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Basket.BasketBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addTaxonomy(Taxonomy _taxonomy, int idx) {
			getIndex(this.taxonomy, idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Basket.BasketBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@RosettaAttribute("exchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchange")
		@Override
		public Basket.BasketBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchange")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchange")
		@Override
		public Basket.BasketBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addRelatedExchange(LegalEntity _relatedExchange, int idx) {
			getIndex(this.relatedExchange, idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null) {
				this.relatedExchange = new ArrayList<>();
			} else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@RuneScopedAttributeKey
		@Override
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent _basketConstituent) {
			if (_basketConstituent != null) {
				this.basketConstituent.add(_basketConstituent.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent _basketConstituent, int idx) {
			getIndex(this.basketConstituent, idx, () -> _basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent _basketConstituent) {
			this.getOrCreateBasketConstituent(-1).setValue(_basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent _basketConstituent, int idx) {
			this.getOrCreateBasketConstituent(idx).setValue(_basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (final FieldWithMetaBasketConstituent toAdd : basketConstituents) {
					this.basketConstituent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituent")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("basketConstituent")
		@RuneScopedAttributeKey
		@Override
		public Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents == null) {
				this.basketConstituent = new ArrayList<>();
			} else {
				this.basketConstituent = basketConstituents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (final BasketConstituent toAdd : basketConstituents) {
					this.addBasketConstituentValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			this.basketConstituent.clear();
			if (basketConstituents != null) {
				basketConstituents.forEach(this::addBasketConstituentValue);
			}
			return this;
		}
		
		@Override
		public Basket build() {
			return new Basket.BasketImpl(this);
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder prune() {
			super.prune();
			basketConstituent = basketConstituent.stream().filter(b->b!=null).<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Basket.BasketBuilder o = (Basket.BasketBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::getOrCreateBasketConstituent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketBuilder {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}
}
