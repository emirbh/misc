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
import fpml.consolidated.asset.meta.ExchangeTradedMeta;
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
 * Provision An abstract base class for all exchange traded financial products.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base class for all exchange traded financial products.
 *
 */
@RosettaDataType(value="ExchangeTraded", builder=ExchangeTraded.ExchangeTradedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTraded", model="fpml", builder=ExchangeTraded.ExchangeTradedBuilderImpl.class, version="2.1.1")
public interface ExchangeTraded extends UnderlyingAsset {

	ExchangeTradedMeta metaData = new ExchangeTradedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for a related exchange. If the element is not present then the exchange shall be the primary exchange on which listed futures and options on the underlying are listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for a related exchange. If the element is not present then the exchange shall be the primary exchange on which listed futures and options on the underlying are listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	List<? extends ExchangeId> getRelatedExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for an exchange on which the reference option contract is listed. This is to address the case where the reference exchange for the future is different than the one for the option. The options Exchange is referenced on share options when Merger Elections are selected as Options Exchange Adjustment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for an exchange on which the reference option contract is listed. This is to address the case where the reference exchange for the future is different than the one for the option. The options Exchange is referenced on share options when Merger Elections are selected as Options Exchange Adjustment.
	 *
	 */
	List<? extends ExchangeId> getOptionsExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for a specified exchange. If the element is not present then the exchange shall be default terms as defined in the MCA; unless otherwise specified in the Transaction Supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for a specified exchange. If the element is not present then the exchange shall be default terms as defined in the MCA; unless otherwise specified in the Transaction Supplement.
	 *
	 */
	List<? extends ExchangeId> getSpecifiedExchangeId();

	/*********************** Build Methods  ***********************/
	ExchangeTraded build();
	
	ExchangeTraded.ExchangeTradedBuilder toBuilder();
	
	static ExchangeTraded.ExchangeTradedBuilder builder() {
		return new ExchangeTraded.ExchangeTradedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTraded> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTraded> getType() {
		return ExchangeTraded.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedBuilder extends ExchangeTraded, UnderlyingAsset.UnderlyingAssetBuilder {
		ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId();
		@Override
		ExchangeTraded.ExchangeTradedBuilder setId(String id);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ExchangeTraded.ExchangeTradedBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setDescription(String description);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ExchangeTraded.ExchangeTradedBuilder setDefinition(ProductReference definition);
		ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		ExchangeTraded.ExchangeTradedBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		ExchangeTraded.ExchangeTradedBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		ExchangeTraded.ExchangeTradedBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);

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
		}
		

		ExchangeTraded.ExchangeTradedBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTraded  ***********************/
	class ExchangeTradedImpl extends UnderlyingAsset.UnderlyingAssetImpl implements ExchangeTraded {
		private final List<? extends ExchangeId> relatedExchangeId;
		private final List<? extends ExchangeId> optionsExchangeId;
		private final List<? extends ExchangeId> specifiedExchangeId;
		
		protected ExchangeTradedImpl(ExchangeTraded.ExchangeTradedBuilder builder) {
			super(builder);
			this.relatedExchangeId = ofNullable(builder.getRelatedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionsExchangeId = ofNullable(builder.getOptionsExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specifiedExchangeId = ofNullable(builder.getSpecifiedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		public List<? extends ExchangeId> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		public List<? extends ExchangeId> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		public List<? extends ExchangeId> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		@Override
		public ExchangeTraded build() {
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder toBuilder() {
			ExchangeTraded.ExchangeTradedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTraded.ExchangeTradedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelatedExchangeId()).ifPresent(builder::setRelatedExchangeId);
			ofNullable(getOptionsExchangeId()).ifPresent(builder::setOptionsExchangeId);
			ofNullable(getSpecifiedExchangeId()).ifPresent(builder::setSpecifiedExchangeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTraded _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTraded {" +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTraded  ***********************/
	class ExchangeTradedBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements ExchangeTraded.ExchangeTradedBuilder {
	
		protected List<ExchangeId.ExchangeIdBuilder> relatedExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> optionsExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> specifiedExchangeId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int index) {
			if (relatedExchangeId==null) {
				this.relatedExchangeId = new ArrayList<>();
			}
			return getIndex(relatedExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newRelatedExchangeId = ExchangeId.builder();
						return newRelatedExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int index) {
			if (optionsExchangeId==null) {
				this.optionsExchangeId = new ArrayList<>();
			}
			return getIndex(optionsExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newOptionsExchangeId = ExchangeId.builder();
						return newOptionsExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int index) {
			if (specifiedExchangeId==null) {
				this.specifiedExchangeId = new ArrayList<>();
			}
			return getIndex(specifiedExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newSpecifiedExchangeId = ExchangeId.builder();
						return newSpecifiedExchangeId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTraded.ExchangeTradedBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTraded.ExchangeTradedBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExchangeTraded build() {
			return new ExchangeTraded.ExchangeTradedImpl(this);
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder prune() {
			super.prune();
			relatedExchangeId = relatedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			optionsExchangeId = optionsExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			specifiedExchangeId = specifiedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelatedExchangeId()!=null && getRelatedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionsExchangeId()!=null && getOptionsExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecifiedExchangeId()!=null && getSpecifiedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExchangeTraded.ExchangeTradedBuilder o = (ExchangeTraded.ExchangeTradedBuilder) other;
			
			merger.mergeRosetta(getRelatedExchangeId(), o.getRelatedExchangeId(), this::getOrCreateRelatedExchangeId);
			merger.mergeRosetta(getOptionsExchangeId(), o.getOptionsExchangeId(), this::getOrCreateOptionsExchangeId);
			merger.mergeRosetta(getSpecifiedExchangeId(), o.getSpecifiedExchangeId(), this::getOrCreateSpecifiedExchangeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTraded _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedBuilder {" +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}' + " " + super.toString();
		}
	}
}
