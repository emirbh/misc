package fpml.consolidated.com;

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
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.meta.SettlementPeriodsFixedPriceMeta;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
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
 * Provision A type defining the Fixed Price applicable to a range or ranges of Settlement Periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the Fixed Price applicable to a range or ranges of Settlement Periods.
 *
 */
@RosettaDataType(value="SettlementPeriodsFixedPrice", builder=SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriodsFixedPrice", model="fpml", builder=SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl.class, version="2.1.1")
public interface SettlementPeriodsFixedPrice extends CommodityFixedPrice {

	SettlementPeriodsFixedPriceMeta metaData = new SettlementPeriodsFixedPriceMeta();

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
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	SettlementPeriodsFixedPrice build();
	
	SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder();
	
	static SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder() {
		return new SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsFixedPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriodsFixedPrice> getType() {
		return SettlementPeriodsFixedPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("priceCurrency"), processor, Currency.class, getPriceCurrency());
		processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.class, getPriceUnit());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsFixedPriceBuilder extends SettlementPeriodsFixedPrice, CommodityFixedPrice.CommodityFixedPriceBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index);
		@Override
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		@Override
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setId(String id);
		@Override
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPrice(BigDecimal price);
		@Override
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceCurrency(Currency priceCurrency);
		@Override
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceUnit(QuantityUnit priceUnit);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int idx);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("priceCurrency"), processor, Currency.CurrencyBuilder.class, getPriceCurrency());
			processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getPriceUnit());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsFixedPrice  ***********************/
	class SettlementPeriodsFixedPriceImpl extends CommodityFixedPrice.CommodityFixedPriceImpl implements SettlementPeriodsFixedPrice {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected SettlementPeriodsFixedPriceImpl(SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsFixedPrice build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder() {
			SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsFixedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsFixedPrice {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsFixedPrice  ***********************/
	class SettlementPeriodsFixedPriceBuilderImpl extends CommodityFixedPrice.CommodityFixedPriceBuilderImpl implements SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index) {
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			return getIndex(settlementPeriodsReference, index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("price")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceCurrency")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceCurrency(Currency _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceUnit")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceUnit(QuantityUnit _priceUnit) {
			this.priceUnit = _priceUnit == null ? null : _priceUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference) {
			if (_settlementPeriodsReference != null) {
				this.settlementPeriodsReference.add(_settlementPeriodsReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference, int idx) {
			getIndex(this.settlementPeriodsReference, idx, () -> _settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (final SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null) {
				this.settlementPeriodsReference = new ArrayList<>();
			} else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice build() {
			return new SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceImpl(this);
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder prune() {
			super.prune();
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder o = (SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsFixedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsFixedPriceBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
