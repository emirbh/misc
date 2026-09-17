package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.IndexMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
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
 * Provision A published index whose price depends on exchange traded constituents.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A published index whose price depends on exchange traded constituents.
 *
 */
@RosettaDataType(value="Index", builder=Index.IndexBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Index", model="fpml", builder=Index.IndexBuilderImpl.class, version="2.1.1")
public interface Index extends ExchangeTradedCalculatedPrice {

	IndexMeta metaData = new IndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for the reference future contract in the case of an index underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for the reference future contract in the case of an index underlyer.
	 *
	 */
	FutureId getFutureId();

	/*********************** Build Methods  ***********************/
	Index build();
	
	Index.IndexBuilder toBuilder();
	
	static Index.IndexBuilder builder() {
		return new Index.IndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Index> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Index> getType() {
		return Index.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.class, getRelatedExchangeId());
		processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.class, getOptionsExchangeId());
		processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.class, getSpecifiedExchangeId());
		processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.class, getConstituentExchangeId());
		processRosetta(path.newSubPath("futureId"), processor, FutureId.class, getFutureId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexBuilder extends Index, ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
		FutureId.FutureIdBuilder getOrCreateFutureId();
		@Override
		FutureId.FutureIdBuilder getFutureId();
		@Override
		Index.IndexBuilder setId(String id);
		@Override
		Index.IndexBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Index.IndexBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Index.IndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Index.IndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Index.IndexBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Index.IndexBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Index.IndexBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Index.IndexBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Index.IndexBuilder setDescription(String description);
		@Override
		Index.IndexBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Index.IndexBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Index.IndexBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Index.IndexBuilder setDefinition(ProductReference definition);
		@Override
		Index.IndexBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		Index.IndexBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		Index.IndexBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Index.IndexBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Index.IndexBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		Index.IndexBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		Index.IndexBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Index.IndexBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Index.IndexBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		Index.IndexBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		Index.IndexBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		Index.IndexBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId);
		@Override
		Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int idx);
		@Override
		Index.IndexBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);
		@Override
		Index.IndexBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);
		Index.IndexBuilder setFutureId(FutureId futureId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getRelatedExchangeId());
			processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getOptionsExchangeId());
			processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getSpecifiedExchangeId());
			processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getConstituentExchangeId());
			processRosetta(path.newSubPath("futureId"), processor, FutureId.FutureIdBuilder.class, getFutureId());
		}
		

		Index.IndexBuilder prune();
	}

	/*********************** Immutable Implementation of Index  ***********************/
	class IndexImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl implements Index {
		private final FutureId futureId;
		
		protected IndexImpl(Index.IndexBuilder builder) {
			super(builder);
			this.futureId = ofNullable(builder.getFutureId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("futureId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureId")
		public FutureId getFutureId() {
			return futureId;
		}
		
		@Override
		public Index build() {
			return this;
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			Index.IndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Index.IndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFutureId()).ifPresent(builder::setFutureId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(futureId, _that.getFutureId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (futureId != null ? futureId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Index {" +
				"futureId=" + this.futureId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Index  ***********************/
	class IndexBuilderImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl implements Index.IndexBuilder {
	
		protected FutureId.FutureIdBuilder futureId;
		
		@Override
		@RosettaAttribute("futureId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureId")
		public FutureId.FutureIdBuilder getFutureId() {
			return futureId;
		}
		
		@Override
		public FutureId.FutureIdBuilder getOrCreateFutureId() {
			FutureId.FutureIdBuilder result;
			if (futureId!=null) {
				result = futureId;
			}
			else {
				result = futureId = FutureId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Index.IndexBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Index.IndexBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Index.IndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Index.IndexBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Index.IndexBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Index.IndexBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Index.IndexBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Index.IndexBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Index.IndexBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Index.IndexBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public Index.IndexBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds != null) {
				for (final ExchangeId toAdd : relatedExchangeIds) {
					this.relatedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public Index.IndexBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds == null) {
				this.relatedExchangeId = new ArrayList<>();
			} else {
				this.relatedExchangeId = relatedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public Index.IndexBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds != null) {
				for (final ExchangeId toAdd : optionsExchangeIds) {
					this.optionsExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public Index.IndexBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds == null) {
				this.optionsExchangeId = new ArrayList<>();
			} else {
				this.optionsExchangeId = optionsExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public Index.IndexBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds != null) {
				for (final ExchangeId toAdd : specifiedExchangeIds) {
					this.specifiedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public Index.IndexBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		@Override
		public Index.IndexBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId) {
			if (_constituentExchangeId != null) {
				this.constituentExchangeId.add(_constituentExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId, int idx) {
			getIndex(this.constituentExchangeId, idx, () -> _constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds != null) {
				for (final ExchangeId toAdd : constituentExchangeIds) {
					this.constituentExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		@Override
		public Index.IndexBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds == null) {
				this.constituentExchangeId = new ArrayList<>();
			} else {
				this.constituentExchangeId = constituentExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("futureId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("futureId")
		@Override
		public Index.IndexBuilder setFutureId(FutureId _futureId) {
			this.futureId = _futureId == null ? null : _futureId.toBuilder();
			return this;
		}
		
		@Override
		public Index build() {
			return new Index.IndexImpl(this);
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder prune() {
			super.prune();
			if (futureId!=null && !futureId.prune().hasData()) futureId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFutureId()!=null && getFutureId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Index.IndexBuilder o = (Index.IndexBuilder) other;
			
			merger.mergeRosetta(getFutureId(), o.getFutureId(), this::setFutureId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(futureId, _that.getFutureId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (futureId != null ? futureId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBuilder {" +
				"futureId=" + this.futureId +
			'}' + " " + super.toString();
		}
	}
}
