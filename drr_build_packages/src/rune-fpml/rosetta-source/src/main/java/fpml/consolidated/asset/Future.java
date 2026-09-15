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
import fpml.consolidated.asset.meta.FutureMeta;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * Provision An exchange traded future contract.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An exchange traded future contract.
 *
 */
@RosettaDataType(value="Future", builder=Future.FutureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Future", model="fpml", builder=Future.FutureBuilderImpl.class, version="2.1.1")
public interface Future extends ExchangeTraded {

	FutureMeta metaData = new FutureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The multiplier is the minimum number of the underlying - index or stock - that a participant has to trade while taking a position in the Future contract. The purpose of the multiplier is to inflate the value of the contract to add leverage to the trade. The multiplier for the Dow is 10, for the Nasdaq it is 100 and it is 250 for the Standard and Poor's index.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The multiplier is the minimum number of the underlying - index or stock - that a participant has to trade while taking a position in the Future contract. The purpose of the multiplier is to inflate the value of the contract to add leverage to the trade. The multiplier for the Dow is 10, for the Nasdaq it is 100 and it is 250 for the Standard and Poor's index.
	 *
	 */
	BigDecimal getMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Native identifier for the contract on the listing exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Native identifier for the contract on the listing exchange.
	 *
	 */
	String getFutureContractReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the future contract expires.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the future contract expires.
	 *
	 */
	ZonedDateTime getMaturity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The contract month of the futures contract. i.e. F13 WTI NYMEX Contract is 2013-01.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The contract month of the futures contract. i.e. F13 WTI NYMEX Contract is 2013-01.
	 *
	 */
	String getContractYearMonth();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Underlyer of the option e.g. a listed future.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Underlyer of the option e.g. a listed future.
	 *
	 */
	ExchangeTradedContractUnderlyer getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement method for the contract (Cash, Physical). This value is used to populate the "Delivery Type" field for regulatory reporting (CFTC, ESMA).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement method for the contract (Cash, Physical). This value is used to populate the "Delivery Type" field for regulatory reporting (CFTC, ESMA).
	 *
	 */
	SettlementTypeEnum getSettlementType();

	/*********************** Build Methods  ***********************/
	Future build();
	
	Future.FutureBuilder toBuilder();
	
	static Future.FutureBuilder builder() {
		return new Future.FutureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Future> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Future> getType() {
		return Future.class;
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
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("futureContractReference"), String.class, getFutureContractReference(), this);
		processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
		processor.processBasic(path.newSubPath("contractYearMonth"), String.class, getContractYearMonth(), this);
		processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureBuilder extends Future, ExchangeTraded.ExchangeTradedBuilder {
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer();
		@Override
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer();
		@Override
		Future.FutureBuilder setId(String id);
		@Override
		Future.FutureBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Future.FutureBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Future.FutureBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Future.FutureBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Future.FutureBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Future.FutureBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Future.FutureBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Future.FutureBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Future.FutureBuilder setDescription(String description);
		@Override
		Future.FutureBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Future.FutureBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Future.FutureBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Future.FutureBuilder setDefinition(ProductReference definition);
		@Override
		Future.FutureBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		Future.FutureBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		Future.FutureBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Future.FutureBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Future.FutureBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		Future.FutureBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		Future.FutureBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Future.FutureBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Future.FutureBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		Future.FutureBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		Future.FutureBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		Future.FutureBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		Future.FutureBuilder setMultiplier(BigDecimal multiplier);
		Future.FutureBuilder setFutureContractReference(String futureContractReference);
		Future.FutureBuilder setMaturity(ZonedDateTime maturity);
		Future.FutureBuilder setContractYearMonth(String contractYearMonth);
		Future.FutureBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer);
		Future.FutureBuilder setSettlementType(SettlementTypeEnum settlementType);

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
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("futureContractReference"), String.class, getFutureContractReference(), this);
			processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
			processor.processBasic(path.newSubPath("contractYearMonth"), String.class, getContractYearMonth(), this);
			processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		}
		

		Future.FutureBuilder prune();
	}

	/*********************** Immutable Implementation of Future  ***********************/
	class FutureImpl extends ExchangeTraded.ExchangeTradedImpl implements Future {
		private final BigDecimal multiplier;
		private final String futureContractReference;
		private final ZonedDateTime maturity;
		private final String contractYearMonth;
		private final ExchangeTradedContractUnderlyer underlyer;
		private final SettlementTypeEnum settlementType;
		
		protected FutureImpl(Future.FutureBuilder builder) {
			super(builder);
			this.multiplier = builder.getMultiplier();
			this.futureContractReference = builder.getFutureContractReference();
			this.maturity = builder.getMaturity();
			this.contractYearMonth = builder.getContractYearMonth();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("futureContractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureContractReference")
		public String getFutureContractReference() {
			return futureContractReference;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("contractYearMonth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractYearMonth")
		public String getContractYearMonth() {
			return contractYearMonth;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ExchangeTradedContractUnderlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public Future build() {
			return this;
		}
		
		@Override
		public Future.FutureBuilder toBuilder() {
			Future.FutureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Future.FutureBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getFutureContractReference()).ifPresent(builder::setFutureContractReference);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getContractYearMonth()).ifPresent(builder::setContractYearMonth);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Future _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(futureContractReference, _that.getFutureContractReference())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(contractYearMonth, _that.getContractYearMonth())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (futureContractReference != null ? futureContractReference.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (contractYearMonth != null ? contractYearMonth.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Future {" +
				"multiplier=" + this.multiplier + ", " +
				"futureContractReference=" + this.futureContractReference + ", " +
				"maturity=" + this.maturity + ", " +
				"contractYearMonth=" + this.contractYearMonth + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Future  ***********************/
	class FutureBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl implements Future.FutureBuilder {
	
		protected BigDecimal multiplier;
		protected String futureContractReference;
		protected ZonedDateTime maturity;
		protected String contractYearMonth;
		protected ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("futureContractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureContractReference")
		public String getFutureContractReference() {
			return futureContractReference;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("contractYearMonth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractYearMonth")
		public String getContractYearMonth() {
			return contractYearMonth;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = ExchangeTradedContractUnderlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Future.FutureBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Future.FutureBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Future.FutureBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Future.FutureBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Future.FutureBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Future.FutureBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Future.FutureBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Future.FutureBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Future.FutureBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Future.FutureBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Future.FutureBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Future.FutureBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public Future.FutureBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Future.FutureBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public Future.FutureBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public Future.FutureBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Future.FutureBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public Future.FutureBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public Future.FutureBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Future.FutureBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public Future.FutureBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public Future.FutureBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("futureContractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("futureContractReference")
		@Override
		public Future.FutureBuilder setFutureContractReference(String _futureContractReference) {
			this.futureContractReference = _futureContractReference == null ? null : _futureContractReference;
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public Future.FutureBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@RosettaAttribute("contractYearMonth")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractYearMonth")
		@Override
		public Future.FutureBuilder setContractYearMonth(String _contractYearMonth) {
			this.contractYearMonth = _contractYearMonth == null ? null : _contractYearMonth;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public Future.FutureBuilder setUnderlyer(ExchangeTradedContractUnderlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public Future.FutureBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@Override
		public Future build() {
			return new Future.FutureImpl(this);
		}
		
		@Override
		public Future.FutureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Future.FutureBuilder prune() {
			super.prune();
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null) return true;
			if (getFutureContractReference()!=null) return true;
			if (getMaturity()!=null) return true;
			if (getContractYearMonth()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Future.FutureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Future.FutureBuilder o = (Future.FutureBuilder) other;
			
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeBasic(getFutureContractReference(), o.getFutureContractReference(), this::setFutureContractReference);
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getContractYearMonth(), o.getContractYearMonth(), this::setContractYearMonth);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Future _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(futureContractReference, _that.getFutureContractReference())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(contractYearMonth, _that.getContractYearMonth())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (futureContractReference != null ? futureContractReference.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (contractYearMonth != null ? contractYearMonth.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"futureContractReference=" + this.futureContractReference + ", " +
				"maturity=" + this.maturity + ", " +
				"contractYearMonth=" + this.contractYearMonth + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}
}
