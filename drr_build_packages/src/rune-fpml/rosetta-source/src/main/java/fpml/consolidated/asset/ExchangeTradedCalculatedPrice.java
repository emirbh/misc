package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.ExchangeTradedCalculatedPriceMeta;
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
 * Provision Abstract base class for all exchange traded financial products with a price which is calculated from exchange traded constituents.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base class for all exchange traded financial products with a price which is calculated from exchange traded constituents.
 *
 */
@RosettaDataType(value="ExchangeTradedCalculatedPrice", builder=ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTradedCalculatedPrice", model="fpml", builder=ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl.class, version="2.1.1")
public interface ExchangeTradedCalculatedPrice extends ExchangeTraded {

	ExchangeTradedCalculatedPriceMeta metaData = new ExchangeTradedCalculatedPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of all the exchanges where constituents are traded. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of all the exchanges where constituents are traded. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	List<? extends ExchangeId> getConstituentExchangeId();

	/*********************** Build Methods  ***********************/
	ExchangeTradedCalculatedPrice build();
	
	ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder();
	
	static ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder() {
		return new ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedCalculatedPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTradedCalculatedPrice> getType() {
		return ExchangeTradedCalculatedPrice.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedCalculatedPriceBuilder extends ExchangeTradedCalculatedPrice, ExchangeTraded.ExchangeTradedBuilder {
		ExchangeId.ExchangeIdBuilder getOrCreateConstituentExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getConstituentExchangeId();
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setId(String id);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDescription(String description);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDefinition(ProductReference definition);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int idx);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);

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
		}
		

		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedCalculatedPrice  ***********************/
	class ExchangeTradedCalculatedPriceImpl extends ExchangeTraded.ExchangeTradedImpl implements ExchangeTradedCalculatedPrice {
		private final List<? extends ExchangeId> constituentExchangeId;
		
		protected ExchangeTradedCalculatedPriceImpl(ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder) {
			super(builder);
			this.constituentExchangeId = ofNullable(builder.getConstituentExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		public List<? extends ExchangeId> getConstituentExchangeId() {
			return constituentExchangeId;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice build() {
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder() {
			ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConstituentExchangeId()).ifPresent(builder::setConstituentExchangeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedCalculatedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(constituentExchangeId, _that.getConstituentExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentExchangeId != null ? constituentExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedCalculatedPrice {" +
				"constituentExchangeId=" + this.constituentExchangeId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedCalculatedPrice  ***********************/
	class ExchangeTradedCalculatedPriceBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl implements ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
	
		protected List<ExchangeId.ExchangeIdBuilder> constituentExchangeId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getConstituentExchangeId() {
			return constituentExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateConstituentExchangeId(int index) {
			if (constituentExchangeId==null) {
				this.constituentExchangeId = new ArrayList<>();
			}
			return getIndex(constituentExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newConstituentExchangeId = ExchangeId.builder();
						return newConstituentExchangeId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId) {
			if (_constituentExchangeId != null) {
				this.constituentExchangeId.add(_constituentExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId, int idx) {
			getIndex(this.constituentExchangeId, idx, () -> _constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds == null) {
				this.constituentExchangeId = new ArrayList<>();
			} else {
				this.constituentExchangeId = constituentExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice build() {
			return new ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl(this);
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder prune() {
			super.prune();
			constituentExchangeId = constituentExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConstituentExchangeId()!=null && getConstituentExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder o = (ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder) other;
			
			merger.mergeRosetta(getConstituentExchangeId(), o.getConstituentExchangeId(), this::getOrCreateConstituentExchangeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedCalculatedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(constituentExchangeId, _that.getConstituentExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentExchangeId != null ? constituentExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedCalculatedPriceBuilder {" +
				"constituentExchangeId=" + this.constituentExchangeId +
			'}' + " " + super.toString();
		}
	}
}
