package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.TradeLegPriceChangeMeta;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.Reference;
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
 * Provision A structure describing a change to the size of a single leg or stream of a trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a change to the size of a single leg or stream of a trade.
 *
 */
@RosettaDataType(value="TradeLegPriceChange", builder=TradeLegPriceChange.TradeLegPriceChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeLegPriceChange", model="fpml", builder=TradeLegPriceChange.TradeLegPriceChangeBuilderImpl.class, version="2.1.1")
public interface TradeLegPriceChange extends RosettaModelObject {

	TradeLegPriceChangeMeta metaData = new TradeLegPriceChangeMeta();

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
	Reference getPriceReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 */
	List<? extends InstrumentId> getInstrumentId();
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
	BigDecimal getPriceChangeAmount();
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
	BigDecimal getNewPrice();

	/*********************** Build Methods  ***********************/
	TradeLegPriceChange build();
	
	TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder();
	
	static TradeLegPriceChange.TradeLegPriceChangeBuilder builder() {
		return new TradeLegPriceChange.TradeLegPriceChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegPriceChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeLegPriceChange> getType() {
		return TradeLegPriceChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("priceReference"), processor, Reference.class, getPriceReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("priceChangeAmount"), BigDecimal.class, getPriceChangeAmount(), this);
		processor.processBasic(path.newSubPath("newPrice"), BigDecimal.class, getNewPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegPriceChangeBuilder extends TradeLegPriceChange, RosettaModelObjectBuilder {
		Reference.ReferenceBuilder getOrCreatePriceReference();
		@Override
		Reference.ReferenceBuilder getPriceReference();
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index);
		@Override
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceReference(Reference priceReference);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceChangeAmount(BigDecimal priceChangeAmount);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setNewPrice(BigDecimal newPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("priceReference"), processor, Reference.ReferenceBuilder.class, getPriceReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("priceChangeAmount"), BigDecimal.class, getPriceChangeAmount(), this);
			processor.processBasic(path.newSubPath("newPrice"), BigDecimal.class, getNewPrice(), this);
		}
		

		TradeLegPriceChange.TradeLegPriceChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegPriceChange  ***********************/
	class TradeLegPriceChangeImpl implements TradeLegPriceChange {
		private final Reference priceReference;
		private final List<? extends InstrumentId> instrumentId;
		private final BigDecimal priceChangeAmount;
		private final BigDecimal newPrice;
		
		protected TradeLegPriceChangeImpl(TradeLegPriceChange.TradeLegPriceChangeBuilder builder) {
			this.priceReference = ofNullable(builder.getPriceReference()).map(f->f.build()).orElse(null);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.priceChangeAmount = builder.getPriceChangeAmount();
			this.newPrice = builder.getNewPrice();
		}
		
		@Override
		@RosettaAttribute("priceReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceReference")
		public Reference getPriceReference() {
			return priceReference;
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("priceChangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceChangeAmount")
		public BigDecimal getPriceChangeAmount() {
			return priceChangeAmount;
		}
		
		@Override
		@RosettaAttribute("newPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newPrice")
		public BigDecimal getNewPrice() {
			return newPrice;
		}
		
		@Override
		public TradeLegPriceChange build() {
			return this;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder() {
			TradeLegPriceChange.TradeLegPriceChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegPriceChange.TradeLegPriceChangeBuilder builder) {
			ofNullable(getPriceReference()).ifPresent(builder::setPriceReference);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getPriceChangeAmount()).ifPresent(builder::setPriceChangeAmount);
			ofNullable(getNewPrice()).ifPresent(builder::setNewPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegPriceChange _that = getType().cast(o);
		
			if (!Objects.equals(priceReference, _that.getPriceReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(priceChangeAmount, _that.getPriceChangeAmount())) return false;
			if (!Objects.equals(newPrice, _that.getNewPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceReference != null ? priceReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (priceChangeAmount != null ? priceChangeAmount.hashCode() : 0);
			_result = 31 * _result + (newPrice != null ? newPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegPriceChange {" +
				"priceReference=" + this.priceReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"priceChangeAmount=" + this.priceChangeAmount + ", " +
				"newPrice=" + this.newPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegPriceChange  ***********************/
	class TradeLegPriceChangeBuilderImpl implements TradeLegPriceChange.TradeLegPriceChangeBuilder {
	
		protected Reference.ReferenceBuilder priceReference;
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected BigDecimal priceChangeAmount;
		protected BigDecimal newPrice;
		
		@Override
		@RosettaAttribute("priceReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceReference")
		public Reference.ReferenceBuilder getPriceReference() {
			return priceReference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreatePriceReference() {
			Reference.ReferenceBuilder result;
			if (priceReference!=null) {
				result = priceReference;
			}
			else {
				result = priceReference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index) {
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			return getIndex(instrumentId, index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("priceChangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceChangeAmount")
		public BigDecimal getPriceChangeAmount() {
			return priceChangeAmount;
		}
		
		@Override
		@RosettaAttribute("newPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newPrice")
		public BigDecimal getNewPrice() {
			return newPrice;
		}
		
		@RosettaAttribute("priceReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceReference")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceReference(Reference _priceReference) {
			this.priceReference = _priceReference == null ? null : _priceReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("priceChangeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceChangeAmount")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceChangeAmount(BigDecimal _priceChangeAmount) {
			this.priceChangeAmount = _priceChangeAmount == null ? null : _priceChangeAmount;
			return this;
		}
		
		@RosettaAttribute("newPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newPrice")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setNewPrice(BigDecimal _newPrice) {
			this.newPrice = _newPrice == null ? null : _newPrice;
			return this;
		}
		
		@Override
		public TradeLegPriceChange build() {
			return new TradeLegPriceChange.TradeLegPriceChangeImpl(this);
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder prune() {
			if (priceReference!=null && !priceReference.prune().hasData()) priceReference = null;
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceReference()!=null && getPriceReference().hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPriceChangeAmount()!=null) return true;
			if (getNewPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegPriceChange.TradeLegPriceChangeBuilder o = (TradeLegPriceChange.TradeLegPriceChangeBuilder) other;
			
			merger.mergeRosetta(getPriceReference(), o.getPriceReference(), this::setPriceReference);
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			
			merger.mergeBasic(getPriceChangeAmount(), o.getPriceChangeAmount(), this::setPriceChangeAmount);
			merger.mergeBasic(getNewPrice(), o.getNewPrice(), this::setNewPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegPriceChange _that = getType().cast(o);
		
			if (!Objects.equals(priceReference, _that.getPriceReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(priceChangeAmount, _that.getPriceChangeAmount())) return false;
			if (!Objects.equals(newPrice, _that.getNewPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceReference != null ? priceReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (priceChangeAmount != null ? priceChangeAmount.hashCode() : 0);
			_result = 31 * _result + (newPrice != null ? newPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegPriceChangeBuilder {" +
				"priceReference=" + this.priceReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"priceChangeAmount=" + this.priceChangeAmount + ", " +
				"newPrice=" + this.newPrice +
			'}';
		}
	}
}
