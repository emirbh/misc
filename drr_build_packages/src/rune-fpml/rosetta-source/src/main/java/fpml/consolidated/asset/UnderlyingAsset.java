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
import fpml.consolidated.asset.meta.UnderlyingAssetMeta;
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
 * Provision Abstract base class for all underlying assets.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base class for all underlying assets.
 *
 */
@RosettaDataType(value="UnderlyingAsset", builder=UnderlyingAsset.UnderlyingAssetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnderlyingAsset", model="fpml", builder=UnderlyingAsset.UnderlyingAssetBuilderImpl.class, version="2.1.1")
public interface UnderlyingAsset extends IdentifiedAsset {

	UnderlyingAssetMeta metaData = new UnderlyingAssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Trading currency of the underlyer when transacted as a cash instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trading currency of the underlyer when transacted as a cash instrument.
	 *
	 */
	IdentifiedCurrency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the exchange on which this asset is transacted for the purposes of calculating a contractural payoff. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the exchange on which this asset is transacted for the purposes of calculating a contractural payoff. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	ExchangeId getExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the clearance system associated with the transaction exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the clearance system associated with the transaction exchange.
	 *
	 */
	ClearanceSystem getClearanceSystem();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional reference to a full FpML product that defines the simple product in greater detail. In case of inconsistency between the terms of the simple product and those of the detailed definition, the values in the simple product override those in the detailed definition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional reference to a full FpML product that defines the simple product in greater detail. In case of inconsistency between the terms of the simple product and those of the detailed definition, the values in the simple product override those in the detailed definition.
	 *
	 */
	ProductReference getDefinition();

	/*********************** Build Methods  ***********************/
	UnderlyingAsset build();
	
	UnderlyingAsset.UnderlyingAssetBuilder toBuilder();
	
	static UnderlyingAsset.UnderlyingAssetBuilder builder() {
		return new UnderlyingAsset.UnderlyingAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnderlyingAsset> getType() {
		return UnderlyingAsset.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetBuilder extends UnderlyingAsset, IdentifiedAsset.IdentifiedAssetBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		@Override
		ExchangeId.ExchangeIdBuilder getExchangeId();
		ClearanceSystem.ClearanceSystemBuilder getOrCreateClearanceSystem();
		@Override
		ClearanceSystem.ClearanceSystemBuilder getClearanceSystem();
		ProductReference.ProductReferenceBuilder getOrCreateDefinition();
		@Override
		ProductReference.ProductReferenceBuilder getDefinition();
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder setId(String id);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		UnderlyingAsset.UnderlyingAssetBuilder setDescription(String description);
		UnderlyingAsset.UnderlyingAssetBuilder setCurrency(IdentifiedCurrency currency);
		UnderlyingAsset.UnderlyingAssetBuilder setExchangeId(ExchangeId exchangeId);
		UnderlyingAsset.UnderlyingAssetBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		UnderlyingAsset.UnderlyingAssetBuilder setDefinition(ProductReference definition);

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
		}
		

		UnderlyingAsset.UnderlyingAssetBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAsset  ***********************/
	class UnderlyingAssetImpl extends IdentifiedAsset.IdentifiedAssetImpl implements UnderlyingAsset {
		private final IdentifiedCurrency currency;
		private final ExchangeId exchangeId;
		private final ClearanceSystem clearanceSystem;
		private final ProductReference definition;
		
		protected UnderlyingAssetImpl(UnderlyingAsset.UnderlyingAssetBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.clearanceSystem = ofNullable(builder.getClearanceSystem()).map(f->f.build()).orElse(null);
			this.definition = ofNullable(builder.getDefinition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearanceSystem")
		public ClearanceSystem getClearanceSystem() {
			return clearanceSystem;
		}
		
		@Override
		@RosettaAttribute("definition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definition")
		public ProductReference getDefinition() {
			return definition;
		}
		
		@Override
		public UnderlyingAsset build() {
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder toBuilder() {
			UnderlyingAsset.UnderlyingAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAsset.UnderlyingAssetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getClearanceSystem()).ifPresent(builder::setClearanceSystem);
			ofNullable(getDefinition()).ifPresent(builder::setDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyingAsset _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(clearanceSystem, _that.getClearanceSystem())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (clearanceSystem != null ? clearanceSystem.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAsset {" +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"clearanceSystem=" + this.clearanceSystem + ", " +
				"definition=" + this.definition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyingAsset  ***********************/
	class UnderlyingAssetBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl implements UnderlyingAsset.UnderlyingAssetBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
		protected ClearanceSystem.ClearanceSystemBuilder clearanceSystem;
		protected ProductReference.ProductReferenceBuilder definition;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearanceSystem")
		public ClearanceSystem.ClearanceSystemBuilder getClearanceSystem() {
			return clearanceSystem;
		}
		
		@Override
		public ClearanceSystem.ClearanceSystemBuilder getOrCreateClearanceSystem() {
			ClearanceSystem.ClearanceSystemBuilder result;
			if (clearanceSystem!=null) {
				result = clearanceSystem;
			}
			else {
				result = clearanceSystem = ClearanceSystem.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("definition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definition")
		public ProductReference.ProductReferenceBuilder getDefinition() {
			return definition;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreateDefinition() {
			ProductReference.ProductReferenceBuilder result;
			if (definition!=null) {
				result = definition;
			}
			else {
				result = definition = ProductReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public UnderlyingAsset.UnderlyingAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public UnderlyingAsset.UnderlyingAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public UnderlyingAsset.UnderlyingAssetBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@Override
		public UnderlyingAsset build() {
			return new UnderlyingAsset.UnderlyingAssetImpl(this);
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			if (clearanceSystem!=null && !clearanceSystem.prune().hasData()) clearanceSystem = null;
			if (definition!=null && !definition.prune().hasData()) definition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			if (getClearanceSystem()!=null && getClearanceSystem().hasData()) return true;
			if (getDefinition()!=null && getDefinition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			UnderlyingAsset.UnderlyingAssetBuilder o = (UnderlyingAsset.UnderlyingAssetBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getClearanceSystem(), o.getClearanceSystem(), this::setClearanceSystem);
			merger.mergeRosetta(getDefinition(), o.getDefinition(), this::setDefinition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyingAsset _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(clearanceSystem, _that.getClearanceSystem())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (clearanceSystem != null ? clearanceSystem.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetBuilder {" +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"clearanceSystem=" + this.clearanceSystem + ", " +
				"definition=" + this.definition +
			'}' + " " + super.toString();
		}
	}
}
