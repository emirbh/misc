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
import fpml.consolidated.asset.meta.FxRateAssetMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import fpml.consolidated.shared.QuotedCurrencyPair;
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
@RosettaDataType(value="FxRateAsset", builder=FxRateAsset.FxRateAssetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxRateAsset", model="fpml", builder=FxRateAsset.FxRateAssetBuilderImpl.class, version="2.1.1")
public interface FxRateAsset extends UnderlyingAsset {

	FxRateAssetMeta metaData = new FxRateAssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the source of the FX rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the source of the FX rate.
	 *
	 */
	FxSpotRateSource getRateSource();

	/*********************** Build Methods  ***********************/
	FxRateAsset build();
	
	FxRateAsset.FxRateAssetBuilder toBuilder();
	
	static FxRateAsset.FxRateAssetBuilder builder() {
		return new FxRateAsset.FxRateAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxRateAsset> getType() {
		return FxRateAsset.class;
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
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("rateSource"), processor, FxSpotRateSource.class, getRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateAssetBuilder extends FxRateAsset, UnderlyingAsset.UnderlyingAssetBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateRateSource();
		@Override
		FxSpotRateSource.FxSpotRateSourceBuilder getRateSource();
		@Override
		FxRateAsset.FxRateAssetBuilder setId(String id);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FxRateAsset.FxRateAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		FxRateAsset.FxRateAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		FxRateAsset.FxRateAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		FxRateAsset.FxRateAssetBuilder setDescription(String description);
		@Override
		FxRateAsset.FxRateAssetBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		FxRateAsset.FxRateAssetBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		FxRateAsset.FxRateAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		FxRateAsset.FxRateAssetBuilder setDefinition(ProductReference definition);
		FxRateAsset.FxRateAssetBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxRateAsset.FxRateAssetBuilder setRateSource(FxSpotRateSource rateSource);

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
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("rateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getRateSource());
		}
		

		FxRateAsset.FxRateAssetBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateAsset  ***********************/
	class FxRateAssetImpl extends UnderlyingAsset.UnderlyingAssetImpl implements FxRateAsset {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final FxSpotRateSource rateSource;
		
		protected FxRateAssetImpl(FxRateAsset.FxRateAssetBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public FxSpotRateSource getRateSource() {
			return rateSource;
		}
		
		@Override
		public FxRateAsset build() {
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder toBuilder() {
			FxRateAsset.FxRateAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateAsset.FxRateAssetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateAsset _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateAsset {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rateSource=" + this.rateSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRateAsset  ***********************/
	class FxRateAssetBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements FxRateAsset.FxRateAssetBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected FxSpotRateSource.FxSpotRateSourceBuilder rateSource;
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxRateAsset.FxRateAssetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FxRateAsset.FxRateAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FxRateAsset.FxRateAssetBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public FxRateAsset.FxRateAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public FxRateAsset.FxRateAssetBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public FxRateAsset.FxRateAssetBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public FxRateAsset.FxRateAssetBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public FxRateAsset.FxRateAssetBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public FxRateAsset.FxRateAssetBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxRateAsset.FxRateAssetBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSource")
		@Override
		public FxRateAsset.FxRateAssetBuilder setRateSource(FxSpotRateSource _rateSource) {
			this.rateSource = _rateSource == null ? null : _rateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxRateAsset build() {
			return new FxRateAsset.FxRateAssetImpl(this);
		}
		
		@Override
		public FxRateAsset.FxRateAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateAsset.FxRateAssetBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRateSource()!=null && getRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateAsset.FxRateAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxRateAsset.FxRateAssetBuilder o = (FxRateAsset.FxRateAssetBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateAsset _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateAssetBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rateSource=" + this.rateSource +
			'}' + " " + super.toString();
		}
	}
}
